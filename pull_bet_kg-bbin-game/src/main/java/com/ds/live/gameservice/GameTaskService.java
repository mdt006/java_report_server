package com.ds.live.gameservice;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ds.live.entity.BBINGameHttpConfig;
import com.ds.live.mapper.BBINGamePageRecordMapper;
import com.ds.live.until.BBINCommon;
import com.ds.live.until.ThreadUtil;
import com.kg.live.entity.ApiInfoEntity;

@Resource
public class GameTaskService implements Runnable {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private GameDBService bbService;
	@Autowired
	private BBINGamePageRecordMapper pageRecordMapper;

	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

	@PostConstruct
	public void start() {
		logger.info("程序开始");
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			// 获取权重请求列表
			List<ApiInfoEntity> agentHttpList = bbService.getConfigApiInfo();
			List<BBINGameHttpConfig> gameHttpConfigList = bbService.getGameHttpConfig();
			CountDownLatch cdl = new CountDownLatch(agentHttpList.size());
			long startTime = System.currentTimeMillis();
			try {
				for (ApiInfoEntity configApiInfo : agentHttpList) {
					logger.info("注单拉取开始  siteId=" + configApiInfo.getSiteId());
					fixedThreadPool.execute(new GameRequestService(pageRecordMapper, bbService, cdl, configApiInfo,
							gameHttpConfigList));
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("执行拉取任务异常:" + e);
				ThreadUtil.sleep(60 * 1000L);
				logger.info("系统异常，休眠一分钟");
				continue;
			}
			try {
				cdl.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long endTime = System.currentTimeMillis();
			logger.info("拉取一次循环耗时time:{}", (endTime - startTime));
			ThreadUtil.sleep(BBINCommon.ONCE_TIME_THREAD_SLEEP);
		}
	}

}

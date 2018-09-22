package com.ds.live.service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ds.live.until.LiveConfig;
import com.ds.live.until.ThreadUtil;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.mapper.ApiInfoEntityMapper;
import com.kg.live.mapper.M8SportEntityMapper;

/**
 * H8注单拉取任务
 * 
 * @author worf
 * @date 2018年4月18日 下午3:45:33
 */
@Resource
public class H8TaskService implements Runnable {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ApiInfoEntityMapper apiInfoMapper;

	@Autowired
	private M8SportEntityMapper m8SportMapper;

	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;

	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

	@PostConstruct
	public void start() {
		logger.info("程序开始");
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			List<ApiInfoEntity> agentHttpList = getDbApiInfoList();
			CountDownLatch cdl = new CountDownLatch(agentHttpList.size());
			long startTime = System.currentTimeMillis();
			try {
				logger.info("h8开始进入各个网站拉取数据.....");
				for (ApiInfoEntity configApiInfo : agentHttpList) {
					fixedThreadPool
							.execute(new H8RequestService(m8SportMapper, tempAuditTotalMapper, configApiInfo, cdl));
				}
			} catch (Exception e) {
				ThreadUtil.sleep(60*1000L);
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
			ThreadUtil.sleep(5000L);
		}

	}

	/**
	 * 获取api配置列表
	 * 
	 * @return
	 */
	private List<ApiInfoEntity> getDbApiInfoList() {
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(LiveConfig.M8_LIVE_ID).andStateEqualTo(LiveConfig.NORMAL_STATE);
		return apiInfoMapper.selectByExample(e);
	}

}

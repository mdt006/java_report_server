package com.ds.chess.service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ds.chess.common.BaseCommon;
import com.ds.chess.util.ThreadUtil;
import com.kg.live.entity.ApiInfoEntity;

/**
 * 开元棋牌注单拉取任务
 * 
 * @author worf
 * @date 2018年4月26日 上午11:56:56
 */
@Resource
public class KyChessTaskService implements Runnable {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private KyChessService kyChessService;
	
	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

	@PostConstruct
	public void start() {
		logger.info("程序开始");
//		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			List<ApiInfoEntity> list = kyChessService.getDbApiInfoList();
			CountDownLatch cdl = new CountDownLatch(list.size());
			long startTime = System.currentTimeMillis();
			try {
				for (ApiInfoEntity apiConfig : list) {
					fixedThreadPool.execute(new KyChessRequestService(kyChessService, cdl, apiConfig));
				}
			} catch (Exception e) {
				ThreadUtil.sleep(BaseCommon.SYSTEM_ERROR_THREAD_SLEEP);
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
			ThreadUtil.sleep(BaseCommon.ONCE_TIME_THREAD_SLEEP);
		}

	}

}

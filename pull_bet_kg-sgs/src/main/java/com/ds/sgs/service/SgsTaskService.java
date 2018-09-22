package com.ds.sgs.service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ds.sgs.common.BaseCommon;
import com.ds.sgs.entity.DsSgsConfig;
import com.ds.sgs.util.ThreadUtil;

/**
 * SGS注单拉取任务
 * 
 * @author worf 
 * @date 2018年6月6日 下午1:53:18
 */
@Resource
public class SgsTaskService implements Runnable {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SgsService sgsService;
	
	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
	
	@PostConstruct
	public void start() {
		logger.info("程序开始");
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			sgsService.getDbApiInfoList();
			sgsService.putApiInfoMap();
			if(sgsService.getApiInfoList() == null || sgsService.getApiInfoList().isEmpty()){
				logger.info("SGS网站配置信息为空,请先配置api_info，程序稍后将重新获取");
				ThreadUtil.sleep(BaseCommon.ONCE_TIME_THREAD_SLEEP);
				continue;
			}
			List<DsSgsConfig> configList = sgsService.getSgsConfigList();
			if(configList == null || configList.isEmpty()){
				logger.info("SGS配置信息为空,请先配置ds_sgs_config，程序稍后将重新获取");
				ThreadUtil.sleep(BaseCommon.ONCE_TIME_THREAD_SLEEP);
				continue;
			}
			CountDownLatch cdl = new CountDownLatch(configList.size());
			long startTime = System.currentTimeMillis();
			try {
				for (DsSgsConfig dsSgsConfig : configList) {
					fixedThreadPool.execute(new SgsRequestService(sgsService, cdl, dsSgsConfig));
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
			logger.info("拉取一次循环耗时time:{} ，线程休眠1分钟...", (endTime - startTime));
			ThreadUtil.sleep(BaseCommon.ONCE_TIME_THREAD_SLEEP);
		}

	}

}

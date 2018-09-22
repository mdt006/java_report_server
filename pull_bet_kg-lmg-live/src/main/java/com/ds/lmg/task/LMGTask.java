package com.ds.lmg.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ds.lmg.constant.LMGContants;
import com.ds.lmg.service.LMGService;
import com.ds.lmg.service.LMGThreadService;
import com.ds.lmg.util.ThreadUtil;
import com.kg.live.entity.ApiInfoEntity;
@Component
public class LMGTask implements Runnable{
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private LMGService lmgServ;
	
	//存放各个网站的site->sequence_no
	private Map<Integer,Long> maxSeqNoMap = new HashMap<Integer,Long>();
	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
	@PostConstruct
	public void start(){
		logger.info("程序开始");
		new Thread(this).start();
	}
	@Override
	public void run() {
		while(true){
			long startTime = System.currentTimeMillis();
			try {
				List<ApiInfoEntity> apiList = lmgServ.getAipInfoList();
				CountDownLatch cdl = new CountDownLatch(apiList.size());
				for (ApiInfoEntity apiInfo : apiList) {
					fixedThreadPool.execute(new LMGThreadService(apiInfo,lmgServ, cdl,maxSeqNoMap));
				}
			}catch(Exception e) {
				logger.error("拉取循环报错", e);
			}
			long endTime = System.currentTimeMillis();
			logger.info("拉取一次循环耗时time:{}",(endTime-startTime));
			ThreadUtil.sleep(LMGContants.ONCE_TIME_THREAD_SLEEP);
		}
	}

}

package com.ds.lottery.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ds.lottery.common.BaseCommon;
import com.ds.lottery.entity.GFLotteryInfoEntity;
import com.ds.lottery.until.ThreadUtil;
import com.ds.lottery.vo.GameTypeVo;

/**
 * 官方彩注单拉取任务
 * 
 * @author worf
 * @date 2018年4月24日 下午4:27:26
 */
@Resource
public class GfLotteryTaskService implements Runnable {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DsLotteryServiceImp lotteryService;

	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

	@PostConstruct
	public void start() {
		logger.info("程序开始");
		BaseCommon.initGameName();
		logger.info("初始化平台名称完成：{},{}",BaseCommon.KIND_NAME_DSPT,BaseCommon.KIND_NAME_GF);
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			List<GFLotteryInfoEntity> lotteryInfoList = lotteryService.getDbLotteryInfoList();
			Map<String, GameTypeVo> gameTypeVoMap = lotteryService.getGameType(12, 56);
			CountDownLatch cdl = new CountDownLatch(lotteryInfoList.size());
			long startTime = System.currentTimeMillis();
			try {
				logger.info("lottery开始进入各个网站拉取数据.....");
				for (GFLotteryInfoEntity lottery : lotteryInfoList) {
					fixedThreadPool.execute(new GfLotteryRequestService(lotteryService, lottery, gameTypeVoMap, cdl));
				}
			} catch (Exception e) {
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
			ThreadUtil.sleep(5000L);
		}

	}

}

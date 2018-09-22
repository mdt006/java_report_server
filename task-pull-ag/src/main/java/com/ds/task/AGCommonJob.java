package com.ds.task;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ds.common.AGApplication;
import com.ds.dao.AGDaoImpl;
@Component
public class AGCommonJob{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AGDaoImpl agDao;
	@Value("${ag.live.gamelist}")
	private String liveGameStr;
	//定时更新apiList接口
	@Scheduled(fixedDelay = 1000*60*5)
	public void exec() {
		log.info("Scheduled apilist");
		AGApplication.list = agDao.getAPIinfoList();
		String [] gameArr = liveGameStr.split(",");
		AGApplication.liveGameList = Arrays.asList(gameArr);
	}

}

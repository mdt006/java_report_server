package com.ds.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ds.common.AGCommon;
import com.ds.service.ftp.AGYoplayFtpService;
import com.ds.task.inter.AbstractJob;
import com.ds.util.DateUtils;
import com.kg.live.entity.AGLiveEntity;
@Component
public class AGYoplayJob  extends AbstractJob<AGLiveEntity>{
	private static final Logger log = LoggerFactory.getLogger(AGCommon.LOG_AG_YOPLAY);
	@Value("${ag.status.yoplay}")
	private boolean status;
	@Autowired
	public void setBaseftpService(AGYoplayFtpService ftpService) {
		super.setFtpService(ftpService, log);
	}
	@Override
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void exec() {
		super.job(status, null,AGCommon.LOG_AG_YOPLAY);
	}

	@Override
	@Scheduled(cron = "0 0/5 * * * ? ")
	public void execLastDay() {
		super.job(status, DateUtils.getGTM4Lastdate(new Date()),AGCommon.LOG_AG_YOPLAY);
	}
}

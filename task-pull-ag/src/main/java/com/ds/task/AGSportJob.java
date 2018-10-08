package com.ds.task;

import java.util.Date;

import com.ds.service.ftp.AGHunterFtpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ds.common.AGCommon;
import com.ds.service.ftp.AGSportFtpService;
import com.ds.task.inter.AbstractJob;
import com.ds.util.DateUtils;
import com.kg.live.entity.DsAgSport;

import javax.annotation.PostConstruct;

@Component
public class AGSportJob  extends AbstractJob<DsAgSport> implements Runnable{
	private static final Logger log = LoggerFactory.getLogger(AGCommon.LOG_AG_SPORT);
	@Value("${ag.status.sport}")
	private boolean status;
	/*@Autowired
	public void setBaseftpService(AGSportFtpService ftpService) {
		super.setFtpService(ftpService, log);
	}

	@Override
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void exec() {
		super.job(status, null,AGCommon.LOG_AG_SPORT);
	}

	@Override
	@Scheduled(cron = "0 0/5 * * * ? ")
	public void execLastDay() {
		super.job(status, DateUtils.getGTM4Lastdate(new Date()),AGCommon.LOG_AG_SPORT);
	}*/

	@Autowired
	public void setBaseftpService(AGSportFtpService ftpService) {
		super.setFtpService(ftpService, log);
	}
	@PostConstruct
	public void start() {
		new Thread(this).start();
	}
	@Override
	public void run() {
		exec();
	}
	@Override
	public void exec() {
		while (true) {
			try {
				Thread.sleep(60 * 1000);
				super.job(status, null);
			} catch (Exception e) {
				log.error("AGJob error", e);
			}
		}
	}

	@Scheduled(cron = "0 0/5 * * * ? ")
	public void execLastDay() {
		super.job(status, DateUtils.getGTM4Lastdate(new Date()));
	}

}

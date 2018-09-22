package com.ds.service.ftp;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ds.common.AGCommon;
import com.ds.service.AGLiveService;
import com.kg.live.entity.AGLiveEntity;
@Service
public class AGLiveFtpService extends BaseFtpService<AGLiveEntity>{
	
	@Value("${ag.ftp.path.live}")
	private String ftpPath;
	@Autowired
	public void setAGService(AGLiveService liveService) {
		setBaseService(liveService,LoggerFactory.getLogger(AGCommon.LOG_AG_LIVE));
	}
	@Override
	public void execpull(String datePath) {
		super.start(ftpPath,datePath);
	}
	  

}

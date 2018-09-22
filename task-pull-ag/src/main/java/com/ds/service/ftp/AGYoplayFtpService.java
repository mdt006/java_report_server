package com.ds.service.ftp;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ds.common.AGCommon;
import com.ds.service.AGYoplayService;
import com.kg.live.entity.AGLiveEntity;
@Service
public class AGYoplayFtpService  extends BaseFtpService<AGLiveEntity>{

	@Value("${ag.ftp.path.yoplay}")
	private String ftpPath;
	@Autowired
	public void setAGService(AGYoplayService service) {
		setBaseService(service,LoggerFactory.getLogger(AGCommon.LOG_AG_YOPLAY));
	}
	@Override
	public void execpull(String datePath) {
		super.start(ftpPath,datePath);
	}

}

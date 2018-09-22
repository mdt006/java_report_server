package com.ds.service.ftp;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ds.common.AGCommon;
import com.ds.service.AGGameService;
import com.kg.live.entity.AGLiveEntity;
@Service
public class AGGameFtpService  extends BaseFtpService<AGLiveEntity>{
	@Value("${ag.ftp.path.game}")
	private String ftpPath;
	@Override
	public void execpull(String datePath) {
		super.start(ftpPath,datePath);
	}
	@Autowired
	public void setAGService(AGGameService service) {
		setBaseService(service,LoggerFactory.getLogger(AGCommon.LOG_AG_GAME));
	}

}

package com.ds.service.ftp;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ds.common.AGCommon;
import com.ds.service.AGSportService;
import com.kg.live.entity.DsAgSport;
@Service
public class AGSportFtpService  extends BaseFtpService<DsAgSport>{
	@Value("${ag.ftp.path.sport}")
	private String ftpPath;
	@Autowired
	public void setAGService(AGSportService service) {
		setBaseService(service,LoggerFactory.getLogger(AGCommon.LOG_AG_SPORT));
	}
	@Override
	public void execpull(String datePath) {
		super.start(ftpPath,datePath);
	}
}

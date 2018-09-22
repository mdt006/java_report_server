package com.ds.service.ftp;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ds.common.AGCommon;
import com.ds.service.AGHunterService;
import com.kg.live.entity.DsAgHunter;
@Service
public class AGHunterFtpService  extends BaseFtpService<DsAgHunter>{
	@Value("${ag.ftp.path.hunter}")
	private String ftpPath;
	@Autowired
	public void setAGService(AGHunterService service) {
		setBaseService(service,LoggerFactory.getLogger(AGCommon.LOG_AG_HUNTER));
	}
	@Override
	public void execpull(String datePath) {
		super.start(ftpPath,datePath);
	}
}

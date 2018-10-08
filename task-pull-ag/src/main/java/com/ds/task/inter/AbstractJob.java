package com.ds.task.inter;


import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import com.ds.common.AGApplication;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import com.ds.service.ftp.BaseFtpService;

public abstract class AbstractJob<M>{
	private Logger log;
	private BaseFtpService<M> ftpServ;
	public abstract void exec();
	public abstract void execLastDay();
	public void setFtpService(BaseFtpService<M> ftpService,Logger log) {
		this.ftpServ = ftpService;
		this.log = log;
	}
	public void job(boolean status,String date) {
		log.info("拉取-----");
		if(!status){
			log.info("拉取未开启");
			return;
		}
		if(AGApplication.list.size() == 0) {
			log.info("初始化未完成");
			return;
		}
		ftpServ.execpull(date);
		log.info("完成一次拉取注单");

	}

	/*private Logger log;
	private BaseFtpService<M> ftpServ;
	public abstract void exec();
	public abstract void execLastDay();
	public void setFtpService(BaseFtpService<M> ftpService,Logger log) {
		this.ftpServ = ftpService;
		this.log = log;
	}
	public void job(boolean status,String date,String lockFile) {
		log.info("拉取-----");
		if(!status){
			log.info("拉取未开启");
			return;
		}
		FileLock fl = null;
		try {
			FileChannel channel = lockToFile(lockFile);
			if(channel == null) {
				return;
			}
			try {
				fl = channel.lock();
				log.info("开始拉取注单:"+lockFile);
			} catch (Exception e1) {
				log.info("上次拉取注单:"+lockFile+"未完成,等待下一次执行");
				return;
			}
			ftpServ.execpull(date);
			log.info("完成一次拉取注单");
		} finally {
			unlockToFile(fl);
		}
		
	}
	@SuppressWarnings("resource")
	private void unlockToFile(FileLock fl) {
		if(fl == null) {
			return;
		}
		try {
			fl.release();
		} catch (Exception e) {
			log.error("解锁出错", e);
		}
	}
	@SuppressWarnings("resource")
	private FileChannel lockToFile(String lockFile) {
		if(StringUtils.isBlank(lockFile)) {
			return null;
		}
		try {
			File file = new File(lockFile);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
			return channel;
		} catch (Exception e) {
			return null;
		}
	}*/
}

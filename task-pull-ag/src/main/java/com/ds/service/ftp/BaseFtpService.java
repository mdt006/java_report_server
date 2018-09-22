package com.ds.service.ftp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.ds.message.MsgManger;
import com.ds.po.AGPullRecordPO;
import com.ds.service.BaseService;
import com.ds.util.DateUtils;
import com.ds.util.ErrorUtil;

public abstract class BaseFtpService<M> {
	private Logger log;
	private final String filelistname="filelist";
	private final String recordlistname="recordfilelist";
	@Value("${ag.ftp.host}")
	private String host;
	@Value("${ag.ftp.port}")
	private int port;
	@Value("${ag.ftp.username}")
	private String username;
	@Value("${ag.ftp.password}")
	private String password;
	@Autowired
	private MsgManger msgManager;
	private BaseService<M> agService;
	public void setBaseService(BaseService<M> agService,Logger log) {
		this.agService = agService;
		this.log = log;
	}
	public abstract void execpull(String datePath);
	/**
	 * 把所有流程逻辑用此方法串联起来
	 * @param ftpPath
	 * @param date
	 */
	public void start(String ftpPath,String date) {
		String datePath = date == null?DateUtils.getGTM4date(new Date()):date;
		FTPClient ftpClient = getFtpClient();//获取连接
		FTPFile[]  fs = getFtpFileList(ftpClient,ftpPath,datePath);//获取全部ftp文件列表
		Map<String,Object> map = getFileList(fs,ftpPath,datePath);
		List<AGPullRecordPO> recordList = (List<AGPullRecordPO>) map.get(recordlistname);
		List<String> fileList = (List<String>) map.get(filelistname);
		for (String filename : fileList) {
			String absPathfile = ftpPath + datePath+"/"+ filename;
			String strXml = readFile(ftpClient, absPathfile);
			boolean xmlReaderResult = agService.xmlReader(absPathfile, strXml);
			if(StringUtils.isBlank(strXml)||!xmlReaderResult) {//如果strXml为空,或者xmlReader出错，则ag_pull_record_log不记录或者更新此次记录
				delRecByFilename(recordList, ftpPath, datePath, filename);
			}
		}

		//更新record
		if(recordList!= null && recordList.size()>0) {
			log.info("开始插入record log:"+recordList.size());
			agService.insertOrupdateRecord(recordList);
		}else {
			log.info("此次拉取没有要更新的文件");
		}
		
	}
	private void delRecByFilename(List<AGPullRecordPO> recordList,String ftpPath,String datePath,String filename) {
		boolean result = recordList.removeIf(file->file.getUniqueKey().equals(ftpPath+datePath+filename));
		log.info("文件:{}移除{}",ftpPath+datePath+filename,result);
	}
	public FTPClient getFtpClient() {
		log.info("开始获取连接");
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.setDefaultTimeout(30 * 1000);
			ftpClient.setConnectTimeout(60 * 1000);
			ftpClient.setDataTimeout(30 * 1000);
			ftpClient.connect(host, port);
			ftpClient.login(username, password);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setControlEncoding("UTF-8");
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			log.info("ftp连接返回:" + ftpClient.getPassiveHost() + ",getStatus():"
					+ ftpClient.getStatus());
		} catch (SocketException e) {
			log.error("SocketException:", e);
			e.printStackTrace();
			msgManager.sendMessage("SocketException", "AG注单拉取出错："+ErrorUtil.LogExceptionStack(e));
			return null;
		} catch (IOException e) {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			log.error("IOException:",e);
			e.printStackTrace();
			msgManager.sendMessage("IOException", "AG注单拉取出错："+ErrorUtil.LogExceptionStack(e));
			return null;
		}
		return ftpClient;
	}
	/**
	 * 
	 * @param ftpClient
	 * @param datePath 日期文件夹 格式20180808
	 * @param ftpPath
	 * @return
	 */
	public FTPFile[] getFtpFileList(FTPClient ftpClient,String ftpPath,String datePath) {
		FTPFile[] fs = null;
		String absPath = ftpPath+datePath;
		try {
			log.info("开始获取{}列表",absPath);
			fs = ftpClient.listFiles(absPath);
			log.info("获取{}列表完成,list:{}",absPath,fs.length);
		} catch (Exception e) {
			log.error("Exception:",e);
			msgManager.sendMessage("getFtpFileList", "AG注单拉取出错："+ErrorUtil.LogExceptionStack(e));
		}
		return fs;
	}
	public Map<String,Object> getFileList(FTPFile[] list,String ftpPath,String date) {
		Map<String,Object> map = new HashMap<String,Object>();
		int count = list.length;
		if(count==0){
			return null;
		}
		List<String> fileList = new ArrayList<String>();
		List<AGPullRecordPO> recordList = new Vector<AGPullRecordPO>();
		//临时连接变量
		String tempcon = ftpPath + date;
		Map<String,AGPullRecordPO> recordMap = agService.getAGPullRecord(ftpPath, date);
		for (FTPFile ftpFile : list) {
			String filename = ftpFile.getName();
			String fileSize = getfileSize(ftpFile.getRawListing().split(" "));
			AGPullRecordPO record = recordMap.get(tempcon+filename);
			if(record == null) {
				fileList.add(filename);
				recordList.add(new AGPullRecordPO(ftpPath, date, filename, ftpFile.getTimestamp().getTime().getTime(),fileSize));
			}else {
				String lastFileSize = record.getFileSize();
				if(!fileSize.equals(lastFileSize)) {
					fileList.add(filename);
					recordList.add(new AGPullRecordPO(ftpPath, date, filename, ftpFile.getTimestamp().getTime().getTime(),fileSize));
				}
			}
			
		}
		map.put(filelistname, fileList);
		map.put(recordlistname, recordList);
		return map;
	}

	public String readFile(FTPClient ftpClient,String absPathfile) {
		StringBuffer resultBuffer = new StringBuffer();
		InputStream in = null;
		log.info("开始读取绝对路径" + absPathfile + "文件!");
		try {
			in = ftpClient.retrieveFileStream(absPathfile);
		} catch (FileNotFoundException e) {
			msgManager.sendMessage("FileNotFoundException", "AG注单拉取出错："+ErrorUtil.LogExceptionStack(e));
			
			log.error("没有找到" + absPathfile + "文件");
			return null;
		} catch (SocketException e) {
			msgManager.sendMessage("SocketException", "AG注单拉取出错："+ErrorUtil.LogExceptionStack(e));
			log.error("连接FTP SocketException:", e);
			return null;
		} catch (IOException e) {
			msgManager.sendMessage("IOException", "AG注单拉取出错："+ErrorUtil.LogExceptionStack(e));
			log.error("文件读取错误IOException：", e);
			return null;
		}
		if (in != null) {// 此方法经常发生异常。。。Read timed out
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String data = null;
			try {
				while ((data = br.readLine()) != null) {
					resultBuffer.append(data + "\n");
				}
				in.close();
				ftpClient.completePendingCommand();
			} catch (IOException e) {
				msgManager.sendMessage("IOException", "AG注单拉取出错："+ErrorUtil.LogExceptionStack(e));
				log.error("文件读取错误。" + e.getMessage());
				e.printStackTrace();
				return null;
			} 
		}
		return resultBuffer.toString();
	}
	private String getfileSize(String[] rawstrArr) {
		if (rawstrArr == null || rawstrArr.length == 0) {
			return null;
		}
		return  rawstrArr[rawstrArr.length-5];
	}
}

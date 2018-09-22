package com.ds.po;

public class AGPullRecordPO {
	private Long id;
	private String agPath;
	private String datePath;
	private String filename;
	private long lastUpdateTime;
	private String fileSize;
	public AGPullRecordPO() {
		super();
	}
	/**
	 * 
	 * @param agPath
	 * @param datePath
	 * @param filename
	 * @param lastUpdateTime
	 * @param fileSize
	 */
	public AGPullRecordPO(String agPath, String datePath, String filename, long lastUpdateTime, String fileSize) {
		super();
		this.agPath = agPath;
		this.datePath = datePath;
		this.filename = filename;
		this.lastUpdateTime = lastUpdateTime;
		this.fileSize = fileSize;
	}



	public String getFileSize() {
		return fileSize;
	}



	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAgPath() {
		return agPath;
	}
	public void setAgPath(String agPath) {
		this.agPath = agPath;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDatePath() {
		return datePath;
	}
	public void setDatePath(String datePath) {
		this.datePath = datePath;
	}
	public long getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(long lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getUniqueKey() {
		return agPath + datePath + filename;
	}
	
}

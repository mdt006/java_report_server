package com.ds.report.vo;

import java.util.List;

public class AuditTotalBatParam {
	private String username;
	private Integer siteId;
	private List<AuditTotalDateVo> timeList;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public List<AuditTotalDateVo> getTimeList() {
		return timeList;
	}
	public void setTimeList(List<AuditTotalDateVo> timeList) {
		this.timeList = timeList;
	}
	
}

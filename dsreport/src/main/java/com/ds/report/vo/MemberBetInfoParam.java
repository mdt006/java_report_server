package com.ds.report.vo;

import java.util.Date;

public class MemberBetInfoParam {
	private Date beginTime;
	private Date endTime;
	private Integer siteId;
	private String username;
	private Integer liveId;
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getLiveId() {
		return liveId;
	}
	public void setLiveId(Integer liveId) {
		this.liveId = liveId;
	}
	
}

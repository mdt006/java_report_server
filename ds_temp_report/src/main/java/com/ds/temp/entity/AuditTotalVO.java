package com.ds.temp.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AuditTotalVO {
	private Long id;
	private Integer liveId;
	private String orderNo;
	private String username;
	private Date betTime;
	private BigDecimal payAmount;
	private BigDecimal betAmount;
	private BigDecimal validAmount;
	private Integer type;
	private String gameName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getLiveId() {
		return liveId;
	}
	public void setLiveId(Integer liveId) {
		this.liveId = liveId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBetTime() {
		return betTime;
	}
	public void setBetTime(Date betTime) {
		this.betTime = betTime;
	}
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	public BigDecimal getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(BigDecimal betAmount) {
		this.betAmount = betAmount;
	}
	public BigDecimal getValidAmount() {
		return validAmount;
	}
	public void setValidAmount(BigDecimal validAmount) {
		this.validAmount = validAmount;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
}

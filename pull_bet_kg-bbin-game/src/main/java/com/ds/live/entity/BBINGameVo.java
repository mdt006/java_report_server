package com.ds.live.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class BBINGameVo {
	private Long id;
	private String userName;
	private String uppername;
	private String wagersId;
	private Date wagersDate;
	private String serialId;
	private String roundNo;
	private Integer gameType;
	private String gameCode;
	private String wagerDetail;
	private String result;
	private String resultType;
	private String card;
	private BigDecimal betAmount;
	private BigDecimal payOff;
	private String currency;
	private String exchangeRate;
	private BigDecimal commissionable;
	private String origin;
	private Date createTime;
	private Date updateTime;
	private Integer winLossType;
	private Integer siteId;
	@JSONField(name = "UserName") 
	public String getUserName() {
		return userName;
	}
	@JSONField(name = "Uppername") 
	public String getUppername() {
		return uppername;
	}
	@JSONField(name = "WagersID") 
	public String getWagersId() {
		return wagersId;
	}
	@JSONField(name = "WagersDate") 
	public Date getWagersDate() {
		return wagersDate;
	}
	@JSONField(name = "SerialID") 
	public String getSerialId() {
		return serialId;
	}
	@JSONField(name = "RoundNo") 
	public String getRoundNo() {
		return roundNo;
	}
	@JSONField(name = "GameType") 
	public Integer getGameType() {
		return gameType;
	}
	@JSONField(name = "GameCode") 
	public String getGameCode() {
		return gameCode;
	}
	@JSONField(name = "Result") 
	public String getResult() {
		return result;
	}
	@JSONField(name = "ResultType") 
	public String getResultType() {
		return resultType;
	}
	@JSONField(name = "Card") 
	public String getCard() {
		return card;
	}
	@JSONField(name = "BetAmount") 
	public BigDecimal getBetAmount() {
		return betAmount;
	}
	@JSONField(name = "Payoff") 
	public BigDecimal getPayOff() {
		return payOff;
	}
	@JSONField(name = "Currency") 
	public String getCurrency() {
		return currency;
	}
	@JSONField(name = "ExchangeRate") 
	public String getExchangeRate() {
		return exchangeRate;
	}
	@JSONField(name = "Commissionable") 
	public BigDecimal getCommissionable() {
		return commissionable;
	}
	@JSONField(name = "WagerDetail") 
	public String getWagerDetail() {
		return wagerDetail;
	}
	
	@JSONField(name = "Origin") 
	public String getOrigin() {
		return origin;
	}
	
	@JSONField(name = "UserName") 
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JSONField(name = "Uppername") 
	public void setUppername(String uppername) {
		this.uppername = uppername;
	}
	@JSONField(name = "WagersID") 
	public void setWagersId(String wagersId) {
		this.wagersId = wagersId;
	}
	@JSONField(name = "WagersDate") 
	public void setWagersDate(Date wagersDate) {
		this.wagersDate = wagersDate;
	}
	@JSONField(name = "SerialID") 
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	@JSONField(name = "RoundNo") 
	public void setRoundNo(String roundNo) {
		this.roundNo = roundNo;
	}
	@JSONField(name = "GameType") 
	public void setGameType(Integer gameType) {
		this.gameType = gameType;
	}
	@JSONField(name = "GameCode") 
	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}
	@JSONField(name = "Result") 
	public void setResult(String result) {
		this.result = result;
	}
	@JSONField(name = "ResultType") 
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	@JSONField(name = "Card") 
	public void setCard(String card) {
		this.card = card;
	}
	@JSONField(name = "BetAmount") 
	public void setBetAmount(BigDecimal betAmount) {
		this.betAmount = betAmount;
	}
	@JSONField(name = "Payoff") 
	public void setPayOff(BigDecimal payOff) {
		this.payOff = payOff;
	}
	@JSONField(name = "Currency") 
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@JSONField(name = "ExchangeRate") 
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	@JSONField(name = "Commissionable") 
	public void setCommissionable(BigDecimal commissionable) {
		this.commissionable = commissionable;
	}
	@JSONField(name = "WagerDetail") 
	public void setWagerDetail(String wagerDetail) {
		this.wagerDetail = wagerDetail;
	}
	@JSONField(name = "Origin") 
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getWinLossType() {
		return winLossType;
	}
	public void setWinLossType(Integer winLossType) {
		this.winLossType = winLossType;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	@Override
	public String toString() {
		return "BBINGameVo [id=" + id + ", userName=" + userName + ", uppername=" + uppername + ", wagersId=" + wagersId
				+ ", wagersDate=" + wagersDate + ", serialId=" + serialId + ", roundNo=" + roundNo + ", gameType="
				+ gameType + ", gameCode=" + gameCode + ", wagerDetail=" + wagerDetail + ", result=" + result
				+ ", resultType=" + resultType + ", card=" + card + ", betAmount=" + betAmount + ", payOff=" + payOff
				+ ", currency=" + currency + ", exchangeRate=" + exchangeRate + ", commissionable=" + commissionable
				+ ", origin=" + origin + ", createTime=" + createTime + ", updateTime=" + updateTime + ", winLossType="
				+ winLossType + ", siteId=" + siteId + "]";
	}
	
	
}

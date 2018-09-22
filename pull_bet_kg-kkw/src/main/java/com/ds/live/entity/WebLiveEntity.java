package com.ds.live.entity;

import java.sql.Timestamp;

/**
 * 对应表 web_live
 */
public class WebLiveEntity {
	private int id;
	private Integer ProductID;//billno
	//private String ProductID;
	private String UserName;
	private String GameRecordID;
	private String OrderNumber;
	private String TableID;
	private String Stage;
	private int Inning;
	private int GameNameID;
	private int ResultType;
	private double BettingAmount;
	private double CompensateRate;
	private double WinLoseAmount;
	private double Balance;
	private Timestamp AddTime;
	/**************************/
	private String Agents;
	private String World;
	private String Corprator;
	private String Super;
	private String Admin;
	/**************************/
	private int GameBettingKind;
	private int PlatformID;
	private String vendorid;  //版本
	private String website;  //bbin 访问的网站名
	private String uppername;//代理名
	private String wagersid; //注单编号
	private String result;	 //bbin 结果
	private String card;	 //牌结果
	private String resultbet;//注单结果
	private String beginId;  ///太阳城 最大 id
	private double validmoney;
	/*****************/
	//by guangguang
	private int siteId;
	
	
	public Integer getProductID() {
		return ProductID;
	}
	public void setProductID(Integer productID) {
		ProductID = productID;
	}
	public double getValidmoney() {
		return validmoney;
	}
	public void setValidmoney(double validmoney) {
		this.validmoney = validmoney;
	}
	public String getBeginId() {
		return beginId;
	}
	public void setBeginId(String beginId) {
		this.beginId = beginId;
	}
	public String getWagersid() {
		return wagersid;
	}
	public void setWagersid(String wagersid) {
		this.wagersid = wagersid;
	}
	public String getResultbet() {
		return resultbet;
	}
	public void setResultbet(String resultbet) {
		this.resultbet = resultbet;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getUppername() {
		return uppername;
	}
	public void setUppername(String uppername) {
		this.uppername = uppername;
	}
	public String getVendorid() {
		return vendorid;
	}
	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}
	public String getSuper() {
		return Super;
	}
	public void setSuper(String super1) {
		Super = super1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getGameRecordID() {
		return GameRecordID;
	}
	public void setGameRecordID(String gameRecordID) {
		GameRecordID = gameRecordID;
	}
	public String getOrderNumber() {
		return OrderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}
	public String getTableID() {
		return TableID;
	}
	public void setTableID(String tableID) {
		TableID = tableID;
	}
	public int getInning() {
		return Inning;
	}
	public void setInning(int inning) {
		Inning = inning;
	}
	public int getGameNameID() {
		return GameNameID;
	}
	public void setGameNameID(int gameNameID) {
		GameNameID = gameNameID;
	}
	public int getResultType() {
		return ResultType;
	}
	public void setResultType(int resultType) {
		ResultType = resultType;
	}
	public double getBettingAmount() {
		return BettingAmount;
	}
	public void setBettingAmount(double bettingAmount) {
		BettingAmount = bettingAmount;
	}
	public double getCompensateRate() {
		return CompensateRate;
	}
	public void setCompensateRate(double compensateRate) {
		CompensateRate = compensateRate;
	}
	public double getWinLoseAmount() {
		return WinLoseAmount;
	}
	public void setWinLoseAmount(double winLoseAmount) {
		WinLoseAmount = winLoseAmount;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public Timestamp getAddTime() {
		return AddTime;
	}
	public void setAddTime(Timestamp addTime) {
		AddTime = addTime;
	}
	public String getAgents() {
		return Agents;
	}
	public void setAgents(String agents) {
		Agents = agents;
	}
	public String getWorld() {
		return World;
	}
	public void setWorld(String world) {
		World = world;
	}
	public String getCorprator() {
		return Corprator;
	}
	public void setCorprator(String corprator) {
		Corprator = corprator;
	}
	public String getAdmin() {
		return Admin;
	}
	public void setAdmin(String admin) {
		Admin = admin;
	}
	public int getGameBettingKind() {
		return GameBettingKind;
	}
	public void setGameBettingKind(int gameBettingKind) {
		GameBettingKind = gameBettingKind;
	}
	public int getPlatformID() {
		return PlatformID;
	}
	public void setPlatformID(int platformID) {
		PlatformID = platformID;
	}
	
	/*public Integer getProductID() {
		return ProductID;
	}
	public void setProductID(Integer productID) {
		ProductID = productID;
	}*/
	public String getStage() {
		return Stage;
	}
	public void setStage(String stage) {
		Stage = stage;
	}
	
	
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	@Override
	public String toString() {
		return "WebLiveEntity [id=" + id + ", productID=" + ProductID
				+ ", UserName=" + UserName + ", GameRecordID=" + GameRecordID
				+ ", OrderNumber=" + OrderNumber + ", TableID=" + TableID
				+ ", Stage=" + Stage + ", Inning=" + Inning + ", GameNameID="
				+ GameNameID + ", ResultType=" + ResultType
				+ ", BettingAmount=" + BettingAmount + ", CompensateRate="
				+ CompensateRate + ", WinLoseAmount=" + WinLoseAmount
				+ ", Balance=" + Balance + ", AddTime=" + AddTime + ", Agents="
				+ Agents + ", World=" + World + ", Corprator=" + Corprator
				+ ", Super=" + Super + ", Admin=" + Admin
				+ ", GameBettingKind=" + GameBettingKind + ", PlatformID="
				+ PlatformID + ", vendorid=" + vendorid + "]";
	}

}

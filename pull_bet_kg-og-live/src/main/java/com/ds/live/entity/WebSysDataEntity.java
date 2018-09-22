package com.ds.live.entity;

import java.io.Serializable;
import java.sql.Timestamp;
//extends BaseEntity implements Serializable
public class WebSysDataEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private int userid;
	private int act_result;
	private double min_sum;
	private int modelID;
	private int checked;
	private char payway;
	private double gold;
	private String userName;
	private String agents;
	private String world;
	private String corprator;
	private String Super;
	private String admin;
	private String curType;
	private Timestamp date;
	private String notes;
	private String ps;
	private String levelName;
	private Integer bankid;
	private String fingerprint;
	
	private Integer siteId;
	
	public final static char PAYWAY = 'D';
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAct_result() {
		return act_result;
	}
	public void setAct_result(int act_result) {
		this.act_result = act_result;
	}
	public double getMin_sum() {
		return min_sum;
	}
	public void setMin_sum(double min_sum) {
		this.min_sum = min_sum;
	}
	public int getModelID() {
		return modelID;
	}
	public void setModelID(int modelID) {
		this.modelID = modelID;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public char getPayway() {
		return payway;
	}
	public void setPayway(char payway) {
		this.payway = payway;
	}
	public double getGold() {
		return gold;
	}
	public void setGold(double gold) {
		this.gold = gold;
	}
	public String getAgents() {
		return agents;
	}
	public void setAgents(String agents) {
		this.agents = agents;
	}
	public String getWorld() {
		return world;
	}
	public void setWorld(String world) {
		this.world = world;
	}
	public String getCorprator() {
		return corprator;
	}
	public void setCorprator(String corprator) {
		this.corprator = corprator;
	}
	public String getSuper() {
		return Super;
	}
	public void setSuper(String super1) {
		Super = super1;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getCurType() {
		return curType;
	}
	public void setCurType(String curType) {
		this.curType = curType;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public Integer getBankid() {
		return bankid;
	}
	public void setBankid(Integer bankid) {
		this.bankid = bankid;
	}
	public String getFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
	
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	@Override
	public String toString() {
		return "WebSysDataEntity [id=" + id + ", userid=" + userid
				+ ", act_result=" + act_result + ", min_sum=" + min_sum
				+ ", modelID=" + modelID + ", checked=" + checked + ", payway="
				+ payway + ", gold=" + gold + ", userName=" + userName
				+ ", agents=" + agents + ", world=" + world + ", corprator="
				+ corprator + ", Super=" + Super + ", admin=" + admin
				+ ", curType=" + curType + ", date=" + date + ", notes="
				+ notes + ", ps=" + ps + ", levelName=" + levelName
				+ ", bankid=" + bankid + ", fingerprint=" + fingerprint + "]";
	}

}

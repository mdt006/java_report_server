package com.ds.temp.entity;

import java.math.BigDecimal;

public class DsAuditTotal {
	private String username;//用户名
	private BigDecimal totalValidamount;
	private BigDecimal liveValidamount;//视讯有效投注金额
	private BigDecimal lottoValidamount;//彩票有效投注金额
	private BigDecimal jilvValidamount;//机率有效投注金额
	private BigDecimal sportValidamount;//体育有效投注金额
	private BigDecimal chessValidamount;//棋牌有效投注金额
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BigDecimal getTotalValidamount() {
		return totalValidamount;
	}
	public void setTotalValidamount(BigDecimal totalValidamount) {
		this.totalValidamount = totalValidamount;
	}
	public BigDecimal getLiveValidamount() {
		return liveValidamount;
	}
	public void setLiveValidamount(BigDecimal liveValidamount) {
		this.liveValidamount = liveValidamount;
	}
	public BigDecimal getLottoValidamount() {
		return lottoValidamount;
	}
	public void setLottoValidamount(BigDecimal lottoValidamount) {
		this.lottoValidamount = lottoValidamount;
	}
	public BigDecimal getJilvValidamount() {
		return jilvValidamount;
	}
	public void setJilvValidamount(BigDecimal jilvValidamount) {
		this.jilvValidamount = jilvValidamount;
	}
	public BigDecimal getSportValidamount() {
		return sportValidamount;
	}
	public void setSportValidamount(BigDecimal sportValidamount) {
		this.sportValidamount = sportValidamount;
	}
	
	/**
	* @Title: total 
	* @Description: TODO(合并统计) 
	* @param @param o1
	* @param @param o2
	* @param @return    设定文件 
	* @return DsAuditTotal    返回类型 
	* @throws
	 */
	public DsAuditTotal total(DsAuditTotal o1,DsAuditTotal o2){
		DsAuditTotal o=new DsAuditTotal();
		if(null!=o1.getJilvValidamount() || null!=o2.getJilvValidamount()){
			o.setJilvValidamount(o1.getJilvValidamount().add(o2.getJilvValidamount()));
		}
		if(null!=o1.getLiveValidamount() || null!=o2.getLiveValidamount()){
			o.setLiveValidamount(o1.getLiveValidamount().add(o2.getLiveValidamount()));
		}
		if(null!=o1.getLottoValidamount() || null!=o2.getLottoValidamount()){
			o.setLottoValidamount(o1.getLottoValidamount().add(o2.getLottoValidamount()));
		}
		if(null!=o1.getSportValidamount() || null!=o2.getSportValidamount()){
			o.setSportValidamount(o1.getSportValidamount().add(o2.getSportValidamount()));
		}
		if(null!=o1.getChessValidamount() || null!=o2.getChessValidamount()){
			o.setChessValidamount(o1.getChessValidamount().add(o2.getChessValidamount()));
		}
		if(null!=o1.getTotalValidamount() || null!=o2.getTotalValidamount()){
			o.setTotalValidamount(o1.getTotalValidamount().add(o2.getTotalValidamount()));
		}
		o.setUsername(o1.getUsername());
		return o;
	}
	public BigDecimal getChessValidamount() {
		return chessValidamount;
	}
	public void setChessValidamount(BigDecimal chessValidamount) {
		this.chessValidamount = chessValidamount;
	}
}

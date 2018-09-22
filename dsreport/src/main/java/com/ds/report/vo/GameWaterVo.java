package com.ds.report.vo;

import java.math.BigDecimal;

public class GameWaterVo {
	private String water;
	private Integer gamekind;
	private String gametypes;
	private BigDecimal validamount;
	private BigDecimal water_money;
	public String getWater() {
		return water;
	}
	public void setWater(String water) {
		this.water = water;
	}
	
	
	public Integer getGamekind() {
		return gamekind;
	}
	public void setGamekind(Integer gamekind) {
		this.gamekind = gamekind;
	}
	public String getGametypes() {
		return gametypes;
	}
	public void setGametypes(String gametypes) {
		this.gametypes = gametypes;
	}
	public BigDecimal getValidamount() {
		return validamount;
	}
	public void setValidamount(BigDecimal validamount) {
		this.validamount = validamount;
	}
	public BigDecimal getWater_money() {
		return water_money;
	}
	public void setWater_money(BigDecimal water_money) {
		this.water_money = water_money;
	}
	
	
}

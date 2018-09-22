package com.ds.lottery.vo;

import java.math.BigDecimal;

public class ValidateVo {
	private Integer addBetCount;//新增投注量
	private BigDecimal addBetamount;//新增投注金额
	private BigDecimal addValidamount;//新增有效投注金额
	private BigDecimal addWinlose;//新增输赢金额
	public Integer getAddBetCount() {
		return addBetCount;
	}
	public void setAddBetCount(Integer addBetCount) {
		this.addBetCount = addBetCount;
	}
	public BigDecimal getAddBetamount() {
		return addBetamount;
	}
	public void setAddBetamount(BigDecimal addBetamount) {
		this.addBetamount = addBetamount;
	}
	public BigDecimal getAddValidamount() {
		return addValidamount;
	}
	public void setAddValidamount(BigDecimal addValidamount) {
		this.addValidamount = addValidamount;
	}
	public BigDecimal getAddWinlose() {
		return addWinlose;
	}
	public void setAddWinlose(BigDecimal addWinlose) {
		this.addWinlose = addWinlose;
	}
	
}

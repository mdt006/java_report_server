package com.ds.live.vo;

import java.math.BigDecimal;

public class ValidateReportVo {
	private Long count;
	private BigDecimal betMount;
	private BigDecimal validateMount;
	private BigDecimal payoffMount;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public BigDecimal getBetMount() {
		return betMount;
	}
	public void setBetMount(BigDecimal betMount) {
		this.betMount = betMount;
	}
	public BigDecimal getValidateMount() {
		return validateMount;
	}
	public void setValidateMount(BigDecimal validateMount) {
		this.validateMount = validateMount;
	}
	public BigDecimal getPayoffMount() {
		return payoffMount;
	}
	public void setPayoffMount(BigDecimal payoffMount) {
		this.payoffMount = payoffMount;
	}
	
	public boolean validate(ValidateReportVo vo){
		if(vo == null || null == vo.getCount()){
			return false;
		}
		Long voCount = vo.getCount();
		if(voCount.intValue() != count.intValue()){
			return false;
		}
		if(vo.getBetMount().compareTo(betMount)!=0){
			return false;
		}
		if(vo.getValidateMount().compareTo(validateMount)!=0){
			return false;
		}
		if(vo.getPayoffMount().compareTo(payoffMount)!=0){
			return false;
		}
		
		return true;
	}
}

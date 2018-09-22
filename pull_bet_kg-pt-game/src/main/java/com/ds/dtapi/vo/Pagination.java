package com.ds.dtapi.vo;

import com.alibaba.fastjson.annotation.JSONField;

public class Pagination {
	private Integer page;
	private Integer pageLimit;
	private Integer potalNumber;
	private Integer totalPage;
	
	@JSONField(name = "Page") 
	public Integer getPage() {
		return page;
	}
	
	@JSONField(name = "PageLimit") 
	public Integer getPageLimit() {
		return pageLimit;
	}
	
	@JSONField(name = "PotalNumber") 
	public Integer getPotalNumber() {
		return potalNumber;
	}
	
	@JSONField(name = "TotalPage") 
	public Integer getTotalPage() {
		return totalPage;
	}
	@JSONField(name = "Page") 
	public void setPage(Integer page) {
		this.page = page;
	}
	@JSONField(name = "PageLimit") 
	public void setPageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}
	@JSONField(name = "PotalNumber") 
	public void setPotalNumber(Integer potalNumber) {
		this.potalNumber = potalNumber;
	}
	@JSONField(name = "TotalPage") 
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "Pagination [page=" + page + ", pageLimit=" + pageLimit + ", potalNumber=" + potalNumber + ", totalPage="
				+ totalPage + "]";
	}
	
	
	
}

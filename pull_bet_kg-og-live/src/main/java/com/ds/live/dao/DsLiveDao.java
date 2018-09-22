package com.ds.live.dao;

import org.apache.ibatis.annotations.Param;

import com.ds.live.entity.WebLiveEntity;
import com.kg.live.entity.DsLiveEntity;

public interface DsLiveDao {

	String getMaxOGLiveBillno();

	WebLiveEntity getDsLiveByBillno(DsLiveEntity liveEntity);
	
	/**
	 * 
	 * @param date
	 * @param siteId
	 * @return date日期前ds-og-live表中siteID相对应的最大Vendorid
	 */
	Long getMaxVendoridByDate(@Param("date")String date,@Param("siteId")Integer siteId);
	
	/**
	 * 
	 * @param date
	 * @param siteId
	 * @return date日期后ds-og-live表中siteID相对应的最小Vendorid
	 */
	Long getMinVendoridByDate(@Param("date")String date,@Param("siteId")Integer siteId);
	
}

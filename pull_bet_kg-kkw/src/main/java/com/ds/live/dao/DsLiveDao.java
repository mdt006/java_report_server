package com.ds.live.dao;

import org.apache.ibatis.annotations.Param;

import com.ds.live.entity.WebLiveEntity;
import com.kg.live.entity.DsLiveEntity;

public interface DsLiveDao {

	String getMaxDsLiveBillno(@Param(value="siteId")Integer siteId);

	WebLiveEntity getDsLiveByBillno(DsLiveEntity liveEntity);
	
	/**
	 * 六合彩 获取最大注单编号
	 */
	String getMaxDsLottoBillno(@Param(value="siteId")Integer siteId);
	
	/**
	 * 彩票 获取最大注单编号
	 */
	String getMaxDsLotteryBillno(@Param(value="siteId")Integer siteId);
	String getMaxDsLottery(@Param(value="siteId")Integer siteId,@Param(value="lotteryGameType")String lotteryGameType);
}

package com.ds.lottery.mapper;

import com.ds.lottery.entity.GFLotteryInfoEntity;
import com.ds.lottery.entity.GFLotteryInfoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GFLotteryInfoEntityMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gf_lottery_info
	 * @mbggenerated  Mon Oct 23 05:25:45 EDT 2017
	 */
	int countByExample(GFLotteryInfoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gf_lottery_info
	 * @mbggenerated  Mon Oct 23 05:25:45 EDT 2017
	 */
	int deleteByExample(GFLotteryInfoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gf_lottery_info
	 * @mbggenerated  Mon Oct 23 05:25:45 EDT 2017
	 */
	int insert(GFLotteryInfoEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gf_lottery_info
	 * @mbggenerated  Mon Oct 23 05:25:45 EDT 2017
	 */
	int insertSelective(GFLotteryInfoEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gf_lottery_info
	 * @mbggenerated  Mon Oct 23 05:25:45 EDT 2017
	 */
	List<GFLotteryInfoEntity> selectByExample(GFLotteryInfoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gf_lottery_info
	 * @mbggenerated  Mon Oct 23 05:25:45 EDT 2017
	 */
	int updateByExampleSelective(@Param("record") GFLotteryInfoEntity record,
			@Param("example") GFLotteryInfoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gf_lottery_info
	 * @mbggenerated  Mon Oct 23 05:25:45 EDT 2017
	 */
	int updateByExample(@Param("record") GFLotteryInfoEntity record,
			@Param("example") GFLotteryInfoEntityExample example);
}
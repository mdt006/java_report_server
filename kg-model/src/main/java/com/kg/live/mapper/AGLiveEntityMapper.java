package com.kg.live.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kg.live.entity.AGLiveEntity;
import com.kg.live.entity.AGLiveEntityExample;

public interface AGLiveEntityMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_ag_live
	 * @mbggenerated  Sat Jun 27 15:44:21 CST 2015
	 */
	int countByExample(AGLiveEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_ag_live
	 * @mbggenerated  Sat Jun 27 15:44:21 CST 2015
	 */
	int deleteByExample(AGLiveEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_ag_live
	 * @mbggenerated  Sat Jun 27 15:44:21 CST 2015
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_ag_live
	 * @mbggenerated  Sat Jun 27 15:44:21 CST 2015
	 */
	int insert(AGLiveEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_ag_live
	 * @mbggenerated  Sat Jun 27 15:44:21 CST 2015
	 */
	int insertSelective(AGLiveEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_ag_live
	 * @mbggenerated  Sat Jun 27 15:44:21 CST 2015
	 */
	List<AGLiveEntity> selectByExample(AGLiveEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_ag_live
	 * @mbggenerated  Sat Jun 27 15:44:21 CST 2015
	 */
	AGLiveEntity selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_ag_live
	 * @mbggenerated  Sat Jun 27 15:44:21 CST 2015
	 */
	int updateByExampleSelective(@Param("record") AGLiveEntity record,
			@Param("example") AGLiveEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_ag_live
	 * @mbggenerated  Sat Jun 27 15:44:21 CST 2015
	 */
	int updateByExample(@Param("record") AGLiveEntity record,
			@Param("example") AGLiveEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_ag_live
	 * @mbggenerated  Sat Jun 27 15:44:21 CST 2015
	 */
	int updateByPrimaryKeySelective(AGLiveEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_ag_live
	 * @mbggenerated  Sat Jun 27 15:44:21 CST 2015
	 */
	int updateByPrimaryKey(AGLiveEntity record);
	
	AGLiveEntity selectFirstByBetTime();
}
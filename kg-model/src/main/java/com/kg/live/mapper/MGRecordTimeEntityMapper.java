package com.kg.live.mapper;

import com.kg.live.entity.MGRecordTimeEntity;
import com.kg.live.entity.MGRecordTimeEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MGRecordTimeEntityMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_mg_record_time
	 * @mbggenerated  Thu Jul 21 09:25:46 CST 2016
	 */
	int countByExample(MGRecordTimeEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_mg_record_time
	 * @mbggenerated  Thu Jul 21 09:25:46 CST 2016
	 */
	int deleteByExample(MGRecordTimeEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_mg_record_time
	 * @mbggenerated  Thu Jul 21 09:25:46 CST 2016
	 */
	int deleteByPrimaryKey(String agent);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_mg_record_time
	 * @mbggenerated  Thu Jul 21 09:25:46 CST 2016
	 */
	int insert(MGRecordTimeEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_mg_record_time
	 * @mbggenerated  Thu Jul 21 09:25:46 CST 2016
	 */
	int insertSelective(MGRecordTimeEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_mg_record_time
	 * @mbggenerated  Thu Jul 21 09:25:46 CST 2016
	 */
	List<MGRecordTimeEntity> selectByExample(MGRecordTimeEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_mg_record_time
	 * @mbggenerated  Thu Jul 21 09:25:46 CST 2016
	 */
	MGRecordTimeEntity selectByPrimaryKey(String agent);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_mg_record_time
	 * @mbggenerated  Thu Jul 21 09:25:46 CST 2016
	 */
	int updateByExampleSelective(@Param("record") MGRecordTimeEntity record,
			@Param("example") MGRecordTimeEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_mg_record_time
	 * @mbggenerated  Thu Jul 21 09:25:46 CST 2016
	 */
	int updateByExample(@Param("record") MGRecordTimeEntity record,
			@Param("example") MGRecordTimeEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_mg_record_time
	 * @mbggenerated  Thu Jul 21 09:25:46 CST 2016
	 */
	int updateByPrimaryKeySelective(MGRecordTimeEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_mg_record_time
	 * @mbggenerated  Thu Jul 21 09:25:46 CST 2016
	 */
	int updateByPrimaryKey(MGRecordTimeEntity record);
}
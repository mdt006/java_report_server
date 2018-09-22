package com.kg.live.mapper;

import com.kg.live.entity.M8SportEntity;
import com.kg.live.entity.M8SportEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface M8SportEntityMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_m8_sport
	 * @mbggenerated  Sun Sep 06 14:03:32 EDT 2015
	 */
	int countByExample(M8SportEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_m8_sport
	 * @mbggenerated  Sun Sep 06 14:03:32 EDT 2015
	 */
	int deleteByExample(M8SportEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_m8_sport
	 * @mbggenerated  Sun Sep 06 14:03:32 EDT 2015
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_m8_sport
	 * @mbggenerated  Sun Sep 06 14:03:32 EDT 2015
	 */
	int insert(M8SportEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_m8_sport
	 * @mbggenerated  Sun Sep 06 14:03:32 EDT 2015
	 */
	int insertSelective(M8SportEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_m8_sport
	 * @mbggenerated  Sun Sep 06 14:03:32 EDT 2015
	 */
	List<M8SportEntity> selectByExample(M8SportEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_m8_sport
	 * @mbggenerated  Sun Sep 06 14:03:32 EDT 2015
	 */
	M8SportEntity selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_m8_sport
	 * @mbggenerated  Sun Sep 06 14:03:32 EDT 2015
	 */
	int updateByExampleSelective(@Param("record") M8SportEntity record,
			@Param("example") M8SportEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_m8_sport
	 * @mbggenerated  Sun Sep 06 14:03:32 EDT 2015
	 */
	int updateByExample(@Param("record") M8SportEntity record,
			@Param("example") M8SportEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_m8_sport
	 * @mbggenerated  Sun Sep 06 14:03:32 EDT 2015
	 */
	int updateByPrimaryKeySelective(M8SportEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_m8_sport
	 * @mbggenerated  Sun Sep 06 14:03:32 EDT 2015
	 */
	int updateByPrimaryKey(M8SportEntity record);
}
package com.kg.live.mapper;

import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApiInfoEntityMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	int countByExample(ApiInfoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	int deleteByExample(ApiInfoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	int insert(ApiInfoEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	int insertSelective(ApiInfoEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	List<ApiInfoEntity> selectByExample(ApiInfoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	ApiInfoEntity selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	int updateByExampleSelective(@Param("record") ApiInfoEntity record,
			@Param("example") ApiInfoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	int updateByExample(@Param("record") ApiInfoEntity record,
			@Param("example") ApiInfoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	int updateByPrimaryKeySelective(ApiInfoEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	int updateByPrimaryKey(ApiInfoEntity record);
}
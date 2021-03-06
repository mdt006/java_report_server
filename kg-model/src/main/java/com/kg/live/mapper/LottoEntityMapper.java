package com.kg.live.mapper;

import com.kg.live.entity.LottoEntity;
import com.kg.live.entity.LottoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LottoEntityMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto
	 * @mbggenerated  Wed Mar 09 16:52:46 AST 2016
	 */
	int countByExample(LottoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto
	 * @mbggenerated  Wed Mar 09 16:52:46 AST 2016
	 */
	int deleteByExample(LottoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto
	 * @mbggenerated  Wed Mar 09 16:52:46 AST 2016
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto
	 * @mbggenerated  Wed Mar 09 16:52:46 AST 2016
	 */
	int insert(LottoEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto
	 * @mbggenerated  Wed Mar 09 16:52:46 AST 2016
	 */
	int insertSelective(LottoEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto
	 * @mbggenerated  Wed Mar 09 16:52:46 AST 2016
	 */
	List<LottoEntity> selectByExample(LottoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto
	 * @mbggenerated  Wed Mar 09 16:52:46 AST 2016
	 */
	LottoEntity selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto
	 * @mbggenerated  Wed Mar 09 16:52:46 AST 2016
	 */
	int updateByExampleSelective(@Param("record") LottoEntity record,
			@Param("example") LottoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto
	 * @mbggenerated  Wed Mar 09 16:52:46 AST 2016
	 */
	int updateByExample(@Param("record") LottoEntity record,
			@Param("example") LottoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto
	 * @mbggenerated  Wed Mar 09 16:52:46 AST 2016
	 */
	int updateByPrimaryKeySelective(LottoEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto
	 * @mbggenerated  Wed Mar 09 16:52:46 AST 2016
	 */
	int updateByPrimaryKey(LottoEntity record);
}
package com.kg.live.mapper;

import com.kg.live.entity.LottoTrans;
import com.kg.live.entity.LottoTransExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LottoTransMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto_trans
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	int countByExample(LottoTransExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto_trans
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	int deleteByExample(LottoTransExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto_trans
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto_trans
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	int insert(LottoTrans record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto_trans
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	int insertSelective(LottoTrans record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto_trans
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	List<LottoTrans> selectByExample(LottoTransExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto_trans
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	LottoTrans selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto_trans
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	int updateByExampleSelective(@Param("record") LottoTrans record,
			@Param("example") LottoTransExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto_trans
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	int updateByExample(@Param("record") LottoTrans record,
			@Param("example") LottoTransExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto_trans
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	int updateByPrimaryKeySelective(LottoTrans record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_xiaoyu_lotto_trans
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	int updateByPrimaryKey(LottoTrans record);
}
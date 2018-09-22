package com.kg.live.mapper;

import com.kg.live.entity.FenfenLottoEntity;
import com.kg.live.entity.FenfenLottoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.kg.live.entity.FenfenLottoEntity;
import com.kg.live.entity.FenfenLottoEntityWithBLOBs;

public interface FenfenLottoEntityMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_fenfen_lotto
	 * @mbggenerated  Wed Mar 02 02:41:26 CST 2016
	 */
	int countByExample(FenfenLottoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_fenfen_lotto
	 * @mbggenerated  Wed Mar 02 02:41:26 CST 2016
	 */
	int deleteByExample(FenfenLottoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_fenfen_lotto
	 * @mbggenerated  Wed Mar 02 02:41:26 CST 2016
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_fenfen_lotto
	 * @mbggenerated  Wed Mar 02 02:41:26 CST 2016
	 */
	int insert(FenfenLottoEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_fenfen_lotto
	 * @mbggenerated  Wed Mar 02 02:41:26 CST 2016
	 */
	int insertSelective(FenfenLottoEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_fenfen_lotto
	 * @mbggenerated  Wed Mar 02 02:41:26 CST 2016
	 */
	List<FenfenLottoEntity> selectByExample(FenfenLottoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_fenfen_lotto
	 * @mbggenerated  Wed Mar 02 02:41:26 CST 2016
	 */
	FenfenLottoEntity selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_fenfen_lotto
	 * @mbggenerated  Wed Mar 02 02:41:26 CST 2016
	 */
	int updateByExampleSelective(@Param("record") FenfenLottoEntity record,
			@Param("example") FenfenLottoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_fenfen_lotto
	 * @mbggenerated  Wed Mar 02 02:41:26 CST 2016
	 */
	int updateByExample(@Param("record") FenfenLottoEntity record,
			@Param("example") FenfenLottoEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_fenfen_lotto
	 * @mbggenerated  Wed Mar 02 02:41:26 CST 2016
	 */
	int updateByPrimaryKeySelective(FenfenLottoEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_fenfen_lotto
	 * @mbggenerated  Wed Mar 02 02:41:26 CST 2016
	 */
	int updateByPrimaryKey(FenfenLottoEntity record);
}
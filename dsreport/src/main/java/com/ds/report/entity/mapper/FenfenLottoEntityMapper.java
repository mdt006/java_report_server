package com.ds.report.entity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.FenfenLottoEntity;
import com.ds.report.entity.FenfenLottoEntityExample;

public interface FenfenLottoEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    int countByExample(FenfenLottoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    int deleteByExample(FenfenLottoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    int insert(FenfenLottoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    int insertSelective(FenfenLottoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    List<FenfenLottoEntity> selectByExampleWithBLOBs(FenfenLottoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    List<FenfenLottoEntity> selectByExample(FenfenLottoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    FenfenLottoEntity selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    int updateByExampleSelective(@Param("record") FenfenLottoEntity record, @Param("example") FenfenLottoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    int updateByExampleWithBLOBs(@Param("record") FenfenLottoEntity record, @Param("example") FenfenLottoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    int updateByExample(@Param("record") FenfenLottoEntity record, @Param("example") FenfenLottoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    int updateByPrimaryKeySelective(FenfenLottoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    int updateByPrimaryKeyWithBLOBs(FenfenLottoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_fenfen_lotto
     *
     * @mbggenerated Mon Sep 21 09:41:59 EDT 2015
     */
    int updateByPrimaryKey(FenfenLottoEntity record);
    
    DsReportDetail queryTotal(FenfenLottoEntityExample example);

	List<DsReportDetail> queryDetail(FenfenLottoEntityExample example);

	List<DsReport> queryTotalGroupGameType(FenfenLottoEntityExample example);

	List<DsReport> queryBetTotalByDayNew(FenfenLottoEntityExample example);
}
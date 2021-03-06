package com.ds.report.entity.mapper;

import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.MGGameEntity;
import com.ds.report.entity.MGGameEntityExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MGGameEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    int countByExample(MGGameEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    int deleteByExample(MGGameEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    int insert(MGGameEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    int insertSelective(MGGameEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    List<MGGameEntity> selectByExampleWithBLOBs(MGGameEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    List<MGGameEntity> selectByExample(MGGameEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    MGGameEntity selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    int updateByExampleSelective(@Param("record") MGGameEntity record, @Param("example") MGGameEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") MGGameEntity record, @Param("example") MGGameEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    int updateByExample(@Param("record") MGGameEntity record, @Param("example") MGGameEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    int updateByPrimaryKeySelective(MGGameEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(MGGameEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_mg_game
     *
     * @mbggenerated Wed Jul 27 10:05:18 CST 2016
     */
    int updateByPrimaryKey(MGGameEntity record);

	List<DsReport> queryTotalGroupGameType(MGGameEntityExample m_example);

	DsReportDetail queryTotal(MGGameEntityExample example);

	List<DsReportDetail> queryDetail(MGGameEntityExample m_example);

	List<DsReport> queryBetTotalByDayNew(MGGameEntityExample m_example);
}
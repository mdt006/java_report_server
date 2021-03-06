package com.ds.report.entity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ds.report.entity.DsAgHunter;
import com.ds.report.entity.DsAgHunterExample;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;

public interface DsAgHunterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_ag_hunter
     *
     * @mbggenerated Wed Jun 28 07:18:59 EDT 2017
     */
    int countByExample(DsAgHunterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_ag_hunter
     *
     * @mbggenerated Wed Jun 28 07:18:59 EDT 2017
     */
    int deleteByExample(DsAgHunterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_ag_hunter
     *
     * @mbggenerated Wed Jun 28 07:18:59 EDT 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_ag_hunter
     *
     * @mbggenerated Wed Jun 28 07:18:59 EDT 2017
     */
    int insert(DsAgHunter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_ag_hunter
     *
     * @mbggenerated Wed Jun 28 07:18:59 EDT 2017
     */
    int insertSelective(DsAgHunter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_ag_hunter
     *
     * @mbggenerated Wed Jun 28 07:18:59 EDT 2017
     */
    List<DsAgHunter> selectByExample(DsAgHunterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_ag_hunter
     *
     * @mbggenerated Wed Jun 28 07:18:59 EDT 2017
     */
    DsAgHunter selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_ag_hunter
     *
     * @mbggenerated Wed Jun 28 07:18:59 EDT 2017
     */
    int updateByExampleSelective(@Param("record") DsAgHunter record, @Param("example") DsAgHunterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_ag_hunter
     *
     * @mbggenerated Wed Jun 28 07:18:59 EDT 2017
     */
    int updateByExample(@Param("record") DsAgHunter record, @Param("example") DsAgHunterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_ag_hunter
     *
     * @mbggenerated Wed Jun 28 07:18:59 EDT 2017
     */
    int updateByPrimaryKeySelective(DsAgHunter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_ag_hunter
     *
     * @mbggenerated Wed Jun 28 07:18:59 EDT 2017
     */
    int updateByPrimaryKey(DsAgHunter record);
    DsReportDetail queryTotal(DsAgHunterExample example);
    List<DsReportDetail> queryDetail(DsAgHunterExample example);
	List<DsReport> queryTotalGroupGameType(DsAgHunterExample example);
	/** 按天统计 */
	List<DsReport> queryBetTotalByDayNew(DsAgHunterExample example);

}
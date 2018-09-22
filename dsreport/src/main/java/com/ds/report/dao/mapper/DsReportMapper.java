package com.ds.report.dao.mapper;

import com.ds.report.entity.DsCommissionTotal;
import com.ds.report.entity.DsPrivilegeTotal;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportExample;
import com.ds.report.entity.DsWaterTotal;
import com.ds.report.entity.DsAuditTotal;
import com.ds.report.entity.DsWaterTotalNew;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DsReportMapper {
    int countByExample(DsReportExample example);

    int deleteByExample(DsReportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsReport record);

    int insertSelective(DsReport record);

    List<DsReport> selectByExample(DsReportExample example);

    DsReport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsReport record, @Param("example") DsReportExample example);

    int updateByExample(@Param("record") DsReport record, @Param("example") DsReportExample example);

    int updateByPrimaryKeySelective(DsReport record);

    int updateByPrimaryKey(DsReport record);
    
    //增加查询 接口
    /**
     * 查询层级统计报表
     * @param example
     * @return
     */
    List<DsReport> queryTotal(DsReportExample example);
    /**
     * 查询层级统计报表
     * @param example
     * @return
     */
    List<DsReport> queryTotalByProc(String condition);
    /**
     * 查询分公司报表，按照大股东分组显示报表
     * @param example
     * @return
     */
    List<DsReport> queryTotalByBranch(DsReportExample example);
    /**
     * 查询大股东下的各个股东层级报表，按照股东分组显示报表
     * @param example
     * @return
     */
    List<DsReport> queryTotalBySuperior(DsReportExample example);
    /**
     * 查询股东下的各个总代层级报表，按照总代分组显示报表
     * @param example
     * @return
     */
    List<DsReport> queryTotalByCorprator(DsReportExample example);
    /**
     * 查询总代理下的各个代理层级报表，按照代理分组显示报表
     * @param example
     * @return
     */
    List<DsReport> queryTotalByWorld(DsReportExample example);
    /**
     * 查询代理下的各个会员层级报表，按照会员分组显示报表
     * @param example
     * @return
     */
    List<DsReport> queryTotalByAgent(DsReportExample example);
    /**
     * 按用户统计汇总数
     * @param example
     * @return
     */
    List<DsReport> queryBetTotal(DsReportExample example);
    
    /**
     * 按用户/天统计汇总数
     * @param example
     * @return
     */
    List<DsReport> queryBetTotalByDay(DsReportExample example);
    
    /**
     * 优惠统计,根据用户名称统计每天游戏大类的有效投注额
     */
    List<DsPrivilegeTotal> privilegeTotal(DsReportExample example);
    List<DsPrivilegeTotal> privilegeTotalByProc(String condition);
    
    /**
     * 退佣统计,根据代理分组统计有效投注金额、派彩金额、会员数
     */
    List<DsCommissionTotal> commissionTotal(DsReportExample example);
    List<DsCommissionTotal> commissionTotalByProc(String condition);
    List<DsCommissionTotal> commissionTotalByPage(Map<String, Object> mapCondition);
   
    /**
     * 返水报表,根据用户名称统计每个游戏大类的返水金额
     */
    List<DsWaterTotal> waterReportByProc(Map<String,Object> mapCondition);
    
    List<DsWaterTotal> waterReport(DsReportExample example);
    List<DsWaterTotal> waterReportTotal(String condition);
    DsAuditTotal auditTotal(DsReportExample example);
    /**
     * 有效会员统计,根据代理分组统计有效会员数
     */
    DsCommissionTotal validUserTotal(DsReportExample example);
    List<DsCommissionTotal> validUserList(DsReportExample example);
    List<List<DsCommissionTotal>> validUserListByProc(String condition);

	List<DsWaterTotalNew> waterReportTotalNew(String condition);
	
	List<DsWaterTotalNew> waterReportTotalNewByPage(Map<String, Object> paramMap);
	/**按gameType分组查询报表统计**/
	List<Map<String,Object>> getReportGroupByGameType(DsReportExample example);
	/**按gameType分组查询报表统计总数**/
	int getReportGroupByGameTypeCount(DsReportExample example);
	List<Map<String,Object>> getGameKindsByUsername(Map<String,Object> map);
	List<Map<String,Object>> getDetailSqlMap();
	List<Map<String,Object>> getDetailDataBySql(@Param("select_sql")String select_sql);
	
	//查询游戏返水
	List<Map<String,Object>> getGameWaterDataBySql(@Param("select_sql")String select_sql);
}
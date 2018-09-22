package com.ds.report.dao.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.alibaba.fastjson.JSONObject;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.LiveIdConfig;
import com.ds.report.entity.MemberLogVo;
import com.ds.report.vo.AuditTotalBatParam;
import com.ds.report.vo.AuditTotalBatResult;
import com.ds.report.vo.BetInfoByDateParam;
import com.ds.report.vo.BetInfoByDateSum;
import com.ds.report.vo.GetAllLiveByUserVo;
import com.ds.report.vo.HunterDetailRecordParam;
import com.ds.report.vo.HunterDetailRecordVo;
import com.ds.report.vo.HunterDetailTotalVo;
import com.ds.report.vo.HunterSumRecordParam;
import com.ds.report.vo.HunterSumRecordVo;
import com.ds.report.vo.MemberBetInfoParam;
import com.ds.report.vo.MemberBetInfoVo;
import com.ds.report.vo.MemberBetSumVo;
import com.ds.report.vo.SiteOrderVo;
import com.ds.report.vo.TotalBySiteVo;
import com.ds.report.vo.ValidateMemberByDateParam;
import com.ds.report.vo.ValidateMemberByDateVo;

public interface DsReportDao {

	List<MemberBetInfoVo> findMemberBetByPage(RowBounds rowBounds,
			@Param("param")MemberBetInfoParam queryParam);

	Long countMemberBetByPage(@Param("param")MemberBetInfoParam queryParam);

	MemberBetSumVo memberBetSum(@Param("param")MemberBetInfoParam queryParam);

	Long memberBetCountByPage(@Param("param")MemberBetInfoParam queryParam);

	List<MemberBetInfoVo> findBetByDate(@Param("param")BetInfoByDateParam queryParam);

	BetInfoByDateSum betInfoByDateSum(@Param("param")BetInfoByDateParam queryParam);

	List<ValidateMemberByDateVo> findValidateMemberByDate(
			@Param("param")ValidateMemberByDateParam queryParam);

	List<String> getBanlanceByLiveId(Map<String, Object> queryParam);

	List<GetAllLiveByUserVo> getAllLiveByUser(@Param("param")JSONObject obj);

	BigDecimal getAllTypeByUser(@Param("param")JSONObject obj);

	List<String> getMemberNameList(@Param("param")JSONObject obj);

	List<SiteOrderVo> siteOrderDesc(@Param("param")JSONObject obj);

	DsReport getBetInfoByLiveId(@Param("liveConfig")LiveIdConfig liveIdConfig, @Param("param")JSONObject obj);
	
	List<MemberLogVo> selectIMemberLogById(@Param("id")Long id);

	List<AuditTotalBatResult> getAuditBat(@Param("param")AuditTotalBatParam param);
	
	//捕鱼王详细jackpot
	List<HunterDetailRecordVo> getDeatilRecord(@Param("param")HunterDetailRecordParam param,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);
	//总数
	HunterDetailTotalVo getDeatilRecordCount(@Param("param")HunterDetailRecordParam param); 
	//捕鱼王统计jackpot
	List<HunterSumRecordVo> getTotalRecord(@Param("param")HunterSumRecordParam hunterSumRecordParam);
	
	//按siteId统计用户打码量
	List<TotalBySiteVo> getTotalBySite(@Param("siteId") String siteId,@Param("beginTime")String beginTime,@Param("endTime")String endTime,@Param("page")int page,@Param("pageLimit")int pageLimit);
	
	int getTotalBySiteCount(@Param("siteId") String siteId,@Param("beginTime")String beginTime,@Param("endTime")String endTime);

}

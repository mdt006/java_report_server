package com.ds.report.dao.mapper;

import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.DsXiaoyuLotto;
import com.ds.report.entity.DsXiaoyuLottoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsXiaoyuLottoMapper {
    int countByExample(DsXiaoyuLottoExample example);

    int deleteByExample(DsXiaoyuLottoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsXiaoyuLotto record);

    int insertSelective(DsXiaoyuLotto record);

    List<DsXiaoyuLotto> selectByExample(DsXiaoyuLottoExample example);

    DsXiaoyuLotto selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsXiaoyuLotto record, @Param("example") DsXiaoyuLottoExample example);

    int updateByExample(@Param("record") DsXiaoyuLotto record, @Param("example") DsXiaoyuLottoExample example);

    int updateByPrimaryKeySelective(DsXiaoyuLotto record);

    int updateByPrimaryKey(DsXiaoyuLotto record);
    
    //查询明细总条数、总投注金额、总有效金额及总输赢金额
    DsReportDetail queryTotal(DsXiaoyuLottoExample example);
    List<DsReportDetail> queryDetail(DsXiaoyuLottoExample example);
}
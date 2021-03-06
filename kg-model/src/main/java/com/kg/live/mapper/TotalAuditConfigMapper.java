package com.kg.live.mapper;

import com.kg.live.entity.TotalAuditConfig;
import com.kg.live.entity.TotalAuditConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TotalAuditConfigMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    int countByExample(TotalAuditConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    int deleteByExample(TotalAuditConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    int insert(TotalAuditConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    int insertSelective(TotalAuditConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    List<TotalAuditConfig> selectByExampleWithBLOBs(TotalAuditConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    List<TotalAuditConfig> selectByExample(TotalAuditConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    TotalAuditConfig selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    int updateByExampleSelective(@Param("record") TotalAuditConfig record, @Param("example") TotalAuditConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") TotalAuditConfig record, @Param("example") TotalAuditConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    int updateByExample(@Param("record") TotalAuditConfig record, @Param("example") TotalAuditConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    int updateByPrimaryKeySelective(TotalAuditConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(TotalAuditConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_total_audit_config
     *
     * @mbggenerated Tue Oct 27 13:43:10 CST 2015
     */
    int updateByPrimaryKey(TotalAuditConfig record);
}
package com.kg.live.mapper;

import com.kg.live.entity.GuangxiLottoEntity;
import com.kg.live.entity.GuangxiLottoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuangxiLottoEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_guangxi_lotto
     *
     * @mbggenerated Fri Jun 03 22:03:53 ADT 2016
     */
    int countByExample(GuangxiLottoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_guangxi_lotto
     *
     * @mbggenerated Fri Jun 03 22:03:53 ADT 2016
     */
    int deleteByExample(GuangxiLottoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_guangxi_lotto
     *
     * @mbggenerated Fri Jun 03 22:03:53 ADT 2016
     */
    int deleteByPrimaryKey(String billno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_guangxi_lotto
     *
     * @mbggenerated Fri Jun 03 22:03:53 ADT 2016
     */
    int insert(GuangxiLottoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_guangxi_lotto
     *
     * @mbggenerated Fri Jun 03 22:03:53 ADT 2016
     */
    int insertSelective(GuangxiLottoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_guangxi_lotto
     *
     * @mbggenerated Fri Jun 03 22:03:53 ADT 2016
     */
    List<GuangxiLottoEntity> selectByExample(GuangxiLottoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_guangxi_lotto
     *
     * @mbggenerated Fri Jun 03 22:03:53 ADT 2016
     */
    GuangxiLottoEntity selectByPrimaryKey(String billno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_guangxi_lotto
     *
     * @mbggenerated Fri Jun 03 22:03:53 ADT 2016
     */
    int updateByExampleSelective(@Param("record") GuangxiLottoEntity record, @Param("example") GuangxiLottoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_guangxi_lotto
     *
     * @mbggenerated Fri Jun 03 22:03:53 ADT 2016
     */
    int updateByExample(@Param("record") GuangxiLottoEntity record, @Param("example") GuangxiLottoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_guangxi_lotto
     *
     * @mbggenerated Fri Jun 03 22:03:53 ADT 2016
     */
    int updateByPrimaryKeySelective(GuangxiLottoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_guangxi_lotto
     *
     * @mbggenerated Fri Jun 03 22:03:53 ADT 2016
     */
    int updateByPrimaryKey(GuangxiLottoEntity record);
}
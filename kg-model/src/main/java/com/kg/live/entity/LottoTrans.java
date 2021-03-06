package com.kg.live.entity;

import java.util.Date;

public class LottoTrans {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ds_xiaoyu_lotto_trans.id
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ds_xiaoyu_lotto_trans.site_id
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	private Integer siteId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ds_xiaoyu_lotto_trans.username
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ds_xiaoyu_lotto_trans.trans_id
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	private String transId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ds_xiaoyu_lotto_trans.state
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	private Integer state;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ds_xiaoyu_lotto_trans.memo
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	private String memo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ds_xiaoyu_lotto_trans.money
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	private String money;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ds_xiaoyu_lotto_trans.trans_time
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	private Date transTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ds_xiaoyu_lotto_trans.create_time
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	private Date createTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ds_xiaoyu_lotto_trans.id
	 * @return  the value of ds_xiaoyu_lotto_trans.id
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ds_xiaoyu_lotto_trans.id
	 * @param id  the value for ds_xiaoyu_lotto_trans.id
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ds_xiaoyu_lotto_trans.site_id
	 * @return  the value of ds_xiaoyu_lotto_trans.site_id
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public Integer getSiteId() {
		return siteId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ds_xiaoyu_lotto_trans.site_id
	 * @param siteId  the value for ds_xiaoyu_lotto_trans.site_id
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ds_xiaoyu_lotto_trans.username
	 * @return  the value of ds_xiaoyu_lotto_trans.username
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ds_xiaoyu_lotto_trans.username
	 * @param username  the value for ds_xiaoyu_lotto_trans.username
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ds_xiaoyu_lotto_trans.trans_id
	 * @return  the value of ds_xiaoyu_lotto_trans.trans_id
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public String getTransId() {
		return transId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ds_xiaoyu_lotto_trans.trans_id
	 * @param transId  the value for ds_xiaoyu_lotto_trans.trans_id
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public void setTransId(String transId) {
		this.transId = transId == null ? null : transId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ds_xiaoyu_lotto_trans.state
	 * @return  the value of ds_xiaoyu_lotto_trans.state
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ds_xiaoyu_lotto_trans.state
	 * @param state  the value for ds_xiaoyu_lotto_trans.state
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ds_xiaoyu_lotto_trans.memo
	 * @return  the value of ds_xiaoyu_lotto_trans.memo
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ds_xiaoyu_lotto_trans.memo
	 * @param memo  the value for ds_xiaoyu_lotto_trans.memo
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ds_xiaoyu_lotto_trans.money
	 * @return  the value of ds_xiaoyu_lotto_trans.money
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public String getMoney() {
		return money;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ds_xiaoyu_lotto_trans.money
	 * @param money  the value for ds_xiaoyu_lotto_trans.money
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public void setMoney(String money) {
		this.money = money == null ? null : money.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ds_xiaoyu_lotto_trans.trans_time
	 * @return  the value of ds_xiaoyu_lotto_trans.trans_time
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public Date getTransTime() {
		return transTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ds_xiaoyu_lotto_trans.trans_time
	 * @param transTime  the value for ds_xiaoyu_lotto_trans.trans_time
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ds_xiaoyu_lotto_trans.create_time
	 * @return  the value of ds_xiaoyu_lotto_trans.create_time
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ds_xiaoyu_lotto_trans.create_time
	 * @param createTime  the value for ds_xiaoyu_lotto_trans.create_time
	 * @mbggenerated  Mon Aug 31 17:12:19 ADT 2015
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
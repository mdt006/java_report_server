package com.kg.live.entity;

import java.util.ArrayList;
import java.util.List;

public class ApiInfoEntityExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	public ApiInfoEntityExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andHashcodeIsNull() {
			addCriterion("hashcode is null");
			return (Criteria) this;
		}

		public Criteria andHashcodeIsNotNull() {
			addCriterion("hashcode is not null");
			return (Criteria) this;
		}

		public Criteria andHashcodeEqualTo(String value) {
			addCriterion("hashcode =", value, "hashcode");
			return (Criteria) this;
		}

		public Criteria andHashcodeNotEqualTo(String value) {
			addCriterion("hashcode <>", value, "hashcode");
			return (Criteria) this;
		}

		public Criteria andHashcodeGreaterThan(String value) {
			addCriterion("hashcode >", value, "hashcode");
			return (Criteria) this;
		}

		public Criteria andHashcodeGreaterThanOrEqualTo(String value) {
			addCriterion("hashcode >=", value, "hashcode");
			return (Criteria) this;
		}

		public Criteria andHashcodeLessThan(String value) {
			addCriterion("hashcode <", value, "hashcode");
			return (Criteria) this;
		}

		public Criteria andHashcodeLessThanOrEqualTo(String value) {
			addCriterion("hashcode <=", value, "hashcode");
			return (Criteria) this;
		}

		public Criteria andHashcodeLike(String value) {
			addCriterion("hashcode like", value, "hashcode");
			return (Criteria) this;
		}

		public Criteria andHashcodeNotLike(String value) {
			addCriterion("hashcode not like", value, "hashcode");
			return (Criteria) this;
		}

		public Criteria andHashcodeIn(List<String> values) {
			addCriterion("hashcode in", values, "hashcode");
			return (Criteria) this;
		}

		public Criteria andHashcodeNotIn(List<String> values) {
			addCriterion("hashcode not in", values, "hashcode");
			return (Criteria) this;
		}

		public Criteria andHashcodeBetween(String value1, String value2) {
			addCriterion("hashcode between", value1, value2, "hashcode");
			return (Criteria) this;
		}

		public Criteria andHashcodeNotBetween(String value1, String value2) {
			addCriterion("hashcode not between", value1, value2, "hashcode");
			return (Criteria) this;
		}

		public Criteria andSiteIdIsNull() {
			addCriterion("site_id is null");
			return (Criteria) this;
		}

		public Criteria andSiteIdIsNotNull() {
			addCriterion("site_id is not null");
			return (Criteria) this;
		}

		public Criteria andSiteIdEqualTo(Integer value) {
			addCriterion("site_id =", value, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdNotEqualTo(Integer value) {
			addCriterion("site_id <>", value, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdGreaterThan(Integer value) {
			addCriterion("site_id >", value, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("site_id >=", value, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdLessThan(Integer value) {
			addCriterion("site_id <", value, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdLessThanOrEqualTo(Integer value) {
			addCriterion("site_id <=", value, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdIn(List<Integer> values) {
			addCriterion("site_id in", values, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdNotIn(List<Integer> values) {
			addCriterion("site_id not in", values, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdBetween(Integer value1, Integer value2) {
			addCriterion("site_id between", value1, value2, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdNotBetween(Integer value1, Integer value2) {
			addCriterion("site_id not between", value1, value2, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteNameIsNull() {
			addCriterion("site_name is null");
			return (Criteria) this;
		}

		public Criteria andSiteNameIsNotNull() {
			addCriterion("site_name is not null");
			return (Criteria) this;
		}

		public Criteria andSiteNameEqualTo(String value) {
			addCriterion("site_name =", value, "siteName");
			return (Criteria) this;
		}

		public Criteria andSiteNameNotEqualTo(String value) {
			addCriterion("site_name <>", value, "siteName");
			return (Criteria) this;
		}

		public Criteria andSiteNameGreaterThan(String value) {
			addCriterion("site_name >", value, "siteName");
			return (Criteria) this;
		}

		public Criteria andSiteNameGreaterThanOrEqualTo(String value) {
			addCriterion("site_name >=", value, "siteName");
			return (Criteria) this;
		}

		public Criteria andSiteNameLessThan(String value) {
			addCriterion("site_name <", value, "siteName");
			return (Criteria) this;
		}

		public Criteria andSiteNameLessThanOrEqualTo(String value) {
			addCriterion("site_name <=", value, "siteName");
			return (Criteria) this;
		}

		public Criteria andSiteNameLike(String value) {
			addCriterion("site_name like", value, "siteName");
			return (Criteria) this;
		}

		public Criteria andSiteNameNotLike(String value) {
			addCriterion("site_name not like", value, "siteName");
			return (Criteria) this;
		}

		public Criteria andSiteNameIn(List<String> values) {
			addCriterion("site_name in", values, "siteName");
			return (Criteria) this;
		}

		public Criteria andSiteNameNotIn(List<String> values) {
			addCriterion("site_name not in", values, "siteName");
			return (Criteria) this;
		}

		public Criteria andSiteNameBetween(String value1, String value2) {
			addCriterion("site_name between", value1, value2, "siteName");
			return (Criteria) this;
		}

		public Criteria andSiteNameNotBetween(String value1, String value2) {
			addCriterion("site_name not between", value1, value2, "siteName");
			return (Criteria) this;
		}

		public Criteria andPrefixIsNull() {
			addCriterion("prefix is null");
			return (Criteria) this;
		}

		public Criteria andPrefixIsNotNull() {
			addCriterion("prefix is not null");
			return (Criteria) this;
		}

		public Criteria andPrefixEqualTo(String value) {
			addCriterion("prefix =", value, "prefix");
			return (Criteria) this;
		}

		public Criteria andPrefixNotEqualTo(String value) {
			addCriterion("prefix <>", value, "prefix");
			return (Criteria) this;
		}

		public Criteria andPrefixGreaterThan(String value) {
			addCriterion("prefix >", value, "prefix");
			return (Criteria) this;
		}

		public Criteria andPrefixGreaterThanOrEqualTo(String value) {
			addCriterion("prefix >=", value, "prefix");
			return (Criteria) this;
		}

		public Criteria andPrefixLessThan(String value) {
			addCriterion("prefix <", value, "prefix");
			return (Criteria) this;
		}

		public Criteria andPrefixLessThanOrEqualTo(String value) {
			addCriterion("prefix <=", value, "prefix");
			return (Criteria) this;
		}

		public Criteria andPrefixLike(String value) {
			addCriterion("prefix like", value, "prefix");
			return (Criteria) this;
		}

		public Criteria andPrefixNotLike(String value) {
			addCriterion("prefix not like", value, "prefix");
			return (Criteria) this;
		}

		public Criteria andPrefixIn(List<String> values) {
			addCriterion("prefix in", values, "prefix");
			return (Criteria) this;
		}

		public Criteria andPrefixNotIn(List<String> values) {
			addCriterion("prefix not in", values, "prefix");
			return (Criteria) this;
		}

		public Criteria andPrefixBetween(String value1, String value2) {
			addCriterion("prefix between", value1, value2, "prefix");
			return (Criteria) this;
		}

		public Criteria andPrefixNotBetween(String value1, String value2) {
			addCriterion("prefix not between", value1, value2, "prefix");
			return (Criteria) this;
		}

		public Criteria andAgentIsNull() {
			addCriterion("agent is null");
			return (Criteria) this;
		}

		public Criteria andAgentIsNotNull() {
			addCriterion("agent is not null");
			return (Criteria) this;
		}

		public Criteria andAgentEqualTo(String value) {
			addCriterion("agent =", value, "agent");
			return (Criteria) this;
		}

		public Criteria andAgentNotEqualTo(String value) {
			addCriterion("agent <>", value, "agent");
			return (Criteria) this;
		}

		public Criteria andAgentGreaterThan(String value) {
			addCriterion("agent >", value, "agent");
			return (Criteria) this;
		}

		public Criteria andAgentGreaterThanOrEqualTo(String value) {
			addCriterion("agent >=", value, "agent");
			return (Criteria) this;
		}

		public Criteria andAgentLessThan(String value) {
			addCriterion("agent <", value, "agent");
			return (Criteria) this;
		}

		public Criteria andAgentLessThanOrEqualTo(String value) {
			addCriterion("agent <=", value, "agent");
			return (Criteria) this;
		}

		public Criteria andAgentLike(String value) {
			addCriterion("agent like", value, "agent");
			return (Criteria) this;
		}

		public Criteria andAgentNotLike(String value) {
			addCriterion("agent not like", value, "agent");
			return (Criteria) this;
		}

		public Criteria andAgentIn(List<String> values) {
			addCriterion("agent in", values, "agent");
			return (Criteria) this;
		}

		public Criteria andAgentNotIn(List<String> values) {
			addCriterion("agent not in", values, "agent");
			return (Criteria) this;
		}

		public Criteria andAgentBetween(String value1, String value2) {
			addCriterion("agent between", value1, value2, "agent");
			return (Criteria) this;
		}

		public Criteria andAgentNotBetween(String value1, String value2) {
			addCriterion("agent not between", value1, value2, "agent");
			return (Criteria) this;
		}

		public Criteria andWebUrlIsNull() {
			addCriterion("web_url is null");
			return (Criteria) this;
		}

		public Criteria andWebUrlIsNotNull() {
			addCriterion("web_url is not null");
			return (Criteria) this;
		}

		public Criteria andWebUrlEqualTo(String value) {
			addCriterion("web_url =", value, "webUrl");
			return (Criteria) this;
		}

		public Criteria andWebUrlNotEqualTo(String value) {
			addCriterion("web_url <>", value, "webUrl");
			return (Criteria) this;
		}

		public Criteria andWebUrlGreaterThan(String value) {
			addCriterion("web_url >", value, "webUrl");
			return (Criteria) this;
		}

		public Criteria andWebUrlGreaterThanOrEqualTo(String value) {
			addCriterion("web_url >=", value, "webUrl");
			return (Criteria) this;
		}

		public Criteria andWebUrlLessThan(String value) {
			addCriterion("web_url <", value, "webUrl");
			return (Criteria) this;
		}

		public Criteria andWebUrlLessThanOrEqualTo(String value) {
			addCriterion("web_url <=", value, "webUrl");
			return (Criteria) this;
		}

		public Criteria andWebUrlLike(String value) {
			addCriterion("web_url like", value, "webUrl");
			return (Criteria) this;
		}

		public Criteria andWebUrlNotLike(String value) {
			addCriterion("web_url not like", value, "webUrl");
			return (Criteria) this;
		}

		public Criteria andWebUrlIn(List<String> values) {
			addCriterion("web_url in", values, "webUrl");
			return (Criteria) this;
		}

		public Criteria andWebUrlNotIn(List<String> values) {
			addCriterion("web_url not in", values, "webUrl");
			return (Criteria) this;
		}

		public Criteria andWebUrlBetween(String value1, String value2) {
			addCriterion("web_url between", value1, value2, "webUrl");
			return (Criteria) this;
		}

		public Criteria andWebUrlNotBetween(String value1, String value2) {
			addCriterion("web_url not between", value1, value2, "webUrl");
			return (Criteria) this;
		}

		public Criteria andReporturlIsNull() {
			addCriterion("reporturl is null");
			return (Criteria) this;
		}

		public Criteria andReporturlIsNotNull() {
			addCriterion("reporturl is not null");
			return (Criteria) this;
		}

		public Criteria andReporturlEqualTo(String value) {
			addCriterion("reporturl =", value, "reporturl");
			return (Criteria) this;
		}

		public Criteria andReporturlNotEqualTo(String value) {
			addCriterion("reporturl <>", value, "reporturl");
			return (Criteria) this;
		}

		public Criteria andReporturlGreaterThan(String value) {
			addCriterion("reporturl >", value, "reporturl");
			return (Criteria) this;
		}

		public Criteria andReporturlGreaterThanOrEqualTo(String value) {
			addCriterion("reporturl >=", value, "reporturl");
			return (Criteria) this;
		}

		public Criteria andReporturlLessThan(String value) {
			addCriterion("reporturl <", value, "reporturl");
			return (Criteria) this;
		}

		public Criteria andReporturlLessThanOrEqualTo(String value) {
			addCriterion("reporturl <=", value, "reporturl");
			return (Criteria) this;
		}

		public Criteria andReporturlLike(String value) {
			addCriterion("reporturl like", value, "reporturl");
			return (Criteria) this;
		}

		public Criteria andReporturlNotLike(String value) {
			addCriterion("reporturl not like", value, "reporturl");
			return (Criteria) this;
		}

		public Criteria andReporturlIn(List<String> values) {
			addCriterion("reporturl in", values, "reporturl");
			return (Criteria) this;
		}

		public Criteria andReporturlNotIn(List<String> values) {
			addCriterion("reporturl not in", values, "reporturl");
			return (Criteria) this;
		}

		public Criteria andReporturlBetween(String value1, String value2) {
			addCriterion("reporturl between", value1, value2, "reporturl");
			return (Criteria) this;
		}

		public Criteria andReporturlNotBetween(String value1, String value2) {
			addCriterion("reporturl not between", value1, value2, "reporturl");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andIpIsNull() {
			addCriterion("ip is null");
			return (Criteria) this;
		}

		public Criteria andIpIsNotNull() {
			addCriterion("ip is not null");
			return (Criteria) this;
		}

		public Criteria andIpEqualTo(String value) {
			addCriterion("ip =", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotEqualTo(String value) {
			addCriterion("ip <>", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThan(String value) {
			addCriterion("ip >", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThanOrEqualTo(String value) {
			addCriterion("ip >=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThan(String value) {
			addCriterion("ip <", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThanOrEqualTo(String value) {
			addCriterion("ip <=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLike(String value) {
			addCriterion("ip like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotLike(String value) {
			addCriterion("ip not like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpIn(List<String> values) {
			addCriterion("ip in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotIn(List<String> values) {
			addCriterion("ip not in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpBetween(String value1, String value2) {
			addCriterion("ip between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotBetween(String value1, String value2) {
			addCriterion("ip not between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andKeybIsNull() {
			addCriterion("keyB is null");
			return (Criteria) this;
		}

		public Criteria andKeybIsNotNull() {
			addCriterion("keyB is not null");
			return (Criteria) this;
		}

		public Criteria andKeybEqualTo(String value) {
			addCriterion("keyB =", value, "keyb");
			return (Criteria) this;
		}

		public Criteria andKeybNotEqualTo(String value) {
			addCriterion("keyB <>", value, "keyb");
			return (Criteria) this;
		}

		public Criteria andKeybGreaterThan(String value) {
			addCriterion("keyB >", value, "keyb");
			return (Criteria) this;
		}

		public Criteria andKeybGreaterThanOrEqualTo(String value) {
			addCriterion("keyB >=", value, "keyb");
			return (Criteria) this;
		}

		public Criteria andKeybLessThan(String value) {
			addCriterion("keyB <", value, "keyb");
			return (Criteria) this;
		}

		public Criteria andKeybLessThanOrEqualTo(String value) {
			addCriterion("keyB <=", value, "keyb");
			return (Criteria) this;
		}

		public Criteria andKeybLike(String value) {
			addCriterion("keyB like", value, "keyb");
			return (Criteria) this;
		}

		public Criteria andKeybNotLike(String value) {
			addCriterion("keyB not like", value, "keyb");
			return (Criteria) this;
		}

		public Criteria andKeybIn(List<String> values) {
			addCriterion("keyB in", values, "keyb");
			return (Criteria) this;
		}

		public Criteria andKeybNotIn(List<String> values) {
			addCriterion("keyB not in", values, "keyb");
			return (Criteria) this;
		}

		public Criteria andKeybBetween(String value1, String value2) {
			addCriterion("keyB between", value1, value2, "keyb");
			return (Criteria) this;
		}

		public Criteria andKeybNotBetween(String value1, String value2) {
			addCriterion("keyB not between", value1, value2, "keyb");
			return (Criteria) this;
		}

		public Criteria andStateIsNull() {
			addCriterion("state is null");
			return (Criteria) this;
		}

		public Criteria andStateIsNotNull() {
			addCriterion("state is not null");
			return (Criteria) this;
		}

		public Criteria andStateEqualTo(Short value) {
			addCriterion("state =", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotEqualTo(Short value) {
			addCriterion("state <>", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThan(Short value) {
			addCriterion("state >", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThanOrEqualTo(Short value) {
			addCriterion("state >=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThan(Short value) {
			addCriterion("state <", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThanOrEqualTo(Short value) {
			addCriterion("state <=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateIn(List<Short> values) {
			addCriterion("state in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotIn(List<Short> values) {
			addCriterion("state not in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateBetween(Short value1, Short value2) {
			addCriterion("state between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotBetween(Short value1, Short value2) {
			addCriterion("state not between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andLiveIdIsNull() {
			addCriterion("live_id is null");
			return (Criteria) this;
		}

		public Criteria andLiveIdIsNotNull() {
			addCriterion("live_id is not null");
			return (Criteria) this;
		}

		public Criteria andLiveIdEqualTo(Integer value) {
			addCriterion("live_id =", value, "liveId");
			return (Criteria) this;
		}

		public Criteria andLiveIdNotEqualTo(Integer value) {
			addCriterion("live_id <>", value, "liveId");
			return (Criteria) this;
		}

		public Criteria andLiveIdGreaterThan(Integer value) {
			addCriterion("live_id >", value, "liveId");
			return (Criteria) this;
		}

		public Criteria andLiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("live_id >=", value, "liveId");
			return (Criteria) this;
		}

		public Criteria andLiveIdLessThan(Integer value) {
			addCriterion("live_id <", value, "liveId");
			return (Criteria) this;
		}

		public Criteria andLiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("live_id <=", value, "liveId");
			return (Criteria) this;
		}

		public Criteria andLiveIdIn(List<Integer> values) {
			addCriterion("live_id in", values, "liveId");
			return (Criteria) this;
		}

		public Criteria andLiveIdNotIn(List<Integer> values) {
			addCriterion("live_id not in", values, "liveId");
			return (Criteria) this;
		}

		public Criteria andLiveIdBetween(Integer value1, Integer value2) {
			addCriterion("live_id between", value1, value2, "liveId");
			return (Criteria) this;
		}

		public Criteria andLiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("live_id not between", value1, value2, "liveId");
			return (Criteria) this;
		}

		public Criteria andLiveNameIsNull() {
			addCriterion("live_name is null");
			return (Criteria) this;
		}

		public Criteria andLiveNameIsNotNull() {
			addCriterion("live_name is not null");
			return (Criteria) this;
		}

		public Criteria andLiveNameEqualTo(String value) {
			addCriterion("live_name =", value, "liveName");
			return (Criteria) this;
		}

		public Criteria andLiveNameNotEqualTo(String value) {
			addCriterion("live_name <>", value, "liveName");
			return (Criteria) this;
		}

		public Criteria andLiveNameGreaterThan(String value) {
			addCriterion("live_name >", value, "liveName");
			return (Criteria) this;
		}

		public Criteria andLiveNameGreaterThanOrEqualTo(String value) {
			addCriterion("live_name >=", value, "liveName");
			return (Criteria) this;
		}

		public Criteria andLiveNameLessThan(String value) {
			addCriterion("live_name <", value, "liveName");
			return (Criteria) this;
		}

		public Criteria andLiveNameLessThanOrEqualTo(String value) {
			addCriterion("live_name <=", value, "liveName");
			return (Criteria) this;
		}

		public Criteria andLiveNameLike(String value) {
			addCriterion("live_name like", value, "liveName");
			return (Criteria) this;
		}

		public Criteria andLiveNameNotLike(String value) {
			addCriterion("live_name not like", value, "liveName");
			return (Criteria) this;
		}

		public Criteria andLiveNameIn(List<String> values) {
			addCriterion("live_name in", values, "liveName");
			return (Criteria) this;
		}

		public Criteria andLiveNameNotIn(List<String> values) {
			addCriterion("live_name not in", values, "liveName");
			return (Criteria) this;
		}

		public Criteria andLiveNameBetween(String value1, String value2) {
			addCriterion("live_name between", value1, value2, "liveName");
			return (Criteria) this;
		}

		public Criteria andLiveNameNotBetween(String value1, String value2) {
			addCriterion("live_name not between", value1, value2, "liveName");
			return (Criteria) this;
		}

		public Criteria andLiveKeyIsNull() {
			addCriterion("live_key is null");
			return (Criteria) this;
		}

		public Criteria andLiveKeyIsNotNull() {
			addCriterion("live_key is not null");
			return (Criteria) this;
		}

		public Criteria andLiveKeyEqualTo(String value) {
			addCriterion("live_key =", value, "liveKey");
			return (Criteria) this;
		}

		public Criteria andLiveKeyNotEqualTo(String value) {
			addCriterion("live_key <>", value, "liveKey");
			return (Criteria) this;
		}

		public Criteria andLiveKeyGreaterThan(String value) {
			addCriterion("live_key >", value, "liveKey");
			return (Criteria) this;
		}

		public Criteria andLiveKeyGreaterThanOrEqualTo(String value) {
			addCriterion("live_key >=", value, "liveKey");
			return (Criteria) this;
		}

		public Criteria andLiveKeyLessThan(String value) {
			addCriterion("live_key <", value, "liveKey");
			return (Criteria) this;
		}

		public Criteria andLiveKeyLessThanOrEqualTo(String value) {
			addCriterion("live_key <=", value, "liveKey");
			return (Criteria) this;
		}

		public Criteria andLiveKeyLike(String value) {
			addCriterion("live_key like", value, "liveKey");
			return (Criteria) this;
		}

		public Criteria andLiveKeyNotLike(String value) {
			addCriterion("live_key not like", value, "liveKey");
			return (Criteria) this;
		}

		public Criteria andLiveKeyIn(List<String> values) {
			addCriterion("live_key in", values, "liveKey");
			return (Criteria) this;
		}

		public Criteria andLiveKeyNotIn(List<String> values) {
			addCriterion("live_key not in", values, "liveKey");
			return (Criteria) this;
		}

		public Criteria andLiveKeyBetween(String value1, String value2) {
			addCriterion("live_key between", value1, value2, "liveKey");
			return (Criteria) this;
		}

		public Criteria andLiveKeyNotBetween(String value1, String value2) {
			addCriterion("live_key not between", value1, value2, "liveKey");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table api_info
	 * @mbggenerated  Tue May 12 23:02:22 CST 2015
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table api_info
     *
     * @mbggenerated do_not_delete_during_merge Tue May 12 22:12:47 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}
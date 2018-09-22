package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DsLiveExample {
    protected String orderByClause;

    protected Integer page;

	protected Integer pageLimit;
	
    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsLiveExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}
	
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
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

        public Criteria andBillnoIsNull() {
            addCriterion("billno is null");
            return (Criteria) this;
        }

        public Criteria andBillnoIsNotNull() {
            addCriterion("billno is not null");
            return (Criteria) this;
        }

        public Criteria andBillnoEqualTo(Long value) {
            addCriterion("billno =", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotEqualTo(Long value) {
            addCriterion("billno <>", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThan(Long value) {
            addCriterion("billno >", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThanOrEqualTo(Long value) {
            addCriterion("billno >=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThan(Long value) {
            addCriterion("billno <", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThanOrEqualTo(Long value) {
            addCriterion("billno <=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoIn(List<Long> values) {
            addCriterion("billno in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotIn(List<Long> values) {
            addCriterion("billno not in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoBetween(Long value1, Long value2) {
            addCriterion("billno between", value1, value2, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotBetween(Long value1, Long value2) {
            addCriterion("billno not between", value1, value2, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoModifyIdIsNull() {
            addCriterion("billno_modify_id is null");
            return (Criteria) this;
        }

        public Criteria andBillnoModifyIdIsNotNull() {
            addCriterion("billno_modify_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillnoModifyIdEqualTo(Long value) {
            addCriterion("billno_modify_id =", value, "billnoModifyId");
            return (Criteria) this;
        }

        public Criteria andBillnoModifyIdNotEqualTo(Long value) {
            addCriterion("billno_modify_id <>", value, "billnoModifyId");
            return (Criteria) this;
        }

        public Criteria andBillnoModifyIdGreaterThan(Long value) {
            addCriterion("billno_modify_id >", value, "billnoModifyId");
            return (Criteria) this;
        }

        public Criteria andBillnoModifyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("billno_modify_id >=", value, "billnoModifyId");
            return (Criteria) this;
        }

        public Criteria andBillnoModifyIdLessThan(Long value) {
            addCriterion("billno_modify_id <", value, "billnoModifyId");
            return (Criteria) this;
        }

        public Criteria andBillnoModifyIdLessThanOrEqualTo(Long value) {
            addCriterion("billno_modify_id <=", value, "billnoModifyId");
            return (Criteria) this;
        }

        public Criteria andBillnoModifyIdIn(List<Long> values) {
            addCriterion("billno_modify_id in", values, "billnoModifyId");
            return (Criteria) this;
        }

        public Criteria andBillnoModifyIdNotIn(List<Long> values) {
            addCriterion("billno_modify_id not in", values, "billnoModifyId");
            return (Criteria) this;
        }

        public Criteria andBillnoModifyIdBetween(Long value1, Long value2) {
            addCriterion("billno_modify_id between", value1, value2, "billnoModifyId");
            return (Criteria) this;
        }

        public Criteria andBillnoModifyIdNotBetween(Long value1, Long value2) {
            addCriterion("billno_modify_id not between", value1, value2, "billnoModifyId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
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

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andGameTypeIsNull() {
            addCriterion("game_type is null");
            return (Criteria) this;
        }

        public Criteria andGameTypeIsNotNull() {
            addCriterion("game_type is not null");
            return (Criteria) this;
        }

        public Criteria andGameTypeEqualTo(String value) {
            addCriterion("game_type =", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotEqualTo(String value) {
            addCriterion("game_type <>", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeGreaterThan(String value) {
            addCriterion("game_type >", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeGreaterThanOrEqualTo(String value) {
            addCriterion("game_type >=", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLessThan(String value) {
            addCriterion("game_type <", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLessThanOrEqualTo(String value) {
            addCriterion("game_type <=", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLike(String value) {
            addCriterion("game_type like", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotLike(String value) {
            addCriterion("game_type not like", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeIn(List<String> values) {
            addCriterion("game_type in", values, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotIn(List<String> values) {
            addCriterion("game_type not in", values, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeBetween(String value1, String value2) {
            addCriterion("game_type between", value1, value2, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotBetween(String value1, String value2) {
            addCriterion("game_type not between", value1, value2, "gameType");
            return (Criteria) this;
        }

        public Criteria andTableInfoIdIsNull() {
            addCriterion("table_info_id is null");
            return (Criteria) this;
        }

        public Criteria andTableInfoIdIsNotNull() {
            addCriterion("table_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andTableInfoIdEqualTo(Integer value) {
            addCriterion("table_info_id =", value, "tableInfoId");
            return (Criteria) this;
        }

        public Criteria andTableInfoIdNotEqualTo(Integer value) {
            addCriterion("table_info_id <>", value, "tableInfoId");
            return (Criteria) this;
        }

        public Criteria andTableInfoIdGreaterThan(Integer value) {
            addCriterion("table_info_id >", value, "tableInfoId");
            return (Criteria) this;
        }

        public Criteria andTableInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("table_info_id >=", value, "tableInfoId");
            return (Criteria) this;
        }

        public Criteria andTableInfoIdLessThan(Integer value) {
            addCriterion("table_info_id <", value, "tableInfoId");
            return (Criteria) this;
        }

        public Criteria andTableInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("table_info_id <=", value, "tableInfoId");
            return (Criteria) this;
        }

        public Criteria andTableInfoIdIn(List<Integer> values) {
            addCriterion("table_info_id in", values, "tableInfoId");
            return (Criteria) this;
        }

        public Criteria andTableInfoIdNotIn(List<Integer> values) {
            addCriterion("table_info_id not in", values, "tableInfoId");
            return (Criteria) this;
        }

        public Criteria andTableInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("table_info_id between", value1, value2, "tableInfoId");
            return (Criteria) this;
        }

        public Criteria andTableInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("table_info_id not between", value1, value2, "tableInfoId");
            return (Criteria) this;
        }

        public Criteria andShowInfoIdIsNull() {
            addCriterion("show_info_id is null");
            return (Criteria) this;
        }

        public Criteria andShowInfoIdIsNotNull() {
            addCriterion("show_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andShowInfoIdEqualTo(Integer value) {
            addCriterion("show_info_id =", value, "showInfoId");
            return (Criteria) this;
        }

        public Criteria andShowInfoIdNotEqualTo(Integer value) {
            addCriterion("show_info_id <>", value, "showInfoId");
            return (Criteria) this;
        }

        public Criteria andShowInfoIdGreaterThan(Integer value) {
            addCriterion("show_info_id >", value, "showInfoId");
            return (Criteria) this;
        }

        public Criteria andShowInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_info_id >=", value, "showInfoId");
            return (Criteria) this;
        }

        public Criteria andShowInfoIdLessThan(Integer value) {
            addCriterion("show_info_id <", value, "showInfoId");
            return (Criteria) this;
        }

        public Criteria andShowInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("show_info_id <=", value, "showInfoId");
            return (Criteria) this;
        }

        public Criteria andShowInfoIdIn(List<Integer> values) {
            addCriterion("show_info_id in", values, "showInfoId");
            return (Criteria) this;
        }

        public Criteria andShowInfoIdNotIn(List<Integer> values) {
            addCriterion("show_info_id not in", values, "showInfoId");
            return (Criteria) this;
        }

        public Criteria andShowInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("show_info_id between", value1, value2, "showInfoId");
            return (Criteria) this;
        }

        public Criteria andShowInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("show_info_id not between", value1, value2, "showInfoId");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNull() {
            addCriterion("table_name is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("table_name is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("table_name =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("table_name <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("table_name >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_name >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("table_name <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("table_name <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("table_name like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("table_name not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("table_name in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("table_name not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("table_name between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("table_name not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andGameInfoIdIsNull() {
            addCriterion("game_info_id is null");
            return (Criteria) this;
        }

        public Criteria andGameInfoIdIsNotNull() {
            addCriterion("game_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andGameInfoIdEqualTo(Integer value) {
            addCriterion("game_info_id =", value, "gameInfoId");
            return (Criteria) this;
        }

        public Criteria andGameInfoIdNotEqualTo(Integer value) {
            addCriterion("game_info_id <>", value, "gameInfoId");
            return (Criteria) this;
        }

        public Criteria andGameInfoIdGreaterThan(Integer value) {
            addCriterion("game_info_id >", value, "gameInfoId");
            return (Criteria) this;
        }

        public Criteria andGameInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("game_info_id >=", value, "gameInfoId");
            return (Criteria) this;
        }

        public Criteria andGameInfoIdLessThan(Integer value) {
            addCriterion("game_info_id <", value, "gameInfoId");
            return (Criteria) this;
        }

        public Criteria andGameInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("game_info_id <=", value, "gameInfoId");
            return (Criteria) this;
        }

        public Criteria andGameInfoIdIn(List<Integer> values) {
            addCriterion("game_info_id in", values, "gameInfoId");
            return (Criteria) this;
        }

        public Criteria andGameInfoIdNotIn(List<Integer> values) {
            addCriterion("game_info_id not in", values, "gameInfoId");
            return (Criteria) this;
        }

        public Criteria andGameInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("game_info_id between", value1, value2, "gameInfoId");
            return (Criteria) this;
        }

        public Criteria andGameInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("game_info_id not between", value1, value2, "gameInfoId");
            return (Criteria) this;
        }

        public Criteria andBankerResultIsNull() {
            addCriterion("banker_result is null");
            return (Criteria) this;
        }

        public Criteria andBankerResultIsNotNull() {
            addCriterion("banker_result is not null");
            return (Criteria) this;
        }

        public Criteria andBankerResultEqualTo(String value) {
            addCriterion("banker_result =", value, "bankerResult");
            return (Criteria) this;
        }

        public Criteria andBankerResultNotEqualTo(String value) {
            addCriterion("banker_result <>", value, "bankerResult");
            return (Criteria) this;
        }

        public Criteria andBankerResultGreaterThan(String value) {
            addCriterion("banker_result >", value, "bankerResult");
            return (Criteria) this;
        }

        public Criteria andBankerResultGreaterThanOrEqualTo(String value) {
            addCriterion("banker_result >=", value, "bankerResult");
            return (Criteria) this;
        }

        public Criteria andBankerResultLessThan(String value) {
            addCriterion("banker_result <", value, "bankerResult");
            return (Criteria) this;
        }

        public Criteria andBankerResultLessThanOrEqualTo(String value) {
            addCriterion("banker_result <=", value, "bankerResult");
            return (Criteria) this;
        }

        public Criteria andBankerResultLike(String value) {
            addCriterion("banker_result like", value, "bankerResult");
            return (Criteria) this;
        }

        public Criteria andBankerResultNotLike(String value) {
            addCriterion("banker_result not like", value, "bankerResult");
            return (Criteria) this;
        }

        public Criteria andBankerResultIn(List<String> values) {
            addCriterion("banker_result in", values, "bankerResult");
            return (Criteria) this;
        }

        public Criteria andBankerResultNotIn(List<String> values) {
            addCriterion("banker_result not in", values, "bankerResult");
            return (Criteria) this;
        }

        public Criteria andBankerResultBetween(String value1, String value2) {
            addCriterion("banker_result between", value1, value2, "bankerResult");
            return (Criteria) this;
        }

        public Criteria andBankerResultNotBetween(String value1, String value2) {
            addCriterion("banker_result not between", value1, value2, "bankerResult");
            return (Criteria) this;
        }

        public Criteria andResultListIsNull() {
            addCriterion("result_list is null");
            return (Criteria) this;
        }

        public Criteria andResultListIsNotNull() {
            addCriterion("result_list is not null");
            return (Criteria) this;
        }

        public Criteria andResultListEqualTo(String value) {
            addCriterion("result_list =", value, "resultList");
            return (Criteria) this;
        }

        public Criteria andResultListNotEqualTo(String value) {
            addCriterion("result_list <>", value, "resultList");
            return (Criteria) this;
        }

        public Criteria andResultListGreaterThan(String value) {
            addCriterion("result_list >", value, "resultList");
            return (Criteria) this;
        }

        public Criteria andResultListGreaterThanOrEqualTo(String value) {
            addCriterion("result_list >=", value, "resultList");
            return (Criteria) this;
        }

        public Criteria andResultListLessThan(String value) {
            addCriterion("result_list <", value, "resultList");
            return (Criteria) this;
        }

        public Criteria andResultListLessThanOrEqualTo(String value) {
            addCriterion("result_list <=", value, "resultList");
            return (Criteria) this;
        }

        public Criteria andResultListLike(String value) {
            addCriterion("result_list like", value, "resultList");
            return (Criteria) this;
        }

        public Criteria andResultListNotLike(String value) {
            addCriterion("result_list not like", value, "resultList");
            return (Criteria) this;
        }

        public Criteria andResultListIn(List<String> values) {
            addCriterion("result_list in", values, "resultList");
            return (Criteria) this;
        }

        public Criteria andResultListNotIn(List<String> values) {
            addCriterion("result_list not in", values, "resultList");
            return (Criteria) this;
        }

        public Criteria andResultListBetween(String value1, String value2) {
            addCriterion("result_list between", value1, value2, "resultList");
            return (Criteria) this;
        }

        public Criteria andResultListNotBetween(String value1, String value2) {
            addCriterion("result_list not between", value1, value2, "resultList");
            return (Criteria) this;
        }

        public Criteria andPokerListIsNull() {
            addCriterion("poker_list is null");
            return (Criteria) this;
        }

        public Criteria andPokerListIsNotNull() {
            addCriterion("poker_list is not null");
            return (Criteria) this;
        }

        public Criteria andPokerListEqualTo(String value) {
            addCriterion("poker_list =", value, "pokerList");
            return (Criteria) this;
        }

        public Criteria andPokerListNotEqualTo(String value) {
            addCriterion("poker_list <>", value, "pokerList");
            return (Criteria) this;
        }

        public Criteria andPokerListGreaterThan(String value) {
            addCriterion("poker_list >", value, "pokerList");
            return (Criteria) this;
        }

        public Criteria andPokerListGreaterThanOrEqualTo(String value) {
            addCriterion("poker_list >=", value, "pokerList");
            return (Criteria) this;
        }

        public Criteria andPokerListLessThan(String value) {
            addCriterion("poker_list <", value, "pokerList");
            return (Criteria) this;
        }

        public Criteria andPokerListLessThanOrEqualTo(String value) {
            addCriterion("poker_list <=", value, "pokerList");
            return (Criteria) this;
        }

        public Criteria andPokerListLike(String value) {
            addCriterion("poker_list like", value, "pokerList");
            return (Criteria) this;
        }

        public Criteria andPokerListNotLike(String value) {
            addCriterion("poker_list not like", value, "pokerList");
            return (Criteria) this;
        }

        public Criteria andPokerListIn(List<String> values) {
            addCriterion("poker_list in", values, "pokerList");
            return (Criteria) this;
        }

        public Criteria andPokerListNotIn(List<String> values) {
            addCriterion("poker_list not in", values, "pokerList");
            return (Criteria) this;
        }

        public Criteria andPokerListBetween(String value1, String value2) {
            addCriterion("poker_list between", value1, value2, "pokerList");
            return (Criteria) this;
        }

        public Criteria andPokerListNotBetween(String value1, String value2) {
            addCriterion("poker_list not between", value1, value2, "pokerList");
            return (Criteria) this;
        }

        public Criteria andStakeAmountIsNull() {
            addCriterion("stake_amount is null");
            return (Criteria) this;
        }

        public Criteria andStakeAmountIsNotNull() {
            addCriterion("stake_amount is not null");
            return (Criteria) this;
        }

        public Criteria andStakeAmountEqualTo(BigDecimal value) {
            addCriterion("stake_amount =", value, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountNotEqualTo(BigDecimal value) {
            addCriterion("stake_amount <>", value, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountGreaterThan(BigDecimal value) {
            addCriterion("stake_amount >", value, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stake_amount >=", value, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountLessThan(BigDecimal value) {
            addCriterion("stake_amount <", value, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stake_amount <=", value, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountIn(List<BigDecimal> values) {
            addCriterion("stake_amount in", values, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountNotIn(List<BigDecimal> values) {
            addCriterion("stake_amount not in", values, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stake_amount between", value1, value2, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stake_amount not between", value1, value2, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andValidStakeIsNull() {
            addCriterion("valid_stake is null");
            return (Criteria) this;
        }

        public Criteria andValidStakeIsNotNull() {
            addCriterion("valid_stake is not null");
            return (Criteria) this;
        }

        public Criteria andValidStakeEqualTo(BigDecimal value) {
            addCriterion("valid_stake =", value, "validStake");
            return (Criteria) this;
        }

        public Criteria andValidStakeNotEqualTo(BigDecimal value) {
            addCriterion("valid_stake <>", value, "validStake");
            return (Criteria) this;
        }

        public Criteria andValidStakeGreaterThan(BigDecimal value) {
            addCriterion("valid_stake >", value, "validStake");
            return (Criteria) this;
        }

        public Criteria andValidStakeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("valid_stake >=", value, "validStake");
            return (Criteria) this;
        }

        public Criteria andValidStakeLessThan(BigDecimal value) {
            addCriterion("valid_stake <", value, "validStake");
            return (Criteria) this;
        }

        public Criteria andValidStakeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("valid_stake <=", value, "validStake");
            return (Criteria) this;
        }

        public Criteria andValidStakeIn(List<BigDecimal> values) {
            addCriterion("valid_stake in", values, "validStake");
            return (Criteria) this;
        }

        public Criteria andValidStakeNotIn(List<BigDecimal> values) {
            addCriterion("valid_stake not in", values, "validStake");
            return (Criteria) this;
        }

        public Criteria andValidStakeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("valid_stake between", value1, value2, "validStake");
            return (Criteria) this;
        }

        public Criteria andValidStakeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("valid_stake not between", value1, value2, "validStake");
            return (Criteria) this;
        }

        public Criteria andWinLossIsNull() {
            addCriterion("win_loss is null");
            return (Criteria) this;
        }

        public Criteria andWinLossIsNotNull() {
            addCriterion("win_loss is not null");
            return (Criteria) this;
        }

        public Criteria andWinLossEqualTo(BigDecimal value) {
            addCriterion("win_loss =", value, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossNotEqualTo(BigDecimal value) {
            addCriterion("win_loss <>", value, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossGreaterThan(BigDecimal value) {
            addCriterion("win_loss >", value, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("win_loss >=", value, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossLessThan(BigDecimal value) {
            addCriterion("win_loss <", value, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossLessThanOrEqualTo(BigDecimal value) {
            addCriterion("win_loss <=", value, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossIn(List<BigDecimal> values) {
            addCriterion("win_loss in", values, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossNotIn(List<BigDecimal> values) {
            addCriterion("win_loss not in", values, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("win_loss between", value1, value2, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("win_loss not between", value1, value2, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossTypeIsNull() {
            addCriterion("win_loss_type is null");
            return (Criteria) this;
        }

        public Criteria andWinLossTypeIsNotNull() {
            addCriterion("win_loss_type is not null");
            return (Criteria) this;
        }

        public Criteria andWinLossTypeEqualTo(Byte value) {
            addCriterion("win_loss_type =", value, "winLossType");
            return (Criteria) this;
        }

        public Criteria andWinLossTypeNotEqualTo(Byte value) {
            addCriterion("win_loss_type <>", value, "winLossType");
            return (Criteria) this;
        }

        public Criteria andWinLossTypeGreaterThan(Byte value) {
            addCriterion("win_loss_type >", value, "winLossType");
            return (Criteria) this;
        }

        public Criteria andWinLossTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("win_loss_type >=", value, "winLossType");
            return (Criteria) this;
        }

        public Criteria andWinLossTypeLessThan(Byte value) {
            addCriterion("win_loss_type <", value, "winLossType");
            return (Criteria) this;
        }

        public Criteria andWinLossTypeLessThanOrEqualTo(Byte value) {
            addCriterion("win_loss_type <=", value, "winLossType");
            return (Criteria) this;
        }

        public Criteria andWinLossTypeIn(List<Byte> values) {
            addCriterion("win_loss_type in", values, "winLossType");
            return (Criteria) this;
        }

        public Criteria andWinLossTypeNotIn(List<Byte> values) {
            addCriterion("win_loss_type not in", values, "winLossType");
            return (Criteria) this;
        }

        public Criteria andWinLossTypeBetween(Byte value1, Byte value2) {
            addCriterion("win_loss_type between", value1, value2, "winLossType");
            return (Criteria) this;
        }

        public Criteria andWinLossTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("win_loss_type not between", value1, value2, "winLossType");
            return (Criteria) this;
        }

        public Criteria andCommIsNull() {
            addCriterion("comm is null");
            return (Criteria) this;
        }

        public Criteria andCommIsNotNull() {
            addCriterion("comm is not null");
            return (Criteria) this;
        }

        public Criteria andCommEqualTo(BigDecimal value) {
            addCriterion("comm =", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotEqualTo(BigDecimal value) {
            addCriterion("comm <>", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommGreaterThan(BigDecimal value) {
            addCriterion("comm >", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("comm >=", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLessThan(BigDecimal value) {
            addCriterion("comm <", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLessThanOrEqualTo(BigDecimal value) {
            addCriterion("comm <=", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommIn(List<BigDecimal> values) {
            addCriterion("comm in", values, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotIn(List<BigDecimal> values) {
            addCriterion("comm not in", values, "comm");
            return (Criteria) this;
        }

        public Criteria andCommBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm between", value1, value2, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm not between", value1, value2, "comm");
            return (Criteria) this;
        }

        public Criteria andBalanceAfterIsNull() {
            addCriterion("balance_after is null");
            return (Criteria) this;
        }

        public Criteria andBalanceAfterIsNotNull() {
            addCriterion("balance_after is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceAfterEqualTo(BigDecimal value) {
            addCriterion("balance_after =", value, "balanceAfter");
            return (Criteria) this;
        }

        public Criteria andBalanceAfterNotEqualTo(BigDecimal value) {
            addCriterion("balance_after <>", value, "balanceAfter");
            return (Criteria) this;
        }

        public Criteria andBalanceAfterGreaterThan(BigDecimal value) {
            addCriterion("balance_after >", value, "balanceAfter");
            return (Criteria) this;
        }

        public Criteria andBalanceAfterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_after >=", value, "balanceAfter");
            return (Criteria) this;
        }

        public Criteria andBalanceAfterLessThan(BigDecimal value) {
            addCriterion("balance_after <", value, "balanceAfter");
            return (Criteria) this;
        }

        public Criteria andBalanceAfterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_after <=", value, "balanceAfter");
            return (Criteria) this;
        }

        public Criteria andBalanceAfterIn(List<BigDecimal> values) {
            addCriterion("balance_after in", values, "balanceAfter");
            return (Criteria) this;
        }

        public Criteria andBalanceAfterNotIn(List<BigDecimal> values) {
            addCriterion("balance_after not in", values, "balanceAfter");
            return (Criteria) this;
        }

        public Criteria andBalanceAfterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_after between", value1, value2, "balanceAfter");
            return (Criteria) this;
        }

        public Criteria andBalanceAfterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_after not between", value1, value2, "balanceAfter");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andAdjustmentTimeIsNull() {
            addCriterion("adjustment_time is null");
            return (Criteria) this;
        }

        public Criteria andAdjustmentTimeIsNotNull() {
            addCriterion("adjustment_time is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustmentTimeEqualTo(Date value) {
            addCriterion("adjustment_time =", value, "adjustmentTime");
            return (Criteria) this;
        }

        public Criteria andAdjustmentTimeNotEqualTo(Date value) {
            addCriterion("adjustment_time <>", value, "adjustmentTime");
            return (Criteria) this;
        }

        public Criteria andAdjustmentTimeGreaterThan(Date value) {
            addCriterion("adjustment_time >", value, "adjustmentTime");
            return (Criteria) this;
        }

        public Criteria andAdjustmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("adjustment_time >=", value, "adjustmentTime");
            return (Criteria) this;
        }

        public Criteria andAdjustmentTimeLessThan(Date value) {
            addCriterion("adjustment_time <", value, "adjustmentTime");
            return (Criteria) this;
        }

        public Criteria andAdjustmentTimeLessThanOrEqualTo(Date value) {
            addCriterion("adjustment_time <=", value, "adjustmentTime");
            return (Criteria) this;
        }

        public Criteria andAdjustmentTimeIn(List<Date> values) {
            addCriterion("adjustment_time in", values, "adjustmentTime");
            return (Criteria) this;
        }

        public Criteria andAdjustmentTimeNotIn(List<Date> values) {
            addCriterion("adjustment_time not in", values, "adjustmentTime");
            return (Criteria) this;
        }

        public Criteria andAdjustmentTimeBetween(Date value1, Date value2) {
            addCriterion("adjustment_time between", value1, value2, "adjustmentTime");
            return (Criteria) this;
        }

        public Criteria andAdjustmentTimeNotBetween(Date value1, Date value2) {
            addCriterion("adjustment_time not between", value1, value2, "adjustmentTime");
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

        public Criteria andResultImgNameIsNull() {
            addCriterion("result_img_name is null");
            return (Criteria) this;
        }

        public Criteria andResultImgNameIsNotNull() {
            addCriterion("result_img_name is not null");
            return (Criteria) this;
        }

        public Criteria andResultImgNameEqualTo(String value) {
            addCriterion("result_img_name =", value, "resultImgName");
            return (Criteria) this;
        }

        public Criteria andResultImgNameNotEqualTo(String value) {
            addCriterion("result_img_name <>", value, "resultImgName");
            return (Criteria) this;
        }

        public Criteria andResultImgNameGreaterThan(String value) {
            addCriterion("result_img_name >", value, "resultImgName");
            return (Criteria) this;
        }

        public Criteria andResultImgNameGreaterThanOrEqualTo(String value) {
            addCriterion("result_img_name >=", value, "resultImgName");
            return (Criteria) this;
        }

        public Criteria andResultImgNameLessThan(String value) {
            addCriterion("result_img_name <", value, "resultImgName");
            return (Criteria) this;
        }

        public Criteria andResultImgNameLessThanOrEqualTo(String value) {
            addCriterion("result_img_name <=", value, "resultImgName");
            return (Criteria) this;
        }

        public Criteria andResultImgNameLike(String value) {
            addCriterion("result_img_name like", value, "resultImgName");
            return (Criteria) this;
        }

        public Criteria andResultImgNameNotLike(String value) {
            addCriterion("result_img_name not like", value, "resultImgName");
            return (Criteria) this;
        }

        public Criteria andResultImgNameIn(List<String> values) {
            addCriterion("result_img_name in", values, "resultImgName");
            return (Criteria) this;
        }

        public Criteria andResultImgNameNotIn(List<String> values) {
            addCriterion("result_img_name not in", values, "resultImgName");
            return (Criteria) this;
        }

        public Criteria andResultImgNameBetween(String value1, String value2) {
            addCriterion("result_img_name between", value1, value2, "resultImgName");
            return (Criteria) this;
        }

        public Criteria andResultImgNameNotBetween(String value1, String value2) {
            addCriterion("result_img_name not between", value1, value2, "resultImgName");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Byte value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Byte value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Byte value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Byte value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Byte value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Byte> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Byte> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Byte value1, Byte value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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
}
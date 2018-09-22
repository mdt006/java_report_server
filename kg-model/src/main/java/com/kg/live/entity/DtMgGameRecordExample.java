package com.kg.live.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtMgGameRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DtMgGameRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
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

        public Criteria andMgIdIsNull() {
            addCriterion("mg_id is null");
            return (Criteria) this;
        }

        public Criteria andMgIdIsNotNull() {
            addCriterion("mg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMgIdEqualTo(String value) {
            addCriterion("mg_id =", value, "mgId");
            return (Criteria) this;
        }

        public Criteria andMgIdNotEqualTo(String value) {
            addCriterion("mg_id <>", value, "mgId");
            return (Criteria) this;
        }

        public Criteria andMgIdGreaterThan(String value) {
            addCriterion("mg_id >", value, "mgId");
            return (Criteria) this;
        }

        public Criteria andMgIdGreaterThanOrEqualTo(String value) {
            addCriterion("mg_id >=", value, "mgId");
            return (Criteria) this;
        }

        public Criteria andMgIdLessThan(String value) {
            addCriterion("mg_id <", value, "mgId");
            return (Criteria) this;
        }

        public Criteria andMgIdLessThanOrEqualTo(String value) {
            addCriterion("mg_id <=", value, "mgId");
            return (Criteria) this;
        }

        public Criteria andMgIdLike(String value) {
            addCriterion("mg_id like", value, "mgId");
            return (Criteria) this;
        }

        public Criteria andMgIdNotLike(String value) {
            addCriterion("mg_id not like", value, "mgId");
            return (Criteria) this;
        }

        public Criteria andMgIdIn(List<String> values) {
            addCriterion("mg_id in", values, "mgId");
            return (Criteria) this;
        }

        public Criteria andMgIdNotIn(List<String> values) {
            addCriterion("mg_id not in", values, "mgId");
            return (Criteria) this;
        }

        public Criteria andMgIdBetween(String value1, String value2) {
            addCriterion("mg_id between", value1, value2, "mgId");
            return (Criteria) this;
        }

        public Criteria andMgIdNotBetween(String value1, String value2) {
            addCriterion("mg_id not between", value1, value2, "mgId");
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

        public Criteria andPlayernameIsNull() {
            addCriterion("playername is null");
            return (Criteria) this;
        }

        public Criteria andPlayernameIsNotNull() {
            addCriterion("playername is not null");
            return (Criteria) this;
        }

        public Criteria andPlayernameEqualTo(String value) {
            addCriterion("playername =", value, "playername");
            return (Criteria) this;
        }

        public Criteria andPlayernameNotEqualTo(String value) {
            addCriterion("playername <>", value, "playername");
            return (Criteria) this;
        }

        public Criteria andPlayernameGreaterThan(String value) {
            addCriterion("playername >", value, "playername");
            return (Criteria) this;
        }

        public Criteria andPlayernameGreaterThanOrEqualTo(String value) {
            addCriterion("playername >=", value, "playername");
            return (Criteria) this;
        }

        public Criteria andPlayernameLessThan(String value) {
            addCriterion("playername <", value, "playername");
            return (Criteria) this;
        }

        public Criteria andPlayernameLessThanOrEqualTo(String value) {
            addCriterion("playername <=", value, "playername");
            return (Criteria) this;
        }

        public Criteria andPlayernameLike(String value) {
            addCriterion("playername like", value, "playername");
            return (Criteria) this;
        }

        public Criteria andPlayernameNotLike(String value) {
            addCriterion("playername not like", value, "playername");
            return (Criteria) this;
        }

        public Criteria andPlayernameIn(List<String> values) {
            addCriterion("playername in", values, "playername");
            return (Criteria) this;
        }

        public Criteria andPlayernameNotIn(List<String> values) {
            addCriterion("playername not in", values, "playername");
            return (Criteria) this;
        }

        public Criteria andPlayernameBetween(String value1, String value2) {
            addCriterion("playername between", value1, value2, "playername");
            return (Criteria) this;
        }

        public Criteria andPlayernameNotBetween(String value1, String value2) {
            addCriterion("playername not between", value1, value2, "playername");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andValidateAmountIsNull() {
            addCriterion("validate_amount is null");
            return (Criteria) this;
        }

        public Criteria andValidateAmountIsNotNull() {
            addCriterion("validate_amount is not null");
            return (Criteria) this;
        }

        public Criteria andValidateAmountEqualTo(BigDecimal value) {
            addCriterion("validate_amount =", value, "validateAmount");
            return (Criteria) this;
        }

        public Criteria andValidateAmountNotEqualTo(BigDecimal value) {
            addCriterion("validate_amount <>", value, "validateAmount");
            return (Criteria) this;
        }

        public Criteria andValidateAmountGreaterThan(BigDecimal value) {
            addCriterion("validate_amount >", value, "validateAmount");
            return (Criteria) this;
        }

        public Criteria andValidateAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("validate_amount >=", value, "validateAmount");
            return (Criteria) this;
        }

        public Criteria andValidateAmountLessThan(BigDecimal value) {
            addCriterion("validate_amount <", value, "validateAmount");
            return (Criteria) this;
        }

        public Criteria andValidateAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("validate_amount <=", value, "validateAmount");
            return (Criteria) this;
        }

        public Criteria andValidateAmountIn(List<BigDecimal> values) {
            addCriterion("validate_amount in", values, "validateAmount");
            return (Criteria) this;
        }

        public Criteria andValidateAmountNotIn(List<BigDecimal> values) {
            addCriterion("validate_amount not in", values, "validateAmount");
            return (Criteria) this;
        }

        public Criteria andValidateAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("validate_amount between", value1, value2, "validateAmount");
            return (Criteria) this;
        }

        public Criteria andValidateAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("validate_amount not between", value1, value2, "validateAmount");
            return (Criteria) this;
        }

        public Criteria andPayoffIsNull() {
            addCriterion("payoff is null");
            return (Criteria) this;
        }

        public Criteria andPayoffIsNotNull() {
            addCriterion("payoff is not null");
            return (Criteria) this;
        }

        public Criteria andPayoffEqualTo(BigDecimal value) {
            addCriterion("payoff =", value, "payoff");
            return (Criteria) this;
        }

        public Criteria andPayoffNotEqualTo(BigDecimal value) {
            addCriterion("payoff <>", value, "payoff");
            return (Criteria) this;
        }

        public Criteria andPayoffGreaterThan(BigDecimal value) {
            addCriterion("payoff >", value, "payoff");
            return (Criteria) this;
        }

        public Criteria andPayoffGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payoff >=", value, "payoff");
            return (Criteria) this;
        }

        public Criteria andPayoffLessThan(BigDecimal value) {
            addCriterion("payoff <", value, "payoff");
            return (Criteria) this;
        }

        public Criteria andPayoffLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payoff <=", value, "payoff");
            return (Criteria) this;
        }

        public Criteria andPayoffIn(List<BigDecimal> values) {
            addCriterion("payoff in", values, "payoff");
            return (Criteria) this;
        }

        public Criteria andPayoffNotIn(List<BigDecimal> values) {
            addCriterion("payoff not in", values, "payoff");
            return (Criteria) this;
        }

        public Criteria andPayoffBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payoff between", value1, value2, "payoff");
            return (Criteria) this;
        }

        public Criteria andPayoffNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payoff not between", value1, value2, "payoff");
            return (Criteria) this;
        }

        public Criteria andWinLoseTypeIsNull() {
            addCriterion("win_lose_type is null");
            return (Criteria) this;
        }

        public Criteria andWinLoseTypeIsNotNull() {
            addCriterion("win_lose_type is not null");
            return (Criteria) this;
        }

        public Criteria andWinLoseTypeEqualTo(Integer value) {
            addCriterion("win_lose_type =", value, "winLoseType");
            return (Criteria) this;
        }

        public Criteria andWinLoseTypeNotEqualTo(Integer value) {
            addCriterion("win_lose_type <>", value, "winLoseType");
            return (Criteria) this;
        }

        public Criteria andWinLoseTypeGreaterThan(Integer value) {
            addCriterion("win_lose_type >", value, "winLoseType");
            return (Criteria) this;
        }

        public Criteria andWinLoseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("win_lose_type >=", value, "winLoseType");
            return (Criteria) this;
        }

        public Criteria andWinLoseTypeLessThan(Integer value) {
            addCriterion("win_lose_type <", value, "winLoseType");
            return (Criteria) this;
        }

        public Criteria andWinLoseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("win_lose_type <=", value, "winLoseType");
            return (Criteria) this;
        }

        public Criteria andWinLoseTypeIn(List<Integer> values) {
            addCriterion("win_lose_type in", values, "winLoseType");
            return (Criteria) this;
        }

        public Criteria andWinLoseTypeNotIn(List<Integer> values) {
            addCriterion("win_lose_type not in", values, "winLoseType");
            return (Criteria) this;
        }

        public Criteria andWinLoseTypeBetween(Integer value1, Integer value2) {
            addCriterion("win_lose_type between", value1, value2, "winLoseType");
            return (Criteria) this;
        }

        public Criteria andWinLoseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("win_lose_type not between", value1, value2, "winLoseType");
            return (Criteria) this;
        }

        public Criteria andSumOfRefundIsNull() {
            addCriterion("sum_of_refund is null");
            return (Criteria) this;
        }

        public Criteria andSumOfRefundIsNotNull() {
            addCriterion("sum_of_refund is not null");
            return (Criteria) this;
        }

        public Criteria andSumOfRefundEqualTo(BigDecimal value) {
            addCriterion("sum_of_refund =", value, "sumOfRefund");
            return (Criteria) this;
        }

        public Criteria andSumOfRefundNotEqualTo(BigDecimal value) {
            addCriterion("sum_of_refund <>", value, "sumOfRefund");
            return (Criteria) this;
        }

        public Criteria andSumOfRefundGreaterThan(BigDecimal value) {
            addCriterion("sum_of_refund >", value, "sumOfRefund");
            return (Criteria) this;
        }

        public Criteria andSumOfRefundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sum_of_refund >=", value, "sumOfRefund");
            return (Criteria) this;
        }

        public Criteria andSumOfRefundLessThan(BigDecimal value) {
            addCriterion("sum_of_refund <", value, "sumOfRefund");
            return (Criteria) this;
        }

        public Criteria andSumOfRefundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sum_of_refund <=", value, "sumOfRefund");
            return (Criteria) this;
        }

        public Criteria andSumOfRefundIn(List<BigDecimal> values) {
            addCriterion("sum_of_refund in", values, "sumOfRefund");
            return (Criteria) this;
        }

        public Criteria andSumOfRefundNotIn(List<BigDecimal> values) {
            addCriterion("sum_of_refund not in", values, "sumOfRefund");
            return (Criteria) this;
        }

        public Criteria andSumOfRefundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sum_of_refund between", value1, value2, "sumOfRefund");
            return (Criteria) this;
        }

        public Criteria andSumOfRefundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sum_of_refund not between", value1, value2, "sumOfRefund");
            return (Criteria) this;
        }

        public Criteria andMgStatusIsNull() {
            addCriterion("mg_status is null");
            return (Criteria) this;
        }

        public Criteria andMgStatusIsNotNull() {
            addCriterion("mg_status is not null");
            return (Criteria) this;
        }

        public Criteria andMgStatusEqualTo(String value) {
            addCriterion("mg_status =", value, "mgStatus");
            return (Criteria) this;
        }

        public Criteria andMgStatusNotEqualTo(String value) {
            addCriterion("mg_status <>", value, "mgStatus");
            return (Criteria) this;
        }

        public Criteria andMgStatusGreaterThan(String value) {
            addCriterion("mg_status >", value, "mgStatus");
            return (Criteria) this;
        }

        public Criteria andMgStatusGreaterThanOrEqualTo(String value) {
            addCriterion("mg_status >=", value, "mgStatus");
            return (Criteria) this;
        }

        public Criteria andMgStatusLessThan(String value) {
            addCriterion("mg_status <", value, "mgStatus");
            return (Criteria) this;
        }

        public Criteria andMgStatusLessThanOrEqualTo(String value) {
            addCriterion("mg_status <=", value, "mgStatus");
            return (Criteria) this;
        }

        public Criteria andMgStatusLike(String value) {
            addCriterion("mg_status like", value, "mgStatus");
            return (Criteria) this;
        }

        public Criteria andMgStatusNotLike(String value) {
            addCriterion("mg_status not like", value, "mgStatus");
            return (Criteria) this;
        }

        public Criteria andMgStatusIn(List<String> values) {
            addCriterion("mg_status in", values, "mgStatus");
            return (Criteria) this;
        }

        public Criteria andMgStatusNotIn(List<String> values) {
            addCriterion("mg_status not in", values, "mgStatus");
            return (Criteria) this;
        }

        public Criteria andMgStatusBetween(String value1, String value2) {
            addCriterion("mg_status between", value1, value2, "mgStatus");
            return (Criteria) this;
        }

        public Criteria andMgStatusNotBetween(String value1, String value2) {
            addCriterion("mg_status not between", value1, value2, "mgStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNull() {
            addCriterion("application_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNotNull() {
            addCriterion("application_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdEqualTo(String value) {
            addCriterion("application_id =", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotEqualTo(String value) {
            addCriterion("application_id <>", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThan(String value) {
            addCriterion("application_id >", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThanOrEqualTo(String value) {
            addCriterion("application_id >=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThan(String value) {
            addCriterion("application_id <", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThanOrEqualTo(String value) {
            addCriterion("application_id <=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLike(String value) {
            addCriterion("application_id like", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotLike(String value) {
            addCriterion("application_id not like", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIn(List<String> values) {
            addCriterion("application_id in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotIn(List<String> values) {
            addCriterion("application_id not in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdBetween(String value1, String value2) {
            addCriterion("application_id between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotBetween(String value1, String value2) {
            addCriterion("application_id not between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andGameCodeIsNull() {
            addCriterion("game_code is null");
            return (Criteria) this;
        }

        public Criteria andGameCodeIsNotNull() {
            addCriterion("game_code is not null");
            return (Criteria) this;
        }

        public Criteria andGameCodeEqualTo(String value) {
            addCriterion("game_code =", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeNotEqualTo(String value) {
            addCriterion("game_code <>", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeGreaterThan(String value) {
            addCriterion("game_code >", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeGreaterThanOrEqualTo(String value) {
            addCriterion("game_code >=", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeLessThan(String value) {
            addCriterion("game_code <", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeLessThanOrEqualTo(String value) {
            addCriterion("game_code <=", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeLike(String value) {
            addCriterion("game_code like", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeNotLike(String value) {
            addCriterion("game_code not like", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeIn(List<String> values) {
            addCriterion("game_code in", values, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeNotIn(List<String> values) {
            addCriterion("game_code not in", values, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeBetween(String value1, String value2) {
            addCriterion("game_code between", value1, value2, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeNotBetween(String value1, String value2) {
            addCriterion("game_code not between", value1, value2, "gameCode");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("account_id like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("account_id not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andWalletCodeIsNull() {
            addCriterion("wallet_code is null");
            return (Criteria) this;
        }

        public Criteria andWalletCodeIsNotNull() {
            addCriterion("wallet_code is not null");
            return (Criteria) this;
        }

        public Criteria andWalletCodeEqualTo(String value) {
            addCriterion("wallet_code =", value, "walletCode");
            return (Criteria) this;
        }

        public Criteria andWalletCodeNotEqualTo(String value) {
            addCriterion("wallet_code <>", value, "walletCode");
            return (Criteria) this;
        }

        public Criteria andWalletCodeGreaterThan(String value) {
            addCriterion("wallet_code >", value, "walletCode");
            return (Criteria) this;
        }

        public Criteria andWalletCodeGreaterThanOrEqualTo(String value) {
            addCriterion("wallet_code >=", value, "walletCode");
            return (Criteria) this;
        }

        public Criteria andWalletCodeLessThan(String value) {
            addCriterion("wallet_code <", value, "walletCode");
            return (Criteria) this;
        }

        public Criteria andWalletCodeLessThanOrEqualTo(String value) {
            addCriterion("wallet_code <=", value, "walletCode");
            return (Criteria) this;
        }

        public Criteria andWalletCodeLike(String value) {
            addCriterion("wallet_code like", value, "walletCode");
            return (Criteria) this;
        }

        public Criteria andWalletCodeNotLike(String value) {
            addCriterion("wallet_code not like", value, "walletCode");
            return (Criteria) this;
        }

        public Criteria andWalletCodeIn(List<String> values) {
            addCriterion("wallet_code in", values, "walletCode");
            return (Criteria) this;
        }

        public Criteria andWalletCodeNotIn(List<String> values) {
            addCriterion("wallet_code not in", values, "walletCode");
            return (Criteria) this;
        }

        public Criteria andWalletCodeBetween(String value1, String value2) {
            addCriterion("wallet_code between", value1, value2, "walletCode");
            return (Criteria) this;
        }

        public Criteria andWalletCodeNotBetween(String value1, String value2) {
            addCriterion("wallet_code not between", value1, value2, "walletCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIsNull() {
            addCriterion("currency_unit is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIsNotNull() {
            addCriterion("currency_unit is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitEqualTo(String value) {
            addCriterion("currency_unit =", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotEqualTo(String value) {
            addCriterion("currency_unit <>", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitGreaterThan(String value) {
            addCriterion("currency_unit >", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitGreaterThanOrEqualTo(String value) {
            addCriterion("currency_unit >=", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLessThan(String value) {
            addCriterion("currency_unit <", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLessThanOrEqualTo(String value) {
            addCriterion("currency_unit <=", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLike(String value) {
            addCriterion("currency_unit like", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotLike(String value) {
            addCriterion("currency_unit not like", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIn(List<String> values) {
            addCriterion("currency_unit in", values, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotIn(List<String> values) {
            addCriterion("currency_unit not in", values, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitBetween(String value1, String value2) {
            addCriterion("currency_unit between", value1, value2, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotBetween(String value1, String value2) {
            addCriterion("currency_unit not between", value1, value2, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andExternalRefIsNull() {
            addCriterion("external_ref is null");
            return (Criteria) this;
        }

        public Criteria andExternalRefIsNotNull() {
            addCriterion("external_ref is not null");
            return (Criteria) this;
        }

        public Criteria andExternalRefEqualTo(String value) {
            addCriterion("external_ref =", value, "externalRef");
            return (Criteria) this;
        }

        public Criteria andExternalRefNotEqualTo(String value) {
            addCriterion("external_ref <>", value, "externalRef");
            return (Criteria) this;
        }

        public Criteria andExternalRefGreaterThan(String value) {
            addCriterion("external_ref >", value, "externalRef");
            return (Criteria) this;
        }

        public Criteria andExternalRefGreaterThanOrEqualTo(String value) {
            addCriterion("external_ref >=", value, "externalRef");
            return (Criteria) this;
        }

        public Criteria andExternalRefLessThan(String value) {
            addCriterion("external_ref <", value, "externalRef");
            return (Criteria) this;
        }

        public Criteria andExternalRefLessThanOrEqualTo(String value) {
            addCriterion("external_ref <=", value, "externalRef");
            return (Criteria) this;
        }

        public Criteria andExternalRefLike(String value) {
            addCriterion("external_ref like", value, "externalRef");
            return (Criteria) this;
        }

        public Criteria andExternalRefNotLike(String value) {
            addCriterion("external_ref not like", value, "externalRef");
            return (Criteria) this;
        }

        public Criteria andExternalRefIn(List<String> values) {
            addCriterion("external_ref in", values, "externalRef");
            return (Criteria) this;
        }

        public Criteria andExternalRefNotIn(List<String> values) {
            addCriterion("external_ref not in", values, "externalRef");
            return (Criteria) this;
        }

        public Criteria andExternalRefBetween(String value1, String value2) {
            addCriterion("external_ref between", value1, value2, "externalRef");
            return (Criteria) this;
        }

        public Criteria andExternalRefNotBetween(String value1, String value2) {
            addCriterion("external_ref not between", value1, value2, "externalRef");
            return (Criteria) this;
        }

        public Criteria andBetTimeIsNull() {
            addCriterion("bet_time is null");
            return (Criteria) this;
        }

        public Criteria andBetTimeIsNotNull() {
            addCriterion("bet_time is not null");
            return (Criteria) this;
        }

        public Criteria andBetTimeEqualTo(Date value) {
            addCriterion("bet_time =", value, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeNotEqualTo(Date value) {
            addCriterion("bet_time <>", value, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeGreaterThan(Date value) {
            addCriterion("bet_time >", value, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bet_time >=", value, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeLessThan(Date value) {
            addCriterion("bet_time <", value, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeLessThanOrEqualTo(Date value) {
            addCriterion("bet_time <=", value, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeIn(List<Date> values) {
            addCriterion("bet_time in", values, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeNotIn(List<Date> values) {
            addCriterion("bet_time not in", values, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeBetween(Date value1, Date value2) {
            addCriterion("bet_time between", value1, value2, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeNotBetween(Date value1, Date value2) {
            addCriterion("bet_time not between", value1, value2, "betTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNull() {
            addCriterion("close_time is null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNotNull() {
            addCriterion("close_time is not null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeEqualTo(Date value) {
            addCriterion("close_time =", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotEqualTo(Date value) {
            addCriterion("close_time <>", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThan(Date value) {
            addCriterion("close_time >", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("close_time >=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThan(Date value) {
            addCriterion("close_time <", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThanOrEqualTo(Date value) {
            addCriterion("close_time <=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIn(List<Date> values) {
            addCriterion("close_time in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotIn(List<Date> values) {
            addCriterion("close_time not in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeBetween(Date value1, Date value2) {
            addCriterion("close_time between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotBetween(Date value1, Date value2) {
            addCriterion("close_time not between", value1, value2, "closeTime");
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
package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DsSgsLiveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    protected Integer page;

   	protected Integer pageLimit;

    public DsSgsLiveExample() {
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

        public Criteria andUgsBetIdIsNull() {
            addCriterion("ugs_bet_id is null");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdIsNotNull() {
            addCriterion("ugs_bet_id is not null");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdEqualTo(String value) {
            addCriterion("ugs_bet_id =", value, "ugsBetId");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdNotEqualTo(String value) {
            addCriterion("ugs_bet_id <>", value, "ugsBetId");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdGreaterThan(String value) {
            addCriterion("ugs_bet_id >", value, "ugsBetId");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdGreaterThanOrEqualTo(String value) {
            addCriterion("ugs_bet_id >=", value, "ugsBetId");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdLessThan(String value) {
            addCriterion("ugs_bet_id <", value, "ugsBetId");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdLessThanOrEqualTo(String value) {
            addCriterion("ugs_bet_id <=", value, "ugsBetId");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdLike(String value) {
            addCriterion("ugs_bet_id like", value, "ugsBetId");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdNotLike(String value) {
            addCriterion("ugs_bet_id not like", value, "ugsBetId");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdIn(List<String> values) {
            addCriterion("ugs_bet_id in", values, "ugsBetId");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdNotIn(List<String> values) {
            addCriterion("ugs_bet_id not in", values, "ugsBetId");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdBetween(String value1, String value2) {
            addCriterion("ugs_bet_id between", value1, value2, "ugsBetId");
            return (Criteria) this;
        }

        public Criteria andUgsBetIdNotBetween(String value1, String value2) {
            addCriterion("ugs_bet_id not between", value1, value2, "ugsBetId");
            return (Criteria) this;
        }

        public Criteria andTxidIsNull() {
            addCriterion("txid is null");
            return (Criteria) this;
        }

        public Criteria andTxidIsNotNull() {
            addCriterion("txid is not null");
            return (Criteria) this;
        }

        public Criteria andTxidEqualTo(String value) {
            addCriterion("txid =", value, "txid");
            return (Criteria) this;
        }

        public Criteria andTxidNotEqualTo(String value) {
            addCriterion("txid <>", value, "txid");
            return (Criteria) this;
        }

        public Criteria andTxidGreaterThan(String value) {
            addCriterion("txid >", value, "txid");
            return (Criteria) this;
        }

        public Criteria andTxidGreaterThanOrEqualTo(String value) {
            addCriterion("txid >=", value, "txid");
            return (Criteria) this;
        }

        public Criteria andTxidLessThan(String value) {
            addCriterion("txid <", value, "txid");
            return (Criteria) this;
        }

        public Criteria andTxidLessThanOrEqualTo(String value) {
            addCriterion("txid <=", value, "txid");
            return (Criteria) this;
        }

        public Criteria andTxidLike(String value) {
            addCriterion("txid like", value, "txid");
            return (Criteria) this;
        }

        public Criteria andTxidNotLike(String value) {
            addCriterion("txid not like", value, "txid");
            return (Criteria) this;
        }

        public Criteria andTxidIn(List<String> values) {
            addCriterion("txid in", values, "txid");
            return (Criteria) this;
        }

        public Criteria andTxidNotIn(List<String> values) {
            addCriterion("txid not in", values, "txid");
            return (Criteria) this;
        }

        public Criteria andTxidBetween(String value1, String value2) {
            addCriterion("txid between", value1, value2, "txid");
            return (Criteria) this;
        }

        public Criteria andTxidNotBetween(String value1, String value2) {
            addCriterion("txid not between", value1, value2, "txid");
            return (Criteria) this;
        }

        public Criteria andBetIdIsNull() {
            addCriterion("bet_id is null");
            return (Criteria) this;
        }

        public Criteria andBetIdIsNotNull() {
            addCriterion("bet_id is not null");
            return (Criteria) this;
        }

        public Criteria andBetIdEqualTo(String value) {
            addCriterion("bet_id =", value, "betId");
            return (Criteria) this;
        }

        public Criteria andBetIdNotEqualTo(String value) {
            addCriterion("bet_id <>", value, "betId");
            return (Criteria) this;
        }

        public Criteria andBetIdGreaterThan(String value) {
            addCriterion("bet_id >", value, "betId");
            return (Criteria) this;
        }

        public Criteria andBetIdGreaterThanOrEqualTo(String value) {
            addCriterion("bet_id >=", value, "betId");
            return (Criteria) this;
        }

        public Criteria andBetIdLessThan(String value) {
            addCriterion("bet_id <", value, "betId");
            return (Criteria) this;
        }

        public Criteria andBetIdLessThanOrEqualTo(String value) {
            addCriterion("bet_id <=", value, "betId");
            return (Criteria) this;
        }

        public Criteria andBetIdLike(String value) {
            addCriterion("bet_id like", value, "betId");
            return (Criteria) this;
        }

        public Criteria andBetIdNotLike(String value) {
            addCriterion("bet_id not like", value, "betId");
            return (Criteria) this;
        }

        public Criteria andBetIdIn(List<String> values) {
            addCriterion("bet_id in", values, "betId");
            return (Criteria) this;
        }

        public Criteria andBetIdNotIn(List<String> values) {
            addCriterion("bet_id not in", values, "betId");
            return (Criteria) this;
        }

        public Criteria andBetIdBetween(String value1, String value2) {
            addCriterion("bet_id between", value1, value2, "betId");
            return (Criteria) this;
        }

        public Criteria andBetIdNotBetween(String value1, String value2) {
            addCriterion("bet_id not between", value1, value2, "betId");
            return (Criteria) this;
        }

        public Criteria andBetOnIsNull() {
            addCriterion("bet_on is null");
            return (Criteria) this;
        }

        public Criteria andBetOnIsNotNull() {
            addCriterion("bet_on is not null");
            return (Criteria) this;
        }

        public Criteria andBetOnEqualTo(Date value) {
            addCriterion("bet_on =", value, "betOn");
            return (Criteria) this;
        }

        public Criteria andBetOnNotEqualTo(Date value) {
            addCriterion("bet_on <>", value, "betOn");
            return (Criteria) this;
        }

        public Criteria andBetOnGreaterThan(Date value) {
            addCriterion("bet_on >", value, "betOn");
            return (Criteria) this;
        }

        public Criteria andBetOnGreaterThanOrEqualTo(Date value) {
            addCriterion("bet_on >=", value, "betOn");
            return (Criteria) this;
        }

        public Criteria andBetOnLessThan(Date value) {
            addCriterion("bet_on <", value, "betOn");
            return (Criteria) this;
        }

        public Criteria andBetOnLessThanOrEqualTo(Date value) {
            addCriterion("bet_on <=", value, "betOn");
            return (Criteria) this;
        }

        public Criteria andBetOnIn(List<Date> values) {
            addCriterion("bet_on in", values, "betOn");
            return (Criteria) this;
        }

        public Criteria andBetOnNotIn(List<Date> values) {
            addCriterion("bet_on not in", values, "betOn");
            return (Criteria) this;
        }

        public Criteria andBetOnBetween(Date value1, Date value2) {
            addCriterion("bet_on between", value1, value2, "betOn");
            return (Criteria) this;
        }

        public Criteria andBetOnNotBetween(Date value1, Date value2) {
            addCriterion("bet_on not between", value1, value2, "betOn");
            return (Criteria) this;
        }

        public Criteria andBetClosedOnIsNull() {
            addCriterion("bet_closed_on is null");
            return (Criteria) this;
        }

        public Criteria andBetClosedOnIsNotNull() {
            addCriterion("bet_closed_on is not null");
            return (Criteria) this;
        }

        public Criteria andBetClosedOnEqualTo(Date value) {
            addCriterion("bet_closed_on =", value, "betClosedOn");
            return (Criteria) this;
        }

        public Criteria andBetClosedOnNotEqualTo(Date value) {
            addCriterion("bet_closed_on <>", value, "betClosedOn");
            return (Criteria) this;
        }

        public Criteria andBetClosedOnGreaterThan(Date value) {
            addCriterion("bet_closed_on >", value, "betClosedOn");
            return (Criteria) this;
        }

        public Criteria andBetClosedOnGreaterThanOrEqualTo(Date value) {
            addCriterion("bet_closed_on >=", value, "betClosedOn");
            return (Criteria) this;
        }

        public Criteria andBetClosedOnLessThan(Date value) {
            addCriterion("bet_closed_on <", value, "betClosedOn");
            return (Criteria) this;
        }

        public Criteria andBetClosedOnLessThanOrEqualTo(Date value) {
            addCriterion("bet_closed_on <=", value, "betClosedOn");
            return (Criteria) this;
        }

        public Criteria andBetClosedOnIn(List<Date> values) {
            addCriterion("bet_closed_on in", values, "betClosedOn");
            return (Criteria) this;
        }

        public Criteria andBetClosedOnNotIn(List<Date> values) {
            addCriterion("bet_closed_on not in", values, "betClosedOn");
            return (Criteria) this;
        }

        public Criteria andBetClosedOnBetween(Date value1, Date value2) {
            addCriterion("bet_closed_on between", value1, value2, "betClosedOn");
            return (Criteria) this;
        }

        public Criteria andBetClosedOnNotBetween(Date value1, Date value2) {
            addCriterion("bet_closed_on not between", value1, value2, "betClosedOn");
            return (Criteria) this;
        }

        public Criteria andBetUpdatedOnIsNull() {
            addCriterion("bet_updated_on is null");
            return (Criteria) this;
        }

        public Criteria andBetUpdatedOnIsNotNull() {
            addCriterion("bet_updated_on is not null");
            return (Criteria) this;
        }

        public Criteria andBetUpdatedOnEqualTo(Date value) {
            addCriterion("bet_updated_on =", value, "betUpdatedOn");
            return (Criteria) this;
        }

        public Criteria andBetUpdatedOnNotEqualTo(Date value) {
            addCriterion("bet_updated_on <>", value, "betUpdatedOn");
            return (Criteria) this;
        }

        public Criteria andBetUpdatedOnGreaterThan(Date value) {
            addCriterion("bet_updated_on >", value, "betUpdatedOn");
            return (Criteria) this;
        }

        public Criteria andBetUpdatedOnGreaterThanOrEqualTo(Date value) {
            addCriterion("bet_updated_on >=", value, "betUpdatedOn");
            return (Criteria) this;
        }

        public Criteria andBetUpdatedOnLessThan(Date value) {
            addCriterion("bet_updated_on <", value, "betUpdatedOn");
            return (Criteria) this;
        }

        public Criteria andBetUpdatedOnLessThanOrEqualTo(Date value) {
            addCriterion("bet_updated_on <=", value, "betUpdatedOn");
            return (Criteria) this;
        }

        public Criteria andBetUpdatedOnIn(List<Date> values) {
            addCriterion("bet_updated_on in", values, "betUpdatedOn");
            return (Criteria) this;
        }

        public Criteria andBetUpdatedOnNotIn(List<Date> values) {
            addCriterion("bet_updated_on not in", values, "betUpdatedOn");
            return (Criteria) this;
        }

        public Criteria andBetUpdatedOnBetween(Date value1, Date value2) {
            addCriterion("bet_updated_on between", value1, value2, "betUpdatedOn");
            return (Criteria) this;
        }

        public Criteria andBetUpdatedOnNotBetween(Date value1, Date value2) {
            addCriterion("bet_updated_on not between", value1, value2, "betUpdatedOn");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(Date value) {
            addCriterion("timestamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(Date value) {
            addCriterion("timestamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(Date value) {
            addCriterion("timestamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("timestamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(Date value) {
            addCriterion("timestamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(Date value) {
            addCriterion("timestamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<Date> values) {
            addCriterion("timestamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<Date> values) {
            addCriterion("timestamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(Date value1, Date value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(Date value1, Date value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andRoundidIsNull() {
            addCriterion("roundid is null");
            return (Criteria) this;
        }

        public Criteria andRoundidIsNotNull() {
            addCriterion("roundid is not null");
            return (Criteria) this;
        }

        public Criteria andRoundidEqualTo(String value) {
            addCriterion("roundid =", value, "roundid");
            return (Criteria) this;
        }

        public Criteria andRoundidNotEqualTo(String value) {
            addCriterion("roundid <>", value, "roundid");
            return (Criteria) this;
        }

        public Criteria andRoundidGreaterThan(String value) {
            addCriterion("roundid >", value, "roundid");
            return (Criteria) this;
        }

        public Criteria andRoundidGreaterThanOrEqualTo(String value) {
            addCriterion("roundid >=", value, "roundid");
            return (Criteria) this;
        }

        public Criteria andRoundidLessThan(String value) {
            addCriterion("roundid <", value, "roundid");
            return (Criteria) this;
        }

        public Criteria andRoundidLessThanOrEqualTo(String value) {
            addCriterion("roundid <=", value, "roundid");
            return (Criteria) this;
        }

        public Criteria andRoundidLike(String value) {
            addCriterion("roundid like", value, "roundid");
            return (Criteria) this;
        }

        public Criteria andRoundidNotLike(String value) {
            addCriterion("roundid not like", value, "roundid");
            return (Criteria) this;
        }

        public Criteria andRoundidIn(List<String> values) {
            addCriterion("roundid in", values, "roundid");
            return (Criteria) this;
        }

        public Criteria andRoundidNotIn(List<String> values) {
            addCriterion("roundid not in", values, "roundid");
            return (Criteria) this;
        }

        public Criteria andRoundidBetween(String value1, String value2) {
            addCriterion("roundid between", value1, value2, "roundid");
            return (Criteria) this;
        }

        public Criteria andRoundidNotBetween(String value1, String value2) {
            addCriterion("roundid not between", value1, value2, "roundid");
            return (Criteria) this;
        }

        public Criteria andRoundStatusIsNull() {
            addCriterion("round_status is null");
            return (Criteria) this;
        }

        public Criteria andRoundStatusIsNotNull() {
            addCriterion("round_status is not null");
            return (Criteria) this;
        }

        public Criteria andRoundStatusEqualTo(String value) {
            addCriterion("round_status =", value, "roundStatus");
            return (Criteria) this;
        }

        public Criteria andRoundStatusNotEqualTo(String value) {
            addCriterion("round_status <>", value, "roundStatus");
            return (Criteria) this;
        }

        public Criteria andRoundStatusGreaterThan(String value) {
            addCriterion("round_status >", value, "roundStatus");
            return (Criteria) this;
        }

        public Criteria andRoundStatusGreaterThanOrEqualTo(String value) {
            addCriterion("round_status >=", value, "roundStatus");
            return (Criteria) this;
        }

        public Criteria andRoundStatusLessThan(String value) {
            addCriterion("round_status <", value, "roundStatus");
            return (Criteria) this;
        }

        public Criteria andRoundStatusLessThanOrEqualTo(String value) {
            addCriterion("round_status <=", value, "roundStatus");
            return (Criteria) this;
        }

        public Criteria andRoundStatusLike(String value) {
            addCriterion("round_status like", value, "roundStatus");
            return (Criteria) this;
        }

        public Criteria andRoundStatusNotLike(String value) {
            addCriterion("round_status not like", value, "roundStatus");
            return (Criteria) this;
        }

        public Criteria andRoundStatusIn(List<String> values) {
            addCriterion("round_status in", values, "roundStatus");
            return (Criteria) this;
        }

        public Criteria andRoundStatusNotIn(List<String> values) {
            addCriterion("round_status not in", values, "roundStatus");
            return (Criteria) this;
        }

        public Criteria andRoundStatusBetween(String value1, String value2) {
            addCriterion("round_status between", value1, value2, "roundStatus");
            return (Criteria) this;
        }

        public Criteria andRoundStatusNotBetween(String value1, String value2) {
            addCriterion("round_status not between", value1, value2, "roundStatus");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
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

        public Criteria andRiskamtIsNull() {
            addCriterion("riskamt is null");
            return (Criteria) this;
        }

        public Criteria andRiskamtIsNotNull() {
            addCriterion("riskamt is not null");
            return (Criteria) this;
        }

        public Criteria andRiskamtEqualTo(BigDecimal value) {
            addCriterion("riskamt =", value, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtNotEqualTo(BigDecimal value) {
            addCriterion("riskamt <>", value, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtGreaterThan(BigDecimal value) {
            addCriterion("riskamt >", value, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("riskamt >=", value, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtLessThan(BigDecimal value) {
            addCriterion("riskamt <", value, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("riskamt <=", value, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtIn(List<BigDecimal> values) {
            addCriterion("riskamt in", values, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtNotIn(List<BigDecimal> values) {
            addCriterion("riskamt not in", values, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("riskamt between", value1, value2, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("riskamt not between", value1, value2, "riskamt");
            return (Criteria) this;
        }

        public Criteria andWinamtIsNull() {
            addCriterion("winamt is null");
            return (Criteria) this;
        }

        public Criteria andWinamtIsNotNull() {
            addCriterion("winamt is not null");
            return (Criteria) this;
        }

        public Criteria andWinamtEqualTo(BigDecimal value) {
            addCriterion("winamt =", value, "winamt");
            return (Criteria) this;
        }

        public Criteria andWinamtNotEqualTo(BigDecimal value) {
            addCriterion("winamt <>", value, "winamt");
            return (Criteria) this;
        }

        public Criteria andWinamtGreaterThan(BigDecimal value) {
            addCriterion("winamt >", value, "winamt");
            return (Criteria) this;
        }

        public Criteria andWinamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("winamt >=", value, "winamt");
            return (Criteria) this;
        }

        public Criteria andWinamtLessThan(BigDecimal value) {
            addCriterion("winamt <", value, "winamt");
            return (Criteria) this;
        }

        public Criteria andWinamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("winamt <=", value, "winamt");
            return (Criteria) this;
        }

        public Criteria andWinamtIn(List<BigDecimal> values) {
            addCriterion("winamt in", values, "winamt");
            return (Criteria) this;
        }

        public Criteria andWinamtNotIn(List<BigDecimal> values) {
            addCriterion("winamt not in", values, "winamt");
            return (Criteria) this;
        }

        public Criteria andWinamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("winamt between", value1, value2, "winamt");
            return (Criteria) this;
        }

        public Criteria andWinamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("winamt not between", value1, value2, "winamt");
            return (Criteria) this;
        }

        public Criteria andWinlossIsNull() {
            addCriterion("winloss is null");
            return (Criteria) this;
        }

        public Criteria andWinlossIsNotNull() {
            addCriterion("winloss is not null");
            return (Criteria) this;
        }

        public Criteria andWinlossEqualTo(BigDecimal value) {
            addCriterion("winloss =", value, "winloss");
            return (Criteria) this;
        }

        public Criteria andWinlossNotEqualTo(BigDecimal value) {
            addCriterion("winloss <>", value, "winloss");
            return (Criteria) this;
        }

        public Criteria andWinlossGreaterThan(BigDecimal value) {
            addCriterion("winloss >", value, "winloss");
            return (Criteria) this;
        }

        public Criteria andWinlossGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("winloss >=", value, "winloss");
            return (Criteria) this;
        }

        public Criteria andWinlossLessThan(BigDecimal value) {
            addCriterion("winloss <", value, "winloss");
            return (Criteria) this;
        }

        public Criteria andWinlossLessThanOrEqualTo(BigDecimal value) {
            addCriterion("winloss <=", value, "winloss");
            return (Criteria) this;
        }

        public Criteria andWinlossIn(List<BigDecimal> values) {
            addCriterion("winloss in", values, "winloss");
            return (Criteria) this;
        }

        public Criteria andWinlossNotIn(List<BigDecimal> values) {
            addCriterion("winloss not in", values, "winloss");
            return (Criteria) this;
        }

        public Criteria andWinlossBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("winloss between", value1, value2, "winloss");
            return (Criteria) this;
        }

        public Criteria andWinlossNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("winloss not between", value1, value2, "winloss");
            return (Criteria) this;
        }

        public Criteria andBeforebalIsNull() {
            addCriterion("beforebal is null");
            return (Criteria) this;
        }

        public Criteria andBeforebalIsNotNull() {
            addCriterion("beforebal is not null");
            return (Criteria) this;
        }

        public Criteria andBeforebalEqualTo(BigDecimal value) {
            addCriterion("beforebal =", value, "beforebal");
            return (Criteria) this;
        }

        public Criteria andBeforebalNotEqualTo(BigDecimal value) {
            addCriterion("beforebal <>", value, "beforebal");
            return (Criteria) this;
        }

        public Criteria andBeforebalGreaterThan(BigDecimal value) {
            addCriterion("beforebal >", value, "beforebal");
            return (Criteria) this;
        }

        public Criteria andBeforebalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("beforebal >=", value, "beforebal");
            return (Criteria) this;
        }

        public Criteria andBeforebalLessThan(BigDecimal value) {
            addCriterion("beforebal <", value, "beforebal");
            return (Criteria) this;
        }

        public Criteria andBeforebalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("beforebal <=", value, "beforebal");
            return (Criteria) this;
        }

        public Criteria andBeforebalIn(List<BigDecimal> values) {
            addCriterion("beforebal in", values, "beforebal");
            return (Criteria) this;
        }

        public Criteria andBeforebalNotIn(List<BigDecimal> values) {
            addCriterion("beforebal not in", values, "beforebal");
            return (Criteria) this;
        }

        public Criteria andBeforebalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("beforebal between", value1, value2, "beforebal");
            return (Criteria) this;
        }

        public Criteria andBeforebalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("beforebal not between", value1, value2, "beforebal");
            return (Criteria) this;
        }

        public Criteria andPostbalIsNull() {
            addCriterion("postbal is null");
            return (Criteria) this;
        }

        public Criteria andPostbalIsNotNull() {
            addCriterion("postbal is not null");
            return (Criteria) this;
        }

        public Criteria andPostbalEqualTo(BigDecimal value) {
            addCriterion("postbal =", value, "postbal");
            return (Criteria) this;
        }

        public Criteria andPostbalNotEqualTo(BigDecimal value) {
            addCriterion("postbal <>", value, "postbal");
            return (Criteria) this;
        }

        public Criteria andPostbalGreaterThan(BigDecimal value) {
            addCriterion("postbal >", value, "postbal");
            return (Criteria) this;
        }

        public Criteria andPostbalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("postbal >=", value, "postbal");
            return (Criteria) this;
        }

        public Criteria andPostbalLessThan(BigDecimal value) {
            addCriterion("postbal <", value, "postbal");
            return (Criteria) this;
        }

        public Criteria andPostbalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("postbal <=", value, "postbal");
            return (Criteria) this;
        }

        public Criteria andPostbalIn(List<BigDecimal> values) {
            addCriterion("postbal in", values, "postbal");
            return (Criteria) this;
        }

        public Criteria andPostbalNotIn(List<BigDecimal> values) {
            addCriterion("postbal not in", values, "postbal");
            return (Criteria) this;
        }

        public Criteria andPostbalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("postbal between", value1, value2, "postbal");
            return (Criteria) this;
        }

        public Criteria andPostbalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("postbal not between", value1, value2, "postbal");
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

        public Criteria andGameProviderIsNull() {
            addCriterion("game_provider is null");
            return (Criteria) this;
        }

        public Criteria andGameProviderIsNotNull() {
            addCriterion("game_provider is not null");
            return (Criteria) this;
        }

        public Criteria andGameProviderEqualTo(String value) {
            addCriterion("game_provider =", value, "gameProvider");
            return (Criteria) this;
        }

        public Criteria andGameProviderNotEqualTo(String value) {
            addCriterion("game_provider <>", value, "gameProvider");
            return (Criteria) this;
        }

        public Criteria andGameProviderGreaterThan(String value) {
            addCriterion("game_provider >", value, "gameProvider");
            return (Criteria) this;
        }

        public Criteria andGameProviderGreaterThanOrEqualTo(String value) {
            addCriterion("game_provider >=", value, "gameProvider");
            return (Criteria) this;
        }

        public Criteria andGameProviderLessThan(String value) {
            addCriterion("game_provider <", value, "gameProvider");
            return (Criteria) this;
        }

        public Criteria andGameProviderLessThanOrEqualTo(String value) {
            addCriterion("game_provider <=", value, "gameProvider");
            return (Criteria) this;
        }

        public Criteria andGameProviderLike(String value) {
            addCriterion("game_provider like", value, "gameProvider");
            return (Criteria) this;
        }

        public Criteria andGameProviderNotLike(String value) {
            addCriterion("game_provider not like", value, "gameProvider");
            return (Criteria) this;
        }

        public Criteria andGameProviderIn(List<String> values) {
            addCriterion("game_provider in", values, "gameProvider");
            return (Criteria) this;
        }

        public Criteria andGameProviderNotIn(List<String> values) {
            addCriterion("game_provider not in", values, "gameProvider");
            return (Criteria) this;
        }

        public Criteria andGameProviderBetween(String value1, String value2) {
            addCriterion("game_provider between", value1, value2, "gameProvider");
            return (Criteria) this;
        }

        public Criteria andGameProviderNotBetween(String value1, String value2) {
            addCriterion("game_provider not between", value1, value2, "gameProvider");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeIsNull() {
            addCriterion("game_provider_code is null");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeIsNotNull() {
            addCriterion("game_provider_code is not null");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeEqualTo(String value) {
            addCriterion("game_provider_code =", value, "gameProviderCode");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeNotEqualTo(String value) {
            addCriterion("game_provider_code <>", value, "gameProviderCode");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeGreaterThan(String value) {
            addCriterion("game_provider_code >", value, "gameProviderCode");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("game_provider_code >=", value, "gameProviderCode");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeLessThan(String value) {
            addCriterion("game_provider_code <", value, "gameProviderCode");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeLessThanOrEqualTo(String value) {
            addCriterion("game_provider_code <=", value, "gameProviderCode");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeLike(String value) {
            addCriterion("game_provider_code like", value, "gameProviderCode");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeNotLike(String value) {
            addCriterion("game_provider_code not like", value, "gameProviderCode");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeIn(List<String> values) {
            addCriterion("game_provider_code in", values, "gameProviderCode");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeNotIn(List<String> values) {
            addCriterion("game_provider_code not in", values, "gameProviderCode");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeBetween(String value1, String value2) {
            addCriterion("game_provider_code between", value1, value2, "gameProviderCode");
            return (Criteria) this;
        }

        public Criteria andGameProviderCodeNotBetween(String value1, String value2) {
            addCriterion("game_provider_code not between", value1, value2, "gameProviderCode");
            return (Criteria) this;
        }

        public Criteria andGameNameIsNull() {
            addCriterion("game_name is null");
            return (Criteria) this;
        }

        public Criteria andGameNameIsNotNull() {
            addCriterion("game_name is not null");
            return (Criteria) this;
        }

        public Criteria andGameNameEqualTo(String value) {
            addCriterion("game_name =", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotEqualTo(String value) {
            addCriterion("game_name <>", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameGreaterThan(String value) {
            addCriterion("game_name >", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameGreaterThanOrEqualTo(String value) {
            addCriterion("game_name >=", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameLessThan(String value) {
            addCriterion("game_name <", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameLessThanOrEqualTo(String value) {
            addCriterion("game_name <=", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameLike(String value) {
            addCriterion("game_name like", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotLike(String value) {
            addCriterion("game_name not like", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameIn(List<String> values) {
            addCriterion("game_name in", values, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotIn(List<String> values) {
            addCriterion("game_name not in", values, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameBetween(String value1, String value2) {
            addCriterion("game_name between", value1, value2, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotBetween(String value1, String value2) {
            addCriterion("game_name not between", value1, value2, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNull() {
            addCriterion("game_id is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("game_id is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(String value) {
            addCriterion("game_id =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(String value) {
            addCriterion("game_id <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(String value) {
            addCriterion("game_id >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(String value) {
            addCriterion("game_id >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(String value) {
            addCriterion("game_id <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(String value) {
            addCriterion("game_id <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLike(String value) {
            addCriterion("game_id like", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotLike(String value) {
            addCriterion("game_id not like", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<String> values) {
            addCriterion("game_id in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<String> values) {
            addCriterion("game_id not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(String value1, String value2) {
            addCriterion("game_id between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(String value1, String value2) {
            addCriterion("game_id not between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIsNull() {
            addCriterion("platform_type is null");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIsNotNull() {
            addCriterion("platform_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeEqualTo(String value) {
            addCriterion("platform_type =", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotEqualTo(String value) {
            addCriterion("platform_type <>", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeGreaterThan(String value) {
            addCriterion("platform_type >", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeGreaterThanOrEqualTo(String value) {
            addCriterion("platform_type >=", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeLessThan(String value) {
            addCriterion("platform_type <", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeLessThanOrEqualTo(String value) {
            addCriterion("platform_type <=", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeLike(String value) {
            addCriterion("platform_type like", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotLike(String value) {
            addCriterion("platform_type not like", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIn(List<String> values) {
            addCriterion("platform_type in", values, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotIn(List<String> values) {
            addCriterion("platform_type not in", values, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeBetween(String value1, String value2) {
            addCriterion("platform_type between", value1, value2, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotBetween(String value1, String value2) {
            addCriterion("platform_type not between", value1, value2, "platformType");
            return (Criteria) this;
        }

        public Criteria andIpAddressIsNull() {
            addCriterion("ip_address is null");
            return (Criteria) this;
        }

        public Criteria andIpAddressIsNotNull() {
            addCriterion("ip_address is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddressEqualTo(String value) {
            addCriterion("ip_address =", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotEqualTo(String value) {
            addCriterion("ip_address <>", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressGreaterThan(String value) {
            addCriterion("ip_address >", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ip_address >=", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLessThan(String value) {
            addCriterion("ip_address <", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLessThanOrEqualTo(String value) {
            addCriterion("ip_address <=", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLike(String value) {
            addCriterion("ip_address like", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotLike(String value) {
            addCriterion("ip_address not like", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressIn(List<String> values) {
            addCriterion("ip_address in", values, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotIn(List<String> values) {
            addCriterion("ip_address not in", values, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressBetween(String value1, String value2) {
            addCriterion("ip_address between", value1, value2, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotBetween(String value1, String value2) {
            addCriterion("ip_address not between", value1, value2, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andBetTypeIsNull() {
            addCriterion("bet_type is null");
            return (Criteria) this;
        }

        public Criteria andBetTypeIsNotNull() {
            addCriterion("bet_type is not null");
            return (Criteria) this;
        }

        public Criteria andBetTypeEqualTo(String value) {
            addCriterion("bet_type =", value, "betType");
            return (Criteria) this;
        }

        public Criteria andBetTypeNotEqualTo(String value) {
            addCriterion("bet_type <>", value, "betType");
            return (Criteria) this;
        }

        public Criteria andBetTypeGreaterThan(String value) {
            addCriterion("bet_type >", value, "betType");
            return (Criteria) this;
        }

        public Criteria andBetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bet_type >=", value, "betType");
            return (Criteria) this;
        }

        public Criteria andBetTypeLessThan(String value) {
            addCriterion("bet_type <", value, "betType");
            return (Criteria) this;
        }

        public Criteria andBetTypeLessThanOrEqualTo(String value) {
            addCriterion("bet_type <=", value, "betType");
            return (Criteria) this;
        }

        public Criteria andBetTypeLike(String value) {
            addCriterion("bet_type like", value, "betType");
            return (Criteria) this;
        }

        public Criteria andBetTypeNotLike(String value) {
            addCriterion("bet_type not like", value, "betType");
            return (Criteria) this;
        }

        public Criteria andBetTypeIn(List<String> values) {
            addCriterion("bet_type in", values, "betType");
            return (Criteria) this;
        }

        public Criteria andBetTypeNotIn(List<String> values) {
            addCriterion("bet_type not in", values, "betType");
            return (Criteria) this;
        }

        public Criteria andBetTypeBetween(String value1, String value2) {
            addCriterion("bet_type between", value1, value2, "betType");
            return (Criteria) this;
        }

        public Criteria andBetTypeNotBetween(String value1, String value2) {
            addCriterion("bet_type not between", value1, value2, "betType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNull() {
            addCriterion("play_type is null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNotNull() {
            addCriterion("play_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeEqualTo(String value) {
            addCriterion("play_type =", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotEqualTo(String value) {
            addCriterion("play_type <>", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThan(String value) {
            addCriterion("play_type >", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("play_type >=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThan(String value) {
            addCriterion("play_type <", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThanOrEqualTo(String value) {
            addCriterion("play_type <=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLike(String value) {
            addCriterion("play_type like", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotLike(String value) {
            addCriterion("play_type not like", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIn(List<String> values) {
            addCriterion("play_type in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotIn(List<String> values) {
            addCriterion("play_type not in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeBetween(String value1, String value2) {
            addCriterion("play_type between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotBetween(String value1, String value2) {
            addCriterion("play_type not between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayerTypeIsNull() {
            addCriterion("player_type is null");
            return (Criteria) this;
        }

        public Criteria andPlayerTypeIsNotNull() {
            addCriterion("player_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerTypeEqualTo(Byte value) {
            addCriterion("player_type =", value, "playerType");
            return (Criteria) this;
        }

        public Criteria andPlayerTypeNotEqualTo(Byte value) {
            addCriterion("player_type <>", value, "playerType");
            return (Criteria) this;
        }

        public Criteria andPlayerTypeGreaterThan(Byte value) {
            addCriterion("player_type >", value, "playerType");
            return (Criteria) this;
        }

        public Criteria andPlayerTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("player_type >=", value, "playerType");
            return (Criteria) this;
        }

        public Criteria andPlayerTypeLessThan(Byte value) {
            addCriterion("player_type <", value, "playerType");
            return (Criteria) this;
        }

        public Criteria andPlayerTypeLessThanOrEqualTo(Byte value) {
            addCriterion("player_type <=", value, "playerType");
            return (Criteria) this;
        }

        public Criteria andPlayerTypeIn(List<Byte> values) {
            addCriterion("player_type in", values, "playerType");
            return (Criteria) this;
        }

        public Criteria andPlayerTypeNotIn(List<Byte> values) {
            addCriterion("player_type not in", values, "playerType");
            return (Criteria) this;
        }

        public Criteria andPlayerTypeBetween(Byte value1, Byte value2) {
            addCriterion("player_type between", value1, value2, "playerType");
            return (Criteria) this;
        }

        public Criteria andPlayerTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("player_type not between", value1, value2, "playerType");
            return (Criteria) this;
        }

        public Criteria andTurnoverIsNull() {
            addCriterion("turnover is null");
            return (Criteria) this;
        }

        public Criteria andTurnoverIsNotNull() {
            addCriterion("turnover is not null");
            return (Criteria) this;
        }

        public Criteria andTurnoverEqualTo(BigDecimal value) {
            addCriterion("turnover =", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotEqualTo(BigDecimal value) {
            addCriterion("turnover <>", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverGreaterThan(BigDecimal value) {
            addCriterion("turnover >", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("turnover >=", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverLessThan(BigDecimal value) {
            addCriterion("turnover <", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverLessThanOrEqualTo(BigDecimal value) {
            addCriterion("turnover <=", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverIn(List<BigDecimal> values) {
            addCriterion("turnover in", values, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotIn(List<BigDecimal> values) {
            addCriterion("turnover not in", values, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("turnover between", value1, value2, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("turnover not between", value1, value2, "turnover");
            return (Criteria) this;
        }

        public Criteria andValidbetIsNull() {
            addCriterion("validbet is null");
            return (Criteria) this;
        }

        public Criteria andValidbetIsNotNull() {
            addCriterion("validbet is not null");
            return (Criteria) this;
        }

        public Criteria andValidbetEqualTo(BigDecimal value) {
            addCriterion("validbet =", value, "validbet");
            return (Criteria) this;
        }

        public Criteria andValidbetNotEqualTo(BigDecimal value) {
            addCriterion("validbet <>", value, "validbet");
            return (Criteria) this;
        }

        public Criteria andValidbetGreaterThan(BigDecimal value) {
            addCriterion("validbet >", value, "validbet");
            return (Criteria) this;
        }

        public Criteria andValidbetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("validbet >=", value, "validbet");
            return (Criteria) this;
        }

        public Criteria andValidbetLessThan(BigDecimal value) {
            addCriterion("validbet <", value, "validbet");
            return (Criteria) this;
        }

        public Criteria andValidbetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("validbet <=", value, "validbet");
            return (Criteria) this;
        }

        public Criteria andValidbetIn(List<BigDecimal> values) {
            addCriterion("validbet in", values, "validbet");
            return (Criteria) this;
        }

        public Criteria andValidbetNotIn(List<BigDecimal> values) {
            addCriterion("validbet not in", values, "validbet");
            return (Criteria) this;
        }

        public Criteria andValidbetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("validbet between", value1, value2, "validbet");
            return (Criteria) this;
        }

        public Criteria andValidbetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("validbet not between", value1, value2, "validbet");
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
    
}
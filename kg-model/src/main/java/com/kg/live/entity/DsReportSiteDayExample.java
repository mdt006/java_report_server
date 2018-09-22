package com.kg.live.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DsReportSiteDayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsReportSiteDayExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBetCountIsNull() {
            addCriterion("bet_count is null");
            return (Criteria) this;
        }

        public Criteria andBetCountIsNotNull() {
            addCriterion("bet_count is not null");
            return (Criteria) this;
        }

        public Criteria andBetCountEqualTo(Integer value) {
            addCriterion("bet_count =", value, "betCount");
            return (Criteria) this;
        }

        public Criteria andBetCountNotEqualTo(Integer value) {
            addCriterion("bet_count <>", value, "betCount");
            return (Criteria) this;
        }

        public Criteria andBetCountGreaterThan(Integer value) {
            addCriterion("bet_count >", value, "betCount");
            return (Criteria) this;
        }

        public Criteria andBetCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("bet_count >=", value, "betCount");
            return (Criteria) this;
        }

        public Criteria andBetCountLessThan(Integer value) {
            addCriterion("bet_count <", value, "betCount");
            return (Criteria) this;
        }

        public Criteria andBetCountLessThanOrEqualTo(Integer value) {
            addCriterion("bet_count <=", value, "betCount");
            return (Criteria) this;
        }

        public Criteria andBetCountIn(List<Integer> values) {
            addCriterion("bet_count in", values, "betCount");
            return (Criteria) this;
        }

        public Criteria andBetCountNotIn(List<Integer> values) {
            addCriterion("bet_count not in", values, "betCount");
            return (Criteria) this;
        }

        public Criteria andBetCountBetween(Integer value1, Integer value2) {
            addCriterion("bet_count between", value1, value2, "betCount");
            return (Criteria) this;
        }

        public Criteria andBetCountNotBetween(Integer value1, Integer value2) {
            addCriterion("bet_count not between", value1, value2, "betCount");
            return (Criteria) this;
        }

        public Criteria andBetamountIsNull() {
            addCriterion("betamount is null");
            return (Criteria) this;
        }

        public Criteria andBetamountIsNotNull() {
            addCriterion("betamount is not null");
            return (Criteria) this;
        }

        public Criteria andBetamountEqualTo(BigDecimal value) {
            addCriterion("betamount =", value, "betamount");
            return (Criteria) this;
        }

        public Criteria andBetamountNotEqualTo(BigDecimal value) {
            addCriterion("betamount <>", value, "betamount");
            return (Criteria) this;
        }

        public Criteria andBetamountGreaterThan(BigDecimal value) {
            addCriterion("betamount >", value, "betamount");
            return (Criteria) this;
        }

        public Criteria andBetamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("betamount >=", value, "betamount");
            return (Criteria) this;
        }

        public Criteria andBetamountLessThan(BigDecimal value) {
            addCriterion("betamount <", value, "betamount");
            return (Criteria) this;
        }

        public Criteria andBetamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("betamount <=", value, "betamount");
            return (Criteria) this;
        }

        public Criteria andBetamountIn(List<BigDecimal> values) {
            addCriterion("betamount in", values, "betamount");
            return (Criteria) this;
        }

        public Criteria andBetamountNotIn(List<BigDecimal> values) {
            addCriterion("betamount not in", values, "betamount");
            return (Criteria) this;
        }

        public Criteria andBetamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("betamount between", value1, value2, "betamount");
            return (Criteria) this;
        }

        public Criteria andBetamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("betamount not between", value1, value2, "betamount");
            return (Criteria) this;
        }

        public Criteria andWinloseIsNull() {
            addCriterion("winlose is null");
            return (Criteria) this;
        }

        public Criteria andWinloseIsNotNull() {
            addCriterion("winlose is not null");
            return (Criteria) this;
        }

        public Criteria andWinloseEqualTo(BigDecimal value) {
            addCriterion("winlose =", value, "winlose");
            return (Criteria) this;
        }

        public Criteria andWinloseNotEqualTo(BigDecimal value) {
            addCriterion("winlose <>", value, "winlose");
            return (Criteria) this;
        }

        public Criteria andWinloseGreaterThan(BigDecimal value) {
            addCriterion("winlose >", value, "winlose");
            return (Criteria) this;
        }

        public Criteria andWinloseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("winlose >=", value, "winlose");
            return (Criteria) this;
        }

        public Criteria andWinloseLessThan(BigDecimal value) {
            addCriterion("winlose <", value, "winlose");
            return (Criteria) this;
        }

        public Criteria andWinloseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("winlose <=", value, "winlose");
            return (Criteria) this;
        }

        public Criteria andWinloseIn(List<BigDecimal> values) {
            addCriterion("winlose in", values, "winlose");
            return (Criteria) this;
        }

        public Criteria andWinloseNotIn(List<BigDecimal> values) {
            addCriterion("winlose not in", values, "winlose");
            return (Criteria) this;
        }

        public Criteria andWinloseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("winlose between", value1, value2, "winlose");
            return (Criteria) this;
        }

        public Criteria andWinloseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("winlose not between", value1, value2, "winlose");
            return (Criteria) this;
        }

        public Criteria andValidamountIsNull() {
            addCriterion("validamount is null");
            return (Criteria) this;
        }

        public Criteria andValidamountIsNotNull() {
            addCriterion("validamount is not null");
            return (Criteria) this;
        }

        public Criteria andValidamountEqualTo(BigDecimal value) {
            addCriterion("validamount =", value, "validamount");
            return (Criteria) this;
        }

        public Criteria andValidamountNotEqualTo(BigDecimal value) {
            addCriterion("validamount <>", value, "validamount");
            return (Criteria) this;
        }

        public Criteria andValidamountGreaterThan(BigDecimal value) {
            addCriterion("validamount >", value, "validamount");
            return (Criteria) this;
        }

        public Criteria andValidamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("validamount >=", value, "validamount");
            return (Criteria) this;
        }

        public Criteria andValidamountLessThan(BigDecimal value) {
            addCriterion("validamount <", value, "validamount");
            return (Criteria) this;
        }

        public Criteria andValidamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("validamount <=", value, "validamount");
            return (Criteria) this;
        }

        public Criteria andValidamountIn(List<BigDecimal> values) {
            addCriterion("validamount in", values, "validamount");
            return (Criteria) this;
        }

        public Criteria andValidamountNotIn(List<BigDecimal> values) {
            addCriterion("validamount not in", values, "validamount");
            return (Criteria) this;
        }

        public Criteria andValidamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("validamount between", value1, value2, "validamount");
            return (Criteria) this;
        }

        public Criteria andValidamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("validamount not between", value1, value2, "validamount");
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

        public Criteria andLiveIdIsNull() {
            addCriterion("live_id is null");
            return (Criteria) this;
        }

        public Criteria andLiveIdIsNotNull() {
            addCriterion("live_id is not null");
            return (Criteria) this;
        }

        public Criteria andLiveIdEqualTo(Byte value) {
            addCriterion("live_id =", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdNotEqualTo(Byte value) {
            addCriterion("live_id <>", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdGreaterThan(Byte value) {
            addCriterion("live_id >", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("live_id >=", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdLessThan(Byte value) {
            addCriterion("live_id <", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdLessThanOrEqualTo(Byte value) {
            addCriterion("live_id <=", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdIn(List<Byte> values) {
            addCriterion("live_id in", values, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdNotIn(List<Byte> values) {
            addCriterion("live_id not in", values, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdBetween(Byte value1, Byte value2) {
            addCriterion("live_id between", value1, value2, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdNotBetween(Byte value1, Byte value2) {
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

        public Criteria andGameKindIsNull() {
            addCriterion("game_kind is null");
            return (Criteria) this;
        }

        public Criteria andGameKindIsNotNull() {
            addCriterion("game_kind is not null");
            return (Criteria) this;
        }

        public Criteria andGameKindEqualTo(Integer value) {
            addCriterion("game_kind =", value, "gameKind");
            return (Criteria) this;
        }

        public Criteria andGameKindNotEqualTo(Integer value) {
            addCriterion("game_kind <>", value, "gameKind");
            return (Criteria) this;
        }

        public Criteria andGameKindGreaterThan(Integer value) {
            addCriterion("game_kind >", value, "gameKind");
            return (Criteria) this;
        }

        public Criteria andGameKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("game_kind >=", value, "gameKind");
            return (Criteria) this;
        }

        public Criteria andGameKindLessThan(Integer value) {
            addCriterion("game_kind <", value, "gameKind");
            return (Criteria) this;
        }

        public Criteria andGameKindLessThanOrEqualTo(Integer value) {
            addCriterion("game_kind <=", value, "gameKind");
            return (Criteria) this;
        }

        public Criteria andGameKindIn(List<Integer> values) {
            addCriterion("game_kind in", values, "gameKind");
            return (Criteria) this;
        }

        public Criteria andGameKindNotIn(List<Integer> values) {
            addCriterion("game_kind not in", values, "gameKind");
            return (Criteria) this;
        }

        public Criteria andGameKindBetween(Integer value1, Integer value2) {
            addCriterion("game_kind between", value1, value2, "gameKind");
            return (Criteria) this;
        }

        public Criteria andGameKindNotBetween(Integer value1, Integer value2) {
            addCriterion("game_kind not between", value1, value2, "gameKind");
            return (Criteria) this;
        }

        public Criteria andGameKindNameIsNull() {
            addCriterion("game_kind_name is null");
            return (Criteria) this;
        }

        public Criteria andGameKindNameIsNotNull() {
            addCriterion("game_kind_name is not null");
            return (Criteria) this;
        }

        public Criteria andGameKindNameEqualTo(String value) {
            addCriterion("game_kind_name =", value, "gameKindName");
            return (Criteria) this;
        }

        public Criteria andGameKindNameNotEqualTo(String value) {
            addCriterion("game_kind_name <>", value, "gameKindName");
            return (Criteria) this;
        }

        public Criteria andGameKindNameGreaterThan(String value) {
            addCriterion("game_kind_name >", value, "gameKindName");
            return (Criteria) this;
        }

        public Criteria andGameKindNameGreaterThanOrEqualTo(String value) {
            addCriterion("game_kind_name >=", value, "gameKindName");
            return (Criteria) this;
        }

        public Criteria andGameKindNameLessThan(String value) {
            addCriterion("game_kind_name <", value, "gameKindName");
            return (Criteria) this;
        }

        public Criteria andGameKindNameLessThanOrEqualTo(String value) {
            addCriterion("game_kind_name <=", value, "gameKindName");
            return (Criteria) this;
        }

        public Criteria andGameKindNameLike(String value) {
            addCriterion("game_kind_name like", value, "gameKindName");
            return (Criteria) this;
        }

        public Criteria andGameKindNameNotLike(String value) {
            addCriterion("game_kind_name not like", value, "gameKindName");
            return (Criteria) this;
        }

        public Criteria andGameKindNameIn(List<String> values) {
            addCriterion("game_kind_name in", values, "gameKindName");
            return (Criteria) this;
        }

        public Criteria andGameKindNameNotIn(List<String> values) {
            addCriterion("game_kind_name not in", values, "gameKindName");
            return (Criteria) this;
        }

        public Criteria andGameKindNameBetween(String value1, String value2) {
            addCriterion("game_kind_name between", value1, value2, "gameKindName");
            return (Criteria) this;
        }

        public Criteria andGameKindNameNotBetween(String value1, String value2) {
            addCriterion("game_kind_name not between", value1, value2, "gameKindName");
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
            addCriterionForJDBCDate("bet_time =", value, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("bet_time <>", value, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("bet_time >", value, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bet_time >=", value, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeLessThan(Date value) {
            addCriterionForJDBCDate("bet_time <", value, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bet_time <=", value, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeIn(List<Date> values) {
            addCriterionForJDBCDate("bet_time in", values, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("bet_time not in", values, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bet_time between", value1, value2, "betTime");
            return (Criteria) this;
        }

        public Criteria andBetTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bet_time not between", value1, value2, "betTime");
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
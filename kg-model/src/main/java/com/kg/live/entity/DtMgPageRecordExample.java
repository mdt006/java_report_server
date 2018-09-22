package com.kg.live.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtMgPageRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DtMgPageRecordExample() {
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

        public Criteria andPageIsNull() {
            addCriterion("page is null");
            return (Criteria) this;
        }

        public Criteria andPageIsNotNull() {
            addCriterion("page is not null");
            return (Criteria) this;
        }

        public Criteria andPageEqualTo(Integer value) {
            addCriterion("page =", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotEqualTo(Integer value) {
            addCriterion("page <>", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThan(Integer value) {
            addCriterion("page >", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThanOrEqualTo(Integer value) {
            addCriterion("page >=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThan(Integer value) {
            addCriterion("page <", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThanOrEqualTo(Integer value) {
            addCriterion("page <=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageIn(List<Integer> values) {
            addCriterion("page in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotIn(List<Integer> values) {
            addCriterion("page not in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageBetween(Integer value1, Integer value2) {
            addCriterion("page between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotBetween(Integer value1, Integer value2) {
            addCriterion("page not between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andPageSizeIsNull() {
            addCriterion("page_size is null");
            return (Criteria) this;
        }

        public Criteria andPageSizeIsNotNull() {
            addCriterion("page_size is not null");
            return (Criteria) this;
        }

        public Criteria andPageSizeEqualTo(Integer value) {
            addCriterion("page_size =", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotEqualTo(Integer value) {
            addCriterion("page_size <>", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeGreaterThan(Integer value) {
            addCriterion("page_size >", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("page_size >=", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeLessThan(Integer value) {
            addCriterion("page_size <", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeLessThanOrEqualTo(Integer value) {
            addCriterion("page_size <=", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeIn(List<Integer> values) {
            addCriterion("page_size in", values, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotIn(List<Integer> values) {
            addCriterion("page_size not in", values, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeBetween(Integer value1, Integer value2) {
            addCriterion("page_size between", value1, value2, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("page_size not between", value1, value2, "pageSize");
            return (Criteria) this;
        }

        public Criteria andLastPageCheckTimesIsNull() {
            addCriterion("last_page_check_times is null");
            return (Criteria) this;
        }

        public Criteria andLastPageCheckTimesIsNotNull() {
            addCriterion("last_page_check_times is not null");
            return (Criteria) this;
        }

        public Criteria andLastPageCheckTimesEqualTo(Integer value) {
            addCriterion("last_page_check_times =", value, "lastPageCheckTimes");
            return (Criteria) this;
        }

        public Criteria andLastPageCheckTimesNotEqualTo(Integer value) {
            addCriterion("last_page_check_times <>", value, "lastPageCheckTimes");
            return (Criteria) this;
        }

        public Criteria andLastPageCheckTimesGreaterThan(Integer value) {
            addCriterion("last_page_check_times >", value, "lastPageCheckTimes");
            return (Criteria) this;
        }

        public Criteria andLastPageCheckTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_page_check_times >=", value, "lastPageCheckTimes");
            return (Criteria) this;
        }

        public Criteria andLastPageCheckTimesLessThan(Integer value) {
            addCriterion("last_page_check_times <", value, "lastPageCheckTimes");
            return (Criteria) this;
        }

        public Criteria andLastPageCheckTimesLessThanOrEqualTo(Integer value) {
            addCriterion("last_page_check_times <=", value, "lastPageCheckTimes");
            return (Criteria) this;
        }

        public Criteria andLastPageCheckTimesIn(List<Integer> values) {
            addCriterion("last_page_check_times in", values, "lastPageCheckTimes");
            return (Criteria) this;
        }

        public Criteria andLastPageCheckTimesNotIn(List<Integer> values) {
            addCriterion("last_page_check_times not in", values, "lastPageCheckTimes");
            return (Criteria) this;
        }

        public Criteria andLastPageCheckTimesBetween(Integer value1, Integer value2) {
            addCriterion("last_page_check_times between", value1, value2, "lastPageCheckTimes");
            return (Criteria) this;
        }

        public Criteria andLastPageCheckTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("last_page_check_times not between", value1, value2, "lastPageCheckTimes");
            return (Criteria) this;
        }

        public Criteria andYesterdayCheckStatusIsNull() {
            addCriterion("yesterday_check_status is null");
            return (Criteria) this;
        }

        public Criteria andYesterdayCheckStatusIsNotNull() {
            addCriterion("yesterday_check_status is not null");
            return (Criteria) this;
        }

        public Criteria andYesterdayCheckStatusEqualTo(Integer value) {
            addCriterion("yesterday_check_status =", value, "yesterdayCheckStatus");
            return (Criteria) this;
        }

        public Criteria andYesterdayCheckStatusNotEqualTo(Integer value) {
            addCriterion("yesterday_check_status <>", value, "yesterdayCheckStatus");
            return (Criteria) this;
        }

        public Criteria andYesterdayCheckStatusGreaterThan(Integer value) {
            addCriterion("yesterday_check_status >", value, "yesterdayCheckStatus");
            return (Criteria) this;
        }

        public Criteria andYesterdayCheckStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("yesterday_check_status >=", value, "yesterdayCheckStatus");
            return (Criteria) this;
        }

        public Criteria andYesterdayCheckStatusLessThan(Integer value) {
            addCriterion("yesterday_check_status <", value, "yesterdayCheckStatus");
            return (Criteria) this;
        }

        public Criteria andYesterdayCheckStatusLessThanOrEqualTo(Integer value) {
            addCriterion("yesterday_check_status <=", value, "yesterdayCheckStatus");
            return (Criteria) this;
        }

        public Criteria andYesterdayCheckStatusIn(List<Integer> values) {
            addCriterion("yesterday_check_status in", values, "yesterdayCheckStatus");
            return (Criteria) this;
        }

        public Criteria andYesterdayCheckStatusNotIn(List<Integer> values) {
            addCriterion("yesterday_check_status not in", values, "yesterdayCheckStatus");
            return (Criteria) this;
        }

        public Criteria andYesterdayCheckStatusBetween(Integer value1, Integer value2) {
            addCriterion("yesterday_check_status between", value1, value2, "yesterdayCheckStatus");
            return (Criteria) this;
        }

        public Criteria andYesterdayCheckStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("yesterday_check_status not between", value1, value2, "yesterdayCheckStatus");
            return (Criteria) this;
        }

        public Criteria andRounddateIsNull() {
            addCriterion("rounddate is null");
            return (Criteria) this;
        }

        public Criteria andRounddateIsNotNull() {
            addCriterion("rounddate is not null");
            return (Criteria) this;
        }

        public Criteria andRounddateEqualTo(String value) {
            addCriterion("rounddate =", value, "rounddate");
            return (Criteria) this;
        }

        public Criteria andRounddateNotEqualTo(String value) {
            addCriterion("rounddate <>", value, "rounddate");
            return (Criteria) this;
        }

        public Criteria andRounddateGreaterThan(String value) {
            addCriterion("rounddate >", value, "rounddate");
            return (Criteria) this;
        }

        public Criteria andRounddateGreaterThanOrEqualTo(String value) {
            addCriterion("rounddate >=", value, "rounddate");
            return (Criteria) this;
        }

        public Criteria andRounddateLessThan(String value) {
            addCriterion("rounddate <", value, "rounddate");
            return (Criteria) this;
        }

        public Criteria andRounddateLessThanOrEqualTo(String value) {
            addCriterion("rounddate <=", value, "rounddate");
            return (Criteria) this;
        }

        public Criteria andRounddateLike(String value) {
            addCriterion("rounddate like", value, "rounddate");
            return (Criteria) this;
        }

        public Criteria andRounddateNotLike(String value) {
            addCriterion("rounddate not like", value, "rounddate");
            return (Criteria) this;
        }

        public Criteria andRounddateIn(List<String> values) {
            addCriterion("rounddate in", values, "rounddate");
            return (Criteria) this;
        }

        public Criteria andRounddateNotIn(List<String> values) {
            addCriterion("rounddate not in", values, "rounddate");
            return (Criteria) this;
        }

        public Criteria andRounddateBetween(String value1, String value2) {
            addCriterion("rounddate between", value1, value2, "rounddate");
            return (Criteria) this;
        }

        public Criteria andRounddateNotBetween(String value1, String value2) {
            addCriterion("rounddate not between", value1, value2, "rounddate");
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
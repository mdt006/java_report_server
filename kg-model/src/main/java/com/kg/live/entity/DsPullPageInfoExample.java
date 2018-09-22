package com.kg.live.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DsPullPageInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsPullPageInfoExample() {
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

        public Criteria andPageNumIsNull() {
            addCriterion("page_num is null");
            return (Criteria) this;
        }

        public Criteria andPageNumIsNotNull() {
            addCriterion("page_num is not null");
            return (Criteria) this;
        }

        public Criteria andPageNumEqualTo(Integer value) {
            addCriterion("page_num =", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumNotEqualTo(Integer value) {
            addCriterion("page_num <>", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumGreaterThan(Integer value) {
            addCriterion("page_num >", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("page_num >=", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumLessThan(Integer value) {
            addCriterion("page_num <", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumLessThanOrEqualTo(Integer value) {
            addCriterion("page_num <=", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumIn(List<Integer> values) {
            addCriterion("page_num in", values, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumNotIn(List<Integer> values) {
            addCriterion("page_num not in", values, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumBetween(Integer value1, Integer value2) {
            addCriterion("page_num between", value1, value2, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("page_num not between", value1, value2, "pageNum");
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

        public Criteria andGameTypeIsNull() {
            addCriterion("game_type is null");
            return (Criteria) this;
        }

        public Criteria andGameTypeIsNotNull() {
            addCriterion("game_type is not null");
            return (Criteria) this;
        }

        public Criteria andGameTypeEqualTo(Integer value) {
            addCriterion("game_type =", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotEqualTo(Integer value) {
            addCriterion("game_type <>", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeGreaterThan(Integer value) {
            addCriterion("game_type >", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("game_type >=", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLessThan(Integer value) {
            addCriterion("game_type <", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLessThanOrEqualTo(Integer value) {
            addCriterion("game_type <=", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeIn(List<Integer> values) {
            addCriterion("game_type in", values, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotIn(List<Integer> values) {
            addCriterion("game_type not in", values, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeBetween(Integer value1, Integer value2) {
            addCriterion("game_type between", value1, value2, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("game_type not between", value1, value2, "gameType");
            return (Criteria) this;
        }

        public Criteria andPageDateIsNull() {
            addCriterion("page_date is null");
            return (Criteria) this;
        }

        public Criteria andPageDateIsNotNull() {
            addCriterion("page_date is not null");
            return (Criteria) this;
        }

        public Criteria andPageDateEqualTo(Date value) {
            addCriterionForJDBCDate("page_date =", value, "pageDate");
            return (Criteria) this;
        }

        public Criteria andPageDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("page_date <>", value, "pageDate");
            return (Criteria) this;
        }

        public Criteria andPageDateGreaterThan(Date value) {
            addCriterionForJDBCDate("page_date >", value, "pageDate");
            return (Criteria) this;
        }

        public Criteria andPageDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("page_date >=", value, "pageDate");
            return (Criteria) this;
        }

        public Criteria andPageDateLessThan(Date value) {
            addCriterionForJDBCDate("page_date <", value, "pageDate");
            return (Criteria) this;
        }

        public Criteria andPageDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("page_date <=", value, "pageDate");
            return (Criteria) this;
        }

        public Criteria andPageDateIn(List<Date> values) {
            addCriterionForJDBCDate("page_date in", values, "pageDate");
            return (Criteria) this;
        }

        public Criteria andPageDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("page_date not in", values, "pageDate");
            return (Criteria) this;
        }

        public Criteria andPageDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("page_date between", value1, value2, "pageDate");
            return (Criteria) this;
        }

        public Criteria andPageDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("page_date not between", value1, value2, "pageDate");
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
package com.kg.live.entity;

import java.util.ArrayList;
import java.util.List;

public class DsGameTypeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    public DsGameTypeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
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

        public Criteria andOutGameCodeIsNull() {
            addCriterion("out_game_code is null");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeIsNotNull() {
            addCriterion("out_game_code is not null");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeEqualTo(String value) {
            addCriterion("out_game_code =", value, "outGameCode");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeNotEqualTo(String value) {
            addCriterion("out_game_code <>", value, "outGameCode");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeGreaterThan(String value) {
            addCriterion("out_game_code >", value, "outGameCode");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeGreaterThanOrEqualTo(String value) {
            addCriterion("out_game_code >=", value, "outGameCode");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeLessThan(String value) {
            addCriterion("out_game_code <", value, "outGameCode");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeLessThanOrEqualTo(String value) {
            addCriterion("out_game_code <=", value, "outGameCode");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeLike(String value) {
            addCriterion("out_game_code like", value, "outGameCode");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeNotLike(String value) {
            addCriterion("out_game_code not like", value, "outGameCode");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeIn(List<String> values) {
            addCriterion("out_game_code in", values, "outGameCode");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeNotIn(List<String> values) {
            addCriterion("out_game_code not in", values, "outGameCode");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeBetween(String value1, String value2) {
            addCriterion("out_game_code between", value1, value2, "outGameCode");
            return (Criteria) this;
        }

        public Criteria andOutGameCodeNotBetween(String value1, String value2) {
            addCriterion("out_game_code not between", value1, value2, "outGameCode");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andFkLiveIdIsNull() {
            addCriterion("fk_live_id is null");
            return (Criteria) this;
        }

        public Criteria andFkLiveIdIsNotNull() {
            addCriterion("fk_live_id is not null");
            return (Criteria) this;
        }

        public Criteria andFkLiveIdEqualTo(Byte value) {
            addCriterion("fk_live_id =", value, "fkLiveId");
            return (Criteria) this;
        }

        public Criteria andFkLiveIdNotEqualTo(Byte value) {
            addCriterion("fk_live_id <>", value, "fkLiveId");
            return (Criteria) this;
        }

        public Criteria andFkLiveIdGreaterThan(Byte value) {
            addCriterion("fk_live_id >", value, "fkLiveId");
            return (Criteria) this;
        }

        public Criteria andFkLiveIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("fk_live_id >=", value, "fkLiveId");
            return (Criteria) this;
        }

        public Criteria andFkLiveIdLessThan(Byte value) {
            addCriterion("fk_live_id <", value, "fkLiveId");
            return (Criteria) this;
        }

        public Criteria andFkLiveIdLessThanOrEqualTo(Byte value) {
            addCriterion("fk_live_id <=", value, "fkLiveId");
            return (Criteria) this;
        }

        public Criteria andFkLiveIdIn(List<Byte> values) {
            addCriterion("fk_live_id in", values, "fkLiveId");
            return (Criteria) this;
        }

        public Criteria andFkLiveIdNotIn(List<Byte> values) {
            addCriterion("fk_live_id not in", values, "fkLiveId");
            return (Criteria) this;
        }

        public Criteria andFkLiveIdBetween(Byte value1, Byte value2) {
            addCriterion("fk_live_id between", value1, value2, "fkLiveId");
            return (Criteria) this;
        }

        public Criteria andFkLiveIdNotBetween(Byte value1, Byte value2) {
            addCriterion("fk_live_id not between", value1, value2, "fkLiveId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ds_game_type
     *
     * @mbggenerated do_not_delete_during_merge Mon Nov 02 13:46:13 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ds_game_type
     *
     * @mbggenerated Mon Nov 02 13:46:13 CST 2015
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
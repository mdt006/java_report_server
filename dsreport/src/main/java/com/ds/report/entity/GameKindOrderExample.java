package com.ds.report.entity;

import java.util.ArrayList;
import java.util.List;

public class GameKindOrderExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	public GameKindOrderExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
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
			addCriterion("game_kind_name between", value1, value2,
					"gameKindName");
			return (Criteria) this;
		}

		public Criteria andGameKindNameNotBetween(String value1, String value2) {
			addCriterion("game_kind_name not between", value1, value2,
					"gameKindName");
			return (Criteria) this;
		}

		public Criteria andOrderAscIsNull() {
			addCriterion("order_asc is null");
			return (Criteria) this;
		}

		public Criteria andOrderAscIsNotNull() {
			addCriterion("order_asc is not null");
			return (Criteria) this;
		}

		public Criteria andOrderAscEqualTo(Integer value) {
			addCriterion("order_asc =", value, "orderAsc");
			return (Criteria) this;
		}

		public Criteria andOrderAscNotEqualTo(Integer value) {
			addCriterion("order_asc <>", value, "orderAsc");
			return (Criteria) this;
		}

		public Criteria andOrderAscGreaterThan(Integer value) {
			addCriterion("order_asc >", value, "orderAsc");
			return (Criteria) this;
		}

		public Criteria andOrderAscGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_asc >=", value, "orderAsc");
			return (Criteria) this;
		}

		public Criteria andOrderAscLessThan(Integer value) {
			addCriterion("order_asc <", value, "orderAsc");
			return (Criteria) this;
		}

		public Criteria andOrderAscLessThanOrEqualTo(Integer value) {
			addCriterion("order_asc <=", value, "orderAsc");
			return (Criteria) this;
		}

		public Criteria andOrderAscIn(List<Integer> values) {
			addCriterion("order_asc in", values, "orderAsc");
			return (Criteria) this;
		}

		public Criteria andOrderAscNotIn(List<Integer> values) {
			addCriterion("order_asc not in", values, "orderAsc");
			return (Criteria) this;
		}

		public Criteria andOrderAscBetween(Integer value1, Integer value2) {
			addCriterion("order_asc between", value1, value2, "orderAsc");
			return (Criteria) this;
		}

		public Criteria andOrderAscNotBetween(Integer value1, Integer value2) {
			addCriterion("order_asc not between", value1, value2, "orderAsc");
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

		public Criteria andStateEqualTo(Integer value) {
			addCriterion("state =", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotEqualTo(Integer value) {
			addCriterion("state <>", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThan(Integer value) {
			addCriterion("state >", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("state >=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThan(Integer value) {
			addCriterion("state <", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThanOrEqualTo(Integer value) {
			addCriterion("state <=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateIn(List<Integer> values) {
			addCriterion("state in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotIn(List<Integer> values) {
			addCriterion("state not in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateBetween(Integer value1, Integer value2) {
			addCriterion("state between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotBetween(Integer value1, Integer value2) {
			addCriterion("state not between", value1, value2, "state");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table ds_game_kind_order
	 * @mbggenerated  Tue Nov 03 16:16:29 CST 2015
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
     * This class corresponds to the database table ds_game_kind_order
     *
     * @mbggenerated do_not_delete_during_merge Tue Nov 03 15:26:58 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}
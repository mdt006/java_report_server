package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DsKyChessExample {
    protected String orderByClause;
    
    
    protected Integer page;

	protected Integer pageLimit;
    
    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsKyChessExample() {
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

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNull() {
            addCriterion("server_id is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("server_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(Integer value) {
            addCriterion("server_id =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(Integer value) {
            addCriterion("server_id <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(Integer value) {
            addCriterion("server_id >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("server_id >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(Integer value) {
            addCriterion("server_id <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(Integer value) {
            addCriterion("server_id <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(List<Integer> values) {
            addCriterion("server_id in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(List<Integer> values) {
            addCriterion("server_id not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(Integer value1, Integer value2) {
            addCriterion("server_id between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("server_id not between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andKindIdIsNull() {
            addCriterion("kind_id is null");
            return (Criteria) this;
        }

        public Criteria andKindIdIsNotNull() {
            addCriterion("kind_id is not null");
            return (Criteria) this;
        }

        public Criteria andKindIdEqualTo(Integer value) {
            addCriterion("kind_id =", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotEqualTo(Integer value) {
            addCriterion("kind_id <>", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdGreaterThan(Integer value) {
            addCriterion("kind_id >", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("kind_id >=", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdLessThan(Integer value) {
            addCriterion("kind_id <", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdLessThanOrEqualTo(Integer value) {
            addCriterion("kind_id <=", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdIn(List<Integer> values) {
            addCriterion("kind_id in", values, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotIn(List<Integer> values) {
            addCriterion("kind_id not in", values, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdBetween(Integer value1, Integer value2) {
            addCriterion("kind_id between", value1, value2, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotBetween(Integer value1, Integer value2) {
            addCriterion("kind_id not between", value1, value2, "kindId");
            return (Criteria) this;
        }

        public Criteria andTableIdIsNull() {
            addCriterion("table_id is null");
            return (Criteria) this;
        }

        public Criteria andTableIdIsNotNull() {
            addCriterion("table_id is not null");
            return (Criteria) this;
        }

        public Criteria andTableIdEqualTo(Integer value) {
            addCriterion("table_id =", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotEqualTo(Integer value) {
            addCriterion("table_id <>", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdGreaterThan(Integer value) {
            addCriterion("table_id >", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("table_id >=", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLessThan(Integer value) {
            addCriterion("table_id <", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLessThanOrEqualTo(Integer value) {
            addCriterion("table_id <=", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdIn(List<Integer> values) {
            addCriterion("table_id in", values, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotIn(List<Integer> values) {
            addCriterion("table_id not in", values, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdBetween(Integer value1, Integer value2) {
            addCriterion("table_id between", value1, value2, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("table_id not between", value1, value2, "tableId");
            return (Criteria) this;
        }

        public Criteria andChairIdIsNull() {
            addCriterion("chair_id is null");
            return (Criteria) this;
        }

        public Criteria andChairIdIsNotNull() {
            addCriterion("chair_id is not null");
            return (Criteria) this;
        }

        public Criteria andChairIdEqualTo(Integer value) {
            addCriterion("chair_id =", value, "chairId");
            return (Criteria) this;
        }

        public Criteria andChairIdNotEqualTo(Integer value) {
            addCriterion("chair_id <>", value, "chairId");
            return (Criteria) this;
        }

        public Criteria andChairIdGreaterThan(Integer value) {
            addCriterion("chair_id >", value, "chairId");
            return (Criteria) this;
        }

        public Criteria andChairIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("chair_id >=", value, "chairId");
            return (Criteria) this;
        }

        public Criteria andChairIdLessThan(Integer value) {
            addCriterion("chair_id <", value, "chairId");
            return (Criteria) this;
        }

        public Criteria andChairIdLessThanOrEqualTo(Integer value) {
            addCriterion("chair_id <=", value, "chairId");
            return (Criteria) this;
        }

        public Criteria andChairIdIn(List<Integer> values) {
            addCriterion("chair_id in", values, "chairId");
            return (Criteria) this;
        }

        public Criteria andChairIdNotIn(List<Integer> values) {
            addCriterion("chair_id not in", values, "chairId");
            return (Criteria) this;
        }

        public Criteria andChairIdBetween(Integer value1, Integer value2) {
            addCriterion("chair_id between", value1, value2, "chairId");
            return (Criteria) this;
        }

        public Criteria andChairIdNotBetween(Integer value1, Integer value2) {
            addCriterion("chair_id not between", value1, value2, "chairId");
            return (Criteria) this;
        }

        public Criteria andUserCountIsNull() {
            addCriterion("user_count is null");
            return (Criteria) this;
        }

        public Criteria andUserCountIsNotNull() {
            addCriterion("user_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserCountEqualTo(Integer value) {
            addCriterion("user_count =", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountNotEqualTo(Integer value) {
            addCriterion("user_count <>", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountGreaterThan(Integer value) {
            addCriterion("user_count >", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_count >=", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountLessThan(Integer value) {
            addCriterion("user_count <", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountLessThanOrEqualTo(Integer value) {
            addCriterion("user_count <=", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountIn(List<Integer> values) {
            addCriterion("user_count in", values, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountNotIn(List<Integer> values) {
            addCriterion("user_count not in", values, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountBetween(Integer value1, Integer value2) {
            addCriterion("user_count between", value1, value2, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountNotBetween(Integer value1, Integer value2) {
            addCriterion("user_count not between", value1, value2, "userCount");
            return (Criteria) this;
        }

        public Criteria andCardValueIsNull() {
            addCriterion("card_value is null");
            return (Criteria) this;
        }

        public Criteria andCardValueIsNotNull() {
            addCriterion("card_value is not null");
            return (Criteria) this;
        }

        public Criteria andCardValueEqualTo(String value) {
            addCriterion("card_value =", value, "cardValue");
            return (Criteria) this;
        }

        public Criteria andCardValueNotEqualTo(String value) {
            addCriterion("card_value <>", value, "cardValue");
            return (Criteria) this;
        }

        public Criteria andCardValueGreaterThan(String value) {
            addCriterion("card_value >", value, "cardValue");
            return (Criteria) this;
        }

        public Criteria andCardValueGreaterThanOrEqualTo(String value) {
            addCriterion("card_value >=", value, "cardValue");
            return (Criteria) this;
        }

        public Criteria andCardValueLessThan(String value) {
            addCriterion("card_value <", value, "cardValue");
            return (Criteria) this;
        }

        public Criteria andCardValueLessThanOrEqualTo(String value) {
            addCriterion("card_value <=", value, "cardValue");
            return (Criteria) this;
        }

        public Criteria andCardValueLike(String value) {
            addCriterion("card_value like", value, "cardValue");
            return (Criteria) this;
        }

        public Criteria andCardValueNotLike(String value) {
            addCriterion("card_value not like", value, "cardValue");
            return (Criteria) this;
        }

        public Criteria andCardValueIn(List<String> values) {
            addCriterion("card_value in", values, "cardValue");
            return (Criteria) this;
        }

        public Criteria andCardValueNotIn(List<String> values) {
            addCriterion("card_value not in", values, "cardValue");
            return (Criteria) this;
        }

        public Criteria andCardValueBetween(String value1, String value2) {
            addCriterion("card_value between", value1, value2, "cardValue");
            return (Criteria) this;
        }

        public Criteria andCardValueNotBetween(String value1, String value2) {
            addCriterion("card_value not between", value1, value2, "cardValue");
            return (Criteria) this;
        }

        public Criteria andCellScoreIsNull() {
            addCriterion("cell_score is null");
            return (Criteria) this;
        }

        public Criteria andCellScoreIsNotNull() {
            addCriterion("cell_score is not null");
            return (Criteria) this;
        }

        public Criteria andCellScoreEqualTo(BigDecimal value) {
            addCriterion("cell_score =", value, "cellScore");
            return (Criteria) this;
        }

        public Criteria andCellScoreNotEqualTo(BigDecimal value) {
            addCriterion("cell_score <>", value, "cellScore");
            return (Criteria) this;
        }

        public Criteria andCellScoreGreaterThan(BigDecimal value) {
            addCriterion("cell_score >", value, "cellScore");
            return (Criteria) this;
        }

        public Criteria andCellScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cell_score >=", value, "cellScore");
            return (Criteria) this;
        }

        public Criteria andCellScoreLessThan(BigDecimal value) {
            addCriterion("cell_score <", value, "cellScore");
            return (Criteria) this;
        }

        public Criteria andCellScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cell_score <=", value, "cellScore");
            return (Criteria) this;
        }

        public Criteria andCellScoreIn(List<BigDecimal> values) {
            addCriterion("cell_score in", values, "cellScore");
            return (Criteria) this;
        }

        public Criteria andCellScoreNotIn(List<BigDecimal> values) {
            addCriterion("cell_score not in", values, "cellScore");
            return (Criteria) this;
        }

        public Criteria andCellScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cell_score between", value1, value2, "cellScore");
            return (Criteria) this;
        }

        public Criteria andCellScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cell_score not between", value1, value2, "cellScore");
            return (Criteria) this;
        }

        public Criteria andAllBetIsNull() {
            addCriterion("all_bet is null");
            return (Criteria) this;
        }

        public Criteria andAllBetIsNotNull() {
            addCriterion("all_bet is not null");
            return (Criteria) this;
        }

        public Criteria andAllBetEqualTo(BigDecimal value) {
            addCriterion("all_bet =", value, "allBet");
            return (Criteria) this;
        }

        public Criteria andAllBetNotEqualTo(BigDecimal value) {
            addCriterion("all_bet <>", value, "allBet");
            return (Criteria) this;
        }

        public Criteria andAllBetGreaterThan(BigDecimal value) {
            addCriterion("all_bet >", value, "allBet");
            return (Criteria) this;
        }

        public Criteria andAllBetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_bet >=", value, "allBet");
            return (Criteria) this;
        }

        public Criteria andAllBetLessThan(BigDecimal value) {
            addCriterion("all_bet <", value, "allBet");
            return (Criteria) this;
        }

        public Criteria andAllBetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_bet <=", value, "allBet");
            return (Criteria) this;
        }

        public Criteria andAllBetIn(List<BigDecimal> values) {
            addCriterion("all_bet in", values, "allBet");
            return (Criteria) this;
        }

        public Criteria andAllBetNotIn(List<BigDecimal> values) {
            addCriterion("all_bet not in", values, "allBet");
            return (Criteria) this;
        }

        public Criteria andAllBetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_bet between", value1, value2, "allBet");
            return (Criteria) this;
        }

        public Criteria andAllBetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_bet not between", value1, value2, "allBet");
            return (Criteria) this;
        }

        public Criteria andProfitIsNull() {
            addCriterion("profit is null");
            return (Criteria) this;
        }

        public Criteria andProfitIsNotNull() {
            addCriterion("profit is not null");
            return (Criteria) this;
        }

        public Criteria andProfitEqualTo(BigDecimal value) {
            addCriterion("profit =", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotEqualTo(BigDecimal value) {
            addCriterion("profit <>", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThan(BigDecimal value) {
            addCriterion("profit >", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("profit >=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThan(BigDecimal value) {
            addCriterion("profit <", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("profit <=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitIn(List<BigDecimal> values) {
            addCriterion("profit in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotIn(List<BigDecimal> values) {
            addCriterion("profit not in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("profit between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("profit not between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andRevenueIsNull() {
            addCriterion("revenue is null");
            return (Criteria) this;
        }

        public Criteria andRevenueIsNotNull() {
            addCriterion("revenue is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueEqualTo(BigDecimal value) {
            addCriterion("revenue =", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotEqualTo(BigDecimal value) {
            addCriterion("revenue <>", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueGreaterThan(BigDecimal value) {
            addCriterion("revenue >", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("revenue >=", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLessThan(BigDecimal value) {
            addCriterion("revenue <", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("revenue <=", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueIn(List<BigDecimal> values) {
            addCriterion("revenue in", values, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotIn(List<BigDecimal> values) {
            addCriterion("revenue not in", values, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("revenue between", value1, value2, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("revenue not between", value1, value2, "revenue");
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

        public Criteria andGameStartTimeIsNull() {
            addCriterion("game_start_time is null");
            return (Criteria) this;
        }

        public Criteria andGameStartTimeIsNotNull() {
            addCriterion("game_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andGameStartTimeEqualTo(Date value) {
            addCriterion("game_start_time =", value, "gameStartTime");
            return (Criteria) this;
        }

        public Criteria andGameStartTimeNotEqualTo(Date value) {
            addCriterion("game_start_time <>", value, "gameStartTime");
            return (Criteria) this;
        }

        public Criteria andGameStartTimeGreaterThan(Date value) {
            addCriterion("game_start_time >", value, "gameStartTime");
            return (Criteria) this;
        }

        public Criteria andGameStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("game_start_time >=", value, "gameStartTime");
            return (Criteria) this;
        }

        public Criteria andGameStartTimeLessThan(Date value) {
            addCriterion("game_start_time <", value, "gameStartTime");
            return (Criteria) this;
        }

        public Criteria andGameStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("game_start_time <=", value, "gameStartTime");
            return (Criteria) this;
        }

        public Criteria andGameStartTimeIn(List<Date> values) {
            addCriterion("game_start_time in", values, "gameStartTime");
            return (Criteria) this;
        }

        public Criteria andGameStartTimeNotIn(List<Date> values) {
            addCriterion("game_start_time not in", values, "gameStartTime");
            return (Criteria) this;
        }

        public Criteria andGameStartTimeBetween(Date value1, Date value2) {
            addCriterion("game_start_time between", value1, value2, "gameStartTime");
            return (Criteria) this;
        }

        public Criteria andGameStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("game_start_time not between", value1, value2, "gameStartTime");
            return (Criteria) this;
        }

        public Criteria andGameEndTimeIsNull() {
            addCriterion("game_end_time is null");
            return (Criteria) this;
        }

        public Criteria andGameEndTimeIsNotNull() {
            addCriterion("game_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andGameEndTimeEqualTo(Date value) {
            addCriterion("game_end_time =", value, "gameEndTime");
            return (Criteria) this;
        }

        public Criteria andGameEndTimeNotEqualTo(Date value) {
            addCriterion("game_end_time <>", value, "gameEndTime");
            return (Criteria) this;
        }

        public Criteria andGameEndTimeGreaterThan(Date value) {
            addCriterion("game_end_time >", value, "gameEndTime");
            return (Criteria) this;
        }

        public Criteria andGameEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("game_end_time >=", value, "gameEndTime");
            return (Criteria) this;
        }

        public Criteria andGameEndTimeLessThan(Date value) {
            addCriterion("game_end_time <", value, "gameEndTime");
            return (Criteria) this;
        }

        public Criteria andGameEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("game_end_time <=", value, "gameEndTime");
            return (Criteria) this;
        }

        public Criteria andGameEndTimeIn(List<Date> values) {
            addCriterion("game_end_time in", values, "gameEndTime");
            return (Criteria) this;
        }

        public Criteria andGameEndTimeNotIn(List<Date> values) {
            addCriterion("game_end_time not in", values, "gameEndTime");
            return (Criteria) this;
        }

        public Criteria andGameEndTimeBetween(Date value1, Date value2) {
            addCriterion("game_end_time between", value1, value2, "gameEndTime");
            return (Criteria) this;
        }

        public Criteria andGameEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("game_end_time not between", value1, value2, "gameEndTime");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Integer value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Integer value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Integer value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Integer value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Integer> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Integer> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
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
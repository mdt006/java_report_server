package com.kg.live.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtPtGameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DtPtGameExample() {
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

        public Criteria andWindowcodeIsNull() {
            addCriterion("windowcode is null");
            return (Criteria) this;
        }

        public Criteria andWindowcodeIsNotNull() {
            addCriterion("windowcode is not null");
            return (Criteria) this;
        }

        public Criteria andWindowcodeEqualTo(String value) {
            addCriterion("windowcode =", value, "windowcode");
            return (Criteria) this;
        }

        public Criteria andWindowcodeNotEqualTo(String value) {
            addCriterion("windowcode <>", value, "windowcode");
            return (Criteria) this;
        }

        public Criteria andWindowcodeGreaterThan(String value) {
            addCriterion("windowcode >", value, "windowcode");
            return (Criteria) this;
        }

        public Criteria andWindowcodeGreaterThanOrEqualTo(String value) {
            addCriterion("windowcode >=", value, "windowcode");
            return (Criteria) this;
        }

        public Criteria andWindowcodeLessThan(String value) {
            addCriterion("windowcode <", value, "windowcode");
            return (Criteria) this;
        }

        public Criteria andWindowcodeLessThanOrEqualTo(String value) {
            addCriterion("windowcode <=", value, "windowcode");
            return (Criteria) this;
        }

        public Criteria andWindowcodeLike(String value) {
            addCriterion("windowcode like", value, "windowcode");
            return (Criteria) this;
        }

        public Criteria andWindowcodeNotLike(String value) {
            addCriterion("windowcode not like", value, "windowcode");
            return (Criteria) this;
        }

        public Criteria andWindowcodeIn(List<String> values) {
            addCriterion("windowcode in", values, "windowcode");
            return (Criteria) this;
        }

        public Criteria andWindowcodeNotIn(List<String> values) {
            addCriterion("windowcode not in", values, "windowcode");
            return (Criteria) this;
        }

        public Criteria andWindowcodeBetween(String value1, String value2) {
            addCriterion("windowcode between", value1, value2, "windowcode");
            return (Criteria) this;
        }

        public Criteria andWindowcodeNotBetween(String value1, String value2) {
            addCriterion("windowcode not between", value1, value2, "windowcode");
            return (Criteria) this;
        }

        public Criteria andGameidIsNull() {
            addCriterion("gameid is null");
            return (Criteria) this;
        }

        public Criteria andGameidIsNotNull() {
            addCriterion("gameid is not null");
            return (Criteria) this;
        }

        public Criteria andGameidEqualTo(Integer value) {
            addCriterion("gameid =", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotEqualTo(Integer value) {
            addCriterion("gameid <>", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidGreaterThan(Integer value) {
            addCriterion("gameid >", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gameid >=", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidLessThan(Integer value) {
            addCriterion("gameid <", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidLessThanOrEqualTo(Integer value) {
            addCriterion("gameid <=", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidIn(List<Integer> values) {
            addCriterion("gameid in", values, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotIn(List<Integer> values) {
            addCriterion("gameid not in", values, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidBetween(Integer value1, Integer value2) {
            addCriterion("gameid between", value1, value2, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotBetween(Integer value1, Integer value2) {
            addCriterion("gameid not between", value1, value2, "gameid");
            return (Criteria) this;
        }

        public Criteria andGamecodeIsNull() {
            addCriterion("gamecode is null");
            return (Criteria) this;
        }

        public Criteria andGamecodeIsNotNull() {
            addCriterion("gamecode is not null");
            return (Criteria) this;
        }

        public Criteria andGamecodeEqualTo(String value) {
            addCriterion("gamecode =", value, "gamecode");
            return (Criteria) this;
        }

        public Criteria andGamecodeNotEqualTo(String value) {
            addCriterion("gamecode <>", value, "gamecode");
            return (Criteria) this;
        }

        public Criteria andGamecodeGreaterThan(String value) {
            addCriterion("gamecode >", value, "gamecode");
            return (Criteria) this;
        }

        public Criteria andGamecodeGreaterThanOrEqualTo(String value) {
            addCriterion("gamecode >=", value, "gamecode");
            return (Criteria) this;
        }

        public Criteria andGamecodeLessThan(String value) {
            addCriterion("gamecode <", value, "gamecode");
            return (Criteria) this;
        }

        public Criteria andGamecodeLessThanOrEqualTo(String value) {
            addCriterion("gamecode <=", value, "gamecode");
            return (Criteria) this;
        }

        public Criteria andGamecodeLike(String value) {
            addCriterion("gamecode like", value, "gamecode");
            return (Criteria) this;
        }

        public Criteria andGamecodeNotLike(String value) {
            addCriterion("gamecode not like", value, "gamecode");
            return (Criteria) this;
        }

        public Criteria andGamecodeIn(List<String> values) {
            addCriterion("gamecode in", values, "gamecode");
            return (Criteria) this;
        }

        public Criteria andGamecodeNotIn(List<String> values) {
            addCriterion("gamecode not in", values, "gamecode");
            return (Criteria) this;
        }

        public Criteria andGamecodeBetween(String value1, String value2) {
            addCriterion("gamecode between", value1, value2, "gamecode");
            return (Criteria) this;
        }

        public Criteria andGamecodeNotBetween(String value1, String value2) {
            addCriterion("gamecode not between", value1, value2, "gamecode");
            return (Criteria) this;
        }

        public Criteria andGametypeIsNull() {
            addCriterion("gametype is null");
            return (Criteria) this;
        }

        public Criteria andGametypeIsNotNull() {
            addCriterion("gametype is not null");
            return (Criteria) this;
        }

        public Criteria andGametypeEqualTo(String value) {
            addCriterion("gametype =", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeNotEqualTo(String value) {
            addCriterion("gametype <>", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeGreaterThan(String value) {
            addCriterion("gametype >", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeGreaterThanOrEqualTo(String value) {
            addCriterion("gametype >=", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeLessThan(String value) {
            addCriterion("gametype <", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeLessThanOrEqualTo(String value) {
            addCriterion("gametype <=", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeLike(String value) {
            addCriterion("gametype like", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeNotLike(String value) {
            addCriterion("gametype not like", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeIn(List<String> values) {
            addCriterion("gametype in", values, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeNotIn(List<String> values) {
            addCriterion("gametype not in", values, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeBetween(String value1, String value2) {
            addCriterion("gametype between", value1, value2, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeNotBetween(String value1, String value2) {
            addCriterion("gametype not between", value1, value2, "gametype");
            return (Criteria) this;
        }

        public Criteria andGamenameIsNull() {
            addCriterion("gamename is null");
            return (Criteria) this;
        }

        public Criteria andGamenameIsNotNull() {
            addCriterion("gamename is not null");
            return (Criteria) this;
        }

        public Criteria andGamenameEqualTo(String value) {
            addCriterion("gamename =", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotEqualTo(String value) {
            addCriterion("gamename <>", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameGreaterThan(String value) {
            addCriterion("gamename >", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameGreaterThanOrEqualTo(String value) {
            addCriterion("gamename >=", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLessThan(String value) {
            addCriterion("gamename <", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLessThanOrEqualTo(String value) {
            addCriterion("gamename <=", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLike(String value) {
            addCriterion("gamename like", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotLike(String value) {
            addCriterion("gamename not like", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameIn(List<String> values) {
            addCriterion("gamename in", values, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotIn(List<String> values) {
            addCriterion("gamename not in", values, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameBetween(String value1, String value2) {
            addCriterion("gamename between", value1, value2, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotBetween(String value1, String value2) {
            addCriterion("gamename not between", value1, value2, "gamename");
            return (Criteria) this;
        }

        public Criteria andSessionidIsNull() {
            addCriterion("sessionid is null");
            return (Criteria) this;
        }

        public Criteria andSessionidIsNotNull() {
            addCriterion("sessionid is not null");
            return (Criteria) this;
        }

        public Criteria andSessionidEqualTo(String value) {
            addCriterion("sessionid =", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotEqualTo(String value) {
            addCriterion("sessionid <>", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidGreaterThan(String value) {
            addCriterion("sessionid >", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidGreaterThanOrEqualTo(String value) {
            addCriterion("sessionid >=", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLessThan(String value) {
            addCriterion("sessionid <", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLessThanOrEqualTo(String value) {
            addCriterion("sessionid <=", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLike(String value) {
            addCriterion("sessionid like", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotLike(String value) {
            addCriterion("sessionid not like", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidIn(List<String> values) {
            addCriterion("sessionid in", values, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotIn(List<String> values) {
            addCriterion("sessionid not in", values, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidBetween(String value1, String value2) {
            addCriterion("sessionid between", value1, value2, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotBetween(String value1, String value2) {
            addCriterion("sessionid not between", value1, value2, "sessionid");
            return (Criteria) this;
        }

        public Criteria andBetIsNull() {
            addCriterion("bet is null");
            return (Criteria) this;
        }

        public Criteria andBetIsNotNull() {
            addCriterion("bet is not null");
            return (Criteria) this;
        }

        public Criteria andBetEqualTo(BigDecimal value) {
            addCriterion("bet =", value, "bet");
            return (Criteria) this;
        }

        public Criteria andBetNotEqualTo(BigDecimal value) {
            addCriterion("bet <>", value, "bet");
            return (Criteria) this;
        }

        public Criteria andBetGreaterThan(BigDecimal value) {
            addCriterion("bet >", value, "bet");
            return (Criteria) this;
        }

        public Criteria andBetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bet >=", value, "bet");
            return (Criteria) this;
        }

        public Criteria andBetLessThan(BigDecimal value) {
            addCriterion("bet <", value, "bet");
            return (Criteria) this;
        }

        public Criteria andBetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bet <=", value, "bet");
            return (Criteria) this;
        }

        public Criteria andBetIn(List<BigDecimal> values) {
            addCriterion("bet in", values, "bet");
            return (Criteria) this;
        }

        public Criteria andBetNotIn(List<BigDecimal> values) {
            addCriterion("bet not in", values, "bet");
            return (Criteria) this;
        }

        public Criteria andBetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bet between", value1, value2, "bet");
            return (Criteria) this;
        }

        public Criteria andBetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bet not between", value1, value2, "bet");
            return (Criteria) this;
        }

        public Criteria andWinIsNull() {
            addCriterion("win is null");
            return (Criteria) this;
        }

        public Criteria andWinIsNotNull() {
            addCriterion("win is not null");
            return (Criteria) this;
        }

        public Criteria andWinEqualTo(BigDecimal value) {
            addCriterion("win =", value, "win");
            return (Criteria) this;
        }

        public Criteria andWinNotEqualTo(BigDecimal value) {
            addCriterion("win <>", value, "win");
            return (Criteria) this;
        }

        public Criteria andWinGreaterThan(BigDecimal value) {
            addCriterion("win >", value, "win");
            return (Criteria) this;
        }

        public Criteria andWinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("win >=", value, "win");
            return (Criteria) this;
        }

        public Criteria andWinLessThan(BigDecimal value) {
            addCriterion("win <", value, "win");
            return (Criteria) this;
        }

        public Criteria andWinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("win <=", value, "win");
            return (Criteria) this;
        }

        public Criteria andWinIn(List<BigDecimal> values) {
            addCriterion("win in", values, "win");
            return (Criteria) this;
        }

        public Criteria andWinNotIn(List<BigDecimal> values) {
            addCriterion("win not in", values, "win");
            return (Criteria) this;
        }

        public Criteria andWinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("win between", value1, value2, "win");
            return (Criteria) this;
        }

        public Criteria andWinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("win not between", value1, value2, "win");
            return (Criteria) this;
        }

        public Criteria andProgressivebetIsNull() {
            addCriterion("progressivebet is null");
            return (Criteria) this;
        }

        public Criteria andProgressivebetIsNotNull() {
            addCriterion("progressivebet is not null");
            return (Criteria) this;
        }

        public Criteria andProgressivebetEqualTo(BigDecimal value) {
            addCriterion("progressivebet =", value, "progressivebet");
            return (Criteria) this;
        }

        public Criteria andProgressivebetNotEqualTo(BigDecimal value) {
            addCriterion("progressivebet <>", value, "progressivebet");
            return (Criteria) this;
        }

        public Criteria andProgressivebetGreaterThan(BigDecimal value) {
            addCriterion("progressivebet >", value, "progressivebet");
            return (Criteria) this;
        }

        public Criteria andProgressivebetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("progressivebet >=", value, "progressivebet");
            return (Criteria) this;
        }

        public Criteria andProgressivebetLessThan(BigDecimal value) {
            addCriterion("progressivebet <", value, "progressivebet");
            return (Criteria) this;
        }

        public Criteria andProgressivebetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("progressivebet <=", value, "progressivebet");
            return (Criteria) this;
        }

        public Criteria andProgressivebetIn(List<BigDecimal> values) {
            addCriterion("progressivebet in", values, "progressivebet");
            return (Criteria) this;
        }

        public Criteria andProgressivebetNotIn(List<BigDecimal> values) {
            addCriterion("progressivebet not in", values, "progressivebet");
            return (Criteria) this;
        }

        public Criteria andProgressivebetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("progressivebet between", value1, value2, "progressivebet");
            return (Criteria) this;
        }

        public Criteria andProgressivebetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("progressivebet not between", value1, value2, "progressivebet");
            return (Criteria) this;
        }

        public Criteria andProgressivewinIsNull() {
            addCriterion("progressivewin is null");
            return (Criteria) this;
        }

        public Criteria andProgressivewinIsNotNull() {
            addCriterion("progressivewin is not null");
            return (Criteria) this;
        }

        public Criteria andProgressivewinEqualTo(BigDecimal value) {
            addCriterion("progressivewin =", value, "progressivewin");
            return (Criteria) this;
        }

        public Criteria andProgressivewinNotEqualTo(BigDecimal value) {
            addCriterion("progressivewin <>", value, "progressivewin");
            return (Criteria) this;
        }

        public Criteria andProgressivewinGreaterThan(BigDecimal value) {
            addCriterion("progressivewin >", value, "progressivewin");
            return (Criteria) this;
        }

        public Criteria andProgressivewinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("progressivewin >=", value, "progressivewin");
            return (Criteria) this;
        }

        public Criteria andProgressivewinLessThan(BigDecimal value) {
            addCriterion("progressivewin <", value, "progressivewin");
            return (Criteria) this;
        }

        public Criteria andProgressivewinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("progressivewin <=", value, "progressivewin");
            return (Criteria) this;
        }

        public Criteria andProgressivewinIn(List<BigDecimal> values) {
            addCriterion("progressivewin in", values, "progressivewin");
            return (Criteria) this;
        }

        public Criteria andProgressivewinNotIn(List<BigDecimal> values) {
            addCriterion("progressivewin not in", values, "progressivewin");
            return (Criteria) this;
        }

        public Criteria andProgressivewinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("progressivewin between", value1, value2, "progressivewin");
            return (Criteria) this;
        }

        public Criteria andProgressivewinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("progressivewin not between", value1, value2, "progressivewin");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andCurrentbetIsNull() {
            addCriterion("currentbet is null");
            return (Criteria) this;
        }

        public Criteria andCurrentbetIsNotNull() {
            addCriterion("currentbet is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentbetEqualTo(BigDecimal value) {
            addCriterion("currentbet =", value, "currentbet");
            return (Criteria) this;
        }

        public Criteria andCurrentbetNotEqualTo(BigDecimal value) {
            addCriterion("currentbet <>", value, "currentbet");
            return (Criteria) this;
        }

        public Criteria andCurrentbetGreaterThan(BigDecimal value) {
            addCriterion("currentbet >", value, "currentbet");
            return (Criteria) this;
        }

        public Criteria andCurrentbetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("currentbet >=", value, "currentbet");
            return (Criteria) this;
        }

        public Criteria andCurrentbetLessThan(BigDecimal value) {
            addCriterion("currentbet <", value, "currentbet");
            return (Criteria) this;
        }

        public Criteria andCurrentbetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("currentbet <=", value, "currentbet");
            return (Criteria) this;
        }

        public Criteria andCurrentbetIn(List<BigDecimal> values) {
            addCriterion("currentbet in", values, "currentbet");
            return (Criteria) this;
        }

        public Criteria andCurrentbetNotIn(List<BigDecimal> values) {
            addCriterion("currentbet not in", values, "currentbet");
            return (Criteria) this;
        }

        public Criteria andCurrentbetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("currentbet between", value1, value2, "currentbet");
            return (Criteria) this;
        }

        public Criteria andCurrentbetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("currentbet not between", value1, value2, "currentbet");
            return (Criteria) this;
        }

        public Criteria andRnumIsNull() {
            addCriterion("rnum is null");
            return (Criteria) this;
        }

        public Criteria andRnumIsNotNull() {
            addCriterion("rnum is not null");
            return (Criteria) this;
        }

        public Criteria andRnumEqualTo(Integer value) {
            addCriterion("rnum =", value, "rnum");
            return (Criteria) this;
        }

        public Criteria andRnumNotEqualTo(Integer value) {
            addCriterion("rnum <>", value, "rnum");
            return (Criteria) this;
        }

        public Criteria andRnumGreaterThan(Integer value) {
            addCriterion("rnum >", value, "rnum");
            return (Criteria) this;
        }

        public Criteria andRnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("rnum >=", value, "rnum");
            return (Criteria) this;
        }

        public Criteria andRnumLessThan(Integer value) {
            addCriterion("rnum <", value, "rnum");
            return (Criteria) this;
        }

        public Criteria andRnumLessThanOrEqualTo(Integer value) {
            addCriterion("rnum <=", value, "rnum");
            return (Criteria) this;
        }

        public Criteria andRnumIn(List<Integer> values) {
            addCriterion("rnum in", values, "rnum");
            return (Criteria) this;
        }

        public Criteria andRnumNotIn(List<Integer> values) {
            addCriterion("rnum not in", values, "rnum");
            return (Criteria) this;
        }

        public Criteria andRnumBetween(Integer value1, Integer value2) {
            addCriterion("rnum between", value1, value2, "rnum");
            return (Criteria) this;
        }

        public Criteria andRnumNotBetween(Integer value1, Integer value2) {
            addCriterion("rnum not between", value1, value2, "rnum");
            return (Criteria) this;
        }

        public Criteria andGamedateIsNull() {
            addCriterion("gamedate is null");
            return (Criteria) this;
        }

        public Criteria andGamedateIsNotNull() {
            addCriterion("gamedate is not null");
            return (Criteria) this;
        }

        public Criteria andGamedateEqualTo(Date value) {
            addCriterion("gamedate =", value, "gamedate");
            return (Criteria) this;
        }

        public Criteria andGamedateNotEqualTo(Date value) {
            addCriterion("gamedate <>", value, "gamedate");
            return (Criteria) this;
        }

        public Criteria andGamedateGreaterThan(Date value) {
            addCriterion("gamedate >", value, "gamedate");
            return (Criteria) this;
        }

        public Criteria andGamedateGreaterThanOrEqualTo(Date value) {
            addCriterion("gamedate >=", value, "gamedate");
            return (Criteria) this;
        }

        public Criteria andGamedateLessThan(Date value) {
            addCriterion("gamedate <", value, "gamedate");
            return (Criteria) this;
        }

        public Criteria andGamedateLessThanOrEqualTo(Date value) {
            addCriterion("gamedate <=", value, "gamedate");
            return (Criteria) this;
        }

        public Criteria andGamedateIn(List<Date> values) {
            addCriterion("gamedate in", values, "gamedate");
            return (Criteria) this;
        }

        public Criteria andGamedateNotIn(List<Date> values) {
            addCriterion("gamedate not in", values, "gamedate");
            return (Criteria) this;
        }

        public Criteria andGamedateBetween(Date value1, Date value2) {
            addCriterion("gamedate between", value1, value2, "gamedate");
            return (Criteria) this;
        }

        public Criteria andGamedateNotBetween(Date value1, Date value2) {
            addCriterion("gamedate not between", value1, value2, "gamedate");
            return (Criteria) this;
        }

        public Criteria andLivenetworkIsNull() {
            addCriterion("livenetwork is null");
            return (Criteria) this;
        }

        public Criteria andLivenetworkIsNotNull() {
            addCriterion("livenetwork is not null");
            return (Criteria) this;
        }

        public Criteria andLivenetworkEqualTo(String value) {
            addCriterion("livenetwork =", value, "livenetwork");
            return (Criteria) this;
        }

        public Criteria andLivenetworkNotEqualTo(String value) {
            addCriterion("livenetwork <>", value, "livenetwork");
            return (Criteria) this;
        }

        public Criteria andLivenetworkGreaterThan(String value) {
            addCriterion("livenetwork >", value, "livenetwork");
            return (Criteria) this;
        }

        public Criteria andLivenetworkGreaterThanOrEqualTo(String value) {
            addCriterion("livenetwork >=", value, "livenetwork");
            return (Criteria) this;
        }

        public Criteria andLivenetworkLessThan(String value) {
            addCriterion("livenetwork <", value, "livenetwork");
            return (Criteria) this;
        }

        public Criteria andLivenetworkLessThanOrEqualTo(String value) {
            addCriterion("livenetwork <=", value, "livenetwork");
            return (Criteria) this;
        }

        public Criteria andLivenetworkLike(String value) {
            addCriterion("livenetwork like", value, "livenetwork");
            return (Criteria) this;
        }

        public Criteria andLivenetworkNotLike(String value) {
            addCriterion("livenetwork not like", value, "livenetwork");
            return (Criteria) this;
        }

        public Criteria andLivenetworkIn(List<String> values) {
            addCriterion("livenetwork in", values, "livenetwork");
            return (Criteria) this;
        }

        public Criteria andLivenetworkNotIn(List<String> values) {
            addCriterion("livenetwork not in", values, "livenetwork");
            return (Criteria) this;
        }

        public Criteria andLivenetworkBetween(String value1, String value2) {
            addCriterion("livenetwork between", value1, value2, "livenetwork");
            return (Criteria) this;
        }

        public Criteria andLivenetworkNotBetween(String value1, String value2) {
            addCriterion("livenetwork not between", value1, value2, "livenetwork");
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
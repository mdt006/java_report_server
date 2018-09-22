package com.kg.live.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DsAgHunterInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsAgHunterInfoExample() {
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

        public Criteria andAgentCodeIsNull() {
            addCriterion("agent_code is null");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIsNotNull() {
            addCriterion("agent_code is not null");
            return (Criteria) this;
        }

        public Criteria andAgentCodeEqualTo(String value) {
            addCriterion("agent_code =", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotEqualTo(String value) {
            addCriterion("agent_code <>", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeGreaterThan(String value) {
            addCriterion("agent_code >", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("agent_code >=", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLessThan(String value) {
            addCriterion("agent_code <", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLessThanOrEqualTo(String value) {
            addCriterion("agent_code <=", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLike(String value) {
            addCriterion("agent_code like", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotLike(String value) {
            addCriterion("agent_code not like", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIn(List<String> values) {
            addCriterion("agent_code in", values, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotIn(List<String> values) {
            addCriterion("agent_code not in", values, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeBetween(String value1, String value2) {
            addCriterion("agent_code between", value1, value2, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotBetween(String value1, String value2) {
            addCriterion("agent_code not between", value1, value2, "agentCode");
            return (Criteria) this;
        }

        public Criteria andNamepreIsNull() {
            addCriterion("namepre is null");
            return (Criteria) this;
        }

        public Criteria andNamepreIsNotNull() {
            addCriterion("namepre is not null");
            return (Criteria) this;
        }

        public Criteria andNamepreEqualTo(String value) {
            addCriterion("namepre =", value, "namepre");
            return (Criteria) this;
        }

        public Criteria andNamepreNotEqualTo(String value) {
            addCriterion("namepre <>", value, "namepre");
            return (Criteria) this;
        }

        public Criteria andNamepreGreaterThan(String value) {
            addCriterion("namepre >", value, "namepre");
            return (Criteria) this;
        }

        public Criteria andNamepreGreaterThanOrEqualTo(String value) {
            addCriterion("namepre >=", value, "namepre");
            return (Criteria) this;
        }

        public Criteria andNamepreLessThan(String value) {
            addCriterion("namepre <", value, "namepre");
            return (Criteria) this;
        }

        public Criteria andNamepreLessThanOrEqualTo(String value) {
            addCriterion("namepre <=", value, "namepre");
            return (Criteria) this;
        }

        public Criteria andNamepreLike(String value) {
            addCriterion("namepre like", value, "namepre");
            return (Criteria) this;
        }

        public Criteria andNamepreNotLike(String value) {
            addCriterion("namepre not like", value, "namepre");
            return (Criteria) this;
        }

        public Criteria andNamepreIn(List<String> values) {
            addCriterion("namepre in", values, "namepre");
            return (Criteria) this;
        }

        public Criteria andNamepreNotIn(List<String> values) {
            addCriterion("namepre not in", values, "namepre");
            return (Criteria) this;
        }

        public Criteria andNamepreBetween(String value1, String value2) {
            addCriterion("namepre between", value1, value2, "namepre");
            return (Criteria) this;
        }

        public Criteria andNamepreNotBetween(String value1, String value2) {
            addCriterion("namepre not between", value1, value2, "namepre");
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

        public Criteria andBillIdIsNull() {
            addCriterion("bill_id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(String value) {
            addCriterion("bill_id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(String value) {
            addCriterion("bill_id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(String value) {
            addCriterion("bill_id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("bill_id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(String value) {
            addCriterion("bill_id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(String value) {
            addCriterion("bill_id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLike(String value) {
            addCriterion("bill_id like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotLike(String value) {
            addCriterion("bill_id not like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<String> values) {
            addCriterion("bill_id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<String> values) {
            addCriterion("bill_id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(String value1, String value2) {
            addCriterion("bill_id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(String value1, String value2) {
            addCriterion("bill_id not between", value1, value2, "billId");
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

        public Criteria andSceneIdIsNull() {
            addCriterion("scene_id is null");
            return (Criteria) this;
        }

        public Criteria andSceneIdIsNotNull() {
            addCriterion("scene_id is not null");
            return (Criteria) this;
        }

        public Criteria andSceneIdEqualTo(String value) {
            addCriterion("scene_id =", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdNotEqualTo(String value) {
            addCriterion("scene_id <>", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdGreaterThan(String value) {
            addCriterion("scene_id >", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdGreaterThanOrEqualTo(String value) {
            addCriterion("scene_id >=", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdLessThan(String value) {
            addCriterion("scene_id <", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdLessThanOrEqualTo(String value) {
            addCriterion("scene_id <=", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdLike(String value) {
            addCriterion("scene_id like", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdNotLike(String value) {
            addCriterion("scene_id not like", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdIn(List<String> values) {
            addCriterion("scene_id in", values, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdNotIn(List<String> values) {
            addCriterion("scene_id not in", values, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdBetween(String value1, String value2) {
            addCriterion("scene_id between", value1, value2, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdNotBetween(String value1, String value2) {
            addCriterion("scene_id not between", value1, value2, "sceneId");
            return (Criteria) this;
        }

        public Criteria andPlayerNameIsNull() {
            addCriterion("player_name is null");
            return (Criteria) this;
        }

        public Criteria andPlayerNameIsNotNull() {
            addCriterion("player_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerNameEqualTo(String value) {
            addCriterion("player_name =", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameNotEqualTo(String value) {
            addCriterion("player_name <>", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameGreaterThan(String value) {
            addCriterion("player_name >", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameGreaterThanOrEqualTo(String value) {
            addCriterion("player_name >=", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameLessThan(String value) {
            addCriterion("player_name <", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameLessThanOrEqualTo(String value) {
            addCriterion("player_name <=", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameLike(String value) {
            addCriterion("player_name like", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameNotLike(String value) {
            addCriterion("player_name not like", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameIn(List<String> values) {
            addCriterion("player_name in", values, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameNotIn(List<String> values) {
            addCriterion("player_name not in", values, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameBetween(String value1, String value2) {
            addCriterion("player_name between", value1, value2, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameNotBetween(String value1, String value2) {
            addCriterion("player_name not between", value1, value2, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIsNull() {
            addCriterion("platform_id is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIsNotNull() {
            addCriterion("platform_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdEqualTo(String value) {
            addCriterion("platform_id =", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotEqualTo(String value) {
            addCriterion("platform_id <>", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdGreaterThan(String value) {
            addCriterion("platform_id >", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdGreaterThanOrEqualTo(String value) {
            addCriterion("platform_id >=", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdLessThan(String value) {
            addCriterion("platform_id <", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdLessThanOrEqualTo(String value) {
            addCriterion("platform_id <=", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdLike(String value) {
            addCriterion("platform_id like", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotLike(String value) {
            addCriterion("platform_id not like", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIn(List<String> values) {
            addCriterion("platform_id in", values, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotIn(List<String> values) {
            addCriterion("platform_id not in", values, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdBetween(String value1, String value2) {
            addCriterion("platform_id between", value1, value2, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotBetween(String value1, String value2) {
            addCriterion("platform_id not between", value1, value2, "platformId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(Byte value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(Byte value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(Byte value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(Byte value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(Byte value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<Byte> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<Byte> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(Byte value1, Byte value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNull() {
            addCriterion("bill_type is null");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNotNull() {
            addCriterion("bill_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypeEqualTo(Byte value) {
            addCriterion("bill_type =", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotEqualTo(Byte value) {
            addCriterion("bill_type <>", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThan(Byte value) {
            addCriterion("bill_type >", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("bill_type >=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThan(Byte value) {
            addCriterion("bill_type <", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThanOrEqualTo(Byte value) {
            addCriterion("bill_type <=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIn(List<Byte> values) {
            addCriterion("bill_type in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotIn(List<Byte> values) {
            addCriterion("bill_type not in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeBetween(Byte value1, Byte value2) {
            addCriterion("bill_type between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("bill_type not between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andSceneStartTimeIsNull() {
            addCriterion("scene_start_time is null");
            return (Criteria) this;
        }

        public Criteria andSceneStartTimeIsNotNull() {
            addCriterion("scene_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andSceneStartTimeEqualTo(Date value) {
            addCriterion("scene_start_time =", value, "sceneStartTime");
            return (Criteria) this;
        }

        public Criteria andSceneStartTimeNotEqualTo(Date value) {
            addCriterion("scene_start_time <>", value, "sceneStartTime");
            return (Criteria) this;
        }

        public Criteria andSceneStartTimeGreaterThan(Date value) {
            addCriterion("scene_start_time >", value, "sceneStartTime");
            return (Criteria) this;
        }

        public Criteria andSceneStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("scene_start_time >=", value, "sceneStartTime");
            return (Criteria) this;
        }

        public Criteria andSceneStartTimeLessThan(Date value) {
            addCriterion("scene_start_time <", value, "sceneStartTime");
            return (Criteria) this;
        }

        public Criteria andSceneStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("scene_start_time <=", value, "sceneStartTime");
            return (Criteria) this;
        }

        public Criteria andSceneStartTimeIn(List<Date> values) {
            addCriterion("scene_start_time in", values, "sceneStartTime");
            return (Criteria) this;
        }

        public Criteria andSceneStartTimeNotIn(List<Date> values) {
            addCriterion("scene_start_time not in", values, "sceneStartTime");
            return (Criteria) this;
        }

        public Criteria andSceneStartTimeBetween(Date value1, Date value2) {
            addCriterion("scene_start_time between", value1, value2, "sceneStartTime");
            return (Criteria) this;
        }

        public Criteria andSceneStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("scene_start_time not between", value1, value2, "sceneStartTime");
            return (Criteria) this;
        }

        public Criteria andSceneEndTimeIsNull() {
            addCriterion("scene_end_time is null");
            return (Criteria) this;
        }

        public Criteria andSceneEndTimeIsNotNull() {
            addCriterion("scene_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andSceneEndTimeEqualTo(Date value) {
            addCriterion("scene_end_time =", value, "sceneEndTime");
            return (Criteria) this;
        }

        public Criteria andSceneEndTimeNotEqualTo(Date value) {
            addCriterion("scene_end_time <>", value, "sceneEndTime");
            return (Criteria) this;
        }

        public Criteria andSceneEndTimeGreaterThan(Date value) {
            addCriterion("scene_end_time >", value, "sceneEndTime");
            return (Criteria) this;
        }

        public Criteria andSceneEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("scene_end_time >=", value, "sceneEndTime");
            return (Criteria) this;
        }

        public Criteria andSceneEndTimeLessThan(Date value) {
            addCriterion("scene_end_time <", value, "sceneEndTime");
            return (Criteria) this;
        }

        public Criteria andSceneEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("scene_end_time <=", value, "sceneEndTime");
            return (Criteria) this;
        }

        public Criteria andSceneEndTimeIn(List<Date> values) {
            addCriterion("scene_end_time in", values, "sceneEndTime");
            return (Criteria) this;
        }

        public Criteria andSceneEndTimeNotIn(List<Date> values) {
            addCriterion("scene_end_time not in", values, "sceneEndTime");
            return (Criteria) this;
        }

        public Criteria andSceneEndTimeBetween(Date value1, Date value2) {
            addCriterion("scene_end_time between", value1, value2, "sceneEndTime");
            return (Criteria) this;
        }

        public Criteria andSceneEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("scene_end_time not between", value1, value2, "sceneEndTime");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNull() {
            addCriterion("roomid is null");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNotNull() {
            addCriterion("roomid is not null");
            return (Criteria) this;
        }

        public Criteria andRoomidEqualTo(String value) {
            addCriterion("roomid =", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotEqualTo(String value) {
            addCriterion("roomid <>", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThan(String value) {
            addCriterion("roomid >", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThanOrEqualTo(String value) {
            addCriterion("roomid >=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThan(String value) {
            addCriterion("roomid <", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThanOrEqualTo(String value) {
            addCriterion("roomid <=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLike(String value) {
            addCriterion("roomid like", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotLike(String value) {
            addCriterion("roomid not like", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidIn(List<String> values) {
            addCriterion("roomid in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotIn(List<String> values) {
            addCriterion("roomid not in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidBetween(String value1, String value2) {
            addCriterion("roomid between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotBetween(String value1, String value2) {
            addCriterion("roomid not between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoombetIsNull() {
            addCriterion("roombet is null");
            return (Criteria) this;
        }

        public Criteria andRoombetIsNotNull() {
            addCriterion("roombet is not null");
            return (Criteria) this;
        }

        public Criteria andRoombetEqualTo(BigDecimal value) {
            addCriterion("roombet =", value, "roombet");
            return (Criteria) this;
        }

        public Criteria andRoombetNotEqualTo(BigDecimal value) {
            addCriterion("roombet <>", value, "roombet");
            return (Criteria) this;
        }

        public Criteria andRoombetGreaterThan(BigDecimal value) {
            addCriterion("roombet >", value, "roombet");
            return (Criteria) this;
        }

        public Criteria andRoombetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("roombet >=", value, "roombet");
            return (Criteria) this;
        }

        public Criteria andRoombetLessThan(BigDecimal value) {
            addCriterion("roombet <", value, "roombet");
            return (Criteria) this;
        }

        public Criteria andRoombetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("roombet <=", value, "roombet");
            return (Criteria) this;
        }

        public Criteria andRoombetIn(List<BigDecimal> values) {
            addCriterion("roombet in", values, "roombet");
            return (Criteria) this;
        }

        public Criteria andRoombetNotIn(List<BigDecimal> values) {
            addCriterion("roombet not in", values, "roombet");
            return (Criteria) this;
        }

        public Criteria andRoombetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("roombet between", value1, value2, "roombet");
            return (Criteria) this;
        }

        public Criteria andRoombetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("roombet not between", value1, value2, "roombet");
            return (Criteria) this;
        }

        public Criteria andJpDrawIsNull() {
            addCriterion("jp_draw is null");
            return (Criteria) this;
        }

        public Criteria andJpDrawIsNotNull() {
            addCriterion("jp_draw is not null");
            return (Criteria) this;
        }

        public Criteria andJpDrawEqualTo(BigDecimal value) {
            addCriterion("jp_draw =", value, "jpDraw");
            return (Criteria) this;
        }

        public Criteria andJpDrawNotEqualTo(BigDecimal value) {
            addCriterion("jp_draw <>", value, "jpDraw");
            return (Criteria) this;
        }

        public Criteria andJpDrawGreaterThan(BigDecimal value) {
            addCriterion("jp_draw >", value, "jpDraw");
            return (Criteria) this;
        }

        public Criteria andJpDrawGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jp_draw >=", value, "jpDraw");
            return (Criteria) this;
        }

        public Criteria andJpDrawLessThan(BigDecimal value) {
            addCriterion("jp_draw <", value, "jpDraw");
            return (Criteria) this;
        }

        public Criteria andJpDrawLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jp_draw <=", value, "jpDraw");
            return (Criteria) this;
        }

        public Criteria andJpDrawIn(List<BigDecimal> values) {
            addCriterion("jp_draw in", values, "jpDraw");
            return (Criteria) this;
        }

        public Criteria andJpDrawNotIn(List<BigDecimal> values) {
            addCriterion("jp_draw not in", values, "jpDraw");
            return (Criteria) this;
        }

        public Criteria andJpDrawBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jp_draw between", value1, value2, "jpDraw");
            return (Criteria) this;
        }

        public Criteria andJpDrawNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jp_draw not between", value1, value2, "jpDraw");
            return (Criteria) this;
        }

        public Criteria andSceneExIsNull() {
            addCriterion("scene_ex is null");
            return (Criteria) this;
        }

        public Criteria andSceneExIsNotNull() {
            addCriterion("scene_ex is not null");
            return (Criteria) this;
        }

        public Criteria andSceneExEqualTo(BigDecimal value) {
            addCriterion("scene_ex =", value, "sceneEx");
            return (Criteria) this;
        }

        public Criteria andSceneExNotEqualTo(BigDecimal value) {
            addCriterion("scene_ex <>", value, "sceneEx");
            return (Criteria) this;
        }

        public Criteria andSceneExGreaterThan(BigDecimal value) {
            addCriterion("scene_ex >", value, "sceneEx");
            return (Criteria) this;
        }

        public Criteria andSceneExGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("scene_ex >=", value, "sceneEx");
            return (Criteria) this;
        }

        public Criteria andSceneExLessThan(BigDecimal value) {
            addCriterion("scene_ex <", value, "sceneEx");
            return (Criteria) this;
        }

        public Criteria andSceneExLessThanOrEqualTo(BigDecimal value) {
            addCriterion("scene_ex <=", value, "sceneEx");
            return (Criteria) this;
        }

        public Criteria andSceneExIn(List<BigDecimal> values) {
            addCriterion("scene_ex in", values, "sceneEx");
            return (Criteria) this;
        }

        public Criteria andSceneExNotIn(List<BigDecimal> values) {
            addCriterion("scene_ex not in", values, "sceneEx");
            return (Criteria) this;
        }

        public Criteria andSceneExBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("scene_ex between", value1, value2, "sceneEx");
            return (Criteria) this;
        }

        public Criteria andSceneExNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("scene_ex not between", value1, value2, "sceneEx");
            return (Criteria) this;
        }

        public Criteria andBombDrawIsNull() {
            addCriterion("bomb_draw is null");
            return (Criteria) this;
        }

        public Criteria andBombDrawIsNotNull() {
            addCriterion("bomb_draw is not null");
            return (Criteria) this;
        }

        public Criteria andBombDrawEqualTo(Byte value) {
            addCriterion("bomb_draw =", value, "bombDraw");
            return (Criteria) this;
        }

        public Criteria andBombDrawNotEqualTo(Byte value) {
            addCriterion("bomb_draw <>", value, "bombDraw");
            return (Criteria) this;
        }

        public Criteria andBombDrawGreaterThan(Byte value) {
            addCriterion("bomb_draw >", value, "bombDraw");
            return (Criteria) this;
        }

        public Criteria andBombDrawGreaterThanOrEqualTo(Byte value) {
            addCriterion("bomb_draw >=", value, "bombDraw");
            return (Criteria) this;
        }

        public Criteria andBombDrawLessThan(Byte value) {
            addCriterion("bomb_draw <", value, "bombDraw");
            return (Criteria) this;
        }

        public Criteria andBombDrawLessThanOrEqualTo(Byte value) {
            addCriterion("bomb_draw <=", value, "bombDraw");
            return (Criteria) this;
        }

        public Criteria andBombDrawIn(List<Byte> values) {
            addCriterion("bomb_draw in", values, "bombDraw");
            return (Criteria) this;
        }

        public Criteria andBombDrawNotIn(List<Byte> values) {
            addCriterion("bomb_draw not in", values, "bombDraw");
            return (Criteria) this;
        }

        public Criteria andBombDrawBetween(Byte value1, Byte value2) {
            addCriterion("bomb_draw between", value1, value2, "bombDraw");
            return (Criteria) this;
        }

        public Criteria andBombDrawNotBetween(Byte value1, Byte value2) {
            addCriterion("bomb_draw not between", value1, value2, "bombDraw");
            return (Criteria) this;
        }

        public Criteria andBulletOutNumIsNull() {
            addCriterion("bullet_out_num is null");
            return (Criteria) this;
        }

        public Criteria andBulletOutNumIsNotNull() {
            addCriterion("bullet_out_num is not null");
            return (Criteria) this;
        }

        public Criteria andBulletOutNumEqualTo(Integer value) {
            addCriterion("bullet_out_num =", value, "bulletOutNum");
            return (Criteria) this;
        }

        public Criteria andBulletOutNumNotEqualTo(Integer value) {
            addCriterion("bullet_out_num <>", value, "bulletOutNum");
            return (Criteria) this;
        }

        public Criteria andBulletOutNumGreaterThan(Integer value) {
            addCriterion("bullet_out_num >", value, "bulletOutNum");
            return (Criteria) this;
        }

        public Criteria andBulletOutNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("bullet_out_num >=", value, "bulletOutNum");
            return (Criteria) this;
        }

        public Criteria andBulletOutNumLessThan(Integer value) {
            addCriterion("bullet_out_num <", value, "bulletOutNum");
            return (Criteria) this;
        }

        public Criteria andBulletOutNumLessThanOrEqualTo(Integer value) {
            addCriterion("bullet_out_num <=", value, "bulletOutNum");
            return (Criteria) this;
        }

        public Criteria andBulletOutNumIn(List<Integer> values) {
            addCriterion("bullet_out_num in", values, "bulletOutNum");
            return (Criteria) this;
        }

        public Criteria andBulletOutNumNotIn(List<Integer> values) {
            addCriterion("bullet_out_num not in", values, "bulletOutNum");
            return (Criteria) this;
        }

        public Criteria andBulletOutNumBetween(Integer value1, Integer value2) {
            addCriterion("bullet_out_num between", value1, value2, "bulletOutNum");
            return (Criteria) this;
        }

        public Criteria andBulletOutNumNotBetween(Integer value1, Integer value2) {
            addCriterion("bullet_out_num not between", value1, value2, "bulletOutNum");
            return (Criteria) this;
        }

        public Criteria andBillHitNumIsNull() {
            addCriterion("bill_hit_num is null");
            return (Criteria) this;
        }

        public Criteria andBillHitNumIsNotNull() {
            addCriterion("bill_hit_num is not null");
            return (Criteria) this;
        }

        public Criteria andBillHitNumEqualTo(Integer value) {
            addCriterion("bill_hit_num =", value, "billHitNum");
            return (Criteria) this;
        }

        public Criteria andBillHitNumNotEqualTo(Integer value) {
            addCriterion("bill_hit_num <>", value, "billHitNum");
            return (Criteria) this;
        }

        public Criteria andBillHitNumGreaterThan(Integer value) {
            addCriterion("bill_hit_num >", value, "billHitNum");
            return (Criteria) this;
        }

        public Criteria andBillHitNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("bill_hit_num >=", value, "billHitNum");
            return (Criteria) this;
        }

        public Criteria andBillHitNumLessThan(Integer value) {
            addCriterion("bill_hit_num <", value, "billHitNum");
            return (Criteria) this;
        }

        public Criteria andBillHitNumLessThanOrEqualTo(Integer value) {
            addCriterion("bill_hit_num <=", value, "billHitNum");
            return (Criteria) this;
        }

        public Criteria andBillHitNumIn(List<Integer> values) {
            addCriterion("bill_hit_num in", values, "billHitNum");
            return (Criteria) this;
        }

        public Criteria andBillHitNumNotIn(List<Integer> values) {
            addCriterion("bill_hit_num not in", values, "billHitNum");
            return (Criteria) this;
        }

        public Criteria andBillHitNumBetween(Integer value1, Integer value2) {
            addCriterion("bill_hit_num between", value1, value2, "billHitNum");
            return (Criteria) this;
        }

        public Criteria andBillHitNumNotBetween(Integer value1, Integer value2) {
            addCriterion("bill_hit_num not between", value1, value2, "billHitNum");
            return (Criteria) this;
        }

        public Criteria andEarnIsNull() {
            addCriterion("earn is null");
            return (Criteria) this;
        }

        public Criteria andEarnIsNotNull() {
            addCriterion("earn is not null");
            return (Criteria) this;
        }

        public Criteria andEarnEqualTo(BigDecimal value) {
            addCriterion("earn =", value, "earn");
            return (Criteria) this;
        }

        public Criteria andEarnNotEqualTo(BigDecimal value) {
            addCriterion("earn <>", value, "earn");
            return (Criteria) this;
        }

        public Criteria andEarnGreaterThan(BigDecimal value) {
            addCriterion("earn >", value, "earn");
            return (Criteria) this;
        }

        public Criteria andEarnGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("earn >=", value, "earn");
            return (Criteria) this;
        }

        public Criteria andEarnLessThan(BigDecimal value) {
            addCriterion("earn <", value, "earn");
            return (Criteria) this;
        }

        public Criteria andEarnLessThanOrEqualTo(BigDecimal value) {
            addCriterion("earn <=", value, "earn");
            return (Criteria) this;
        }

        public Criteria andEarnIn(List<BigDecimal> values) {
            addCriterion("earn in", values, "earn");
            return (Criteria) this;
        }

        public Criteria andEarnNotIn(List<BigDecimal> values) {
            addCriterion("earn not in", values, "earn");
            return (Criteria) this;
        }

        public Criteria andEarnBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("earn between", value1, value2, "earn");
            return (Criteria) this;
        }

        public Criteria andEarnNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("earn not between", value1, value2, "earn");
            return (Criteria) this;
        }

        public Criteria andNetAmountIsNull() {
            addCriterion("net_amount is null");
            return (Criteria) this;
        }

        public Criteria andNetAmountIsNotNull() {
            addCriterion("net_amount is not null");
            return (Criteria) this;
        }

        public Criteria andNetAmountEqualTo(BigDecimal value) {
            addCriterion("net_amount =", value, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountNotEqualTo(BigDecimal value) {
            addCriterion("net_amount <>", value, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountGreaterThan(BigDecimal value) {
            addCriterion("net_amount >", value, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("net_amount >=", value, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountLessThan(BigDecimal value) {
            addCriterion("net_amount <", value, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("net_amount <=", value, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountIn(List<BigDecimal> values) {
            addCriterion("net_amount in", values, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountNotIn(List<BigDecimal> values) {
            addCriterion("net_amount not in", values, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_amount between", value1, value2, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_amount not between", value1, value2, "netAmount");
            return (Criteria) this;
        }

        public Criteria andJackpotcommIsNull() {
            addCriterion("jackpotcomm is null");
            return (Criteria) this;
        }

        public Criteria andJackpotcommIsNotNull() {
            addCriterion("jackpotcomm is not null");
            return (Criteria) this;
        }

        public Criteria andJackpotcommEqualTo(BigDecimal value) {
            addCriterion("jackpotcomm =", value, "jackpotcomm");
            return (Criteria) this;
        }

        public Criteria andJackpotcommNotEqualTo(BigDecimal value) {
            addCriterion("jackpotcomm <>", value, "jackpotcomm");
            return (Criteria) this;
        }

        public Criteria andJackpotcommGreaterThan(BigDecimal value) {
            addCriterion("jackpotcomm >", value, "jackpotcomm");
            return (Criteria) this;
        }

        public Criteria andJackpotcommGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jackpotcomm >=", value, "jackpotcomm");
            return (Criteria) this;
        }

        public Criteria andJackpotcommLessThan(BigDecimal value) {
            addCriterion("jackpotcomm <", value, "jackpotcomm");
            return (Criteria) this;
        }

        public Criteria andJackpotcommLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jackpotcomm <=", value, "jackpotcomm");
            return (Criteria) this;
        }

        public Criteria andJackpotcommIn(List<BigDecimal> values) {
            addCriterion("jackpotcomm in", values, "jackpotcomm");
            return (Criteria) this;
        }

        public Criteria andJackpotcommNotIn(List<BigDecimal> values) {
            addCriterion("jackpotcomm not in", values, "jackpotcomm");
            return (Criteria) this;
        }

        public Criteria andJackpotcommBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jackpotcomm between", value1, value2, "jackpotcomm");
            return (Criteria) this;
        }

        public Criteria andJackpotcommNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jackpotcomm not between", value1, value2, "jackpotcomm");
            return (Criteria) this;
        }

        public Criteria andValidBetAmountIsNull() {
            addCriterion("valid_bet_amount is null");
            return (Criteria) this;
        }

        public Criteria andValidBetAmountIsNotNull() {
            addCriterion("valid_bet_amount is not null");
            return (Criteria) this;
        }

        public Criteria andValidBetAmountEqualTo(BigDecimal value) {
            addCriterion("valid_bet_amount =", value, "validBetAmount");
            return (Criteria) this;
        }

        public Criteria andValidBetAmountNotEqualTo(BigDecimal value) {
            addCriterion("valid_bet_amount <>", value, "validBetAmount");
            return (Criteria) this;
        }

        public Criteria andValidBetAmountGreaterThan(BigDecimal value) {
            addCriterion("valid_bet_amount >", value, "validBetAmount");
            return (Criteria) this;
        }

        public Criteria andValidBetAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("valid_bet_amount >=", value, "validBetAmount");
            return (Criteria) this;
        }

        public Criteria andValidBetAmountLessThan(BigDecimal value) {
            addCriterion("valid_bet_amount <", value, "validBetAmount");
            return (Criteria) this;
        }

        public Criteria andValidBetAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("valid_bet_amount <=", value, "validBetAmount");
            return (Criteria) this;
        }

        public Criteria andValidBetAmountIn(List<BigDecimal> values) {
            addCriterion("valid_bet_amount in", values, "validBetAmount");
            return (Criteria) this;
        }

        public Criteria andValidBetAmountNotIn(List<BigDecimal> values) {
            addCriterion("valid_bet_amount not in", values, "validBetAmount");
            return (Criteria) this;
        }

        public Criteria andValidBetAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("valid_bet_amount between", value1, value2, "validBetAmount");
            return (Criteria) this;
        }

        public Criteria andValidBetAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("valid_bet_amount not between", value1, value2, "validBetAmount");
            return (Criteria) this;
        }

        public Criteria andBetAmountIsNull() {
            addCriterion("bet_amount is null");
            return (Criteria) this;
        }

        public Criteria andBetAmountIsNotNull() {
            addCriterion("bet_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBetAmountEqualTo(BigDecimal value) {
            addCriterion("bet_amount =", value, "betAmount");
            return (Criteria) this;
        }

        public Criteria andBetAmountNotEqualTo(BigDecimal value) {
            addCriterion("bet_amount <>", value, "betAmount");
            return (Criteria) this;
        }

        public Criteria andBetAmountGreaterThan(BigDecimal value) {
            addCriterion("bet_amount >", value, "betAmount");
            return (Criteria) this;
        }

        public Criteria andBetAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bet_amount >=", value, "betAmount");
            return (Criteria) this;
        }

        public Criteria andBetAmountLessThan(BigDecimal value) {
            addCriterion("bet_amount <", value, "betAmount");
            return (Criteria) this;
        }

        public Criteria andBetAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bet_amount <=", value, "betAmount");
            return (Criteria) this;
        }

        public Criteria andBetAmountIn(List<BigDecimal> values) {
            addCriterion("bet_amount in", values, "betAmount");
            return (Criteria) this;
        }

        public Criteria andBetAmountNotIn(List<BigDecimal> values) {
            addCriterion("bet_amount not in", values, "betAmount");
            return (Criteria) this;
        }

        public Criteria andBetAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bet_amount between", value1, value2, "betAmount");
            return (Criteria) this;
        }

        public Criteria andBetAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bet_amount not between", value1, value2, "betAmount");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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
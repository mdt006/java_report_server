package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DsReportExample {
    protected String orderByClause;
    
	protected Integer page;

	protected Integer pageLimit;
    
    //是否需要汇总数据
    protected boolean needTotal;
    
    //层级
    protected String agentLevel;
    
    //排序 asc desc
    protected String orderType;
    
    //有效投注金额
    protected BigDecimal defValidamount;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

    public DsReportExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
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

    
    public boolean isNeedTotal() {
		return needTotal;
	}

	public void setNeedTotal(boolean needTotal) {
		this.needTotal = needTotal;
	}
	
	public String getAgentLevel() {
		return agentLevel;
	}

	public void setAgentLevel(String agentLevel) {
		this.agentLevel = agentLevel;
	}

    public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	 public BigDecimal getDefValidamount() {
		return defValidamount;
	}

	public void setDefValidamount(BigDecimal defValidamount) {
		this.defValidamount = defValidamount;
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

        public Criteria andAgentsIsNull() {
            addCriterion("agents is null");
            return (Criteria) this;
        }

        public Criteria andAgentsIsNotNull() {
            addCriterion("agents is not null");
            return (Criteria) this;
        }

        public Criteria andAgentsEqualTo(String value) {
            addCriterion("agents =", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsNotEqualTo(String value) {
            addCriterion("agents <>", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsGreaterThan(String value) {
            addCriterion("agents >", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsGreaterThanOrEqualTo(String value) {
            addCriterion("agents >=", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsLessThan(String value) {
            addCriterion("agents <", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsLessThanOrEqualTo(String value) {
            addCriterion("agents <=", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsLike(String value) {
            addCriterion("agents like", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsNotLike(String value) {
            addCriterion("agents not like", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsIn(List<String> values) {
            addCriterion("agents in", values, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsNotIn(List<String> values) {
            addCriterion("agents not in", values, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsBetween(String value1, String value2) {
            addCriterion("agents between", value1, value2, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsNotBetween(String value1, String value2) {
            addCriterion("agents not between", value1, value2, "agents");
            return (Criteria) this;
        }

        public Criteria andWorldIsNull() {
            addCriterion("world is null");
            return (Criteria) this;
        }

        public Criteria andWorldIsNotNull() {
            addCriterion("world is not null");
            return (Criteria) this;
        }

        public Criteria andWorldEqualTo(String value) {
            addCriterion("world =", value, "world");
            return (Criteria) this;
        }

        public Criteria andWorldNotEqualTo(String value) {
            addCriterion("world <>", value, "world");
            return (Criteria) this;
        }

        public Criteria andWorldGreaterThan(String value) {
            addCriterion("world >", value, "world");
            return (Criteria) this;
        }

        public Criteria andWorldGreaterThanOrEqualTo(String value) {
            addCriterion("world >=", value, "world");
            return (Criteria) this;
        }

        public Criteria andWorldLessThan(String value) {
            addCriterion("world <", value, "world");
            return (Criteria) this;
        }

        public Criteria andWorldLessThanOrEqualTo(String value) {
            addCriterion("world <=", value, "world");
            return (Criteria) this;
        }

        public Criteria andWorldLike(String value) {
            addCriterion("world like", value, "world");
            return (Criteria) this;
        }

        public Criteria andWorldNotLike(String value) {
            addCriterion("world not like", value, "world");
            return (Criteria) this;
        }

        public Criteria andWorldIn(List<String> values) {
            addCriterion("world in", values, "world");
            return (Criteria) this;
        }

        public Criteria andWorldNotIn(List<String> values) {
            addCriterion("world not in", values, "world");
            return (Criteria) this;
        }

        public Criteria andWorldBetween(String value1, String value2) {
            addCriterion("world between", value1, value2, "world");
            return (Criteria) this;
        }

        public Criteria andWorldNotBetween(String value1, String value2) {
            addCriterion("world not between", value1, value2, "world");
            return (Criteria) this;
        }

        public Criteria andCorpratorIsNull() {
            addCriterion("corprator is null");
            return (Criteria) this;
        }

        public Criteria andCorpratorIsNotNull() {
            addCriterion("corprator is not null");
            return (Criteria) this;
        }

        public Criteria andCorpratorEqualTo(String value) {
            addCriterion("corprator =", value, "corprator");
            return (Criteria) this;
        }

        public Criteria andCorpratorNotEqualTo(String value) {
            addCriterion("corprator <>", value, "corprator");
            return (Criteria) this;
        }

        public Criteria andCorpratorGreaterThan(String value) {
            addCriterion("corprator >", value, "corprator");
            return (Criteria) this;
        }

        public Criteria andCorpratorGreaterThanOrEqualTo(String value) {
            addCriterion("corprator >=", value, "corprator");
            return (Criteria) this;
        }

        public Criteria andCorpratorLessThan(String value) {
            addCriterion("corprator <", value, "corprator");
            return (Criteria) this;
        }

        public Criteria andCorpratorLessThanOrEqualTo(String value) {
            addCriterion("corprator <=", value, "corprator");
            return (Criteria) this;
        }

        public Criteria andCorpratorLike(String value) {
            addCriterion("corprator like", value, "corprator");
            return (Criteria) this;
        }

        public Criteria andCorpratorNotLike(String value) {
            addCriterion("corprator not like", value, "corprator");
            return (Criteria) this;
        }

        public Criteria andCorpratorIn(List<String> values) {
            addCriterion("corprator in", values, "corprator");
            return (Criteria) this;
        }

        public Criteria andCorpratorNotIn(List<String> values) {
            addCriterion("corprator not in", values, "corprator");
            return (Criteria) this;
        }

        public Criteria andCorpratorBetween(String value1, String value2) {
            addCriterion("corprator between", value1, value2, "corprator");
            return (Criteria) this;
        }

        public Criteria andCorpratorNotBetween(String value1, String value2) {
            addCriterion("corprator not between", value1, value2, "corprator");
            return (Criteria) this;
        }

        public Criteria andSuperiorIsNull() {
            addCriterion("superior is null");
            return (Criteria) this;
        }

        public Criteria andSuperiorIsNotNull() {
            addCriterion("superior is not null");
            return (Criteria) this;
        }

        public Criteria andSuperiorEqualTo(String value) {
            addCriterion("superior =", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorNotEqualTo(String value) {
            addCriterion("superior <>", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorGreaterThan(String value) {
            addCriterion("superior >", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorGreaterThanOrEqualTo(String value) {
            addCriterion("superior >=", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorLessThan(String value) {
            addCriterion("superior <", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorLessThanOrEqualTo(String value) {
            addCriterion("superior <=", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorLike(String value) {
            addCriterion("superior like", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorNotLike(String value) {
            addCriterion("superior not like", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorIn(List<String> values) {
            addCriterion("superior in", values, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorNotIn(List<String> values) {
            addCriterion("superior not in", values, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorBetween(String value1, String value2) {
            addCriterion("superior between", value1, value2, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorNotBetween(String value1, String value2) {
            addCriterion("superior not between", value1, value2, "superior");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCommAgentIsNull() {
            addCriterion("comm_agent is null");
            return (Criteria) this;
        }

        public Criteria andCommAgentIsNotNull() {
            addCriterion("comm_agent is not null");
            return (Criteria) this;
        }

        public Criteria andCommAgentEqualTo(BigDecimal value) {
            addCriterion("comm_agent =", value, "commAgent");
            return (Criteria) this;
        }

        public Criteria andCommAgentNotEqualTo(BigDecimal value) {
            addCriterion("comm_agent <>", value, "commAgent");
            return (Criteria) this;
        }

        public Criteria andCommAgentGreaterThan(BigDecimal value) {
            addCriterion("comm_agent >", value, "commAgent");
            return (Criteria) this;
        }

        public Criteria andCommAgentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("comm_agent >=", value, "commAgent");
            return (Criteria) this;
        }

        public Criteria andCommAgentLessThan(BigDecimal value) {
            addCriterion("comm_agent <", value, "commAgent");
            return (Criteria) this;
        }

        public Criteria andCommAgentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("comm_agent <=", value, "commAgent");
            return (Criteria) this;
        }

        public Criteria andCommAgentIn(List<BigDecimal> values) {
            addCriterion("comm_agent in", values, "commAgent");
            return (Criteria) this;
        }

        public Criteria andCommAgentNotIn(List<BigDecimal> values) {
            addCriterion("comm_agent not in", values, "commAgent");
            return (Criteria) this;
        }

        public Criteria andCommAgentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm_agent between", value1, value2, "commAgent");
            return (Criteria) this;
        }

        public Criteria andCommAgentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm_agent not between", value1, value2, "commAgent");
            return (Criteria) this;
        }

        public Criteria andCommWorldIsNull() {
            addCriterion("comm_world is null");
            return (Criteria) this;
        }

        public Criteria andCommWorldIsNotNull() {
            addCriterion("comm_world is not null");
            return (Criteria) this;
        }

        public Criteria andCommWorldEqualTo(BigDecimal value) {
            addCriterion("comm_world =", value, "commWorld");
            return (Criteria) this;
        }

        public Criteria andCommWorldNotEqualTo(BigDecimal value) {
            addCriterion("comm_world <>", value, "commWorld");
            return (Criteria) this;
        }

        public Criteria andCommWorldGreaterThan(BigDecimal value) {
            addCriterion("comm_world >", value, "commWorld");
            return (Criteria) this;
        }

        public Criteria andCommWorldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("comm_world >=", value, "commWorld");
            return (Criteria) this;
        }

        public Criteria andCommWorldLessThan(BigDecimal value) {
            addCriterion("comm_world <", value, "commWorld");
            return (Criteria) this;
        }

        public Criteria andCommWorldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("comm_world <=", value, "commWorld");
            return (Criteria) this;
        }

        public Criteria andCommWorldIn(List<BigDecimal> values) {
            addCriterion("comm_world in", values, "commWorld");
            return (Criteria) this;
        }

        public Criteria andCommWorldNotIn(List<BigDecimal> values) {
            addCriterion("comm_world not in", values, "commWorld");
            return (Criteria) this;
        }

        public Criteria andCommWorldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm_world between", value1, value2, "commWorld");
            return (Criteria) this;
        }

        public Criteria andCommWorldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm_world not between", value1, value2, "commWorld");
            return (Criteria) this;
        }

        public Criteria andCommCorpratorIsNull() {
            addCriterion("comm_corprator is null");
            return (Criteria) this;
        }

        public Criteria andCommCorpratorIsNotNull() {
            addCriterion("comm_corprator is not null");
            return (Criteria) this;
        }

        public Criteria andCommCorpratorEqualTo(BigDecimal value) {
            addCriterion("comm_corprator =", value, "commCorprator");
            return (Criteria) this;
        }

        public Criteria andCommCorpratorNotEqualTo(BigDecimal value) {
            addCriterion("comm_corprator <>", value, "commCorprator");
            return (Criteria) this;
        }

        public Criteria andCommCorpratorGreaterThan(BigDecimal value) {
            addCriterion("comm_corprator >", value, "commCorprator");
            return (Criteria) this;
        }

        public Criteria andCommCorpratorGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("comm_corprator >=", value, "commCorprator");
            return (Criteria) this;
        }

        public Criteria andCommCorpratorLessThan(BigDecimal value) {
            addCriterion("comm_corprator <", value, "commCorprator");
            return (Criteria) this;
        }

        public Criteria andCommCorpratorLessThanOrEqualTo(BigDecimal value) {
            addCriterion("comm_corprator <=", value, "commCorprator");
            return (Criteria) this;
        }

        public Criteria andCommCorpratorIn(List<BigDecimal> values) {
            addCriterion("comm_corprator in", values, "commCorprator");
            return (Criteria) this;
        }

        public Criteria andCommCorpratorNotIn(List<BigDecimal> values) {
            addCriterion("comm_corprator not in", values, "commCorprator");
            return (Criteria) this;
        }

        public Criteria andCommCorpratorBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm_corprator between", value1, value2, "commCorprator");
            return (Criteria) this;
        }

        public Criteria andCommCorpratorNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm_corprator not between", value1, value2, "commCorprator");
            return (Criteria) this;
        }

        public Criteria andCommSuperiorIsNull() {
            addCriterion("comm_superior is null");
            return (Criteria) this;
        }

        public Criteria andCommSuperiorIsNotNull() {
            addCriterion("comm_superior is not null");
            return (Criteria) this;
        }

        public Criteria andCommSuperiorEqualTo(BigDecimal value) {
            addCriterion("comm_superior =", value, "commSuperior");
            return (Criteria) this;
        }

        public Criteria andCommSuperiorNotEqualTo(BigDecimal value) {
            addCriterion("comm_superior <>", value, "commSuperior");
            return (Criteria) this;
        }

        public Criteria andCommSuperiorGreaterThan(BigDecimal value) {
            addCriterion("comm_superior >", value, "commSuperior");
            return (Criteria) this;
        }

        public Criteria andCommSuperiorGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("comm_superior >=", value, "commSuperior");
            return (Criteria) this;
        }

        public Criteria andCommSuperiorLessThan(BigDecimal value) {
            addCriterion("comm_superior <", value, "commSuperior");
            return (Criteria) this;
        }

        public Criteria andCommSuperiorLessThanOrEqualTo(BigDecimal value) {
            addCriterion("comm_superior <=", value, "commSuperior");
            return (Criteria) this;
        }

        public Criteria andCommSuperiorIn(List<BigDecimal> values) {
            addCriterion("comm_superior in", values, "commSuperior");
            return (Criteria) this;
        }

        public Criteria andCommSuperiorNotIn(List<BigDecimal> values) {
            addCriterion("comm_superior not in", values, "commSuperior");
            return (Criteria) this;
        }

        public Criteria andCommSuperiorBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm_superior between", value1, value2, "commSuperior");
            return (Criteria) this;
        }

        public Criteria andCommSuperiorNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm_superior not between", value1, value2, "commSuperior");
            return (Criteria) this;
        }

        public Criteria andCommBranchIsNull() {
            addCriterion("comm_branch is null");
            return (Criteria) this;
        }

        public Criteria andCommBranchIsNotNull() {
            addCriterion("comm_branch is not null");
            return (Criteria) this;
        }

        public Criteria andCommBranchEqualTo(BigDecimal value) {
            addCriterion("comm_branch =", value, "commBranch");
            return (Criteria) this;
        }

        public Criteria andCommBranchNotEqualTo(BigDecimal value) {
            addCriterion("comm_branch <>", value, "commBranch");
            return (Criteria) this;
        }

        public Criteria andCommBranchGreaterThan(BigDecimal value) {
            addCriterion("comm_branch >", value, "commBranch");
            return (Criteria) this;
        }

        public Criteria andCommBranchGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("comm_branch >=", value, "commBranch");
            return (Criteria) this;
        }

        public Criteria andCommBranchLessThan(BigDecimal value) {
            addCriterion("comm_branch <", value, "commBranch");
            return (Criteria) this;
        }

        public Criteria andCommBranchLessThanOrEqualTo(BigDecimal value) {
            addCriterion("comm_branch <=", value, "commBranch");
            return (Criteria) this;
        }

        public Criteria andCommBranchIn(List<BigDecimal> values) {
            addCriterion("comm_branch in", values, "commBranch");
            return (Criteria) this;
        }

        public Criteria andCommBranchNotIn(List<BigDecimal> values) {
            addCriterion("comm_branch not in", values, "commBranch");
            return (Criteria) this;
        }

        public Criteria andCommBranchBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm_branch between", value1, value2, "commBranch");
            return (Criteria) this;
        }

        public Criteria andCommBranchNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm_branch not between", value1, value2, "commBranch");
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
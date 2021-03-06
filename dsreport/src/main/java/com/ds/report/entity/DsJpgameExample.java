package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DsJpgameExample {
    protected String orderByClause;

    protected boolean distinct;
    
    protected Integer page;

   	protected Integer pageLimit;

    protected List<Criteria> oredCriteria;

    public DsJpgameExample() {
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

        public Criteria andWagersidIsNull() {
            addCriterion("wagersid is null");
            return (Criteria) this;
        }

        public Criteria andWagersidIsNotNull() {
            addCriterion("wagersid is not null");
            return (Criteria) this;
        }

        public Criteria andWagersidEqualTo(String value) {
            addCriterion("wagersid =", value, "wagersid");
            return (Criteria) this;
        }

        public Criteria andWagersidNotEqualTo(String value) {
            addCriterion("wagersid <>", value, "wagersid");
            return (Criteria) this;
        }

        public Criteria andWagersidGreaterThan(String value) {
            addCriterion("wagersid >", value, "wagersid");
            return (Criteria) this;
        }

        public Criteria andWagersidGreaterThanOrEqualTo(String value) {
            addCriterion("wagersid >=", value, "wagersid");
            return (Criteria) this;
        }

        public Criteria andWagersidLessThan(String value) {
            addCriterion("wagersid <", value, "wagersid");
            return (Criteria) this;
        }

        public Criteria andWagersidLessThanOrEqualTo(String value) {
            addCriterion("wagersid <=", value, "wagersid");
            return (Criteria) this;
        }

        public Criteria andWagersidLike(String value) {
            addCriterion("wagersid like", value, "wagersid");
            return (Criteria) this;
        }

        public Criteria andWagersidNotLike(String value) {
            addCriterion("wagersid not like", value, "wagersid");
            return (Criteria) this;
        }

        public Criteria andWagersidIn(List<String> values) {
            addCriterion("wagersid in", values, "wagersid");
            return (Criteria) this;
        }

        public Criteria andWagersidNotIn(List<String> values) {
            addCriterion("wagersid not in", values, "wagersid");
            return (Criteria) this;
        }

        public Criteria andWagersidBetween(String value1, String value2) {
            addCriterion("wagersid between", value1, value2, "wagersid");
            return (Criteria) this;
        }

        public Criteria andWagersidNotBetween(String value1, String value2) {
            addCriterion("wagersid not between", value1, value2, "wagersid");
            return (Criteria) this;
        }

        public Criteria andJptypeidIsNull() {
            addCriterion("jptypeid is null");
            return (Criteria) this;
        }

        public Criteria andJptypeidIsNotNull() {
            addCriterion("jptypeid is not null");
            return (Criteria) this;
        }

        public Criteria andJptypeidEqualTo(String value) {
            addCriterion("jptypeid =", value, "jptypeid");
            return (Criteria) this;
        }

        public Criteria andJptypeidNotEqualTo(String value) {
            addCriterion("jptypeid <>", value, "jptypeid");
            return (Criteria) this;
        }

        public Criteria andJptypeidGreaterThan(String value) {
            addCriterion("jptypeid >", value, "jptypeid");
            return (Criteria) this;
        }

        public Criteria andJptypeidGreaterThanOrEqualTo(String value) {
            addCriterion("jptypeid >=", value, "jptypeid");
            return (Criteria) this;
        }

        public Criteria andJptypeidLessThan(String value) {
            addCriterion("jptypeid <", value, "jptypeid");
            return (Criteria) this;
        }

        public Criteria andJptypeidLessThanOrEqualTo(String value) {
            addCriterion("jptypeid <=", value, "jptypeid");
            return (Criteria) this;
        }

        public Criteria andJptypeidLike(String value) {
            addCriterion("jptypeid like", value, "jptypeid");
            return (Criteria) this;
        }

        public Criteria andJptypeidNotLike(String value) {
            addCriterion("jptypeid not like", value, "jptypeid");
            return (Criteria) this;
        }

        public Criteria andJptypeidIn(List<String> values) {
            addCriterion("jptypeid in", values, "jptypeid");
            return (Criteria) this;
        }

        public Criteria andJptypeidNotIn(List<String> values) {
            addCriterion("jptypeid not in", values, "jptypeid");
            return (Criteria) this;
        }

        public Criteria andJptypeidBetween(String value1, String value2) {
            addCriterion("jptypeid between", value1, value2, "jptypeid");
            return (Criteria) this;
        }

        public Criteria andJptypeidNotBetween(String value1, String value2) {
            addCriterion("jptypeid not between", value1, value2, "jptypeid");
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

        public Criteria andWagersdateIsNull() {
            addCriterion("wagersdate is null");
            return (Criteria) this;
        }

        public Criteria andWagersdateIsNotNull() {
            addCriterion("wagersdate is not null");
            return (Criteria) this;
        }

        public Criteria andWagersdateEqualTo(Date value) {
            addCriterion("wagersdate =", value, "wagersdate");
            return (Criteria) this;
        }

        public Criteria andWagersdateNotEqualTo(Date value) {
            addCriterion("wagersdate <>", value, "wagersdate");
            return (Criteria) this;
        }

        public Criteria andWagersdateGreaterThan(Date value) {
            addCriterion("wagersdate >", value, "wagersdate");
            return (Criteria) this;
        }

        public Criteria andWagersdateGreaterThanOrEqualTo(Date value) {
            addCriterion("wagersdate >=", value, "wagersdate");
            return (Criteria) this;
        }

        public Criteria andWagersdateLessThan(Date value) {
            addCriterion("wagersdate <", value, "wagersdate");
            return (Criteria) this;
        }

        public Criteria andWagersdateLessThanOrEqualTo(Date value) {
            addCriterion("wagersdate <=", value, "wagersdate");
            return (Criteria) this;
        }

        public Criteria andWagersdateIn(List<Date> values) {
            addCriterion("wagersdate in", values, "wagersdate");
            return (Criteria) this;
        }

        public Criteria andWagersdateNotIn(List<Date> values) {
            addCriterion("wagersdate not in", values, "wagersdate");
            return (Criteria) this;
        }

        public Criteria andWagersdateBetween(Date value1, Date value2) {
            addCriterion("wagersdate between", value1, value2, "wagersdate");
            return (Criteria) this;
        }

        public Criteria andWagersdateNotBetween(Date value1, Date value2) {
            addCriterion("wagersdate not between", value1, value2, "wagersdate");
            return (Criteria) this;
        }

        public Criteria andJpamountIsNull() {
            addCriterion("jpamount is null");
            return (Criteria) this;
        }

        public Criteria andJpamountIsNotNull() {
            addCriterion("jpamount is not null");
            return (Criteria) this;
        }

        public Criteria andJpamountEqualTo(BigDecimal value) {
            addCriterion("jpamount =", value, "jpamount");
            return (Criteria) this;
        }

        public Criteria andJpamountNotEqualTo(BigDecimal value) {
            addCriterion("jpamount <>", value, "jpamount");
            return (Criteria) this;
        }

        public Criteria andJpamountGreaterThan(BigDecimal value) {
            addCriterion("jpamount >", value, "jpamount");
            return (Criteria) this;
        }

        public Criteria andJpamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jpamount >=", value, "jpamount");
            return (Criteria) this;
        }

        public Criteria andJpamountLessThan(BigDecimal value) {
            addCriterion("jpamount <", value, "jpamount");
            return (Criteria) this;
        }

        public Criteria andJpamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jpamount <=", value, "jpamount");
            return (Criteria) this;
        }

        public Criteria andJpamountIn(List<BigDecimal> values) {
            addCriterion("jpamount in", values, "jpamount");
            return (Criteria) this;
        }

        public Criteria andJpamountNotIn(List<BigDecimal> values) {
            addCriterion("jpamount not in", values, "jpamount");
            return (Criteria) this;
        }

        public Criteria andJpamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jpamount between", value1, value2, "jpamount");
            return (Criteria) this;
        }

        public Criteria andJpamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jpamount not between", value1, value2, "jpamount");
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

        public Criteria andAdminIsNull() {
            addCriterion("admin is null");
            return (Criteria) this;
        }

        public Criteria andAdminIsNotNull() {
            addCriterion("admin is not null");
            return (Criteria) this;
        }

        public Criteria andAdminEqualTo(String value) {
            addCriterion("admin =", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotEqualTo(String value) {
            addCriterion("admin <>", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThan(String value) {
            addCriterion("admin >", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThanOrEqualTo(String value) {
            addCriterion("admin >=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThan(String value) {
            addCriterion("admin <", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThanOrEqualTo(String value) {
            addCriterion("admin <=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLike(String value) {
            addCriterion("admin like", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotLike(String value) {
            addCriterion("admin not like", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminIn(List<String> values) {
            addCriterion("admin in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotIn(List<String> values) {
            addCriterion("admin not in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminBetween(String value1, String value2) {
            addCriterion("admin between", value1, value2, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotBetween(String value1, String value2) {
            addCriterion("admin not between", value1, value2, "admin");
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

        public Criteria andLiveIdEqualTo(Integer value) {
            addCriterion("live_id =", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdNotEqualTo(Integer value) {
            addCriterion("live_id <>", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdGreaterThan(Integer value) {
            addCriterion("live_id >", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("live_id >=", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdLessThan(Integer value) {
            addCriterion("live_id <", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("live_id <=", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdIn(List<Integer> values) {
            addCriterion("live_id in", values, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdNotIn(List<Integer> values) {
            addCriterion("live_id not in", values, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdBetween(Integer value1, Integer value2) {
            addCriterion("live_id between", value1, value2, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdNotBetween(Integer value1, Integer value2) {
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
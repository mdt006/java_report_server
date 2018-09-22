package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DsBbinJilvExample {
    protected String orderByClause;
    
    protected Integer page;

	protected Integer pageLimit;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsBbinJilvExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
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

        public Criteria andUppernameIsNull() {
            addCriterion("uppername is null");
            return (Criteria) this;
        }

        public Criteria andUppernameIsNotNull() {
            addCriterion("uppername is not null");
            return (Criteria) this;
        }

        public Criteria andUppernameEqualTo(String value) {
            addCriterion("uppername =", value, "uppername");
            return (Criteria) this;
        }

        public Criteria andUppernameNotEqualTo(String value) {
            addCriterion("uppername <>", value, "uppername");
            return (Criteria) this;
        }

        public Criteria andUppernameGreaterThan(String value) {
            addCriterion("uppername >", value, "uppername");
            return (Criteria) this;
        }

        public Criteria andUppernameGreaterThanOrEqualTo(String value) {
            addCriterion("uppername >=", value, "uppername");
            return (Criteria) this;
        }

        public Criteria andUppernameLessThan(String value) {
            addCriterion("uppername <", value, "uppername");
            return (Criteria) this;
        }

        public Criteria andUppernameLessThanOrEqualTo(String value) {
            addCriterion("uppername <=", value, "uppername");
            return (Criteria) this;
        }

        public Criteria andUppernameLike(String value) {
            addCriterion("uppername like", value, "uppername");
            return (Criteria) this;
        }

        public Criteria andUppernameNotLike(String value) {
            addCriterion("uppername not like", value, "uppername");
            return (Criteria) this;
        }

        public Criteria andUppernameIn(List<String> values) {
            addCriterion("uppername in", values, "uppername");
            return (Criteria) this;
        }

        public Criteria andUppernameNotIn(List<String> values) {
            addCriterion("uppername not in", values, "uppername");
            return (Criteria) this;
        }

        public Criteria andUppernameBetween(String value1, String value2) {
            addCriterion("uppername between", value1, value2, "uppername");
            return (Criteria) this;
        }

        public Criteria andUppernameNotBetween(String value1, String value2) {
            addCriterion("uppername not between", value1, value2, "uppername");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteIsNull() {
            addCriterion("bbin_website is null");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteIsNotNull() {
            addCriterion("bbin_website is not null");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteEqualTo(String value) {
            addCriterion("bbin_website =", value, "bbinWebsite");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteNotEqualTo(String value) {
            addCriterion("bbin_website <>", value, "bbinWebsite");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteGreaterThan(String value) {
            addCriterion("bbin_website >", value, "bbinWebsite");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("bbin_website >=", value, "bbinWebsite");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteLessThan(String value) {
            addCriterion("bbin_website <", value, "bbinWebsite");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteLessThanOrEqualTo(String value) {
            addCriterion("bbin_website <=", value, "bbinWebsite");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteLike(String value) {
            addCriterion("bbin_website like", value, "bbinWebsite");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteNotLike(String value) {
            addCriterion("bbin_website not like", value, "bbinWebsite");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteIn(List<String> values) {
            addCriterion("bbin_website in", values, "bbinWebsite");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteNotIn(List<String> values) {
            addCriterion("bbin_website not in", values, "bbinWebsite");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteBetween(String value1, String value2) {
            addCriterion("bbin_website between", value1, value2, "bbinWebsite");
            return (Criteria) this;
        }

        public Criteria andBbinWebsiteNotBetween(String value1, String value2) {
            addCriterion("bbin_website not between", value1, value2, "bbinWebsite");
            return (Criteria) this;
        }

        public Criteria andBbinGameKindIsNull() {
            addCriterion("bbin_game_kind is null");
            return (Criteria) this;
        }

        public Criteria andBbinGameKindIsNotNull() {
            addCriterion("bbin_game_kind is not null");
            return (Criteria) this;
        }

        public Criteria andBbinGameKindEqualTo(Byte value) {
            addCriterion("bbin_game_kind =", value, "bbinGameKind");
            return (Criteria) this;
        }

        public Criteria andBbinGameKindNotEqualTo(Byte value) {
            addCriterion("bbin_game_kind <>", value, "bbinGameKind");
            return (Criteria) this;
        }

        public Criteria andBbinGameKindGreaterThan(Byte value) {
            addCriterion("bbin_game_kind >", value, "bbinGameKind");
            return (Criteria) this;
        }

        public Criteria andBbinGameKindGreaterThanOrEqualTo(Byte value) {
            addCriterion("bbin_game_kind >=", value, "bbinGameKind");
            return (Criteria) this;
        }

        public Criteria andBbinGameKindLessThan(Byte value) {
            addCriterion("bbin_game_kind <", value, "bbinGameKind");
            return (Criteria) this;
        }

        public Criteria andBbinGameKindLessThanOrEqualTo(Byte value) {
            addCriterion("bbin_game_kind <=", value, "bbinGameKind");
            return (Criteria) this;
        }

        public Criteria andBbinGameKindIn(List<Byte> values) {
            addCriterion("bbin_game_kind in", values, "bbinGameKind");
            return (Criteria) this;
        }

        public Criteria andBbinGameKindNotIn(List<Byte> values) {
            addCriterion("bbin_game_kind not in", values, "bbinGameKind");
            return (Criteria) this;
        }

        public Criteria andBbinGameKindBetween(Byte value1, Byte value2) {
            addCriterion("bbin_game_kind between", value1, value2, "bbinGameKind");
            return (Criteria) this;
        }

        public Criteria andBbinGameKindNotBetween(Byte value1, Byte value2) {
            addCriterion("bbin_game_kind not between", value1, value2, "bbinGameKind");
            return (Criteria) this;
        }

        public Criteria andWagersIdIsNull() {
            addCriterion("wagers_id is null");
            return (Criteria) this;
        }

        public Criteria andWagersIdIsNotNull() {
            addCriterion("wagers_id is not null");
            return (Criteria) this;
        }

        public Criteria andWagersIdEqualTo(String value) {
            addCriterion("wagers_id =", value, "wagersId");
            return (Criteria) this;
        }

        public Criteria andWagersIdNotEqualTo(String value) {
            addCriterion("wagers_id <>", value, "wagersId");
            return (Criteria) this;
        }

        public Criteria andWagersIdGreaterThan(String value) {
            addCriterion("wagers_id >", value, "wagersId");
            return (Criteria) this;
        }

        public Criteria andWagersIdGreaterThanOrEqualTo(String value) {
            addCriterion("wagers_id >=", value, "wagersId");
            return (Criteria) this;
        }

        public Criteria andWagersIdLessThan(String value) {
            addCriterion("wagers_id <", value, "wagersId");
            return (Criteria) this;
        }

        public Criteria andWagersIdLessThanOrEqualTo(String value) {
            addCriterion("wagers_id <=", value, "wagersId");
            return (Criteria) this;
        }

        public Criteria andWagersIdLike(String value) {
            addCriterion("wagers_id like", value, "wagersId");
            return (Criteria) this;
        }

        public Criteria andWagersIdNotLike(String value) {
            addCriterion("wagers_id not like", value, "wagersId");
            return (Criteria) this;
        }

        public Criteria andWagersIdIn(List<String> values) {
            addCriterion("wagers_id in", values, "wagersId");
            return (Criteria) this;
        }

        public Criteria andWagersIdNotIn(List<String> values) {
            addCriterion("wagers_id not in", values, "wagersId");
            return (Criteria) this;
        }

        public Criteria andWagersIdBetween(String value1, String value2) {
            addCriterion("wagers_id between", value1, value2, "wagersId");
            return (Criteria) this;
        }

        public Criteria andWagersIdNotBetween(String value1, String value2) {
            addCriterion("wagers_id not between", value1, value2, "wagersId");
            return (Criteria) this;
        }

        public Criteria andWagersDateIsNull() {
            addCriterion("wagers_date is null");
            return (Criteria) this;
        }

        public Criteria andWagersDateIsNotNull() {
            addCriterion("wagers_date is not null");
            return (Criteria) this;
        }

        public Criteria andWagersDateEqualTo(Date value) {
            addCriterion("wagers_date =", value, "wagersDate");
            return (Criteria) this;
        }

        public Criteria andWagersDateNotEqualTo(Date value) {
            addCriterion("wagers_date <>", value, "wagersDate");
            return (Criteria) this;
        }

        public Criteria andWagersDateGreaterThan(Date value) {
            addCriterion("wagers_date >", value, "wagersDate");
            return (Criteria) this;
        }

        public Criteria andWagersDateGreaterThanOrEqualTo(Date value) {
            addCriterion("wagers_date >=", value, "wagersDate");
            return (Criteria) this;
        }

        public Criteria andWagersDateLessThan(Date value) {
            addCriterion("wagers_date <", value, "wagersDate");
            return (Criteria) this;
        }

        public Criteria andWagersDateLessThanOrEqualTo(Date value) {
            addCriterion("wagers_date <=", value, "wagersDate");
            return (Criteria) this;
        }

        public Criteria andWagersDateIn(List<Date> values) {
            addCriterion("wagers_date in", values, "wagersDate");
            return (Criteria) this;
        }

        public Criteria andWagersDateNotIn(List<Date> values) {
            addCriterion("wagers_date not in", values, "wagersDate");
            return (Criteria) this;
        }

        public Criteria andWagersDateBetween(Date value1, Date value2) {
            addCriterion("wagers_date between", value1, value2, "wagersDate");
            return (Criteria) this;
        }

        public Criteria andWagersDateNotBetween(Date value1, Date value2) {
            addCriterion("wagers_date not between", value1, value2, "wagersDate");
            return (Criteria) this;
        }

        public Criteria andSerialIdIsNull() {
            addCriterion("serial_id is null");
            return (Criteria) this;
        }

        public Criteria andSerialIdIsNotNull() {
            addCriterion("serial_id is not null");
            return (Criteria) this;
        }

        public Criteria andSerialIdEqualTo(String value) {
            addCriterion("serial_id =", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdNotEqualTo(String value) {
            addCriterion("serial_id <>", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdGreaterThan(String value) {
            addCriterion("serial_id >", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdGreaterThanOrEqualTo(String value) {
            addCriterion("serial_id >=", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdLessThan(String value) {
            addCriterion("serial_id <", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdLessThanOrEqualTo(String value) {
            addCriterion("serial_id <=", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdLike(String value) {
            addCriterion("serial_id like", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdNotLike(String value) {
            addCriterion("serial_id not like", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdIn(List<String> values) {
            addCriterion("serial_id in", values, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdNotIn(List<String> values) {
            addCriterion("serial_id not in", values, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdBetween(String value1, String value2) {
            addCriterion("serial_id between", value1, value2, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdNotBetween(String value1, String value2) {
            addCriterion("serial_id not between", value1, value2, "serialId");
            return (Criteria) this;
        }

        public Criteria andRoundNoIsNull() {
            addCriterion("round_no is null");
            return (Criteria) this;
        }

        public Criteria andRoundNoIsNotNull() {
            addCriterion("round_no is not null");
            return (Criteria) this;
        }

        public Criteria andRoundNoEqualTo(String value) {
            addCriterion("round_no =", value, "roundNo");
            return (Criteria) this;
        }

        public Criteria andRoundNoNotEqualTo(String value) {
            addCriterion("round_no <>", value, "roundNo");
            return (Criteria) this;
        }

        public Criteria andRoundNoGreaterThan(String value) {
            addCriterion("round_no >", value, "roundNo");
            return (Criteria) this;
        }

        public Criteria andRoundNoGreaterThanOrEqualTo(String value) {
            addCriterion("round_no >=", value, "roundNo");
            return (Criteria) this;
        }

        public Criteria andRoundNoLessThan(String value) {
            addCriterion("round_no <", value, "roundNo");
            return (Criteria) this;
        }

        public Criteria andRoundNoLessThanOrEqualTo(String value) {
            addCriterion("round_no <=", value, "roundNo");
            return (Criteria) this;
        }

        public Criteria andRoundNoLike(String value) {
            addCriterion("round_no like", value, "roundNo");
            return (Criteria) this;
        }

        public Criteria andRoundNoNotLike(String value) {
            addCriterion("round_no not like", value, "roundNo");
            return (Criteria) this;
        }

        public Criteria andRoundNoIn(List<String> values) {
            addCriterion("round_no in", values, "roundNo");
            return (Criteria) this;
        }

        public Criteria andRoundNoNotIn(List<String> values) {
            addCriterion("round_no not in", values, "roundNo");
            return (Criteria) this;
        }

        public Criteria andRoundNoBetween(String value1, String value2) {
            addCriterion("round_no between", value1, value2, "roundNo");
            return (Criteria) this;
        }

        public Criteria andRoundNoNotBetween(String value1, String value2) {
            addCriterion("round_no not between", value1, value2, "roundNo");
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

        public Criteria andGameTypeEqualTo(String value) {
            addCriterion("game_type =", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotEqualTo(String value) {
            addCriterion("game_type <>", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeGreaterThan(String value) {
            addCriterion("game_type >", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeGreaterThanOrEqualTo(String value) {
            addCriterion("game_type >=", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLessThan(String value) {
            addCriterion("game_type <", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLessThanOrEqualTo(String value) {
            addCriterion("game_type <=", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLike(String value) {
            addCriterion("game_type like", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotLike(String value) {
            addCriterion("game_type not like", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeIn(List<String> values) {
            addCriterion("game_type in", values, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotIn(List<String> values) {
            addCriterion("game_type not in", values, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeBetween(String value1, String value2) {
            addCriterion("game_type between", value1, value2, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotBetween(String value1, String value2) {
            addCriterion("game_type not between", value1, value2, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameCodeIsNull() {
            addCriterion("game_code is null");
            return (Criteria) this;
        }

        public Criteria andGameCodeIsNotNull() {
            addCriterion("game_code is not null");
            return (Criteria) this;
        }

        public Criteria andGameCodeEqualTo(String value) {
            addCriterion("game_code =", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeNotEqualTo(String value) {
            addCriterion("game_code <>", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeGreaterThan(String value) {
            addCriterion("game_code >", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeGreaterThanOrEqualTo(String value) {
            addCriterion("game_code >=", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeLessThan(String value) {
            addCriterion("game_code <", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeLessThanOrEqualTo(String value) {
            addCriterion("game_code <=", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeLike(String value) {
            addCriterion("game_code like", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeNotLike(String value) {
            addCriterion("game_code not like", value, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeIn(List<String> values) {
            addCriterion("game_code in", values, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeNotIn(List<String> values) {
            addCriterion("game_code not in", values, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeBetween(String value1, String value2) {
            addCriterion("game_code between", value1, value2, "gameCode");
            return (Criteria) this;
        }

        public Criteria andGameCodeNotBetween(String value1, String value2) {
            addCriterion("game_code not between", value1, value2, "gameCode");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultTypeIsNull() {
            addCriterion("result_type is null");
            return (Criteria) this;
        }

        public Criteria andResultTypeIsNotNull() {
            addCriterion("result_type is not null");
            return (Criteria) this;
        }

        public Criteria andResultTypeEqualTo(String value) {
            addCriterion("result_type =", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotEqualTo(String value) {
            addCriterion("result_type <>", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeGreaterThan(String value) {
            addCriterion("result_type >", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeGreaterThanOrEqualTo(String value) {
            addCriterion("result_type >=", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLessThan(String value) {
            addCriterion("result_type <", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLessThanOrEqualTo(String value) {
            addCriterion("result_type <=", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLike(String value) {
            addCriterion("result_type like", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotLike(String value) {
            addCriterion("result_type not like", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeIn(List<String> values) {
            addCriterion("result_type in", values, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotIn(List<String> values) {
            addCriterion("result_type not in", values, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeBetween(String value1, String value2) {
            addCriterion("result_type between", value1, value2, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotBetween(String value1, String value2) {
            addCriterion("result_type not between", value1, value2, "resultType");
            return (Criteria) this;
        }

        public Criteria andCardIsNull() {
            addCriterion("card is null");
            return (Criteria) this;
        }

        public Criteria andCardIsNotNull() {
            addCriterion("card is not null");
            return (Criteria) this;
        }

        public Criteria andCardEqualTo(String value) {
            addCriterion("card =", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardNotEqualTo(String value) {
            addCriterion("card <>", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardGreaterThan(String value) {
            addCriterion("card >", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardGreaterThanOrEqualTo(String value) {
            addCriterion("card >=", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardLessThan(String value) {
            addCriterion("card <", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardLessThanOrEqualTo(String value) {
            addCriterion("card <=", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardLike(String value) {
            addCriterion("card like", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardNotLike(String value) {
            addCriterion("card not like", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardIn(List<String> values) {
            addCriterion("card in", values, "card");
            return (Criteria) this;
        }

        public Criteria andCardNotIn(List<String> values) {
            addCriterion("card not in", values, "card");
            return (Criteria) this;
        }

        public Criteria andCardBetween(String value1, String value2) {
            addCriterion("card between", value1, value2, "card");
            return (Criteria) this;
        }

        public Criteria andCardNotBetween(String value1, String value2) {
            addCriterion("card not between", value1, value2, "card");
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

        public Criteria andPayOffIsNull() {
            addCriterion("pay_off is null");
            return (Criteria) this;
        }

        public Criteria andPayOffIsNotNull() {
            addCriterion("pay_off is not null");
            return (Criteria) this;
        }

        public Criteria andPayOffEqualTo(BigDecimal value) {
            addCriterion("pay_off =", value, "payOff");
            return (Criteria) this;
        }

        public Criteria andPayOffNotEqualTo(BigDecimal value) {
            addCriterion("pay_off <>", value, "payOff");
            return (Criteria) this;
        }

        public Criteria andPayOffGreaterThan(BigDecimal value) {
            addCriterion("pay_off >", value, "payOff");
            return (Criteria) this;
        }

        public Criteria andPayOffGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_off >=", value, "payOff");
            return (Criteria) this;
        }

        public Criteria andPayOffLessThan(BigDecimal value) {
            addCriterion("pay_off <", value, "payOff");
            return (Criteria) this;
        }

        public Criteria andPayOffLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_off <=", value, "payOff");
            return (Criteria) this;
        }

        public Criteria andPayOffIn(List<BigDecimal> values) {
            addCriterion("pay_off in", values, "payOff");
            return (Criteria) this;
        }

        public Criteria andPayOffNotIn(List<BigDecimal> values) {
            addCriterion("pay_off not in", values, "payOff");
            return (Criteria) this;
        }

        public Criteria andPayOffBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_off between", value1, value2, "payOff");
            return (Criteria) this;
        }

        public Criteria andPayOffNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_off not between", value1, value2, "payOff");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(BigDecimal value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(BigDecimal value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(BigDecimal value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(BigDecimal value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<BigDecimal> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<BigDecimal> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIsNull() {
            addCriterion("exchange_rate is null");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIsNotNull() {
            addCriterion("exchange_rate is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeRateEqualTo(String value) {
            addCriterion("exchange_rate =", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotEqualTo(String value) {
            addCriterion("exchange_rate <>", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateGreaterThan(String value) {
            addCriterion("exchange_rate >", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateGreaterThanOrEqualTo(String value) {
            addCriterion("exchange_rate >=", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLessThan(String value) {
            addCriterion("exchange_rate <", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLessThanOrEqualTo(String value) {
            addCriterion("exchange_rate <=", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLike(String value) {
            addCriterion("exchange_rate like", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotLike(String value) {
            addCriterion("exchange_rate not like", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIn(List<String> values) {
            addCriterion("exchange_rate in", values, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotIn(List<String> values) {
            addCriterion("exchange_rate not in", values, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateBetween(String value1, String value2) {
            addCriterion("exchange_rate between", value1, value2, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotBetween(String value1, String value2) {
            addCriterion("exchange_rate not between", value1, value2, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andCommissionableIsNull() {
            addCriterion("commissionable is null");
            return (Criteria) this;
        }

        public Criteria andCommissionableIsNotNull() {
            addCriterion("commissionable is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionableEqualTo(BigDecimal value) {
            addCriterion("commissionable =", value, "commissionable");
            return (Criteria) this;
        }

        public Criteria andCommissionableNotEqualTo(BigDecimal value) {
            addCriterion("commissionable <>", value, "commissionable");
            return (Criteria) this;
        }

        public Criteria andCommissionableGreaterThan(BigDecimal value) {
            addCriterion("commissionable >", value, "commissionable");
            return (Criteria) this;
        }

        public Criteria andCommissionableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commissionable >=", value, "commissionable");
            return (Criteria) this;
        }

        public Criteria andCommissionableLessThan(BigDecimal value) {
            addCriterion("commissionable <", value, "commissionable");
            return (Criteria) this;
        }

        public Criteria andCommissionableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commissionable <=", value, "commissionable");
            return (Criteria) this;
        }

        public Criteria andCommissionableIn(List<BigDecimal> values) {
            addCriterion("commissionable in", values, "commissionable");
            return (Criteria) this;
        }

        public Criteria andCommissionableNotIn(List<BigDecimal> values) {
            addCriterion("commissionable not in", values, "commissionable");
            return (Criteria) this;
        }

        public Criteria andCommissionableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commissionable between", value1, value2, "commissionable");
            return (Criteria) this;
        }

        public Criteria andCommissionableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commissionable not between", value1, value2, "commissionable");
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

        public Criteria andModifiedDateIsNull() {
            addCriterion("modified_date is null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIsNotNull() {
            addCriterion("modified_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateEqualTo(Date value) {
            addCriterion("modified_date =", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotEqualTo(Date value) {
            addCriterion("modified_date <>", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateGreaterThan(Date value) {
            addCriterion("modified_date >", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_date >=", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateLessThan(Date value) {
            addCriterion("modified_date <", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateLessThanOrEqualTo(Date value) {
            addCriterion("modified_date <=", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIn(List<Date> values) {
            addCriterion("modified_date in", values, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotIn(List<Date> values) {
            addCriterion("modified_date not in", values, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateBetween(Date value1, Date value2) {
            addCriterion("modified_date between", value1, value2, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotBetween(Date value1, Date value2) {
            addCriterion("modified_date not between", value1, value2, "modifiedDate");
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

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Byte value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Byte value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Byte value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Byte value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Byte value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Byte> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Byte> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Byte value1, Byte value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andLastJsonIsNull() {
            addCriterion("last_json is null");
            return (Criteria) this;
        }

        public Criteria andLastJsonIsNotNull() {
            addCriterion("last_json is not null");
            return (Criteria) this;
        }

        public Criteria andLastJsonEqualTo(String value) {
            addCriterion("last_json =", value, "lastJson");
            return (Criteria) this;
        }

        public Criteria andLastJsonNotEqualTo(String value) {
            addCriterion("last_json <>", value, "lastJson");
            return (Criteria) this;
        }

        public Criteria andLastJsonGreaterThan(String value) {
            addCriterion("last_json >", value, "lastJson");
            return (Criteria) this;
        }

        public Criteria andLastJsonGreaterThanOrEqualTo(String value) {
            addCriterion("last_json >=", value, "lastJson");
            return (Criteria) this;
        }

        public Criteria andLastJsonLessThan(String value) {
            addCriterion("last_json <", value, "lastJson");
            return (Criteria) this;
        }

        public Criteria andLastJsonLessThanOrEqualTo(String value) {
            addCriterion("last_json <=", value, "lastJson");
            return (Criteria) this;
        }

        public Criteria andLastJsonLike(String value) {
            addCriterion("last_json like", value, "lastJson");
            return (Criteria) this;
        }

        public Criteria andLastJsonNotLike(String value) {
            addCriterion("last_json not like", value, "lastJson");
            return (Criteria) this;
        }

        public Criteria andLastJsonIn(List<String> values) {
            addCriterion("last_json in", values, "lastJson");
            return (Criteria) this;
        }

        public Criteria andLastJsonNotIn(List<String> values) {
            addCriterion("last_json not in", values, "lastJson");
            return (Criteria) this;
        }

        public Criteria andLastJsonBetween(String value1, String value2) {
            addCriterion("last_json between", value1, value2, "lastJson");
            return (Criteria) this;
        }

        public Criteria andLastJsonNotBetween(String value1, String value2) {
            addCriterion("last_json not between", value1, value2, "lastJson");
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
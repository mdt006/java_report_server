package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DsXiaoyuLottoExample {
    protected String orderByClause;
    
    protected Integer page;

   	protected Integer pageLimit;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsXiaoyuLottoExample() {
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

        public Criteria andTransIdIsNull() {
            addCriterion("trans_id is null");
            return (Criteria) this;
        }

        public Criteria andTransIdIsNotNull() {
            addCriterion("trans_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransIdEqualTo(String value) {
            addCriterion("trans_id =", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdNotEqualTo(String value) {
            addCriterion("trans_id <>", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdGreaterThan(String value) {
            addCriterion("trans_id >", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdGreaterThanOrEqualTo(String value) {
            addCriterion("trans_id >=", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdLessThan(String value) {
            addCriterion("trans_id <", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdLessThanOrEqualTo(String value) {
            addCriterion("trans_id <=", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdLike(String value) {
            addCriterion("trans_id like", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdNotLike(String value) {
            addCriterion("trans_id not like", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdIn(List<String> values) {
            addCriterion("trans_id in", values, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdNotIn(List<String> values) {
            addCriterion("trans_id not in", values, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdBetween(String value1, String value2) {
            addCriterion("trans_id between", value1, value2, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdNotBetween(String value1, String value2) {
            addCriterion("trans_id not between", value1, value2, "transId");
            return (Criteria) this;
        }

        public Criteria andBillnoIsNull() {
            addCriterion("billno is null");
            return (Criteria) this;
        }

        public Criteria andBillnoIsNotNull() {
            addCriterion("billno is not null");
            return (Criteria) this;
        }

        public Criteria andBillnoEqualTo(String value) {
            addCriterion("billno =", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotEqualTo(String value) {
            addCriterion("billno <>", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThan(String value) {
            addCriterion("billno >", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThanOrEqualTo(String value) {
            addCriterion("billno >=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThan(String value) {
            addCriterion("billno <", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThanOrEqualTo(String value) {
            addCriterion("billno <=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLike(String value) {
            addCriterion("billno like", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotLike(String value) {
            addCriterion("billno not like", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoIn(List<String> values) {
            addCriterion("billno in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotIn(List<String> values) {
            addCriterion("billno not in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoBetween(String value1, String value2) {
            addCriterion("billno between", value1, value2, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotBetween(String value1, String value2) {
            addCriterion("billno not between", value1, value2, "billno");
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

        public Criteria andLottoNameIsNull() {
            addCriterion("lotto_name is null");
            return (Criteria) this;
        }

        public Criteria andLottoNameIsNotNull() {
            addCriterion("lotto_name is not null");
            return (Criteria) this;
        }

        public Criteria andLottoNameEqualTo(String value) {
            addCriterion("lotto_name =", value, "lottoName");
            return (Criteria) this;
        }

        public Criteria andLottoNameNotEqualTo(String value) {
            addCriterion("lotto_name <>", value, "lottoName");
            return (Criteria) this;
        }

        public Criteria andLottoNameGreaterThan(String value) {
            addCriterion("lotto_name >", value, "lottoName");
            return (Criteria) this;
        }

        public Criteria andLottoNameGreaterThanOrEqualTo(String value) {
            addCriterion("lotto_name >=", value, "lottoName");
            return (Criteria) this;
        }

        public Criteria andLottoNameLessThan(String value) {
            addCriterion("lotto_name <", value, "lottoName");
            return (Criteria) this;
        }

        public Criteria andLottoNameLessThanOrEqualTo(String value) {
            addCriterion("lotto_name <=", value, "lottoName");
            return (Criteria) this;
        }

        public Criteria andLottoNameLike(String value) {
            addCriterion("lotto_name like", value, "lottoName");
            return (Criteria) this;
        }

        public Criteria andLottoNameNotLike(String value) {
            addCriterion("lotto_name not like", value, "lottoName");
            return (Criteria) this;
        }

        public Criteria andLottoNameIn(List<String> values) {
            addCriterion("lotto_name in", values, "lottoName");
            return (Criteria) this;
        }

        public Criteria andLottoNameNotIn(List<String> values) {
            addCriterion("lotto_name not in", values, "lottoName");
            return (Criteria) this;
        }

        public Criteria andLottoNameBetween(String value1, String value2) {
            addCriterion("lotto_name between", value1, value2, "lottoName");
            return (Criteria) this;
        }

        public Criteria andLottoNameNotBetween(String value1, String value2) {
            addCriterion("lotto_name not between", value1, value2, "lottoName");
            return (Criteria) this;
        }

        public Criteria andLottoTypeIsNull() {
            addCriterion("lotto_type is null");
            return (Criteria) this;
        }

        public Criteria andLottoTypeIsNotNull() {
            addCriterion("lotto_type is not null");
            return (Criteria) this;
        }

        public Criteria andLottoTypeEqualTo(String value) {
            addCriterion("lotto_type =", value, "lottoType");
            return (Criteria) this;
        }

        public Criteria andLottoTypeNotEqualTo(String value) {
            addCriterion("lotto_type <>", value, "lottoType");
            return (Criteria) this;
        }

        public Criteria andLottoTypeGreaterThan(String value) {
            addCriterion("lotto_type >", value, "lottoType");
            return (Criteria) this;
        }

        public Criteria andLottoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lotto_type >=", value, "lottoType");
            return (Criteria) this;
        }

        public Criteria andLottoTypeLessThan(String value) {
            addCriterion("lotto_type <", value, "lottoType");
            return (Criteria) this;
        }

        public Criteria andLottoTypeLessThanOrEqualTo(String value) {
            addCriterion("lotto_type <=", value, "lottoType");
            return (Criteria) this;
        }

        public Criteria andLottoTypeLike(String value) {
            addCriterion("lotto_type like", value, "lottoType");
            return (Criteria) this;
        }

        public Criteria andLottoTypeNotLike(String value) {
            addCriterion("lotto_type not like", value, "lottoType");
            return (Criteria) this;
        }

        public Criteria andLottoTypeIn(List<String> values) {
            addCriterion("lotto_type in", values, "lottoType");
            return (Criteria) this;
        }

        public Criteria andLottoTypeNotIn(List<String> values) {
            addCriterion("lotto_type not in", values, "lottoType");
            return (Criteria) this;
        }

        public Criteria andLottoTypeBetween(String value1, String value2) {
            addCriterion("lotto_type between", value1, value2, "lottoType");
            return (Criteria) this;
        }

        public Criteria andLottoTypeNotBetween(String value1, String value2) {
            addCriterion("lotto_type not between", value1, value2, "lottoType");
            return (Criteria) this;
        }

        public Criteria andQishuIsNull() {
            addCriterion("qishu is null");
            return (Criteria) this;
        }

        public Criteria andQishuIsNotNull() {
            addCriterion("qishu is not null");
            return (Criteria) this;
        }

        public Criteria andQishuEqualTo(Integer value) {
            addCriterion("qishu =", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuNotEqualTo(Integer value) {
            addCriterion("qishu <>", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuGreaterThan(Integer value) {
            addCriterion("qishu >", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuGreaterThanOrEqualTo(Integer value) {
            addCriterion("qishu >=", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuLessThan(Integer value) {
            addCriterion("qishu <", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuLessThanOrEqualTo(Integer value) {
            addCriterion("qishu <=", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuIn(List<Integer> values) {
            addCriterion("qishu in", values, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuNotIn(List<Integer> values) {
            addCriterion("qishu not in", values, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuBetween(Integer value1, Integer value2) {
            addCriterion("qishu between", value1, value2, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuNotBetween(Integer value1, Integer value2) {
            addCriterion("qishu not between", value1, value2, "qishu");
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

        public Criteria andValidAmountIsNull() {
            addCriterion("valid_amount is null");
            return (Criteria) this;
        }

        public Criteria andValidAmountIsNotNull() {
            addCriterion("valid_amount is not null");
            return (Criteria) this;
        }

        public Criteria andValidAmountEqualTo(BigDecimal value) {
            addCriterion("valid_amount =", value, "validAmount");
            return (Criteria) this;
        }

        public Criteria andValidAmountNotEqualTo(BigDecimal value) {
            addCriterion("valid_amount <>", value, "validAmount");
            return (Criteria) this;
        }

        public Criteria andValidAmountGreaterThan(BigDecimal value) {
            addCriterion("valid_amount >", value, "validAmount");
            return (Criteria) this;
        }

        public Criteria andValidAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("valid_amount >=", value, "validAmount");
            return (Criteria) this;
        }

        public Criteria andValidAmountLessThan(BigDecimal value) {
            addCriterion("valid_amount <", value, "validAmount");
            return (Criteria) this;
        }

        public Criteria andValidAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("valid_amount <=", value, "validAmount");
            return (Criteria) this;
        }

        public Criteria andValidAmountIn(List<BigDecimal> values) {
            addCriterion("valid_amount in", values, "validAmount");
            return (Criteria) this;
        }

        public Criteria andValidAmountNotIn(List<BigDecimal> values) {
            addCriterion("valid_amount not in", values, "validAmount");
            return (Criteria) this;
        }

        public Criteria andValidAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("valid_amount between", value1, value2, "validAmount");
            return (Criteria) this;
        }

        public Criteria andValidAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("valid_amount not between", value1, value2, "validAmount");
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

        public Criteria andItemIsNull() {
            addCriterion("item is null");
            return (Criteria) this;
        }

        public Criteria andItemIsNotNull() {
            addCriterion("item is not null");
            return (Criteria) this;
        }

        public Criteria andItemEqualTo(String value) {
            addCriterion("item =", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotEqualTo(String value) {
            addCriterion("item <>", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThan(String value) {
            addCriterion("item >", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThanOrEqualTo(String value) {
            addCriterion("item >=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThan(String value) {
            addCriterion("item <", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThanOrEqualTo(String value) {
            addCriterion("item <=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLike(String value) {
            addCriterion("item like", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotLike(String value) {
            addCriterion("item not like", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemIn(List<String> values) {
            addCriterion("item in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotIn(List<String> values) {
            addCriterion("item not in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemBetween(String value1, String value2) {
            addCriterion("item between", value1, value2, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotBetween(String value1, String value2) {
            addCriterion("item not between", value1, value2, "item");
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

        public Criteria andPlayIsNull() {
            addCriterion("play is null");
            return (Criteria) this;
        }

        public Criteria andPlayIsNotNull() {
            addCriterion("play is not null");
            return (Criteria) this;
        }

        public Criteria andPlayEqualTo(String value) {
            addCriterion("play =", value, "play");
            return (Criteria) this;
        }

        public Criteria andPlayNotEqualTo(String value) {
            addCriterion("play <>", value, "play");
            return (Criteria) this;
        }

        public Criteria andPlayGreaterThan(String value) {
            addCriterion("play >", value, "play");
            return (Criteria) this;
        }

        public Criteria andPlayGreaterThanOrEqualTo(String value) {
            addCriterion("play >=", value, "play");
            return (Criteria) this;
        }

        public Criteria andPlayLessThan(String value) {
            addCriterion("play <", value, "play");
            return (Criteria) this;
        }

        public Criteria andPlayLessThanOrEqualTo(String value) {
            addCriterion("play <=", value, "play");
            return (Criteria) this;
        }

        public Criteria andPlayLike(String value) {
            addCriterion("play like", value, "play");
            return (Criteria) this;
        }

        public Criteria andPlayNotLike(String value) {
            addCriterion("play not like", value, "play");
            return (Criteria) this;
        }

        public Criteria andPlayIn(List<String> values) {
            addCriterion("play in", values, "play");
            return (Criteria) this;
        }

        public Criteria andPlayNotIn(List<String> values) {
            addCriterion("play not in", values, "play");
            return (Criteria) this;
        }

        public Criteria andPlayBetween(String value1, String value2) {
            addCriterion("play between", value1, value2, "play");
            return (Criteria) this;
        }

        public Criteria andPlayNotBetween(String value1, String value2) {
            addCriterion("play not between", value1, value2, "play");
            return (Criteria) this;
        }

        public Criteria andPlayInfoIsNull() {
            addCriterion("play_info is null");
            return (Criteria) this;
        }

        public Criteria andPlayInfoIsNotNull() {
            addCriterion("play_info is not null");
            return (Criteria) this;
        }

        public Criteria andPlayInfoEqualTo(String value) {
            addCriterion("play_info =", value, "playInfo");
            return (Criteria) this;
        }

        public Criteria andPlayInfoNotEqualTo(String value) {
            addCriterion("play_info <>", value, "playInfo");
            return (Criteria) this;
        }

        public Criteria andPlayInfoGreaterThan(String value) {
            addCriterion("play_info >", value, "playInfo");
            return (Criteria) this;
        }

        public Criteria andPlayInfoGreaterThanOrEqualTo(String value) {
            addCriterion("play_info >=", value, "playInfo");
            return (Criteria) this;
        }

        public Criteria andPlayInfoLessThan(String value) {
            addCriterion("play_info <", value, "playInfo");
            return (Criteria) this;
        }

        public Criteria andPlayInfoLessThanOrEqualTo(String value) {
            addCriterion("play_info <=", value, "playInfo");
            return (Criteria) this;
        }

        public Criteria andPlayInfoLike(String value) {
            addCriterion("play_info like", value, "playInfo");
            return (Criteria) this;
        }

        public Criteria andPlayInfoNotLike(String value) {
            addCriterion("play_info not like", value, "playInfo");
            return (Criteria) this;
        }

        public Criteria andPlayInfoIn(List<String> values) {
            addCriterion("play_info in", values, "playInfo");
            return (Criteria) this;
        }

        public Criteria andPlayInfoNotIn(List<String> values) {
            addCriterion("play_info not in", values, "playInfo");
            return (Criteria) this;
        }

        public Criteria andPlayInfoBetween(String value1, String value2) {
            addCriterion("play_info between", value1, value2, "playInfo");
            return (Criteria) this;
        }

        public Criteria andPlayInfoNotBetween(String value1, String value2) {
            addCriterion("play_info not between", value1, value2, "playInfo");
            return (Criteria) this;
        }

        public Criteria andOddsIsNull() {
            addCriterion("odds is null");
            return (Criteria) this;
        }

        public Criteria andOddsIsNotNull() {
            addCriterion("odds is not null");
            return (Criteria) this;
        }

        public Criteria andOddsEqualTo(String value) {
            addCriterion("odds =", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsNotEqualTo(String value) {
            addCriterion("odds <>", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsGreaterThan(String value) {
            addCriterion("odds >", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsGreaterThanOrEqualTo(String value) {
            addCriterion("odds >=", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsLessThan(String value) {
            addCriterion("odds <", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsLessThanOrEqualTo(String value) {
            addCriterion("odds <=", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsLike(String value) {
            addCriterion("odds like", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsNotLike(String value) {
            addCriterion("odds not like", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsIn(List<String> values) {
            addCriterion("odds in", values, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsNotIn(List<String> values) {
            addCriterion("odds not in", values, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsBetween(String value1, String value2) {
            addCriterion("odds between", value1, value2, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsNotBetween(String value1, String value2) {
            addCriterion("odds not between", value1, value2, "odds");
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

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
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

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
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
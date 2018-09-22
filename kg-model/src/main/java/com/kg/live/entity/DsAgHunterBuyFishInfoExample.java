package com.kg.live.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DsAgHunterBuyFishInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsAgHunterBuyFishInfoExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andBillNoIsNull() {
            addCriterion("bill_no is null");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNotNull() {
            addCriterion("bill_no is not null");
            return (Criteria) this;
        }

        public Criteria andBillNoEqualTo(String value) {
            addCriterion("bill_no =", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotEqualTo(String value) {
            addCriterion("bill_no <>", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThan(String value) {
            addCriterion("bill_no >", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("bill_no >=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThan(String value) {
            addCriterion("bill_no <", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThanOrEqualTo(String value) {
            addCriterion("bill_no <=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLike(String value) {
            addCriterion("bill_no like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotLike(String value) {
            addCriterion("bill_no not like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoIn(List<String> values) {
            addCriterion("bill_no in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotIn(List<String> values) {
            addCriterion("bill_no not in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoBetween(String value1, String value2) {
            addCriterion("bill_no between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotBetween(String value1, String value2) {
            addCriterion("bill_no not between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andCashBillIsNull() {
            addCriterion("cash_bill is null");
            return (Criteria) this;
        }

        public Criteria andCashBillIsNotNull() {
            addCriterion("cash_bill is not null");
            return (Criteria) this;
        }

        public Criteria andCashBillEqualTo(String value) {
            addCriterion("cash_bill =", value, "cashBill");
            return (Criteria) this;
        }

        public Criteria andCashBillNotEqualTo(String value) {
            addCriterion("cash_bill <>", value, "cashBill");
            return (Criteria) this;
        }

        public Criteria andCashBillGreaterThan(String value) {
            addCriterion("cash_bill >", value, "cashBill");
            return (Criteria) this;
        }

        public Criteria andCashBillGreaterThanOrEqualTo(String value) {
            addCriterion("cash_bill >=", value, "cashBill");
            return (Criteria) this;
        }

        public Criteria andCashBillLessThan(String value) {
            addCriterion("cash_bill <", value, "cashBill");
            return (Criteria) this;
        }

        public Criteria andCashBillLessThanOrEqualTo(String value) {
            addCriterion("cash_bill <=", value, "cashBill");
            return (Criteria) this;
        }

        public Criteria andCashBillLike(String value) {
            addCriterion("cash_bill like", value, "cashBill");
            return (Criteria) this;
        }

        public Criteria andCashBillNotLike(String value) {
            addCriterion("cash_bill not like", value, "cashBill");
            return (Criteria) this;
        }

        public Criteria andCashBillIn(List<String> values) {
            addCriterion("cash_bill in", values, "cashBill");
            return (Criteria) this;
        }

        public Criteria andCashBillNotIn(List<String> values) {
            addCriterion("cash_bill not in", values, "cashBill");
            return (Criteria) this;
        }

        public Criteria andCashBillBetween(String value1, String value2) {
            addCriterion("cash_bill between", value1, value2, "cashBill");
            return (Criteria) this;
        }

        public Criteria andCashBillNotBetween(String value1, String value2) {
            addCriterion("cash_bill not between", value1, value2, "cashBill");
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

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Byte value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Byte value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Byte value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Byte value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Byte value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Byte> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Byte> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Byte value1, Byte value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("user_type not between", value1, value2, "userType");
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andFishIdIsNull() {
            addCriterion("fish_id is null");
            return (Criteria) this;
        }

        public Criteria andFishIdIsNotNull() {
            addCriterion("fish_id is not null");
            return (Criteria) this;
        }

        public Criteria andFishIdEqualTo(String value) {
            addCriterion("fish_id =", value, "fishId");
            return (Criteria) this;
        }

        public Criteria andFishIdNotEqualTo(String value) {
            addCriterion("fish_id <>", value, "fishId");
            return (Criteria) this;
        }

        public Criteria andFishIdGreaterThan(String value) {
            addCriterion("fish_id >", value, "fishId");
            return (Criteria) this;
        }

        public Criteria andFishIdGreaterThanOrEqualTo(String value) {
            addCriterion("fish_id >=", value, "fishId");
            return (Criteria) this;
        }

        public Criteria andFishIdLessThan(String value) {
            addCriterion("fish_id <", value, "fishId");
            return (Criteria) this;
        }

        public Criteria andFishIdLessThanOrEqualTo(String value) {
            addCriterion("fish_id <=", value, "fishId");
            return (Criteria) this;
        }

        public Criteria andFishIdLike(String value) {
            addCriterion("fish_id like", value, "fishId");
            return (Criteria) this;
        }

        public Criteria andFishIdNotLike(String value) {
            addCriterion("fish_id not like", value, "fishId");
            return (Criteria) this;
        }

        public Criteria andFishIdIn(List<String> values) {
            addCriterion("fish_id in", values, "fishId");
            return (Criteria) this;
        }

        public Criteria andFishIdNotIn(List<String> values) {
            addCriterion("fish_id not in", values, "fishId");
            return (Criteria) this;
        }

        public Criteria andFishIdBetween(String value1, String value2) {
            addCriterion("fish_id between", value1, value2, "fishId");
            return (Criteria) this;
        }

        public Criteria andFishIdNotBetween(String value1, String value2) {
            addCriterion("fish_id not between", value1, value2, "fishId");
            return (Criteria) this;
        }

        public Criteria andFishTypeIdIsNull() {
            addCriterion("fish_type_id is null");
            return (Criteria) this;
        }

        public Criteria andFishTypeIdIsNotNull() {
            addCriterion("fish_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andFishTypeIdEqualTo(Byte value) {
            addCriterion("fish_type_id =", value, "fishTypeId");
            return (Criteria) this;
        }

        public Criteria andFishTypeIdNotEqualTo(Byte value) {
            addCriterion("fish_type_id <>", value, "fishTypeId");
            return (Criteria) this;
        }

        public Criteria andFishTypeIdGreaterThan(Byte value) {
            addCriterion("fish_type_id >", value, "fishTypeId");
            return (Criteria) this;
        }

        public Criteria andFishTypeIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("fish_type_id >=", value, "fishTypeId");
            return (Criteria) this;
        }

        public Criteria andFishTypeIdLessThan(Byte value) {
            addCriterion("fish_type_id <", value, "fishTypeId");
            return (Criteria) this;
        }

        public Criteria andFishTypeIdLessThanOrEqualTo(Byte value) {
            addCriterion("fish_type_id <=", value, "fishTypeId");
            return (Criteria) this;
        }

        public Criteria andFishTypeIdIn(List<Byte> values) {
            addCriterion("fish_type_id in", values, "fishTypeId");
            return (Criteria) this;
        }

        public Criteria andFishTypeIdNotIn(List<Byte> values) {
            addCriterion("fish_type_id not in", values, "fishTypeId");
            return (Criteria) this;
        }

        public Criteria andFishTypeIdBetween(Byte value1, Byte value2) {
            addCriterion("fish_type_id between", value1, value2, "fishTypeId");
            return (Criteria) this;
        }

        public Criteria andFishTypeIdNotBetween(Byte value1, Byte value2) {
            addCriterion("fish_type_id not between", value1, value2, "fishTypeId");
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

        public Criteria andSroomIdIsNull() {
            addCriterion("sroom_id is null");
            return (Criteria) this;
        }

        public Criteria andSroomIdIsNotNull() {
            addCriterion("sroom_id is not null");
            return (Criteria) this;
        }

        public Criteria andSroomIdEqualTo(Integer value) {
            addCriterion("sroom_id =", value, "sroomId");
            return (Criteria) this;
        }

        public Criteria andSroomIdNotEqualTo(Integer value) {
            addCriterion("sroom_id <>", value, "sroomId");
            return (Criteria) this;
        }

        public Criteria andSroomIdGreaterThan(Integer value) {
            addCriterion("sroom_id >", value, "sroomId");
            return (Criteria) this;
        }

        public Criteria andSroomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sroom_id >=", value, "sroomId");
            return (Criteria) this;
        }

        public Criteria andSroomIdLessThan(Integer value) {
            addCriterion("sroom_id <", value, "sroomId");
            return (Criteria) this;
        }

        public Criteria andSroomIdLessThanOrEqualTo(Integer value) {
            addCriterion("sroom_id <=", value, "sroomId");
            return (Criteria) this;
        }

        public Criteria andSroomIdIn(List<Integer> values) {
            addCriterion("sroom_id in", values, "sroomId");
            return (Criteria) this;
        }

        public Criteria andSroomIdNotIn(List<Integer> values) {
            addCriterion("sroom_id not in", values, "sroomId");
            return (Criteria) this;
        }

        public Criteria andSroomIdBetween(Integer value1, Integer value2) {
            addCriterion("sroom_id between", value1, value2, "sroomId");
            return (Criteria) this;
        }

        public Criteria andSroomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sroom_id not between", value1, value2, "sroomId");
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

        public Criteria andUserCashBeforeIsNull() {
            addCriterion("user_cash_before is null");
            return (Criteria) this;
        }

        public Criteria andUserCashBeforeIsNotNull() {
            addCriterion("user_cash_before is not null");
            return (Criteria) this;
        }

        public Criteria andUserCashBeforeEqualTo(BigDecimal value) {
            addCriterion("user_cash_before =", value, "userCashBefore");
            return (Criteria) this;
        }

        public Criteria andUserCashBeforeNotEqualTo(BigDecimal value) {
            addCriterion("user_cash_before <>", value, "userCashBefore");
            return (Criteria) this;
        }

        public Criteria andUserCashBeforeGreaterThan(BigDecimal value) {
            addCriterion("user_cash_before >", value, "userCashBefore");
            return (Criteria) this;
        }

        public Criteria andUserCashBeforeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("user_cash_before >=", value, "userCashBefore");
            return (Criteria) this;
        }

        public Criteria andUserCashBeforeLessThan(BigDecimal value) {
            addCriterion("user_cash_before <", value, "userCashBefore");
            return (Criteria) this;
        }

        public Criteria andUserCashBeforeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("user_cash_before <=", value, "userCashBefore");
            return (Criteria) this;
        }

        public Criteria andUserCashBeforeIn(List<BigDecimal> values) {
            addCriterion("user_cash_before in", values, "userCashBefore");
            return (Criteria) this;
        }

        public Criteria andUserCashBeforeNotIn(List<BigDecimal> values) {
            addCriterion("user_cash_before not in", values, "userCashBefore");
            return (Criteria) this;
        }

        public Criteria andUserCashBeforeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_cash_before between", value1, value2, "userCashBefore");
            return (Criteria) this;
        }

        public Criteria andUserCashBeforeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_cash_before not between", value1, value2, "userCashBefore");
            return (Criteria) this;
        }

        public Criteria andUserCashAfterIsNull() {
            addCriterion("user_cash_after is null");
            return (Criteria) this;
        }

        public Criteria andUserCashAfterIsNotNull() {
            addCriterion("user_cash_after is not null");
            return (Criteria) this;
        }

        public Criteria andUserCashAfterEqualTo(BigDecimal value) {
            addCriterion("user_cash_after =", value, "userCashAfter");
            return (Criteria) this;
        }

        public Criteria andUserCashAfterNotEqualTo(BigDecimal value) {
            addCriterion("user_cash_after <>", value, "userCashAfter");
            return (Criteria) this;
        }

        public Criteria andUserCashAfterGreaterThan(BigDecimal value) {
            addCriterion("user_cash_after >", value, "userCashAfter");
            return (Criteria) this;
        }

        public Criteria andUserCashAfterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("user_cash_after >=", value, "userCashAfter");
            return (Criteria) this;
        }

        public Criteria andUserCashAfterLessThan(BigDecimal value) {
            addCriterion("user_cash_after <", value, "userCashAfter");
            return (Criteria) this;
        }

        public Criteria andUserCashAfterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("user_cash_after <=", value, "userCashAfter");
            return (Criteria) this;
        }

        public Criteria andUserCashAfterIn(List<BigDecimal> values) {
            addCriterion("user_cash_after in", values, "userCashAfter");
            return (Criteria) this;
        }

        public Criteria andUserCashAfterNotIn(List<BigDecimal> values) {
            addCriterion("user_cash_after not in", values, "userCashAfter");
            return (Criteria) this;
        }

        public Criteria andUserCashAfterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_cash_after between", value1, value2, "userCashAfter");
            return (Criteria) this;
        }

        public Criteria andUserCashAfterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_cash_after not between", value1, value2, "userCashAfter");
            return (Criteria) this;
        }

        public Criteria andHunterUidIsNull() {
            addCriterion("hunter_uid is null");
            return (Criteria) this;
        }

        public Criteria andHunterUidIsNotNull() {
            addCriterion("hunter_uid is not null");
            return (Criteria) this;
        }

        public Criteria andHunterUidEqualTo(String value) {
            addCriterion("hunter_uid =", value, "hunterUid");
            return (Criteria) this;
        }

        public Criteria andHunterUidNotEqualTo(String value) {
            addCriterion("hunter_uid <>", value, "hunterUid");
            return (Criteria) this;
        }

        public Criteria andHunterUidGreaterThan(String value) {
            addCriterion("hunter_uid >", value, "hunterUid");
            return (Criteria) this;
        }

        public Criteria andHunterUidGreaterThanOrEqualTo(String value) {
            addCriterion("hunter_uid >=", value, "hunterUid");
            return (Criteria) this;
        }

        public Criteria andHunterUidLessThan(String value) {
            addCriterion("hunter_uid <", value, "hunterUid");
            return (Criteria) this;
        }

        public Criteria andHunterUidLessThanOrEqualTo(String value) {
            addCriterion("hunter_uid <=", value, "hunterUid");
            return (Criteria) this;
        }

        public Criteria andHunterUidLike(String value) {
            addCriterion("hunter_uid like", value, "hunterUid");
            return (Criteria) this;
        }

        public Criteria andHunterUidNotLike(String value) {
            addCriterion("hunter_uid not like", value, "hunterUid");
            return (Criteria) this;
        }

        public Criteria andHunterUidIn(List<String> values) {
            addCriterion("hunter_uid in", values, "hunterUid");
            return (Criteria) this;
        }

        public Criteria andHunterUidNotIn(List<String> values) {
            addCriterion("hunter_uid not in", values, "hunterUid");
            return (Criteria) this;
        }

        public Criteria andHunterUidBetween(String value1, String value2) {
            addCriterion("hunter_uid between", value1, value2, "hunterUid");
            return (Criteria) this;
        }

        public Criteria andHunterUidNotBetween(String value1, String value2) {
            addCriterion("hunter_uid not between", value1, value2, "hunterUid");
            return (Criteria) this;
        }

        public Criteria andHunterPidIsNull() {
            addCriterion("hunter_pid is null");
            return (Criteria) this;
        }

        public Criteria andHunterPidIsNotNull() {
            addCriterion("hunter_pid is not null");
            return (Criteria) this;
        }

        public Criteria andHunterPidEqualTo(String value) {
            addCriterion("hunter_pid =", value, "hunterPid");
            return (Criteria) this;
        }

        public Criteria andHunterPidNotEqualTo(String value) {
            addCriterion("hunter_pid <>", value, "hunterPid");
            return (Criteria) this;
        }

        public Criteria andHunterPidGreaterThan(String value) {
            addCriterion("hunter_pid >", value, "hunterPid");
            return (Criteria) this;
        }

        public Criteria andHunterPidGreaterThanOrEqualTo(String value) {
            addCriterion("hunter_pid >=", value, "hunterPid");
            return (Criteria) this;
        }

        public Criteria andHunterPidLessThan(String value) {
            addCriterion("hunter_pid <", value, "hunterPid");
            return (Criteria) this;
        }

        public Criteria andHunterPidLessThanOrEqualTo(String value) {
            addCriterion("hunter_pid <=", value, "hunterPid");
            return (Criteria) this;
        }

        public Criteria andHunterPidLike(String value) {
            addCriterion("hunter_pid like", value, "hunterPid");
            return (Criteria) this;
        }

        public Criteria andHunterPidNotLike(String value) {
            addCriterion("hunter_pid not like", value, "hunterPid");
            return (Criteria) this;
        }

        public Criteria andHunterPidIn(List<String> values) {
            addCriterion("hunter_pid in", values, "hunterPid");
            return (Criteria) this;
        }

        public Criteria andHunterPidNotIn(List<String> values) {
            addCriterion("hunter_pid not in", values, "hunterPid");
            return (Criteria) this;
        }

        public Criteria andHunterPidBetween(String value1, String value2) {
            addCriterion("hunter_pid between", value1, value2, "hunterPid");
            return (Criteria) this;
        }

        public Criteria andHunterPidNotBetween(String value1, String value2) {
            addCriterion("hunter_pid not between", value1, value2, "hunterPid");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeIsNull() {
            addCriterion("hunter_user_type is null");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeIsNotNull() {
            addCriterion("hunter_user_type is not null");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeEqualTo(String value) {
            addCriterion("hunter_user_type =", value, "hunterUserType");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeNotEqualTo(String value) {
            addCriterion("hunter_user_type <>", value, "hunterUserType");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeGreaterThan(String value) {
            addCriterion("hunter_user_type >", value, "hunterUserType");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("hunter_user_type >=", value, "hunterUserType");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeLessThan(String value) {
            addCriterion("hunter_user_type <", value, "hunterUserType");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeLessThanOrEqualTo(String value) {
            addCriterion("hunter_user_type <=", value, "hunterUserType");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeLike(String value) {
            addCriterion("hunter_user_type like", value, "hunterUserType");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeNotLike(String value) {
            addCriterion("hunter_user_type not like", value, "hunterUserType");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeIn(List<String> values) {
            addCriterion("hunter_user_type in", values, "hunterUserType");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeNotIn(List<String> values) {
            addCriterion("hunter_user_type not in", values, "hunterUserType");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeBetween(String value1, String value2) {
            addCriterion("hunter_user_type between", value1, value2, "hunterUserType");
            return (Criteria) this;
        }

        public Criteria andHunterUserTypeNotBetween(String value1, String value2) {
            addCriterion("hunter_user_type not between", value1, value2, "hunterUserType");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameIsNull() {
            addCriterion("hunter_user_name is null");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameIsNotNull() {
            addCriterion("hunter_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameEqualTo(String value) {
            addCriterion("hunter_user_name =", value, "hunterUserName");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameNotEqualTo(String value) {
            addCriterion("hunter_user_name <>", value, "hunterUserName");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameGreaterThan(String value) {
            addCriterion("hunter_user_name >", value, "hunterUserName");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("hunter_user_name >=", value, "hunterUserName");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameLessThan(String value) {
            addCriterion("hunter_user_name <", value, "hunterUserName");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameLessThanOrEqualTo(String value) {
            addCriterion("hunter_user_name <=", value, "hunterUserName");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameLike(String value) {
            addCriterion("hunter_user_name like", value, "hunterUserName");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameNotLike(String value) {
            addCriterion("hunter_user_name not like", value, "hunterUserName");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameIn(List<String> values) {
            addCriterion("hunter_user_name in", values, "hunterUserName");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameNotIn(List<String> values) {
            addCriterion("hunter_user_name not in", values, "hunterUserName");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameBetween(String value1, String value2) {
            addCriterion("hunter_user_name between", value1, value2, "hunterUserName");
            return (Criteria) this;
        }

        public Criteria andHunterUserNameNotBetween(String value1, String value2) {
            addCriterion("hunter_user_name not between", value1, value2, "hunterUserName");
            return (Criteria) this;
        }

        public Criteria andFishLifeIsNull() {
            addCriterion("fish_life is null");
            return (Criteria) this;
        }

        public Criteria andFishLifeIsNotNull() {
            addCriterion("fish_life is not null");
            return (Criteria) this;
        }

        public Criteria andFishLifeEqualTo(String value) {
            addCriterion("fish_life =", value, "fishLife");
            return (Criteria) this;
        }

        public Criteria andFishLifeNotEqualTo(String value) {
            addCriterion("fish_life <>", value, "fishLife");
            return (Criteria) this;
        }

        public Criteria andFishLifeGreaterThan(String value) {
            addCriterion("fish_life >", value, "fishLife");
            return (Criteria) this;
        }

        public Criteria andFishLifeGreaterThanOrEqualTo(String value) {
            addCriterion("fish_life >=", value, "fishLife");
            return (Criteria) this;
        }

        public Criteria andFishLifeLessThan(String value) {
            addCriterion("fish_life <", value, "fishLife");
            return (Criteria) this;
        }

        public Criteria andFishLifeLessThanOrEqualTo(String value) {
            addCriterion("fish_life <=", value, "fishLife");
            return (Criteria) this;
        }

        public Criteria andFishLifeLike(String value) {
            addCriterion("fish_life like", value, "fishLife");
            return (Criteria) this;
        }

        public Criteria andFishLifeNotLike(String value) {
            addCriterion("fish_life not like", value, "fishLife");
            return (Criteria) this;
        }

        public Criteria andFishLifeIn(List<String> values) {
            addCriterion("fish_life in", values, "fishLife");
            return (Criteria) this;
        }

        public Criteria andFishLifeNotIn(List<String> values) {
            addCriterion("fish_life not in", values, "fishLife");
            return (Criteria) this;
        }

        public Criteria andFishLifeBetween(String value1, String value2) {
            addCriterion("fish_life between", value1, value2, "fishLife");
            return (Criteria) this;
        }

        public Criteria andFishLifeNotBetween(String value1, String value2) {
            addCriterion("fish_life not between", value1, value2, "fishLife");
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

        public Criteria andReadIsNull() {
            addCriterion("read is null");
            return (Criteria) this;
        }

        public Criteria andReadIsNotNull() {
            addCriterion("read is not null");
            return (Criteria) this;
        }

        public Criteria andReadEqualTo(String value) {
            addCriterion("read =", value, "read");
            return (Criteria) this;
        }

        public Criteria andReadNotEqualTo(String value) {
            addCriterion("read <>", value, "read");
            return (Criteria) this;
        }

        public Criteria andReadGreaterThan(String value) {
            addCriterion("read >", value, "read");
            return (Criteria) this;
        }

        public Criteria andReadGreaterThanOrEqualTo(String value) {
            addCriterion("read >=", value, "read");
            return (Criteria) this;
        }

        public Criteria andReadLessThan(String value) {
            addCriterion("read <", value, "read");
            return (Criteria) this;
        }

        public Criteria andReadLessThanOrEqualTo(String value) {
            addCriterion("read <=", value, "read");
            return (Criteria) this;
        }

        public Criteria andReadLike(String value) {
            addCriterion("read like", value, "read");
            return (Criteria) this;
        }

        public Criteria andReadNotLike(String value) {
            addCriterion("read not like", value, "read");
            return (Criteria) this;
        }

        public Criteria andReadIn(List<String> values) {
            addCriterion("read in", values, "read");
            return (Criteria) this;
        }

        public Criteria andReadNotIn(List<String> values) {
            addCriterion("read not in", values, "read");
            return (Criteria) this;
        }

        public Criteria andReadBetween(String value1, String value2) {
            addCriterion("read between", value1, value2, "read");
            return (Criteria) this;
        }

        public Criteria andReadNotBetween(String value1, String value2) {
            addCriterion("read not between", value1, value2, "read");
            return (Criteria) this;
        }

        public Criteria andBulletInFishIsNull() {
            addCriterion("bullet_in_fish is null");
            return (Criteria) this;
        }

        public Criteria andBulletInFishIsNotNull() {
            addCriterion("bullet_in_fish is not null");
            return (Criteria) this;
        }

        public Criteria andBulletInFishEqualTo(Integer value) {
            addCriterion("bullet_in_fish =", value, "bulletInFish");
            return (Criteria) this;
        }

        public Criteria andBulletInFishNotEqualTo(Integer value) {
            addCriterion("bullet_in_fish <>", value, "bulletInFish");
            return (Criteria) this;
        }

        public Criteria andBulletInFishGreaterThan(Integer value) {
            addCriterion("bullet_in_fish >", value, "bulletInFish");
            return (Criteria) this;
        }

        public Criteria andBulletInFishGreaterThanOrEqualTo(Integer value) {
            addCriterion("bullet_in_fish >=", value, "bulletInFish");
            return (Criteria) this;
        }

        public Criteria andBulletInFishLessThan(Integer value) {
            addCriterion("bullet_in_fish <", value, "bulletInFish");
            return (Criteria) this;
        }

        public Criteria andBulletInFishLessThanOrEqualTo(Integer value) {
            addCriterion("bullet_in_fish <=", value, "bulletInFish");
            return (Criteria) this;
        }

        public Criteria andBulletInFishIn(List<Integer> values) {
            addCriterion("bullet_in_fish in", values, "bulletInFish");
            return (Criteria) this;
        }

        public Criteria andBulletInFishNotIn(List<Integer> values) {
            addCriterion("bullet_in_fish not in", values, "bulletInFish");
            return (Criteria) this;
        }

        public Criteria andBulletInFishBetween(Integer value1, Integer value2) {
            addCriterion("bullet_in_fish between", value1, value2, "bulletInFish");
            return (Criteria) this;
        }

        public Criteria andBulletInFishNotBetween(Integer value1, Integer value2) {
            addCriterion("bullet_in_fish not between", value1, value2, "bulletInFish");
            return (Criteria) this;
        }

        public Criteria andBullletCostInFishIsNull() {
            addCriterion("bulllet_cost_in_fish is null");
            return (Criteria) this;
        }

        public Criteria andBullletCostInFishIsNotNull() {
            addCriterion("bulllet_cost_in_fish is not null");
            return (Criteria) this;
        }

        public Criteria andBullletCostInFishEqualTo(BigDecimal value) {
            addCriterion("bulllet_cost_in_fish =", value, "bullletCostInFish");
            return (Criteria) this;
        }

        public Criteria andBullletCostInFishNotEqualTo(BigDecimal value) {
            addCriterion("bulllet_cost_in_fish <>", value, "bullletCostInFish");
            return (Criteria) this;
        }

        public Criteria andBullletCostInFishGreaterThan(BigDecimal value) {
            addCriterion("bulllet_cost_in_fish >", value, "bullletCostInFish");
            return (Criteria) this;
        }

        public Criteria andBullletCostInFishGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bulllet_cost_in_fish >=", value, "bullletCostInFish");
            return (Criteria) this;
        }

        public Criteria andBullletCostInFishLessThan(BigDecimal value) {
            addCriterion("bulllet_cost_in_fish <", value, "bullletCostInFish");
            return (Criteria) this;
        }

        public Criteria andBullletCostInFishLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bulllet_cost_in_fish <=", value, "bullletCostInFish");
            return (Criteria) this;
        }

        public Criteria andBullletCostInFishIn(List<BigDecimal> values) {
            addCriterion("bulllet_cost_in_fish in", values, "bullletCostInFish");
            return (Criteria) this;
        }

        public Criteria andBullletCostInFishNotIn(List<BigDecimal> values) {
            addCriterion("bulllet_cost_in_fish not in", values, "bullletCostInFish");
            return (Criteria) this;
        }

        public Criteria andBullletCostInFishBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bulllet_cost_in_fish between", value1, value2, "bullletCostInFish");
            return (Criteria) this;
        }

        public Criteria andBullletCostInFishNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bulllet_cost_in_fish not between", value1, value2, "bullletCostInFish");
            return (Criteria) this;
        }

        public Criteria andBullletCostIsNull() {
            addCriterion("bulllet_cost is null");
            return (Criteria) this;
        }

        public Criteria andBullletCostIsNotNull() {
            addCriterion("bulllet_cost is not null");
            return (Criteria) this;
        }

        public Criteria andBullletCostEqualTo(BigDecimal value) {
            addCriterion("bulllet_cost =", value, "bullletCost");
            return (Criteria) this;
        }

        public Criteria andBullletCostNotEqualTo(BigDecimal value) {
            addCriterion("bulllet_cost <>", value, "bullletCost");
            return (Criteria) this;
        }

        public Criteria andBullletCostGreaterThan(BigDecimal value) {
            addCriterion("bulllet_cost >", value, "bullletCost");
            return (Criteria) this;
        }

        public Criteria andBullletCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bulllet_cost >=", value, "bullletCost");
            return (Criteria) this;
        }

        public Criteria andBullletCostLessThan(BigDecimal value) {
            addCriterion("bulllet_cost <", value, "bullletCost");
            return (Criteria) this;
        }

        public Criteria andBullletCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bulllet_cost <=", value, "bullletCost");
            return (Criteria) this;
        }

        public Criteria andBullletCostIn(List<BigDecimal> values) {
            addCriterion("bulllet_cost in", values, "bullletCost");
            return (Criteria) this;
        }

        public Criteria andBullletCostNotIn(List<BigDecimal> values) {
            addCriterion("bulllet_cost not in", values, "bullletCost");
            return (Criteria) this;
        }

        public Criteria andBullletCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bulllet_cost between", value1, value2, "bullletCost");
            return (Criteria) this;
        }

        public Criteria andBullletCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bulllet_cost not between", value1, value2, "bullletCost");
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

        public Criteria andFishCostIsNull() {
            addCriterion("fish_cost is null");
            return (Criteria) this;
        }

        public Criteria andFishCostIsNotNull() {
            addCriterion("fish_cost is not null");
            return (Criteria) this;
        }

        public Criteria andFishCostEqualTo(BigDecimal value) {
            addCriterion("fish_cost =", value, "fishCost");
            return (Criteria) this;
        }

        public Criteria andFishCostNotEqualTo(BigDecimal value) {
            addCriterion("fish_cost <>", value, "fishCost");
            return (Criteria) this;
        }

        public Criteria andFishCostGreaterThan(BigDecimal value) {
            addCriterion("fish_cost >", value, "fishCost");
            return (Criteria) this;
        }

        public Criteria andFishCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fish_cost >=", value, "fishCost");
            return (Criteria) this;
        }

        public Criteria andFishCostLessThan(BigDecimal value) {
            addCriterion("fish_cost <", value, "fishCost");
            return (Criteria) this;
        }

        public Criteria andFishCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fish_cost <=", value, "fishCost");
            return (Criteria) this;
        }

        public Criteria andFishCostIn(List<BigDecimal> values) {
            addCriterion("fish_cost in", values, "fishCost");
            return (Criteria) this;
        }

        public Criteria andFishCostNotIn(List<BigDecimal> values) {
            addCriterion("fish_cost not in", values, "fishCost");
            return (Criteria) this;
        }

        public Criteria andFishCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fish_cost between", value1, value2, "fishCost");
            return (Criteria) this;
        }

        public Criteria andFishCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fish_cost not between", value1, value2, "fishCost");
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

        public Criteria andExBonusReturnIsNull() {
            addCriterion("ex_bonus_return is null");
            return (Criteria) this;
        }

        public Criteria andExBonusReturnIsNotNull() {
            addCriterion("ex_bonus_return is not null");
            return (Criteria) this;
        }

        public Criteria andExBonusReturnEqualTo(BigDecimal value) {
            addCriterion("ex_bonus_return =", value, "exBonusReturn");
            return (Criteria) this;
        }

        public Criteria andExBonusReturnNotEqualTo(BigDecimal value) {
            addCriterion("ex_bonus_return <>", value, "exBonusReturn");
            return (Criteria) this;
        }

        public Criteria andExBonusReturnGreaterThan(BigDecimal value) {
            addCriterion("ex_bonus_return >", value, "exBonusReturn");
            return (Criteria) this;
        }

        public Criteria andExBonusReturnGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ex_bonus_return >=", value, "exBonusReturn");
            return (Criteria) this;
        }

        public Criteria andExBonusReturnLessThan(BigDecimal value) {
            addCriterion("ex_bonus_return <", value, "exBonusReturn");
            return (Criteria) this;
        }

        public Criteria andExBonusReturnLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ex_bonus_return <=", value, "exBonusReturn");
            return (Criteria) this;
        }

        public Criteria andExBonusReturnIn(List<BigDecimal> values) {
            addCriterion("ex_bonus_return in", values, "exBonusReturn");
            return (Criteria) this;
        }

        public Criteria andExBonusReturnNotIn(List<BigDecimal> values) {
            addCriterion("ex_bonus_return not in", values, "exBonusReturn");
            return (Criteria) this;
        }

        public Criteria andExBonusReturnBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ex_bonus_return between", value1, value2, "exBonusReturn");
            return (Criteria) this;
        }

        public Criteria andExBonusReturnNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ex_bonus_return not between", value1, value2, "exBonusReturn");
            return (Criteria) this;
        }

        public Criteria andHuntedTimeIsNull() {
            addCriterion("hunted_time is null");
            return (Criteria) this;
        }

        public Criteria andHuntedTimeIsNotNull() {
            addCriterion("hunted_time is not null");
            return (Criteria) this;
        }

        public Criteria andHuntedTimeEqualTo(Date value) {
            addCriterion("hunted_time =", value, "huntedTime");
            return (Criteria) this;
        }

        public Criteria andHuntedTimeNotEqualTo(Date value) {
            addCriterion("hunted_time <>", value, "huntedTime");
            return (Criteria) this;
        }

        public Criteria andHuntedTimeGreaterThan(Date value) {
            addCriterion("hunted_time >", value, "huntedTime");
            return (Criteria) this;
        }

        public Criteria andHuntedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hunted_time >=", value, "huntedTime");
            return (Criteria) this;
        }

        public Criteria andHuntedTimeLessThan(Date value) {
            addCriterion("hunted_time <", value, "huntedTime");
            return (Criteria) this;
        }

        public Criteria andHuntedTimeLessThanOrEqualTo(Date value) {
            addCriterion("hunted_time <=", value, "huntedTime");
            return (Criteria) this;
        }

        public Criteria andHuntedTimeIn(List<Date> values) {
            addCriterion("hunted_time in", values, "huntedTime");
            return (Criteria) this;
        }

        public Criteria andHuntedTimeNotIn(List<Date> values) {
            addCriterion("hunted_time not in", values, "huntedTime");
            return (Criteria) this;
        }

        public Criteria andHuntedTimeBetween(Date value1, Date value2) {
            addCriterion("hunted_time between", value1, value2, "huntedTime");
            return (Criteria) this;
        }

        public Criteria andHuntedTimeNotBetween(Date value1, Date value2) {
            addCriterion("hunted_time not between", value1, value2, "huntedTime");
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
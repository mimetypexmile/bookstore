package com.xzl.bookstore.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRecevierNameIsNull() {
            addCriterion("recevier_name is null");
            return (Criteria) this;
        }

        public Criteria andRecevierNameIsNotNull() {
            addCriterion("recevier_name is not null");
            return (Criteria) this;
        }

        public Criteria andRecevierNameEqualTo(String value) {
            addCriterion("recevier_name =", value, "recevierName");
            return (Criteria) this;
        }

        public Criteria andRecevierNameNotEqualTo(String value) {
            addCriterion("recevier_name <>", value, "recevierName");
            return (Criteria) this;
        }

        public Criteria andRecevierNameGreaterThan(String value) {
            addCriterion("recevier_name >", value, "recevierName");
            return (Criteria) this;
        }

        public Criteria andRecevierNameGreaterThanOrEqualTo(String value) {
            addCriterion("recevier_name >=", value, "recevierName");
            return (Criteria) this;
        }

        public Criteria andRecevierNameLessThan(String value) {
            addCriterion("recevier_name <", value, "recevierName");
            return (Criteria) this;
        }

        public Criteria andRecevierNameLessThanOrEqualTo(String value) {
            addCriterion("recevier_name <=", value, "recevierName");
            return (Criteria) this;
        }

        public Criteria andRecevierNameLike(String value) {
            addCriterion("recevier_name like", value, "recevierName");
            return (Criteria) this;
        }

        public Criteria andRecevierNameNotLike(String value) {
            addCriterion("recevier_name not like", value, "recevierName");
            return (Criteria) this;
        }

        public Criteria andRecevierNameIn(List<String> values) {
            addCriterion("recevier_name in", values, "recevierName");
            return (Criteria) this;
        }

        public Criteria andRecevierNameNotIn(List<String> values) {
            addCriterion("recevier_name not in", values, "recevierName");
            return (Criteria) this;
        }

        public Criteria andRecevierNameBetween(String value1, String value2) {
            addCriterion("recevier_name between", value1, value2, "recevierName");
            return (Criteria) this;
        }

        public Criteria andRecevierNameNotBetween(String value1, String value2) {
            addCriterion("recevier_name not between", value1, value2, "recevierName");
            return (Criteria) this;
        }

        public Criteria andAddrIdIsNull() {
            addCriterion("addr_id is null");
            return (Criteria) this;
        }

        public Criteria andAddrIdIsNotNull() {
            addCriterion("addr_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddrIdEqualTo(String value) {
            addCriterion("addr_id =", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdNotEqualTo(String value) {
            addCriterion("addr_id <>", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdGreaterThan(String value) {
            addCriterion("addr_id >", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdGreaterThanOrEqualTo(String value) {
            addCriterion("addr_id >=", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdLessThan(String value) {
            addCriterion("addr_id <", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdLessThanOrEqualTo(String value) {
            addCriterion("addr_id <=", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdLike(String value) {
            addCriterion("addr_id like", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdNotLike(String value) {
            addCriterion("addr_id not like", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdIn(List<String> values) {
            addCriterion("addr_id in", values, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdNotIn(List<String> values) {
            addCriterion("addr_id not in", values, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdBetween(String value1, String value2) {
            addCriterion("addr_id between", value1, value2, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdNotBetween(String value1, String value2) {
            addCriterion("addr_id not between", value1, value2, "addrId");
            return (Criteria) this;
        }

        public Criteria andRecevierTelIsNull() {
            addCriterion("recevier_tel is null");
            return (Criteria) this;
        }

        public Criteria andRecevierTelIsNotNull() {
            addCriterion("recevier_tel is not null");
            return (Criteria) this;
        }

        public Criteria andRecevierTelEqualTo(String value) {
            addCriterion("recevier_tel =", value, "recevierTel");
            return (Criteria) this;
        }

        public Criteria andRecevierTelNotEqualTo(String value) {
            addCriterion("recevier_tel <>", value, "recevierTel");
            return (Criteria) this;
        }

        public Criteria andRecevierTelGreaterThan(String value) {
            addCriterion("recevier_tel >", value, "recevierTel");
            return (Criteria) this;
        }

        public Criteria andRecevierTelGreaterThanOrEqualTo(String value) {
            addCriterion("recevier_tel >=", value, "recevierTel");
            return (Criteria) this;
        }

        public Criteria andRecevierTelLessThan(String value) {
            addCriterion("recevier_tel <", value, "recevierTel");
            return (Criteria) this;
        }

        public Criteria andRecevierTelLessThanOrEqualTo(String value) {
            addCriterion("recevier_tel <=", value, "recevierTel");
            return (Criteria) this;
        }

        public Criteria andRecevierTelLike(String value) {
            addCriterion("recevier_tel like", value, "recevierTel");
            return (Criteria) this;
        }

        public Criteria andRecevierTelNotLike(String value) {
            addCriterion("recevier_tel not like", value, "recevierTel");
            return (Criteria) this;
        }

        public Criteria andRecevierTelIn(List<String> values) {
            addCriterion("recevier_tel in", values, "recevierTel");
            return (Criteria) this;
        }

        public Criteria andRecevierTelNotIn(List<String> values) {
            addCriterion("recevier_tel not in", values, "recevierTel");
            return (Criteria) this;
        }

        public Criteria andRecevierTelBetween(String value1, String value2) {
            addCriterion("recevier_tel between", value1, value2, "recevierTel");
            return (Criteria) this;
        }

        public Criteria andRecevierTelNotBetween(String value1, String value2) {
            addCriterion("recevier_tel not between", value1, value2, "recevierTel");
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
package com.demo.chat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.base.Example;
import com.demo.base.Page;

public class ChatMsgExample implements Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public ChatMsgExample() {
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
    
    public void setPage(Page page) {
        this.page=page;
    }
    
    public Page getPage() {
        return page;
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
        
        public Criteria andidIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }
        public Criteria andidIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }
        public Criteria andidEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andidNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andidGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andidGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andidLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andidLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andidIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andidNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andidBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andidNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }
        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }
        public Criteria andGroupIdEqualTo(Long value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Long value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Long value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Long value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Long> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Long> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Long value1, Long value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }
        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }
        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }
        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }
        public Criteria andsenderIsNull() {
            addCriterion("sender is null");
            return (Criteria) this;
        }
        public Criteria andsenderIsNotNull() {
            addCriterion("sender is not null");
            return (Criteria) this;
        }
        public Criteria andsenderEqualTo(String value) {
            addCriterion("sender =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andsenderNotEqualTo(String value) {
            addCriterion("sender <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andsenderGreaterThan(String value) {
            addCriterion("sender >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andsenderGreaterThanOrEqualTo(String value) {
            addCriterion("sender >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andsenderLessThan(String value) {
            addCriterion("sender <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andsenderLessThanOrEqualTo(String value) {
            addCriterion("sender <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andsenderIn(List<String> values) {
            addCriterion("sender in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andsenderNotIn(List<String> values) {
            addCriterion("sender not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andsenderBetween(String value1, String value2) {
            addCriterion("sender between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andsenderNotBetween(String value1, String value2) {
            addCriterion("sender not between", value1, value2, "sender");
            return (Criteria) this;
        }
        public Criteria andcontentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }
        public Criteria andcontentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }
        public Criteria andcontentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andcontentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andcontentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andcontentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andcontentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andcontentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andcontentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andcontentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andcontentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andcontentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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
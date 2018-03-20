package com.demo.chat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.base.Example;
import com.demo.base.Page;

public class ChatGroupRelExample implements Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public ChatGroupRelExample() {
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
        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }
        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }
        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }
        public Criteria andLastMsgIdIsNull() {
            addCriterion("last_msg_id is null");
            return (Criteria) this;
        }
        public Criteria andLastMsgIdIsNotNull() {
            addCriterion("last_msg_id is not null");
            return (Criteria) this;
        }
        public Criteria andLastMsgIdEqualTo(Long value) {
            addCriterion("last_msg_id =", value, "lastMsgId");
            return (Criteria) this;
        }

        public Criteria andLastMsgIdNotEqualTo(Long value) {
            addCriterion("last_msg_id <>", value, "lastMsgId");
            return (Criteria) this;
        }

        public Criteria andLastMsgIdGreaterThan(Long value) {
            addCriterion("last_msg_id >", value, "lastMsgId");
            return (Criteria) this;
        }

        public Criteria andLastMsgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("last_msg_id >=", value, "lastMsgId");
            return (Criteria) this;
        }

        public Criteria andLastMsgIdLessThan(Long value) {
            addCriterion("last_msg_id <", value, "lastMsgId");
            return (Criteria) this;
        }

        public Criteria andLastMsgIdLessThanOrEqualTo(Long value) {
            addCriterion("last_msg_id <=", value, "lastMsgId");
            return (Criteria) this;
        }

        public Criteria andLastMsgIdIn(List<Long> values) {
            addCriterion("last_msg_id in", values, "lastMsgId");
            return (Criteria) this;
        }

        public Criteria andLastMsgIdNotIn(List<Long> values) {
            addCriterion("last_msg_id not in", values, "lastMsgId");
            return (Criteria) this;
        }

        public Criteria andLastMsgIdBetween(Long value1, Long value2) {
            addCriterion("last_msg_id between", value1, value2, "lastMsgId");
            return (Criteria) this;
        }

        public Criteria andLastMsgIdNotBetween(Long value1, Long value2) {
            addCriterion("last_msg_id not between", value1, value2, "lastMsgId");
            return (Criteria) this;
        }
        public Criteria andUnreadNumIsNull() {
            addCriterion("unread_num is null");
            return (Criteria) this;
        }
        public Criteria andUnreadNumIsNotNull() {
            addCriterion("unread_num is not null");
            return (Criteria) this;
        }
        public Criteria andUnreadNumEqualTo(Integer value) {
            addCriterion("unread_num =", value, "unreadNum");
            return (Criteria) this;
        }

        public Criteria andUnreadNumNotEqualTo(Integer value) {
            addCriterion("unread_num <>", value, "unreadNum");
            return (Criteria) this;
        }

        public Criteria andUnreadNumGreaterThan(Integer value) {
            addCriterion("unread_num >", value, "unreadNum");
            return (Criteria) this;
        }

        public Criteria andUnreadNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("unread_num >=", value, "unreadNum");
            return (Criteria) this;
        }

        public Criteria andUnreadNumLessThan(Integer value) {
            addCriterion("unread_num <", value, "unreadNum");
            return (Criteria) this;
        }

        public Criteria andUnreadNumLessThanOrEqualTo(Integer value) {
            addCriterion("unread_num <=", value, "unreadNum");
            return (Criteria) this;
        }

        public Criteria andUnreadNumIn(List<Integer> values) {
            addCriterion("unread_num in", values, "unreadNum");
            return (Criteria) this;
        }

        public Criteria andUnreadNumNotIn(List<Integer> values) {
            addCriterion("unread_num not in", values, "unreadNum");
            return (Criteria) this;
        }

        public Criteria andUnreadNumBetween(Integer value1, Integer value2) {
            addCriterion("unread_num between", value1, value2, "unreadNum");
            return (Criteria) this;
        }

        public Criteria andUnreadNumNotBetween(Integer value1, Integer value2) {
            addCriterion("unread_num not between", value1, value2, "unreadNum");
            return (Criteria) this;
        }
        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }
        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }
        public Criteria andAppIdEqualTo(Integer value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(Integer value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(Integer value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(Integer value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(Integer value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<Integer> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<Integer> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(Integer value1, Integer value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(Integer value1, Integer value2) {
            addCriterion("app_id not between", value1, value2, "appId");
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
package com.szht.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNull() {
            addCriterion("usercode is null");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNotNull() {
            addCriterion("usercode is not null");
            return (Criteria) this;
        }

        public Criteria andUsercodeEqualTo(String value) {
            addCriterion("usercode =", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotEqualTo(String value) {
            addCriterion("usercode <>", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThan(String value) {
            addCriterion("usercode >", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThanOrEqualTo(String value) {
            addCriterion("usercode >=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThan(String value) {
            addCriterion("usercode <", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThanOrEqualTo(String value) {
            addCriterion("usercode <=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLike(String value) {
            addCriterion("usercode like", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotLike(String value) {
            addCriterion("usercode not like", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeIn(List<String> values) {
            addCriterion("usercode in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotIn(List<String> values) {
            addCriterion("usercode not in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeBetween(String value1, String value2) {
            addCriterion("usercode between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotBetween(String value1, String value2) {
            addCriterion("usercode not between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
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

        public Criteria andLogtimesIsNull() {
            addCriterion("logtimes is null");
            return (Criteria) this;
        }

        public Criteria andLogtimesIsNotNull() {
            addCriterion("logtimes is not null");
            return (Criteria) this;
        }

        public Criteria andLogtimesEqualTo(Integer value) {
            addCriterion("logtimes =", value, "logtimes");
            return (Criteria) this;
        }

        public Criteria andLogtimesNotEqualTo(Integer value) {
            addCriterion("logtimes <>", value, "logtimes");
            return (Criteria) this;
        }

        public Criteria andLogtimesGreaterThan(Integer value) {
            addCriterion("logtimes >", value, "logtimes");
            return (Criteria) this;
        }

        public Criteria andLogtimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("logtimes >=", value, "logtimes");
            return (Criteria) this;
        }

        public Criteria andLogtimesLessThan(Integer value) {
            addCriterion("logtimes <", value, "logtimes");
            return (Criteria) this;
        }

        public Criteria andLogtimesLessThanOrEqualTo(Integer value) {
            addCriterion("logtimes <=", value, "logtimes");
            return (Criteria) this;
        }

        public Criteria andLogtimesIn(List<Integer> values) {
            addCriterion("logtimes in", values, "logtimes");
            return (Criteria) this;
        }

        public Criteria andLogtimesNotIn(List<Integer> values) {
            addCriterion("logtimes not in", values, "logtimes");
            return (Criteria) this;
        }

        public Criteria andLogtimesBetween(Integer value1, Integer value2) {
            addCriterion("logtimes between", value1, value2, "logtimes");
            return (Criteria) this;
        }

        public Criteria andLogtimesNotBetween(Integer value1, Integer value2) {
            addCriterion("logtimes not between", value1, value2, "logtimes");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNull() {
            addCriterion("lasttime is null");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNotNull() {
            addCriterion("lasttime is not null");
            return (Criteria) this;
        }

        public Criteria andLasttimeEqualTo(Date value) {
            addCriterion("lasttime =", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotEqualTo(Date value) {
            addCriterion("lasttime <>", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThan(Date value) {
            addCriterion("lasttime >", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lasttime >=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThan(Date value) {
            addCriterion("lasttime <", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThanOrEqualTo(Date value) {
            addCriterion("lasttime <=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeIn(List<Date> values) {
            addCriterion("lasttime in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotIn(List<Date> values) {
            addCriterion("lasttime not in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeBetween(Date value1, Date value2) {
            addCriterion("lasttime between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotBetween(Date value1, Date value2) {
            addCriterion("lasttime not between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andPassword2IsNull() {
            addCriterion("password2 is null");
            return (Criteria) this;
        }

        public Criteria andPassword2IsNotNull() {
            addCriterion("password2 is not null");
            return (Criteria) this;
        }

        public Criteria andPassword2EqualTo(String value) {
            addCriterion("password2 =", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2NotEqualTo(String value) {
            addCriterion("password2 <>", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2GreaterThan(String value) {
            addCriterion("password2 >", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2GreaterThanOrEqualTo(String value) {
            addCriterion("password2 >=", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2LessThan(String value) {
            addCriterion("password2 <", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2LessThanOrEqualTo(String value) {
            addCriterion("password2 <=", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2Like(String value) {
            addCriterion("password2 like", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2NotLike(String value) {
            addCriterion("password2 not like", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2In(List<String> values) {
            addCriterion("password2 in", values, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2NotIn(List<String> values) {
            addCriterion("password2 not in", values, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2Between(String value1, String value2) {
            addCriterion("password2 between", value1, value2, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2NotBetween(String value1, String value2) {
            addCriterion("password2 not between", value1, value2, "password2");
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
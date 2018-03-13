package com.szht.model;

import java.util.ArrayList;
import java.util.List;

public class BcinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BcinfoExample() {
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

        public Criteria andDmmcIsNull() {
            addCriterion("dmmc is null");
            return (Criteria) this;
        }

        public Criteria andDmmcIsNotNull() {
            addCriterion("dmmc is not null");
            return (Criteria) this;
        }

        public Criteria andDmmcEqualTo(String value) {
            addCriterion("dmmc =", value, "dmmc");
            return (Criteria) this;
        }

        public Criteria andDmmcNotEqualTo(String value) {
            addCriterion("dmmc <>", value, "dmmc");
            return (Criteria) this;
        }

        public Criteria andDmmcGreaterThan(String value) {
            addCriterion("dmmc >", value, "dmmc");
            return (Criteria) this;
        }

        public Criteria andDmmcGreaterThanOrEqualTo(String value) {
            addCriterion("dmmc >=", value, "dmmc");
            return (Criteria) this;
        }

        public Criteria andDmmcLessThan(String value) {
            addCriterion("dmmc <", value, "dmmc");
            return (Criteria) this;
        }

        public Criteria andDmmcLessThanOrEqualTo(String value) {
            addCriterion("dmmc <=", value, "dmmc");
            return (Criteria) this;
        }

        public Criteria andDmmcLike(String value) {
            addCriterion("dmmc like", value, "dmmc");
            return (Criteria) this;
        }

        public Criteria andDmmcNotLike(String value) {
            addCriterion("dmmc not like", value, "dmmc");
            return (Criteria) this;
        }

        public Criteria andDmmcIn(List<String> values) {
            addCriterion("dmmc in", values, "dmmc");
            return (Criteria) this;
        }

        public Criteria andDmmcNotIn(List<String> values) {
            addCriterion("dmmc not in", values, "dmmc");
            return (Criteria) this;
        }

        public Criteria andDmmcBetween(String value1, String value2) {
            addCriterion("dmmc between", value1, value2, "dmmc");
            return (Criteria) this;
        }

        public Criteria andDmmcNotBetween(String value1, String value2) {
            addCriterion("dmmc not between", value1, value2, "dmmc");
            return (Criteria) this;
        }

        public Criteria andMubiaoIsNull() {
            addCriterion("mubiao is null");
            return (Criteria) this;
        }

        public Criteria andMubiaoIsNotNull() {
            addCriterion("mubiao is not null");
            return (Criteria) this;
        }

        public Criteria andMubiaoEqualTo(Integer value) {
            addCriterion("mubiao =", value, "mubiao");
            return (Criteria) this;
        }

        public Criteria andMubiaoNotEqualTo(Integer value) {
            addCriterion("mubiao <>", value, "mubiao");
            return (Criteria) this;
        }

        public Criteria andMubiaoGreaterThan(Integer value) {
            addCriterion("mubiao >", value, "mubiao");
            return (Criteria) this;
        }

        public Criteria andMubiaoGreaterThanOrEqualTo(Integer value) {
            addCriterion("mubiao >=", value, "mubiao");
            return (Criteria) this;
        }

        public Criteria andMubiaoLessThan(Integer value) {
            addCriterion("mubiao <", value, "mubiao");
            return (Criteria) this;
        }

        public Criteria andMubiaoLessThanOrEqualTo(Integer value) {
            addCriterion("mubiao <=", value, "mubiao");
            return (Criteria) this;
        }

        public Criteria andMubiaoIn(List<Integer> values) {
            addCriterion("mubiao in", values, "mubiao");
            return (Criteria) this;
        }

        public Criteria andMubiaoNotIn(List<Integer> values) {
            addCriterion("mubiao not in", values, "mubiao");
            return (Criteria) this;
        }

        public Criteria andMubiaoBetween(Integer value1, Integer value2) {
            addCriterion("mubiao between", value1, value2, "mubiao");
            return (Criteria) this;
        }

        public Criteria andMubiaoNotBetween(Integer value1, Integer value2) {
            addCriterion("mubiao not between", value1, value2, "mubiao");
            return (Criteria) this;
        }

        public Criteria andHlmcIsNull() {
            addCriterion("hlmc is null");
            return (Criteria) this;
        }

        public Criteria andHlmcIsNotNull() {
            addCriterion("hlmc is not null");
            return (Criteria) this;
        }

        public Criteria andHlmcEqualTo(String value) {
            addCriterion("hlmc =", value, "hlmc");
            return (Criteria) this;
        }

        public Criteria andHlmcNotEqualTo(String value) {
            addCriterion("hlmc <>", value, "hlmc");
            return (Criteria) this;
        }

        public Criteria andHlmcGreaterThan(String value) {
            addCriterion("hlmc >", value, "hlmc");
            return (Criteria) this;
        }

        public Criteria andHlmcGreaterThanOrEqualTo(String value) {
            addCriterion("hlmc >=", value, "hlmc");
            return (Criteria) this;
        }

        public Criteria andHlmcLessThan(String value) {
            addCriterion("hlmc <", value, "hlmc");
            return (Criteria) this;
        }

        public Criteria andHlmcLessThanOrEqualTo(String value) {
            addCriterion("hlmc <=", value, "hlmc");
            return (Criteria) this;
        }

        public Criteria andHlmcLike(String value) {
            addCriterion("hlmc like", value, "hlmc");
            return (Criteria) this;
        }

        public Criteria andHlmcNotLike(String value) {
            addCriterion("hlmc not like", value, "hlmc");
            return (Criteria) this;
        }

        public Criteria andHlmcIn(List<String> values) {
            addCriterion("hlmc in", values, "hlmc");
            return (Criteria) this;
        }

        public Criteria andHlmcNotIn(List<String> values) {
            addCriterion("hlmc not in", values, "hlmc");
            return (Criteria) this;
        }

        public Criteria andHlmcBetween(String value1, String value2) {
            addCriterion("hlmc between", value1, value2, "hlmc");
            return (Criteria) this;
        }

        public Criteria andHlmcNotBetween(String value1, String value2) {
            addCriterion("hlmc not between", value1, value2, "hlmc");
            return (Criteria) this;
        }

        public Criteria andDmlbIsNull() {
            addCriterion("dmlb is null");
            return (Criteria) this;
        }

        public Criteria andDmlbIsNotNull() {
            addCriterion("dmlb is not null");
            return (Criteria) this;
        }

        public Criteria andDmlbEqualTo(String value) {
            addCriterion("dmlb =", value, "dmlb");
            return (Criteria) this;
        }

        public Criteria andDmlbNotEqualTo(String value) {
            addCriterion("dmlb <>", value, "dmlb");
            return (Criteria) this;
        }

        public Criteria andDmlbGreaterThan(String value) {
            addCriterion("dmlb >", value, "dmlb");
            return (Criteria) this;
        }

        public Criteria andDmlbGreaterThanOrEqualTo(String value) {
            addCriterion("dmlb >=", value, "dmlb");
            return (Criteria) this;
        }

        public Criteria andDmlbLessThan(String value) {
            addCriterion("dmlb <", value, "dmlb");
            return (Criteria) this;
        }

        public Criteria andDmlbLessThanOrEqualTo(String value) {
            addCriterion("dmlb <=", value, "dmlb");
            return (Criteria) this;
        }

        public Criteria andDmlbLike(String value) {
            addCriterion("dmlb like", value, "dmlb");
            return (Criteria) this;
        }

        public Criteria andDmlbNotLike(String value) {
            addCriterion("dmlb not like", value, "dmlb");
            return (Criteria) this;
        }

        public Criteria andDmlbIn(List<String> values) {
            addCriterion("dmlb in", values, "dmlb");
            return (Criteria) this;
        }

        public Criteria andDmlbNotIn(List<String> values) {
            addCriterion("dmlb not in", values, "dmlb");
            return (Criteria) this;
        }

        public Criteria andDmlbBetween(String value1, String value2) {
            addCriterion("dmlb between", value1, value2, "dmlb");
            return (Criteria) this;
        }

        public Criteria andDmlbNotBetween(String value1, String value2) {
            addCriterion("dmlb not between", value1, value2, "dmlb");
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
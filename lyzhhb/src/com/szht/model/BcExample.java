package com.szht.model;

import java.util.ArrayList;
import java.util.List;

public class BcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BcExample() {
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

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andGmsyIsNull() {
            addCriterion("gmsy is null");
            return (Criteria) this;
        }

        public Criteria andGmsyIsNotNull() {
            addCriterion("gmsy is not null");
            return (Criteria) this;
        }

        public Criteria andGmsyEqualTo(Double value) {
            addCriterion("gmsy =", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyNotEqualTo(Double value) {
            addCriterion("gmsy <>", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyGreaterThan(Double value) {
            addCriterion("gmsy >", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyGreaterThanOrEqualTo(Double value) {
            addCriterion("gmsy >=", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyLessThan(Double value) {
            addCriterion("gmsy <", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyLessThanOrEqualTo(Double value) {
            addCriterion("gmsy <=", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyIn(List<Double> values) {
            addCriterion("gmsy in", values, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyNotIn(List<Double> values) {
            addCriterion("gmsy not in", values, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyBetween(Double value1, Double value2) {
            addCriterion("gmsy between", value1, value2, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyNotBetween(Double value1, Double value2) {
            addCriterion("gmsy not between", value1, value2, "gmsy");
            return (Criteria) this;
        }

        public Criteria andAdIsNull() {
            addCriterion("ad is null");
            return (Criteria) this;
        }

        public Criteria andAdIsNotNull() {
            addCriterion("ad is not null");
            return (Criteria) this;
        }

        public Criteria andAdEqualTo(Double value) {
            addCriterion("ad =", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotEqualTo(Double value) {
            addCriterion("ad <>", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdGreaterThan(Double value) {
            addCriterion("ad >", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdGreaterThanOrEqualTo(Double value) {
            addCriterion("ad >=", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLessThan(Double value) {
            addCriterion("ad <", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLessThanOrEqualTo(Double value) {
            addCriterion("ad <=", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdIn(List<Double> values) {
            addCriterion("ad in", values, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotIn(List<Double> values) {
            addCriterion("ad not in", values, "ad");
            return (Criteria) this;
        }

        public Criteria andAdBetween(Double value1, Double value2) {
            addCriterion("ad between", value1, value2, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotBetween(Double value1, Double value2) {
            addCriterion("ad not between", value1, value2, "ad");
            return (Criteria) this;
        }

        public Criteria andZlIsNull() {
            addCriterion("zl is null");
            return (Criteria) this;
        }

        public Criteria andZlIsNotNull() {
            addCriterion("zl is not null");
            return (Criteria) this;
        }

        public Criteria andZlEqualTo(Double value) {
            addCriterion("zl =", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotEqualTo(Double value) {
            addCriterion("zl <>", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlGreaterThan(Double value) {
            addCriterion("zl >", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlGreaterThanOrEqualTo(Double value) {
            addCriterion("zl >=", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlLessThan(Double value) {
            addCriterion("zl <", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlLessThanOrEqualTo(Double value) {
            addCriterion("zl <=", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlIn(List<Double> values) {
            addCriterion("zl in", values, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotIn(List<Double> values) {
            addCriterion("zl not in", values, "zl");
            return (Criteria) this;
        }

        public Criteria andZlBetween(Double value1, Double value2) {
            addCriterion("zl between", value1, value2, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotBetween(Double value1, Double value2) {
            addCriterion("zl not between", value1, value2, "zl");
            return (Criteria) this;
        }

        public Criteria andDmIsNull() {
            addCriterion("dm is null");
            return (Criteria) this;
        }

        public Criteria andDmIsNotNull() {
            addCriterion("dm is not null");
            return (Criteria) this;
        }

        public Criteria andDmEqualTo(String value) {
            addCriterion("dm =", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmNotEqualTo(String value) {
            addCriterion("dm <>", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmGreaterThan(String value) {
            addCriterion("dm >", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmGreaterThanOrEqualTo(String value) {
            addCriterion("dm >=", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmLessThan(String value) {
            addCriterion("dm <", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmLessThanOrEqualTo(String value) {
            addCriterion("dm <=", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmLike(String value) {
            addCriterion("dm like", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmNotLike(String value) {
            addCriterion("dm not like", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmIn(List<String> values) {
            addCriterion("dm in", values, "dm");
            return (Criteria) this;
        }

        public Criteria andDmNotIn(List<String> values) {
            addCriterion("dm not in", values, "dm");
            return (Criteria) this;
        }

        public Criteria andDmBetween(String value1, String value2) {
            addCriterion("dm between", value1, value2, "dm");
            return (Criteria) this;
        }

        public Criteria andDmNotBetween(String value1, String value2) {
            addCriterion("dm not between", value1, value2, "dm");
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
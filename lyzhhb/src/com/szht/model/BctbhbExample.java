package com.szht.model;

import java.util.ArrayList;
import java.util.List;

public class BctbhbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BctbhbExample() {
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

        public Criteria andGmsytbIsNull() {
            addCriterion("gmsytb is null");
            return (Criteria) this;
        }

        public Criteria andGmsytbIsNotNull() {
            addCriterion("gmsytb is not null");
            return (Criteria) this;
        }

        public Criteria andGmsytbEqualTo(Double value) {
            addCriterion("gmsytb =", value, "gmsytb");
            return (Criteria) this;
        }

        public Criteria andGmsytbNotEqualTo(Double value) {
            addCriterion("gmsytb <>", value, "gmsytb");
            return (Criteria) this;
        }

        public Criteria andGmsytbGreaterThan(Double value) {
            addCriterion("gmsytb >", value, "gmsytb");
            return (Criteria) this;
        }

        public Criteria andGmsytbGreaterThanOrEqualTo(Double value) {
            addCriterion("gmsytb >=", value, "gmsytb");
            return (Criteria) this;
        }

        public Criteria andGmsytbLessThan(Double value) {
            addCriterion("gmsytb <", value, "gmsytb");
            return (Criteria) this;
        }

        public Criteria andGmsytbLessThanOrEqualTo(Double value) {
            addCriterion("gmsytb <=", value, "gmsytb");
            return (Criteria) this;
        }

        public Criteria andGmsytbIn(List<Double> values) {
            addCriterion("gmsytb in", values, "gmsytb");
            return (Criteria) this;
        }

        public Criteria andGmsytbNotIn(List<Double> values) {
            addCriterion("gmsytb not in", values, "gmsytb");
            return (Criteria) this;
        }

        public Criteria andGmsytbBetween(Double value1, Double value2) {
            addCriterion("gmsytb between", value1, value2, "gmsytb");
            return (Criteria) this;
        }

        public Criteria andGmsytbNotBetween(Double value1, Double value2) {
            addCriterion("gmsytb not between", value1, value2, "gmsytb");
            return (Criteria) this;
        }

        public Criteria andAdtbIsNull() {
            addCriterion("adtb is null");
            return (Criteria) this;
        }

        public Criteria andAdtbIsNotNull() {
            addCriterion("adtb is not null");
            return (Criteria) this;
        }

        public Criteria andAdtbEqualTo(Double value) {
            addCriterion("adtb =", value, "adtb");
            return (Criteria) this;
        }

        public Criteria andAdtbNotEqualTo(Double value) {
            addCriterion("adtb <>", value, "adtb");
            return (Criteria) this;
        }

        public Criteria andAdtbGreaterThan(Double value) {
            addCriterion("adtb >", value, "adtb");
            return (Criteria) this;
        }

        public Criteria andAdtbGreaterThanOrEqualTo(Double value) {
            addCriterion("adtb >=", value, "adtb");
            return (Criteria) this;
        }

        public Criteria andAdtbLessThan(Double value) {
            addCriterion("adtb <", value, "adtb");
            return (Criteria) this;
        }

        public Criteria andAdtbLessThanOrEqualTo(Double value) {
            addCriterion("adtb <=", value, "adtb");
            return (Criteria) this;
        }

        public Criteria andAdtbIn(List<Double> values) {
            addCriterion("adtb in", values, "adtb");
            return (Criteria) this;
        }

        public Criteria andAdtbNotIn(List<Double> values) {
            addCriterion("adtb not in", values, "adtb");
            return (Criteria) this;
        }

        public Criteria andAdtbBetween(Double value1, Double value2) {
            addCriterion("adtb between", value1, value2, "adtb");
            return (Criteria) this;
        }

        public Criteria andAdtbNotBetween(Double value1, Double value2) {
            addCriterion("adtb not between", value1, value2, "adtb");
            return (Criteria) this;
        }

        public Criteria andZltbIsNull() {
            addCriterion("zltb is null");
            return (Criteria) this;
        }

        public Criteria andZltbIsNotNull() {
            addCriterion("zltb is not null");
            return (Criteria) this;
        }

        public Criteria andZltbEqualTo(Double value) {
            addCriterion("zltb =", value, "zltb");
            return (Criteria) this;
        }

        public Criteria andZltbNotEqualTo(Double value) {
            addCriterion("zltb <>", value, "zltb");
            return (Criteria) this;
        }

        public Criteria andZltbGreaterThan(Double value) {
            addCriterion("zltb >", value, "zltb");
            return (Criteria) this;
        }

        public Criteria andZltbGreaterThanOrEqualTo(Double value) {
            addCriterion("zltb >=", value, "zltb");
            return (Criteria) this;
        }

        public Criteria andZltbLessThan(Double value) {
            addCriterion("zltb <", value, "zltb");
            return (Criteria) this;
        }

        public Criteria andZltbLessThanOrEqualTo(Double value) {
            addCriterion("zltb <=", value, "zltb");
            return (Criteria) this;
        }

        public Criteria andZltbIn(List<Double> values) {
            addCriterion("zltb in", values, "zltb");
            return (Criteria) this;
        }

        public Criteria andZltbNotIn(List<Double> values) {
            addCriterion("zltb not in", values, "zltb");
            return (Criteria) this;
        }

        public Criteria andZltbBetween(Double value1, Double value2) {
            addCriterion("zltb between", value1, value2, "zltb");
            return (Criteria) this;
        }

        public Criteria andZltbNotBetween(Double value1, Double value2) {
            addCriterion("zltb not between", value1, value2, "zltb");
            return (Criteria) this;
        }

        public Criteria andGmsyhbIsNull() {
            addCriterion("gmsyhb is null");
            return (Criteria) this;
        }

        public Criteria andGmsyhbIsNotNull() {
            addCriterion("gmsyhb is not null");
            return (Criteria) this;
        }

        public Criteria andGmsyhbEqualTo(Double value) {
            addCriterion("gmsyhb =", value, "gmsyhb");
            return (Criteria) this;
        }

        public Criteria andGmsyhbNotEqualTo(Double value) {
            addCriterion("gmsyhb <>", value, "gmsyhb");
            return (Criteria) this;
        }

        public Criteria andGmsyhbGreaterThan(Double value) {
            addCriterion("gmsyhb >", value, "gmsyhb");
            return (Criteria) this;
        }

        public Criteria andGmsyhbGreaterThanOrEqualTo(Double value) {
            addCriterion("gmsyhb >=", value, "gmsyhb");
            return (Criteria) this;
        }

        public Criteria andGmsyhbLessThan(Double value) {
            addCriterion("gmsyhb <", value, "gmsyhb");
            return (Criteria) this;
        }

        public Criteria andGmsyhbLessThanOrEqualTo(Double value) {
            addCriterion("gmsyhb <=", value, "gmsyhb");
            return (Criteria) this;
        }

        public Criteria andGmsyhbIn(List<Double> values) {
            addCriterion("gmsyhb in", values, "gmsyhb");
            return (Criteria) this;
        }

        public Criteria andGmsyhbNotIn(List<Double> values) {
            addCriterion("gmsyhb not in", values, "gmsyhb");
            return (Criteria) this;
        }

        public Criteria andGmsyhbBetween(Double value1, Double value2) {
            addCriterion("gmsyhb between", value1, value2, "gmsyhb");
            return (Criteria) this;
        }

        public Criteria andGmsyhbNotBetween(Double value1, Double value2) {
            addCriterion("gmsyhb not between", value1, value2, "gmsyhb");
            return (Criteria) this;
        }

        public Criteria andAdhbIsNull() {
            addCriterion("adhb is null");
            return (Criteria) this;
        }

        public Criteria andAdhbIsNotNull() {
            addCriterion("adhb is not null");
            return (Criteria) this;
        }

        public Criteria andAdhbEqualTo(Double value) {
            addCriterion("adhb =", value, "adhb");
            return (Criteria) this;
        }

        public Criteria andAdhbNotEqualTo(Double value) {
            addCriterion("adhb <>", value, "adhb");
            return (Criteria) this;
        }

        public Criteria andAdhbGreaterThan(Double value) {
            addCriterion("adhb >", value, "adhb");
            return (Criteria) this;
        }

        public Criteria andAdhbGreaterThanOrEqualTo(Double value) {
            addCriterion("adhb >=", value, "adhb");
            return (Criteria) this;
        }

        public Criteria andAdhbLessThan(Double value) {
            addCriterion("adhb <", value, "adhb");
            return (Criteria) this;
        }

        public Criteria andAdhbLessThanOrEqualTo(Double value) {
            addCriterion("adhb <=", value, "adhb");
            return (Criteria) this;
        }

        public Criteria andAdhbIn(List<Double> values) {
            addCriterion("adhb in", values, "adhb");
            return (Criteria) this;
        }

        public Criteria andAdhbNotIn(List<Double> values) {
            addCriterion("adhb not in", values, "adhb");
            return (Criteria) this;
        }

        public Criteria andAdhbBetween(Double value1, Double value2) {
            addCriterion("adhb between", value1, value2, "adhb");
            return (Criteria) this;
        }

        public Criteria andAdhbNotBetween(Double value1, Double value2) {
            addCriterion("adhb not between", value1, value2, "adhb");
            return (Criteria) this;
        }

        public Criteria andZlhbIsNull() {
            addCriterion("zlhb is null");
            return (Criteria) this;
        }

        public Criteria andZlhbIsNotNull() {
            addCriterion("zlhb is not null");
            return (Criteria) this;
        }

        public Criteria andZlhbEqualTo(Double value) {
            addCriterion("zlhb =", value, "zlhb");
            return (Criteria) this;
        }

        public Criteria andZlhbNotEqualTo(Double value) {
            addCriterion("zlhb <>", value, "zlhb");
            return (Criteria) this;
        }

        public Criteria andZlhbGreaterThan(Double value) {
            addCriterion("zlhb >", value, "zlhb");
            return (Criteria) this;
        }

        public Criteria andZlhbGreaterThanOrEqualTo(Double value) {
            addCriterion("zlhb >=", value, "zlhb");
            return (Criteria) this;
        }

        public Criteria andZlhbLessThan(Double value) {
            addCriterion("zlhb <", value, "zlhb");
            return (Criteria) this;
        }

        public Criteria andZlhbLessThanOrEqualTo(Double value) {
            addCriterion("zlhb <=", value, "zlhb");
            return (Criteria) this;
        }

        public Criteria andZlhbIn(List<Double> values) {
            addCriterion("zlhb in", values, "zlhb");
            return (Criteria) this;
        }

        public Criteria andZlhbNotIn(List<Double> values) {
            addCriterion("zlhb not in", values, "zlhb");
            return (Criteria) this;
        }

        public Criteria andZlhbBetween(Double value1, Double value2) {
            addCriterion("zlhb between", value1, value2, "zlhb");
            return (Criteria) this;
        }

        public Criteria andZlhbNotBetween(Double value1, Double value2) {
            addCriterion("zlhb not between", value1, value2, "zlhb");
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
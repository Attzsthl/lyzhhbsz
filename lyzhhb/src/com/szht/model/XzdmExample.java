package com.szht.model;

import java.util.ArrayList;
import java.util.List;

public class XzdmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XzdmExample() {
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

        public Criteria andSeasonIsNull() {
            addCriterion("season is null");
            return (Criteria) this;
        }

        public Criteria andSeasonIsNotNull() {
            addCriterion("season is not null");
            return (Criteria) this;
        }

        public Criteria andSeasonEqualTo(Integer value) {
            addCriterion("season =", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotEqualTo(Integer value) {
            addCriterion("season <>", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonGreaterThan(Integer value) {
            addCriterion("season >", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonGreaterThanOrEqualTo(Integer value) {
            addCriterion("season >=", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLessThan(Integer value) {
            addCriterion("season <", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLessThanOrEqualTo(Integer value) {
            addCriterion("season <=", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonIn(List<Integer> values) {
            addCriterion("season in", values, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotIn(List<Integer> values) {
            addCriterion("season not in", values, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonBetween(Integer value1, Integer value2) {
            addCriterion("season between", value1, value2, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotBetween(Integer value1, Integer value2) {
            addCriterion("season not between", value1, value2, "season");
            return (Criteria) this;
        }

        public Criteria andZhenquIsNull() {
            addCriterion("zhenqu is null");
            return (Criteria) this;
        }

        public Criteria andZhenquIsNotNull() {
            addCriterion("zhenqu is not null");
            return (Criteria) this;
        }

        public Criteria andZhenquEqualTo(String value) {
            addCriterion("zhenqu =", value, "zhenqu");
            return (Criteria) this;
        }

        public Criteria andZhenquNotEqualTo(String value) {
            addCriterion("zhenqu <>", value, "zhenqu");
            return (Criteria) this;
        }

        public Criteria andZhenquGreaterThan(String value) {
            addCriterion("zhenqu >", value, "zhenqu");
            return (Criteria) this;
        }

        public Criteria andZhenquGreaterThanOrEqualTo(String value) {
            addCriterion("zhenqu >=", value, "zhenqu");
            return (Criteria) this;
        }

        public Criteria andZhenquLessThan(String value) {
            addCriterion("zhenqu <", value, "zhenqu");
            return (Criteria) this;
        }

        public Criteria andZhenquLessThanOrEqualTo(String value) {
            addCriterion("zhenqu <=", value, "zhenqu");
            return (Criteria) this;
        }

        public Criteria andZhenquLike(String value) {
            addCriterion("zhenqu like", value, "zhenqu");
            return (Criteria) this;
        }

        public Criteria andZhenquNotLike(String value) {
            addCriterion("zhenqu not like", value, "zhenqu");
            return (Criteria) this;
        }

        public Criteria andZhenquIn(List<String> values) {
            addCriterion("zhenqu in", values, "zhenqu");
            return (Criteria) this;
        }

        public Criteria andZhenquNotIn(List<String> values) {
            addCriterion("zhenqu not in", values, "zhenqu");
            return (Criteria) this;
        }

        public Criteria andZhenquBetween(String value1, String value2) {
            addCriterion("zhenqu between", value1, value2, "zhenqu");
            return (Criteria) this;
        }

        public Criteria andZhenquNotBetween(String value1, String value2) {
            addCriterion("zhenqu not between", value1, value2, "zhenqu");
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

        public Criteria andRjyIsNull() {
            addCriterion("rjy is null");
            return (Criteria) this;
        }

        public Criteria andRjyIsNotNull() {
            addCriterion("rjy is not null");
            return (Criteria) this;
        }

        public Criteria andRjyEqualTo(Double value) {
            addCriterion("rjy =", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyNotEqualTo(Double value) {
            addCriterion("rjy <>", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyGreaterThan(Double value) {
            addCriterion("rjy >", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyGreaterThanOrEqualTo(Double value) {
            addCriterion("rjy >=", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyLessThan(Double value) {
            addCriterion("rjy <", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyLessThanOrEqualTo(Double value) {
            addCriterion("rjy <=", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyIn(List<Double> values) {
            addCriterion("rjy in", values, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyNotIn(List<Double> values) {
            addCriterion("rjy not in", values, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyBetween(Double value1, Double value2) {
            addCriterion("rjy between", value1, value2, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyNotBetween(Double value1, Double value2) {
            addCriterion("rjy not between", value1, value2, "rjy");
            return (Criteria) this;
        }

        public Criteria andDabiaoIsNull() {
            addCriterion("dabiao is null");
            return (Criteria) this;
        }

        public Criteria andDabiaoIsNotNull() {
            addCriterion("dabiao is not null");
            return (Criteria) this;
        }

        public Criteria andDabiaoEqualTo(String value) {
            addCriterion("dabiao =", value, "dabiao");
            return (Criteria) this;
        }

        public Criteria andDabiaoNotEqualTo(String value) {
            addCriterion("dabiao <>", value, "dabiao");
            return (Criteria) this;
        }

        public Criteria andDabiaoGreaterThan(String value) {
            addCriterion("dabiao >", value, "dabiao");
            return (Criteria) this;
        }

        public Criteria andDabiaoGreaterThanOrEqualTo(String value) {
            addCriterion("dabiao >=", value, "dabiao");
            return (Criteria) this;
        }

        public Criteria andDabiaoLessThan(String value) {
            addCriterion("dabiao <", value, "dabiao");
            return (Criteria) this;
        }

        public Criteria andDabiaoLessThanOrEqualTo(String value) {
            addCriterion("dabiao <=", value, "dabiao");
            return (Criteria) this;
        }

        public Criteria andDabiaoLike(String value) {
            addCriterion("dabiao like", value, "dabiao");
            return (Criteria) this;
        }

        public Criteria andDabiaoNotLike(String value) {
            addCriterion("dabiao not like", value, "dabiao");
            return (Criteria) this;
        }

        public Criteria andDabiaoIn(List<String> values) {
            addCriterion("dabiao in", values, "dabiao");
            return (Criteria) this;
        }

        public Criteria andDabiaoNotIn(List<String> values) {
            addCriterion("dabiao not in", values, "dabiao");
            return (Criteria) this;
        }

        public Criteria andDabiaoBetween(String value1, String value2) {
            addCriterion("dabiao between", value1, value2, "dabiao");
            return (Criteria) this;
        }

        public Criteria andDabiaoNotBetween(String value1, String value2) {
            addCriterion("dabiao not between", value1, value2, "dabiao");
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
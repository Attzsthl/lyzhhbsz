package com.szht.model;

import java.util.ArrayList;
import java.util.List;

public class SiteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SiteExample() {
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

        public Criteria andAqiIsNull() {
            addCriterion("aqi is null");
            return (Criteria) this;
        }

        public Criteria andAqiIsNotNull() {
            addCriterion("aqi is not null");
            return (Criteria) this;
        }

        public Criteria andAqiEqualTo(String value) {
            addCriterion("aqi =", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiNotEqualTo(String value) {
            addCriterion("aqi <>", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiGreaterThan(String value) {
            addCriterion("aqi >", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiGreaterThanOrEqualTo(String value) {
            addCriterion("aqi >=", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiLessThan(String value) {
            addCriterion("aqi <", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiLessThanOrEqualTo(String value) {
            addCriterion("aqi <=", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiLike(String value) {
            addCriterion("aqi like", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiNotLike(String value) {
            addCriterion("aqi not like", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiIn(List<String> values) {
            addCriterion("aqi in", values, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiNotIn(List<String> values) {
            addCriterion("aqi not in", values, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiBetween(String value1, String value2) {
            addCriterion("aqi between", value1, value2, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiNotBetween(String value1, String value2) {
            addCriterion("aqi not between", value1, value2, "aqi");
            return (Criteria) this;
        }

        public Criteria andCoIsNull() {
            addCriterion("co is null");
            return (Criteria) this;
        }

        public Criteria andCoIsNotNull() {
            addCriterion("co is not null");
            return (Criteria) this;
        }

        public Criteria andCoEqualTo(String value) {
            addCriterion("co =", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotEqualTo(String value) {
            addCriterion("co <>", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoGreaterThan(String value) {
            addCriterion("co >", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoGreaterThanOrEqualTo(String value) {
            addCriterion("co >=", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoLessThan(String value) {
            addCriterion("co <", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoLessThanOrEqualTo(String value) {
            addCriterion("co <=", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoLike(String value) {
            addCriterion("co like", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotLike(String value) {
            addCriterion("co not like", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoIn(List<String> values) {
            addCriterion("co in", values, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotIn(List<String> values) {
            addCriterion("co not in", values, "co");
            return (Criteria) this;
        }

        public Criteria andCoBetween(String value1, String value2) {
            addCriterion("co between", value1, value2, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotBetween(String value1, String value2) {
            addCriterion("co not between", value1, value2, "co");
            return (Criteria) this;
        }

        public Criteria andCtIsNull() {
            addCriterion("ct is null");
            return (Criteria) this;
        }

        public Criteria andCtIsNotNull() {
            addCriterion("ct is not null");
            return (Criteria) this;
        }

        public Criteria andCtEqualTo(String value) {
            addCriterion("ct =", value, "ct");
            return (Criteria) this;
        }

        public Criteria andCtNotEqualTo(String value) {
            addCriterion("ct <>", value, "ct");
            return (Criteria) this;
        }

        public Criteria andCtGreaterThan(String value) {
            addCriterion("ct >", value, "ct");
            return (Criteria) this;
        }

        public Criteria andCtGreaterThanOrEqualTo(String value) {
            addCriterion("ct >=", value, "ct");
            return (Criteria) this;
        }

        public Criteria andCtLessThan(String value) {
            addCriterion("ct <", value, "ct");
            return (Criteria) this;
        }

        public Criteria andCtLessThanOrEqualTo(String value) {
            addCriterion("ct <=", value, "ct");
            return (Criteria) this;
        }

        public Criteria andCtLike(String value) {
            addCriterion("ct like", value, "ct");
            return (Criteria) this;
        }

        public Criteria andCtNotLike(String value) {
            addCriterion("ct not like", value, "ct");
            return (Criteria) this;
        }

        public Criteria andCtIn(List<String> values) {
            addCriterion("ct in", values, "ct");
            return (Criteria) this;
        }

        public Criteria andCtNotIn(List<String> values) {
            addCriterion("ct not in", values, "ct");
            return (Criteria) this;
        }

        public Criteria andCtBetween(String value1, String value2) {
            addCriterion("ct between", value1, value2, "ct");
            return (Criteria) this;
        }

        public Criteria andCtNotBetween(String value1, String value2) {
            addCriterion("ct not between", value1, value2, "ct");
            return (Criteria) this;
        }

        public Criteria andNo2IsNull() {
            addCriterion("no2 is null");
            return (Criteria) this;
        }

        public Criteria andNo2IsNotNull() {
            addCriterion("no2 is not null");
            return (Criteria) this;
        }

        public Criteria andNo2EqualTo(String value) {
            addCriterion("no2 =", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotEqualTo(String value) {
            addCriterion("no2 <>", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2GreaterThan(String value) {
            addCriterion("no2 >", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2GreaterThanOrEqualTo(String value) {
            addCriterion("no2 >=", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2LessThan(String value) {
            addCriterion("no2 <", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2LessThanOrEqualTo(String value) {
            addCriterion("no2 <=", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2Like(String value) {
            addCriterion("no2 like", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotLike(String value) {
            addCriterion("no2 not like", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2In(List<String> values) {
            addCriterion("no2 in", values, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotIn(List<String> values) {
            addCriterion("no2 not in", values, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2Between(String value1, String value2) {
            addCriterion("no2 between", value1, value2, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotBetween(String value1, String value2) {
            addCriterion("no2 not between", value1, value2, "no2");
            return (Criteria) this;
        }

        public Criteria andO3IsNull() {
            addCriterion("o3 is null");
            return (Criteria) this;
        }

        public Criteria andO3IsNotNull() {
            addCriterion("o3 is not null");
            return (Criteria) this;
        }

        public Criteria andO3EqualTo(String value) {
            addCriterion("o3 =", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3NotEqualTo(String value) {
            addCriterion("o3 <>", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3GreaterThan(String value) {
            addCriterion("o3 >", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3GreaterThanOrEqualTo(String value) {
            addCriterion("o3 >=", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3LessThan(String value) {
            addCriterion("o3 <", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3LessThanOrEqualTo(String value) {
            addCriterion("o3 <=", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3Like(String value) {
            addCriterion("o3 like", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3NotLike(String value) {
            addCriterion("o3 not like", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3In(List<String> values) {
            addCriterion("o3 in", values, "o3");
            return (Criteria) this;
        }

        public Criteria andO3NotIn(List<String> values) {
            addCriterion("o3 not in", values, "o3");
            return (Criteria) this;
        }

        public Criteria andO3Between(String value1, String value2) {
            addCriterion("o3 between", value1, value2, "o3");
            return (Criteria) this;
        }

        public Criteria andO3NotBetween(String value1, String value2) {
            addCriterion("o3 not between", value1, value2, "o3");
            return (Criteria) this;
        }

        public Criteria andO38hIsNull() {
            addCriterion("o3_8h is null");
            return (Criteria) this;
        }

        public Criteria andO38hIsNotNull() {
            addCriterion("o3_8h is not null");
            return (Criteria) this;
        }

        public Criteria andO38hEqualTo(String value) {
            addCriterion("o3_8h =", value, "o38h");
            return (Criteria) this;
        }

        public Criteria andO38hNotEqualTo(String value) {
            addCriterion("o3_8h <>", value, "o38h");
            return (Criteria) this;
        }

        public Criteria andO38hGreaterThan(String value) {
            addCriterion("o3_8h >", value, "o38h");
            return (Criteria) this;
        }

        public Criteria andO38hGreaterThanOrEqualTo(String value) {
            addCriterion("o3_8h >=", value, "o38h");
            return (Criteria) this;
        }

        public Criteria andO38hLessThan(String value) {
            addCriterion("o3_8h <", value, "o38h");
            return (Criteria) this;
        }

        public Criteria andO38hLessThanOrEqualTo(String value) {
            addCriterion("o3_8h <=", value, "o38h");
            return (Criteria) this;
        }

        public Criteria andO38hLike(String value) {
            addCriterion("o3_8h like", value, "o38h");
            return (Criteria) this;
        }

        public Criteria andO38hNotLike(String value) {
            addCriterion("o3_8h not like", value, "o38h");
            return (Criteria) this;
        }

        public Criteria andO38hIn(List<String> values) {
            addCriterion("o3_8h in", values, "o38h");
            return (Criteria) this;
        }

        public Criteria andO38hNotIn(List<String> values) {
            addCriterion("o3_8h not in", values, "o38h");
            return (Criteria) this;
        }

        public Criteria andO38hBetween(String value1, String value2) {
            addCriterion("o3_8h between", value1, value2, "o38h");
            return (Criteria) this;
        }

        public Criteria andO38hNotBetween(String value1, String value2) {
            addCriterion("o3_8h not between", value1, value2, "o38h");
            return (Criteria) this;
        }

        public Criteria andPm10IsNull() {
            addCriterion("pm10 is null");
            return (Criteria) this;
        }

        public Criteria andPm10IsNotNull() {
            addCriterion("pm10 is not null");
            return (Criteria) this;
        }

        public Criteria andPm10EqualTo(String value) {
            addCriterion("pm10 =", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotEqualTo(String value) {
            addCriterion("pm10 <>", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10GreaterThan(String value) {
            addCriterion("pm10 >", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10GreaterThanOrEqualTo(String value) {
            addCriterion("pm10 >=", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10LessThan(String value) {
            addCriterion("pm10 <", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10LessThanOrEqualTo(String value) {
            addCriterion("pm10 <=", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10Like(String value) {
            addCriterion("pm10 like", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotLike(String value) {
            addCriterion("pm10 not like", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10In(List<String> values) {
            addCriterion("pm10 in", values, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotIn(List<String> values) {
            addCriterion("pm10 not in", values, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10Between(String value1, String value2) {
            addCriterion("pm10 between", value1, value2, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotBetween(String value1, String value2) {
            addCriterion("pm10 not between", value1, value2, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm25IsNull() {
            addCriterion("pm2_5 is null");
            return (Criteria) this;
        }

        public Criteria andPm25IsNotNull() {
            addCriterion("pm2_5 is not null");
            return (Criteria) this;
        }

        public Criteria andPm25EqualTo(String value) {
            addCriterion("pm2_5 =", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotEqualTo(String value) {
            addCriterion("pm2_5 <>", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25GreaterThan(String value) {
            addCriterion("pm2_5 >", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25GreaterThanOrEqualTo(String value) {
            addCriterion("pm2_5 >=", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25LessThan(String value) {
            addCriterion("pm2_5 <", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25LessThanOrEqualTo(String value) {
            addCriterion("pm2_5 <=", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25Like(String value) {
            addCriterion("pm2_5 like", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotLike(String value) {
            addCriterion("pm2_5 not like", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25In(List<String> values) {
            addCriterion("pm2_5 in", values, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotIn(List<String> values) {
            addCriterion("pm2_5 not in", values, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25Between(String value1, String value2) {
            addCriterion("pm2_5 between", value1, value2, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotBetween(String value1, String value2) {
            addCriterion("pm2_5 not between", value1, value2, "pm25");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantIsNull() {
            addCriterion("primary_pollutant is null");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantIsNotNull() {
            addCriterion("primary_pollutant is not null");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantEqualTo(String value) {
            addCriterion("primary_pollutant =", value, "primaryPollutant");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantNotEqualTo(String value) {
            addCriterion("primary_pollutant <>", value, "primaryPollutant");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantGreaterThan(String value) {
            addCriterion("primary_pollutant >", value, "primaryPollutant");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantGreaterThanOrEqualTo(String value) {
            addCriterion("primary_pollutant >=", value, "primaryPollutant");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantLessThan(String value) {
            addCriterion("primary_pollutant <", value, "primaryPollutant");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantLessThanOrEqualTo(String value) {
            addCriterion("primary_pollutant <=", value, "primaryPollutant");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantLike(String value) {
            addCriterion("primary_pollutant like", value, "primaryPollutant");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantNotLike(String value) {
            addCriterion("primary_pollutant not like", value, "primaryPollutant");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantIn(List<String> values) {
            addCriterion("primary_pollutant in", values, "primaryPollutant");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantNotIn(List<String> values) {
            addCriterion("primary_pollutant not in", values, "primaryPollutant");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantBetween(String value1, String value2) {
            addCriterion("primary_pollutant between", value1, value2, "primaryPollutant");
            return (Criteria) this;
        }

        public Criteria andPrimaryPollutantNotBetween(String value1, String value2) {
            addCriterion("primary_pollutant not between", value1, value2, "primaryPollutant");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(String value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(String value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(String value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(String value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(String value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(String value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLike(String value) {
            addCriterion("quality like", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotLike(String value) {
            addCriterion("quality not like", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<String> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<String> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(String value1, String value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(String value1, String value2) {
            addCriterion("quality not between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNull() {
            addCriterion("site_name is null");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNotNull() {
            addCriterion("site_name is not null");
            return (Criteria) this;
        }

        public Criteria andSiteNameEqualTo(String value) {
            addCriterion("site_name =", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotEqualTo(String value) {
            addCriterion("site_name <>", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThan(String value) {
            addCriterion("site_name >", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThanOrEqualTo(String value) {
            addCriterion("site_name >=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThan(String value) {
            addCriterion("site_name <", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThanOrEqualTo(String value) {
            addCriterion("site_name <=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLike(String value) {
            addCriterion("site_name like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotLike(String value) {
            addCriterion("site_name not like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameIn(List<String> values) {
            addCriterion("site_name in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotIn(List<String> values) {
            addCriterion("site_name not in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameBetween(String value1, String value2) {
            addCriterion("site_name between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotBetween(String value1, String value2) {
            addCriterion("site_name not between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andSo2IsNull() {
            addCriterion("so2 is null");
            return (Criteria) this;
        }

        public Criteria andSo2IsNotNull() {
            addCriterion("so2 is not null");
            return (Criteria) this;
        }

        public Criteria andSo2EqualTo(String value) {
            addCriterion("so2 =", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2NotEqualTo(String value) {
            addCriterion("so2 <>", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2GreaterThan(String value) {
            addCriterion("so2 >", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2GreaterThanOrEqualTo(String value) {
            addCriterion("so2 >=", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2LessThan(String value) {
            addCriterion("so2 <", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2LessThanOrEqualTo(String value) {
            addCriterion("so2 <=", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2Like(String value) {
            addCriterion("so2 like", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2NotLike(String value) {
            addCriterion("so2 not like", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2In(List<String> values) {
            addCriterion("so2 in", values, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2NotIn(List<String> values) {
            addCriterion("so2 not in", values, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2Between(String value1, String value2) {
            addCriterion("so2 between", value1, value2, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2NotBetween(String value1, String value2) {
            addCriterion("so2 not between", value1, value2, "so2");
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
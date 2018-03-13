package com.szht.model;

import java.util.ArrayList;
import java.util.List;

public class JcdmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JcdmExample() {
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

        public Criteria andAndanIsNull() {
            addCriterion("andan is null");
            return (Criteria) this;
        }

        public Criteria andAndanIsNotNull() {
            addCriterion("andan is not null");
            return (Criteria) this;
        }

        public Criteria andAndanEqualTo(String value) {
            addCriterion("andan =", value, "andan");
            return (Criteria) this;
        }

        public Criteria andAndanNotEqualTo(String value) {
            addCriterion("andan <>", value, "andan");
            return (Criteria) this;
        }

        public Criteria andAndanGreaterThan(String value) {
            addCriterion("andan >", value, "andan");
            return (Criteria) this;
        }

        public Criteria andAndanGreaterThanOrEqualTo(String value) {
            addCriterion("andan >=", value, "andan");
            return (Criteria) this;
        }

        public Criteria andAndanLessThan(String value) {
            addCriterion("andan <", value, "andan");
            return (Criteria) this;
        }

        public Criteria andAndanLessThanOrEqualTo(String value) {
            addCriterion("andan <=", value, "andan");
            return (Criteria) this;
        }

        public Criteria andAndanLike(String value) {
            addCriterion("andan like", value, "andan");
            return (Criteria) this;
        }

        public Criteria andAndanNotLike(String value) {
            addCriterion("andan not like", value, "andan");
            return (Criteria) this;
        }

        public Criteria andAndanIn(List<String> values) {
            addCriterion("andan in", values, "andan");
            return (Criteria) this;
        }

        public Criteria andAndanNotIn(List<String> values) {
            addCriterion("andan not in", values, "andan");
            return (Criteria) this;
        }

        public Criteria andAndanBetween(String value1, String value2) {
            addCriterion("andan between", value1, value2, "andan");
            return (Criteria) this;
        }

        public Criteria andAndanNotBetween(String value1, String value2) {
            addCriterion("andan not between", value1, value2, "andan");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDiandaolvIsNull() {
            addCriterion("diandaolv is null");
            return (Criteria) this;
        }

        public Criteria andDiandaolvIsNotNull() {
            addCriterion("diandaolv is not null");
            return (Criteria) this;
        }

        public Criteria andDiandaolvEqualTo(String value) {
            addCriterion("diandaolv =", value, "diandaolv");
            return (Criteria) this;
        }

        public Criteria andDiandaolvNotEqualTo(String value) {
            addCriterion("diandaolv <>", value, "diandaolv");
            return (Criteria) this;
        }

        public Criteria andDiandaolvGreaterThan(String value) {
            addCriterion("diandaolv >", value, "diandaolv");
            return (Criteria) this;
        }

        public Criteria andDiandaolvGreaterThanOrEqualTo(String value) {
            addCriterion("diandaolv >=", value, "diandaolv");
            return (Criteria) this;
        }

        public Criteria andDiandaolvLessThan(String value) {
            addCriterion("diandaolv <", value, "diandaolv");
            return (Criteria) this;
        }

        public Criteria andDiandaolvLessThanOrEqualTo(String value) {
            addCriterion("diandaolv <=", value, "diandaolv");
            return (Criteria) this;
        }

        public Criteria andDiandaolvLike(String value) {
            addCriterion("diandaolv like", value, "diandaolv");
            return (Criteria) this;
        }

        public Criteria andDiandaolvNotLike(String value) {
            addCriterion("diandaolv not like", value, "diandaolv");
            return (Criteria) this;
        }

        public Criteria andDiandaolvIn(List<String> values) {
            addCriterion("diandaolv in", values, "diandaolv");
            return (Criteria) this;
        }

        public Criteria andDiandaolvNotIn(List<String> values) {
            addCriterion("diandaolv not in", values, "diandaolv");
            return (Criteria) this;
        }

        public Criteria andDiandaolvBetween(String value1, String value2) {
            addCriterion("diandaolv between", value1, value2, "diandaolv");
            return (Criteria) this;
        }

        public Criteria andDiandaolvNotBetween(String value1, String value2) {
            addCriterion("diandaolv not between", value1, value2, "diandaolv");
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

        public Criteria andFlzaIsNull() {
            addCriterion("flza is null");
            return (Criteria) this;
        }

        public Criteria andFlzaIsNotNull() {
            addCriterion("flza is not null");
            return (Criteria) this;
        }

        public Criteria andFlzaEqualTo(String value) {
            addCriterion("flza =", value, "flza");
            return (Criteria) this;
        }

        public Criteria andFlzaNotEqualTo(String value) {
            addCriterion("flza <>", value, "flza");
            return (Criteria) this;
        }

        public Criteria andFlzaGreaterThan(String value) {
            addCriterion("flza >", value, "flza");
            return (Criteria) this;
        }

        public Criteria andFlzaGreaterThanOrEqualTo(String value) {
            addCriterion("flza >=", value, "flza");
            return (Criteria) this;
        }

        public Criteria andFlzaLessThan(String value) {
            addCriterion("flza <", value, "flza");
            return (Criteria) this;
        }

        public Criteria andFlzaLessThanOrEqualTo(String value) {
            addCriterion("flza <=", value, "flza");
            return (Criteria) this;
        }

        public Criteria andFlzaLike(String value) {
            addCriterion("flza like", value, "flza");
            return (Criteria) this;
        }

        public Criteria andFlzaNotLike(String value) {
            addCriterion("flza not like", value, "flza");
            return (Criteria) this;
        }

        public Criteria andFlzaIn(List<String> values) {
            addCriterion("flza in", values, "flza");
            return (Criteria) this;
        }

        public Criteria andFlzaNotIn(List<String> values) {
            addCriterion("flza not in", values, "flza");
            return (Criteria) this;
        }

        public Criteria andFlzaBetween(String value1, String value2) {
            addCriterion("flza between", value1, value2, "flza");
            return (Criteria) this;
        }

        public Criteria andFlzaNotBetween(String value1, String value2) {
            addCriterion("flza not between", value1, value2, "flza");
            return (Criteria) this;
        }

        public Criteria andFuhuawuIsNull() {
            addCriterion("fuhuawu is null");
            return (Criteria) this;
        }

        public Criteria andFuhuawuIsNotNull() {
            addCriterion("fuhuawu is not null");
            return (Criteria) this;
        }

        public Criteria andFuhuawuEqualTo(String value) {
            addCriterion("fuhuawu =", value, "fuhuawu");
            return (Criteria) this;
        }

        public Criteria andFuhuawuNotEqualTo(String value) {
            addCriterion("fuhuawu <>", value, "fuhuawu");
            return (Criteria) this;
        }

        public Criteria andFuhuawuGreaterThan(String value) {
            addCriterion("fuhuawu >", value, "fuhuawu");
            return (Criteria) this;
        }

        public Criteria andFuhuawuGreaterThanOrEqualTo(String value) {
            addCriterion("fuhuawu >=", value, "fuhuawu");
            return (Criteria) this;
        }

        public Criteria andFuhuawuLessThan(String value) {
            addCriterion("fuhuawu <", value, "fuhuawu");
            return (Criteria) this;
        }

        public Criteria andFuhuawuLessThanOrEqualTo(String value) {
            addCriterion("fuhuawu <=", value, "fuhuawu");
            return (Criteria) this;
        }

        public Criteria andFuhuawuLike(String value) {
            addCriterion("fuhuawu like", value, "fuhuawu");
            return (Criteria) this;
        }

        public Criteria andFuhuawuNotLike(String value) {
            addCriterion("fuhuawu not like", value, "fuhuawu");
            return (Criteria) this;
        }

        public Criteria andFuhuawuIn(List<String> values) {
            addCriterion("fuhuawu in", values, "fuhuawu");
            return (Criteria) this;
        }

        public Criteria andFuhuawuNotIn(List<String> values) {
            addCriterion("fuhuawu not in", values, "fuhuawu");
            return (Criteria) this;
        }

        public Criteria andFuhuawuBetween(String value1, String value2) {
            addCriterion("fuhuawu between", value1, value2, "fuhuawu");
            return (Criteria) this;
        }

        public Criteria andFuhuawuNotBetween(String value1, String value2) {
            addCriterion("fuhuawu not between", value1, value2, "fuhuawu");
            return (Criteria) this;
        }

        public Criteria andGeIsNull() {
            addCriterion("ge is null");
            return (Criteria) this;
        }

        public Criteria andGeIsNotNull() {
            addCriterion("ge is not null");
            return (Criteria) this;
        }

        public Criteria andGeEqualTo(String value) {
            addCriterion("ge =", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeNotEqualTo(String value) {
            addCriterion("ge <>", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeGreaterThan(String value) {
            addCriterion("ge >", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeGreaterThanOrEqualTo(String value) {
            addCriterion("ge >=", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeLessThan(String value) {
            addCriterion("ge <", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeLessThanOrEqualTo(String value) {
            addCriterion("ge <=", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeLike(String value) {
            addCriterion("ge like", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeNotLike(String value) {
            addCriterion("ge not like", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeIn(List<String> values) {
            addCriterion("ge in", values, "ge");
            return (Criteria) this;
        }

        public Criteria andGeNotIn(List<String> values) {
            addCriterion("ge not in", values, "ge");
            return (Criteria) this;
        }

        public Criteria andGeBetween(String value1, String value2) {
            addCriterion("ge between", value1, value2, "ge");
            return (Criteria) this;
        }

        public Criteria andGeNotBetween(String value1, String value2) {
            addCriterion("ge not between", value1, value2, "ge");
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

        public Criteria andGmsyEqualTo(String value) {
            addCriterion("gmsy =", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyNotEqualTo(String value) {
            addCriterion("gmsy <>", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyGreaterThan(String value) {
            addCriterion("gmsy >", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyGreaterThanOrEqualTo(String value) {
            addCriterion("gmsy >=", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyLessThan(String value) {
            addCriterion("gmsy <", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyLessThanOrEqualTo(String value) {
            addCriterion("gmsy <=", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyLike(String value) {
            addCriterion("gmsy like", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyNotLike(String value) {
            addCriterion("gmsy not like", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyIn(List<String> values) {
            addCriterion("gmsy in", values, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyNotIn(List<String> values) {
            addCriterion("gmsy not in", values, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyBetween(String value1, String value2) {
            addCriterion("gmsy between", value1, value2, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyNotBetween(String value1, String value2) {
            addCriterion("gmsy not between", value1, value2, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGongIsNull() {
            addCriterion("gong is null");
            return (Criteria) this;
        }

        public Criteria andGongIsNotNull() {
            addCriterion("gong is not null");
            return (Criteria) this;
        }

        public Criteria andGongEqualTo(String value) {
            addCriterion("gong =", value, "gong");
            return (Criteria) this;
        }

        public Criteria andGongNotEqualTo(String value) {
            addCriterion("gong <>", value, "gong");
            return (Criteria) this;
        }

        public Criteria andGongGreaterThan(String value) {
            addCriterion("gong >", value, "gong");
            return (Criteria) this;
        }

        public Criteria andGongGreaterThanOrEqualTo(String value) {
            addCriterion("gong >=", value, "gong");
            return (Criteria) this;
        }

        public Criteria andGongLessThan(String value) {
            addCriterion("gong <", value, "gong");
            return (Criteria) this;
        }

        public Criteria andGongLessThanOrEqualTo(String value) {
            addCriterion("gong <=", value, "gong");
            return (Criteria) this;
        }

        public Criteria andGongLike(String value) {
            addCriterion("gong like", value, "gong");
            return (Criteria) this;
        }

        public Criteria andGongNotLike(String value) {
            addCriterion("gong not like", value, "gong");
            return (Criteria) this;
        }

        public Criteria andGongIn(List<String> values) {
            addCriterion("gong in", values, "gong");
            return (Criteria) this;
        }

        public Criteria andGongNotIn(List<String> values) {
            addCriterion("gong not in", values, "gong");
            return (Criteria) this;
        }

        public Criteria andGongBetween(String value1, String value2) {
            addCriterion("gong between", value1, value2, "gong");
            return (Criteria) this;
        }

        public Criteria andGongNotBetween(String value1, String value2) {
            addCriterion("gong not between", value1, value2, "gong");
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

        public Criteria andHuifafenIsNull() {
            addCriterion("huifafen is null");
            return (Criteria) this;
        }

        public Criteria andHuifafenIsNotNull() {
            addCriterion("huifafen is not null");
            return (Criteria) this;
        }

        public Criteria andHuifafenEqualTo(String value) {
            addCriterion("huifafen =", value, "huifafen");
            return (Criteria) this;
        }

        public Criteria andHuifafenNotEqualTo(String value) {
            addCriterion("huifafen <>", value, "huifafen");
            return (Criteria) this;
        }

        public Criteria andHuifafenGreaterThan(String value) {
            addCriterion("huifafen >", value, "huifafen");
            return (Criteria) this;
        }

        public Criteria andHuifafenGreaterThanOrEqualTo(String value) {
            addCriterion("huifafen >=", value, "huifafen");
            return (Criteria) this;
        }

        public Criteria andHuifafenLessThan(String value) {
            addCriterion("huifafen <", value, "huifafen");
            return (Criteria) this;
        }

        public Criteria andHuifafenLessThanOrEqualTo(String value) {
            addCriterion("huifafen <=", value, "huifafen");
            return (Criteria) this;
        }

        public Criteria andHuifafenLike(String value) {
            addCriterion("huifafen like", value, "huifafen");
            return (Criteria) this;
        }

        public Criteria andHuifafenNotLike(String value) {
            addCriterion("huifafen not like", value, "huifafen");
            return (Criteria) this;
        }

        public Criteria andHuifafenIn(List<String> values) {
            addCriterion("huifafen in", values, "huifafen");
            return (Criteria) this;
        }

        public Criteria andHuifafenNotIn(List<String> values) {
            addCriterion("huifafen not in", values, "huifafen");
            return (Criteria) this;
        }

        public Criteria andHuifafenBetween(String value1, String value2) {
            addCriterion("huifafen between", value1, value2, "huifafen");
            return (Criteria) this;
        }

        public Criteria andHuifafenNotBetween(String value1, String value2) {
            addCriterion("huifafen not between", value1, value2, "huifafen");
            return (Criteria) this;
        }

        public Criteria andHxxylIsNull() {
            addCriterion("hxxyl is null");
            return (Criteria) this;
        }

        public Criteria andHxxylIsNotNull() {
            addCriterion("hxxyl is not null");
            return (Criteria) this;
        }

        public Criteria andHxxylEqualTo(String value) {
            addCriterion("hxxyl =", value, "hxxyl");
            return (Criteria) this;
        }

        public Criteria andHxxylNotEqualTo(String value) {
            addCriterion("hxxyl <>", value, "hxxyl");
            return (Criteria) this;
        }

        public Criteria andHxxylGreaterThan(String value) {
            addCriterion("hxxyl >", value, "hxxyl");
            return (Criteria) this;
        }

        public Criteria andHxxylGreaterThanOrEqualTo(String value) {
            addCriterion("hxxyl >=", value, "hxxyl");
            return (Criteria) this;
        }

        public Criteria andHxxylLessThan(String value) {
            addCriterion("hxxyl <", value, "hxxyl");
            return (Criteria) this;
        }

        public Criteria andHxxylLessThanOrEqualTo(String value) {
            addCriterion("hxxyl <=", value, "hxxyl");
            return (Criteria) this;
        }

        public Criteria andHxxylLike(String value) {
            addCriterion("hxxyl like", value, "hxxyl");
            return (Criteria) this;
        }

        public Criteria andHxxylNotLike(String value) {
            addCriterion("hxxyl not like", value, "hxxyl");
            return (Criteria) this;
        }

        public Criteria andHxxylIn(List<String> values) {
            addCriterion("hxxyl in", values, "hxxyl");
            return (Criteria) this;
        }

        public Criteria andHxxylNotIn(List<String> values) {
            addCriterion("hxxyl not in", values, "hxxyl");
            return (Criteria) this;
        }

        public Criteria andHxxylBetween(String value1, String value2) {
            addCriterion("hxxyl between", value1, value2, "hxxyl");
            return (Criteria) this;
        }

        public Criteria andHxxylNotBetween(String value1, String value2) {
            addCriterion("hxxyl not between", value1, value2, "hxxyl");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuIsNull() {
            addCriterion("liuhuawu is null");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuIsNotNull() {
            addCriterion("liuhuawu is not null");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuEqualTo(String value) {
            addCriterion("liuhuawu =", value, "liuhuawu");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuNotEqualTo(String value) {
            addCriterion("liuhuawu <>", value, "liuhuawu");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuGreaterThan(String value) {
            addCriterion("liuhuawu >", value, "liuhuawu");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuGreaterThanOrEqualTo(String value) {
            addCriterion("liuhuawu >=", value, "liuhuawu");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuLessThan(String value) {
            addCriterion("liuhuawu <", value, "liuhuawu");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuLessThanOrEqualTo(String value) {
            addCriterion("liuhuawu <=", value, "liuhuawu");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuLike(String value) {
            addCriterion("liuhuawu like", value, "liuhuawu");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuNotLike(String value) {
            addCriterion("liuhuawu not like", value, "liuhuawu");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuIn(List<String> values) {
            addCriterion("liuhuawu in", values, "liuhuawu");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuNotIn(List<String> values) {
            addCriterion("liuhuawu not in", values, "liuhuawu");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuBetween(String value1, String value2) {
            addCriterion("liuhuawu between", value1, value2, "liuhuawu");
            return (Criteria) this;
        }

        public Criteria andLiuhuawuNotBetween(String value1, String value2) {
            addCriterion("liuhuawu not between", value1, value2, "liuhuawu");
            return (Criteria) this;
        }

        public Criteria andLiujiageIsNull() {
            addCriterion("liujiage is null");
            return (Criteria) this;
        }

        public Criteria andLiujiageIsNotNull() {
            addCriterion("liujiage is not null");
            return (Criteria) this;
        }

        public Criteria andLiujiageEqualTo(String value) {
            addCriterion("liujiage =", value, "liujiage");
            return (Criteria) this;
        }

        public Criteria andLiujiageNotEqualTo(String value) {
            addCriterion("liujiage <>", value, "liujiage");
            return (Criteria) this;
        }

        public Criteria andLiujiageGreaterThan(String value) {
            addCriterion("liujiage >", value, "liujiage");
            return (Criteria) this;
        }

        public Criteria andLiujiageGreaterThanOrEqualTo(String value) {
            addCriterion("liujiage >=", value, "liujiage");
            return (Criteria) this;
        }

        public Criteria andLiujiageLessThan(String value) {
            addCriterion("liujiage <", value, "liujiage");
            return (Criteria) this;
        }

        public Criteria andLiujiageLessThanOrEqualTo(String value) {
            addCriterion("liujiage <=", value, "liujiage");
            return (Criteria) this;
        }

        public Criteria andLiujiageLike(String value) {
            addCriterion("liujiage like", value, "liujiage");
            return (Criteria) this;
        }

        public Criteria andLiujiageNotLike(String value) {
            addCriterion("liujiage not like", value, "liujiage");
            return (Criteria) this;
        }

        public Criteria andLiujiageIn(List<String> values) {
            addCriterion("liujiage in", values, "liujiage");
            return (Criteria) this;
        }

        public Criteria andLiujiageNotIn(List<String> values) {
            addCriterion("liujiage not in", values, "liujiage");
            return (Criteria) this;
        }

        public Criteria andLiujiageBetween(String value1, String value2) {
            addCriterion("liujiage between", value1, value2, "liujiage");
            return (Criteria) this;
        }

        public Criteria andLiujiageNotBetween(String value1, String value2) {
            addCriterion("liujiage not between", value1, value2, "liujiage");
            return (Criteria) this;
        }

        public Criteria andLiuliangIsNull() {
            addCriterion("liuliang is null");
            return (Criteria) this;
        }

        public Criteria andLiuliangIsNotNull() {
            addCriterion("liuliang is not null");
            return (Criteria) this;
        }

        public Criteria andLiuliangEqualTo(String value) {
            addCriterion("liuliang =", value, "liuliang");
            return (Criteria) this;
        }

        public Criteria andLiuliangNotEqualTo(String value) {
            addCriterion("liuliang <>", value, "liuliang");
            return (Criteria) this;
        }

        public Criteria andLiuliangGreaterThan(String value) {
            addCriterion("liuliang >", value, "liuliang");
            return (Criteria) this;
        }

        public Criteria andLiuliangGreaterThanOrEqualTo(String value) {
            addCriterion("liuliang >=", value, "liuliang");
            return (Criteria) this;
        }

        public Criteria andLiuliangLessThan(String value) {
            addCriterion("liuliang <", value, "liuliang");
            return (Criteria) this;
        }

        public Criteria andLiuliangLessThanOrEqualTo(String value) {
            addCriterion("liuliang <=", value, "liuliang");
            return (Criteria) this;
        }

        public Criteria andLiuliangLike(String value) {
            addCriterion("liuliang like", value, "liuliang");
            return (Criteria) this;
        }

        public Criteria andLiuliangNotLike(String value) {
            addCriterion("liuliang not like", value, "liuliang");
            return (Criteria) this;
        }

        public Criteria andLiuliangIn(List<String> values) {
            addCriterion("liuliang in", values, "liuliang");
            return (Criteria) this;
        }

        public Criteria andLiuliangNotIn(List<String> values) {
            addCriterion("liuliang not in", values, "liuliang");
            return (Criteria) this;
        }

        public Criteria andLiuliangBetween(String value1, String value2) {
            addCriterion("liuliang between", value1, value2, "liuliang");
            return (Criteria) this;
        }

        public Criteria andLiuliangNotBetween(String value1, String value2) {
            addCriterion("liuliang not between", value1, value2, "liuliang");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanIsNull() {
            addCriterion("liusuanyan is null");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanIsNotNull() {
            addCriterion("liusuanyan is not null");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanEqualTo(String value) {
            addCriterion("liusuanyan =", value, "liusuanyan");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanNotEqualTo(String value) {
            addCriterion("liusuanyan <>", value, "liusuanyan");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanGreaterThan(String value) {
            addCriterion("liusuanyan >", value, "liusuanyan");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanGreaterThanOrEqualTo(String value) {
            addCriterion("liusuanyan >=", value, "liusuanyan");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanLessThan(String value) {
            addCriterion("liusuanyan <", value, "liusuanyan");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanLessThanOrEqualTo(String value) {
            addCriterion("liusuanyan <=", value, "liusuanyan");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanLike(String value) {
            addCriterion("liusuanyan like", value, "liusuanyan");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanNotLike(String value) {
            addCriterion("liusuanyan not like", value, "liusuanyan");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanIn(List<String> values) {
            addCriterion("liusuanyan in", values, "liusuanyan");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanNotIn(List<String> values) {
            addCriterion("liusuanyan not in", values, "liusuanyan");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanBetween(String value1, String value2) {
            addCriterion("liusuanyan between", value1, value2, "liusuanyan");
            return (Criteria) this;
        }

        public Criteria andLiusuanyanNotBetween(String value1, String value2) {
            addCriterion("liusuanyan not between", value1, value2, "liusuanyan");
            return (Criteria) this;
        }

        public Criteria andLvhuawuIsNull() {
            addCriterion("lvhuawu is null");
            return (Criteria) this;
        }

        public Criteria andLvhuawuIsNotNull() {
            addCriterion("lvhuawu is not null");
            return (Criteria) this;
        }

        public Criteria andLvhuawuEqualTo(String value) {
            addCriterion("lvhuawu =", value, "lvhuawu");
            return (Criteria) this;
        }

        public Criteria andLvhuawuNotEqualTo(String value) {
            addCriterion("lvhuawu <>", value, "lvhuawu");
            return (Criteria) this;
        }

        public Criteria andLvhuawuGreaterThan(String value) {
            addCriterion("lvhuawu >", value, "lvhuawu");
            return (Criteria) this;
        }

        public Criteria andLvhuawuGreaterThanOrEqualTo(String value) {
            addCriterion("lvhuawu >=", value, "lvhuawu");
            return (Criteria) this;
        }

        public Criteria andLvhuawuLessThan(String value) {
            addCriterion("lvhuawu <", value, "lvhuawu");
            return (Criteria) this;
        }

        public Criteria andLvhuawuLessThanOrEqualTo(String value) {
            addCriterion("lvhuawu <=", value, "lvhuawu");
            return (Criteria) this;
        }

        public Criteria andLvhuawuLike(String value) {
            addCriterion("lvhuawu like", value, "lvhuawu");
            return (Criteria) this;
        }

        public Criteria andLvhuawuNotLike(String value) {
            addCriterion("lvhuawu not like", value, "lvhuawu");
            return (Criteria) this;
        }

        public Criteria andLvhuawuIn(List<String> values) {
            addCriterion("lvhuawu in", values, "lvhuawu");
            return (Criteria) this;
        }

        public Criteria andLvhuawuNotIn(List<String> values) {
            addCriterion("lvhuawu not in", values, "lvhuawu");
            return (Criteria) this;
        }

        public Criteria andLvhuawuBetween(String value1, String value2) {
            addCriterion("lvhuawu between", value1, value2, "lvhuawu");
            return (Criteria) this;
        }

        public Criteria andLvhuawuNotBetween(String value1, String value2) {
            addCriterion("lvhuawu not between", value1, value2, "lvhuawu");
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

        public Criteria andPhIsNull() {
            addCriterion("ph is null");
            return (Criteria) this;
        }

        public Criteria andPhIsNotNull() {
            addCriterion("ph is not null");
            return (Criteria) this;
        }

        public Criteria andPhEqualTo(String value) {
            addCriterion("ph =", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotEqualTo(String value) {
            addCriterion("ph <>", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThan(String value) {
            addCriterion("ph >", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThanOrEqualTo(String value) {
            addCriterion("ph >=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThan(String value) {
            addCriterion("ph <", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThanOrEqualTo(String value) {
            addCriterion("ph <=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLike(String value) {
            addCriterion("ph like", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotLike(String value) {
            addCriterion("ph not like", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhIn(List<String> values) {
            addCriterion("ph in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotIn(List<String> values) {
            addCriterion("ph not in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhBetween(String value1, String value2) {
            addCriterion("ph between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotBetween(String value1, String value2) {
            addCriterion("ph not between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andQianIsNull() {
            addCriterion("qian is null");
            return (Criteria) this;
        }

        public Criteria andQianIsNotNull() {
            addCriterion("qian is not null");
            return (Criteria) this;
        }

        public Criteria andQianEqualTo(String value) {
            addCriterion("qian =", value, "qian");
            return (Criteria) this;
        }

        public Criteria andQianNotEqualTo(String value) {
            addCriterion("qian <>", value, "qian");
            return (Criteria) this;
        }

        public Criteria andQianGreaterThan(String value) {
            addCriterion("qian >", value, "qian");
            return (Criteria) this;
        }

        public Criteria andQianGreaterThanOrEqualTo(String value) {
            addCriterion("qian >=", value, "qian");
            return (Criteria) this;
        }

        public Criteria andQianLessThan(String value) {
            addCriterion("qian <", value, "qian");
            return (Criteria) this;
        }

        public Criteria andQianLessThanOrEqualTo(String value) {
            addCriterion("qian <=", value, "qian");
            return (Criteria) this;
        }

        public Criteria andQianLike(String value) {
            addCriterion("qian like", value, "qian");
            return (Criteria) this;
        }

        public Criteria andQianNotLike(String value) {
            addCriterion("qian not like", value, "qian");
            return (Criteria) this;
        }

        public Criteria andQianIn(List<String> values) {
            addCriterion("qian in", values, "qian");
            return (Criteria) this;
        }

        public Criteria andQianNotIn(List<String> values) {
            addCriterion("qian not in", values, "qian");
            return (Criteria) this;
        }

        public Criteria andQianBetween(String value1, String value2) {
            addCriterion("qian between", value1, value2, "qian");
            return (Criteria) this;
        }

        public Criteria andQianNotBetween(String value1, String value2) {
            addCriterion("qian not between", value1, value2, "qian");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngIsNull() {
            addCriterion("rongjieyanng is null");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngIsNotNull() {
            addCriterion("rongjieyanng is not null");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngEqualTo(String value) {
            addCriterion("rongjieyanng =", value, "rongjieyanng");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngNotEqualTo(String value) {
            addCriterion("rongjieyanng <>", value, "rongjieyanng");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngGreaterThan(String value) {
            addCriterion("rongjieyanng >", value, "rongjieyanng");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngGreaterThanOrEqualTo(String value) {
            addCriterion("rongjieyanng >=", value, "rongjieyanng");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngLessThan(String value) {
            addCriterion("rongjieyanng <", value, "rongjieyanng");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngLessThanOrEqualTo(String value) {
            addCriterion("rongjieyanng <=", value, "rongjieyanng");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngLike(String value) {
            addCriterion("rongjieyanng like", value, "rongjieyanng");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngNotLike(String value) {
            addCriterion("rongjieyanng not like", value, "rongjieyanng");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngIn(List<String> values) {
            addCriterion("rongjieyanng in", values, "rongjieyanng");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngNotIn(List<String> values) {
            addCriterion("rongjieyanng not in", values, "rongjieyanng");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngBetween(String value1, String value2) {
            addCriterion("rongjieyanng between", value1, value2, "rongjieyanng");
            return (Criteria) this;
        }

        public Criteria andRongjieyanngNotBetween(String value1, String value2) {
            addCriterion("rongjieyanng not between", value1, value2, "rongjieyanng");
            return (Criteria) this;
        }

        public Criteria andShenIsNull() {
            addCriterion("shen is null");
            return (Criteria) this;
        }

        public Criteria andShenIsNotNull() {
            addCriterion("shen is not null");
            return (Criteria) this;
        }

        public Criteria andShenEqualTo(String value) {
            addCriterion("shen =", value, "shen");
            return (Criteria) this;
        }

        public Criteria andShenNotEqualTo(String value) {
            addCriterion("shen <>", value, "shen");
            return (Criteria) this;
        }

        public Criteria andShenGreaterThan(String value) {
            addCriterion("shen >", value, "shen");
            return (Criteria) this;
        }

        public Criteria andShenGreaterThanOrEqualTo(String value) {
            addCriterion("shen >=", value, "shen");
            return (Criteria) this;
        }

        public Criteria andShenLessThan(String value) {
            addCriterion("shen <", value, "shen");
            return (Criteria) this;
        }

        public Criteria andShenLessThanOrEqualTo(String value) {
            addCriterion("shen <=", value, "shen");
            return (Criteria) this;
        }

        public Criteria andShenLike(String value) {
            addCriterion("shen like", value, "shen");
            return (Criteria) this;
        }

        public Criteria andShenNotLike(String value) {
            addCriterion("shen not like", value, "shen");
            return (Criteria) this;
        }

        public Criteria andShenIn(List<String> values) {
            addCriterion("shen in", values, "shen");
            return (Criteria) this;
        }

        public Criteria andShenNotIn(List<String> values) {
            addCriterion("shen not in", values, "shen");
            return (Criteria) this;
        }

        public Criteria andShenBetween(String value1, String value2) {
            addCriterion("shen between", value1, value2, "shen");
            return (Criteria) this;
        }

        public Criteria andShenNotBetween(String value1, String value2) {
            addCriterion("shen not between", value1, value2, "shen");
            return (Criteria) this;
        }

        public Criteria andShiyouleiIsNull() {
            addCriterion("shiyoulei is null");
            return (Criteria) this;
        }

        public Criteria andShiyouleiIsNotNull() {
            addCriterion("shiyoulei is not null");
            return (Criteria) this;
        }

        public Criteria andShiyouleiEqualTo(String value) {
            addCriterion("shiyoulei =", value, "shiyoulei");
            return (Criteria) this;
        }

        public Criteria andShiyouleiNotEqualTo(String value) {
            addCriterion("shiyoulei <>", value, "shiyoulei");
            return (Criteria) this;
        }

        public Criteria andShiyouleiGreaterThan(String value) {
            addCriterion("shiyoulei >", value, "shiyoulei");
            return (Criteria) this;
        }

        public Criteria andShiyouleiGreaterThanOrEqualTo(String value) {
            addCriterion("shiyoulei >=", value, "shiyoulei");
            return (Criteria) this;
        }

        public Criteria andShiyouleiLessThan(String value) {
            addCriterion("shiyoulei <", value, "shiyoulei");
            return (Criteria) this;
        }

        public Criteria andShiyouleiLessThanOrEqualTo(String value) {
            addCriterion("shiyoulei <=", value, "shiyoulei");
            return (Criteria) this;
        }

        public Criteria andShiyouleiLike(String value) {
            addCriterion("shiyoulei like", value, "shiyoulei");
            return (Criteria) this;
        }

        public Criteria andShiyouleiNotLike(String value) {
            addCriterion("shiyoulei not like", value, "shiyoulei");
            return (Criteria) this;
        }

        public Criteria andShiyouleiIn(List<String> values) {
            addCriterion("shiyoulei in", values, "shiyoulei");
            return (Criteria) this;
        }

        public Criteria andShiyouleiNotIn(List<String> values) {
            addCriterion("shiyoulei not in", values, "shiyoulei");
            return (Criteria) this;
        }

        public Criteria andShiyouleiBetween(String value1, String value2) {
            addCriterion("shiyoulei between", value1, value2, "shiyoulei");
            return (Criteria) this;
        }

        public Criteria andShiyouleiNotBetween(String value1, String value2) {
            addCriterion("shiyoulei not between", value1, value2, "shiyoulei");
            return (Criteria) this;
        }

        public Criteria andShuishenIsNull() {
            addCriterion("shuishen is null");
            return (Criteria) this;
        }

        public Criteria andShuishenIsNotNull() {
            addCriterion("shuishen is not null");
            return (Criteria) this;
        }

        public Criteria andShuishenEqualTo(String value) {
            addCriterion("shuishen =", value, "shuishen");
            return (Criteria) this;
        }

        public Criteria andShuishenNotEqualTo(String value) {
            addCriterion("shuishen <>", value, "shuishen");
            return (Criteria) this;
        }

        public Criteria andShuishenGreaterThan(String value) {
            addCriterion("shuishen >", value, "shuishen");
            return (Criteria) this;
        }

        public Criteria andShuishenGreaterThanOrEqualTo(String value) {
            addCriterion("shuishen >=", value, "shuishen");
            return (Criteria) this;
        }

        public Criteria andShuishenLessThan(String value) {
            addCriterion("shuishen <", value, "shuishen");
            return (Criteria) this;
        }

        public Criteria andShuishenLessThanOrEqualTo(String value) {
            addCriterion("shuishen <=", value, "shuishen");
            return (Criteria) this;
        }

        public Criteria andShuishenLike(String value) {
            addCriterion("shuishen like", value, "shuishen");
            return (Criteria) this;
        }

        public Criteria andShuishenNotLike(String value) {
            addCriterion("shuishen not like", value, "shuishen");
            return (Criteria) this;
        }

        public Criteria andShuishenIn(List<String> values) {
            addCriterion("shuishen in", values, "shuishen");
            return (Criteria) this;
        }

        public Criteria andShuishenNotIn(List<String> values) {
            addCriterion("shuishen not in", values, "shuishen");
            return (Criteria) this;
        }

        public Criteria andShuishenBetween(String value1, String value2) {
            addCriterion("shuishen between", value1, value2, "shuishen");
            return (Criteria) this;
        }

        public Criteria andShuishenNotBetween(String value1, String value2) {
            addCriterion("shuishen not between", value1, value2, "shuishen");
            return (Criteria) this;
        }

        public Criteria andShuiwengIsNull() {
            addCriterion("shuiweng is null");
            return (Criteria) this;
        }

        public Criteria andShuiwengIsNotNull() {
            addCriterion("shuiweng is not null");
            return (Criteria) this;
        }

        public Criteria andShuiwengEqualTo(String value) {
            addCriterion("shuiweng =", value, "shuiweng");
            return (Criteria) this;
        }

        public Criteria andShuiwengNotEqualTo(String value) {
            addCriterion("shuiweng <>", value, "shuiweng");
            return (Criteria) this;
        }

        public Criteria andShuiwengGreaterThan(String value) {
            addCriterion("shuiweng >", value, "shuiweng");
            return (Criteria) this;
        }

        public Criteria andShuiwengGreaterThanOrEqualTo(String value) {
            addCriterion("shuiweng >=", value, "shuiweng");
            return (Criteria) this;
        }

        public Criteria andShuiwengLessThan(String value) {
            addCriterion("shuiweng <", value, "shuiweng");
            return (Criteria) this;
        }

        public Criteria andShuiwengLessThanOrEqualTo(String value) {
            addCriterion("shuiweng <=", value, "shuiweng");
            return (Criteria) this;
        }

        public Criteria andShuiwengLike(String value) {
            addCriterion("shuiweng like", value, "shuiweng");
            return (Criteria) this;
        }

        public Criteria andShuiwengNotLike(String value) {
            addCriterion("shuiweng not like", value, "shuiweng");
            return (Criteria) this;
        }

        public Criteria andShuiwengIn(List<String> values) {
            addCriterion("shuiweng in", values, "shuiweng");
            return (Criteria) this;
        }

        public Criteria andShuiwengNotIn(List<String> values) {
            addCriterion("shuiweng not in", values, "shuiweng");
            return (Criteria) this;
        }

        public Criteria andShuiwengBetween(String value1, String value2) {
            addCriterion("shuiweng between", value1, value2, "shuiweng");
            return (Criteria) this;
        }

        public Criteria andShuiwengNotBetween(String value1, String value2) {
            addCriterion("shuiweng not between", value1, value2, "shuiweng");
            return (Criteria) this;
        }

        public Criteria andShxylIsNull() {
            addCriterion("shxyl is null");
            return (Criteria) this;
        }

        public Criteria andShxylIsNotNull() {
            addCriterion("shxyl is not null");
            return (Criteria) this;
        }

        public Criteria andShxylEqualTo(String value) {
            addCriterion("shxyl =", value, "shxyl");
            return (Criteria) this;
        }

        public Criteria andShxylNotEqualTo(String value) {
            addCriterion("shxyl <>", value, "shxyl");
            return (Criteria) this;
        }

        public Criteria andShxylGreaterThan(String value) {
            addCriterion("shxyl >", value, "shxyl");
            return (Criteria) this;
        }

        public Criteria andShxylGreaterThanOrEqualTo(String value) {
            addCriterion("shxyl >=", value, "shxyl");
            return (Criteria) this;
        }

        public Criteria andShxylLessThan(String value) {
            addCriterion("shxyl <", value, "shxyl");
            return (Criteria) this;
        }

        public Criteria andShxylLessThanOrEqualTo(String value) {
            addCriterion("shxyl <=", value, "shxyl");
            return (Criteria) this;
        }

        public Criteria andShxylLike(String value) {
            addCriterion("shxyl like", value, "shxyl");
            return (Criteria) this;
        }

        public Criteria andShxylNotLike(String value) {
            addCriterion("shxyl not like", value, "shxyl");
            return (Criteria) this;
        }

        public Criteria andShxylIn(List<String> values) {
            addCriterion("shxyl in", values, "shxyl");
            return (Criteria) this;
        }

        public Criteria andShxylNotIn(List<String> values) {
            addCriterion("shxyl not in", values, "shxyl");
            return (Criteria) this;
        }

        public Criteria andShxylBetween(String value1, String value2) {
            addCriterion("shxyl between", value1, value2, "shxyl");
            return (Criteria) this;
        }

        public Criteria andShxylNotBetween(String value1, String value2) {
            addCriterion("shxyl not between", value1, value2, "shxyl");
            return (Criteria) this;
        }

        public Criteria andSqdmIsNull() {
            addCriterion("sqdm is null");
            return (Criteria) this;
        }

        public Criteria andSqdmIsNotNull() {
            addCriterion("sqdm is not null");
            return (Criteria) this;
        }

        public Criteria andSqdmEqualTo(String value) {
            addCriterion("sqdm =", value, "sqdm");
            return (Criteria) this;
        }

        public Criteria andSqdmNotEqualTo(String value) {
            addCriterion("sqdm <>", value, "sqdm");
            return (Criteria) this;
        }

        public Criteria andSqdmGreaterThan(String value) {
            addCriterion("sqdm >", value, "sqdm");
            return (Criteria) this;
        }

        public Criteria andSqdmGreaterThanOrEqualTo(String value) {
            addCriterion("sqdm >=", value, "sqdm");
            return (Criteria) this;
        }

        public Criteria andSqdmLessThan(String value) {
            addCriterion("sqdm <", value, "sqdm");
            return (Criteria) this;
        }

        public Criteria andSqdmLessThanOrEqualTo(String value) {
            addCriterion("sqdm <=", value, "sqdm");
            return (Criteria) this;
        }

        public Criteria andSqdmLike(String value) {
            addCriterion("sqdm like", value, "sqdm");
            return (Criteria) this;
        }

        public Criteria andSqdmNotLike(String value) {
            addCriterion("sqdm not like", value, "sqdm");
            return (Criteria) this;
        }

        public Criteria andSqdmIn(List<String> values) {
            addCriterion("sqdm in", values, "sqdm");
            return (Criteria) this;
        }

        public Criteria andSqdmNotIn(List<String> values) {
            addCriterion("sqdm not in", values, "sqdm");
            return (Criteria) this;
        }

        public Criteria andSqdmBetween(String value1, String value2) {
            addCriterion("sqdm between", value1, value2, "sqdm");
            return (Criteria) this;
        }

        public Criteria andSqdmNotBetween(String value1, String value2) {
            addCriterion("sqdm not between", value1, value2, "sqdm");
            return (Criteria) this;
        }

        public Criteria andXiIsNull() {
            addCriterion("xi is null");
            return (Criteria) this;
        }

        public Criteria andXiIsNotNull() {
            addCriterion("xi is not null");
            return (Criteria) this;
        }

        public Criteria andXiEqualTo(String value) {
            addCriterion("xi =", value, "xi");
            return (Criteria) this;
        }

        public Criteria andXiNotEqualTo(String value) {
            addCriterion("xi <>", value, "xi");
            return (Criteria) this;
        }

        public Criteria andXiGreaterThan(String value) {
            addCriterion("xi >", value, "xi");
            return (Criteria) this;
        }

        public Criteria andXiGreaterThanOrEqualTo(String value) {
            addCriterion("xi >=", value, "xi");
            return (Criteria) this;
        }

        public Criteria andXiLessThan(String value) {
            addCriterion("xi <", value, "xi");
            return (Criteria) this;
        }

        public Criteria andXiLessThanOrEqualTo(String value) {
            addCriterion("xi <=", value, "xi");
            return (Criteria) this;
        }

        public Criteria andXiLike(String value) {
            addCriterion("xi like", value, "xi");
            return (Criteria) this;
        }

        public Criteria andXiNotLike(String value) {
            addCriterion("xi not like", value, "xi");
            return (Criteria) this;
        }

        public Criteria andXiIn(List<String> values) {
            addCriterion("xi in", values, "xi");
            return (Criteria) this;
        }

        public Criteria andXiNotIn(List<String> values) {
            addCriterion("xi not in", values, "xi");
            return (Criteria) this;
        }

        public Criteria andXiBetween(String value1, String value2) {
            addCriterion("xi between", value1, value2, "xi");
            return (Criteria) this;
        }

        public Criteria andXiNotBetween(String value1, String value2) {
            addCriterion("xi not between", value1, value2, "xi");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanIsNull() {
            addCriterion("xiaosuanyan is null");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanIsNotNull() {
            addCriterion("xiaosuanyan is not null");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanEqualTo(String value) {
            addCriterion("xiaosuanyan =", value, "xiaosuanyan");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanNotEqualTo(String value) {
            addCriterion("xiaosuanyan <>", value, "xiaosuanyan");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanGreaterThan(String value) {
            addCriterion("xiaosuanyan >", value, "xiaosuanyan");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanGreaterThanOrEqualTo(String value) {
            addCriterion("xiaosuanyan >=", value, "xiaosuanyan");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanLessThan(String value) {
            addCriterion("xiaosuanyan <", value, "xiaosuanyan");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanLessThanOrEqualTo(String value) {
            addCriterion("xiaosuanyan <=", value, "xiaosuanyan");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanLike(String value) {
            addCriterion("xiaosuanyan like", value, "xiaosuanyan");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanNotLike(String value) {
            addCriterion("xiaosuanyan not like", value, "xiaosuanyan");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanIn(List<String> values) {
            addCriterion("xiaosuanyan in", values, "xiaosuanyan");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanNotIn(List<String> values) {
            addCriterion("xiaosuanyan not in", values, "xiaosuanyan");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanBetween(String value1, String value2) {
            addCriterion("xiaosuanyan between", value1, value2, "xiaosuanyan");
            return (Criteria) this;
        }

        public Criteria andXiaosuanyanNotBetween(String value1, String value2) {
            addCriterion("xiaosuanyan not between", value1, value2, "xiaosuanyan");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuIsNull() {
            addCriterion("xuanfuwu is null");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuIsNotNull() {
            addCriterion("xuanfuwu is not null");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuEqualTo(String value) {
            addCriterion("xuanfuwu =", value, "xuanfuwu");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuNotEqualTo(String value) {
            addCriterion("xuanfuwu <>", value, "xuanfuwu");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuGreaterThan(String value) {
            addCriterion("xuanfuwu >", value, "xuanfuwu");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuGreaterThanOrEqualTo(String value) {
            addCriterion("xuanfuwu >=", value, "xuanfuwu");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuLessThan(String value) {
            addCriterion("xuanfuwu <", value, "xuanfuwu");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuLessThanOrEqualTo(String value) {
            addCriterion("xuanfuwu <=", value, "xuanfuwu");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuLike(String value) {
            addCriterion("xuanfuwu like", value, "xuanfuwu");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuNotLike(String value) {
            addCriterion("xuanfuwu not like", value, "xuanfuwu");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuIn(List<String> values) {
            addCriterion("xuanfuwu in", values, "xuanfuwu");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuNotIn(List<String> values) {
            addCriterion("xuanfuwu not in", values, "xuanfuwu");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuBetween(String value1, String value2) {
            addCriterion("xuanfuwu between", value1, value2, "xuanfuwu");
            return (Criteria) this;
        }

        public Criteria andXuanfuwuNotBetween(String value1, String value2) {
            addCriterion("xuanfuwu not between", value1, value2, "xuanfuwu");
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

        public Criteria andYxsyIsNull() {
            addCriterion("yxsy is null");
            return (Criteria) this;
        }

        public Criteria andYxsyIsNotNull() {
            addCriterion("yxsy is not null");
            return (Criteria) this;
        }

        public Criteria andYxsyEqualTo(String value) {
            addCriterion("yxsy =", value, "yxsy");
            return (Criteria) this;
        }

        public Criteria andYxsyNotEqualTo(String value) {
            addCriterion("yxsy <>", value, "yxsy");
            return (Criteria) this;
        }

        public Criteria andYxsyGreaterThan(String value) {
            addCriterion("yxsy >", value, "yxsy");
            return (Criteria) this;
        }

        public Criteria andYxsyGreaterThanOrEqualTo(String value) {
            addCriterion("yxsy >=", value, "yxsy");
            return (Criteria) this;
        }

        public Criteria andYxsyLessThan(String value) {
            addCriterion("yxsy <", value, "yxsy");
            return (Criteria) this;
        }

        public Criteria andYxsyLessThanOrEqualTo(String value) {
            addCriterion("yxsy <=", value, "yxsy");
            return (Criteria) this;
        }

        public Criteria andYxsyLike(String value) {
            addCriterion("yxsy like", value, "yxsy");
            return (Criteria) this;
        }

        public Criteria andYxsyNotLike(String value) {
            addCriterion("yxsy not like", value, "yxsy");
            return (Criteria) this;
        }

        public Criteria andYxsyIn(List<String> values) {
            addCriterion("yxsy in", values, "yxsy");
            return (Criteria) this;
        }

        public Criteria andYxsyNotIn(List<String> values) {
            addCriterion("yxsy not in", values, "yxsy");
            return (Criteria) this;
        }

        public Criteria andYxsyBetween(String value1, String value2) {
            addCriterion("yxsy between", value1, value2, "yxsy");
            return (Criteria) this;
        }

        public Criteria andYxsyNotBetween(String value1, String value2) {
            addCriterion("yxsy not between", value1, value2, "yxsy");
            return (Criteria) this;
        }

        public Criteria andZjhwIsNull() {
            addCriterion("zjhw is null");
            return (Criteria) this;
        }

        public Criteria andZjhwIsNotNull() {
            addCriterion("zjhw is not null");
            return (Criteria) this;
        }

        public Criteria andZjhwEqualTo(String value) {
            addCriterion("zjhw =", value, "zjhw");
            return (Criteria) this;
        }

        public Criteria andZjhwNotEqualTo(String value) {
            addCriterion("zjhw <>", value, "zjhw");
            return (Criteria) this;
        }

        public Criteria andZjhwGreaterThan(String value) {
            addCriterion("zjhw >", value, "zjhw");
            return (Criteria) this;
        }

        public Criteria andZjhwGreaterThanOrEqualTo(String value) {
            addCriterion("zjhw >=", value, "zjhw");
            return (Criteria) this;
        }

        public Criteria andZjhwLessThan(String value) {
            addCriterion("zjhw <", value, "zjhw");
            return (Criteria) this;
        }

        public Criteria andZjhwLessThanOrEqualTo(String value) {
            addCriterion("zjhw <=", value, "zjhw");
            return (Criteria) this;
        }

        public Criteria andZjhwLike(String value) {
            addCriterion("zjhw like", value, "zjhw");
            return (Criteria) this;
        }

        public Criteria andZjhwNotLike(String value) {
            addCriterion("zjhw not like", value, "zjhw");
            return (Criteria) this;
        }

        public Criteria andZjhwIn(List<String> values) {
            addCriterion("zjhw in", values, "zjhw");
            return (Criteria) this;
        }

        public Criteria andZjhwNotIn(List<String> values) {
            addCriterion("zjhw not in", values, "zjhw");
            return (Criteria) this;
        }

        public Criteria andZjhwBetween(String value1, String value2) {
            addCriterion("zjhw between", value1, value2, "zjhw");
            return (Criteria) this;
        }

        public Criteria andZjhwNotBetween(String value1, String value2) {
            addCriterion("zjhw not between", value1, value2, "zjhw");
            return (Criteria) this;
        }

        public Criteria andZongdanIsNull() {
            addCriterion("zongdan is null");
            return (Criteria) this;
        }

        public Criteria andZongdanIsNotNull() {
            addCriterion("zongdan is not null");
            return (Criteria) this;
        }

        public Criteria andZongdanEqualTo(String value) {
            addCriterion("zongdan =", value, "zongdan");
            return (Criteria) this;
        }

        public Criteria andZongdanNotEqualTo(String value) {
            addCriterion("zongdan <>", value, "zongdan");
            return (Criteria) this;
        }

        public Criteria andZongdanGreaterThan(String value) {
            addCriterion("zongdan >", value, "zongdan");
            return (Criteria) this;
        }

        public Criteria andZongdanGreaterThanOrEqualTo(String value) {
            addCriterion("zongdan >=", value, "zongdan");
            return (Criteria) this;
        }

        public Criteria andZongdanLessThan(String value) {
            addCriterion("zongdan <", value, "zongdan");
            return (Criteria) this;
        }

        public Criteria andZongdanLessThanOrEqualTo(String value) {
            addCriterion("zongdan <=", value, "zongdan");
            return (Criteria) this;
        }

        public Criteria andZongdanLike(String value) {
            addCriterion("zongdan like", value, "zongdan");
            return (Criteria) this;
        }

        public Criteria andZongdanNotLike(String value) {
            addCriterion("zongdan not like", value, "zongdan");
            return (Criteria) this;
        }

        public Criteria andZongdanIn(List<String> values) {
            addCriterion("zongdan in", values, "zongdan");
            return (Criteria) this;
        }

        public Criteria andZongdanNotIn(List<String> values) {
            addCriterion("zongdan not in", values, "zongdan");
            return (Criteria) this;
        }

        public Criteria andZongdanBetween(String value1, String value2) {
            addCriterion("zongdan between", value1, value2, "zongdan");
            return (Criteria) this;
        }

        public Criteria andZongdanNotBetween(String value1, String value2) {
            addCriterion("zongdan not between", value1, value2, "zongdan");
            return (Criteria) this;
        }

        public Criteria andZonglingIsNull() {
            addCriterion("zongling is null");
            return (Criteria) this;
        }

        public Criteria andZonglingIsNotNull() {
            addCriterion("zongling is not null");
            return (Criteria) this;
        }

        public Criteria andZonglingEqualTo(String value) {
            addCriterion("zongling =", value, "zongling");
            return (Criteria) this;
        }

        public Criteria andZonglingNotEqualTo(String value) {
            addCriterion("zongling <>", value, "zongling");
            return (Criteria) this;
        }

        public Criteria andZonglingGreaterThan(String value) {
            addCriterion("zongling >", value, "zongling");
            return (Criteria) this;
        }

        public Criteria andZonglingGreaterThanOrEqualTo(String value) {
            addCriterion("zongling >=", value, "zongling");
            return (Criteria) this;
        }

        public Criteria andZonglingLessThan(String value) {
            addCriterion("zongling <", value, "zongling");
            return (Criteria) this;
        }

        public Criteria andZonglingLessThanOrEqualTo(String value) {
            addCriterion("zongling <=", value, "zongling");
            return (Criteria) this;
        }

        public Criteria andZonglingLike(String value) {
            addCriterion("zongling like", value, "zongling");
            return (Criteria) this;
        }

        public Criteria andZonglingNotLike(String value) {
            addCriterion("zongling not like", value, "zongling");
            return (Criteria) this;
        }

        public Criteria andZonglingIn(List<String> values) {
            addCriterion("zongling in", values, "zongling");
            return (Criteria) this;
        }

        public Criteria andZonglingNotIn(List<String> values) {
            addCriterion("zongling not in", values, "zongling");
            return (Criteria) this;
        }

        public Criteria andZonglingBetween(String value1, String value2) {
            addCriterion("zongling between", value1, value2, "zongling");
            return (Criteria) this;
        }

        public Criteria andZonglingNotBetween(String value1, String value2) {
            addCriterion("zongling not between", value1, value2, "zongling");
            return (Criteria) this;
        }

        public Criteria andZongyingduIsNull() {
            addCriterion("zongyingdu is null");
            return (Criteria) this;
        }

        public Criteria andZongyingduIsNotNull() {
            addCriterion("zongyingdu is not null");
            return (Criteria) this;
        }

        public Criteria andZongyingduEqualTo(String value) {
            addCriterion("zongyingdu =", value, "zongyingdu");
            return (Criteria) this;
        }

        public Criteria andZongyingduNotEqualTo(String value) {
            addCriterion("zongyingdu <>", value, "zongyingdu");
            return (Criteria) this;
        }

        public Criteria andZongyingduGreaterThan(String value) {
            addCriterion("zongyingdu >", value, "zongyingdu");
            return (Criteria) this;
        }

        public Criteria andZongyingduGreaterThanOrEqualTo(String value) {
            addCriterion("zongyingdu >=", value, "zongyingdu");
            return (Criteria) this;
        }

        public Criteria andZongyingduLessThan(String value) {
            addCriterion("zongyingdu <", value, "zongyingdu");
            return (Criteria) this;
        }

        public Criteria andZongyingduLessThanOrEqualTo(String value) {
            addCriterion("zongyingdu <=", value, "zongyingdu");
            return (Criteria) this;
        }

        public Criteria andZongyingduLike(String value) {
            addCriterion("zongyingdu like", value, "zongyingdu");
            return (Criteria) this;
        }

        public Criteria andZongyingduNotLike(String value) {
            addCriterion("zongyingdu not like", value, "zongyingdu");
            return (Criteria) this;
        }

        public Criteria andZongyingduIn(List<String> values) {
            addCriterion("zongyingdu in", values, "zongyingdu");
            return (Criteria) this;
        }

        public Criteria andZongyingduNotIn(List<String> values) {
            addCriterion("zongyingdu not in", values, "zongyingdu");
            return (Criteria) this;
        }

        public Criteria andZongyingduBetween(String value1, String value2) {
            addCriterion("zongyingdu between", value1, value2, "zongyingdu");
            return (Criteria) this;
        }

        public Criteria andZongyingduNotBetween(String value1, String value2) {
            addCriterion("zongyingdu not between", value1, value2, "zongyingdu");
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
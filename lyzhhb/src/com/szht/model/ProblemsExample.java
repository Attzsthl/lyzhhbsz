package com.szht.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProblemsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProblemsExample() {
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

        public Criteria andLonIsNull() {
            addCriterion("lon is null");
            return (Criteria) this;
        }

        public Criteria andLonIsNotNull() {
            addCriterion("lon is not null");
            return (Criteria) this;
        }

        public Criteria andLonEqualTo(Double value) {
            addCriterion("lon =", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotEqualTo(Double value) {
            addCriterion("lon <>", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonGreaterThan(Double value) {
            addCriterion("lon >", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonGreaterThanOrEqualTo(Double value) {
            addCriterion("lon >=", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLessThan(Double value) {
            addCriterion("lon <", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLessThanOrEqualTo(Double value) {
            addCriterion("lon <=", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonIn(List<Double> values) {
            addCriterion("lon in", values, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotIn(List<Double> values) {
            addCriterion("lon not in", values, "lon");
            return (Criteria) this;
        }

        public Criteria andLonBetween(Double value1, Double value2) {
            addCriterion("lon between", value1, value2, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotBetween(Double value1, Double value2) {
            addCriterion("lon not between", value1, value2, "lon");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andDiscIsNull() {
            addCriterion("disc is null");
            return (Criteria) this;
        }

        public Criteria andDiscIsNotNull() {
            addCriterion("disc is not null");
            return (Criteria) this;
        }

        public Criteria andDiscEqualTo(String value) {
            addCriterion("disc =", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscNotEqualTo(String value) {
            addCriterion("disc <>", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscGreaterThan(String value) {
            addCriterion("disc >", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscGreaterThanOrEqualTo(String value) {
            addCriterion("disc >=", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscLessThan(String value) {
            addCriterion("disc <", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscLessThanOrEqualTo(String value) {
            addCriterion("disc <=", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscLike(String value) {
            addCriterion("disc like", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscNotLike(String value) {
            addCriterion("disc not like", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscIn(List<String> values) {
            addCriterion("disc in", values, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscNotIn(List<String> values) {
            addCriterion("disc not in", values, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscBetween(String value1, String value2) {
            addCriterion("disc between", value1, value2, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscNotBetween(String value1, String value2) {
            addCriterion("disc not between", value1, value2, "disc");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
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

        public Criteria andSubmittimeIsNull() {
            addCriterion("submittime is null");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIsNotNull() {
            addCriterion("submittime is not null");
            return (Criteria) this;
        }

        public Criteria andSubmittimeEqualTo(Date value) {
            addCriterion("submittime =", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotEqualTo(Date value) {
            addCriterion("submittime <>", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeGreaterThan(Date value) {
            addCriterion("submittime >", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submittime >=", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLessThan(Date value) {
            addCriterion("submittime <", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLessThanOrEqualTo(Date value) {
            addCriterion("submittime <=", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIn(List<Date> values) {
            addCriterion("submittime in", values, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotIn(List<Date> values) {
            addCriterion("submittime not in", values, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeBetween(Date value1, Date value2) {
            addCriterion("submittime between", value1, value2, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotBetween(Date value1, Date value2) {
            addCriterion("submittime not between", value1, value2, "submittime");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSlovetimeIsNull() {
            addCriterion("slovetime is null");
            return (Criteria) this;
        }

        public Criteria andSlovetimeIsNotNull() {
            addCriterion("slovetime is not null");
            return (Criteria) this;
        }

        public Criteria andSlovetimeEqualTo(Date value) {
            addCriterion("slovetime =", value, "slovetime");
            return (Criteria) this;
        }

        public Criteria andSlovetimeNotEqualTo(Date value) {
            addCriterion("slovetime <>", value, "slovetime");
            return (Criteria) this;
        }

        public Criteria andSlovetimeGreaterThan(Date value) {
            addCriterion("slovetime >", value, "slovetime");
            return (Criteria) this;
        }

        public Criteria andSlovetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("slovetime >=", value, "slovetime");
            return (Criteria) this;
        }

        public Criteria andSlovetimeLessThan(Date value) {
            addCriterion("slovetime <", value, "slovetime");
            return (Criteria) this;
        }

        public Criteria andSlovetimeLessThanOrEqualTo(Date value) {
            addCriterion("slovetime <=", value, "slovetime");
            return (Criteria) this;
        }

        public Criteria andSlovetimeIn(List<Date> values) {
            addCriterion("slovetime in", values, "slovetime");
            return (Criteria) this;
        }

        public Criteria andSlovetimeNotIn(List<Date> values) {
            addCriterion("slovetime not in", values, "slovetime");
            return (Criteria) this;
        }

        public Criteria andSlovetimeBetween(Date value1, Date value2) {
            addCriterion("slovetime between", value1, value2, "slovetime");
            return (Criteria) this;
        }

        public Criteria andSlovetimeNotBetween(Date value1, Date value2) {
            addCriterion("slovetime not between", value1, value2, "slovetime");
            return (Criteria) this;
        }

        public Criteria andSolverIsNull() {
            addCriterion("solver is null");
            return (Criteria) this;
        }

        public Criteria andSolverIsNotNull() {
            addCriterion("solver is not null");
            return (Criteria) this;
        }

        public Criteria andSolverEqualTo(String value) {
            addCriterion("solver =", value, "solver");
            return (Criteria) this;
        }

        public Criteria andSolverNotEqualTo(String value) {
            addCriterion("solver <>", value, "solver");
            return (Criteria) this;
        }

        public Criteria andSolverGreaterThan(String value) {
            addCriterion("solver >", value, "solver");
            return (Criteria) this;
        }

        public Criteria andSolverGreaterThanOrEqualTo(String value) {
            addCriterion("solver >=", value, "solver");
            return (Criteria) this;
        }

        public Criteria andSolverLessThan(String value) {
            addCriterion("solver <", value, "solver");
            return (Criteria) this;
        }

        public Criteria andSolverLessThanOrEqualTo(String value) {
            addCriterion("solver <=", value, "solver");
            return (Criteria) this;
        }

        public Criteria andSolverLike(String value) {
            addCriterion("solver like", value, "solver");
            return (Criteria) this;
        }

        public Criteria andSolverNotLike(String value) {
            addCriterion("solver not like", value, "solver");
            return (Criteria) this;
        }

        public Criteria andSolverIn(List<String> values) {
            addCriterion("solver in", values, "solver");
            return (Criteria) this;
        }

        public Criteria andSolverNotIn(List<String> values) {
            addCriterion("solver not in", values, "solver");
            return (Criteria) this;
        }

        public Criteria andSolverBetween(String value1, String value2) {
            addCriterion("solver between", value1, value2, "solver");
            return (Criteria) this;
        }

        public Criteria andSolverNotBetween(String value1, String value2) {
            addCriterion("solver not between", value1, value2, "solver");
            return (Criteria) this;
        }

        public Criteria andSuggestIsNull() {
            addCriterion("suggest is null");
            return (Criteria) this;
        }

        public Criteria andSuggestIsNotNull() {
            addCriterion("suggest is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestEqualTo(String value) {
            addCriterion("suggest =", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestNotEqualTo(String value) {
            addCriterion("suggest <>", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestGreaterThan(String value) {
            addCriterion("suggest >", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestGreaterThanOrEqualTo(String value) {
            addCriterion("suggest >=", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestLessThan(String value) {
            addCriterion("suggest <", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestLessThanOrEqualTo(String value) {
            addCriterion("suggest <=", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestLike(String value) {
            addCriterion("suggest like", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestNotLike(String value) {
            addCriterion("suggest not like", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestIn(List<String> values) {
            addCriterion("suggest in", values, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestNotIn(List<String> values) {
            addCriterion("suggest not in", values, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestBetween(String value1, String value2) {
            addCriterion("suggest between", value1, value2, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestNotBetween(String value1, String value2) {
            addCriterion("suggest not between", value1, value2, "suggest");
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
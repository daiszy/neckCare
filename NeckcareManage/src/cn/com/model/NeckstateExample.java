package cn.com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NeckstateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NeckstateExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andDatetimeIsNull() {
            addCriterion("datetime is null");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNotNull() {
            addCriterion("datetime is not null");
            return (Criteria) this;
        }

        public Criteria andDatetimeEqualTo(Date value) {
            addCriterion("datetime =", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotEqualTo(Date value) {
            addCriterion("datetime <>", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThan(Date value) {
            addCriterion("datetime >", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("datetime >=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThan(Date value) {
            addCriterion("datetime <", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("datetime <=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeIn(List<Date> values) {
            addCriterion("datetime in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotIn(List<Date> values) {
            addCriterion("datetime not in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeBetween(Date value1, Date value2) {
            addCriterion("datetime between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("datetime not between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andAverneckangleIsNull() {
            addCriterion("averneckangle is null");
            return (Criteria) this;
        }

        public Criteria andAverneckangleIsNotNull() {
            addCriterion("averneckangle is not null");
            return (Criteria) this;
        }

        public Criteria andAverneckangleEqualTo(Float value) {
            addCriterion("averneckangle =", value, "averneckangle");
            return (Criteria) this;
        }

        public Criteria andAverneckangleNotEqualTo(Float value) {
            addCriterion("averneckangle <>", value, "averneckangle");
            return (Criteria) this;
        }

        public Criteria andAverneckangleGreaterThan(Float value) {
            addCriterion("averneckangle >", value, "averneckangle");
            return (Criteria) this;
        }

        public Criteria andAverneckangleGreaterThanOrEqualTo(Float value) {
            addCriterion("averneckangle >=", value, "averneckangle");
            return (Criteria) this;
        }

        public Criteria andAverneckangleLessThan(Float value) {
            addCriterion("averneckangle <", value, "averneckangle");
            return (Criteria) this;
        }

        public Criteria andAverneckangleLessThanOrEqualTo(Float value) {
            addCriterion("averneckangle <=", value, "averneckangle");
            return (Criteria) this;
        }

        public Criteria andAverneckangleIn(List<Float> values) {
            addCriterion("averneckangle in", values, "averneckangle");
            return (Criteria) this;
        }

        public Criteria andAverneckangleNotIn(List<Float> values) {
            addCriterion("averneckangle not in", values, "averneckangle");
            return (Criteria) this;
        }

        public Criteria andAverneckangleBetween(Float value1, Float value2) {
            addCriterion("averneckangle between", value1, value2, "averneckangle");
            return (Criteria) this;
        }

        public Criteria andAverneckangleNotBetween(Float value1, Float value2) {
            addCriterion("averneckangle not between", value1, value2, "averneckangle");
            return (Criteria) this;
        }

        public Criteria andMaxneckangleIsNull() {
            addCriterion("maxneckangle is null");
            return (Criteria) this;
        }

        public Criteria andMaxneckangleIsNotNull() {
            addCriterion("maxneckangle is not null");
            return (Criteria) this;
        }

        public Criteria andMaxneckangleEqualTo(Float value) {
            addCriterion("maxneckangle =", value, "maxneckangle");
            return (Criteria) this;
        }

        public Criteria andMaxneckangleNotEqualTo(Float value) {
            addCriterion("maxneckangle <>", value, "maxneckangle");
            return (Criteria) this;
        }

        public Criteria andMaxneckangleGreaterThan(Float value) {
            addCriterion("maxneckangle >", value, "maxneckangle");
            return (Criteria) this;
        }

        public Criteria andMaxneckangleGreaterThanOrEqualTo(Float value) {
            addCriterion("maxneckangle >=", value, "maxneckangle");
            return (Criteria) this;
        }

        public Criteria andMaxneckangleLessThan(Float value) {
            addCriterion("maxneckangle <", value, "maxneckangle");
            return (Criteria) this;
        }

        public Criteria andMaxneckangleLessThanOrEqualTo(Float value) {
            addCriterion("maxneckangle <=", value, "maxneckangle");
            return (Criteria) this;
        }

        public Criteria andMaxneckangleIn(List<Float> values) {
            addCriterion("maxneckangle in", values, "maxneckangle");
            return (Criteria) this;
        }

        public Criteria andMaxneckangleNotIn(List<Float> values) {
            addCriterion("maxneckangle not in", values, "maxneckangle");
            return (Criteria) this;
        }

        public Criteria andMaxneckangleBetween(Float value1, Float value2) {
            addCriterion("maxneckangle between", value1, value2, "maxneckangle");
            return (Criteria) this;
        }

        public Criteria andMaxneckangleNotBetween(Float value1, Float value2) {
            addCriterion("maxneckangle not between", value1, value2, "maxneckangle");
            return (Criteria) this;
        }

        public Criteria andUsephonetimeIsNull() {
            addCriterion("usephonetime is null");
            return (Criteria) this;
        }

        public Criteria andUsephonetimeIsNotNull() {
            addCriterion("usephonetime is not null");
            return (Criteria) this;
        }

        public Criteria andUsephonetimeEqualTo(Float value) {
            addCriterion("usephonetime =", value, "usephonetime");
            return (Criteria) this;
        }

        public Criteria andUsephonetimeNotEqualTo(Float value) {
            addCriterion("usephonetime <>", value, "usephonetime");
            return (Criteria) this;
        }

        public Criteria andUsephonetimeGreaterThan(Float value) {
            addCriterion("usephonetime >", value, "usephonetime");
            return (Criteria) this;
        }

        public Criteria andUsephonetimeGreaterThanOrEqualTo(Float value) {
            addCriterion("usephonetime >=", value, "usephonetime");
            return (Criteria) this;
        }

        public Criteria andUsephonetimeLessThan(Float value) {
            addCriterion("usephonetime <", value, "usephonetime");
            return (Criteria) this;
        }

        public Criteria andUsephonetimeLessThanOrEqualTo(Float value) {
            addCriterion("usephonetime <=", value, "usephonetime");
            return (Criteria) this;
        }

        public Criteria andUsephonetimeIn(List<Float> values) {
            addCriterion("usephonetime in", values, "usephonetime");
            return (Criteria) this;
        }

        public Criteria andUsephonetimeNotIn(List<Float> values) {
            addCriterion("usephonetime not in", values, "usephonetime");
            return (Criteria) this;
        }

        public Criteria andUsephonetimeBetween(Float value1, Float value2) {
            addCriterion("usephonetime between", value1, value2, "usephonetime");
            return (Criteria) this;
        }

        public Criteria andUsephonetimeNotBetween(Float value1, Float value2) {
            addCriterion("usephonetime not between", value1, value2, "usephonetime");
            return (Criteria) this;
        }

        public Criteria andNeckAngleIsNull() {
            addCriterion("neck_angle is null");
            return (Criteria) this;
        }

        public Criteria andNeckAngleIsNotNull() {
            addCriterion("neck_angle is not null");
            return (Criteria) this;
        }

        public Criteria andNeckAngleEqualTo(String value) {
            addCriterion("neck_angle =", value, "neckAngle");
            return (Criteria) this;
        }

        public Criteria andNeckAngleNotEqualTo(String value) {
            addCriterion("neck_angle <>", value, "neckAngle");
            return (Criteria) this;
        }

        public Criteria andNeckAngleGreaterThan(String value) {
            addCriterion("neck_angle >", value, "neckAngle");
            return (Criteria) this;
        }

        public Criteria andNeckAngleGreaterThanOrEqualTo(String value) {
            addCriterion("neck_angle >=", value, "neckAngle");
            return (Criteria) this;
        }

        public Criteria andNeckAngleLessThan(String value) {
            addCriterion("neck_angle <", value, "neckAngle");
            return (Criteria) this;
        }

        public Criteria andNeckAngleLessThanOrEqualTo(String value) {
            addCriterion("neck_angle <=", value, "neckAngle");
            return (Criteria) this;
        }

        public Criteria andNeckAngleLike(String value) {
            addCriterion("neck_angle like", value, "neckAngle");
            return (Criteria) this;
        }

        public Criteria andNeckAngleNotLike(String value) {
            addCriterion("neck_angle not like", value, "neckAngle");
            return (Criteria) this;
        }

        public Criteria andNeckAngleIn(List<String> values) {
            addCriterion("neck_angle in", values, "neckAngle");
            return (Criteria) this;
        }

        public Criteria andNeckAngleNotIn(List<String> values) {
            addCriterion("neck_angle not in", values, "neckAngle");
            return (Criteria) this;
        }

        public Criteria andNeckAngleBetween(String value1, String value2) {
            addCriterion("neck_angle between", value1, value2, "neckAngle");
            return (Criteria) this;
        }

        public Criteria andNeckAngleNotBetween(String value1, String value2) {
            addCriterion("neck_angle not between", value1, value2, "neckAngle");
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
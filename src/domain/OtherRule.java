package domain;

public class OtherRule extends BusinessRule {

    private String sql;
    private int otherRuleID;

//getters and setters
    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public int getOtherRuleID() {
        return otherRuleID;
    }

    public void setOtherRuleID(int otherRuleID) {
        this.otherRuleID = otherRuleID;
    }

    @Override
    public String toString() {
        return "OtherRule{" +
                "sql='" + sql + '\'' +
                ", otherRuleID=" + otherRuleID +
                "} " + super.toString();
    }

//builds object
    public static final class Builder {
        protected String code;
        protected String name;
        protected String explanation;
        protected String mainTable;
        protected boolean insert;
        protected boolean update;
        protected boolean delete;
        protected boolean trigger;
        protected boolean constraint;
        protected String generatedCode;
        protected String errorCode;
        protected String affectedColumn;
        protected String example;
        protected int BusinessRuleID;
        private String sql;
        private int otherRuleID;

        private Builder() {
        }

        public static Builder buildOtherRule() {
            return new Builder();
        }

        public Builder setSql(String sql) {
            this.sql = sql;
            return this;
        }

        public Builder setOtherRuleID(int otherRuleID) {
            this.otherRuleID = otherRuleID;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setExplanation(String explanation) {
            this.explanation = explanation;
            return this;
        }

        public Builder setMainTable(String mainTable) {
            this.mainTable = mainTable;
            return this;
        }

        public Builder setInsert(boolean insert) {
            this.insert = insert;
            return this;
        }

        public Builder setUpdate(boolean update) {
            this.update = update;
            return this;
        }

        public Builder setDelete(boolean delete) {
            this.delete = delete;
            return this;
        }

        public Builder setTrigger(boolean trigger) {
            this.trigger = trigger;
            return this;
        }

        public Builder setConstraint(boolean constraint) {
            this.constraint = constraint;
            return this;
        }

        public Builder setGeneratedCode(String generatedCode) {
            this.generatedCode = generatedCode;
            return this;
        }

        public Builder setErrorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder setAffectedColumn(String affectedColumn) {
            this.affectedColumn = affectedColumn;
            return this;
        }

        public Builder setExample(String example) {
            this.example = example;
            return this;
        }

        public Builder setBusinessRuleID(int BusinessRuleID) {
            this.BusinessRuleID = BusinessRuleID;
            return this;
        }

        public OtherRule build() {
            OtherRule otherRule = new OtherRule();
            otherRule.setSql(sql);
            otherRule.setOtherRuleID(otherRuleID);
            otherRule.setCode(code);
            otherRule.setName(name);
            otherRule.setExplanation(explanation);
            otherRule.setMainTable(mainTable);
            otherRule.setInsert(insert);
            otherRule.setUpdate(update);
            otherRule.setDelete(delete);
            otherRule.setTrigger(trigger);
            otherRule.setConstraint(constraint);
            otherRule.setGeneratedCode(generatedCode);
            otherRule.setErrorCode(errorCode);
            otherRule.setAffectedColumn(affectedColumn);
            otherRule.setExample(example);
            otherRule.setBusinessRuleID(BusinessRuleID);
            return otherRule;
        }
    }
}

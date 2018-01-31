package domain;

public class interEntityCompareRule extends BusinessRule {

    private String otherTable;
    private String otherColumn;
    private String operator;
    private int interentityID;
//getters
    public String getOtherTable() {
        return otherTable;
    }

    public String getOtherColumn() {
        return otherColumn;
    }

    public String getOperator() {
        return operator;
    }

    public int getInterentityID() {
        return interentityID;
    }
    //setters
    public void setOtherTable(String otherTable) {
        this.otherTable = otherTable;
    }

    public void setOtherColumn(String otherColumn) {
        this.otherColumn = otherColumn;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setInterentityID(int interentityID) {
        this.interentityID = interentityID;
    }

    @Override
    public String toString() {
        return "interEntityCompareRule{" +
                "otherTable='" + otherTable + '\'' +
                ", otherColumn='" + otherColumn + '\'' +
                ", operator='" + operator + '\'' +
                ", interentityID=" + interentityID +
                "} " + super.toString();
    }
//builds the object
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
        private String otherTable;
        private String otherColumn;
        private String operator;
        private int interentityID;

        private Builder() {
        }

        public static Builder buildInterEntityCompareRule() {
            return new Builder();
        }

        public Builder setOtherTable(String otherTable) {
            this.otherTable = otherTable;
            return this;
        }

        public Builder setOtherColumn(String otherColumn) {
            this.otherColumn = otherColumn;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setOperator(String operator) {
            this.operator = operator;
            return this;
        }

        public Builder setInterentityID(int interentityID) {
            this.interentityID = interentityID;
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

        public interEntityCompareRule build() {
            interEntityCompareRule interEntityCompareRule = new interEntityCompareRule();
            interEntityCompareRule.setOtherTable(otherTable);
            interEntityCompareRule.setOtherColumn(otherColumn);
            interEntityCompareRule.setCode(code);
            interEntityCompareRule.setOperator(operator);
            interEntityCompareRule.setInterentityID(interentityID);
            interEntityCompareRule.setName(name);
            interEntityCompareRule.setExplanation(explanation);
            interEntityCompareRule.setMainTable(mainTable);
            interEntityCompareRule.setInsert(insert);
            interEntityCompareRule.setUpdate(update);
            interEntityCompareRule.setDelete(delete);
            interEntityCompareRule.setTrigger(trigger);
            interEntityCompareRule.setConstraint(constraint);
            interEntityCompareRule.setGeneratedCode(generatedCode);
            interEntityCompareRule.setErrorCode(errorCode);
            interEntityCompareRule.setAffectedColumn(affectedColumn);
            interEntityCompareRule.setExample(example);
            interEntityCompareRule.setBusinessRuleID(BusinessRuleID);
            return interEntityCompareRule;
        }
    }
}

package domain;

/**
 * The type Attribute compare rule.
 */
public class attributeCompareRule extends BusinessRule {


    // variables for the type attribute compare rule

    private String operator;
    private int value;
    private int attributeCompareRuleID;


    //getters
    //get the corresponding variable


    public String getOperator() {
        return operator;
    }


    public int getValue() {
        return value;
    }

    public int getAttributeCompareRuleID() {
        return attributeCompareRuleID;
    }

    //setters
    //set the corresponding variable


    public void setOperator(String operator) {
        this.operator = operator;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public void setAttributeCompareRuleID(int attributeCompareRuleID) {
        this.attributeCompareRuleID = attributeCompareRuleID;
    }

    //extends businessrule.toString()

    @Override
    public String toString() {
        return "attributeCompareRule{" +
                "operator='" + operator + '\'' +
                ", value=" + value +
                ", attributeCompareRuleID=" + attributeCompareRuleID +
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
        private String operator;
        private int value;
        private int attributeCompareRuleID;

        private Builder() {
        }

        public static Builder buildAttributeCompareRule() {
            return new Builder();
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setOperator(String operator) {
            this.operator = operator;
            return this;
        }

        public Builder setValue(int value) {
            this.value = value;
            return this;
        }

        public Builder setAttributeCompareRuleID(int attributeCompareRuleID) {
            this.attributeCompareRuleID = attributeCompareRuleID;
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

        public attributeCompareRule build() {
            attributeCompareRule attributeCompareRule = new attributeCompareRule();
            attributeCompareRule.setCode(code);
            attributeCompareRule.setOperator(operator);
            attributeCompareRule.setValue(value);
            attributeCompareRule.setAttributeCompareRuleID(attributeCompareRuleID);
            attributeCompareRule.setName(name);
            attributeCompareRule.setExplanation(explanation);
            attributeCompareRule.setMainTable(mainTable);
            attributeCompareRule.setInsert(insert);
            attributeCompareRule.setUpdate(update);
            attributeCompareRule.setDelete(delete);
            attributeCompareRule.setTrigger(trigger);
            attributeCompareRule.setConstraint(constraint);
            attributeCompareRule.setGeneratedCode(generatedCode);
            attributeCompareRule.setErrorCode(errorCode);
            attributeCompareRule.setAffectedColumn(affectedColumn);
            attributeCompareRule.setExample(example);
            attributeCompareRule.setBusinessRuleID(BusinessRuleID);
            return attributeCompareRule;
        }
    }
}
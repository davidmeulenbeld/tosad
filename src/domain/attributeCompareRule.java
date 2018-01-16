package domain;

public class attributeCompareRule extends BusinessRule {
    private String operator;
    private int value;


    public String getOperator() {
        return operator;
    }

    public int getValue() {
        return value;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "attributeCompareRule{" + "\n" +
                "operator='" + operator + '\'' + "\n" +
                ", value=" + value + "\n" +
                super.toString();
    }

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
        private String operator;
        private int value;

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

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setValue(int value) {
            this.value = value;
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

        public attributeCompareRule build() {
            attributeCompareRule attributeCompareRule = new attributeCompareRule();
            attributeCompareRule.insert = this.insert;
            attributeCompareRule.operator = this.operator;
            attributeCompareRule.errorCode = this.errorCode;
            attributeCompareRule.example = this.example;
            attributeCompareRule.code = this.code;
            attributeCompareRule.generatedCode = this.generatedCode;
            attributeCompareRule.value = this.value;
            attributeCompareRule.explanation = this.explanation;
            attributeCompareRule.name = this.name;
            attributeCompareRule.constraint = this.constraint;
            attributeCompareRule.affectedColumn = this.affectedColumn;
            attributeCompareRule.delete = this.delete;
            attributeCompareRule.update = this.update;
            attributeCompareRule.trigger = this.trigger;
            attributeCompareRule.mainTable = this.mainTable;
            return attributeCompareRule;
        }
    }
}
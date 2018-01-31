package domain;

public class tupleCompareRule extends BusinessRule {

    private String secondcolumn;

    private String operator;

    //getters and setters
    public String getSecondcolumn() {
        return secondcolumn;
    }

    public String getOperator() {
        return operator;
    }


    public void setSecondcolumn(String secondcolumn) {
        this.secondcolumn = secondcolumn;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }


    @Override
    public String toString() {
        return "tupleCompareRule{" +
                "operator='" + operator + '\'' +

                ", secondcolumn='" + secondcolumn + '\'' +
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
        private String secondcolumn;

        private String operator;

        private Builder() {
        }

        public static Builder buildTupleCompareRule() {
            return new Builder();
        }

        public Builder setSecondcolumn(String secondcolumn) {
            this.secondcolumn = secondcolumn;
            return this;
        }

        public Builder setOperator(String operator) {
            this.operator = operator;
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


        public tupleCompareRule build() {
            tupleCompareRule tupleCompareRule = new tupleCompareRule();
            tupleCompareRule.setSecondcolumn(secondcolumn);
            tupleCompareRule.setOperator(operator);
            tupleCompareRule.setCode(code);
            tupleCompareRule.setName(name);
            tupleCompareRule.setExplanation(explanation);
            tupleCompareRule.setMainTable(mainTable);
            tupleCompareRule.setInsert(insert);
            tupleCompareRule.setUpdate(update);
            tupleCompareRule.setDelete(delete);
            tupleCompareRule.setTrigger(trigger);
            tupleCompareRule.setConstraint(constraint);
            tupleCompareRule.setGeneratedCode(generatedCode);
            tupleCompareRule.setErrorCode(errorCode);
            tupleCompareRule.setAffectedColumn(affectedColumn);
            tupleCompareRule.setExample(example);

            return tupleCompareRule;
        }
    }
}

package domain;

public class interEntityCompareRule extends BusinessRule  {

    private String otherTable;
    private String otherColumn;
    private String operator;

    public String getOtherTable() {
        return otherTable;
    }

    public String getOtherColumn() {
        return otherColumn;
    }

    public String getOperator() {
        return operator;
    }

    public void setOtherTable(String otherTable) {
        this.otherTable = otherTable;
    }

    public void setOtherColumn(String otherColumn) {
        this.otherColumn = otherColumn;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "interEntityCompareRule{" +
                "operator='" + operator + '\'' +
                ", otherColumn='" + otherColumn + '\'' +
                ", otherTable='" + otherTable + '\'' +
                "} " + super.toString();
    }

    public static final class Builder {
        private String code;
        private String name;
        private String explanation;
        private String mainTable;
        private boolean insert;
        private boolean update;
        private boolean delete;
        private boolean trigger;
        private boolean constraint;
        private String generatedCode;
        private String errorCode;
        private String affectedColumn;
        private String example;
        private String otherTable;
        private String otherColumn;
        private String operator;

        private Builder() {
        }

        public static Builder aninterEntityCompareRule() {
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

        public interEntityCompareRule build() {
            interEntityCompareRule interEntityCompareRule = new interEntityCompareRule();
            interEntityCompareRule.setOtherTable(otherTable);
            interEntityCompareRule.setOtherColumn(otherColumn);
            interEntityCompareRule.setCode("ICMP");
            interEntityCompareRule.setOperator(operator);
            interEntityCompareRule.setName(name);
            interEntityCompareRule.setExplanation("The attribute value must be equal to, bigger,smaller,equal or bigger than or equal or smaller than an attribute in another table");
            interEntityCompareRule.setMainTable(mainTable);
            interEntityCompareRule.setInsert(insert);
            interEntityCompareRule.setUpdate(update);
            interEntityCompareRule.setDelete(delete);
            interEntityCompareRule.setTrigger(trigger);
            interEntityCompareRule.setConstraint(constraint);
            interEntityCompareRule.setGeneratedCode(generatedCode);
            interEntityCompareRule.setErrorCode(errorCode);
            interEntityCompareRule.setAffectedColumn(affectedColumn);
            interEntityCompareRule.setExample("delivery.registrydate must be equal to order.registrydate");
            return interEntityCompareRule;
        }
    }
}

package domain;

/**
 * The type Attribute compare rule.
 */
public class attributeCompareRule extends BusinessRule {


    // variables for the type attribute compare rule

    private String operator;
    private int value;


    //getters
    //get the corresponding variable



    public String getOperator() {
        return operator;
    }


    public int getValue() {
        return value;
    }

    //setters
    //set the corresponding variable


    public void setOperator(String operator) {
        this.operator = operator;
    }


    public void setValue(int value) {
        this.value = value;
    }



    //extends businessrule.toString()
    @Override
    public String toString() {
        return "attributeCompareRule{" + "\n" +
                "operator='" + operator + '\'' + "\n" +
                ", value=" + value + "\n" +
                super.toString();
    }

    /**
     * inner builder for type attributecomparerule
     *
     */
    public static final class Builder {
        //for variable information see corresponding class and businessrule


        private String name;

        private String mainTable;

        private boolean insert;

        private boolean update;

        private boolean delete;

        private boolean trigger;

        private boolean constraint;

        private String generatedCode;

        private String errorCode;

        private String affectedColumn;

        private String operator;
        private int value;

        private Builder() {
        }

        /**
         * Build attribute compare rule builder.
         *
         * @return the builder
         */
        public static Builder buildAttributeCompareRule() {
            return new Builder();
        }

        //builder setters
        // sets a piece of the complicated instance




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


        /**
         * Build attribute compare rule.
         *
         * @return an instance of attribute compare rule
         */
        public attributeCompareRule build() {
            attributeCompareRule attributeCompareRule = new attributeCompareRule();
            attributeCompareRule.insert = this.insert;
            attributeCompareRule.operator = this.operator;
            attributeCompareRule.errorCode = this.errorCode;
            attributeCompareRule.example = "Delivery.amount must be bigger than 1.";

            attributeCompareRule.code = "ACMP";
            attributeCompareRule.generatedCode = this.generatedCode;
            attributeCompareRule.value = this.value;
            attributeCompareRule.explanation = "The attribute value must be equal to," +
                    " bigger than, smaller than," +
                    " equal to or bigger, equal to or smaller than given value.";
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
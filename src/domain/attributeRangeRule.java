package domain;

/**
 * The type Attribute range rule.
 */
public class attributeRangeRule extends BusinessRule {

    //variables for the type attribute range rule

    private int rangeStart;
    private int rangeEnd;
    private boolean insideRange;

    //getters
    //get the corresponding variable

    public int getRangeStart() {
        return rangeStart;
    }


    public int getRangeEnd() {
        return rangeEnd;
    }


    public boolean isInsideRange() {
        return insideRange;
    }


    //setters
    //set the corresponding variable

    public void setRangeStart(int rangeStart) {
        this.rangeStart = rangeStart;
    }


    public void setRangeEnd(int rangeEnd) {
        this.rangeEnd = rangeEnd;
    }


    public void setInsideRange(boolean insideRange) {
        this.insideRange = insideRange;
    }


    //extends businessrule.toString()

    @Override
    public String toString() {
        return "attributeRangeRule{" + "\n" +
                "insideRange=" + insideRange + "\n" +
                ", rangeEnd=" + rangeEnd + "\n" +
                ", rangeStart=" + rangeStart + "\n"
                + super.toString();
    }

    /**
     * inner builder for type attributerangerule
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

     ;
        private int rangeStart;
        private int rangeEnd;
        private boolean insideRange;

        private Builder() {
        }

        /**
         * Anattribute range rule builder.
         *
         * @return the builder of attributerangerule
         */
        public static Builder anattributeRangeRule() {
            return new Builder();
        }


        //builder setters
        // sets a piece of the complicated instance



        public Builder setRangeStart(int rangeStart) {
            this.rangeStart = rangeStart;
            return this;
        }


        public Builder setName(String name) {
            this.name = name;
            return this;
        }


        public Builder setRangeEnd(int rangeEnd) {
            this.rangeEnd = rangeEnd;
            return this;
        }




        public Builder setInsideRange(boolean insideRange) {
            this.insideRange = insideRange;
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
         * Build attribute range rule.
         *
         * @return an instance of attribute range rule
         */
        public attributeRangeRule build() {
            attributeRangeRule attributeRangeRule = new attributeRangeRule();
            attributeRangeRule.insert = this.insert;
            attributeRangeRule.errorCode = this.errorCode;
            attributeRangeRule.example = "grade must be between 1 and 10";
            attributeRangeRule.code = "ARNG";
            attributeRangeRule.rangeStart = this.rangeStart;
            attributeRangeRule.generatedCode = this.generatedCode;
            attributeRangeRule.explanation = "The affected column must be in or out of the range";
            attributeRangeRule.name = this.name;
            attributeRangeRule.constraint = this.constraint;
            attributeRangeRule.affectedColumn = this.affectedColumn;
            attributeRangeRule.delete = this.delete;
            attributeRangeRule.update = this.update;
            attributeRangeRule.rangeEnd = this.rangeEnd;
            attributeRangeRule.trigger = this.trigger;
            attributeRangeRule.mainTable = this.mainTable;
            attributeRangeRule.insideRange = this.insideRange;
            return attributeRangeRule;
        }
    }
}


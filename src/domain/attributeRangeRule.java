package domain;

/**
 * The type Attribute range rule.
 */
public class attributeRangeRule extends BusinessRule {

    //variables for the type attribute range rule

    private int rangeStart;
    private int rangeEnd;
    private boolean insideRange;
    private int attributeRangeRuleID;

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

    public int getAttributeRangeRuleID() {
        return attributeRangeRuleID;
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

    public void setAttributeRangeRuleID(int attributeRangeRuleID) {
        this.attributeRangeRuleID = attributeRangeRuleID;
    }

//extends businessrule.toString()


    @Override
    public String toString() {
        return "attributeRangeRule{" +
                "rangeStart=" + rangeStart +
                ", rangeEnd=" + rangeEnd +
                ", insideRange=" + insideRange +
                ", attributeRangeRuleID=" + attributeRangeRuleID +
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
        private int rangeStart;
        private int rangeEnd;
        private boolean insideRange;
        private int attributeRangeRuleID;

        private Builder() {
        }
        /**
         * Anattribute range rule builder.
         *
         * @return the builder of attributerangerule
         */
        public static Builder buildAttributeRangeRule() {
            return new Builder();
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setRangeStart(int rangeStart) {
            this.rangeStart = rangeStart;
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

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAttributeRangeRuleID(int attributeRangeRuleID) {
            this.attributeRangeRuleID = attributeRangeRuleID;
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

        public attributeRangeRule build() {
            attributeRangeRule attributeRangeRule = new attributeRangeRule();
            attributeRangeRule.setCode(code);
            attributeRangeRule.setRangeStart(rangeStart);
            attributeRangeRule.setRangeEnd(rangeEnd);
            attributeRangeRule.setInsideRange(insideRange);
            attributeRangeRule.setName(name);
            attributeRangeRule.setExplanation(explanation);
            attributeRangeRule.setMainTable(mainTable);
            attributeRangeRule.setInsert(insert);
            attributeRangeRule.setUpdate(update);
            attributeRangeRule.setDelete(delete);
            attributeRangeRule.setTrigger(trigger);
            attributeRangeRule.setConstraint(constraint);
            attributeRangeRule.setGeneratedCode(generatedCode);
            attributeRangeRule.setErrorCode(errorCode);
            attributeRangeRule.setAffectedColumn(affectedColumn);
            attributeRangeRule.setExample(example);
            attributeRangeRule.setBusinessRuleID(BusinessRuleID);
            attributeRangeRule.attributeRangeRuleID = this.attributeRangeRuleID;
            return attributeRangeRule;
        }
    }
}


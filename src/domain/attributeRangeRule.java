package domain;

public class attributeRangeRule extends BusinessRule {

    private int rangeStart;
    private int rangeEnd;
    private boolean insideRange;


    public int getRangeStart() {
        return rangeStart;
    }

    public int getRangeEnd() {
        return rangeEnd;
    }

    public boolean isInsideRange() {
        return insideRange;
    }

    public void setRangeStart(int rangeStart) {
        this.rangeStart = rangeStart;
    }

    public void setRangeEnd(int rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    public void setInsideRange(boolean insideRange) {
        this.insideRange = insideRange;
    }

    @Override
    public String toString() {
        return "attributeRangeRule{" + "\n" +
                "insideRange=" + insideRange + "\n" +
                ", rangeEnd=" + rangeEnd + "\n" +
                ", rangeStart=" + rangeStart + "\n"
                + super.toString();
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
        private int rangeStart;
        private int rangeEnd;
        private boolean insideRange;

        private Builder() {
        }

        public static Builder anattributeRangeRule() {
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

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setRangeEnd(int rangeEnd) {
            this.rangeEnd = rangeEnd;
            return this;
        }

        public Builder setExplanation(String explanation) {
            this.explanation = explanation;
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

        public Builder setExample(String example) {
            this.example = example;
            return this;
        }

        public attributeRangeRule build() {
            attributeRangeRule attributeRangeRule = new attributeRangeRule();
            attributeRangeRule.insert = this.insert;
            attributeRangeRule.errorCode = this.errorCode;
            attributeRangeRule.example = this.example;
            attributeRangeRule.code = this.code;
            attributeRangeRule.rangeStart = this.rangeStart;
            attributeRangeRule.generatedCode = this.generatedCode;
            attributeRangeRule.explanation = this.explanation;
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


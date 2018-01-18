package domain;

public class attributeOtherRule extends BusinessRule{

    private String sql ;


    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "attributeOtherRule{" +
                "sql='" + sql + '\'' +
                "} " + super.toString();
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
        private String sql ;

        private Builder() {
        }

        public static Builder buildattributeOtherRule() {
            return new Builder();
        }

        public Builder setSql(String sql) {
            this.sql = sql;
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

        public attributeOtherRule build() {
            attributeOtherRule attributeOtherRule = new attributeOtherRule();
            attributeOtherRule.setSql(sql);
            attributeOtherRule.setCode(code);
            attributeOtherRule.setName(name);
            attributeOtherRule.setExplanation(explanation);
            attributeOtherRule.setMainTable(mainTable);
            attributeOtherRule.setInsert(insert);
            attributeOtherRule.setUpdate(update);
            attributeOtherRule.setDelete(delete);
            attributeOtherRule.setTrigger(trigger);
            attributeOtherRule.setConstraint(constraint);
            attributeOtherRule.setGeneratedCode(generatedCode);
            attributeOtherRule.setErrorCode(errorCode);
            attributeOtherRule.setAffectedColumn(affectedColumn);
            attributeOtherRule.setExample(example);
            return attributeOtherRule;
        }
    }
}

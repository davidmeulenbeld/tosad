package domain;


import java.util.List;

public class attributeListRule  extends BusinessRule{
    private List list ;
    private boolean inList;



    public List getList() {
        return list;
    }

    public boolean isInList() {
        return inList;
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
        private List list ;
        private boolean inList;

        private Builder() {
        }

        public static Builder buildAttributeListRule() {
            return new Builder();
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setList(List list) {
            this.list = list;
            return this;
        }

        public Builder setExplanation(String explanation) {
            this.explanation = explanation;
            return this;
        }

        public Builder setInList(boolean inList) {
            this.inList = inList;
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

        public attributeListRule build() {
            attributeListRule attributeListRule = new attributeListRule();
            attributeListRule.insert = this.insert;
            attributeListRule.inList = this.inList;
            attributeListRule.errorCode = this.errorCode;
            attributeListRule.example = this.example;
            attributeListRule.code = this.code;
            attributeListRule.list = this.list;
            attributeListRule.generatedCode = this.generatedCode;
            attributeListRule.explanation = this.explanation;
            attributeListRule.name = this.name;
            attributeListRule.constraint = this.constraint;
            attributeListRule.affectedColumn = this.affectedColumn;
            attributeListRule.delete = this.delete;
            attributeListRule.update = this.update;
            attributeListRule.trigger = this.trigger;
            attributeListRule.mainTable = this.mainTable;
            return attributeListRule;
        }
    }
}

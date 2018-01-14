package domain;

public  class BusinessRule {

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




    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getMainTable() {
        return mainTable;
    }

    public boolean isInsert() {
        return insert;
    }

    public boolean isUpdate() {
        return update;
    }

    public boolean isDelete() {
        return delete;
    }

    public boolean isTrigger() {
        return trigger;
    }

    public boolean isConstraint() {
        return constraint;
    }

    public String getGeneratedCode() {
        return generatedCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getAffectedColumn() {
        return affectedColumn;
    }

    public String getExample() {
        return example;
    }


    public static abstract class Builder<T extends BusinessRule> {

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

        public Builder<T> setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder<T> setName(String name) {
            this.name = name;
            return this;
        }

        public Builder<T> setExplanation(String explanation) {
            this.explanation = explanation;
            return this;
        }

        public Builder<T> setMainTable(String mainTable) {
            this.mainTable = mainTable;
            return this;
        }

        public Builder<T> setInsert(boolean insert) {
            this.insert = insert;
            return this;
        }

        public Builder<T> setUpdate(boolean update) {
            this.update = update;
            return this;
        }

        public Builder<T> setDelete(boolean delete) {
            this.delete = delete;
            return this;
        }

        public Builder<T> setTrigger(boolean trigger) {
            this.trigger = trigger;
            return this;
        }

        public Builder<T> setConstraint(boolean constraint) {
            this.constraint = constraint;
            return this;
        }

        public Builder<T> setGeneratedCode(String generatedCode) {
            this.generatedCode = generatedCode;
            return this;
        }

        public Builder<T> setErrorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder<T> setAffectedColumn(String affectedColumn) {
            this.affectedColumn = affectedColumn;
            return this;
        }

        public Builder<T> setExample(String example) {
            this.example = example;
            return this;
        }

        public abstract T build();

    }
        public static Builder<?> builder(){
            return new Builder<BusinessRule>(){
                @Override
                public  BusinessRule build(){
                    return new BusinessRule(this);
                }
            };
        }

        protected BusinessRule(Builder<?> builder){
            this.code = builder.code;
            this.name = builder.name;
            this.explanation = builder.explanation;
            this.mainTable = builder.mainTable;
            this.insert = builder.insert;
            this.update = builder.update;
            this.delete = builder.delete;
            this.trigger = builder.trigger;
            this.constraint = builder.constraint;
            this.generatedCode = builder.generatedCode;
            this.errorCode = builder.errorCode;
            this.affectedColumn = builder.affectedColumn;
            this.example = builder.example;
        }



    @Override
    public String toString() {
        return
                ", code='" + code + '\'' + "\n" +
                        ", name='" + name + '\'' + "\n" +
                        ", explanation='" + explanation + '\'' + "\n" +
                        ", mainTable='" + mainTable + '\'' + "\n" +
                        ", insert=" + insert + "\n" +
                        ", update=" + update + "\n" +
                        ", delete=" + delete + "\n" +
                        ", trigger=" + trigger + "\n" +
                        ", constraint=" + constraint + "\n" +
                        ", generatedCode='" + generatedCode + '\'' + "\n" +
                        ", errorCode='" + errorCode + '\'' + "\n" +
                        ", affectedColumn='" + affectedColumn + '\'' + "\n" +
                        ", example='" + example + '\'' + "\n" +
                        '}';
    }
}

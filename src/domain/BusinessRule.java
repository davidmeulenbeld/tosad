package domain;

public abstract class BusinessRule<B extends BusinessRule.Builder<B>> {

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

    public BusinessRule(Builder<B> builder) {
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
    }


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

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setMainTable(String mainTable) {
        this.mainTable = mainTable;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public void setTrigger(boolean trigger) {
        this.trigger = trigger;
    }

    public void setConstraint(boolean constraint) {
        this.constraint = constraint;
    }

    public void setGeneratedCode(String generatedCode) {
        this.generatedCode = generatedCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setAffectedColumn(String affectedColumn) {
        this.affectedColumn = affectedColumn;
    }

    abstract static class Builder<B extends BusinessRule.Builder<B>>{

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

        public B setCode(String code) {
            this.code = code;
            return (B)this;
        }

        public B setName(String name) {
            this.name = name;
            return (B)this;
        }

        public B setExplanation(String explanation) {
            this.explanation = explanation;
            return (B)this;
        }

        public B setMainTable(String mainTable) {
            this.mainTable = mainTable;
            return (B)this;
        }

        public B setInsert(boolean insert) {
            this.insert = insert;
            return (B)this;
        }

        public B setUpdate(boolean update) {
            this.update = update;
            return (B)this;
        }

        public B setDelete(boolean delete) {
            this.delete = delete;
            return (B)this;
        }

        public B setTrigger(boolean trigger) {
            this.trigger = trigger;
            return (B)this;
        }

        public B setConstraint(boolean constraint) {
            this.constraint = constraint;
            return (B)this;
        }

        public B setGeneratedCode(String generatedCode) {
            this.generatedCode = generatedCode;
            return (B)this;
        }

        public B setErrorCode(String errorCode) {
            this.errorCode = errorCode;
            return (B)this;
        }

        public Builder setAffectedColumn(String affectedColumn) {
            this.affectedColumn = affectedColumn;
            return this;
        }

        abstract BusinessRule<B> build ();


    }

    @Override
    public String toString() {
        return "BusinessRule{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", explanation='" + explanation + '\'' +
                ", mainTable='" + mainTable + '\'' +
                ", insert=" + insert +
                ", update=" + update +
                ", delete=" + delete +
                ", trigger=" + trigger +
                ", constraint=" + constraint +
                ", generatedCode='" + generatedCode + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", affectedColumn='" + affectedColumn + '\'' +
                '}';
    }
}

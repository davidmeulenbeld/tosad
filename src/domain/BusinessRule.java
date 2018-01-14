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

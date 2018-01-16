package domain;

public class BusinessRule {

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

    public void setExample(String example) {
        this.example = example;
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

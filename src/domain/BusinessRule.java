package domain;


/**
 * The type Business rule.
 */
public class BusinessRule {

    /**
     * the type of business rule
     */
    protected String code;
    /**
     * The name that is generated by another class
     */
    protected String name;
    /**
     * a short explanation of how that type of business rule works
     */
    protected String explanation;
    /**
     * The table which is affected by the business rule
     */
    protected String mainTable;
    /**
     * checks if trigger needs to happen on insert
     */
    protected boolean insert;
    /**
     * checks if trigger needs to happen on update
     */
    protected boolean update;
    /**
     * checks if trigger needs to happen delete
     */
    protected boolean delete;
    /**
     * checks if it is a trigger
     */
    protected boolean trigger;
    /**
     * check if its a constraint
     */
    protected boolean constraint;
    /**
     * here goes the PL/SQL code that is generated by the corresponding generator
     */
    protected String generatedCode;
    /**
     * the error message that shows up when the business rule raises an application error
     */
    protected String errorCode;
    /**
     * The column that is affected by the business rule
     */
    protected String affectedColumn;
    /**
     * an example of how the business rule works
     */
    protected String example;

    protected int BusinessRuleID;


    // GETTERS
    // returns corresponding variable


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

    public int getBusinessRuleID() {
        return BusinessRuleID;
    }

//setters
    // set the corresponding variable to given value


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

    public void setBusinessRuleID(int businessRuleID) {
        BusinessRuleID = businessRuleID;
    }

// generates overview of instance


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
                ", example='" + example + '\'' +
                ", BusinessRuleID='" + BusinessRuleID + '\'' +
                '}';
    }
}

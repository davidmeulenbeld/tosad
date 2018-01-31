package domain;


import java.util.ArrayList;

/**
 * The type Attribute list rule.
 */
public class attributeListRule extends BusinessRule {
    private ArrayList<String> list;
    private boolean inList;
    private int attributeListRuleID;


    //getters
    //get the corresponding variable


    public ArrayList<String> getList() {
        return list;
    }

    public boolean isInList() {
        return inList;
    }

    public int getAttributeListRuleID() {
        return attributeListRuleID;
    }

    //setters
    //set the corresponding variable


    public void setList(ArrayList<String> list) {
        this.list = list;
    }


    public void setInList(boolean inList) {
        this.inList = inList;

    }

    public void setAttributeListRuleID(int attributeListRuleID) {
        this.attributeListRuleID = attributeListRuleID;
    }

    //extends businessrule.toString()

    @Override
    public String toString() {
        return "attributeListRule{" +
                "list=" + list +
                ", inList=" + inList +
                ", attributeListRuleID=" + attributeListRuleID +
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
        private ArrayList<String> list;
        private boolean inList;
        private int attributeListRuleID;

        private Builder() {
        }

        public static Builder buildAttributeListRule() {
            return new Builder();
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setList(ArrayList<String> list) {
            this.list = list;
            return this;
        }

        public Builder setInList(boolean inList) {
            this.inList = inList;
            return this;
        }

        public Builder setAttributeListRuleID(int attributeListRuleID) {
            this.attributeListRuleID = attributeListRuleID;
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

        public Builder setBusinessRuleID(int BusinessRuleID) {
            this.BusinessRuleID = BusinessRuleID;
            return this;
        }

        public attributeListRule build() {
            attributeListRule attributeListRule = new attributeListRule();
            attributeListRule.setCode(code);
            attributeListRule.setList(list);
            attributeListRule.setInList(inList);
            attributeListRule.setAttributeListRuleID(attributeListRuleID);
            attributeListRule.setName(name);
            attributeListRule.setExplanation(explanation);
            attributeListRule.setMainTable(mainTable);
            attributeListRule.setInsert(insert);
            attributeListRule.setUpdate(update);
            attributeListRule.setDelete(delete);
            attributeListRule.setTrigger(trigger);
            attributeListRule.setConstraint(constraint);
            attributeListRule.setGeneratedCode(generatedCode);
            attributeListRule.setErrorCode(errorCode);
            attributeListRule.setAffectedColumn(affectedColumn);
            attributeListRule.setExample(example);
            attributeListRule.setBusinessRuleID(BusinessRuleID);
            return attributeListRule;
        }
    }
}

package domain;


import java.util.ArrayList;
import java.util.List;

/**
 * The type Attribute list rule.
 */
public class attributeListRule extends BusinessRule {
    private ArrayList<String> list;
    private boolean inList;


    //getters
    //get the corresponding variable


    public ArrayList<String> getList() {
        return list;
    }

    public boolean isInList() {
        return inList;
    }

    //setters
    //set the corresponding variable


    public void setList(ArrayList<String> list) {
        this.list = list;
    }


    public void setInList(boolean inList) {
        this.inList = inList;

    }
    //extends businessrule.toString()
    @Override
    public String toString() {
        return "attributeListRule{" +
                "inList=" + inList +
                ", list=" + list +
                "} " + super.toString();
    }
    /**
     * inner builder for type attributelistrule
     *
     */
    public static final class Builder {
        //for variable information see corresponding class and businessrule


        private String code;

        private String name;

        private String explanation;

        private String mainTable;

        private boolean insert;

        private boolean update;

        private boolean delete;

        private boolean trigger;

        private boolean constraint;

        private String generatedCode;

        private String errorCode;

        private String affectedColumn;

        private String example;
        private ArrayList<String> list;
        private boolean inList;

        private Builder() {
        }

        /**
         * Build attribute list rule builder.
         *
         * @return the builder
         */
        public static Builder buildAttributeListRule() {
            return new Builder();
        }


        //builder setters
        // sets a piece of the complicated instance


        public Builder setCode(String code) {
            this.code = code;
            return this;
        }


        public Builder setName(String name) {
            this.name = name;
            return this;
        }


        public Builder setList(ArrayList<String> list) {
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

        /**
         * Build attribute list rule.
         *
         * @return an instance attribute list rule
         */
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

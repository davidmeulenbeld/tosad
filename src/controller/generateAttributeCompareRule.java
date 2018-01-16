package controller;


import domain.attributeCompareRule;


public class generateAttributeCompareRule {
    generalControllerFunctions gtws = new generalControllerFunctions();

    public String decideTypeGeneratedAttrComp(attributeCompareRule compareRule) {
        String result = "";
        if (compareRule.isConstraint()) {
            result = createAttributeCompareRuleConstraint(compareRule);
        }
        if (compareRule.isTrigger()) {
            result = createAttributeCompareRuleTrigger(compareRule);

        }
        return result;
    }

    public String createAttributeCompareRuleTrigger(attributeCompareRule compareRule) {
        String basestring = "Create or replace trigger ";
        basestring += compareRule.getName() + "\n"
                + gtws.generateTriggerWhenString(compareRule.isInsert(), compareRule.isDelete(), compareRule.isUpdate(), compareRule.getMainTable(), compareRule.getAffectedColumn());

        basestring += "declare" + "\n" +
                "value number := " + compareRule.getValue() + ";" + "\n";
        basestring += "begin" + "\n" +
                "if " + compareRule.getAffectedColumn() + " " + compareRule.getOperator() + " value then" + " \n";
        basestring += "raise_application_error(-20010,'" + compareRule.getErrorCode() + "');" + "\n"
                + "end if;" + "\n"
                + "end;";

        return basestring;
    }

    public String createAttributeCompareRuleConstraint(attributeCompareRule compareRule) {

        String basestring = "alter table ";

        basestring += compareRule.getMainTable() + "\n";
        basestring += "add constraint " + compareRule.getName() + " check " + compareRule.getAffectedColumn() + " "
                + compareRule.getOperator() + " " + compareRule.getValue();
        return basestring;


    }

}
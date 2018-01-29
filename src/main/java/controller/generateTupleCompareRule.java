package main.java.controller;

import main.java.domain.tupleCompareRule;

public class generateTupleCompareRule {

    private generalControllerFunctions gtws = new generalControllerFunctions();

    public tupleCompareRule decideTypeGeneratedAttrComp(tupleCompareRule compareRule) {
        String result = "";
        if (compareRule.isConstraint()) {
            result = createTupleCompareRuleConstraint(compareRule);
        }
        if (compareRule.isTrigger()) {
            result = createTupleCompareRuleTrigger(compareRule);

        }
        compareRule.setGeneratedCode(result);
        return compareRule;
    }

    public String createTupleCompareRuleTrigger(tupleCompareRule compareRule) {
        String basestring = "Create or replace trigger ";
        basestring += compareRule.getName() + "\n"
                + gtws.generateTriggerWhenString(compareRule.isInsert(), compareRule.isDelete(), compareRule.isUpdate(), compareRule.getMainTable(), compareRule.getAffectedColumn());

        basestring += "begin" + "\n" +
                "if " + compareRule.getAffectedColumn() + " " + compareRule.getOperator() + compareRule.getSecondcolumn() + " then" + " \n";
        basestring += "raise_application_error(-20050,'" + compareRule.getErrorCode() + "');" + "\n"
                + "end if;" + "\n"
                + "end;";

        return basestring;
    }

    public String createTupleCompareRuleConstraint(tupleCompareRule compareRule) {

        String basestring = "alter table ";

        basestring += compareRule.getMainTable() + "\n";
        basestring += "add constraint " + compareRule.getName() + " check (" + compareRule.getAffectedColumn() + " "
                + compareRule.getOperator() + " " + compareRule.getSecondcolumn() + ");";
        return basestring;


    }
}

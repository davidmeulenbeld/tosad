package controller;

import domain.interEntityCompareRule;

public class generateinterentityrule {

    private generalControllerFunctions gtws = new generalControllerFunctions();

    public interEntityCompareRule decideTypeGeneratedIEcomp(interEntityCompareRule compareRule) {
        String result = "";
        if (compareRule.isConstraint()) {
            result = createinterentityRuleConstraint(compareRule);
        }
        if (compareRule.isTrigger()) {
            result = createinterentityRuleTrigger(compareRule);

        }
        compareRule.setGeneratedCode(result);
        return compareRule;
    }
    public String createinterentityRuleTrigger(interEntityCompareRule compareRule) {
        String basestring = "Create or replace trigger ";
        basestring += compareRule.getName() + "\n"
                + gtws.generateTriggerWhenString(compareRule.isInsert(), compareRule.isDelete(), compareRule.isUpdate(), compareRule.getMainTable(), compareRule.getAffectedColumn());
        basestring += "begin " + "\n" +
                "if " +compareRule.getMainTable()+"."+ compareRule.getAffectedColumn() + " " + compareRule.getOperator() + compareRule.getOtherTable()+"."+compareRule.getOtherColumn()+" then" + " \n";
        basestring += "raise_application_error(-20040,'" + compareRule.getErrorCode() + "');" + "\n"
                + "end if;" + "\n"
                + "end;";

        return basestring;
    }
    public String createinterentityRuleConstraint(interEntityCompareRule compareRule) {

        String basestring = "alter table ";

        basestring += compareRule.getMainTable() + "\n";
        basestring += "add constraint " + compareRule.getName() + " check ("
                +compareRule.getMainTable()+"."+ compareRule.getAffectedColumn() + " " + compareRule.getOperator()
                + compareRule.getOtherTable()+"."+compareRule.getOtherColumn()+ ");";
        return basestring;


    }
}

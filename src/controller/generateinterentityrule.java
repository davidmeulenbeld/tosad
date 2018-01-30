package controller;

import domain.interEntityCompareRule;

/**
 * The Controller Generate inter entity rule.
 */
public class generateinterentityrule {

    private generalControllerFunctions gtws = new generalControllerFunctions();

    /**
     * Decide type generated inter entity compare inter entity compare rule.
     *
     * @param compareRule the compare rule
     * @return the inter entity compare rule
     */
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

    /**
     * Create interentity rule trigger .
     *
     * @param compareRule the compare rule
     * @return the string
     */
    public String createinterentityRuleTrigger(interEntityCompareRule compareRule) {
        String basestring = "Create or replace trigger ";
        basestring += compareRule.getName() + "\n"
                + gtws.generateTriggerWhenString(compareRule.isInsert(), compareRule.isDelete(), compareRule.isUpdate(), compareRule.getMainTable(), compareRule.getAffectedColumn());
        basestring += "begin " + "\n" +
                "if " + compareRule.getMainTable() + "." + compareRule.getAffectedColumn() + " " + compareRule.getOperator() + compareRule.getOtherTable() + "." + compareRule.getOtherColumn() + " then" + " \n";
        basestring += "raise_application_error(-20040,'" + compareRule.getErrorCode() + "');" + "\n"
                + "end if;" + "\n"
                + "end;";

        return basestring;
    }

    /**
     * Create interentity rule constraint .
     *
     * @param compareRule the compare rule
     * @return the string
     */
    public String createinterentityRuleConstraint(interEntityCompareRule compareRule) {

        String basestring = "alter table ";

        basestring += compareRule.getMainTable() + "\n";
        basestring += "add constraint " + compareRule.getName() + " check ("
                + compareRule.getMainTable() + "." + compareRule.getAffectedColumn() + " " + compareRule.getOperator()
                + compareRule.getOtherTable() + "." + compareRule.getOtherColumn() + ");";
        return basestring;


    }
}

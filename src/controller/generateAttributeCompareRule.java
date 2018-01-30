package controller;


import domain.attributeCompareRule;


/**
 * The controller Generate attribute compare rule.
 */
public class generateAttributeCompareRule {
    /**
     * declaration of general control functions
     */
    private generalControllerFunctions gtws = new generalControllerFunctions();

    /**
     * Decide type generated of  attribute compare string.
     *
     * returns object
     * for now returns a string
     * @param compareRule the compare rule
     * @return compareRule
     */
    public attributeCompareRule decideTypeGeneratedAttrComp(attributeCompareRule compareRule) {
        String result = "";
        //checks if rule is constraint or trigger and calls the corresponding function
        if (compareRule.isConstraint()) {
            result = createAttributeCompareRuleConstraint(compareRule);
        }
        if (compareRule.isTrigger()) {
            result = createAttributeCompareRuleTrigger(compareRule);

        }
        //sets generatedcode of attributecomparerule
        compareRule.setGeneratedCode(result);
        return compareRule;
    }

    /**
     * Create attribute compare rule trigger.

     * @param compareRule the compare rule
     * @return generated code
     */
    public String createAttributeCompareRuleTrigger(attributeCompareRule compareRule) {
        String basestring = "Create or replace trigger ";
        basestring += compareRule.getName() + "\n"
                + gtws.generateTriggerWhenString(compareRule.isInsert(), compareRule.isDelete(), compareRule.isUpdate(), compareRule.getMainTable(), compareRule.getAffectedColumn());


        basestring += "begin" + "\n" +
                "if " + compareRule.getAffectedColumn() + " " + compareRule.getOperator() + " " + compareRule.getValue() +"  then" + " \n";
        basestring += "raise_application_error(-20010,'" + compareRule.getErrorCode() + "');" + "\n"
                + "end if;" + "\n"
                + "end;";

        return basestring;
    }

    /**
     * Create attribute compare rule constraint .

     * @param compareRule the compare rule
     * @return generated code
     */
    public String createAttributeCompareRuleConstraint(attributeCompareRule compareRule) {

        String basestring = "alter table ";

        basestring += compareRule.getMainTable() + "\n";
        basestring += "add constraint " + compareRule.getName() + " check (" + compareRule.getAffectedColumn() + " "
                + compareRule.getOperator() + " " + compareRule.getValue()+ ");";
        return basestring;


    }

}
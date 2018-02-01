package controller;

import domain.attributeRangeRule;


/**
 * The controller Generate attribute range rule.
 */
public class generateAttributeRangeRule {
    /**
     *
     * declaration of general control functions
     */
    private generalControllerFunctions gtws = new generalControllerFunctions();

    /**
     * Decide type generated attribute range attribute range rule.
     *
     * @param rangeRule the range rule
     * @return the attribute range rule
     */
    public attributeRangeRule decideTypeGeneratedAttrRang(attributeRangeRule rangeRule) {
        String result = "";

        if (rangeRule.isConstraint()) {
            result = createAttributeRangeRuleConstraint(rangeRule);
        }
        if (rangeRule.isTrigger()) {
            result = createAttributeRangeRuleTrigger(rangeRule);
        }
        rangeRule.setGeneratedCode(result);
        return rangeRule;

    }

    /**
     * Create attribute range rule trigger
     *
     * @param rangeRule the range rule
     * @return the string
     */
    public String createAttributeRangeRuleTrigger(attributeRangeRule rangeRule) {
        String baseString = "create trigger ";
        baseString += rangeRule.getName() + " \n";
        baseString += gtws.generateTriggerWhenString(rangeRule.isInsert(), rangeRule.isDelete(), rangeRule.isUpdate(), rangeRule.getMainTable(), rangeRule.getAffectedColumn()) + "\n";
        baseString += " begin \n";
        baseString += "if " + rangeRule.getAffectedColumn() + " between " + rangeRule.getRangeStart() + " and " + rangeRule.getRangeEnd() + " then \n";
        baseString += "raise_application_error(-20030,'" + rangeRule.getErrorCode() + "');";
        return baseString;
    }

    /**
     * Create attribute range rule constraint
     *
     * @param rangeRule the range rule
     * @return the string
     */
    public String createAttributeRangeRuleConstraint(attributeRangeRule rangeRule) {
        String constraint = "ALTER TABLE ";
        constraint += rangeRule.getMainTable();
        constraint += " add constraint " + rangeRule.getName() + " check (" + rangeRule.getAffectedColumn() + " BETWEEN "
                + rangeRule.getRangeStart() + " AND " + rangeRule.getRangeEnd() + ");";
        return constraint;
    }

}
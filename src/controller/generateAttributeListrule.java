package controller;

import domain.attributeListRule;

import java.util.ArrayList;


/**
 * The controller Generate attribute listrule.
 */
public class generateAttributeListrule {

    /**
     * declaration of general control functions
     */
    private generalControllerFunctions gtws = new generalControllerFunctions();

    /**
     * Decide type generated of attribute list rule.
     *
     *  returns a string
     *
     * @param listRule the list rule
     * @return listRule
     */
    public attributeListRule decideTypeGeneratedAttrList(attributeListRule listRule) {
        String result = "";
        if (listRule.isConstraint()) {
            result = createAttributeListRuleConstraint(listRule);
        }
        if (listRule.isTrigger()) {
            result = createAttributeListRuleTrigger(listRule);

        }
        listRule.setGeneratedCode(result);
        return listRule;
    }

    /**
     * Create attribute list rule trigger .
     *
     * @param listRule the list rule
     * @return generated code
     */
    public String createAttributeListRuleTrigger(attributeListRule listRule) {
        String basestring = "Create or replace trigger ";
        basestring += listRule.getName() + "\n"
                + gtws.generateTriggerWhenString(listRule.isInsert(), listRule.isDelete(), listRule.isUpdate(), listRule.getMainTable(), listRule.getAffectedColumn());
        basestring += "begin \n";
        basestring += generateStringfromlistForTrigger(listRule);
        basestring += "then raise_application_error(-20020,'" + listRule.getErrorCode() + "'); \n";
        basestring += "end if; \n";
        basestring += "end;";
        return basestring;
    }

    /**
     * Create attribute list rule constraint .
     *
     * @param listRule the list rule
     * @return generated code
     */
    public String createAttributeListRuleConstraint(attributeListRule listRule) {
        String basestring = "alter table ";

        basestring += listRule.getMainTable() + "\n";
        basestring += "add constraint " + listRule.getName() + "\n";
        basestring += "check( " + listRule.getAffectedColumn();
        if (listRule.isInList()) {
            basestring += " in ";

        } else {
            basestring = " not in ";
        }

        basestring += " (" + generateStringfromlistForConstraint(listRule);

        return basestring;
    }


    /**
     * Generates a string of a list for triggers .
     *
     * @param listRule the list rule
     * @return the string
     */
    public String generateStringfromlistForTrigger(attributeListRule listRule) {
        ArrayList<String> list = listRule.getList();
        String basestring = "if ";
        int counter = 0;
        String operator;
        if (listRule.isInList()) {
            operator = " = ";

        } else {
            operator = " != ";
        }
        for (String i : list) {
            if (counter > 0) {
                basestring += "or ";

            }
            basestring += listRule.getAffectedColumn() + operator + "'" + i + "'" + "\n";
            counter++;
        }
        return basestring;

    }

    /**
     * Generate a string of a list for constraints .
     *
     * @param listRule the list rule
     * @return the string
     */
    public String generateStringfromlistForConstraint(attributeListRule listRule) {
        String basestring = "";
        ArrayList<String> list = listRule.getList();
        int counter = 0;

        for (String i : list) {
            if (counter > 0) {
                basestring += ", ";

            }
            basestring += "'" + i + "'";
            counter++;
        }
        basestring += "));";
        return basestring;

    }
}

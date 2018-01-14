package controller;

import domain.BusinessRule;
import domain.attributeCompareRule;
import controller.getTriggerWhenString;

public class generateAttributeCompareRule {
    getTriggerWhenString gtws = new getTriggerWhenString();


    public String createAttributeCompareRule(attributeCompareRule compareRule){
        String basestring = "Create or replace trigger ";
        basestring += compareRule.getName() + "\n"

        + gtws.generateTriggerWhenString(compareRule.isInsert(),compareRule.isDelete(),compareRule.isUpdate(),compareRule.getMainTable(),compareRule.getAffectedColumn());
        return basestring;
    }


}

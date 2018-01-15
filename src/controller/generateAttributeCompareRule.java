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

        basestring += "declare" + "\n"+
                "value number := "+ compareRule.getValue()+";";
        basestring += "begin" + "\n"+
                "if "+ compareRule.getAffectedColumn()+ " "+ compareRule.getOperator() + "value then"+" \n";
        basestring += "raise_application_error(-20010,'"+compareRule.getErrorCode()+"');"+"\n"
                + "end if;"+ "\n"
                + "end;";

        return basestring;
    }


}
package controller;

import domain.attributeListRule;

import java.util.ArrayList;
import java.util.List;

public class generateAttributeListrule {

generalControllerFunctions gtws = new generalControllerFunctions();

    public String decideTypeGeneratedAttrList(attributeListRule listRule){
        String result = "";
        if(listRule.isConstraint()){
            result = createAttributeListRuleConstraint(listRule);
        }
        if(listRule.isTrigger()){
            result = createAttributeListRuleTrigger(listRule);

        }
        return result;
    }

    public String createAttributeListRuleTrigger(attributeListRule listRule){
        String basestring = "Create or replace trigger ";
        basestring += listRule.getName() + "\n"
                + gtws.generateTriggerWhenString(listRule.isInsert(),listRule.isDelete(),listRule.isUpdate(),listRule.getMainTable(),listRule.getAffectedColumn());
        basestring += "begin \n";
        basestring += generateStringfromlist(listRule);
        basestring += "then raise_application_error(-20020,'"+listRule.getErrorCode()+"'); \n";
        basestring += "end if; \n";
        basestring += "end;";
        return basestring;
    }
    public String createAttributeListRuleConstraint(attributeListRule listRule){

        String basestring = "alter table ";


        return basestring;
    }


    public String generateStringfromlist(attributeListRule listRule){
        ArrayList<String> list = listRule.getList();
        String basestring = "if ";
        int counter = 0;
        String operator ;
        if (listRule.isInList()){
            operator = " = ";

        }
        else {
            operator = " != ";
        }
        for (String i: list){
            if(counter > 0){
                basestring += "or ";

            }
           basestring += listRule.getAffectedColumn() +  operator + "'"+ i+ "'"+"\n";
        counter++;
        }
        return basestring;

    }
}

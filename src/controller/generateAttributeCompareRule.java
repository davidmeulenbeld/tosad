package controller;

import domain.attributeCompareRule;

public class generateAttributeCompareRule {

    public generateAttributeCompareRule() {
    }

    public void createAttributeCompareRule(attributeCompareRule compareRule){
        String basestring = "Create or replace trigger";
        basestring += compareRule.getName() + "\n"
        + "before";

    }


}

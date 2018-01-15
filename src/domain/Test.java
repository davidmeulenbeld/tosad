package domain;

import  controller.generateAttributeCompareRule;

import static domain.attributeCompareRule.Builder.buildAttributeCompareRule;

public class Test {

    public static void main(String args[]){
        generateAttributeCompareRule gacr = new generateAttributeCompareRule();


        attributeCompareRule ac = buildAttributeCompareRule()
                .setName("gerry")
                .setInsert(false)
                .setDelete(true)
                .setUpdate(true)
                .setMainTable("testt")
                .setAffectedColumn("test")
                .setValue(20)
                .setOperator(">")
                .setErrorCode("errorcode").build();

        String result = gacr.createAttributeCompareRuleTrigger(ac);

        System.out.println(result);

    }
}

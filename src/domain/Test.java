package domain;

import  controller.generateAttributeCompareRule;

import static domain.attributeCompareRule.Builder.buildAttributeCompareRule;

public class Test {

    public static void main(String args[]){
        generateAttributeCompareRule gacr = new generateAttributeCompareRule();


        attributeCompareRule ac = buildAttributeCompareRule().setName("gerry").setInsert(false).setDelete(true).setUpdate(true).setMainTable("testt").setAffectedColumn("test").build();

        String result = gacr.createAttributeCompareRule(ac);

        System.out.println(result);

    }
}

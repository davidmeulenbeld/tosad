package domain;

import  controller.generateAttributeCompareRule;

public class Test {

    public static void main(String args[]){
        generateAttributeCompareRule gacr = new generateAttributeCompareRule();

        BusinessRule ar = new attributeRangeRule.Builder<>().setInsideRange(true).build();
        attributeCompareRule ac = attributeCompareRule.builder()

        gacr.createAttributeCompareRule(ac);
        System.out.println(ar);

    }
}

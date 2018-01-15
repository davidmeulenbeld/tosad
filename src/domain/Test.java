package domain;

import  controller.generateAttributeCompareRule;
import  controller.generateAttributeListrule;
import java.util.ArrayList;
import java.util.List;

import static domain.attributeCompareRule.Builder.buildAttributeCompareRule;
import static domain.attributeListRule.Builder.buildAttributeListRule;

public class Test {

    public static void main(String args[]){
        generateAttributeCompareRule gacr = new generateAttributeCompareRule();
        generateAttributeListrule gal = new generateAttributeListrule();
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        attributeCompareRule ac = buildAttributeCompareRule()
                .setName("geerry")
                .setInsert(false)
                .setDelete(true)
                .setUpdate(true)
                .setMainTable("testt")
                .setAffectedColumn("test")
                .setValue(20)
                .setOperator(">")
                .setConstraint(false)
                .setTrigger(true)
                .setErrorCode("errorcode").build();
        attributeListRule al = buildAttributeListRule()
                .setName("listrule")
                .setList(list)
                .setErrorCode("ërrorcode")
                .setInsert(true)
                .setDelete(true)
                .setUpdate(true)
                .setMainTable("testtt")
                .setAffectedColumn("testssteg")
                .setInList(false)
                .setTrigger(true)
                .setConstraint(false)
                .build();
        String trigger = gacr.decideTypeGeneratedAttrComp(ac);
        String constraint = gal.createAttributeListRuleTrigger(al);

        System.out.println("trigger------------------------------");
        System.out.println(trigger);
        System.out.println("constraint---------------------------");
        System.out.println(constraint);
        System.out.println("decided-------------------------------");
       // System.out.println(decidedtype);

    }
}

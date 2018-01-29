package domain;

import controller.generateAttributeCompareRule;
import controller.generateAttributeListrule;
import dao.BaseDAO;

import services.BusinessRuleService;
import dao.getTableNamesDAO;

import java.util.ArrayList;
import java.util.List;

import dao.implementBusinesRuleDAO;


import static domain.attributeCompareRule.Builder.buildAttributeCompareRule;
import static domain.attributeListRule.Builder.buildAttributeListRule;

public class Test {

    public static void main(String args[]) {
        generateAttributeCompareRule gacr = new generateAttributeCompareRule();
        generateAttributeListrule gal = new generateAttributeListrule();
        getTableNamesDAO gtn = new getTableNamesDAO();
        implementBusinesRuleDAO ibr = new implementBusinesRuleDAO();


        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        attributeCompareRule ac = buildAttributeCompareRule()
                .setName("testtrigger")
                .setInsert(true)
                .setDelete(true)
                .setUpdate(true)
                .setMainTable("MOVIE")
                .setAffectedColumn("PRICE")
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
        attributeCompareRule trigger = gacr.decideTypeGeneratedAttrComp(ac);
        String constraint = gal.createAttributeListRuleTrigger(al);

        System.out.println("trigger------------------------------");
        System.out.println(trigger);
        System.out.println("constraint---------------------------");
        System.out.println(constraint);
        System.out.println("decided-------------------------------");
        // System.out.println(decidedtype);
        System.out.println(ibr.checkIsActive(51));

        // BusinessRuleService brs = new BusinessRuleService();


       // BusinessRuleService brs = new BusinessRuleService();
        System.out.println(gtn.getTableNames());
        //brs.getBusinessRules();

    }
}

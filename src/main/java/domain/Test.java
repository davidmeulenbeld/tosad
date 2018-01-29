package main.java.domain;

import main.java.controller.generateAttributeCompareRule;
import main.java.controller.generateAttributeListrule;
import main.java.dao.BaseDAO;

import main.java.services.BusinessRuleService;
import main.java.dao.getTableNamesDAO;

import java.util.ArrayList;
import java.util.List;

import main.java.dao.implementBusinesRuleDAO;


import static main.java.domain.attributeCompareRule.Builder.buildAttributeCompareRule;
import static main.java.domain.attributeListRule.Builder.buildAttributeListRule;

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
        ibr.implementBusinessRule(ac.getGeneratedCode(), ac.getBusinessRuleID());
        // BusinessRuleService brs = new BusinessRuleService();


        BusinessRuleService brs = new BusinessRuleService();

        brs.getBusinessRules();

    }
}

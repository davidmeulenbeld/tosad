package domain;

import controller.generateAttributeCompareRule;
import controller.generateAttributeListrule;

import dao.getTableNamesDAO;

import java.util.ArrayList;


import dao.implementBusinesRuleDAO;
import services.BusinessRuleService;


import static domain.attributeCompareRule.Builder.buildAttributeCompareRule;
import static domain.attributeListRule.Builder.buildAttributeListRule;

public class Test {

    public static void main(String args[]) {
        generateAttributeCompareRule gacr = new generateAttributeCompareRule();
        generateAttributeListrule gal = new generateAttributeListrule();
        getTableNamesDAO gtn = new getTableNamesDAO();


         BusinessRuleService brs = new BusinessRuleService();
        System.out.println(gtn.getTableNames());
        brs.getBusinessRules();

    }
}

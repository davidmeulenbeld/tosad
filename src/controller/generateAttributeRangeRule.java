package controller;

import domain.attributeRangeRule;
import domain.BusinessRule;

public class generateAttributeRangeRule {
	
	//generalControllerFunctions gtws = new generalControllerFunctions();
	
	public String decideTypeGeneratedAttrRang(attributeRangeRule rule) { 
		String result;
		
		if (rule.isConstraint()) {
			result = createAttributeRangeRuleConstraint(rule);
		}
		else {
			result = createAttributeRangeRuleTrigger(rule);
		}
		
		return result;
		
	}
	
	public String createAttributeRangeRuleTrigger(attributeRangeRule rule) {
		String trigger = "CREATE OR REPLACE TRIGGER";
		gtws.generateTriggerWhenString(compareRule.isInsert(), compareRule.isDelete(), compareRule.isUpdate(), compareRule.getMainTable(), compareRule.getAffectedColumn());
		return trigger;
	}
	
	public String createAttributeRangeRuleConstraint(attributeRangeRule rule) {
		String constraint = "ALTER TABLE";
		constraint += rule.getMainTable();
		constraint += "add constraint " + rule.getName() + " check " + rule.getAffectedColumn() + " BETWEEN "
                + rule.getRangeStart() + " AND " + rule.getRangeEnd();
		return constraint;
	}

}

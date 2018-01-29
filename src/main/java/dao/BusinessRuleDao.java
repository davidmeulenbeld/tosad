package dao;

import domain.BusinessRule;
import java.util.List;

public interface BusinessRuleDao {
    public List<BusinessRule> getAllBusinessRules();
    public BusinessRule getBusinessRule(String code);
    public void getBusinessRule (BusinessRule br);
    public void setBusinessRule (BusinessRule br);
}
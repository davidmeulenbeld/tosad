package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The Data Access for Implementing business rules
 */
public class implementBusinessRuleDAO extends BaseDAO {

    /**
     * Instantiates a new Implement business rule dao.
     * executes pl/sql code in target database which is given
     * updates the rule in tool database
     * @param generatedCode  to be implemented code
     * @param businessRuleID the business rule id
     */
    public implementBusinessRuleDAO(String generatedCode, int businessRuleID) {
        if (!checkIsActive(businessRuleID)) {
            try {
                Connection con = getTargetConnection();

                Statement stmt = con.createStatement();

                stmt.executeUpdate(generatedCode);

                this.updateActiveBusinessRule(businessRuleID);
                this.updateGeneratedCode(generatedCode, businessRuleID);
                System.out.println("BusinessRule Implemented");
                con.close();
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }
    }

    /**
     * Check is active boolean.
     *
     * @param businessRuleID the business rule id
     * @return the boolean
     */
    public boolean checkIsActive(int businessRuleID) {

        boolean active = false;

        try {
            String baseStatement = "select actief from TOSAD_2017_2C_TEAM3.businessrule " +
                    "where id_businessrule = " + businessRuleID;
            Connection con = getToolConnection();
            Statement stmt = con.createStatement();
            ResultSet RS = stmt.executeQuery(baseStatement);

            while (RS.next()) {
                if (RS.getInt("actief") == 1) {
                    active = true;
                }
            }


        } catch (Exception exc) {
            System.out.println(exc);
        }
        return active;
    }

    /**
     * Update active business rule.
     *
     * @param businessRuleID the business rule id
     */
    public void updateActiveBusinessRule(int businessRuleID) {

        try {
            String baseStatement = "update TOSAD_2017_2C_TEAM3.businessrule set actief = 1" +
                    " where id_businessrule = " + businessRuleID;
            Connection con = getToolConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(baseStatement);

            con.close();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    /**
     * Update generated code.
     *
     * @param generatedCode  the generated code
     * @param businessRuleID the business rule id
     */
    public void updateGeneratedCode(String generatedCode, int businessRuleID) {
        try {
            generatedCode = generatedCode.replaceAll("'", "''");
            String baseStatement = "update TOSAD_2017_2C_TEAM3.businessrule set generatedcode = '" + generatedCode +
                    "' where id_businessrule = " + businessRuleID;
            System.out.println(baseStatement);
            Connection con = getToolConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(baseStatement);

            con.close();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}

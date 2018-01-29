package main.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class implementBusinesRuleDAO extends BaseDAO {

    public void implementBusinessRule(String generatedCode, int businessRuleID) {
        if (!checkIsActive(businessRuleID)) {
            try {
                Connection con = BaseDAO.getTargetConnection();

                Statement stmt = con.createStatement();

                stmt.executeUpdate(generatedCode);

                System.out.println("BusinessRule Implemented");
                con.close();
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }
    }

    public boolean checkIsActive(int businessRuleID) {

        boolean active = false;

        try {
            String baseStatement = "select actief from TOSAD_2017_2C_TEAM3.businessrule " +
                    "where id_businessrule = " + businessRuleID;
            Connection con = super.getToolConnection();
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

    public void updateActiveBusinessRule(int businessRuleID) {

        try {
            String baseStatement = "update TOSAD_2017_2C_TEAM3.businessrule set actief = 1" +
                    " where id_businessrule = " + businessRuleID;
            Connection con = BaseDAO.getToolConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(baseStatement);

            con.close();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}

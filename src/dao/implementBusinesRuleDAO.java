package dao;

import java.sql.Connection;
import java.sql.Statement;

public class implementBusinesRuleDAO extends BaseDAO{

        public void implementBusinessRule(String generatedCode,int businessRuleID) {

            try{
                Connection con = BaseDAO.getTargetConnection();

                Statement stmt = con.createStatement();

                stmt.executeUpdate(generatedCode);

                System.out.println("BusinessRule Implemented");
                con.close();
            }

            catch (Exception exc){
                System.out.println(exc);
            }

        }
        public void updateActiveBusinessRule(int businessRuleID){

          try {
              String baseStatement = "update TOSAD_2017_2C_TEAM3.businessrule set actief = 1" +
                      " where id_businessrule = "+businessRuleID;
              Connection con = BaseDAO.getToolConnection();
              Statement stmt = con.createStatement();
              stmt.executeUpdate(baseStatement);

              con.close();
          }
          catch (Exception exc){
              System.out.println(exc);
          }
        }
}

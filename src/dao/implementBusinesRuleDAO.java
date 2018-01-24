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
            }
            catch (Exception exc){
                System.out.println(exc);
            }

        }
}

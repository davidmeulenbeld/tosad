package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class getTableNamesDAO extends BaseDAO {



    public ArrayList<String> getTableNames() {
        ArrayList<String> tables = new ArrayList<String>();
        try {
            Connection conn = getTargetConnection();

            Statement stmt = conn.createStatement();

            ResultSet RS = stmt.executeQuery(" SELECT table_name as tablename  from all_tables where owner = 'TOSAD_2017_2C_TEAM3_TARGET' " +
                    " and not table_name =  'HTMLDB_PLAN_TABLE'");
            String tablename;
            while (RS.next()) {
                tablename = RS.getString("tablename");
                tables.add(tablename);
            }
            conn.close();

        } catch (Exception exc) {

        }
        return tables;
    }
}

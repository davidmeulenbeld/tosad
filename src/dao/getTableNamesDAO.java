package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * The Data acces for getting tablenames
 * extends baseDAO for connection
 */
public class getTableNamesDAO extends BaseDAO {


    /**
     * Gets table names.
     *
     * @return the table names
     */
    public ArrayList<String> getTableNames() {
        ArrayList<String> tables = new ArrayList<String>();
        try {
            //get connection to target database and create statement
            Connection conn = getTargetConnection();

            Statement stmt = conn.createStatement();
            // gets all tablenames from target db/schema
            ResultSet RS = stmt.executeQuery(" SELECT table_name as tablename  from all_tables where owner = 'TOSAD_2017_2C_TEAM3_TARGET' " +
                    " and not table_name =  'HTMLDB_PLAN_TABLE'");
            String tablename;
            //looping tablenames and writing it to a list
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

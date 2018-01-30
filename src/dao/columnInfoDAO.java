package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import domain.column;


/**
 * The Data acces for getting column info
 * extends Base DAO for connection
 */
public class columnInfoDAO extends BaseDAO {

    /**
     * Describe given table
     *
     * @param table the table
     * @return the list of columns and info about
     */
    public List<column> describeTable(String table) {
        List<column> columns = new ArrayList<column>();
        try {
            //get connection to target database and create statement
            Connection conn = getTargetConnection();

            Statement stmt = conn.createStatement();

            String columnname;
            String columntype;

            //getting metadata from all tables
            DatabaseMetaData dbm = conn.getMetaData();
            // refining query
            ResultSet rs = dbm.getColumns(null, "%", table, "%");
            // looping columns and adding info to an object and adding it to a list
            while (rs.next()) {

                columnname = rs.getString("COLUMN_NAME");
                columntype = rs.getString("TYPE_NAME");
                column column = new column(columnname, columntype);
                columns.add(column);
            }

            conn.close();

        } catch (Exception exc) {
            System.out.println(exc);
        }
        return columns;
    }


}

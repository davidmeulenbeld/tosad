package main.java.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.java.domain.attributeRangeRule;
import main.java.domain.column;


public class columnInfoDAO extends BaseDAO {

    public List<column> describeTable(String table) {
        List<column> columns = new ArrayList<column>();
        try {
            Connection conn = getTargetConnection();

            Statement stmt = conn.createStatement();

            String columnname;
            String columntype;


            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet rs = dbm.getColumns(null, "%", table, "%");
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

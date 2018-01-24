package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BaseDAO {
    private DataSource connectionPool;

    public BaseDAO() {

    }
    public static Connection getTargetConnection(){
        final String url = "jdbc:oracle:thin:@//ondora02.hu.nl:8521/cursus02.hu.nl";
        final String user = "tosad_2017_2c_team3_target";
        final String password = "tosad_2017_2c_team3_target";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("CONNECTIE");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
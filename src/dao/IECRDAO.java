package dao;

import domain.attributeRangeRule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IECRDAO extends BaseDAO{


    public attributeRangeRule getenoughinfotogenerate(int id){
        generaldaofunctions gdf = new generaldaofunctions();
        try(Connection con = getToolConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select a.name, a.maintable, a.insertbr,a.updatebr," +
                    "a.deletebr,a.triggerbr,a.constraintbr,a.errorcode,a.affectedcolumn from businessrule a,blabla b" +
                    "where a.id_businessrule = "+ id +" and b.id_businessrule = "+id);

            //get columns
            String name = rs.getString("name");
            String maintable = rs.getString("maintable");
            boolean insertbr = gdf.istrue(rs.getInt("insertbr"));
            boolean updatebr = gdf.istrue(rs.getInt("updatebr"));
            boolean deletebr = gdf.istrue(rs.getInt("deletebr"));
            boolean triggerbr = gdf.istrue(rs.getInt("triggerbr"));
            boolean constraintbr = gdf.istrue(rs.getInt("constraintbr"));
            String errorcode = rs.getString("errorcode");
            String affectedcolumn = rs.getString("affectedcolumn");


            //build

            //return object
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
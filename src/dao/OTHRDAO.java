package dao;

import domain.OtherRule;
import domain.attributeRangeRule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static domain.OtherRule.Builder.buildOtherRule;

public class OTHRDAO extends BaseDAO{


    public OtherRule getenoughinfotogenerate(int id){
        generaldaofunctions gdf = new generaldaofunctions();
        OtherRule or = new OtherRule();
        try(Connection con = getToolConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select a.name, a.maintable, a.insertbr,a.updatebr," +
                    "a.deletebr,a.triggerbr,a.constraintbr,a.errorcode,a.affectedcolumn,b.sql_code from businessrule a,otherrule b" +
                    " where a.id_businessrule = "+ id +" and b.id_businessrule = "+id);

            //get columns
            while (rs.next()) {
                String name = rs.getString("name");
                String maintable = rs.getString("maintable");
                boolean insert = gdf.istrue(rs.getInt("insertbr"));
                boolean update = gdf.istrue(rs.getInt("updatebr"));
                boolean delete = gdf.istrue(rs.getInt("deletebr"));
                boolean trigger = gdf.istrue(rs.getInt("triggerbr"));
                boolean constraint = gdf.istrue(rs.getInt("constraintbr"));
                String errorcode = rs.getString("errorcode");
                String affectedcolumn = rs.getString("affectedcolumn");
                String sqlcode = rs.getString("sql_code");
                OtherRule other = buildOtherRule()
                        .setName(name)
                        .setGeneratedCode(sqlcode)
                        .setMainTable(maintable)
                        .setAffectedColumn(affectedcolumn)
                        .setInsert(insert)
                        .setDelete(delete)
                        .setUpdate(update)
                        .setConstraint(constraint)
                        .setTrigger(trigger)
                        .setErrorCode(errorcode)
                        .setSql(sqlcode)
                        .build();

                //build
                or = other;
                //return object
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return or;
    }
}
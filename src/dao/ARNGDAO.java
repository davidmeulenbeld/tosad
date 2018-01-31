package dao;

import domain.attributeRangeRule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import dao.generaldaofunctions;
import static domain.attributeRangeRule.Builder.buildAttributeRangeRule;
public class ARNGDAO extends BaseDAO{


    public attributeRangeRule getenoughinfotogenerate(int id){
        attributeRangeRule at = new attributeRangeRule();
        generaldaofunctions gdf = new generaldaofunctions();
        try(Connection con = getToolConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select a.name, a.maintable, a.insertbr,a.updatebr," +
                    "a.deletebr,a.triggerbr,a.constraintbr,a.errorcode,a.affectedcolumn, b.rangestart,b.rangeend,b.insiderange from businessrule a,attributerangerule b " +
                    "where a.id_businessrule = "+ id +" and b.id_businessrule = "+id);

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
                int rangestart = rs.getInt("rangestart");
                int rangeend = rs.getInt("rangeend");
                boolean insiderange = gdf.istrue(rs.getInt("insiderange"));

                attributeRangeRule atrr = buildAttributeRangeRule()
                        .setName(name)
                        .setRangeStart(rangestart)
                        .setRangeEnd(rangeend)
                        .setMainTable(maintable)
                        .setInsideRange(insiderange)
                        .setAffectedColumn(affectedcolumn)
                        .setInsert(insert)
                        .setDelete(delete)
                        .setUpdate(update)
                        .setTrigger(trigger)
                        .setConstraint(constraint)
                        .setErrorCode(errorcode)
                        .build();

                //build
                at = atrr;
            }
            //return object
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return at;
    }
}

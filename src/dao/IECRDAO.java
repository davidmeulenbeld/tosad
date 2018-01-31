package dao;

import domain.attributeRangeRule;
import domain.interEntityCompareRule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static domain.interEntityCompareRule.Builder.buildInterEntityCompareRule;

public class IECRDAO extends BaseDAO{


    public interEntityCompareRule getenoughinfotogenerate(int id){
        generaldaofunctions gdf = new generaldaofunctions();
        interEntityCompareRule iec = new interEntityCompareRule();
        try(Connection con = getToolConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select a.name, a.maintable, a.insertbr,a.updatebr," +
                    "a.deletebr,a.triggerbr,a.constraintbr,a.errorcode,a.affectedcolumn,b.secondaffectedtable,b.secondaffectedcolumn,b.operator from businessrule a,interentitycomparerule b" +
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
                String secondcolumn = rs.getString("secondaffectedcolumn");
                String secondtable = rs.getString("secondaffectedtable");
                String operator = rs.getString("operator");


                //build
                interEntityCompareRule iecr = buildInterEntityCompareRule()
                        .setName(name)
                        .setOtherColumn(secondcolumn)
                        .setOtherTable(secondtable)
                        .setOperator(operator)
                        .setMainTable(maintable)
                        .setAffectedColumn(affectedcolumn)
                        .setInsert(insert)
                        .setDelete(delete)
                        .setUpdate(update)
                        .setTrigger(trigger)
                        .setConstraint(constraint)
                        .setErrorCode(errorcode)
                        .build();
                iec = iecr;
                //return object
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return iec;
    }
}
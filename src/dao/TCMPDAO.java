package dao;

import domain.attributeRangeRule;
import domain.tupleCompareRule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static domain.tupleCompareRule.Builder.buildTupleCompareRule;

public class TCMPDAO extends BaseDAO{


    public tupleCompareRule getenoughinfotogenerate(int id){
        generaldaofunctions gdf = new generaldaofunctions();
        tupleCompareRule tcm = new tupleCompareRule();
        try(Connection con = getToolConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select a.name, a.maintable, a.insertbr,a.updatebr," +
                    "a.deletebr,a.triggerbr,a.constraintbr,a.errorcode,a.affectedcolumn from businessrule a,tuplecomparerule b" +
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
                String operator = rs.getString("operator");
                tupleCompareRule tcr = buildTupleCompareRule()
                        .setName(name)
                        .setSecondcolumn(secondcolumn)
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
                //build
                tcm = tcr;
                //return object
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return tcm;
    }
}
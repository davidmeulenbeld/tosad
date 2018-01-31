package dao;

import domain.attributeCompareRule;
import domain.attributeRangeRule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static domain.attributeCompareRule.Builder.buildAttributeCompareRule;

public class ACMPDAO extends BaseDAO{


    public attributeCompareRule getenoughinfotogenerate(int id){
        generaldaofunctions gdf = new generaldaofunctions();
        attributeCompareRule acmp = new attributeCompareRule();
        try(Connection con = getToolConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select a.name, a.maintable, a.insertbr,a.updatebr," +
                    "a.deletebr,a.triggerbr,a.constraintbr,a.errorcode,a.affectedcolumn,b.operator,b.valuebr from businessrule a,attributecomparerule b" +
                    " where a.id_businessrule = "+ id +" and b.id_businessrule = "+id);

            //get columns
            while (rs.next()){
            String name = rs.getString("name");
            String maintable = rs.getString("maintable");
            boolean insert = gdf.istrue(rs.getInt("insertbr"));
            boolean update = gdf.istrue(rs.getInt("updatebr"));
            boolean delete = gdf.istrue(rs.getInt("deletebr"));
            boolean trigger = gdf.istrue(rs.getInt("triggerbr"));
            boolean constraint = gdf.istrue(rs.getInt("constraintbr"));
            String errorcode = rs.getString("errorcode");
            String affectedcolumn = rs.getString("affectedcolumn");
            int value = rs.getInt("valuebr");
            String operator = rs.getString("operator");



            attributeCompareRule acr = buildAttributeCompareRule()
                    .setName(name)
                    .setMainTable(maintable)
                    .setAffectedColumn(affectedcolumn)
                    .setInsert(insert)
                    .setUpdate(update)
                    .setDelete(delete)
                    .setOperator(operator)
                    .setValue(value)
                    .setTrigger(trigger)
                    .setConstraint(constraint)
                    .setErrorCode(errorcode)
                    .build();
                acmp = acr;
            //return object
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return acmp;
    }
}
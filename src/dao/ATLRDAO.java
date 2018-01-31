package dao;

import domain.attributeListRule;
import domain.attributeRangeRule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static domain.attributeListRule.Builder.buildAttributeListRule;

public class ATLRDAO extends BaseDAO{


    public attributeListRule getenoughinfotogenerate(int id){
        generaldaofunctions gdf = new generaldaofunctions();
        attributeListRule altr = new attributeListRule();
        try(Connection con = getToolConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select a.name, a.maintable, a.insertbr,a.updatebr," +
                    "a.deletebr,a.triggerbr,a.constraintbr,a.errorcode,a.affectedcolumn,b.inlist,b.stringvalue from businessrule a,attributelistrule b" +
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
                boolean inlist = gdf.istrue(rs.getInt("inlist"));
                String stringvalue = rs.getString("stringvalue");

                ArrayList<String> list = new ArrayList<>();
                list.addAll(Arrays.asList(stringvalue.split(":")));

                attributeListRule atlr = buildAttributeListRule()
                        .setName(name)
                        .setMainTable(maintable)
                        .setAffectedColumn(affectedcolumn)
                        .setInsert(insert)
                        .setUpdate(update)
                        .setDelete(delete)
                        .setInList(inlist)
                        .setList(list)
                        .setTrigger(trigger)
                        .setConstraint(constraint)
                        .setErrorCode(errorcode)
                        .build();

                altr = atlr;
                //build
            }
            //return object
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return altr;
    }
}
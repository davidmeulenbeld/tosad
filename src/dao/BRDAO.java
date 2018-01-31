package dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class BRDAO extends BaseDAO{

     public ArrayList<ArrayList> getinactivecode(){

         ArrayList<ArrayList> listofbr = new ArrayList<ArrayList>();
         try(Connection con = getToolConnection()){

             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id_businessrule,type,actief from businessrule");
             while (rs.next()){
                 Object id = rs.getInt("id_businessrule");
                 Object type = rs.getString("type");
                 int actief = rs.getInt("actief");
                 if (actief != 1) {
                     ArrayList<Object> br = new ArrayList<Object>();
                     br.add(id);
                     br.add(type);
                     listofbr.add(br);
                 }
             }
         }

             catch(Exception exc){
                exc.printStackTrace();

         }
         return listofbr;
     }

}

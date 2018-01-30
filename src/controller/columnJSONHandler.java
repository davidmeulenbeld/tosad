package controller;




import dao.columnInfoDAO;
import domain.column;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * controller for columnhandler
 * this class generates a JSON Array when given a table map
 * It doesnt work with a string don't ask why
 */
public class columnJSONHandler  {

    /**
     * declaration of the DAO class which handles getting column info from the target database
     */
    columnInfoDAO cidao = new columnInfoDAO();

    /**
     * method that generates a JSON Array which contains information about the given table
     *
     * @param table the table which needs to be described
     * @return JSONArray of all columns in the target table and their type
     * Examples of types : Varchar2, Number, Date
     * @throws IOException needs to be thrown otherwise errors alot of errors
     */
    public JSONObject colummJSONHandle(Map table) throws IOException {

        //initialization
        JSONArray arr = new JSONArray();
        JSONObject job = new JSONObject();
        HashMap<String, JSONObject> map = new HashMap<String, JSONObject>();
        Object tablename = table.get("table");
        System.out.println(tablename);
        // describe table

        List<column> columns = cidao.describeTable(String.valueOf(tablename));
        //can iterate over 1 thing so an extra iterator to keep track

        int iterator=0;
        try{
        for (column c:columns){
            iterator++;
            //constructing the json object
            JSONObject json = new JSONObject();
            json.put("name",c.getName());
            json.put("type",c.getType());
            //putting it in a map
            map.put("json"+iterator,json);
            //getting value out of map and setting it in the array
            arr.put(map.get("json"+iterator));

        }
        job.put("columns",arr);

        System.out.println(arr);
        }
        catch (Exception exc){

        }
        return job;
    }
}

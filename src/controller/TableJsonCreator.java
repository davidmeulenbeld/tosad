package controller;


import dao.getTableNamesDAO;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.HashMap;
import java.util.List;

/**
 * Controller for tableHandler
 * this class generates a JSON Array of all tables in the targetdatabase
 */
public class TableJsonCreator {

    /**
     * declaration of the DAO class which handles getting tablenames from the target database
     */
    getTableNamesDAO gtdao = new getTableNamesDAO();

    /**
     * method that generates a JSON Array which contains all tablenames
     *
     * @return JSONArray of all tables
     */
    public JSONObject convertToJSON(){

        //initialization
        JSONArray arr = new JSONArray();
        HashMap<String, JSONObject> map = new HashMap<>();
        JSONObject job = new JSONObject();
        //get tables
        List<String> tables =gtdao.getTableNames();
        //can only iterate 1 thing so an extra iterator to keep track
        int iterator=0;
        try{
            for (String t: tables){
                iterator++;
                //constructing the JSON object
                JSONObject json = new JSONObject();
                json.put("tablename",t);
                //putting it in map
                map.put("json"+iterator,json);
                //getting value out of map and setting it in the array
                arr.put(map.get("json"+iterator));
            }
            job.put("tables",arr);
        System.out.println(arr);}
            catch (Exception exc){


            }
            return job;
        }
    }


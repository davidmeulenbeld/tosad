package controller;


import dao.getTableNamesDAO;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.HashMap;
import java.util.List;

public class TableJsonCreator {

    getTableNamesDAO gtdao = new getTableNamesDAO();
    public JSONArray convertToJSON(){

        JSONArray arr = new JSONArray();
        HashMap<String, JSONObject> map = new HashMap<>();
        List<String> tables =gtdao.getTableNames();
        int iterator=0;
        try{
            for (String t: tables){
                iterator++;
                JSONObject json = new JSONObject();
                json.put("tablename",t);
                map.put("json"+iterator,json);
                arr.put(map.get("json"+iterator));
            }
        System.out.println(arr);}
            catch (Exception exc){


            }
            return arr;
        }
    }


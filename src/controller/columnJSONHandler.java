package controller;




import dao.columnInfoDAO;
import domain.column;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class columnJSONHandler  {

columnInfoDAO cidao = new columnInfoDAO();

    public JSONArray colummJSONHandle(Map table) throws IOException {
        JSONArray arr = new JSONArray();
        HashMap<String, JSONObject> map = new HashMap<String, JSONObject>();
        Object tablename = table.get("table");
        System.out.println(tablename);
        List<column> columns = cidao.describeTable(String.valueOf(tablename));
        int iterator=0;
        try{
        for (column c:columns){
            iterator++;
            JSONObject json = new JSONObject();
            json.put("name",c.getName());
            json.put("type",c.getType());
            map.put("json"+iterator,json);
            arr.put(map.get("json"+iterator));

        }


        System.out.println(arr);
        }
        catch (Exception exc){

        }
        return arr;
    }
}

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
    public String convertToJSON(){

        //initialization
        String baseString ="";

        List<String> tables =gtdao.getTableNames();
        //can only iterate 1 thing so an extra iterator to keep track

        try{
            for (String t: tables){
            baseString += t + ";";
        }}
            catch (Exception exc){


            }
            baseString = baseString.substring(0,baseString.length()-1);
            return baseString;
        }
    }


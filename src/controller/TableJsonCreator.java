package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.getTableNamesDAO;

import java.util.ArrayList;
import java.util.List;

public class TableJsonCreator {

    public String convertToJSON(){
        Gson gsonBuilder = new GsonBuilder().create();
        getTableNamesDAO gtdao = new getTableNamesDAO();
        List<String> tablenamelist = gtdao.getTableNames();
        System.out.println(tablenamelist);
        return gsonBuilder.toJson(tablenamelist);
    }
}

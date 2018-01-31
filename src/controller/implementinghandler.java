package controller;

import dao.implementBusinessRuleDAO;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class implementinghandler {

    public void implementintoDB(ArrayList<ArrayList> codes){

        for (ArrayList i: codes){
            String a = i.get(0).toString();
            int b = (int) i.get(1);
            implementBusinessRuleDAO imbd = new implementBusinessRuleDAO(a,b);
        }
    }
}

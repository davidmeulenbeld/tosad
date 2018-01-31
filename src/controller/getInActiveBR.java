package controller;

import dao.ACMPDAO;
import dao.ARNGDAO;
import dao.BRDAO;
import domain.attributeCompareRule;
import domain.attributeRangeRule;

import java.util.ArrayList;

public class getInActiveBR {

    ArrayList<String> gettoimplementcode(){
        ArrayList<String> codes = new ArrayList<>();
        BRDAO brdao = new BRDAO();
       ArrayList<ArrayList> brs = brdao.getinactivecode();

       for(ArrayList ar:brs){
         String type = ar.get(1).toString();
           int id = (int) (ar.get(0));
         switch(type.toUpperCase()){

             case("ATTRIBUTERANGERULE"):
                 ARNGDAO adao = new ARNGDAO();

                 attributeRangeRule arng = adao.getenoughinfotogenerate (id);
                 generateAttributeRangeRule garr = new generateAttributeRangeRule();
                 arng  = garr.decideTypeGeneratedAttrRang(arng);
                 codes.add(arng.getGeneratedCode());
                 break;
             case("ATTRIBUTECOMPARERULE"):
                ACMPDAO atdao = new ACMPDAO();
                 attributeCompareRule acmp = atdao.getenoughinfotogenerate(id);
                 generateAttributeCompareRule gacr = new generateAttributeCompareRule();
                 acmp = gacr.decideTypeGeneratedAttrComp(acmp);
                 codes.add(acmp.getGeneratedCode());
                 break;
             case("ATTRIBUTELISTRULE"):

                 break;
             case("INTERENTITYCOMPARERULE"):

                 break;
             case("OTHERRULE"):

                 break;
             case("TUPLECOMPARERULE"):

                 break;
         }
       }

    }
}

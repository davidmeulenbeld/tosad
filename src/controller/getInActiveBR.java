package controller;

import dao.*;
import domain.*;

import java.util.ArrayList;

public class getInActiveBR {

   public  ArrayList<ArrayList> gettoimplementcode(){
        ArrayList<ArrayList> codesandid = new ArrayList<>();
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
                 Object codestring = arng.getGeneratedCode();
                 ArrayList arlist = new ArrayList();
                 arlist.add(codestring);
                 arlist.add(id);
                 codesandid.add(arlist);
                 break;
             case("ATTRIBUTECOMPARERULE"):
                ACMPDAO atdao = new ACMPDAO();
                 attributeCompareRule acmp = atdao.getenoughinfotogenerate(id);
                 generateAttributeCompareRule gacr = new generateAttributeCompareRule();
                 acmp = gacr.decideTypeGeneratedAttrComp(acmp);
                  codestring = acmp.getGeneratedCode();
                 ArrayList aclist = new ArrayList();
                 aclist.add(codestring);
                 aclist.add(id);
                 codesandid.add(aclist);
                 break;
             case("ATTRIBUTELISTRULE"):
                 ATLRDAO aldao = new ATLRDAO();
                 attributeListRule  alr =  aldao.getenoughinfotogenerate(id);
                 generateAttributeListrule gal = new generateAttributeListrule();
                 alr = gal.decideTypeGeneratedAttrList(alr);
                  codestring = alr.getGeneratedCode();
                 ArrayList allist = new ArrayList();
                 allist.add(codestring);
                 allist.add(id);
                 codesandid.add(allist);
                 break;
             case("INTERENTITYCOMPARERULE"):
                 IECRDAO iedao = new IECRDAO();
                 interEntityCompareRule iecr = iedao.getenoughinfotogenerate(id);
                 generateinterentityrule gir = new generateinterentityrule();
                 iecr = gir.decideTypeGeneratedIEcomp(iecr);
                codestring = iecr.getGeneratedCode();
                 ArrayList ielist = new ArrayList();
                 ielist.add(codestring);
                 ielist.add(id);
                 codesandid.add(ielist);
                 break;
             case("OTHERRULE"):
                 OTHRDAO otdao = new OTHRDAO();
                 OtherRule or = otdao.getenoughinfotogenerate(id);
                   codestring = or.getGeneratedCode();
                 ArrayList orlist = new ArrayList();
                 orlist.add(codestring);
                 orlist.add(id);
                 codesandid.add(orlist);
                 break;
             case("TUPLECOMPARERULE"):
                 TCMPDAO tcdao = new TCMPDAO();
                 tupleCompareRule tcmp = tcdao.getenoughinfotogenerate(id);
                 generateTupleCompareRule gtc= new generateTupleCompareRule();
                 tcmp = gtc.decideTypeGeneratedTupleComp(tcmp);
                  codestring = tcmp.getGeneratedCode();
                 ArrayList tclist = new ArrayList();
                 tclist.add(codestring);
                 tclist.add(id);
                 codesandid.add(tclist);
                 break;
         }
       }
        return codesandid;
    }
}

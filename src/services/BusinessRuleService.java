package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controller.generateAttributeCompareRule;
import controller.generateAttributeListrule;
import controller.generateAttributeRangeRule;
import domain.attributeCompareRule;
import controller.generateTupleCompareRule;
import controller.generateinterentityrule;
import domain.*;
import org.apache.http.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;

import dao.implementBusinessRuleDAO;

import static domain.attributeCompareRule.Builder.buildAttributeCompareRule;
import static domain.attributeRangeRule.Builder.buildAttributeRangeRule;
import static domain.attributeListRule.Builder.buildAttributeListRule;
import static domain.OtherRule.Builder.buildOtherRule;
import static domain.tupleCompareRule.Builder.buildTupleCompareRule;
import static domain.interEntityCompareRule.Builder.buildInterEntityCompareRule;

public class BusinessRuleService {

    private final String USER_AGENT = "Mozilla/5.0";

    public String getBusinessRules() {


        String url = "https://ondora02.hu.nl:8080/ords/tosad_2017_2c_team3/businessrule/get";

        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
        new javax.net.ssl.HostnameVerifier(){

            public boolean verify(String hostname,
                                  javax.net.ssl.SSLSession sslSession) {
                return hostname.equals("ondora02.hu.nl");
            }
        });
        //Trying to get a connection
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);
            //Getting the response and logging out information
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            //defining json array to fill the values with
            JSONArray jsa = new JSONArray();
            while ((inputLine = in.readLine()) != null) {

                //https://stackoverflow.com/questions/31039207/jsonobject-remove-empty-value-pairs (Getting rid of double values)
                Type type = new TypeToken<Map<String, Object>>() {}.getType();
                Map<String, Object> data = new Gson().fromJson(inputLine, type);

                for (Iterator<Map.Entry<String, Object>> it = data.entrySet().iterator(); it.hasNext();) {
                    Map.Entry<String, Object> entry = it.next();
                    if (entry.getValue() == null) {
                        it.remove();
                    } else if (entry.getValue() instanceof ArrayList) {
                        if (((ArrayList<?>) entry.getValue()).isEmpty()) {
                            it.remove();
                        }
                    }
                }
                //disableHtmlEscaping = so we can have things like '=' as operator, or else it will be translated to utf-8 code
                inputLine = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(data);
                //End stackoverflow

                JSONObject json = new JSONObject(inputLine);
                System.out.println(json.toString());
                //Getting items, we do not need any other values from the json values
                JSONArray items = json.getJSONArray("items");
                //We want to get the first row
                JSONObject row = items.getJSONObject(0);
                System.out.println("row" + row);

                //We're filling the json array with our just gotten items
                jsa.put(items);

            }
            in.close();

            //Getting the first value, the problem with the json array is that the brackets keep stacking, this gets rid of that problem
            JSONArray jxson = (JSONArray) jsa.get(0);

            //Looping over all the business rules
            for(int n = 0; n < jxson.length(); n++)
            {
                //Getting the first or N for the next business rule
                JSONObject jso = jxson.getJSONObject(n);
                //Getting the type, later we will filter on the type
                String type = String.valueOf(jso.get("type"));

                //General values declare
                //Declaring values that we can use in ANY type
                String name = String.valueOf(jso.get("name"));
                String mainTable = String.valueOf(jso.get("maintable"));
                String affectedColumn = String.valueOf(jso.get("affectedcolumn"));

                //First we're casting the values to a double and then to an int.
                //If we do this right away we get the error code: java.base/java.lang.Double cannot be cas
                double triggerBr = (double) jso.get("triggerbr");
                int triggerBrInt = (int) triggerBr;

                double constraintBr = (double) jso.get("constraintbr");
                int constraintBrInt = (int) constraintBr;

                double businessRuleID = (double) jso.get("id_businessrule");
                int businessRuleIDInt = (int) businessRuleID;

                double insert = (double) jso.get("insertbr");
                boolean insertBoolean = false;
                if(insert >= 1){
                    insertBoolean = true;
                } else {
                    insertBoolean = false;
                }

                double update = (double) jso.get("updatebr");
                boolean updateBoolean = false;
                if(update >= 1){
                    updateBoolean = true;
                } else {
                    updateBoolean = false;
                }

                double delete = (double) jso.get("deletebr");
                boolean deleteBoolean = false;
                if(delete >= 1){
                    deleteBoolean = true;
                } else {
                    deleteBoolean = false;
                }

                //End of casting of all the values

                //End declaring general values

                //Filtering for which type the rule is
                if(type.equals("AttributeRangeRule")) {
                    //First we're casting the values to a double and then to an int.
                    //If we do this right away we get the error code: java.base/java.lang.Double cannot be cast to java.base/java.lang.Integer
                    double rangeStart = (double) jso.get("rangestart");
                    int rangeStartInt = (int) rangeStart;

                    double rangeEnd = (double) jso.get("rangeend");
                    int rangeEndInt = (int) rangeEnd;

                    double insideRange = (double) jso.get("insiderange");
                    boolean insideRangeBoolean = false;
                    if(insideRange == 1) {
                        insideRangeBoolean = true;
                    } else if (insideRange == 0) {
                        insideRangeBoolean = false;
                    }
                    //The controller
                    generateAttributeRangeRule gatrr = new generateAttributeRangeRule();
                    //The object that we want to give on to the controller
                    attributeRangeRule atrr = buildAttributeRangeRule()
                            .setName(name)
                            .setRangeStart(rangeStartInt)
                            .setRangeEnd(rangeEndInt)
                            .setMainTable(mainTable)
                            .setInsideRange(insideRangeBoolean)
                            .setAffectedColumn(affectedColumn)
                            .setInsert(insertBoolean)
                            .setDelete(deleteBoolean)
                            .setUpdate(updateBoolean)
                            .build();

                    //If the constraint value = 1, it's true. We need other functions in the controller.
                    if(constraintBrInt == 1) {
                        String constraintAttributeRangeRule = gatrr.createAttributeRangeRuleConstraint(atrr);
                        implementBusinessRuleDAO implbrdao = new implementBusinessRuleDAO(constraintAttributeRangeRule, businessRuleIDInt);
                        implbrdao.updateActiveBusinessRule(businessRuleIDInt);
                    }
                    //If the trigger value = 1, it's true. We need other functions in the controller.
                    if(triggerBrInt == 1) {
                        String triggerAttributeRangeRUle = gatrr.createAttributeRangeRuleTrigger(atrr);
                        implementBusinessRuleDAO implbrdao = new implementBusinessRuleDAO(triggerAttributeRangeRUle, businessRuleIDInt);
                        implbrdao.updateActiveBusinessRule(businessRuleIDInt);
                    }

                }
                //Filtering for the type
                if(type.equals("AttributeListRule")){
                    //inList
                    //First we're casting the values to a double and then to an int.
                    //If we do this right away we get the error code: java.base/java.lang.Double cannot be cast to java.base/java.lang.Integer
                    double inList = (double) jso.get("inlist");
                    int inListInt = (int) inList;
                    boolean inlistBoolean = false;
                    if(inListInt == 1) {
                        inlistBoolean = true;
                    } else {
                        inlistBoolean = false;
                    }

                    //The values are in a LOV with a seperate of :, we will split that string and cast it to an arraylist
                    String stringValue = String.valueOf(jso.get("stringvalue"));
                    List<String> list = Arrays.asList(stringValue.split(":"));
                    ArrayList<String> arrayList = new ArrayList(list);
                    //end
                    //Controller
                    generateAttributeListrule gatlr = new generateAttributeListrule();
                    //Object which we're going to give to the controller
                    attributeListRule atlr = buildAttributeListRule()
                            .setName(name)
                            .setMainTable(mainTable)
                            .setAffectedColumn(affectedColumn)
                            .setInsert(insertBoolean)
                            .setUpdate(updateBoolean)
                            .setDelete(deleteBoolean)
                            .setInList(inlistBoolean)
                            .setList(arrayList)
                            .build();
                    //If the constraint value = 1, it's true. We need other functions in the controller.
                    if(constraintBrInt == 1) {
                        String constraintAttributeListRule = gatlr.createAttributeListRuleConstraint(atlr);
                        implementBusinessRuleDAO implbrdao = new implementBusinessRuleDAO(constraintAttributeListRule, businessRuleIDInt);
                        implbrdao.updateActiveBusinessRule(businessRuleIDInt);
                    }
                    //If the trigger value = 1, it's true. We need other functions in the controller.

                    if(triggerBrInt == 1) {
                        String triggerAttributeListRule = gatlr.createAttributeListRuleTrigger(atlr);
                        implementBusinessRuleDAO implbrdao = new implementBusinessRuleDAO(triggerAttributeListRule, businessRuleIDInt);
                        implbrdao.updateActiveBusinessRule(businessRuleIDInt);
                    }

                }
                //Filtering for the type
                //For the rest of the comments, everything of the trigger or constraint is the same as above here.
                //Just as is the same for controller and object.
                if(type.equals("AttributeCompareRule")){

                    String operator = String.valueOf(jso.get("operator"));
                    double valueBr = (double) jso.get("valuebr");
                    int valueBrInt = (int) valueBr;

                    generateAttributeCompareRule gatcr = new generateAttributeCompareRule();

                    attributeCompareRule acr = buildAttributeCompareRule()
                            .setName(name)
                            .setMainTable(mainTable)
                            .setAffectedColumn(affectedColumn)
                            .setInsert(insertBoolean)
                            .setUpdate(updateBoolean)
                            .setDelete(deleteBoolean)
                            .setOperator(operator)
                            .setValue(valueBrInt)
                            .build();

                    if(constraintBrInt == 1) {
                        String constraintAttributeCompareRule = gatcr.createAttributeCompareRuleConstraint(acr);
                        implementBusinessRuleDAO implbrdao = new implementBusinessRuleDAO(constraintAttributeCompareRule, businessRuleIDInt);
                        implbrdao.updateActiveBusinessRule(businessRuleIDInt);
                    }

                    if(triggerBrInt == 1) {
                        String triggerAttributeCompareRule = gatcr.createAttributeCompareRuleTrigger(acr);
                        implementBusinessRuleDAO implbrdao = new implementBusinessRuleDAO(triggerAttributeCompareRule, businessRuleIDInt);
                        implbrdao.updateActiveBusinessRule(businessRuleIDInt);
                    }

                }
                //Filtering for the type
                if(type.equals("InterEntityCompareRule")){

                    generateinterentityrule gier = new generateinterentityrule();
                    String secondcolumn = (String) jso.get("secondaffectedcolumn");
                    String secondTable = (String) jso.get("secondaffectedtable");
                    String operator = (String) jso.get("operator");

                    interEntityCompareRule iecr = buildInterEntityCompareRule()
                            .setName(name)
                            .setOtherColumn(secondcolumn)
                            .setOtherTable(secondTable)
                            .setOperator(operator)
                            .setMainTable(mainTable)
                            .setAffectedColumn(affectedColumn)
                            .setInsert(insertBoolean)
                            .setDelete(deleteBoolean)
                            .setUpdate(updateBoolean)
                            .build();

                    if(constraintBrInt ==1){
                        String gencode = gier.createinterentityRuleConstraint(iecr);
                        implementBusinessRuleDAO implbrdao = new implementBusinessRuleDAO(gencode,
                                iecr.getBusinessRuleID());
                    }
                    if (triggerBrInt == 1){
                        String gencode = gier.createinterentityRuleTrigger(iecr);
                        implementBusinessRuleDAO implbrdao = new implementBusinessRuleDAO(gencode,
                                iecr.getBusinessRuleID());
                    }
                }

                //Filtering for the type
                if(type.equals("TupleCompareRule")){

                    generateTupleCompareRule gtcr = new generateTupleCompareRule();
                    String secondcolumn = (String) jso.get("secondaffectedcolumn");
                    String operator = (String) jso.get("operator");

                    tupleCompareRule tcr = buildTupleCompareRule()
                            .setName(name)
                            .setSecondcolumn(secondcolumn)
                            .setOperator(operator)
                            .setMainTable(mainTable)
                            .setAffectedColumn(affectedColumn)
                            .setInsert(insertBoolean)
                            .setDelete(deleteBoolean)
                            .setUpdate(updateBoolean)
                            .build();

                    if(constraintBrInt == 1){
                        String constraintTupleCompareRule = gtcr.createTupleCompareRuleConstraint(tcr);
                        implementBusinessRuleDAO implbrdao = new implementBusinessRuleDAO(constraintTupleCompareRule,
                                tcr.getBusinessRuleID());

                    }
                    if(triggerBrInt == 1){
                        String triggerTupleCompareRule = gtcr.createTupleCompareRuleTrigger(tcr);
                        implementBusinessRuleDAO implbrdao = new implementBusinessRuleDAO(triggerTupleCompareRule,
                                tcr.getBusinessRuleID());
                    }
                }

                if(type.equals("OtherRule")){
                    String sql = (String) jso.get("sql_code");

                    OtherRule other = buildOtherRule()
                            .setName(name)
                            .setGeneratedCode(sql)
                            .setMainTable(mainTable)
                            .setAffectedColumn(affectedColumn)
                            .setInsert(insertBoolean)
                            .setDelete(deleteBoolean)
                            .setUpdate(updateBoolean)
                            .build();
                            implementBusinessRuleDAO implbrdao = new implementBusinessRuleDAO(other.getGeneratedCode(),
                            other.getOtherRuleID());
                }
                //end loop
            }
        }

        catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

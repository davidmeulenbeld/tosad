package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controller.generateAttributeCompareRule;
import controller.generateAttributeListrule;
import controller.generateAttributeRangeRule;
import domain.attributeCompareRule;
import domain.attributeListRule;
import domain.OtherRule;
import domain.attributeRangeRule;
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

import dao.implementBusinesRuleDAO;

import static domain.attributeCompareRule.Builder.buildAttributeCompareRule;
import static domain.attributeRangeRule.Builder.buildAttributeRangeRule;
import static domain.attributeListRule.Builder.buildAttributeListRule;
import static domain.OtherRule.Builder.buildOtherRule;


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

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            JSONArray jsa = new JSONArray();
            while ((inputLine = in.readLine()) != null) {

                //https://stackoverflow.com/questions/31039207/jsonobject-remove-empty-value-pairs (Dubbele values uit json halen)
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

                inputLine = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(data);
                //Einde SO Gebruik

                JSONObject json = new JSONObject(inputLine);
                System.out.println(json.toString());
                JSONArray items = json.getJSONArray("items");
                JSONObject row = items.getJSONObject(0);
                System.out.println("row" + row);


                jsa.put(items);
                System.out.println(inputLine);
            }
            in.close();

            System.out.println(jsa.get(0));

            JSONArray jxson = (JSONArray) jsa.get(0);


            for(int n = 0; n < jxson.length(); n++)
            {
                JSONObject jso = jxson.getJSONObject(n);
                String type = String.valueOf(jso.get("type"));
                System.out.println("type" + type);

                //General values declare

                String name = String.valueOf(jso.get("name"));
                String mainTable = String.valueOf(jso.get("maintable"));
                String affectedColumn = String.valueOf(jso.get("affectedcolumn"));

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

                //End declaring general values

                //Kijken welk type het is
                if(type.equals("AttributeRangeRule")) {
                    System.out.println("Inside attribute range rule");

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

                    generateAttributeRangeRule gatrr = new generateAttributeRangeRule();

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

                    System.out.println(constraintBr);
                    if(constraintBrInt == 1) {
                        String constraintAttributeRangeRule = gatrr.createAttributeRangeRuleConstraint(atrr);
                        implementBusinesRuleDAO implbrdao = new implementBusinesRuleDAO(constraintAttributeRangeRule, businessRuleIDInt);
                        implbrdao.updateActiveBusinessRule(businessRuleIDInt);
                    }
                    System.out.println(triggerBr);
                    if(triggerBrInt == 1) {
                        String triggerAttributeRangeRUle = gatrr.createAttributeRangeRuleTrigger(atrr);
                        implementBusinesRuleDAO implbrdao = new implementBusinesRuleDAO(triggerAttributeRangeRUle, businessRuleIDInt);
                        implbrdao.updateActiveBusinessRule(businessRuleIDInt);
                    }

                }

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
                    String stringValue = String.valueOf(jso.get("stringvalue"));
                    List<String> list = Arrays.asList(stringValue.split(":"));
                    ArrayList<String> arrayList = new ArrayList(list);
                    //StringValue
                    generateAttributeListrule gatlr = new generateAttributeListrule();

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

                    if(constraintBrInt == 1) {
                        String constraintAttributeListRule = gatlr.createAttributeListRuleConstraint(atlr);
                        implementBusinesRuleDAO implbrdao = new implementBusinesRuleDAO(constraintAttributeListRule, businessRuleIDInt);
                        implbrdao.updateActiveBusinessRule(businessRuleIDInt);
                    }

                    if(triggerBrInt == 1) {
                        String triggerAttributeListRule = gatlr.createAttributeListRuleTrigger(atlr);
                        implementBusinesRuleDAO implbrdao = new implementBusinesRuleDAO(triggerAttributeListRule, businessRuleIDInt);
                        implbrdao.updateActiveBusinessRule(businessRuleIDInt);
                    }

                }

                if(type.equals("AttributeCompareRule")){
                    //Operator
                    //ValueBR
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
                        implementBusinesRuleDAO implbrdao = new implementBusinesRuleDAO(constraintAttributeCompareRule, businessRuleIDInt);
                        implbrdao.updateActiveBusinessRule(businessRuleIDInt);
                    }

                    if(triggerBrInt == 1) {
                        String triggerAttributeCompareRule = gatcr.createAttributeCompareRuleTrigger(acr);
                        implementBusinesRuleDAO implbrdao = new implementBusinesRuleDAO(triggerAttributeCompareRule, businessRuleIDInt);
                        implbrdao.updateActiveBusinessRule(businessRuleIDInt);
                    }

                }

                if(type.equals("InterEntityCompareRule")){
                    //SecondAffectedColumn
                    //SecondAffectedTable
                    //Operator

                }

                if(type.equals("TupleCompareRule")){
                    //SecondAffectedColumn
                    //Operator
                }

                if(type.equals("OtherRule")){
                    System.out.println("otherrule");
                    String sql= (String) jso.get("SQL_CODE");

                    OtherRule other = buildOtherRule()
                            .setName(name)
                            .setGeneratedCode(sql)
                            .setMainTable(mainTable)
                            .setAffectedColumn(affectedColumn)
                            .setInsert(insertBoolean)
                            .setDelete(deleteBoolean)
                            .setUpdate(updateBoolean)
                            .build();
                    implementBusinesRuleDAO implbrdao = new implementBusinesRuleDAO(other.getGeneratedCode(),
                            other.getOtherRuleID());
                }



                System.out.println(n);
            }




            //TODO: Adhv type een controller aanroepen
            //TODO: Rest service POST Gegenereerde businessrule



            //print result
//            System.out.println(jsa.toString());

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

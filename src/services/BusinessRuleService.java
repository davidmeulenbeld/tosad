package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controller.generateAttributeRangeRule;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import static domain.attributeRangeRule.Builder.buildAttributeRangeRule;

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

                inputLine = new GsonBuilder().setPrettyPrinting().create().toJson(data);
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

                if(type == "AttributeRangeRule") {

                    generateAttributeRangeRule gatrr = new generateAttributeRangeRule();

                    attributeRangeRule atrr = buildAttributeRangeRule()
                            .setName("")
                            .setRangeStart(0)
                            .setRangeEnd(2)
                            .build();
                    if("constraint" == "constraint") {
                        gatrr.createAttributeRangeRuleConstraint(atrr);
                    }

                    if("trigger" == "trigger") {
                        gatrr.createAttributeRangeRuleTrigger(atrr);
                    }

                }


                System.out.println(n);
            }



            //TODO: Kijken welk type het is
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

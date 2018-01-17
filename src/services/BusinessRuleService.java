package services;

import dao.BusinessRuleDao;
import dao.BusinessRuleDaoImpl;
import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class BusinessRuleService {
    BusinessRuleDao brDao = new BusinessRuleDaoImpl();

    private final String USER_AGENT = "Mozilla/5.0";

    public String getTableNames() {


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
                JSONObject json = new JSONObject(inputLine);
                System.out.println(json.toString());
                JSONArray items = json.getJSONArray("items");
                JSONObject row = items.getJSONObject(0);
                System.out.println("row" + row);


                jsa.put(row);
            }
            in.close();

            for(int n = 0; n < jsa.length(); n++)
            {
                JSONObject jso = jsa.getJSONObject(n);
                String affectedCol = String.valueOf(jso.get("affectedcolumn"));
                String generatedCode = String.valueOf(jso.get("generatedcode"));
                System.out.println("gen" + generatedCode);
            }


            //print result
            System.out.println(jsa.toString());

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

package services;

import dao.BusinessRuleDao;
import dao.BusinessRuleDaoImpl;
import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class BusinessRuleService {
    BusinessRuleDao brDao = new BusinessRuleDaoImpl();

    public String getTableNames() {
//        DefaultHttpClient httpclient = new DefaultHttpClient();
//        try {
//            // specify the host, protocol, and port
//            HttpHost target = new HttpHost("https://ondora02.hu.nl:8080/ords/tosad_2017_2c_team3/businessrule/get");
//
//            // specify the get request
//            HttpGet getRequest = new HttpGet("/ords/tosad_2017_2c_team3/businessrule/get");
//
//            System.out.println("executing request to " + target);
//
//            HttpResponse httpResponse = null;
//            try {
//                httpResponse = httpclient.execute(target, getRequest);
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//            HttpEntity entity = httpResponse.getEntity();
//
//            System.out.println("----------------------------------------");
//            System.out.println(httpResponse.getStatusLine());
//            Header[] headers = httpResponse.getAllHeaders();
//            for (int i = 0; i < headers.length; i++) {
//                System.out.println(headers[i]);
//            }
//            System.out.println("----------------------------------------");
//
//            if (entity != null) {
//                try {
//                    System.out.println(EntityUtils.toString(entity));
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // When HttpClient instance is no longer needed,
//            // shut down the connection manager to ensure
//            // immediate deallocation of all system resources
//            httpclient.getConnectionManager().shutdown();
//        }
//
//        return null;

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://ondora02.hu.nl:8080/ords/tosad_2017_2c_team3/businessrule/get");
        JSONArray response = target.request(MediaType.APPLICATION_JSON).get(JSONArray.class);
        System.out.println(response);
        return null;
    }
}

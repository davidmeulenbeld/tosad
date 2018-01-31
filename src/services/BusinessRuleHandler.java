package services;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

/**
 * handles implementing businessrules into database
 */
public class BusinessRuleHandler implements HttpHandler{
    @Override

    public void handle(HttpExchange he) throws IOException {
        //declaration of businessruleservice
        BusinessRuleService brs = new BusinessRuleService();
        //implementing non active businessrules

        
        String response = "non active businessrules are being generated " ;
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

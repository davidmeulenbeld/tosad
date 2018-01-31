package services;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import controller.getInActiveBR;
import controller.implementinghandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * handles implementing businessrules into database
 */
public class BusinessRuleHandler implements HttpHandler{
    @Override

    public void handle(HttpExchange he) throws IOException {
        //declaration of businessruleservice
        System.out.println("HELLO");
        getInActiveBR gibr = new getInActiveBR();
        System.out.println("HELLO");
        ArrayList<ArrayList> codes = gibr.gettoimplementcode();
        implementinghandler ih = new implementinghandler();
        ih.implementintoDB(codes);

        //implementing non active businessrules

        
        String response = "non active businessrules are being generated " ;
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

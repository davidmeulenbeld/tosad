package services;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


import java.io.IOException;
import java.io.OutputStream;

public class Roothandler implements HttpHandler{
    @Override

    public void handle(HttpExchange he) throws IOException {
        BusinessRuleService brs = new BusinessRuleService();

        brs.getBusinessRules();
        String response = "<h1>Server start success " +
                "if you see this message</h1>" + "<h1>Port: " + "</h1>";
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

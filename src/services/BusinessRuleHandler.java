package services;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class BusinessRuleHandler implements HttpHandler{
    @Override

    public void handle(HttpExchange he) throws IOException {
        String response = "non active businessrules are being generated " ;
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

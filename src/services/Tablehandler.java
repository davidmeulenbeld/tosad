package services;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import controller.TableJsonCreator;


import java.io.IOException;
import java.io.OutputStream;

public class Tablehandler implements HttpHandler {

    public void handle(HttpExchange he) throws IOException {
        TableJsonCreator tjc = new TableJsonCreator();
        String response =  tjc.convertToJSON().toString();
        he.sendResponseHeaders(200,response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }
}

package services;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;




public class Testserc {

    public static void main(String[] args) throws Exception {
        int port = 9000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("server started at " + port);
        Roothandler rh = new Roothandler();
        server.createContext("/", rh);

        server.setExecutor(null);
        server.start();
    }

    }


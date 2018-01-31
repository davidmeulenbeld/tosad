package services;



import java.net.InetSocketAddress;


import com.sun.net.httpserver.HttpServer;




public class serverStart {

    public static void main(String[] args) throws Exception {
        int port = 9000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("server started at " + port);

        server.createContext("/", new Roothandler());
        server.createContext("/tablenames",new Tablehandler());
        server.createContext("/columns", new Columnhandler());
        server.createContext("/businessrule", new BusinessRuleHandler());
        server.setExecutor(null);
        server.start();
    }

    }


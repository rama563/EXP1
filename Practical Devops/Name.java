import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Name {
    public static void main(String[] args) throws IOException {
        // Create an HTTP server that listens on port 8006
        HttpServer server = HttpServer.create(new InetSocketAddress(8010), 0);
        
        // Set up a context that listens to the root path
        server.createContext("/", new MyHandler());
        
        // Create a default executor
        server.setExecutor(null);
        
        // Start the server
        server.start();
        
        System.out.println("Server is listening on port 8010");
    }

    // Define the handler that processes incoming requests
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // The response text
            String response = "Hello, my name is Ramachandran A";
            
            // Set the response headers
            exchange.sendResponseHeaders(200, response.length());
            
            // Write the response to the output stream
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            
            // Close the output stream
            os.close();
        }
    }
}

package ca.utoronto.utm.mcs;

import java.io.IOException;



public class App
{
    static int port = 8080;

    public static void main(String[] args) throws IOException
    {
    	Dagger service = DaggerDaggerComponent.create().buildMongoHttp();
    	
    	//Create your server context here
        
    	service.getServer().createContext("/api/v1/post", new CreatePost(service.getDb()));
    	service.getServer().createContext("/api/v1/get", new CreatePost(service.getDb()));
    	
    	service.getServer().start();
    	
    	System.out.printf("Server started on port %d", port);
    }
}

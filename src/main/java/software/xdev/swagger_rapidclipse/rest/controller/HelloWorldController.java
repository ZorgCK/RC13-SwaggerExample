package software.xdev.swagger_rapidclipse.rest.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/helloworld")
public class HelloWorldController
{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHelloWorld()
    {
        return "Hello World";
    }
}

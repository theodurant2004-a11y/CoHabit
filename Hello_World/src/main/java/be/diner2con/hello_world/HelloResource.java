package be.diner2con.hello_world;

import be.diner2con.hello_world.DAO.HelloWorldDAO;
import be.diner2con.hello_world.Models.HelloWorld;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello-world")
public class HelloResource {

    private final HelloWorldDAO dao = new HelloWorldDAO();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        HelloWorld hw = dao.get(1);
        return hw != null ? hw.getText() : "No text found";
    }
}
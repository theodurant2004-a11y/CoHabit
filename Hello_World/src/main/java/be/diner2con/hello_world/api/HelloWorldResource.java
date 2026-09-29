package be.diner2con.hello_world.api;

import be.diner2con.hello_world.DAO.HelloWorldDAO;
import be.diner2con.hello_world.Models.HelloWorld;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello-world")
public class HelloWorldResource {

    private final HelloWorldDAO dao = new HelloWorldDAO();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHelloWorld(@PathParam("id") int id) {
        HelloWorld hw = dao.get(id);
        if (hw != null) {
            return Response.status(Response.Status.OK)
                    .entity(hw)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
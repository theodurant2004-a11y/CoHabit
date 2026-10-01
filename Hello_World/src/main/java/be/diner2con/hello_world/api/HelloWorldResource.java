package be.diner2con.hello_world.api;

import be.diner2con.hello_world.DAO.HelloWorldDAO;
import be.diner2con.hello_world.Models.HelloWorld;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello-world")
public class HelloWorldResource {

    private final HelloWorldDAO dao = new HelloWorldDAO();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHelloWorld(@PathParam("id") int id) {
        HelloWorld hw = HelloWorld.getHelloWorld(id, new HelloWorldDAO());
        if (hw != null) {
            return Response.status(Response.Status.OK)
                    .entity(hw)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateHelloWorld(@PathParam("id") int id, HelloWorld body) {
        body.setId(id);
        try {
            return body.update(dao)
                    ? Response.noContent().build()
                    : Response.status(Response.Status.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }
}
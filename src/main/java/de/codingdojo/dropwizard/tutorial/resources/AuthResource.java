package de.codingdojo.dropwizard.tutorial.resources;

import de.codingdojo.dropwizard.tutorial.core.User;
import io.dropwizard.auth.Auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/auth")
public class AuthResource {
    @GET
    public Response authenticate(@Auth User user) {
        if (!"peeskillet".equals(user.getUserName())) {
            throw new WebApplicationException(Response.Status.FORBIDDEN);
        }
        return Response.ok(
                "{\"Hello\": \"" + user.getUserName() + "\"}").build();
    }
}

package com.example.app.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.app.entities.User;

@Path("/user")
public class UserController {

    private static final String CONTEXT = "USERS";

    private final ServletContext servletContext;

    private final Map<Integer, User> users;

    @SuppressWarnings("unchecked")
    public UserController(@Context final ServletContext servletContext) {

        this.servletContext = servletContext;

        if (this.servletContext.getAttribute(CONTEXT) == null) {
            this.servletContext.setAttribute(CONTEXT, new HashMap<Integer, User>());
        }

        this.users = (Map<Integer, User>) this.servletContext.getAttribute(CONTEXT);
    }

    @GET
    public Response getAll() {

        final Collection<User> result = users.values();

        return Response.ok(result).build();
    }

    @GET
    @Path("/{id}")
    public Response getOne(@PathParam("id") final Integer id) {
        Response result;
        final User user = users.get(id);

        if (user != null) {
            result = Response.ok(user).build();
        } else {
            result = Response.noContent().build();
        }

        return result;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response create(@PathParam("id") final Integer id, final User user) {

        if (user.getId() == 0) {
            user.setId(++User.sequence);
        }

        users.put(user.getId(), user);

        return Response.ok(user).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(final List<User> usersParam) {

        for (User user : usersParam) {
            if (user.getId() == 0) {
                user.setId(++User.sequence);
            }

            users.put(user.getId(), user);
        }

        return Response.ok(usersParam).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") final Integer id, final User user) {
        users.replace(id, user);

        return Response.ok(user).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") final Integer id) {
        users.remove(id);

        return Response.ok().build();
    }
}

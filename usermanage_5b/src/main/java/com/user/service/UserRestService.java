package com.user.service;

import com.user.datahandle.DataAccess;
import com.user.model.User;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/")
public class UserRestService {

    private DataAccess dataAccess = new DataAccess();

    @GET
    @Path("/listusers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listAllUsers() {
        return dataAccess.listAllUsers();
    }

    @POST
    @Path("/insertuser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User insertUser(User user) {
        dataAccess.insertUser(user);
        return user;
    }



    @GET
    @Path("/finduser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User findUser(@PathParam("id") int userId) {
        return dataAccess.findUser(userId);
    }

    @PUT
    @Path("/updateuser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(User user) {
        dataAccess.updateUser(user);
        return user;
    }

    @DELETE
    @Path("/deleteuser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User deleteUser(@PathParam("id") int userId) {

        User user = dataAccess.findUser(userId);

        if (user != null) {
            dataAccess.deleteUser(user);
        }

        return user;
    }
}
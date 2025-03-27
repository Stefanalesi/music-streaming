package com.musicstreaming.controller;

import com.musicstreaming.entity.User;
import com.musicstreaming.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    UserService userService;

    @GET
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}

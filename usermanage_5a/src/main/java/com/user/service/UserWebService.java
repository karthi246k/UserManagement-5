package com.user.service;

import com.user.model.User;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface UserWebService {

    @WebMethod
    void insertUser(User user);

    @WebMethod
    void updateUser(User user);

    @WebMethod
    void deleteUser(User user);

    @WebMethod
    List<User> listAllUsers();

    @WebMethod
    User findUser(String searchType, String value);
}
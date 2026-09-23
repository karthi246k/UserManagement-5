package com.user.service;

import com.user.datahandle.DataAccess;
import com.user.model.User;

import jakarta.jws.WebService;

import java.util.List;

@WebService(endpointInterface = "com.user.service.UserWebService")
public class UserWebServiceImpl implements UserWebService {

    private DataAccess dataAccess = new DataAccess();

    public void insertUser(User user) {
        dataAccess.insertUser(user);
    }

    public void updateUser(User user) {
        dataAccess.updateUser(user);
    }

    public void deleteUser(User user) {
        dataAccess.deleteUser(user);
    }

    public List<User> listAllUsers() {
        return dataAccess.listAllUsers();
    }

    public User findUser(String searchType, String value) {
        return dataAccess.findUser(searchType, value);
    }
}
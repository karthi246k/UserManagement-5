package com.user.client;

import java.util.List;

import com.user.model.User;
import com.user.service.UserWebService;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class UserWebServiceClient {

    private static final UserWebService webService;

    static {

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

        factory.setServiceClass(UserWebService.class);

        factory.setAddress("http://localhost:8080/UserManage_5a/services/UserWebService");

        webService = (UserWebService) factory.create();
    }

    public static List<User> listAllUsers() {
        return webService.listAllUsers();
    }

    public static void insertUser(User user) {
        webService.insertUser(user);
    }

    public static void updateUser(User user) {
        webService.updateUser(user);
    }

    public static void deleteUser(User user) {
        webService.deleteUser(user);
    }

    public static User findUser(String searchType, String value) {
        return webService.findUser(searchType, value);
    }
}
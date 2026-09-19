package com.user.client;

import java.util.List;

import com.user.config.ApiUrls;
import com.user.model.User;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

public class UserApiClient {

    private static final Client client = ClientBuilder.newClient();

    public static List<User> listUsers() {
        return client
                .target(ApiUrls.list_user_url)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<User>>() {});
    }

    public static void insertUser(User user) {
        client
                .target(ApiUrls.insert_user_url)
                .request(MediaType.APPLICATION_JSON)
                .post(jakarta.ws.rs.client.Entity.entity(user, MediaType.APPLICATION_JSON));
    }

    public static User findUser(int userId) {
        return client
                .target(ApiUrls.find_user_url + "/" + userId)
                .request(MediaType.APPLICATION_JSON)
                .get(User.class);
    }

    public static void updateUser(User user) {
        client
                .target(ApiUrls.update_user_url)
                .request(MediaType.APPLICATION_JSON)
                .put(jakarta.ws.rs.client.Entity.entity(user, MediaType.APPLICATION_JSON));
    }

    public static User deleteUser(int userId) {
    return client
            .target(ApiUrls.delete_user_url + "/" + userId)
            .request(MediaType.APPLICATION_JSON)
            .delete(User.class);
}
}
package com.user.config;

import java.io.InputStream;
import java.util.Properties;

public class ApiUrls {

    private static Properties properties = new Properties();

    static {
        try (InputStream input = ApiUrls.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String main_url = properties.getProperty("main_url");

    public static final String list_user_url = main_url + "/listusers";
    public static final String insert_user_url = main_url +"/insertuser";
    public static final String update_user_url = main_url + "/updateuser";
    public static final String find_user_url = main_url + "/finduser";
    public static final String delete_user_url = main_url + "/deleteuser";
}
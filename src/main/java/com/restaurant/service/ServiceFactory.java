package com.restaurant.service;

public class ServiceFactory {
    private ServiceFactory() {
    }

    private static UserService userService = new UserService();

    public static UserService getUserService() {
        return userService;
    }

}

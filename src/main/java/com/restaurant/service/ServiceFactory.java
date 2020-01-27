package com.restaurant.service;

public class ServiceFactory {
    private ServiceFactory() {
    }

    private static UserService userService = new UserService();
    private static DishService dishService = new DishService();

    public static UserService getUserService() {
        return userService;
    }
    public static DishService getDishService() {
        return dishService;
    }

}

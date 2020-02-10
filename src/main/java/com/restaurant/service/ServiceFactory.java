package com.restaurant.service;

public class ServiceFactory {
    private ServiceFactory() {
    }

    private static UserService userService = new UserService();
    private static DishService dishService = new DishService();
    private static OrderService orderService = new OrderService();
    private static InvoiceService invoiceService = new InvoiceService();

    public static UserService getUserService() {
        return userService;
    }

    public static DishService getDishService() {
        return dishService;
    }

    public static OrderService getOrderService() {
        return orderService;
    }

    public static InvoiceService getInvoiceService() {
        return invoiceService;
    }

}

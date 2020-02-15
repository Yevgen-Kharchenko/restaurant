package com.restaurant.service;

import com.restaurant.repository.DaoFactory;

public class OrderServiceFactory {
    private static final OrderService orderService = new OrderService(
            DaoFactory.getOrderDao(),
            DaoFactory.getUserDao(),
            DaoFactory.getOrderDishDao(),
            TransactionHandlerFactory.getTransactionHandler()
    );

    public static OrderService getOrderService() {
        return orderService;
    }
}

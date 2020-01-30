package com.restaurant.repository;

import com.restaurant.config.ConnectionFactory;
import com.restaurant.config.DataSourceConnectionPool;
import com.restaurant.repository.impl.DishDaoImpl;
import com.restaurant.repository.impl.OrderDaoImpl;
import com.restaurant.repository.impl.UserDaoImpl;

public class DaoFactory {

    private static final ConnectionFactory CONNECTION_FACTORY = DataSourceConnectionPool.getInstance();

    private static final UserDaoImpl USER_DAO= new UserDaoImpl(CONNECTION_FACTORY);
    private static final DishDaoImpl DISH_DAO= new DishDaoImpl(CONNECTION_FACTORY);
    private static final OrderDaoImpl ORDER_DAO= new OrderDaoImpl(CONNECTION_FACTORY);

   public static UserDaoImpl getUserDao(){return USER_DAO;}
   public static DishDaoImpl getDishDao(){return DISH_DAO;}
   public static OrderDaoImpl getOrderDao(){return ORDER_DAO;}


}

package com.restaurant.repository;

import com.restaurant.model.Order;
import com.restaurant.model.User;

import java.util.List;

public interface OrderDao {

    List<Order> getAllForChef();

}

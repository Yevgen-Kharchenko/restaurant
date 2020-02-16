package com.restaurant.service;

import com.restaurant.config.transaction.TransactionHandler;
import com.restaurant.controller.view.OrderDTO;
import com.restaurant.model.Order;
import com.restaurant.model.User;
import com.restaurant.model.enums.Role;
import com.restaurant.model.enums.Status;
import com.restaurant.repository.impl.OrderDaoImpl;
import com.restaurant.repository.impl.OrderDishDaoImpl;
import com.restaurant.repository.impl.UserDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    private OrderService orderService;
    private OrderDaoImpl orderDao = mock(OrderDaoImpl.class);
    private UserDaoImpl userDao = mock(UserDaoImpl.class);
    private OrderDishDaoImpl orderDishDao = mock(OrderDishDaoImpl.class);
    private TransactionHandler transactionHandler = mock(TransactionHandler.class);
    private User user;
    private List<Order> orders = new ArrayList<>();
    private Order order;

    @Before
    public void init() {
        orderService = new OrderService(orderDao, userDao, orderDishDao, transactionHandler);
        user = User.builder().id(1).login("Login").name("Test").phone("12345").role(Role.GUEST).build();
        orders.add(Order.builder().id(1L).date(LocalDateTime.now()).total(100).userId(2).status(Status.NEW).build());
        orders.add(Order.builder().id(2L).date(LocalDateTime.now()).total(200).userId(2).status(Status.IN_PROGRESS).build());
        order = Order.builder().id(3L).date(LocalDateTime.now()).total(200).userId(2).status(Status.IN_PROGRESS).build();
    }

    @Test
    public void getAllForUser() {
        when(orderDao.getAllByFieldId(anyLong())).thenReturn(orders);
        when(userDao.getById(anyLong())).thenReturn(user);
        List<OrderDTO> receivedOrder = orderService.getAllForUser("uk", 1);
        assertEquals(2, receivedOrder.size());
    }

    @Test
    public void createOrder() {
        when(orderDao.create(anyObject())).thenReturn(order);
        assertEquals(orderService.createOrder(1), 3);
    }

    @Test
    public void getAllByStatus() {
        when(orderDao.getAllByField(anyString())).thenReturn(orders);
        when(userDao.getById(anyLong())).thenReturn(user);
        List<OrderDTO> receivedOrder = orderService.getAllByStatus(Status.NEW);
        assertEquals(2, receivedOrder.size());
    }

    @Test
    public void getAllForChef() {
        when(orderDao.getAllByField(anyString())).thenReturn(orders);
        when(userDao.getById(anyLong())).thenReturn(user);
        List<OrderDTO> receivedOrder = orderService.getAllByStatus(Status.IN_PROGRESS);
        assertEquals(2, receivedOrder.size());
    }

    @Test
    public void getById() {
        when(orderDao.getById(anyLong())).thenReturn(order);
        when(userDao.getById(anyLong())).thenReturn(user);
        assertNotNull(orderService.getById(2, "uk"));
    }

    @Test
    public void changeStatus() {
    }

    @Test
    public void deleteOrderDish() {
    }

    @Test
    public void updateAmountInOrderRepository() {
    }

    @Test
    public void getTotalAmount() {
    }

    @Test
    public void addOrderDish() {
    }

    @Test
    public void updateOrderDish() {
    }

    @Test
    public void repeatOrder() {
    }
}

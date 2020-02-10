package com.restaurant.service;

import com.restaurant.controller.view.DishDTO;
import com.restaurant.controller.view.OrderDTO;
import com.restaurant.model.Order;
import com.restaurant.model.OrderDish;
import com.restaurant.model.enums.Status;
import com.restaurant.repository.DaoFactory;
import com.restaurant.repository.impl.DishDaoImpl;
import com.restaurant.repository.impl.OrderDaoImpl;
import com.restaurant.repository.impl.OrderDishDaoImpl;
import com.restaurant.repository.impl.UserDaoImpl;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.primitives.Ints.tryParse;

@AllArgsConstructor
public class OrderService {
    private static final Logger LOG = Logger.getLogger(OrderService.class);

    private OrderDaoImpl orderDao;
    private UserDaoImpl userDao;
    private OrderDishDaoImpl orderDishDao;

    public OrderService() {
        this.userDao = DaoFactory.getUserDao();
        this.orderDao = DaoFactory.getOrderDao();
        this.orderDishDao = DaoFactory.getOrderDishDao();

    }


    /**
     * Gets List OrderDTO from DB by User ID
     *
     * @param id
     * @return
     */
    public List<OrderDTO> getAllForUser(String local, long id) {
        List<Order> all = orderDao.getAllByFieldId(id);
        return all.stream().map(orders -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(orders.getId());
            orderDTO.setDate(orders.getDate());
            orderDTO.setTotal(orders.getTotal());
            orderDTO.setCustomer(userDao.getById(orders.getUserId()));
            orderDTO.setStatus(orders.getStatus());
            orderDTO.setOrderDish(getListDishDTO(local, orders.getId()));

            return orderDTO;
        }).collect(Collectors.toList());
    }

    /**
     * Converts data from Post request to Order and stores it into DB
     *
     * @param userId
     */
    public long createOrder(long userId) {
        LocalDateTime date = LocalDateTime.now().withNano(0);
        Order order = Order.builder()
                .date(date)
                .userId(userId)
                .status(Status.NEW)
                .build();

        order = orderDao.create(order);
        LOG.info("order create : " + order.toString());
        return order.getId();
    }


    /**
     * Gets the List of orders by Status
     *
     * @param status
     * @return
     */
    public List<OrderDTO> getAllByStatus(Status status) {
        List<Order> all = orderDao.getAllByField(status.toString());
        return all.stream().map(orders -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(orders.getId());
            orderDTO.setDate(orders.getDate());
            orderDTO.setTotal(orders.getTotal());
            orderDTO.setCustomer(userDao.getById(orders.getUserId()));
            orderDTO.setStatus(orders.getStatus());

            return orderDTO;
        }).collect(Collectors.toList());
    }

    public List<OrderDTO> getAllForChef(String local) {
        List<Order> all = orderDao.getAllByField((Status.IN_PROGRESS).toString());
        return all.stream().map(orders -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(orders.getId());
            orderDTO.setDate(orders.getDate());
            orderDTO.setOrderDish(getListDishDTO(local, orders.getId()));
            return orderDTO;
        }).collect(Collectors.toList());
    }

    private List<DishDTO> getListDishDTO(String local, long id) {
        List<OrderDish> all = orderDishDao.getAllByFieldId(id);
        return all.stream().map(orderDish -> {
            DishDTO dishDTO = new DishDTO();
            dishDTO.setId(orderDish.getId());
            if (local.equals("uk_UA")) {
                dishDTO.setName(orderDish.getNameUK());
                dishDTO.setIngredients(orderDish.getIngredientsUK());
            } else {
                dishDTO.setName(orderDish.getNameEN());
                dishDTO.setIngredients(orderDish.getIngredientsEN());
            }
            dishDTO.setPrice(orderDish.getPrice());
            dishDTO.setQuantity(orderDish.getQuantity());
            dishDTO.setCost(orderDish.getPrice()*orderDish.getQuantity());
            return dishDTO;
        }).collect(Collectors.toList());
    }

    /**
     * Gets Order by Order ID
     *
     * @param id
     * @return
     */
    public OrderDTO getById(long id, String local) {
        Order order = orderDao.getById(id);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setDate(order.getDate());
        orderDTO.setTotal(order.getTotal());
        orderDTO.setCustomer(userDao.getById(order.getUserId()));
        orderDTO.setStatus(order.getStatus());
        orderDTO.setOrderDish(getListDishDTO(local, order.getId()));

        return orderDTO;
    }

    /**
     * Changes Order Status depending on Post request
     *
     * @param status
     * @param orderId
     */
    public void changeStatus(String status, String orderId) {
        Long id = Long.parseLong(orderId);

        Order order = orderDao.getById(id);
        order.setStatus(Status.valueOf(status));
        LOG.info("new order: " + order);
        orderDao.update(order);
    }

    public void deleteOrderDish(long dishId, long orderId) {
        orderDishDao.remove(orderDishDao.getById(dishId));
        double amount = getTotalAmount(orderId);
        updateAmountInOrderRepository(amount, orderId);
    }

    public void updateAmountInOrderRepository(double amount, long orderId) {
        Order order = orderDao.getById(orderId);
        order.setTotal(amount);
        orderDao.update(order);

    }

    public double getTotalAmount(long orderId) {
        double amount = 0.0;
        double price;
        int quantity;
        List<OrderDish> all = orderDishDao.getAllByFieldId(orderId);
        for (OrderDish orderDish : all) {
            price = orderDish.getPrice();
            quantity = orderDish.getQuantity();
            amount += price * quantity;
        }
        return amount;
    }

    public void addOrderDish(long dishId, long orderId, int quantity) {
        LOG.info("addOrderDish");
        OrderDish orderDish = OrderDish.builder()
                .dishId(dishId)
                .orderId(orderId)
                .quantity(quantity)
                .build();
        LOG.info("orderDish=" + orderDish.toString());
        orderDishDao.create(orderDish);
        LOG.info("create(orderDish)");
        double amount = getTotalAmount(orderId);
        updateAmountInOrderRepository(amount, orderId);
    }

    public void UpdateOrderDish(long dishId, int quantity, long orderId) {
        OrderDish orderDish = orderDishDao.getById(dishId);
        orderDish.setQuantity(quantity);
        orderDishDao.update(orderDish);
        double amount = getTotalAmount(orderId);
        updateAmountInOrderRepository(amount, orderId);
    }

    public void repeatOrder(String orderId) {
        long id = Long.parseLong(orderId);
        Order order = orderDao.getById(id);
        long newOrderId = createOrder(order.getUserId());
        List<OrderDish> newOrderDish = orderDishDao.getAllByFieldId(id);
        long dishId;
        int quantity;
        for (OrderDish orderDish : newOrderDish) {
            dishId = orderDish.getDishId();
            quantity = orderDish.getQuantity();
            addOrderDish(dishId, newOrderId, quantity);
        }
        double amount = getTotalAmount(newOrderId);
        updateAmountInOrderRepository(amount, newOrderId);
    }
}

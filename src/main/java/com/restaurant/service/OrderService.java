package com.restaurant.service;

import com.restaurant.controller.view.OrderDTO;
import com.restaurant.model.Order;
import com.restaurant.model.enums.Status;
import com.restaurant.repository.DaoFactory;
import com.restaurant.repository.impl.DishDaoImpl;
import com.restaurant.repository.impl.OrderDaoImpl;
import com.restaurant.repository.impl.UserDaoImpl;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OrderService {
    private static final Logger LOG = Logger.getLogger(OrderService.class);

    private OrderDaoImpl orderDao;
    private DishDaoImpl dishDao;
    private UserDaoImpl userDao;

    public OrderService() {
        this.userDao = DaoFactory.getUserDao();
        this.orderDao = DaoFactory.getOrderDao();
        this.dishDao = DaoFactory.getDishDao();

    }

//
//    /**
//     * Gets List OrderDTO from DB by User ID
//     *
//     * @param id
//     * @return
//     */
//    public List<OrderDTO> getAllForUser(int id) {
//        List<Order> all = orderDao.getAllById(id, true);
//        return all.stream().map(orders -> {
//            RepairsTypes repairsTypes = repairTypesDao.getById(orders.getRepairsTypesId(), false);
//            OrderDTO orderDTO = new OrderDTO();
//            orderDTO.setId(orders.getId());
//            orderDTO.setDate(orders.getDate());
//            orderDTO.setRepairsTypes(repairsTypes.getTitle(), false);
//            orderDTO.setPrice(orders.getPrice());
//            orderDTO.setStatus(orders.getStatus());
//
//            return orderDTO;
//        }).collect(Collectors.toList());
//    }
//
//    /**
//     * Converts data from Post request to Order and stores it into DB
//     *
//     * @param date
//     * @param repairTypesId
//     * @param message
//     * @param userId
//     */
//    public void createOrder(LocalDateTime date, int repairTypesId, String message, int userId) {
//        Order order = new Order(date, repairTypesId, userId, Status.NEW);
//        LOG.info("Date =" + date);
//        orderDao.create(order);
//        Order newOrder = orderDao.getByDate(date, true);
//        Comments comments = new Comments(date, message, userId, newOrder.getId());
//        commentsDao.create(comments);
//
//        LOG.info("order create : " + order.toString());
//        LOG.info("comment create : " + comments.toString());
//    }
//
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

    public List<OrderDTO> getAllForChef() {
        List<Order> all = orderDao.getAllByField((Status.IN_PROGRESS).toString());
        return all.stream().map(orders -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(orders.getId());
            orderDTO.setDate(orders.getDate());
            orderDTO.setTotal(orders.getTotal());
            orderDTO.setCustomer(userDao.getById(orders.getUserId()));
            orderDTO.setStatus(orders.getStatus());
            orderDTO.setOrderDish(dishDao.getAllById(orders.getId()));
            return orderDTO;
        }).collect(Collectors.toList());
    }

//    /**
//     * Gets Order by Order ID
//     *
//     * @param id
//     * @return
//     */
//    public OrderDTO getById(int id) {
//        Order order = orderDao.getById(id, true);
//        RepairsTypes repairsTypes = repairTypesDao.getById(order.getRepairsTypesId(), false);
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setId(order.getId());
//        orderDTO.setDate(order.getDate());
//        orderDTO.setRepairsTypes(repairsTypes.getTitle(), false);
//        orderDTO.setPrice(order.getPrice());
//        orderDTO.setCustomer(userDao.getById(order.getUserId(), false));
//        orderDTO.setStatus(order.getStatus());
//        return orderDTO;
//    }
//
//    /**
//     * Changes Order Status depending on Post request
//     *
//     * @param status
//     * @param orderId
//     * @param price
//     */
//    public void changeStatus(String status, String orderId, String price) {
//        int id = tryParse(orderId);
//
//        Order order = orderDao.getById(id, true);
//
//        if (!Strings.isNullOrEmpty(price)) {
//            double doublePrice = 0;
//            try {
//                doublePrice = Double.parseDouble(price);
//            } catch (NumberFormatException e) {
//                LOG.error(e.getMessage());
//            }
//            order.setPrice(doublePrice);
//        }
//
//        order.setStatus(Status.valueOf(status));
//        LOG.info("new order: " + order);
//        orderDao.update(order);
//    }
}

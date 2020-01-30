//package com.restaurant.repository.impl;
//
//import com.restaurant.config.ConnectionFactory;
//import com.restaurant.model.Order;
//import com.restaurant.model.enums.Status;
//import com.restaurant.repository.AbstractDao;
//import com.restaurant.repository.EntityMapper;
//import org.apache.log4j.Logger;
//
//import java.sql.Date;
//import java.util.List;
//
//public class OrderDishDaoImpl extends AbstractDao<Order> {
//    public OrderDishDaoImpl(ConnectionFactory connectionFactory) {
//        super(connectionFactory);
//    }
//
//    private static final Logger LOG = Logger.getLogger(OrderDishDaoImpl.class);
//
//    private static final String COLUMN_ORDER_ID = "orderId";
//    private static final String COLUMN_DISH_ID = "dishId";
//    private static final String COLUMN_QUANTITY = "quantity";
//    private static final String SELECT_ALL_ORDER_DISH = "SELECT * FROM `order`";
//    private static final String SELECT_ALL_BY_ORDER_ID = "SELECT * FROM `order_dish` WHERE orderId = ?";
//
//    private static final String INSERT_INTO_ORDER_DISH = "INSERT INTO `order_dish` ("
//            + COLUMN_ORDER_ID + ", "
//            + COLUMN_DISH_ID + ", "
//            + COLUMN_QUANTITY + ") VALUE (?, ?, ?)";
//
//    private static final String UPDATE_ORDER_DISH = "UPDATE `order_dish` SET "
//            + COLUMN_ORDER_ID + "= ?, "
//            + COLUMN_DISH_ID + "= ?, "
//            + COLUMN_QUANTITY + "= ? WHERE "
//            + COLUMN_ID + " = ?";
//
//    private static final String DELETE_ORDER_DISH = "DELETE FROM `order_dish` "
//            + "WHERE " + COLUMN_ID + " = ?";
//
//    @Override
//    public List<Order> getAllByField(String field) {
//        return getAllByField(SELECT_ALL_ORDER_DISH + "WHERE " + COLUMN_STATUS + "= ?",
//                ps -> ps.setString(1, field),
//                getMapper());
//    }
//
//    public Order getByField(String login) {
//        return getByLogin("SELECT * FROM `order` WHERE status = ?",
//                ps -> ps.setString(1, login),
//                getMapper());
//    }
//
//    @Override
//    public List<Order> getAll() {
//        return getAll(SELECT_ALL_ORDER_DISH, getMapper());
//    }
//
//    @Override
//    public List<Order> getAllPaginated(int page, int size) {
//        return null;
//    }
//
//    @Override
//    public boolean create(Order entity) {
//        LOG.debug("Create order: + " + entity);
//        return createUpdate(INSERT_INTO_ORDER_DISH, ps -> {
//            ps.setDate(1, (Date) entity.getDate());
//            ps.setDouble(2, entity.getTotal());
//            ps.setLong(3, entity.getUserId());
//            ps.setString(4, entity.getStatus().toString());
//        });
//    }
//
//    @Override
//    public boolean update(Order entity) {
//        LOG.debug("Update order: " + entity);
//        return createUpdate(UPDATE_ORDER_DISH, ps -> {
//            ps.setDate(1, (Date) entity.getDate());
//            ps.setDouble(2, entity.getTotal());
//            ps.setLong(3, entity.getUserId());
//            ps.setString(4, entity.getStatus().toString());
//            ps.setLong(5, entity.getId());
//        });
//    }
//
//    @Override
//    public boolean remove(Order entity) {
//        LOG.debug("Delete order: " + entity);
//        return createUpdate(DELETE_ORDER_DISH,
//                ps -> ps.setLong(1, entity.getId()));
//    }
//
//    @Override
//    public List<Order> getAllById(long id) {
//        return getAllById(SELECT_ALL_ORDER_DISH + "WHERE " + COLUMN_USER_ID + "= ?",
//                ps -> ps.setLong(1, id),
//                getMapper());
//    }
//
//    private EntityMapper<Order> getMapper() {
//        return resultSet -> new Order(resultSet.getLong(COLUMN_ID),
//                resultSet.getDate(COLUMN_DATE),
//                resultSet.getDouble(COLUMN_TOTAL),
//                resultSet.getLong(COLUMN_USER_ID),
//                Status.valueOf(resultSet.getString(COLUMN_STATUS)));
//    }
//
//    @Override
//    public Order getById(long id) {
//        return getById("SELECT * FROM `order` WHERE id = ?",
//                ps -> ps.setLong(1, id),
//                getMapper());
//    }
//
//    @Override
//    public Order getByLogin(String login) {
//        return null;
//    }
//}

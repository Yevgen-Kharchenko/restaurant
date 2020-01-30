package com.restaurant.repository.impl;

import com.restaurant.config.ConnectionFactory;
import com.restaurant.controller.view.OrderDTO;
import com.restaurant.model.Order;
import com.restaurant.model.enums.Status;
import com.restaurant.repository.AbstractDao;
import com.restaurant.repository.EntityMapper;
import com.restaurant.repository.GetAllDao;
import com.restaurant.repository.OrderDao;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.util.List;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao, GetAllDao<Order> {
    public OrderDaoImpl(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    private static final Logger LOG = Logger.getLogger(OrderDaoImpl.class);

    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TOTAL = "total";
    private static final String COLUMN_USER_ID = "userId";
    private static final String COLUMN_STATUS = "status";
    private static final String SELECT_ALL_ORDER = "SELECT * FROM `order`";
    private static final String SELECT_ALL_ORDER_BY_USER_ID = "SELECT * FROM `order` WHERE userId = ?";
    private static final String SELECT_ALL_ORDER_PAGINATED = "SELECT * FROM `order` LIMIT ?,?";
    private static final String SELECT_ALL_FOR_CHEF = "SELECT order.id, date, total, order_dish.id," +
            " quantity, name_UK, name_EN FROM `order` " +
            "JOIN order_dish ON order.id = order_dish.orderId " +
            "JOIN dish_menu ON order_dish.dishId = dish_menu.id " +
            "WHERE `status` = \"IN_PROGRESS\"";

    private static final String INSERT_INTO_ORDER = "INSERT INTO `order` ("
            + COLUMN_DATE + ", "
            + COLUMN_TOTAL + ", "
            + COLUMN_USER_ID + ", "
            + COLUMN_STATUS + ") VALUE (?, ?, ?, ?)";

    private static final String UPDATE_ORDER = "UPDATE `order` SET "
            + COLUMN_DATE + "= ?, "
            + COLUMN_TOTAL + "= ?, "
            + COLUMN_USER_ID + "= ?, "
            + COLUMN_STATUS + "= ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_ORDER = "DELETE FROM `order` "
            + "WHERE " + COLUMN_ID + " = ?";

    @Override
    public List<Order> getAllForChef() {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return getAll(SELECT_ALL_ORDER, getMapper());
    }

    @Override
    public List<Order> getAllById(long id) {
        return getAllByField(SELECT_ALL_ORDER + "WHERE " + COLUMN_USER_ID + "= ?",
                ps -> ps.setLong(1, id),
                getMapper());
    }

    @Override
    public List<Order> getAllByField(String field) {
        return getAllByField(SELECT_ALL_ORDER + "WHERE " + COLUMN_STATUS + "= ?",
                ps -> ps.setString(1, field),
                getMapper());
    }

    @Override
    public List<Order> getAllPaginated(int page, int size) {
        int limit = (page - 1) * size;
        return getAll(SELECT_ALL_ORDER_PAGINATED,
                ps -> {
                    ps.setInt(1, limit);
                    ps.setInt(2, size);
                },
                getMapper());
    }

    @Override
    public Order getById(long id) {
        return getByField(SELECT_ALL_ORDER_BY_USER_ID,
                ps -> ps.setLong(1, id),
                getMapper());
    }

    @Override
    public Order create(Order entity) {
        LOG.debug("Create order: + " + entity);
        long id = super.create(INSERT_INTO_ORDER, ps -> {
            ps.setDate(1, (Date) entity.getDate());
            ps.setDouble(2, entity.getTotal());
            ps.setLong(3, entity.getUserId());
            ps.setString(4, entity.getStatus().toString());
        });
        entity.setId(id);
        return entity;
    }

    @Override
    public boolean update(Order entity) {
        LOG.debug("Update order: " + entity);
        return update(UPDATE_ORDER, ps -> {
            ps.setDate(1, (Date) entity.getDate());
            ps.setDouble(2, entity.getTotal());
            ps.setLong(3, entity.getUserId());
            ps.setString(4, entity.getStatus().toString());
            ps.setLong(5, entity.getId());
        });
    }

    @Override
    public boolean remove(Order entity) {
        LOG.debug("Delete order: " + entity);
        return remove(DELETE_ORDER,
                ps -> ps.setLong(1, entity.getId()));
    }

    private EntityMapper<Order> getMapper() {
        return resultSet -> new Order(resultSet.getLong(COLUMN_ID),
                resultSet.getDate(COLUMN_DATE),
                resultSet.getDouble(COLUMN_TOTAL),
                resultSet.getLong(COLUMN_USER_ID),
                Status.valueOf(resultSet.getString(COLUMN_STATUS)));
    }

    private EntityMapper<OrderDTO> getFullMapper() {
        return resultSet -> new OrderDTO(resultSet.getLong(COLUMN_ID),
                resultSet.getDate(COLUMN_DATE),
                resultSet.getDouble(COLUMN_TOTAL),
                resultSet.getLong(COLUMN_USER_ID),
                Status.valueOf(resultSet.getString(COLUMN_STATUS)));
    }
}

package com.restaurant.repository.impl;

import com.restaurant.config.ConnectionFactory;
import com.restaurant.model.OrderDish;
import com.restaurant.repository.AbstractDao;
import com.restaurant.repository.EntityMapper;
import com.restaurant.repository.GetAllDao;
import org.apache.log4j.Logger;

import java.util.List;

public class OrderDishDaoImpl extends AbstractDao<OrderDish> implements GetAllDao<OrderDish> {
    public OrderDishDaoImpl(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    private static final Logger LOG = Logger.getLogger(OrderDishDaoImpl.class);

    private static final String COLUMN_ORDER_ID = "orderId";
    private static final String COLUMN_DISH_ID = "dishId";
    private static final String COLUMN_QUANTITY = "quantity";
    private static final String SELECT_ALL_ORDER_DISH = "SELECT * FROM `order`";
    private static final String SELECT_ALL_ORDER_DISH_PAGINATED = "SELECT * FROM `order_dish` LIMIT ?,?";
    private static final String SELECT_ALL_BY_ORDER_ID = "SELECT order_dish."
            + COLUMN_ID + ", "
            + COLUMN_ORDER_ID + ", "
            + COLUMN_DISH_ID + ", "
            + COLUMN_QUANTITY + ", "
            + DishDaoImpl.COLUMN_NAME_UK + ", "
            + DishDaoImpl.COLUMN_NAME_EN + ", "
            + DishDaoImpl.COLUMN_INGREDIENTS_UK + ", "
            + DishDaoImpl.COLUMN_INGREDIENTS_EN + ", "
            + DishDaoImpl.COLUMN_PRICE +
            " FROM `order_dish` JOIN `dish_menu`" +
            " ON order_dish.dishId = dish_menu.id " +
            "WHERE orderId = ?";


    private static final String INSERT_INTO_ORDER_DISH = "INSERT INTO `order_dish` ("
            + COLUMN_ORDER_ID + ", "
            + COLUMN_DISH_ID + ", "
            + COLUMN_QUANTITY + ") VALUE (?, ?, ?)";

    private static final String UPDATE_ORDER_DISH = "UPDATE `order_dish` SET "
            + COLUMN_ORDER_ID + "= ?, "
            + COLUMN_DISH_ID + "= ?, "
            + COLUMN_QUANTITY + "= ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_ORDER_DISH = "DELETE FROM `order_dish` "
            + "WHERE " + COLUMN_ID + " = ?";

    @Override
    public List<OrderDish> getAll() {
        return getAll(SELECT_ALL_ORDER_DISH, getMapper());
    }

    @Override
    public List<OrderDish> getAllByFieldId(long id) {
        return getAllByField(SELECT_ALL_BY_ORDER_ID,
                ps -> ps.setLong(1, id),
                getFullMapper());
    }

    @Override
    public List<OrderDish> getAllByField(String field) {
        return null;
    }

    @Override
    public List<OrderDish> getAllPaginated(int page, int size) {
        int limit = (page - 1) * size;
        return getAll(SELECT_ALL_ORDER_DISH_PAGINATED,
                ps -> {
                    ps.setInt(1, limit);
                    ps.setInt(2, size);
                },
                getMapper());
    }

    @Override
    public OrderDish getById(long id) {
        return getByField("SELECT * FROM `order_dish` WHERE id = ?",
                ps -> ps.setLong(1, id),
                getMapper());
    }

    @Override
    public OrderDish create(OrderDish entity) {
        LOG.info("Create OrderDish: + " + entity);
        long id = create(INSERT_INTO_ORDER_DISH, ps -> {
            ps.setLong(1, entity.getOrderId());
            ps.setLong(2, entity.getDishId());
            ps.setLong(3, entity.getQuantity());
        });
        entity.setId(id);
        return entity;
    }

    @Override
    public boolean update(OrderDish entity) {
        LOG.debug("Update OrderDish: " + entity);
        return update(UPDATE_ORDER_DISH, ps -> {
            ps.setLong(1, entity.getOrderId());
            ps.setLong(2, entity.getDishId());
            ps.setLong(3, entity.getQuantity());
            ps.setLong(4, entity.getId());
        });
    }

    @Override
    public boolean remove(OrderDish entity) {
        LOG.debug("Delete OrderDish: " + entity);
        return remove(DELETE_ORDER_DISH,
                ps -> ps.setLong(1, entity.getId()));
    }

    private EntityMapper<OrderDish> getMapper() {
        return resultSet -> OrderDish.builder()
                .id(resultSet.getLong(COLUMN_ID))
                .orderId(resultSet.getLong(COLUMN_ORDER_ID))
                .dishId(resultSet.getLong(COLUMN_DISH_ID))
                .quantity(resultSet.getInt(COLUMN_QUANTITY))
                .build();
    }

    private EntityMapper<OrderDish> getFullMapper() {
        return resultSet -> OrderDish.builder()
                .id(resultSet.getLong(COLUMN_ID))
                .orderId(resultSet.getLong(COLUMN_ORDER_ID))
                .dishId(resultSet.getLong(COLUMN_DISH_ID))
                .quantity(resultSet.getInt(COLUMN_QUANTITY))
                .nameUK(resultSet.getString(DishDaoImpl.COLUMN_NAME_UK))
                .nameEN(resultSet.getString(DishDaoImpl.COLUMN_NAME_EN))
                .ingredientsUK(resultSet.getString(DishDaoImpl.COLUMN_INGREDIENTS_UK))
                .ingredientsEN(resultSet.getString(DishDaoImpl.COLUMN_INGREDIENTS_EN))
                .price(resultSet.getDouble(DishDaoImpl.COLUMN_PRICE))
                .build();
    }
}

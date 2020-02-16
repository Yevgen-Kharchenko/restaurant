package com.restaurant.repository.impl;

import com.restaurant.config.ConnectionFactory;
import com.restaurant.model.Dish;
import com.restaurant.model.enums.DishType;
import com.restaurant.repository.AbstractDao;
import com.restaurant.repository.EntityMapper;
import com.restaurant.repository.GetAllDao;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class DishDaoImpl extends AbstractDao<Dish> implements GetAllDao<Dish> {
    private static final Logger LOG = Logger.getLogger(DishDaoImpl.class);

    public DishDaoImpl(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    public static final String COLUMN_DISH_TYPE = "dishType";
    public static final String COLUMN_NAME_UK = "name_UK";
    public static final String COLUMN_NAME_EN = "name_EN";
    public static final String COLUMN_INGREDIENTS_UK = "ingredients_UK";
    public static final String COLUMN_INGREDIENTS_EN = "ingredients_EN";
    public static final String COLUMN_PRICE = "price";
    public static final String IMAGE_NAME = "photo";
    private static final String SELECT_ALL_DISH_MENU = "SELECT * FROM `dish_menu`";
    private static final String SELECT_ALL_DISH_PAGINATED = "SELECT * FROM `dish_menu` LIMIT ?,?";

    private static final String INSERT_INTO_DISH_MENU = "INSERT INTO `dish_menu` ("
            + COLUMN_DISH_TYPE + ", "
            + COLUMN_NAME_UK + ", "
            + COLUMN_NAME_EN + ", "
            + COLUMN_INGREDIENTS_UK + ", "
            + COLUMN_INGREDIENTS_EN + ", "
            + COLUMN_PRICE + ", "
            + IMAGE_NAME + ") VALUE (?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_DISH_MENU = "UPDATE `dish_menu` SET "
            + COLUMN_DISH_TYPE + "= ?, "
            + COLUMN_NAME_UK + "= ?, "
            + COLUMN_NAME_EN + "= ?, "
            + COLUMN_INGREDIENTS_UK + "= ?, "
            + COLUMN_INGREDIENTS_EN + "= ?, "
            + COLUMN_PRICE + "= ?, "
            + IMAGE_NAME + "= ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_DISH_MENU = "DELETE FROM `dish_menu` "
            + "WHERE " + COLUMN_ID + " = ?";

    @Override
    public List<Dish> getAll() {
        return getAll(SELECT_ALL_DISH_MENU, getMapper());
    }

    @Override
    public List<Dish> getAllByFieldId(long id) {
        return getAllByField(SELECT_ALL_DISH_MENU + "WHERE id = ?",
                ps -> ps.setLong(1, id),
                getMapper());
    }

    @Override
    public List<Dish> getAllByField(String field) {
        return getAllByField(SELECT_ALL_DISH_MENU + "WHERE " + COLUMN_DISH_TYPE + "= ?",
                ps -> ps.setString(1, field),
                getMapper());
    }

    @Override
    public List<Dish> getAllPaginated(int page, int size) {
        int limit = (page - 1) * size;
        return getAll(SELECT_ALL_DISH_PAGINATED,
                ps -> {
                    ps.setInt(1, limit);
                    ps.setInt(2, size);
                },
                getMapper());
    }

    @Override
    public Dish getById(long id) {
        return getByField("SELECT * FROM `dish_menu` WHERE id = ?",
                ps -> ps.setLong(1, id),
                getMapper());
    }

    @Override
    public Dish create(Dish entity) {
        LOG.debug("Create Dish: + " + entity);
        long id = super.create(INSERT_INTO_DISH_MENU, ps -> {
            ps.setString(1, entity.getDishType().toString());
            ps.setString(2, entity.getNameUK());
            ps.setString(3, entity.getNameEN());
            ps.setString(4, entity.getIngredientsUK());
            ps.setString(5, entity.getIngredientsEN());
            ps.setBigDecimal(6, BigDecimal.valueOf(entity.getPrice()));
            ps.setString(7, entity.getImageName());
        });
        entity.setId(id);
        return entity;
    }

    @Override
    public boolean update(Dish entity) {
        LOG.debug("Update user: " + entity);
        return update(UPDATE_DISH_MENU, ps -> {
            ps.setString(1, entity.getDishType().toString());
            ps.setString(2, entity.getNameUK());
            ps.setString(3, entity.getNameEN());
            ps.setString(4, entity.getIngredientsUK());
            ps.setString(5, entity.getIngredientsEN());
            ps.setBigDecimal(6, BigDecimal.valueOf(entity.getPrice()));
            ps.setString(7, entity.getImageName());
            ps.setLong(8, entity.getId());
        });
    }

    @Override
    public boolean remove(Dish entity) {
        LOG.debug("Delete user: " + entity);
        return remove(DELETE_DISH_MENU, ps -> ps.setLong(1, entity.getId()));
    }

    private EntityMapper<Dish> getMapper() {
        return resultSet -> new Dish(resultSet.getLong(COLUMN_ID),
                DishType.valueOf(resultSet.getString(COLUMN_DISH_TYPE)),
                resultSet.getString(COLUMN_NAME_UK),
                resultSet.getString(COLUMN_NAME_EN),
                resultSet.getString(COLUMN_INGREDIENTS_UK),
                resultSet.getString(COLUMN_INGREDIENTS_EN),
                resultSet.getDouble(COLUMN_PRICE),
                resultSet.getString(IMAGE_NAME));
    }
}

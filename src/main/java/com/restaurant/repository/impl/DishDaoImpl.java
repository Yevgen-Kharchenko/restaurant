package com.restaurant.repository.impl;

import com.restaurant.config.ConnectionFactory;
import com.restaurant.model.Dish;
import com.restaurant.model.enums.DishType;
import com.restaurant.repository.AbstractDao;
import com.restaurant.repository.EntityMapper;
import com.restaurant.repository.StatementMapper;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class DishDaoImpl extends AbstractDao<Dish> {
    private static final Logger LOG = Logger.getLogger(DishDaoImpl.class);

    public DishDaoImpl(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    private static final String COLUMN_DISH_TYPE = "dishType";
    private static final String COLUMN_NAME_UK = "name_UK";
    private static final String COLUMN_NAME_EN = "name_EN";
    private static final String COLUMN_INGREDIENTS_UK = "ingredients_UK";
    private static final String COLUMN_INGREDIENTS_EN = "ingredients_EN";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_PHOTO = "photo";
    private static final String SELECT_ALL_DISH_MENU = "SELECT * FROM `dish_menu`";
    private static final String SELECT_ALL_DISH_PAGINATED = "SELECT * FROM `dish_menu` LIMIT ?,?";

    private static final String INSERT_INTO_DISH_MENU = "INSERT INTO `dish_menu` ("
            + COLUMN_DISH_TYPE + ", "
            + COLUMN_NAME_UK + ", "
            + COLUMN_NAME_EN + ", "
            + COLUMN_INGREDIENTS_UK + ", "
            + COLUMN_INGREDIENTS_EN + ", "
            + COLUMN_PRICE + ", "
            + COLUMN_PHOTO + ") VALUE (?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_DISH_MENU = "UPDATE `dish_menu` SET "
            + COLUMN_DISH_TYPE + "= ?, "
            + COLUMN_NAME_UK + "= ?, "
            + COLUMN_NAME_EN + "= ?, "
            + COLUMN_INGREDIENTS_UK + "= ?, "
            + COLUMN_INGREDIENTS_EN + "= ?, "
            + COLUMN_PRICE + "= ?, "
            + COLUMN_PHOTO + "= ? WHERE "
            + COLUMN_ID + " = ?";


    private static final String DELETE_DISH_MENU = "DELETE FROM `dish_menu` "
            + "WHERE " + COLUMN_ID + " = ?";


    public Dish getById(long id) {
        return getById("SELECT * FROM `dish_menu` WHERE id = ?",
                ps -> ps.setLong(1, id),
                getMapper());
    }

    public Dish getByLogin(String login) {
        return getByLogin("SELECT * FROM `dish_menu` WHERE login = ?",
                ps -> ps.setString(1, login),
                getMapper());
    }

    @Override
    public Dish getByDate(LocalDateTime date) {
        return null;
    }

    @Override
    public List<Dish> getAllById(long id) {
        return null;
    }

    @Override
    public List<Dish> getAllPaginated(int page, int size) {
        int limit = (page-1)*size;
        return getAll(SELECT_ALL_DISH_PAGINATED,
                ps -> {
            ps.setInt(1,limit);
            ps.setInt(2,size);
                },
                getMapper());
    }

    @Override
    public List<Dish> getAll() {
        return getAll(SELECT_ALL_DISH_MENU, getMapper());
    }

    @Override
    public List<Dish> getAllByField(String field) {
        return getAllByField(SELECT_ALL_DISH_MENU + "WHERE " + COLUMN_DISH_TYPE + "= ?",
                ps -> ps.setString(1, field),
                getMapper());
    }

    private EntityMapper<Dish> getMapper() {
        return resultSet -> new Dish(resultSet.getLong(COLUMN_ID),
                DishType.valueOf(resultSet.getString(COLUMN_DISH_TYPE)),
                resultSet.getString(COLUMN_NAME_UK),
                resultSet.getString(COLUMN_NAME_EN),
                resultSet.getString(COLUMN_INGREDIENTS_UK),
                resultSet.getString(COLUMN_INGREDIENTS_EN),
                resultSet.getDouble(COLUMN_PRICE),
                resultSet.getBlob(COLUMN_PHOTO));
    }

    @Override
    public boolean create(Dish entity) {
        LOG.debug("Create user: + " + entity);
        return createUpdate(INSERT_INTO_DISH_MENU, ps -> {
            ps.setString(1, entity.getDishType().toString());
            ps.setString(2, entity.getNameUK());
            ps.setString(3, entity.getNameEN());
            ps.setString(4, entity.getIngredientsUK());
            ps.setString(5, entity.getIngredientsEN());
            ps.setBigDecimal(6, BigDecimal.valueOf(entity.getPrice()));
            ps.setBlob(7, entity.getImages());
        });
    }

    @Override
    public boolean update(Dish entity) {
        LOG.debug("Update user: " + entity);
        return createUpdate(UPDATE_DISH_MENU, ps -> {
            ps.setString(1, entity.getDishType().toString());
            ps.setString(2, entity.getNameUK());
            ps.setString(3, entity.getNameEN());
            ps.setString(4, entity.getIngredientsUK());
            ps.setString(5, entity.getIngredientsEN());
            ps.setBigDecimal(6, BigDecimal.valueOf(entity.getPrice()));
            ps.setBlob(7, entity.getImages());
            ps.setLong(8, entity.getId());
        });
    }

    @Override
    public boolean remove(Dish entity) {
        LOG.debug("Delete user: " + entity);
        return createUpdate(DELETE_DISH_MENU, ps -> ps.setLong(1, entity.getId()));
    }
}

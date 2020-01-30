package com.restaurant.repository.impl;

import com.restaurant.config.ConnectionFactory;
import com.restaurant.model.User;
import com.restaurant.model.enums.Role;
import com.restaurant.repository.AbstractDao;
import com.restaurant.repository.EntityMapper;
import com.restaurant.repository.GetAllDao;
import com.restaurant.repository.UserDao;
import org.apache.log4j.Logger;

import java.util.List;

public class UserDaoImpl extends AbstractDao<User> implements UserDao, GetAllDao<User> {
    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);

    public UserDaoImpl(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_LOGIN = "login";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ROLE = "role";
    private static final String SELECT_ALL_USERS = "SELECT * FROM `user` ";
    private static final String SELECT_ALL_USERS_PAGINATED = "SELECT * FROM `user` LIMIT ?,?";

    private static final String INSERT_INTO_USER = "INSERT INTO `user` ("
            + COLUMN_NAME + ", "
            + COLUMN_PHONE + ", "
            + COLUMN_LOGIN + ", "
            + COLUMN_PASSWORD + ", "
            + COLUMN_ROLE + ") VALUE (?, ?, ?, ?, ?)";

    private static final String UPDATE_USER = "UPDATE `user` SET "
            + COLUMN_NAME + "= ?, "
            + COLUMN_PHONE + "= ?, "
            + COLUMN_LOGIN + "= ?, "
            + COLUMN_PASSWORD + "= ?, "
            + COLUMN_ROLE + "= ? WHERE "
            + COLUMN_ID + " = ?";


    private static final String DELETE_USER = "DELETE FROM `user` "
            + "WHERE " + COLUMN_ID + " = ?";


    @Override
    public boolean isUserExists(String login) {
        return false;
    }

    @Override
    public boolean isEmailExist(String email) {
        return false;
    }

    @Override
    public User getByLogin(String login) {
        return getByField(SELECT_ALL_USERS + "WHERE login = ?",
                ps -> ps.setString(1, login),
                getMapper());
    }

    @Override
    public List<User> getAll() {
        return getAll(SELECT_ALL_USERS, getMapper());
    }

    @Override
    public List<User> getAllById(long id) {
        return getAllByField(SELECT_ALL_USERS + "WHERE id = ?",
                ps -> ps.setLong(1, id),
                getMapper());
    }

    @Override
    public List<User> getAllByField(String field) {
        return getAllByField(SELECT_ALL_USERS + "WHERE id = ?",
                ps -> ps.setString(1, field),
                getMapper());
    }

    @Override
    public List<User> getAllPaginated(int page, int size) {
        int limit = (page - 1) * size;
        return getAll(SELECT_ALL_USERS_PAGINATED,
                ps -> {
                    ps.setInt(1, limit);
                    ps.setInt(2, size);
                },
                getMapper());
    }

    @Override
    public User getById(long id) {
        return getByField(SELECT_ALL_USERS + "WHERE id = ?",
                ps -> ps.setLong(1, id),
                getMapper());
    }

    @Override
    public User create(User entity) {
        LOG.debug("Create user: + " + entity);
        long id = super.create(INSERT_INTO_USER, ps -> {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getPhone());
            ps.setString(3, entity.getLogin());
            ps.setString(4, entity.getPassword());
            ps.setString(5, entity.getRole().toString());
        });
        entity.setId(id);
        return entity;
    }

    @Override
    public boolean update(User entity) {
        LOG.debug("Update user: " + entity);
        return update(UPDATE_USER, ps -> {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getPhone());
            ps.setString(3, entity.getLogin());
            ps.setString(4, entity.getPassword());
            ps.setString(5, entity.getRole().toString());
            ps.setLong(6, entity.getId());
        });
    }

    @Override
    public boolean remove(User entity) {
        LOG.debug("Delete user: " + entity);
        return remove(DELETE_USER, ps -> ps.setLong(1, entity.getId()));
    }

    private EntityMapper<User> getMapper() {
        return resultSet -> new User(resultSet.getInt(COLUMN_ID),
                resultSet.getString(COLUMN_NAME),
                resultSet.getString(COLUMN_PHONE),
                resultSet.getString(COLUMN_LOGIN),
                resultSet.getString(COLUMN_PASSWORD),
                Role.valueOf(resultSet.getString(COLUMN_ROLE)));
    }
}

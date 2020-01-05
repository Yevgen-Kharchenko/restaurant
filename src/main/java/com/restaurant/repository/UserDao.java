package com.restaurant.repository;

import com.restaurant.model.enums.Role;
import com.restaurant.config.ConnectionFactory;
import com.restaurant.model.User;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

public class UserDao extends AbstractDao<User> {
    private static final Logger LOG = Logger.getLogger(UserDao.class);

    public UserDao(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_LOGIN = "login";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ROLE = "role";
    private static final String SELECT_ALL_USERS = "SELECT * FROM `user`";
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


    public User getById(long id, boolean full) {
        return getById("SELECT * FROM `user` WHERE id = ?",
                ps -> ps.setLong(1, id),
                getMapper());
    }

    public User getByField(String login, boolean full) {
        return getByLogin("SELECT * FROM `user` WHERE login = ?",
                ps -> ps.setString(1, login),
                getMapper());
    }

    @Override
    public User getByDate(LocalDateTime date, boolean full) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return getAll(SELECT_ALL_USERS, getMapper());
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


    private EntityMapper<User> getMapper() {
        return resultSet -> new User(resultSet.getInt(COLUMN_ID),
                resultSet.getString(COLUMN_NAME),
                resultSet.getString(COLUMN_PHONE),
                resultSet.getString(COLUMN_LOGIN),
                resultSet.getString(COLUMN_PASSWORD),
                Role.valueOf(resultSet.getString(COLUMN_ROLE)));
    }

    @Override
    public boolean create(User entity) {
        LOG.debug("Create user: + " + entity);
        return createUpdate(INSERT_INTO_USER, ps -> {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getPhone());
            ps.setString(3, entity.getLogin());
            ps.setString(4, entity.getPassword());
            ps.setString(5, entity.getRole().toString());
        });
    }

    @Override
    public boolean update(User entity) {
        LOG.debug("Update user: " + entity);
        return createUpdate(UPDATE_USER, ps -> {
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
        return createUpdate(DELETE_USER, ps -> ps.setLong(1, entity.getId()));
    }

    @Override
    public List<User> getAllById(long id, boolean full) {
        return null;
    }

}

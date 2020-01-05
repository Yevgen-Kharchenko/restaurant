package com.restaurant.repository;

import com.restaurant.config.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractDao<T> implements EntityDao<T> {
    private static final Logger LOG = Logger.getLogger(AbstractDao.class);

    private final ConnectionFactory connectionFactory;

    protected Connection getConnection() {
        return connectionFactory.getConnection();
    }

    protected static final String COLUMN_ID = "id";

    @Override
    public List<T> getAll(boolean full) {
        return null;
    }

    public List<T> getAll(String query, EntityMapper<T> mapper) {
        List<T> result = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    T entity = mapper.map(resultSet);

                    result.add(entity);
                }
            }
        } catch (SQLException e) {
            LOG.error("Exception while getting all entities", e);
        }

        return result;
    }

    public List<T> getAll(String query, StatementMapper<T> statementMapper, EntityMapper<T> mapper) {
        List<T> result = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            statementMapper.map(preparedStatement);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    T entity = mapper.map(resultSet);

                    result.add(entity);
                }
            }
        } catch (SQLException e) {
            LOG.error("Exception while getting all entities", e);
        }

        return result;
    }

    @Override
    public T getById(long id, boolean full) {
        return null;
    }

    public T getById(String query, StatementMapper<T> statementMapper, EntityMapper<T> mapper) {
        T result = null;

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            statementMapper.map(preparedStatement);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result = mapper.map(resultSet);
                }
            }
        } catch (SQLException e) {
            LOG.error("Exception while getting all entities", e);
        }

        return result;
    }

    public T getByField(String login, boolean full) {
        return null;
    }

    public T getByLogin(String query, StatementMapper<T> statementMapper, EntityMapper<T> mapper) {
        T result = null;

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            statementMapper.map(preparedStatement);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result = mapper.map(resultSet);
                }
            }
        } catch (SQLException e) {
            LOG.error("Exception while getting all entities", e);
        }

        return result;
    }

    public T getByDate(LocalDateTime date, boolean full) {
        return null;
    }

    public T getByDate(String query, StatementMapper<T> statementMapper, EntityMapper<T> mapper) {
        T result = null;

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            statementMapper.map(preparedStatement);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result = mapper.map(resultSet);
                }
            }
        } catch (SQLException e) {
            LOG.error("Exception while getting all entities", e);
        }

        return result;
    }

    public List<T> getAllById(String query, StatementMapper<T> statementMapper, EntityMapper<T> mapper) {
        List<T> result = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            statementMapper.map(preparedStatement);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    T entity = mapper.map(resultSet);
                    result.add(entity);
                }
            }

        } catch (SQLException e) {
            LOG.error("Exception while getting all entities", e);
        }

        return result;
    }

    public boolean createUpdate(String query, StatementMapper<T> statementMapper) {
        try (final Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            statementMapper.map(preparedStatement);
            conn.setAutoCommit(false);

            int result = preparedStatement.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return result == 1;

        } catch (SQLException e) {
            LOG.error("Could not create entity!!", e);
        }

        return false;
    }

    public List<T> getAllByField(String field, boolean full) {
        return null;
    }

    public List<T> getAllByField(String query, StatementMapper<T> statementMapper, EntityMapper<T> mapper) {
        List<T> result = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            statementMapper.map(preparedStatement);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    T entity = mapper.map(resultSet);
                    result.add(entity);
                }
            }

        } catch (SQLException e) {
            LOG.error("Exception while getting all entities", e);
        }

        return result;
    }
}

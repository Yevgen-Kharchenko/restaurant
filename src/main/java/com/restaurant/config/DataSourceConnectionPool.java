package com.restaurant.config;

import com.restaurant.config.transaction.ConnectionHolder;
import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceConnectionPool implements ConnectionFactory {
    private static Logger LOG = Logger.getLogger(DataSourceConnectionPool.class);
    private static final DataSourceConnectionPool INSTANCE = new DataSourceConnectionPool();
    private static DataSource dataSource;

    static {
        try {
            Context initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/restaurant");
        } catch (NamingException e) {
            LOG.error("Could not find DataSource JNDI", e);
        }
    }

    private DataSourceConnectionPool() {
    }

    public Connection getConnection() {

        if (ConnectionHolder.getCurrentConnection() != null) {
            LOG.debug("Connection already exists for thread: " + Thread.currentThread().getName());
            return ConnectionHolder.getCurrentConnection();
        }
        try {
            Connection connection = dataSource.getConnection();
            LOG.debug("New connection received " + connection.toString());
            return connection;
        } catch (SQLException e) {
            LOG.error("Some problem was occurred while getting connection to BD", e);
            throw new RuntimeException(e);
        }
    }

    public static DataSourceConnectionPool getInstance() {
        return INSTANCE;
    }
}

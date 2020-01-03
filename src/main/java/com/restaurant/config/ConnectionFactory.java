package com.restaurant.config;

import java.sql.Connection;

public interface ConnectionFactory {

    Connection getConnection();
}

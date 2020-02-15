package com.restaurant.service;

import com.restaurant.config.DataSourceConnectionPool;
import com.restaurant.config.transaction.TransactionHandler;
import com.restaurant.config.transaction.TransactionManager;

/**
 * The {@code TransactionHandlerFactory} class provides method for provide
 * transaction handler represented by {@link com.restaurant.config.transaction.TransactionHandler} class
 * <p>
 * Properties: <b>TransactionHandlerFactory.TRANSACTION_MANAGER</b>,
 * <b>TransactionHandlerFactory.TRANSACTION_HANDLER</b>,
 *
 * @author
 * @see com.restaurant.config.transaction.TransactionManager
 */

public class TransactionHandlerFactory {
    private static final TransactionManager TRANSACTION_MANAGER = new TransactionManager(
            DataSourceConnectionPool.getInstance()
    );
    private static final TransactionHandler TRANSACTION_HANDLER = new TransactionHandler(TRANSACTION_MANAGER);

    public static TransactionHandler getTransactionHandler() {
        return TRANSACTION_HANDLER;
    }
}

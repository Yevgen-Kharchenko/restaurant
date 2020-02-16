package com.restaurant.config.transaction;

import lombok.AllArgsConstructor;

/**
 * The {@code TransactionHandler} class manages and control the steps of transaction
 * with help of wrapper pattern
 * Properties: <b>transactionManager</b>
 *
 * @see com.restaurant.config.transaction.TransactionManager
 */

@AllArgsConstructor
public class TransactionHandler {
    private final TransactionManager transactionManager;

    public void runInTransaction(Runnable runnable) {
        transactionManager.begin();
        try {
            runnable.run();
            transactionManager.commit();
        } catch (Throwable e) {
            transactionManager.rollback();
            throw e;
        }
    }
}

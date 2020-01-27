package com.restaurant.repository;

import com.restaurant.config.ConnectionFactory;
import com.restaurant.config.DataSourceConnectionPool;
import com.restaurant.model.enums.DaoType;
import com.restaurant.repository.impl.DishDaoImpl;
import com.restaurant.repository.impl.UserDaoImpl;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {

    private static Map<DaoType, EntityDao> daoMap = new HashMap<>();
    private static final ConnectionFactory CONNECTION_FACTORY = DataSourceConnectionPool.getInstance();

    static {
        daoMap.put(DaoType.USER, new UserDaoImpl(CONNECTION_FACTORY));
        daoMap.put(DaoType.DISH, new DishDaoImpl(CONNECTION_FACTORY));
//        daoMap.put(DaoType.COMMENTS, new CommentsDao(CONNECTION_FACTORY));
//        daoMap.put(DaoType.REPAIR, new RepairsTypesDao(CONNECTION_FACTORY));
//        daoMap.put(DaoType.ORDER, new OrderDao(CONNECTION_FACTORY));
    }

    private DaoFactory() {
    }

    public static EntityDao getEntityDao(DaoType daoType) {
        EntityDao entityDao = daoMap.get(daoType);
        if (entityDao != null) {
            return entityDao;
        }
        throw new RuntimeException("Dao with current dao type do not exist: " + daoType.name());
    }

}

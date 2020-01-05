package com.restaurant.repository;

import java.time.LocalDateTime;
import java.util.List;

public interface EntityDao<T> {

    T getById(long id, boolean full);

    T getByField(String login, boolean full);

    T getByDate(LocalDateTime date, boolean full);

    List<T> getAll();


    List<T> getAllPaginated(int page, int size);

    boolean create(T entity);

    boolean update(T entity);

    boolean remove(T entity);

    List<T> getAll(boolean full);

    List<T> getAllById(long id, boolean full);

    List<T> getAllByField(String field, boolean full);

}

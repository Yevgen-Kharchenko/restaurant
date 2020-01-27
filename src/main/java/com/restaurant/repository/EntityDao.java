package com.restaurant.repository;

import java.time.LocalDateTime;
import java.util.List;

public interface EntityDao<T> {

    boolean create(T entity);

    boolean update(T entity);

    boolean remove(T entity);

    List<T> getAll();

    T getById(long id);

    T getByLogin(String login);

    T getByDate(LocalDateTime date);

    List<T> getAllById(long id);

    List<T> getAllByField(String field);

    List<T> getAllPaginated(int page, int size);
}

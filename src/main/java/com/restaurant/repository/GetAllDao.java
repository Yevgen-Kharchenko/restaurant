package com.restaurant.repository;

import java.time.LocalDateTime;
import java.util.List;

public interface GetAllDao<T> {

    List<T> getAll();

    List<T> getAllByFieldId(long id);

    List<T> getAllByField(String field);

    List<T> getAllPaginated(int page, int size);
}

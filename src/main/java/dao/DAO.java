package dao;

import java.util.List;

/**
 * @author Alexander Tsupko (tsupko.alexander@yandex.ru)
 *         Copyright (c) 2016. All rights reserved.
 */
public interface DAO<T> {
    void insert(T entity);

    void delete(T entity);

    void delete(Long id);

    void update(T entity);

    List<T> getAll();

    T getById(Long id);
}

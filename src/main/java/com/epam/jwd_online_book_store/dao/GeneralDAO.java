package com.epam.jwd_online_book_store.dao;

import java.util.List;

public interface GeneralDAO<T> {
    T findById(int id);

    List<T> findAll();

    void create(T t);

    void delete(int id);

    void update(int id, T t);
}

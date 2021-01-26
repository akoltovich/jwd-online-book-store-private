package com.epam.jwd_online_book_store.dao;

import com.epam.jwd_online_book_store.domain.BookOrder;

import java.util.List;

public interface BookOrderDAO extends GeneralDAO<BookOrder> {
    @Override
    BookOrder findById(int id);

    @Override
    List<BookOrder> findAll();

    @Override
    void create(BookOrder bookOrder);

//    @Override
//    void delete(String name);

    @Override
    void delete(int id);

    @Override
    void update(int id, BookOrder bookOrder);
}

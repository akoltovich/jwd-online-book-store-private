package com.epam.jwd_online_book_store.dao;

import com.epam.jwd_online_book_store.domain.BookOrder;
import com.epam.jwd_online_book_store.domain.BookOrderBook;

import java.util.List;

public interface BookOrderDAO extends GeneralDAO<BookOrder> {
    @Override
    BookOrder findById(int id);

    @Override
    List<BookOrder> findAll();

    List<BookOrder> findByUserId(int ordered_by);

    List<BookOrder> findByAdminId(int verified_by);

    void createBookOrderBook(BookOrderBook bookOrderBook);

    BookOrderBook findOrderByOrderId(int orderedBy);

    List<BookOrder> findByOrderStatus(String status);

    @Override
    void create(BookOrder bookOrder);

    @Override
    void delete(int id);

    @Override
    void update(int id, BookOrder bookOrder);
}

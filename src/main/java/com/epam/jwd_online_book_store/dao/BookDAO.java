package com.epam.jwd_online_book_store.dao;

import com.epam.jwd_online_book_store.domain.Book;

import java.util.List;

public interface BookDAO extends GeneralDAO<Book> {
    @Override
    Book findById(int id);

    @Override
    List<Book> findAll();

    @Override
    void create(Book book);

    @Override
    void delete(int id);

    @Override
    void update(int id, Book book);

    List<Book> findByName(String name);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

    List<Book> findByPrice(double from, double to);
}

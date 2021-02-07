package com.epam.jwd_online_book_store.dao.impl;

import com.epam.jwd_online_book_store.connectionPool.DataSource;
import com.epam.jwd_online_book_store.dao.BookDAO;
import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.util.CloseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    private static BookDAOImpl instance;

    public static BookDAOImpl getInstance() {
        if (instance == null) {
            instance = new BookDAOImpl();
        }
        return instance;
    }

    private static final String SQL_FIND_BY_ID = "select * from book where id=?";
    private static final String SQL_FIND_ALL_BOOKS = "select * from book";
    private static final String SQL_CREATE_BOOK = "insert into book (id,name,author,date_of_writing,price,price_per_day,quantity,preview,genre) values (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE_BOOK = "delete from book where id=?";
    private static final String SQL_UPDATE_BOOK = "update book set name=?,author=?,date_of_writing=?,price=?,quantity=?,preview=?,genre=? where id=?";
//            ",price_per_day" +
    private static final String SQL_FIND_BY_NAME = "select * from book where name=?";
    private static final String SQL_FIND_BY_AUTHOR = "select * from book where author=?";
    private static final String SQL_FIND_BY_GENRE = "select * from book where genre=?";
    private static final String SQL_FIND_BY_PRICE = "select * from book where price between ? and ?";

    @Override
    public void create(Book book) {
        Connection connection = DataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_BOOK);
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDate(4, book.getDateOfWriting());
            preparedStatement.setDouble(5, book.getPrice());
            preparedStatement.setDouble(6, book.getPricePerDay());
            preparedStatement.setInt(7, book.getQuantity());
            preparedStatement.setString(8, book.getPreview());
            preparedStatement.setString(9, book.getGenre());
            preparedStatement.executeUpdate();
            CloseUtil.customClose(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book findById(int id) {
        Book book = null;
        Connection connection = DataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = getBookFromResultSet(resultSet);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }


    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        Book book;
        Connection connection = DataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_BOOKS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book = getBookFromResultSet(resultSet);
                books.add(book);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> findByName(String name) {
        Connection connection = DataSource.getConnection();
        List<Book> books = new ArrayList<>();
        Book book;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book = getBookFromResultSet(resultSet);
                books.add(book);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        Connection connection = DataSource.getConnection();
        List<Book> books = new ArrayList<>();
        Book book;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_AUTHOR);
            preparedStatement.setString(1, author);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book = getBookFromResultSet(resultSet);
                books.add(book);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> findByGenre(String genre) {
        Connection connection = DataSource.getConnection();
        List<Book> books = new ArrayList<>();
        Book book;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_GENRE);
            preparedStatement.setString(1, genre);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book = getBookFromResultSet(resultSet);
                books.add(book);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> findByPrice(double from, double to) {
        Connection connection = DataSource.getConnection();
        List<Book> books = new ArrayList<>();
        Book book;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_PRICE);
            preparedStatement.setDouble(1, from);
            preparedStatement.setDouble(2, to);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book = getBookFromResultSet(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void update(int id, Book book) {
        Connection connection = DataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BOOK);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDate(3, book.getDateOfWriting());
            preparedStatement.setDouble(4, book.getPrice());
//            preparedStatement.setDouble(5, book.getPricePerDay());
            preparedStatement.setInt(5, book.getQuantity());
            preparedStatement.setString(6, book.getPreview());
            preparedStatement.setString(7, book.getGenre());
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
            CloseUtil.customClose(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = DataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BOOK);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            CloseUtil.customClose(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    @Override
//    public void delete(String name) {
//        Connection connection = DataSource.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BOOK);
//            preparedStatement.setString(1, name);
//            preparedStatement.executeUpdate();
//            CloseUtil.customClose(connection, preparedStatement);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    private Book getBookFromResultSet(ResultSet resultSet) {
        Book book = new Book();
        try {
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setDateOfWriting(resultSet.getDate("date_of_writing"));
            book.setPrice(resultSet.getDouble("price"));
            book.setPricePerDay(resultSet.getDouble("price_per_day"));
            book.setQuantity(resultSet.getInt("quantity"));
            book.setPreview(resultSet.getString("preview"));
            book.setGenre(resultSet.getString("genre"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}

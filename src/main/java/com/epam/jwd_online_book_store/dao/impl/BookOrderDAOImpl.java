package com.epam.jwd_online_book_store.dao.impl;

import com.epam.jwd_online_book_store.connectionPool.DataSource;
import com.epam.jwd_online_book_store.dao.BookOrderDAO;
import com.epam.jwd_online_book_store.domain.BookOrder;
import com.epam.jwd_online_book_store.util.CloseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookOrderDAOImpl implements BookOrderDAO {

    private static BookOrderDAOImpl instance;

    public static BookOrderDAOImpl getInstance() {
        if (instance == null) {
            instance = new BookOrderDAOImpl();
        }
        return instance;
    }

    private static final String SQL_FIND_ORDER_BY_ID = "select * from book_order where id=?";
    private static final String SQL_FIND_ALL_ORDERS = "select * from book_order";
    private static final String SQL_CREATE_ORDER = "insert into book_order (id,date_of_creation" +
            ",ordered_by,verified_by,order_complete_date,order_status) values (?,?,?,?,?,?)";
    //    private static final String SQL_DELETE_ORDER = "delete from book_order where id=?";
    private static final String SQL_DELETE_ORDER = "delete from book_order where name=?";
    private static final String SQL_UPDATE_ORDER = "update book_order set date_of_creation=?,ordered_by=?," +
            "verified_by=?,order_complete_date=?,order_status=? where id=?";


    @Override
    public BookOrder findById(int id) {
        Connection connection = DataSource.getConnection();
        BookOrder bookOrder = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ORDER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bookOrder = getBookOrderFromResultSet(resultSet);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookOrder;
    }

    @Override
    public List<BookOrder> findAll() {
        Connection connection = DataSource.getConnection();
        List<BookOrder> orders = new ArrayList<>();
        BookOrder bookOrder;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_ORDERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookOrder = getBookOrderFromResultSet(resultSet);
                orders.add(bookOrder);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void create(BookOrder bookOrder) {
        Connection connection = DataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_ORDER);
            preparedStatement.setInt(1, bookOrder.getId());
            preparedStatement.setDate(2, bookOrder.getDateOfCreation());
            preparedStatement.setInt(3, bookOrder.getOrderedBy());
            preparedStatement.setInt(4, bookOrder.getVerifiedBy());
            preparedStatement.setDate(5, bookOrder.getOrderCompleteDate());
            preparedStatement.setString(6, bookOrder.getBookOrderStatus());
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
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_ORDER);
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
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_ORDER);
//            preparedStatement.setString(1, name);
//            preparedStatement.executeUpdate();
//            CloseUtil.customClose(connection, preparedStatement);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void update(int id, BookOrder bookOrder) {
        Connection connection = DataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_ORDER);
            preparedStatement.setDate(1, bookOrder.getDateOfCreation());
            preparedStatement.setInt(2, bookOrder.getOrderedBy());
            preparedStatement.setInt(3, bookOrder.getVerifiedBy());
            preparedStatement.setDate(4, bookOrder.getOrderCompleteDate());
            preparedStatement.setString(5, bookOrder.getBookOrderStatus());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            CloseUtil.customClose(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private BookOrder getBookOrderFromResultSet(ResultSet resultSet) {
        BookOrder bookOrder = new BookOrder();
        try {
            bookOrder.setId(resultSet.getInt("id"));
            bookOrder.setDateOfCreation(resultSet.getDate("date_of_creation"));
            bookOrder.setOrderedBy(resultSet.getInt("ordered_by"));
            bookOrder.setVerifiedBy(resultSet.getInt("verified_by"));
            bookOrder.setOrderCompleteDate(resultSet.getDate("order_complete_date"));
            bookOrder.setBookOrderStatus(resultSet.getString("order_status"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookOrder;
    }
}

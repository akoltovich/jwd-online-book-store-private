package com.epam.jwd_online_book_store.util;

import com.epam.jwd_online_book_store.connectionPool.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CloseUtil {

    public static void customClose(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            connection.close();
            preparedStatement.close();
            resultSet.close();
            DataSource.returnConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void customClose(Connection connection, PreparedStatement preparedStatement) {
        try {
            connection.close();
            preparedStatement.close();
            DataSource.returnConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package com.epam.jwd_online_book_store.connectionPool;

import java.sql.Connection;

public class DataSource {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    public static Connection getConnection() {
        return connectionPool.getConnectionFromPool();
    }

    public static void returnConnection(Connection connection) {
        connectionPool.returnConnectionToPool(connection);
    }
}

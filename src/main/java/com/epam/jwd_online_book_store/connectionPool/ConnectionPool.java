package com.epam.jwd_online_book_store.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static ConnectionPool instance;

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    BlockingQueue<Connection> availableConnections = new ArrayBlockingQueue<>(20);
    Configuration configuration = Configuration.getInstance();

    public ConnectionPool() {
        initConnectionPool();
    }

    private void initConnectionPool() {
        while (!isConnectionPoolIsFull()) {
            availableConnections.add(Objects.requireNonNull(createNewConnectionForPool()));
        }
    }

    private boolean isConnectionPoolIsFull() {
        final int maxPoolSize = configuration.maxConnections;
        return availableConnections.size() >= maxPoolSize;
    }

    private Connection createNewConnectionForPool() {
        try {
            Class.forName(configuration.driver);
            return (Connection) DriverManager.getConnection(configuration.url, configuration.login, configuration.password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnectionFromPool() {
        Connection connection = null;
        if (availableConnections.size() > 0) {
            try {
                connection = availableConnections.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            availableConnections.remove(connection);
        }
        return connection;
    }

    public void returnConnectionToPool(Connection connection) {
        availableConnections.add(connection);
    }
}

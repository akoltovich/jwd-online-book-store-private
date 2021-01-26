package com.epam.jwd_online_book_store.connectionPool;

public class Configuration {

    public String login;

    public String password;

    public String url;

    public String driver;

    public Integer maxConnections;

    public Configuration() {
        init();
    }

    private static Configuration configuration;

    public static Configuration getInstance() {
        if (configuration == null) {
            configuration = new Configuration();
            return configuration;
        }
        return null;
    }

    private void init() {
        login = "root";
        password = "postgres";
        url = "jdbc:mysql://localhost:3306/library?serverTimezone=UTC";
        driver = "com.mysql.jdbc.Driver";
        maxConnections = 20;
    }
}
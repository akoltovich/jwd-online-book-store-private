package com.epam.jwd_online_book_store.dao.impl;

import com.epam.jwd_online_book_store.connectionPool.DataSource;
import com.epam.jwd_online_book_store.dao.UserDAO;
import com.epam.jwd_online_book_store.domain.User;
import com.epam.jwd_online_book_store.util.CloseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static UserDAOImpl instance;

    public static UserDAOImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }


    private static final String SQL_FIND_USER_BY_ID = "select * from app_user where id=?";
    private static final String SQL_FIND_ALL_USERS = "select * from app_user";
    private static final String SQL_CREATE_USER = "insert into app_user (id,login,password,first_name,last_name,role_id,is_banned) values (?,?,?,?,?,?,?)";
        private static final String SQL_DELETE_USER = "delete from app_user where id=?";
//    private static final String SQL_DELETE_USER = "delete from app_user where login=?";
    private static final String SQL_UPDATE_USER = "update app_user set login=?,password=?,first_name=?,last_name=?,role_id=?,is_banned=? where id=?";
    private static final String SQL_FIND_BY_LOGIN = "select * from app_user where login=?";
    private static final String SQL_FIND_BY_FIRST_NAME = "select * from app_user where first_name=?";
    private static final String SQL_FIND_BY_LAST_NAME = "select * from app_user where last_name=?";
    private static final String SQL_FIND_BY_ROLE = "select * from app_user where role_id=?";
    private static final String SQL_FIND_BANNED_USERS = "select * from app_user where is_banned=?";
//    private static final String SQL_


    @Override
    public void create(User user) {
        Connection connection = DataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_USER);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setInt(6, user.getRoleId());
            preparedStatement.setBoolean(7, user.isBanned());
            preparedStatement.executeUpdate();
            CloseUtil.customClose(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        Connection connection = DataSource.getConnection();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = getUserFromResultSet(resultSet);
                CloseUtil.customClose(connection, preparedStatement, resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        Connection connection = DataSource.getConnection();
        List<User> users = new ArrayList<>();
        User user;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = getUserFromResultSet(resultSet);
                users.add(user);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByLogin(String login) {
        Connection connection = DataSource.getConnection();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = getUserFromResultSet(resultSet);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        Connection connection = DataSource.getConnection();
        List<User> users = new ArrayList<>();
        User user;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_FIRST_NAME);
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = getUserFromResultSet(resultSet);
                users.add(user);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> findByLastName(String lastName) {
        Connection connection = DataSource.getConnection();
        List<User> users = new ArrayList<>();
        User user;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_LAST_NAME);
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = getUserFromResultSet(resultSet);
                users.add(user);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> findByRole(int roleId) {
        Connection connection = DataSource.getConnection();
        List<User> users = new ArrayList<>();
        User user;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ROLE);
            preparedStatement.setInt(1, roleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = getUserFromResultSet(resultSet);
                users.add(user);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> findBanned(boolean banned) {
        Connection connection = DataSource.getConnection();
        List<User> users = new ArrayList<>();
        User user;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BANNED_USERS);
            preparedStatement.setBoolean(1, banned);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = getUserFromResultSet(resultSet);
                users.add(user);
            }
            CloseUtil.customClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(int id, User user) {
        Connection connection = DataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setInt(5, user.getRoleId());
            preparedStatement.setBoolean(6, user.isBanned());
            preparedStatement.setInt(7, id);
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
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER);
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
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER);
//            preparedStatement.setString(1, name);
//            preparedStatement.executeUpdate();
//            CloseUtil.customClose(connection, preparedStatement);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    private User getUserFromResultSet(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setRoleId(resultSet.getInt("role_id"));
            user.setBanned(resultSet.getBoolean("is_banned"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}

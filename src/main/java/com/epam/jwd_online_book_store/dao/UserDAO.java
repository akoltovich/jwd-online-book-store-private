package com.epam.jwd_online_book_store.dao;

import com.epam.jwd_online_book_store.domain.User;

import java.util.List;

public interface UserDAO extends GeneralDAO<User> {
    @Override
    User findById(int id);

    @Override
    List<User> findAll();

    @Override
    void create(User user);

//    @Override
//    void delete(String name);

    @Override
    void delete(int id);

    @Override
    void update(int id, User user);

    User findByLogin(String login);

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    List<User> findByRole(int roleId);

    List<User> findBanned(boolean banned);
}

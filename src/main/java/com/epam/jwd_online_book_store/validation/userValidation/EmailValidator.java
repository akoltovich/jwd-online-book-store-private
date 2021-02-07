package com.epam.jwd_online_book_store.validation.userValidation;

import com.epam.jwd_online_book_store.dao.UserDAO;
import com.epam.jwd_online_book_store.dao.impl.UserDAOImpl;
import com.epam.jwd_online_book_store.domain.User;
import com.epam.jwd_online_book_store.exception.UserException;

public class EmailValidator {

    private static final String VALID_EMAIL = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

    public static boolean isValid(String email) throws UserException {
        UserDAO userDAO = UserDAOImpl.getInstance();
        User user = userDAO.findByLogin(email);
        if (email != null && email.matches(VALID_EMAIL) && user == null) {
            return true;
        } else if (user != null) {
            throw new UserException("User with this email already exists");
        } else {
            throw new UserException("Email is incorrect " + email);
        }
    }
}

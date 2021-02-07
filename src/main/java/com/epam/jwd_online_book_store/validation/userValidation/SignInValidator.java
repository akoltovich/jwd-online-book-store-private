package com.epam.jwd_online_book_store.validation.userValidation;

import com.epam.jwd_online_book_store.domain.User;
import com.epam.jwd_online_book_store.exception.UserException;

public class SignInValidator {

    public static boolean isValid(User user, String password) throws UserException {
        if (user == null || !user.getPassword().equals(password)) {
            throw new UserException("Email or password incorrect");
        } else if (user.isBanned()) {
            throw new UserException("You are in ban!");
        } else
            return true;
    }
}

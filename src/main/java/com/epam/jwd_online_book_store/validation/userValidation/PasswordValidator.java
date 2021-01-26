package com.epam.jwd_online_book_store.validation.userValidation;

import com.epam.jwd_online_book_store.exception.UserException;

public class PasswordValidator {
    private static final String VALID_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$";

    public static boolean isValid(String password) throws UserException {
        if (password != null && password.matches(VALID_PASSWORD)) {
            return true;
        } else {
            throw new UserException(password);
        }
    }
}

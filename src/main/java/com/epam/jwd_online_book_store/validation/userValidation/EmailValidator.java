package com.epam.jwd_online_book_store.validation.userValidation;

import com.epam.jwd_online_book_store.exception.UserException;

public class EmailValidator {

    private static final String VALID_EMAIL = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

    public static boolean isValid(String email) throws UserException {
        if (email != null && email.matches(VALID_EMAIL)) {
            return true;
        } else {
            throw new UserException(email);
        }
    }
}

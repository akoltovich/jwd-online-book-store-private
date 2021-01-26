package com.epam.jwd_online_book_store.validation.userValidation;

import com.epam.jwd_online_book_store.exception.UserException;

public class FirstLastNameValidator {
    private static final String VALID_FIRST_LAST_NAME = "^[A-Za-z]{1,20}$";

    public static boolean isValid(String firstOrLastName) throws UserException {
        if (firstOrLastName != null && firstOrLastName.matches(VALID_FIRST_LAST_NAME)) {
            return true;
        } else {
            throw new UserException(firstOrLastName);
        }
    }
}

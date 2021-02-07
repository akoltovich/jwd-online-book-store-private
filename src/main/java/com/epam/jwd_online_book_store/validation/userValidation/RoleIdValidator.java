package com.epam.jwd_online_book_store.validation.userValidation;

import com.epam.jwd_online_book_store.exception.UserException;

public class RoleIdValidator {

    public static boolean isValid(int roleId) throws UserException {
        if (roleId == 1 || roleId == 2) {
            return true;
        } else {
            throw new UserException("Role can be only Admin or User ");
        }
    }
}

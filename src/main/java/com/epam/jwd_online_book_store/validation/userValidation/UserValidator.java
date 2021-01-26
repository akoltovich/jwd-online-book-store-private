package com.epam.jwd_online_book_store.validation.userValidation;

import com.epam.jwd_online_book_store.domain.User;
import com.epam.jwd_online_book_store.exception.UserException;

public class UserValidator {

    public static boolean isValid(User user) throws UserException {
        if (user != null && EmailValidator.isValid(user.getLogin()) && PasswordValidator.isValid(user.getPassword())
                && FirstLastNameValidator.isValid(user.getFirstName()) && FirstLastNameValidator.isValid(user.getLastName())
                && RoleIdValidator.isValid(user.getRoleId())) {
            return true;
        } else {
            throw new UserException(user.toString());
        }
    }
}

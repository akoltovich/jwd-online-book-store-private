package com.epam.jwd_online_book_store.validation.bookValidation;

import com.epam.jwd_online_book_store.exception.BookException;

public class QuantityValidator {
    public static boolean isValid(int quantity) throws BookException {
        if (quantity >= 0) {
            return true;
        } else {
            throw new BookException(String.valueOf(quantity));
        }
    }
}

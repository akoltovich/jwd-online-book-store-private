package com.epam.jwd_online_book_store.validation.bookValidation;

import com.epam.jwd_online_book_store.exception.BookException;

public class PriceValidator {
    public static boolean isValid(double price) throws BookException {
        if (price > 0) {
            return true;
        } else {
            throw new BookException(String.valueOf(price));
        }
    }
}

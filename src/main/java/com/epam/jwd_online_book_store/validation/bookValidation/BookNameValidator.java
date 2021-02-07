package com.epam.jwd_online_book_store.validation.bookValidation;

import com.epam.jwd_online_book_store.exception.BookException;

public class BookNameValidator {
    public static boolean isValid(String bookName) throws BookException {
        if (bookName != null) {
            return true;
        } else {
            throw new BookException("Name of book can't be null ");
        }
    }
}

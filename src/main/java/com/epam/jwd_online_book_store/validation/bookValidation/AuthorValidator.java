package com.epam.jwd_online_book_store.validation.bookValidation;

import com.epam.jwd_online_book_store.exception.BookException;

public class AuthorValidator {

    private static final String VALID_AUTHOR = "^[\\p{L} .'-]+$";

    public static boolean isValid(String authorName) throws BookException {
        if (authorName!=null && authorName.matches(VALID_AUTHOR)) {
            return true;
        } else {
            throw new BookException("This is not valid name for author ");
        }
    }
}

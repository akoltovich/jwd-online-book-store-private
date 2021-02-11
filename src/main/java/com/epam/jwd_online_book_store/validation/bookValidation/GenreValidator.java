package com.epam.jwd_online_book_store.validation.bookValidation;

import com.epam.jwd_online_book_store.exception.BookException;

public class GenreValidator {

    private static final String VALID_GENRE = "^[\\p{L} .'-]+$";

    public static boolean isValid(String genre) throws BookException {
        if (genre != null && genre.matches(VALID_GENRE)){
            return true;
        } else{
            throw new BookException("This is not valid genre ");
        }
    }
}

package com.epam.jwd_online_book_store.validation.bookValidation;

import com.epam.jwd_online_book_store.exception.BookException;

public class PricePerDayValidator {
    public static boolean isValid(double pricePerDay) throws BookException {
        if (pricePerDay > 0) {
            return true;
        } else {
            throw new BookException(String.valueOf(pricePerDay));
        }
    }
}

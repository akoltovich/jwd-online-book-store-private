package com.epam.jwd_online_book_store.validation.bookValidation;

import com.epam.jwd_online_book_store.exception.BookException;

import java.sql.Date;
import java.time.LocalDate;

public class DateOfWritingValidator {
    public static boolean isValid(Date dateOfWriting) throws BookException {
        if (dateOfWriting.before(Date.valueOf(LocalDate.now()))) {
            return true;
        } else {
            throw new BookException("Date of writing must be in past ");
        }
    }
}

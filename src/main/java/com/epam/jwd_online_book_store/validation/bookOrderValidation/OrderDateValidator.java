package com.epam.jwd_online_book_store.validation.bookOrderValidation;

import com.epam.jwd_online_book_store.exception.BookOrderException;

import java.sql.Date;
import java.sql.Timestamp;

public class OrderDateValidator {

    public static boolean isValid(Timestamp dateOfCreation, Timestamp orderCompleteDate) throws BookOrderException {
        if (dateOfCreation.before(orderCompleteDate)) {
            return true;
        } else {
            throw new BookOrderException(orderCompleteDate.toString());
        }
    }
}

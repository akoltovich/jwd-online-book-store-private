package com.epam.jwd_online_book_store.validation.bookOrderValidation;

import com.epam.jwd_online_book_store.domain.BookOrder;
import com.epam.jwd_online_book_store.exception.BookOrderException;

public class BookOrderValidator {

    public static boolean isValid(BookOrder bookOrder) throws BookOrderException {
        if (bookOrder != null && OrderDateValidator.isValid(bookOrder.getDateOfCreation(), bookOrder.getOrderCompleteDate())) {
            return true;
        } else {
            throw new BookOrderException(bookOrder.toString());
        }
    }
}

package com.epam.jwd_online_book_store.validation.bookValidation;

import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.exception.BookException;

public class BookValidator {
    public static boolean isValid(Book book) throws BookException {
        if (book != null && BookNameValidator.isValid(book.getName()) && AuthorValidator.isValid(book.getAuthor())
                && DateOfWritingValidator.isValid(book.getDateOfWriting()) && PriceValidator.isValid(book.getPrice())
//                && PricePerDayValidator.isValid(book.getPricePerDay())
                && QuantityValidator.isValid(book.getQuantity())
                && GenreValidator.isValid(book.getGenre())) {
            return true;
        } else {
            throw new BookException(book.toString());
        }
    }
}

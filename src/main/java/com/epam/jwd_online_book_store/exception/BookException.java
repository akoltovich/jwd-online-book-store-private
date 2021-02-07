package com.epam.jwd_online_book_store.exception;

public class BookException extends Exception {

    private String message;

    public BookException(String message) {
        System.out.println("Book validation failed cause " + message);
        this.message = "Book validation failed cause " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

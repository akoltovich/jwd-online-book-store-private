package com.epam.jwd_online_book_store.exception;

public class BookException extends Exception{
    public BookException(String message) {
        System.out.println("Book validation failed cause " + message + " fields");
    }
}

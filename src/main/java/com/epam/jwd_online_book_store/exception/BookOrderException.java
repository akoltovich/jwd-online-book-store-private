package com.epam.jwd_online_book_store.exception;

public class BookOrderException extends Exception{
    public BookOrderException(String message) {
        System.out.println("Order validation failed cause " + message + " fields");
    }
}

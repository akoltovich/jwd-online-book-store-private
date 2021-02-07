package com.epam.jwd_online_book_store.exception;

public class BookOrderException extends Exception{

    private String message;
    public BookOrderException(String message) {
        System.out.println("Order validation failed cause " + message);
        this.message = "Order validation failed cause " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

package com.epam.jwd_online_book_store.exception;

public class UserException extends Exception{

    private String message;

    public UserException(String message) {
        System.out.println("User validation failed cause " + message);
        this.message = "User validation failed cause " + message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

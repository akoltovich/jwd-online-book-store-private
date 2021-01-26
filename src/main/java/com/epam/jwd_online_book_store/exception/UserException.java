package com.epam.jwd_online_book_store.exception;

public class UserException extends Exception{
    public UserException(String message) {
        System.out.println("User validation failed cause " + message + " fields");
    }
}

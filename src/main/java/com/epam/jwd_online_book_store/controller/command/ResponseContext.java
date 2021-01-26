package com.epam.jwd_online_book_store.controller.command;

public interface ResponseContext {

    enum ResponseType {
        FORWARD,
        REDIRECT
    }

    ResponseType getResponseType();

    String getPage();
}

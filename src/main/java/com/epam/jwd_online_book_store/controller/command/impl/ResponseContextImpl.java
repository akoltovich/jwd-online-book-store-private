package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.controller.command.ResponseContext;

public class ResponseContextImpl implements ResponseContext {

    String page;
    ResponseType responseType;

    public ResponseContextImpl(String page, ResponseType responseType) {
        this.page = page;
        this.responseType = responseType;
    }

    @Override
    public ResponseType getResponseType() {
        return responseType;
    }

    @Override
    public String getPage() {
        return page;
    }
}

package com.epam.jwd_online_book_store.controller.command;

public interface Command {
    ResponseContext execute(RequestContext requestContext);
}

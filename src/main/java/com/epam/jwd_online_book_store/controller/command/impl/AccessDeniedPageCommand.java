package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;

public class AccessDeniedPageCommand implements Command {

    private static final ResponseContext ACCESS_DENIED_PAGE = new ResponseContextImpl(PathToPages.ACCESS_DENIED, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        return ACCESS_DENIED_PAGE;
    }
}

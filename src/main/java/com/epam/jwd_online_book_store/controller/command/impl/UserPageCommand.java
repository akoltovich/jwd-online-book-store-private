package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;

public class UserPageCommand implements Command {

    private static final ResponseContext USER_PAGE = new ResponseContextImpl(PathToPages.USER_PAGE, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        return USER_PAGE;
    }
}

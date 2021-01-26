package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;

public class StartPageCommand implements Command {

    private static final ResponseContext START_PAGE = new ResponseContextImpl(PathToPages.START_PAGE, ResponseContext.ResponseType.FORWARD);
//private static final ResponseContext MAIN_PAGE = new ResponseContextImpl(PathToPages.MAIN_PAGE, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        return START_PAGE;
    }
}

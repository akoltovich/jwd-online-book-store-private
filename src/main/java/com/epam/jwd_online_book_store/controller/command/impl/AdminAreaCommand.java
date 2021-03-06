package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;

public class AdminAreaCommand implements Command {

    private static final ResponseContext ADMIN_AREA = new ResponseContextImpl(PathToPages.ADMIN_AREA, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        return ADMIN_AREA;
    }
}

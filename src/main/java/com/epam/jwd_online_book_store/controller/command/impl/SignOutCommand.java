package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;

import javax.servlet.http.HttpSession;

public class SignOutCommand implements Command {

    private static final ResponseContext MAIN_PAGE = new ResponseContextImpl(PathToPages.MAIN_PAGE, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        HttpSession session = requestContext.getSession();
        session.removeAttribute("user");
        return MAIN_PAGE;
    }
}

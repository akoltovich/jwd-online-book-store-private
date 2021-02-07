package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.exception.UserException;
import com.epam.jwd_online_book_store.service.AdminService;

public class BanUserCommand implements Command {

    private static final ResponseContext ADMIN_PAGE_REDIRECT = new ResponseContextImpl(PathToPages.ADMIN_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext BAN_USER = new ResponseContextImpl(PathToPages.BAN_USER, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext ERROR_PAGE = new ResponseContextImpl(PathToPages.ERROR500_PAGE, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return BAN_USER;
        }
        AdminService service = AdminService.getInstance();
        String login = requestContext.getParameter("login");
        try {
            service.banUser(login);
        } catch (UserException e) {
            e.printStackTrace();
            requestContext.setAttribute("exception", e);
            return ERROR_PAGE;
        }
        return ADMIN_PAGE_REDIRECT;
    }
}

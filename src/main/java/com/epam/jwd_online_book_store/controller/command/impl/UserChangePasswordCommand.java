package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.exception.UserException;
import com.epam.jwd_online_book_store.service.UserService;

public class UserChangePasswordCommand implements Command {
    private static final ResponseContext SIGN_IN_REDIRECT = new ResponseContextImpl(PathToPages.SIGN_IN_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext USER_CHANGE_PASSWORD = new ResponseContextImpl(PathToPages.USER_CHANGE_PASSWORD, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext ERROR_PAGE = new ResponseContextImpl(PathToPages.ERROR500_PAGE, ResponseContext.ResponseType.FORWARD);


    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return USER_CHANGE_PASSWORD;
        }
        UserService service = UserService.getInstance();
        String userLogin = requestContext.getParameter("login");
        String newPassword = requestContext.getParameter("new_password");
        try {
            service.updatePassword(userLogin, newPassword);
        } catch (UserException e) {
            e.printStackTrace();
            requestContext.setAttribute("exception", e);
            return ERROR_PAGE;
        }
        return SIGN_IN_REDIRECT;
    }
}

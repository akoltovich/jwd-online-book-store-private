package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.UserException;
import com.epam.jwd_online_book_store.service.UserService;

import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {

    private static final ResponseContext ERROR_PAGE = new ResponseContextImpl(PathToPages.ERROR500_PAGE, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext ADMIN_PAGE_REDIRECT = new ResponseContextImpl(PathToPages.ADMIN_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext USER_PAGE_REDIRECT = new ResponseContextImpl(PathToPages.USER_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext MAIN_PAGE = new ResponseContextImpl(PathToPages.MAIN_PAGE, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext SIGN_IN_PAGE = new ResponseContextImpl(PathToPages.SIGN_IN_PAGE, ResponseContext.ResponseType.FORWARD);


    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return SIGN_IN_PAGE;
        }
        UserService userService = UserService.getInstance();
        String login = requestContext.getParameter("login");
        String password = requestContext.getParameter("password");
        UserDTO user;
        try {
            user = userService.signIn(login, password);
        } catch (UserException e) {
            e.printStackTrace();
            requestContext.setAttribute("exception", e);
            return ERROR_PAGE;
        }
        if (user != null) {
            HttpSession session = requestContext.getSession();
            session.setAttribute("user", user);
            if (user.getRoleId() == 2) {
                return USER_PAGE_REDIRECT;
            } else if (user.getRoleId() == 1) {
                return ADMIN_PAGE_REDIRECT;
            }
        }
//        } else {
//            return ERROR_PAGE;
//        }
        return SIGN_IN_PAGE;
    }
}

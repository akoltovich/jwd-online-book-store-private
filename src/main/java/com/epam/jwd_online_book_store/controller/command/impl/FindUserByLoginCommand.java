package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.UserException;
import com.epam.jwd_online_book_store.service.AdminService;

public class FindUserByLoginCommand implements Command {

    private static final ResponseContext USER_BY_LOGIN = new ResponseContextImpl(PathToPages.USER_BY_LOGIN, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext USER_BY_LOGIN_REDIRECT = new ResponseContextImpl(PathToPages.USER_BY_LOGIN_REDIRECT, ResponseContext.ResponseType.REDIRECT);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return USER_BY_LOGIN;
        }
        AdminService service = AdminService.getInstance();
        String login = requestContext.getParameter("login");
        try {
            UserDTO user = service.getUserByLogin(login);
            requestContext.setAttribute("user", user);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return USER_BY_LOGIN_REDIRECT;
    }
}

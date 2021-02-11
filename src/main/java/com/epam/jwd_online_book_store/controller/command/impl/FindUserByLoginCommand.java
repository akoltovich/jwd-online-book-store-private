package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.service.AdminService;

public class FindUserByLoginCommand implements Command {

    private static final ResponseContext USER_BY_LOGIN = new ResponseContextImpl(PathToPages.USER_BY_LOGIN, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return USER_BY_LOGIN;
        }
        AdminService service = AdminService.getInstance();
        String login = requestContext.getParameter("login");
        UserDTO user = service.getUserByLogin(login);
        if (user != null && user.getRoleId() == 2) {
            requestContext.setAttribute("user", user);
        } else {
            String empty = "We dont have user with email like that";
            requestContext.setAttribute("empt", empty);
        }
        return USER_BY_LOGIN;
    }
}

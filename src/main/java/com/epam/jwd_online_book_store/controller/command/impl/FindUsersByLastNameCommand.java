package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.UserException;
import com.epam.jwd_online_book_store.service.AdminService;

import java.util.List;

public class FindUsersByLastNameCommand implements Command {
    private static final ResponseContext USERS_BY_LAST_NAME = new ResponseContextImpl(PathToPages.USERS_BY_LAST_NAME, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext USERS_BY_LAST_NAME_REDIRECT = new ResponseContextImpl(PathToPages.USERS_BY_LAST_NAME_REDIRECT, ResponseContext.ResponseType.REDIRECT);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return USERS_BY_LAST_NAME;
        }
        AdminService service = AdminService.getInstance();
        String lastName = requestContext.getParameter("last_name");
        try {
            List<UserDTO> users = service.getUsersByLastName(lastName);
            requestContext.setAttribute("users", users);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return USERS_BY_LAST_NAME_REDIRECT;
    }
}
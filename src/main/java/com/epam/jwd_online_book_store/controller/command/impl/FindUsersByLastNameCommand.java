package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.service.AdminService;

import java.util.List;

public class FindUsersByLastNameCommand implements Command {
    private static final ResponseContext USERS_BY_LAST_NAME = new ResponseContextImpl(PathToPages.USERS_BY_LAST_NAME, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return USERS_BY_LAST_NAME;
        }
        AdminService service = AdminService.getInstance();
        String lastName = requestContext.getParameter("last_name");
        List<UserDTO> users = service.getUsersByLastName(lastName);
        if (!users.isEmpty()) {
            requestContext.setAttribute("users", users);
        } else {
            String empty = "We dont have users with this last name";
            requestContext.setAttribute("empt", empty);
        }
        return USERS_BY_LAST_NAME;
    }
}

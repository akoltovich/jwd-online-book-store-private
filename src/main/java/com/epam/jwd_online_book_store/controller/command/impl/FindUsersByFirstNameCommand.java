package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.service.AdminService;

import java.util.List;

public class FindUsersByFirstNameCommand implements Command {

    private static final ResponseContext USERS_BY_FIRST_NAME = new ResponseContextImpl(PathToPages.USERS_BY_FIRST_NAME, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return USERS_BY_FIRST_NAME;
        }
        AdminService service = AdminService.getInstance();
        String firstName = requestContext.getParameter("first_name");
        List<UserDTO> users = service.getUsersByFirstName(firstName);
        if (!users.isEmpty()) {
            requestContext.setAttribute("users", users);
        } else {
            String empty = "We don't have users with this name!";
            requestContext.setAttribute("empt", empty);
        }
        return USERS_BY_FIRST_NAME;
    }
}

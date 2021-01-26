package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.UserException;
import com.epam.jwd_online_book_store.service.AdminService;

import java.util.List;

public class ShowAllUsersCommand implements Command {

    private static final ResponseContext ALL_USERS = new ResponseContextImpl(PathToPages.ALL_USERS, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        AdminService service = AdminService.getInstance();
        try {
            List<UserDTO> users = service.getAllUsers();
            requestContext.setAttribute("users", users);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return ALL_USERS;
    }
}

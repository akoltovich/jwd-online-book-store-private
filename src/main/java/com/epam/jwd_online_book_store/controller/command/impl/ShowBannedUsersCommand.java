package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.service.AdminService;

import java.util.List;

public class ShowBannedUsersCommand implements Command {

    private static final ResponseContext BANNED_USERS = new ResponseContextImpl(PathToPages.BANNED_USERS, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        AdminService service = AdminService.getInstance();
        List<UserDTO> users = service.getBannedUsers();
        if (!users.isEmpty()) {
            requestContext.setAttribute("users", users);
        } else {
            String empty = "We don't have banned users";
            requestContext.setAttribute("empt", empty);
        }
        return BANNED_USERS;
    }
}

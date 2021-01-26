package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.service.UserService;

public class UserChangeLastNameCommand implements Command {
    private static final ResponseContext ADMIN_AREA_REDIRECT = new ResponseContextImpl(PathToPages.ADMIN_AREA_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext USER_AREA_REDIRECT = new ResponseContextImpl(PathToPages.USER_AREA_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext USER_CHANGE_LAST_NAME = new ResponseContextImpl(PathToPages.USER_CHANGE_LAST_NAME, ResponseContext.ResponseType.FORWARD);


    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return USER_CHANGE_LAST_NAME;
        }
        UserService service = UserService.getInstance();
        String newLastName = requestContext.getParameter("new_last_name");
        UserDTO user = (UserDTO) requestContext.getSession().getAttribute("user");
        service.updateLastName(user, newLastName);
        if (user.getRoleId() == 1) {
            return ADMIN_AREA_REDIRECT;
        } else if (user.getRoleId() == 2) {
            return USER_AREA_REDIRECT;
        }
        return USER_CHANGE_LAST_NAME;
    }
}

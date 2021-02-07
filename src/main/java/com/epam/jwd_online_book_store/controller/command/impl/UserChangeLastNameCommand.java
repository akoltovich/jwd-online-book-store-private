package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.UserException;
import com.epam.jwd_online_book_store.service.UserService;

public class UserChangeLastNameCommand implements Command {
    private static final ResponseContext ADMIN_AREA_REDIRECT = new ResponseContextImpl(PathToPages.ADMIN_AREA_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext USER_AREA_REDIRECT = new ResponseContextImpl(PathToPages.USER_AREA_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext USER_CHANGE_LAST_NAME = new ResponseContextImpl(PathToPages.USER_CHANGE_LAST_NAME, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext ERROR_PAGE = new ResponseContextImpl(PathToPages.ERROR500_PAGE, ResponseContext.ResponseType.FORWARD);


    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return USER_CHANGE_LAST_NAME;
        }
        UserService service = UserService.getInstance();
        String newLastName = requestContext.getParameter("new_last_name");
        UserDTO user = (UserDTO) requestContext.getSession().getAttribute("user");
        try {
            service.updateLastName(user, newLastName);
            user.setLastName(newLastName);
        } catch (UserException e) {
            e.printStackTrace();
            requestContext.setAttribute("exception", e);
            return ERROR_PAGE;
        }
        requestContext.getSession().invalidate();
        requestContext.getSession().setAttribute("user", user);
        if (user.getRoleId() == 1) {
            return ADMIN_AREA_REDIRECT;
        } else if (user.getRoleId() == 2) {
            return USER_AREA_REDIRECT;
        }
        return USER_CHANGE_LAST_NAME;
    }
}

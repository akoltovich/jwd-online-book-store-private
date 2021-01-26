package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.domain.User;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.UserException;
import com.epam.jwd_online_book_store.service.UserService;

import javax.servlet.http.HttpSession;

public class RegistrationCommand implements Command {

    private static final ResponseContext REGISTER_PAGE = new ResponseContextImpl(PathToPages.REGISTER_PAGE, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext USER_PAGE_REDIRECT = new ResponseContextImpl(PathToPages.USER_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext ERROR_PAGE = new ResponseContextImpl(PathToPages.ERROR_PAGE, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext ADMIN_PAGE_REDIRECT = new ResponseContextImpl(PathToPages.ADMIN_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
//    private static final ResponseContext MAIN_PAGE = new ResponseContextImpl(PathToPages.MAIN_PAGE, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return REGISTER_PAGE;
        }
        UserService service = UserService.getInstance();
        String login = requestContext.getParameter("login");
        String password = requestContext.getParameter("password");
        String firstName = requestContext.getParameter("first_name");
        String lastName = requestContext.getParameter("last_name");
        String roleId = requestContext.getParameter("role_id");
        HttpSession session = requestContext.getSession();
        User user;
        try {
            user = service.registration(new UserDTO(login, password, firstName, lastName, Integer.parseInt(roleId)));
        } catch (UserException e) {
            e.printStackTrace();
            return ERROR_PAGE;
        }
        session.setAttribute("user", user);
        if (user.getRoleId() == 2) {
            return USER_PAGE_REDIRECT;
        } else if (user.getRoleId() == 1) {
            return ADMIN_PAGE_REDIRECT;
        }
        return REGISTER_PAGE;
//        return MAIN_PAGE;
    }
}

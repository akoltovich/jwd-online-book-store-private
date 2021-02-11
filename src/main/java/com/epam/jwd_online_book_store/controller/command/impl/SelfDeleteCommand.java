package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.service.UserService;

import javax.servlet.http.HttpSession;

public class SelfDeleteCommand implements Command {

    private static final ResponseContext MAIN_PAGE = new ResponseContextImpl(PathToPages.MAIN_PAGE, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        UserService service = UserService.getInstance();
        HttpSession session = requestContext.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");
        service.selfDelete(user);
        return MAIN_PAGE;
    }
}

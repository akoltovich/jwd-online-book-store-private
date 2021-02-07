package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.BookOrderException;
import com.epam.jwd_online_book_store.service.UserService;

public class DeleteOrderCommand implements Command {

    private static final ResponseContext DELETE_ORDER = new ResponseContextImpl(PathToPages.DELETE_ORDER, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext SHOW_ALL_USER_ORDERS_REDIRECT = new ResponseContextImpl(PathToPages.SHOW_ALL_USER_ORDERS_REDIRECT, ResponseContext.ResponseType.REDIRECT);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return DELETE_ORDER;
        }
        UserService service = UserService.getInstance();
        String id = requestContext.getParameter("order_id");
        UserDTO userDTO = (UserDTO) requestContext.getSession().getAttribute("user");
        try {
            service.deleteOrder(Integer.parseInt(id), userDTO.getLogin());
        } catch (BookOrderException e) {
            e.printStackTrace();
            requestContext.setAttribute("exception", e);
        }
        return SHOW_ALL_USER_ORDERS_REDIRECT;
    }
}

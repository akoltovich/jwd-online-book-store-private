package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.BookException;
import com.epam.jwd_online_book_store.service.UserService;

public class OrderBookCommand implements Command {

    private static final ResponseContext ORDER_BOOK = new ResponseContextImpl(PathToPages.ORDER_BOOK, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext SHOW_USER_ORDERS_REDIRECT = new ResponseContextImpl(PathToPages.SHOW_ALL_USER_ORDERS_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext ERROR_PAGE = new ResponseContextImpl(PathToPages.ERROR500_PAGE, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return ORDER_BOOK;
        }
        UserService service = UserService.getInstance();
        String bookId = requestContext.getParameter("book_id");
        int id;
        try {
            id = Integer.parseInt(bookId);
        } catch (NumberFormatException e) {
            id = 0;
        }
        UserDTO userDTO = (UserDTO) requestContext.getSession().getAttribute("user");
        try {
            service.createBookOrder(id, userDTO.getLogin());
        } catch (BookException e) {
            e.printStackTrace();
            requestContext.setAttribute("exception", e);
            return ERROR_PAGE;
        }
        return SHOW_USER_ORDERS_REDIRECT;
    }
}

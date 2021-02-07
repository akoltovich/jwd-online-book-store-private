package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.domain.BookOrder;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.BookOrderException;
import com.epam.jwd_online_book_store.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShowAllUserOrdersCommand implements Command {

    private static final ResponseContext SHOW_ALL_USER_ORDERS = new ResponseContextImpl(PathToPages.SHOW_ALL_USER_ORDERS, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        UserService service = UserService.getInstance();
        UserDTO userDTO = (UserDTO) requestContext.getSession().getAttribute("user");
        Map<BookOrder, Book> orders = null;
//        try {
            orders = service.getAllUserOrders(userDTO.getLogin());
            if (!orders.isEmpty()) {
                requestContext.setAttribute("orders", orders);
            } else {
                String empty = "Sorry, you don't have orders";
                requestContext.setAttribute("empt", empty);
            }
//        } catch (BookOrderException e) {
//            e.printStackTrace();
//            requestContext.setAttribute("exception", e);
//        }
        return SHOW_ALL_USER_ORDERS;
    }
}

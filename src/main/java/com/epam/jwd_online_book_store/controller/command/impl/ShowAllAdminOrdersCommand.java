package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.domain.BookOrder;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.service.AdminService;
import com.epam.jwd_online_book_store.service.UserService;

import java.util.Map;

public class ShowAllAdminOrdersCommand implements Command {

    private static final ResponseContext SHOW_ALL_ADMIN_ORDERS = new ResponseContextImpl(PathToPages.SHOW_ALL_ADMIN_ORDERS, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        AdminService service = AdminService.getInstance();
        UserDTO userDTO = (UserDTO) requestContext.getSession().getAttribute("user");
        Map<BookOrder, Book> orders = service.getAllAdminOrders(userDTO.getLogin());
        if (!orders.isEmpty()) {
            requestContext.setAttribute("orders", orders);
        } else {
            String empty = "Sorry, you don't have orders";
            requestContext.setAttribute("empt", empty);
        }
        return SHOW_ALL_ADMIN_ORDERS;
    }
}

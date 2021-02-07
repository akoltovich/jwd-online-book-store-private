package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.domain.BookOrder;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.service.AdminService;

import java.util.ArrayList;
import java.util.List;

public class ShowAllOrdersByStatusCommand implements Command {

    private static final ResponseContext SHOW_ALL_ORDERS_BY_STATUS = new ResponseContextImpl(PathToPages.SHOW_ORDERS_BY_STATUS, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext FIND_ORDERS_BY_STATUS = new ResponseContextImpl(PathToPages.FIND_ORDERS_BY_STATUS, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return FIND_ORDERS_BY_STATUS;
        }
        AdminService service = AdminService.getInstance();
        List<BookOrder> orders = new ArrayList<>();
        String status = requestContext.getParameter("status");
        UserDTO userDTO = (UserDTO) requestContext.getSession().getAttribute("user");
        orders = service.findOrderByStatus(status, userDTO.getLogin());
        if (!orders.isEmpty()) {
            requestContext.setAttribute("orders", orders);
        } else {
            String empty = "No orders with this status";
            requestContext.setAttribute("empt", empty);
        }
        return SHOW_ALL_ORDERS_BY_STATUS;
    }
}

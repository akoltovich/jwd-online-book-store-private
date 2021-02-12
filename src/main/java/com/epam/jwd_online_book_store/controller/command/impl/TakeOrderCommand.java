package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.BookOrderException;
import com.epam.jwd_online_book_store.service.AdminService;

public class TakeOrderCommand implements Command {

    private static final ResponseContext TAKE_ORDER = new ResponseContextImpl(PathToPages.TAKE_ORDER, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext SHOW_ALL_ADMIN_ORDERS = new ResponseContextImpl(PathToPages.SHOW_ALL_ADMIN_ORDERS_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext ERROR_PAGE = new ResponseContextImpl(PathToPages.ERROR500_PAGE, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return TAKE_ORDER;
        }
        AdminService service = AdminService.getInstance();
        String id = requestContext.getParameter("order_id");
        UserDTO userDTO = (UserDTO) requestContext.getSession().getAttribute("user");
        int parseId;
        try {
            parseId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            parseId = 0;
        }
        try {
            service.takeOrder(parseId, userDTO.getLogin());
        } catch (BookOrderException e) {
            e.printStackTrace();
            requestContext.setAttribute("exception", e);
            return ERROR_PAGE;
        }
        return SHOW_ALL_ADMIN_ORDERS;
    }
}

package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.service.UserService;

import java.util.List;

public class FindBooksByPriceCommand implements Command {

    private static final ResponseContext BOOKS_BY_PRICE = new ResponseContextImpl(PathToPages.BOOKS_BY_PRICE, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return BOOKS_BY_PRICE;
        }
        UserService service = UserService.getInstance();
        String from = requestContext.getParameter("from");
        String to = requestContext.getParameter("to");
        double fr;
        double t;
        try {
            fr = Double.parseDouble(from);
            t = Double.parseDouble(to);
        } catch (NumberFormatException e) {
            fr = 0;
            t = 0;
        }
        List<Book> books = service.findBooksByPrice(fr, t);
        if (!books.isEmpty()) {
            requestContext.setAttribute("books", books);
        } else {
            String empty = "Sorry, we don't have books with this price";
            requestContext.setAttribute("empt", empty);
        }
        return BOOKS_BY_PRICE;
    }
}

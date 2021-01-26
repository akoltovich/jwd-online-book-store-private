package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.dto.BookDTO;
import com.epam.jwd_online_book_store.exception.BookException;
import com.epam.jwd_online_book_store.service.UserService;

import java.util.List;

public class FindBooksByPriceCommand implements Command {

    private static final ResponseContext BOOKS_BY_PRICE = new ResponseContextImpl(PathToPages.BOOKS_BY_PRICE, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext BOOKS_BY_PRICE_REDIRECT = new ResponseContextImpl(PathToPages.BOOKS_BY_PRICE_REDIRECT, ResponseContext.ResponseType.REDIRECT);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return BOOKS_BY_PRICE;
        }
        UserService service = UserService.getInstance();
        String from = requestContext.getParameter("from");
        String to = requestContext.getParameter("to");
        try {
            List<Book> books = service.findBooksByPrice(Double.parseDouble(from), Double.parseDouble(to));
            requestContext.setAttribute("books", books);
        } catch (BookException e) {
            e.printStackTrace();
        }
        return BOOKS_BY_PRICE_REDIRECT;
    }
}

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

public class FindBooksByNameCommand implements Command {

    private final static ResponseContext BOOKS_BY_NAME = new ResponseContextImpl(PathToPages.BOOKS_FIND_BY_NAME, ResponseContext.ResponseType.FORWARD);
    private final static ResponseContext BOOKS_BY_NAME_REDIRECT = new ResponseContextImpl(PathToPages.BOOKS_FIND_BY_NAME_REDIRECT, ResponseContext.ResponseType.REDIRECT);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return BOOKS_BY_NAME;
        }
        UserService userService = UserService.getInstance();
        String name = requestContext.getParameter("name");
        try {
            List<Book> book = userService.findBooksByName(name);
            requestContext.setAttribute("books", book);
        } catch (BookException e) {
            e.printStackTrace();
        }
        return BOOKS_BY_NAME_REDIRECT;
    }
}

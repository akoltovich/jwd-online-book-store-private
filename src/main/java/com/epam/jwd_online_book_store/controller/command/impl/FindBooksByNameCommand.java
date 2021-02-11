package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.service.UserService;

import java.util.List;

public class FindBooksByNameCommand implements Command {

    private final static ResponseContext BOOKS_BY_NAME = new ResponseContextImpl(PathToPages.BOOKS_FIND_BY_NAME, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return BOOKS_BY_NAME;
        }
        UserService userService = UserService.getInstance();
        String name = requestContext.getParameter("name");
        List<Book> books = userService.findBooksByName(name);
        if (!books.isEmpty()) {
            requestContext.setAttribute("books", books);
        } else {
            String empty = "Sorry, we don't have books with this name";
            requestContext.setAttribute("empt", empty);
        }
        return BOOKS_BY_NAME;
    }
}

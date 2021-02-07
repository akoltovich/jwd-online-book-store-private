package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.exception.BookException;
import com.epam.jwd_online_book_store.service.UserService;

import java.util.List;

public class FindBooksByAuthorCommand implements Command {

    private static final ResponseContext BOOKS_BY_AUTHOR = new ResponseContextImpl(PathToPages.BOOKS_BY_AUTHOR, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext BOOKS_BY_AUTHOR_REDIRECT = new ResponseContextImpl(PathToPages.BOOKS_BY_AUTHOR_REDIRECT, ResponseContext.ResponseType.REDIRECT);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return BOOKS_BY_AUTHOR;
        }
        UserService service = UserService.getInstance();
        String author = requestContext.getParameter("author");
//        try {
            List<Book> books = service.findBooksByAuthor(author);
        if (!books.isEmpty()) {
            requestContext.setAttribute("books", books);
        } else {
            String empty = "Sorry, we don't have books of this author";
            requestContext.setAttribute("empt", empty);
        }
//        } catch (BookException e) {
//            e.printStackTrace();
//        }
        return BOOKS_BY_AUTHOR;
    }
}

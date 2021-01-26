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

public class ShowAllBooksCommand implements Command {

    private static final ResponseContext ALL_BOOKS = new ResponseContextImpl(PathToPages.ALL_BOOKS, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        UserService service = UserService.getInstance();
        try {
            List<Book> books = service.findAllBooks();
            requestContext.setAttribute("books", books);
        } catch (BookException e) {
            e.printStackTrace();
        }
        return ALL_BOOKS;
    }
}

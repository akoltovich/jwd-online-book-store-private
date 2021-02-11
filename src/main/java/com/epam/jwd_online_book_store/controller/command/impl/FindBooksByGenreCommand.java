package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.service.UserService;

import java.util.List;

public class FindBooksByGenreCommand implements Command {

    private static final ResponseContext BOOKS_BY_GENRE = new ResponseContextImpl(PathToPages.BOOKS_BY_GENRE, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return BOOKS_BY_GENRE;
        }
        UserService service = UserService.getInstance();
        String genre = requestContext.getParameter("genre");
        List<Book> books = service.findBooksByGenre(genre);
        if (!books.isEmpty()) {
            requestContext.setAttribute("books", books);
        } else {
            String empty = "Sorry, we don't have books in this genre";
            requestContext.setAttribute("empt", empty);
        }
        return BOOKS_BY_GENRE;
    }
}

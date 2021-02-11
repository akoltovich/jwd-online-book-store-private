package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.service.AdminService;

public class DeleteBookCommand implements Command {

    private static final ResponseContext ALL_BOOKS = new ResponseContextImpl(PathToPages.ALL_BOOKS, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext ALL_BOOKS_REDIRECT = new ResponseContextImpl(PathToPages.ALL_BOOKS_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext DELETE_BOOK = new ResponseContextImpl(PathToPages.DELETE_BOOK, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return DELETE_BOOK;
        }
        AdminService service = AdminService.getInstance();
        String id = requestContext.getParameter("id");
        service.deleteBook(Integer.parseInt(id));
        return ALL_BOOKS_REDIRECT;
    }
}

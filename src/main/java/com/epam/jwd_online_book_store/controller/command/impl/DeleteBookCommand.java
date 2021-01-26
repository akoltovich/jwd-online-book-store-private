package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.dto.BookDTO;
import com.epam.jwd_online_book_store.service.AdminService;

import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

public class DeleteBookCommand implements Command {

    //    private static final ResponseContext ADMIN_PAGE = () -> "WEB-INF/jsp/admin_page.jsp";
    private static final ResponseContext ALL_BOOKS = new ResponseContextImpl(PathToPages.ALL_BOOKS, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext ALL_BOOKS_REDIRECT = new ResponseContextImpl(PathToPages.ALL_BOOKS_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext DELETE_BOOK = new ResponseContextImpl(PathToPages.DELETE_BOOK, ResponseContext.ResponseType.REDIRECT);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return ALL_BOOKS;
        }
        AdminService service = AdminService.getInstance();
        String id = requestContext.getParameter("id");
        service.deleteBook(Integer.parseInt(id));
        return ALL_BOOKS_REDIRECT;
    }
}

package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.dto.BookDTO;
import com.epam.jwd_online_book_store.service.AdminService;

import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

public class DeleteBookCommand implements Command {

    //    private static final ResponseContext ADMIN_PAGE = () -> "WEB-INF/jsp/admin_page.jsp";
    private static final ResponseContext ALL_BOOKS = new ResponseContextImpl(PathToPages.ALL_BOOKS, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext ALL_BOOKS_REDIRECT = new ResponseContextImpl(PathToPages.ALL_BOOKS_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext DELETE_BOOK = new ResponseContextImpl(PathToPages.DELETE_BOOK, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return DELETE_BOOK;
        }
        AdminService service = AdminService.getInstance();
//        Book book =(Book) requestContext.getSession().getAttribute("book");
        String id = requestContext.getParameter("id");
        service.deleteBook(Integer.parseInt(id));
//        service.deleteBook(book.getId());
        return ALL_BOOKS_REDIRECT;
    }
}

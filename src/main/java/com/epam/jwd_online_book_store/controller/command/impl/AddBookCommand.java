package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.exception.BookException;
import com.epam.jwd_online_book_store.service.AdminService;

import java.sql.Date;

public class AddBookCommand implements Command {

    private static final ResponseContext ADMIN_AREA_REDIRECT = new ResponseContextImpl(PathToPages.ADMIN_AREA_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    private static final ResponseContext ADD_BOOK = new ResponseContextImpl(PathToPages.ADD_BOOK, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext ERROR_PAGE = new ResponseContextImpl(PathToPages.ERROR500_PAGE, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return ADD_BOOK;
        }
        AdminService service = AdminService.getInstance();
        String name = requestContext.getParameter("name");
        String author = requestContext.getParameter("author");
        String dateOfWriting = requestContext.getParameter("date_of_writing");
        String price = requestContext.getParameter("price");
        String quantity = requestContext.getParameter("quantity");
        String preview = requestContext.getParameter("preview");
        String genre = requestContext.getParameter("genre");
        Date parseDate = null;
        double parsePrice = 0;
        int parseQuantity = 0;
        if (!dateOfWriting.equals("")) {
            parseDate = Date.valueOf(dateOfWriting);
        }
        if (!price.equals("")) {
            parsePrice = Double.parseDouble(price);
        }
        if (!quantity.equals("")) {
            parseQuantity = Integer.parseInt(quantity);
        }
        try {
            service.addBook(new Book(name, author, parseDate, parsePrice, parseQuantity, preview, genre));
        } catch (BookException e) {
            e.printStackTrace();
            requestContext.setAttribute("exception", e);
            return ERROR_PAGE;
        }
        return ADMIN_AREA_REDIRECT;
    }
}

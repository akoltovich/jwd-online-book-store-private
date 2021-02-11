package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.context.PathToPages;
import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.RequestContext;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.exception.BookException;
import com.epam.jwd_online_book_store.service.AdminService;

import java.sql.Date;

public class UpdateBookCommand implements Command {

    private static final ResponseContext UPDATE_BOOK = new ResponseContextImpl(PathToPages.UPDATE_BOOK, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext ERROR_PAGE = new ResponseContextImpl(PathToPages.ERROR500_PAGE, ResponseContext.ResponseType.FORWARD);
    private static final ResponseContext ADMIN_PAGE_REDIRECT = new ResponseContextImpl(PathToPages.ADMIN_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getRequestMethod().equals("GET")) {
            return UPDATE_BOOK;
        }
        AdminService service = AdminService.getInstance();
        String id = requestContext.getParameter("id");
        String name = requestContext.getParameter("name");
        String author = requestContext.getParameter("author");
        String dateOfWriting = requestContext.getParameter("date_of_writing");
        String price = requestContext.getParameter("price");
        String quantity = requestContext.getParameter("quantity");
        String preview = requestContext.getParameter("preview");
        String genre = requestContext.getParameter("genre");
        int parseId = 0;
        Date newDate = null;
        double newPrice = 0;
        int newQuantity = 0;
        if (!id.equals("")) {
            parseId = Integer.parseInt(id);
        }
        if (!dateOfWriting.equals("")) {
            newDate = Date.valueOf(dateOfWriting);
        }
        if (!price.equals("")) {
            newPrice = Double.parseDouble(price);
        }
        if (!quantity.equals("")) {
            newQuantity = Integer.parseInt(quantity);
        }
        try {
            service.updateBook(parseId, name, author, newDate, newPrice, newQuantity, preview, genre);
        } catch (BookException e) {
            e.printStackTrace();
            requestContext.setAttribute("exception", e);
            return ERROR_PAGE;
        }
        return ADMIN_PAGE_REDIRECT;
    }
}

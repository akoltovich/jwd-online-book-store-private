//package com.epam.jwd_online_book_store.controller.command.impl;
//
//import com.epam.jwd_online_book_store.context.PathToPages;
//import com.epam.jwd_online_book_store.controller.command.Command;
//import com.epam.jwd_online_book_store.controller.command.RequestContext;
//import com.epam.jwd_online_book_store.controller.command.ResponseContext;
//
//public class BookDetailsCommand implements Command {
//
//    private static final ResponseContext BOOK_DETAILS = new ResponseContextImpl(PathToPages.BOOK_DETAILS, ResponseContext.ResponseType.FORWARD);
//
//    @Override
//    public ResponseContext execute(RequestContext requestContext) {
//        return BOOK_DETAILS;
//    }
//}

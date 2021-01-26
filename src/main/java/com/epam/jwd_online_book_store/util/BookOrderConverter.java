package com.epam.jwd_online_book_store.util;

import com.epam.jwd_online_book_store.domain.BookOrder;
import com.epam.jwd_online_book_store.dto.BookOrderDTO;

import java.util.ArrayList;
import java.util.List;

public class BookOrderConverter {

    public static BookOrderDTO bookOrderToBookOrderDTO(BookOrder bookOrder) {
        BookOrderDTO bookOrderDTO = new BookOrderDTO();
        bookOrderDTO.setDateOfCreation(bookOrder.getDateOfCreation());
        bookOrderDTO.setOrderedBy(bookOrder.getOrderedBy());
        bookOrderDTO.setVerifiedBy(bookOrder.getVerifiedBy());
        bookOrderDTO.setOrderCompleteDate(bookOrder.getOrderCompleteDate());
        bookOrderDTO.setBookOrderStatus(bookOrder.getBookOrderStatus());
        return bookOrderDTO;
    }

    public static List<BookOrderDTO> listOfBookOrderToListOfBookOrderDTO(List<BookOrder> bookOrders) {
        List<BookOrderDTO> bookOrderDTOS = new ArrayList<>();
        for (BookOrder bookOrder : bookOrders) {
            BookOrderDTO bookOrderDTO = new BookOrderDTO();
            bookOrderDTO.setDateOfCreation(bookOrder.getDateOfCreation());
            bookOrderDTO.setOrderedBy(bookOrder.getOrderedBy());
            bookOrderDTO.setVerifiedBy(bookOrder.getVerifiedBy());
            bookOrderDTO.setOrderCompleteDate(bookOrder.getOrderCompleteDate());
            bookOrderDTO.setBookOrderStatus(bookOrder.getBookOrderStatus());
            bookOrderDTOS.add(bookOrderDTO);
        }
        return bookOrderDTOS;
    }

    public static BookOrder bookOrderDTOToBookOrder(BookOrderDTO bookOrderDTO) {
        BookOrder bookOrder = new BookOrder();
        bookOrder.setDateOfCreation(bookOrderDTO.getDateOfCreation());
        bookOrder.setOrderedBy(bookOrderDTO.getOrderedBy());
        bookOrder.setVerifiedBy(bookOrderDTO.getVerifiedBy());
        bookOrder.setOrderCompleteDate(bookOrderDTO.getOrderCompleteDate());
        bookOrder.setBookOrderStatus(bookOrderDTO.getBookOrderStatus());
        return bookOrder;
    }

    public static List<BookOrder> listOfBookOrderDTOToListOfBookOrder(List<BookOrderDTO> bookOrderDTOS) {
        List<BookOrder> bookOrders = new ArrayList<>();
        for (BookOrderDTO bookOrderDTO : bookOrderDTOS) {
            BookOrder bookOrder = new BookOrder();
            bookOrder.setDateOfCreation(bookOrderDTO.getDateOfCreation());
            bookOrder.setOrderedBy(bookOrderDTO.getOrderedBy());
            bookOrder.setVerifiedBy(bookOrderDTO.getVerifiedBy());
            bookOrder.setOrderCompleteDate(bookOrderDTO.getOrderCompleteDate());
            bookOrder.setBookOrderStatus(bookOrderDTO.getBookOrderStatus());
            bookOrders.add(bookOrder);
        }
        return bookOrders;
    }
}

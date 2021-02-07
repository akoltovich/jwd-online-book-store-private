package com.epam.jwd_online_book_store.domain;

public class BookOrderBook {
    private int bookId;
    private int orderId;

    public BookOrderBook() {
    }

    public BookOrderBook(int bookId, int orderId) {
        this.bookId = bookId;
        this.orderId = orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "BookOrderBook{" +
                "bookId=" + bookId +
                ", orderId=" + orderId +
                '}';
    }
}

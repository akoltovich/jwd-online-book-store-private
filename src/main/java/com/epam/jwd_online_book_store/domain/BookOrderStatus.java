package com.epam.jwd_online_book_store.domain;

public class BookOrderStatus {
    private String status;

    public BookOrderStatus() {
    }

    public BookOrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

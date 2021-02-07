package com.epam.jwd_online_book_store.domain;

public enum BookOrderStatus {
    AWAITING_CONFIRMATION("Awaiting confirmation"),
    IN_PROGRESS("In progress"),
    COMPLETED("Completed");

    private String status;

    BookOrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

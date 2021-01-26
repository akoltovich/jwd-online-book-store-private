package com.epam.jwd_online_book_store.dto;

import java.sql.Date;

public class BookOrderDTO {
    private Date dateOfCreation;
    private int orderedBy;
    private int verifiedBy;
    private Date orderCompleteDate;
    private String bookOrderStatus;

    public BookOrderDTO(Date dateOfCreation, int orderedBy, int verifiedBy, Date orderCompleteDate, String bookOrderStatus) {
        this.dateOfCreation = dateOfCreation;
        this.orderedBy = orderedBy;
        this.verifiedBy = verifiedBy;
        this.orderCompleteDate = orderCompleteDate;
        this.bookOrderStatus = bookOrderStatus;
    }

    public BookOrderDTO() {
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(int orderedBy) {
        this.orderedBy = orderedBy;
    }

    public int getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(int verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public Date getOrderCompleteDate() {
        return orderCompleteDate;
    }

    public void setOrderCompleteDate(Date orderCompleteDate) {
        this.orderCompleteDate = orderCompleteDate;
    }

    public String getBookOrderStatus() {
        return bookOrderStatus;
    }

    public void setBookOrderStatus(String bookOrderStatus) {
        this.bookOrderStatus = bookOrderStatus;
    }
}

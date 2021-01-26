package com.epam.jwd_online_book_store.domain;

import java.sql.Date;
import java.util.Objects;

public class BookOrder {
    private int id;
    private Date dateOfCreation;
    private int orderedBy;
    private int verifiedBy;
    private Date orderCompleteDate;
    private String bookOrderStatus;

    public BookOrder() {
    }

    public BookOrder( Date dateOfCreation, int orderedBy, int verifiedBy, Date orderCompleteDate, String bookOrderStatus) {
        this.dateOfCreation = dateOfCreation;
        this.orderedBy = orderedBy;
        this.verifiedBy = verifiedBy;
        this.orderCompleteDate = orderCompleteDate;
        this.bookOrderStatus = bookOrderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookOrder bookOrder = (BookOrder) o;
        return id == bookOrder.id &&
                dateOfCreation.equals(bookOrder.dateOfCreation) &&
                orderedBy == bookOrder.orderedBy &&
                verifiedBy == bookOrder.verifiedBy &&
                Objects.equals(orderCompleteDate, bookOrder.orderCompleteDate) &&
                bookOrderStatus == bookOrder.bookOrderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfCreation, orderedBy, verifiedBy, orderCompleteDate, bookOrderStatus);
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "id=" + id +
                ", dateOfCreation=" + dateOfCreation +
                ", requestedBy=" + orderedBy +
                ", verifiedBy=" + verifiedBy +
                ", orderCompleteDate=" + orderCompleteDate +
                ", bookOrderStatus=" + bookOrderStatus +
                '}';
    }
}

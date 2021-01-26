package com.epam.jwd_online_book_store.dto;

import java.sql.Date;

public class BookDTO {
    private String name;
    private String author;
    private Date dateOfWriting;
    private double price;
    private double pricePerDay;
    private int quantity;
    private String preview;
    private String genre;

    public BookDTO(String name, String author, Date dateOfWriting, double price, double pricePerDay, int quantity, String preview, String genre) {
        this.name = name;
        this.author = author;
        this.dateOfWriting = dateOfWriting;
        this.price = price;
        this.pricePerDay = pricePerDay;
        this.quantity = quantity;
        this.preview = preview;
        this.genre = genre;
    }

    public BookDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(Date dateOfWriting) {
        this.dateOfWriting = dateOfWriting;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
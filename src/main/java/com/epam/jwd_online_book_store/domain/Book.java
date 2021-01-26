package com.epam.jwd_online_book_store.domain;

import java.sql.Date;
import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private String author;
    private Date dateOfWriting;
    private double price;
    private double pricePerDay;
    private int quantity;
    private String preview;
    private String genre;

    public Book() {
    }

    public Book(String name, String author, Date dateOfWriting, double price, double pricePerDay, int quantity, String genre, String preview) {
        this.name = name;
        this.author = author;
        this.dateOfWriting = dateOfWriting;
        this.price = price;
        this.pricePerDay = pricePerDay;
        this.quantity = quantity;
        this.genre = genre;
        this.preview = preview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                quantity == book.quantity &&
                id == book.id &&
                name.equals(book.name) &&
                author.equals(book.author) &&
                genre.equals(book.genre) &&
                Objects.equals(preview, book.preview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, price, quantity, genre, preview);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", genre='" + genre + '\'' +
                ", preview='" + preview + '\'' +
                '}';
    }
}

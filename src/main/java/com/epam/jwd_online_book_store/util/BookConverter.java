package com.epam.jwd_online_book_store.util;

import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.dto.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class BookConverter {

    public static BookDTO bookToBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setName(book.getName());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setDateOfWriting(book.getDateOfWriting());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setPricePerDay(book.getPricePerDay());
        bookDTO.setQuantity(book.getQuantity());
        bookDTO.setPreview(book.getPreview());
        bookDTO.setGenre(book.getGenre());
        return bookDTO;
    }

    public static List<BookDTO> listOfBookToListOfBookDTO(List<Book> books) {
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setName(book.getName());
            bookDTO.setAuthor(book.getAuthor());
            bookDTO.setDateOfWriting(book.getDateOfWriting());
            bookDTO.setPrice(book.getPrice());
            bookDTO.setPricePerDay(book.getPricePerDay());
            bookDTO.setQuantity(book.getQuantity());
            bookDTO.setPreview(book.getPreview());
            bookDTO.setGenre(book.getGenre());
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    public static Book bookDTOToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setDateOfWriting(bookDTO.getDateOfWriting());
        book.setPrice(bookDTO.getPrice());
        book.setPricePerDay(bookDTO.getPricePerDay());
        book.setQuantity(bookDTO.getQuantity());
        book.setPreview(bookDTO.getPreview());
        book.setGenre(bookDTO.getGenre());
        return book;

    }

    public static List<Book> listOfBookDTOToListOfBook(List<BookDTO> bookDTOS) {
        List<Book> books = new ArrayList<>();
        for (BookDTO bookDTO : bookDTOS) {
            Book book = new Book();
            book.setName(bookDTO.getName());
            book.setAuthor(bookDTO.getAuthor());
            book.setDateOfWriting(bookDTO.getDateOfWriting());
            book.setPrice(bookDTO.getPrice());
            book.setPricePerDay(bookDTO.getPricePerDay());
            book.setQuantity(bookDTO.getQuantity());
            book.setPreview(bookDTO.getPreview());
            book.setGenre(bookDTO.getGenre());
            books.add(book);
        }
        return books;
    }
}

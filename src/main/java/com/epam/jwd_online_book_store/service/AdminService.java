package com.epam.jwd_online_book_store.service;

import com.epam.jwd_online_book_store.dao.BookDAO;
import com.epam.jwd_online_book_store.dao.BookOrderDAO;
import com.epam.jwd_online_book_store.dao.UserDAO;
import com.epam.jwd_online_book_store.dao.impl.BookDAOImpl;
import com.epam.jwd_online_book_store.dao.impl.BookOrderDAOImpl;
import com.epam.jwd_online_book_store.dao.impl.UserDAOImpl;
import com.epam.jwd_online_book_store.domain.*;
import com.epam.jwd_online_book_store.dto.BookDTO;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.BookException;
import com.epam.jwd_online_book_store.exception.BookOrderException;
import com.epam.jwd_online_book_store.exception.UserException;
import com.epam.jwd_online_book_store.util.BookConverter;
import com.epam.jwd_online_book_store.util.UserConverter;
import com.epam.jwd_online_book_store.validation.bookValidation.BookValidator;
import com.epam.jwd_online_book_store.validation.userValidation.EmailValidator;
import com.epam.jwd_online_book_store.validation.userValidation.FirstLastNameValidator;
import com.epam.jwd_online_book_store.validation.userValidation.UserValidator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class AdminService {
    private static AdminService instance;

    public static AdminService getInstance() {
        if (instance == null) {
            instance = new AdminService();
        }
        return instance;
    }

    UserDAO userDAO = UserDAOImpl.getInstance();
    BookDAO bookDAO = BookDAOImpl.getInstance();
    BookOrderDAO bookOrderDAO = BookOrderDAOImpl.getInstance();

    public List<UserDTO> getAllUsers() {
        List<User> users = userDAO.findAll();
        List<User> onlyUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getRoleId() == 2) {
                onlyUsers.add(user);
            }
        }
        return UserConverter.listOfUserToListOfUserDTO(onlyUsers);
//        if (!userDTOS.isEmpty()) {
//            return userDTOS;
//        } else {
//            throw new UserException("We dont have users:(");
//        }

    }

    public List<UserDTO> getUsersByFirstName(String firstName) {
        List<User> users = new ArrayList<>();
//        if (FirstLastNameValidator.isValid(firstName)) {
        users.addAll(userDAO.findByFirstName(firstName));
        List<User> onlyUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getRoleId() == 2) {
                onlyUsers.add(user);
            }
        }
//        }
        return UserConverter.listOfUserToListOfUserDTO(onlyUsers);
    }

    public List<UserDTO> getUsersByLastName(String lastName) {
        List<User> users = new ArrayList<>();
//        if (FirstLastNameValidator.isValid(lastName)) {
        users.addAll(userDAO.findByLastName(lastName));
        List<User> onlyUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getRoleId() == 2) {
                onlyUsers.add(user);
            }
        }
//        }
        return UserConverter.listOfUserToListOfUserDTO(onlyUsers);
    }


    public UserDTO getUserByLogin(String login) {
//        if (EmailValidator.isValid(login)) {
        User user = userDAO.findByLogin(login);
//        }
        return UserConverter.userToUserDTO(user);
    }

    public List<UserDTO> getBannedUsers() {
        List<User> users = new ArrayList<>(userDAO.findBanned(true));
        return UserConverter.listOfUserToListOfUserDTO(users);
    }

    public Book addBook(Book book) throws BookException {
        if (BookValidator.isValid(book)) {
            bookDAO.create(book);
        }
        return book;
    }

    public void deleteBook(int id) {
        Book book = bookDAO.findById(id);
        bookDAO.delete(book.getId());
    }

    public void updateBook(int id, String newName, String newAuthor, Date newDateOfWriting, double newPrice,
                           int newQuantity, String newPreview, String newGenre) throws BookException {
        Book updatedBook = bookDAO.findById(id);
        if (newName.equals("")) {
            newName = updatedBook.getName();
        }
        if (newAuthor.equals("")) {
            newAuthor = updatedBook.getAuthor();
        }
        if (newDateOfWriting == null) {
            newDateOfWriting = updatedBook.getDateOfWriting();
        }
        if (newPrice == 0) {
            newPrice = updatedBook.getPrice();
        }
        if (newQuantity == 0) {
            newQuantity = updatedBook.getQuantity();
        }
        if (newPreview.equals("")) {
            newPreview = updatedBook.getPreview();
        }
        if (newGenre.equals("")) {
            newGenre = updatedBook.getGenre();
        }
        Book newBook = new Book(newName, newAuthor, newDateOfWriting, newPrice, newQuantity, newPreview, newGenre);
//        try {
        if (BookValidator.isValid(newBook)) {
            bookDAO.update(updatedBook.getId(), newBook);
        }
//        } catch (BookException e) {
//            e.printStackTrace();
//        }
    }

    public void banUser(String login) throws UserException {
        User user = userDAO.findByLogin(login);
        if (user.getRoleId() == 2 && !user.isBanned()) {
            user.setBanned(true);
            userDAO.update(user.getId(), user);
//        }
        } else if (user.getRoleId() != 2) {
            throw new UserException("You can ban only users!");
        } else if (user.isBanned()) {
            throw new UserException("User already in ban");
        }
    }

    public void unbanUser(String login) throws UserException {
        User user = userDAO.findByLogin(login);
        if (user.getRoleId() == 2 && user.isBanned()) {
            user.setBanned(false);
            userDAO.update(user.getId(), user);
//        }
        } else if (user.getRoleId() != 2) {
            throw new UserException("You can unban only users!");
        } else if (!user.isBanned()) {
            throw new UserException("User not in ban");
        }
    }

    //    public List<BookOrder> findOrderByStatus(String status) {
//        List<BookOrder> orders = new ArrayList<>();
//        if (status.equals(BookOrderStatus.AWAITING_CONFIRMATION.getStatus())) {
//            orders = bookOrderDAO.findByOrderStatus(BookOrderStatus.AWAITING_CONFIRMATION.getStatus());
//        } else if (status.equals(BookOrderStatus.IN_PROGRESS.getStatus())) {
//            orders = bookOrderDAO.findByOrderStatus(BookOrderStatus.IN_PROGRESS.getStatus());
//        } else if (status.equals(BookOrderStatus.COMPLETED.getStatus())) {
//            orders = bookOrderDAO.findByOrderStatus(BookOrderStatus.COMPLETED.getStatus());
//        }
//        return orders;
//    }
    public List<BookOrder> findOrderByStatus(String status, String login) {
        User user = userDAO.findByLogin(login);
        List<BookOrder> orders = new ArrayList<>();
        if (status.equals(BookOrderStatus.AWAITING_CONFIRMATION.getStatus())) {
            orders = bookOrderDAO.findByOrderStatus(BookOrderStatus.AWAITING_CONFIRMATION.getStatus());
        } else if (status.equals(BookOrderStatus.IN_PROGRESS.getStatus())) {
            orders = bookOrderDAO.findByOrderStatus(BookOrderStatus.IN_PROGRESS.getStatus());
        } else if (status.equals(BookOrderStatus.COMPLETED.getStatus())) {
            orders = bookOrderDAO.findByOrderStatus(BookOrderStatus.COMPLETED.getStatus());
        }
        List<BookOrder> ordersForAdmin = new ArrayList<>();
        for (BookOrder order : orders) {
            if (order.getVerifiedBy() == 0 || order.getVerifiedBy() == user.getId()) {
                ordersForAdmin.add(order);
            }
        }
        return ordersForAdmin;
    }

    public void takeOrder(int id, String login) throws BookOrderException {
        User user = userDAO.findByLogin(login);
        BookOrder order = bookOrderDAO.findById(id);
        if (order.getBookOrderStatus().equals(BookOrderStatus.AWAITING_CONFIRMATION.getStatus())) {
            bookOrderDAO.update(id, new BookOrder(order.getDateOfCreation(), order.getOrderedBy(), user.getId(), order.getOrderCompleteDate(), BookOrderStatus.IN_PROGRESS.getStatus()));
        } else
            throw new BookOrderException("You can take only awaiting orders");
    }

    public void completeOrder(int id) throws BookOrderException {
        BookOrder order = bookOrderDAO.findById(id);
        BookOrderBook bookOrderBook = bookOrderDAO.findOrderByOrderId(order.getId());
        Book book = bookDAO.findById(bookOrderBook.getBookId());
        if (order.getBookOrderStatus().equals(BookOrderStatus.IN_PROGRESS.getStatus())) {
            bookOrderDAO.update(id, new BookOrder(order.getDateOfCreation(), order.getOrderedBy(), order.getVerifiedBy(), Date.valueOf(LocalDate.now()), BookOrderStatus.COMPLETED.getStatus()));
            book.setQuantity(book.getQuantity() - 1);
            bookDAO.update(book.getId(), book);
        } else
            throw new BookOrderException("You can complete only in progress orders");
    }

    public Map<BookOrder, Book> getAllAdminOrders(String login) {
        User user = userDAO.findByLogin(login);
        Map<BookOrder, Book> orders = new LinkedHashMap<>();
        List<BookOrder> bookOrders = new ArrayList<>(bookOrderDAO.findByAdminId(user.getId()));
        List<BookOrderBook> orderBooks = new ArrayList<>();
        BookOrderBook bookOrderBook;
        for (BookOrder bookOrder : bookOrders) {
            bookOrderBook = bookOrderDAO.findOrderByOrderId(bookOrder.getId());
            orderBooks.add(bookOrderBook);
        }
        List<Book> books = new ArrayList<>();
        Book book;
        for (BookOrderBook bookOrderBookTwo : orderBooks) {
            book = bookDAO.findById(bookOrderBookTwo.getBookId());
            books.add(book);
        }
        int count = bookOrders.size();
        while (count > 0) {
            orders.put(bookOrders.get(count - 1), books.get(count - 1));
            count--;
        }
        return orders;
    }
}

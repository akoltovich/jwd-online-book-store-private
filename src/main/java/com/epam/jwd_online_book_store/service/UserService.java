package com.epam.jwd_online_book_store.service;

import com.epam.jwd_online_book_store.dao.BookDAO;
import com.epam.jwd_online_book_store.dao.BookOrderDAO;
import com.epam.jwd_online_book_store.dao.UserDAO;
import com.epam.jwd_online_book_store.dao.impl.BookDAOImpl;
import com.epam.jwd_online_book_store.dao.impl.BookOrderDAOImpl;
import com.epam.jwd_online_book_store.dao.impl.UserDAOImpl;
import com.epam.jwd_online_book_store.domain.*;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.BookException;
import com.epam.jwd_online_book_store.exception.BookOrderException;
import com.epam.jwd_online_book_store.exception.UserException;
import com.epam.jwd_online_book_store.util.UserConverter;
import com.epam.jwd_online_book_store.validation.userValidation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class UserService {

    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    UserDAO userDAO = UserDAOImpl.getInstance();
    BookDAO bookDAO = BookDAOImpl.getInstance();
    BookOrderDAO bookOrderDAO = BookOrderDAOImpl.getInstance();

    public User registration(UserDTO userDTO) throws UserException {
        User user = UserConverter.userDTOToUser(userDTO);
        if (UserValidator.isValid(user)) {
            userDAO.create(user);
        }
        return user;
//        return null;
    }

    public UserDTO signIn(String login, String password) throws UserException {
        User user = userDAO.findByLogin(login);
        UserDTO userDTO = null;
        if (SignInValidator.isValid(user, password)) {
            userDTO = UserConverter.userToUserDTO(user);
        }
        return userDTO;
//        try {
//            if (user == null || !user.getPassword().equals(password)) {
//                throw new UserException("incorrect email or password");
//
//            }
//            if (user.isBanned()) {
//                throw new UserException("You are in ban");
//            }
//        } catch (UserException e) {
//            e.printStackTrace();
//        }
//        return UserConverter.userToUserDTO(user);
    }

    public List<Book> findBooksByName(String name) {
        return bookDAO.findByName(name);
//        if (!books.isEmpty()) {
//            return books;
//        }
//        throw new BookException("We dont have this books!");
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookDAO.findByAuthor(author);
//        if (!books.isEmpty()) {
//            return books;
//        }
//        throw new BookException("We dont have his books!");
    }

    public List<Book> findBooksByGenre(String genre) {
        return bookDAO.findByGenre(genre);
//        if (!books.isEmpty()) {
//            return books;
//        }
//        throw new BookException("We dont have books of genre" + genre);
    }

    public List<Book> findBooksByPrice(double from, double to) {
        return bookDAO.findByPrice(from, to);
//        if (!books.isEmpty()) {
//            return books;
//        }
//        throw new BookException("We dont have books with this price");
    }

    public List<Book> findAllBooks() {
        return bookDAO.findAll();
//        if (!books.isEmpty()) {
//            return books;
//        }
//        throw new BookException("Sorry, we dont have books:(");
    }

    public void selfDelete(UserDTO userDTO) {
        User userByLogin = userDAO.findByLogin(userDTO.getLogin());
        userDAO.delete(userByLogin.getId());
    }

    public void updateLogin(UserDTO userDTO, String newLogin) throws UserException {
        User user = userDAO.findByLogin(userDTO.getLogin());
        if (EmailValidator.isValid(newLogin)) {
            userDAO.update(user.getId(), new User(newLogin, user.getPassword(), user.getFirstName(), user.getLastName(), user.getRoleId()));
        }
    }

    public void updatePassword(String login, String newPassword) throws UserException {
        User user = userDAO.findByLogin(login);
        if (PasswordValidator.isValid(newPassword)) {
            userDAO.update(user.getId(), new User(user.getLogin(), newPassword, user.getFirstName(), user.getLastName(), user.getRoleId()));
        }
    }

    public void updateFirstName(UserDTO userDTO, String newFirstName) throws UserException {
        User user = userDAO.findByLogin(userDTO.getLogin());
        if (FirstLastNameValidator.isValid(newFirstName)) {
            userDAO.update(user.getId(), new User(user.getLogin(), user.getPassword(), newFirstName, user.getLastName(), user.getRoleId()));
        }
    }

    public void updateLastName(UserDTO userDTO, String newLastName) throws UserException {
        User user = userDAO.findByLogin(userDTO.getLogin());
        if (FirstLastNameValidator.isValid(newLastName)) {
            userDAO.update(user.getId(), new User(user.getLogin(), user.getPassword(), user.getFirstName(), newLastName, user.getRoleId()));
        }
    }

    private BookOrder createOrder(int orderedBy) {
        BookOrder bookOrder = new BookOrder(Date.valueOf(LocalDate.now()), orderedBy, BookOrderStatus.AWAITING_CONFIRMATION.getStatus());
        bookOrderDAO.create(bookOrder);
        return bookOrder;
    }

    public void createBookOrder(int bookId, String login) throws BookException{
        User user = userDAO.findByLogin(login);
        List<BookOrder> orders = bookOrderDAO.findAll();
        int orderId = orders.get(orders.size() - 1).getId();
        BookOrderBook orderBook = new BookOrderBook(bookId, orderId);
        Book book = bookDAO.findById(bookId);
        if (book.getQuantity() > 0) {
            createOrder(user.getId());
            bookOrderDAO.createBookOrderBook(orderBook);
        } else {
            throw new BookException("We don't have this book in storage");
        }
//        return orderBook;
    }

    public Map<BookOrder, Book> getAllUserOrders(String login) {
        User user = userDAO.findByLogin(login);
        Map<BookOrder, Book> orders = new LinkedHashMap<>();
        List<BookOrder> bookOrders = new ArrayList<>(bookOrderDAO.findByUserId(user.getId()));
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

    public void deleteOrder(int id, String login) throws BookOrderException {
        User user = userDAO.findByLogin(login);
        BookOrder order = bookOrderDAO.findById(id);
        if (user.getId() == order.getOrderedBy()) {
            bookOrderDAO.delete(id);
        } else {
            throw new BookOrderException("You can delete only yours orders");
        }
    }
}

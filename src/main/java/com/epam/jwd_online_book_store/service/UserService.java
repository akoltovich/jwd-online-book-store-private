package com.epam.jwd_online_book_store.service;

import com.epam.jwd_online_book_store.dao.BookDAO;
import com.epam.jwd_online_book_store.dao.BookOrderDAO;
import com.epam.jwd_online_book_store.dao.UserDAO;
import com.epam.jwd_online_book_store.dao.impl.BookDAOImpl;
import com.epam.jwd_online_book_store.dao.impl.BookOrderDAOImpl;
import com.epam.jwd_online_book_store.dao.impl.UserDAOImpl;
import com.epam.jwd_online_book_store.domain.Book;
import com.epam.jwd_online_book_store.domain.User;
import com.epam.jwd_online_book_store.dto.BookDTO;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.BookException;
import com.epam.jwd_online_book_store.exception.UserException;
import com.epam.jwd_online_book_store.util.BookConverter;
import com.epam.jwd_online_book_store.util.UserConverter;
import com.epam.jwd_online_book_store.validation.userValidation.UserValidator;

import java.util.List;

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
    }

    public UserDTO signIn(String login, String password) {
        User user = userDAO.findByLogin(login);
        try {
            if (user == null || !user.getPassword().equals(password)) {
                throw new UserException("incorrect email or password");
            }
            if (user.isBanned()) {
                throw new UserException("You are in ban");
            }
        } catch (UserException e) {
            e.printStackTrace();
        }
        return UserConverter.userToUserDTO(user);
    }

//    public List<BookDTO> findBooksByName(String name) throws BookException {
//        List<Book> books = bookDAO.findByName(name);
//        List<BookDTO> bookDTOS = BookConverter.listOfBookToListOfBookDTO(books);
//        if (!bookDTOS.isEmpty()) {
//            return bookDTOS;
//        }
//        throw new BookException("We dont have this books!");
//    }
//
//    public List<BookDTO> findBooksByAuthor(String author) throws BookException {
//        List<Book> books = bookDAO.findByAuthor(author);
//        List<BookDTO> bookDTOS = BookConverter.listOfBookToListOfBookDTO(books);
//        if (!bookDTOS.isEmpty()) {
//            return bookDTOS;
//        }
//        throw new BookException("We dont have his books!");
//    }
//
//    public List<BookDTO> findBooksByGenre(String genre) throws BookException {
//        List<Book> books = bookDAO.findByGenre(genre);
//        List<BookDTO> bookDTOS = BookConverter.listOfBookToListOfBookDTO(books);
//        if (!bookDTOS.isEmpty()) {
//            return bookDTOS;
//        }
//        throw new BookException("We dont have books of genre" + genre);
//    }
//
//    public List<BookDTO> findBooksByPrice(double from, double to) throws BookException {
//        List<Book> books = bookDAO.findByPrice(from, to);
//        List<BookDTO> bookDTOS = BookConverter.listOfBookToListOfBookDTO(books);
//        if (!bookDTOS.isEmpty()) {
//            return bookDTOS;
//        }
//        throw new BookException("We dont have books with this price");
//    }
//
//    public List<BookDTO> findAllBooks() throws BookException {
//        List<Book> books = bookDAO.findAll();
//        List<BookDTO> bookDTOS = BookConverter.listOfBookToListOfBookDTO(books);
//        if (!bookDTOS.isEmpty()) {
//            return bookDTOS;
//        }
//        throw new BookException("Sorry, we dont have books:(");
//    }

    public List<Book> findBooksByName(String name) throws BookException {
        List<Book> books = bookDAO.findByName(name);
        if (!books.isEmpty()) {
            return books;
        }
        throw new BookException("We dont have this books!");
    }

    public List<Book> findBooksByAuthor(String author) throws BookException {
        List<Book> books = bookDAO.findByAuthor(author);
        if (!books.isEmpty()) {
            return books;
        }
        throw new BookException("We dont have his books!");
    }

    public List<Book> findBooksByGenre(String genre) throws BookException {
        List<Book> books = bookDAO.findByGenre(genre);
        if (!books.isEmpty()) {
            return books;
        }
        throw new BookException("We dont have books of genre" + genre);
    }

    public List<Book> findBooksByPrice(double from, double to) throws BookException {
        List<Book> books = bookDAO.findByPrice(from, to);
        if (!books.isEmpty()) {
            return books;
        }
        throw new BookException("We dont have books with this price");
    }

    public List<Book> findAllBooks() throws BookException {
        List<Book> books = bookDAO.findAll();
        if (!books.isEmpty()) {
            return books;
        }
        throw new BookException("Sorry, we dont have books:(");
    }

    public void selfDelete(UserDTO userDTO) throws UserException {
        User userByLogin = userDAO.findByLogin(userDTO.getLogin());
        userDAO.delete(userByLogin.getId());
    }

    public void updateLogin(UserDTO userDTO, String newLogin) {
        User user = userDAO.findByLogin(userDTO.getLogin());
        userDAO.update(user.getId(), new User(newLogin, user.getPassword(), user.getFirstName(), user.getLastName(), user.getRoleId()));
    }

//    public void updatePassword(UserDTO userDTO, String newPassword) {
//        User user = userDAO.findByLogin(userDTO.getLogin());
//        userDAO.update(user.getId(), new User(user.getLogin(), newPassword, user.getFirstName(), user.getLastName(), user.getRoleId()));
//    }

    public void updatePassword(String login, String newPassword) {
        User user = userDAO.findByLogin(login);
        userDAO.update(user.getId(), new User(user.getLogin(), newPassword, user.getFirstName(), user.getLastName(), user.getRoleId()));
    }

    public void updateFirstName(UserDTO userDTO, String newFirstName) {
        User user = userDAO.findByLogin(userDTO.getLogin());
        userDAO.update(user.getId(), new User(user.getLogin(), user.getPassword(), newFirstName, user.getLastName(), user.getRoleId()));
    }

    public void updateLastName(UserDTO userDTO, String newLastName) {
        User user = userDAO.findByLogin(userDTO.getLogin());
        userDAO.update(user.getId(), new User(user.getLogin(), user.getPassword(), user.getFirstName(), newLastName, user.getRoleId()));
    }
}

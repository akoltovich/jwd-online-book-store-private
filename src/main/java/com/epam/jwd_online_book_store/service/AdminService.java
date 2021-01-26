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
import com.epam.jwd_online_book_store.validation.bookValidation.BookValidator;
import com.epam.jwd_online_book_store.validation.userValidation.EmailValidator;
import com.epam.jwd_online_book_store.validation.userValidation.FirstLastNameValidator;
import com.epam.jwd_online_book_store.validation.userValidation.UserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<UserDTO> getAllUsers() throws UserException {
        List<User> users = userDAO.findAll();
        List<User> onlyUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getRoleId() == 2) {
                onlyUsers.add(user);
            }
        }
        List<UserDTO> userDTOS = UserConverter.listOfUserToListOfUserDTO(onlyUsers);
        if (!userDTOS.isEmpty()) {
            return userDTOS;
        } else {
            throw new UserException("We dont have users:(");
        }

    }

    public List<UserDTO> getUsersByFirstName(String firstName) throws UserException {
        List<User> users = new ArrayList<>();
        if (FirstLastNameValidator.isValid(firstName)) {
            users.addAll(userDAO.findByFirstName(firstName));
        }
        return UserConverter.listOfUserToListOfUserDTO(users);
    }

    public List<UserDTO> getUsersByLastName(String lastName) throws UserException {
        List<User> users = new ArrayList<>();
        if (FirstLastNameValidator.isValid(lastName)) {
            users.addAll(userDAO.findByLastName(lastName));
        }
        return UserConverter.listOfUserToListOfUserDTO(users);
    }

    public UserDTO getUserByLogin(String login) throws UserException {
        User user = null;
        if (EmailValidator.isValid(login)) {
            user = userDAO.findByLogin(login);
        }
        return UserConverter.userToUserDTO(user);
    }

    public List<UserDTO> getUsersByBannedStatus(boolean banned) {
        List<User> users = new ArrayList<>(userDAO.findBanned(banned));
        return UserConverter.listOfUserToListOfUserDTO(users);
    }

//    public User updateAdmin(UserDTO userDTO) throws UserException {
//        ищешь юзера, потом берешь из ДТО все поля и сетишь их найденому юзеру, а потом комитишь
//
//        User user = null;
//        if (userDTO.getRoleId() == 1) {
//            user = UserConverter.userDTOToUser(userDTO);
//            if (UserValidator.isValid(user)) {
//                userDAO.update(user.getId(), user);
//            }
//        }
//        return user;
//    }

    public Book addBook(BookDTO bookDTO) throws BookException {
        Book book = BookConverter.bookDTOToBook(bookDTO);
        if (BookValidator.isValid(book)) {
            bookDAO.create(book);
        }
        return book;
    }

//    public void deleteBook(BookDTO bookDTO) {
//        List<Book> books = bookDAO.findByName(bookDTO.getName());
//        Optional<Book> mustBeDeleted = books.stream().filter(book -> book.getAuthor().equals(bookDTO.getAuthor()))
//                .filter(book -> book.getName().equals(bookDTO.getName()))
//                .filter(book -> book.getDateOfWriting().equals(bookDTO.getDateOfWriting()))
//                .filter(book -> book.getQuantity() == bookDTO.getQuantity())
//                .filter(book -> book.getGenre().equals(bookDTO.getGenre()))
//                .filter(book -> book.getPrice() == bookDTO.getPrice())
//                .filter(book -> book.getPricePerDay() == bookDTO.getPricePerDay())
//                .findFirst();
//        for (Book book : books) {
//            if (book.getAuthor().equals(bookDTO.getAuthor()) && book.getGenre().equals(bookDTO.getGenre()) &&
//                    book.getName().equals(bookDTO.getName()) && book.getDateOfWriting().equals(bookDTO.getDateOfWriting()) &&
//                    book.getPreview().equals(bookDTO.getPreview()) && book.getPrice() == bookDTO.getPrice() &&
//                    book.getPricePerDay() == bookDTO.getPricePerDay() && book.getQuantity() == bookDTO.getQuantity()) {
//                mustBeDeleted = book;
//            }
//        Book newBook = null;
//        if (mustBeDeleted.isPresent()) {
//            newBook = mustBeDeleted.get();
//        }
//        bookDAO.delete(newBook.getId());
//    }
//}

    public void deleteBook(int id) {
        Book book = bookDAO.findById(id);
        bookDAO.delete(book.getId());
    }

//    public void deleteBook(List<BookDTO> bookDTOS) {
//        List<Book> books;
//        Book mustBeDeleted = null;
//        for (BookDTO bookDTO1 : bookDTOS) {
//            books = bookDAO.findByName(bookDTO1.getName());
//            for (Book book : books) {
//                if (book.getAuthor().equals(bookDTO1.getAuthor()) && book.getGenre().equals(bookDTO1.getGenre()) &&
//                        book.getName().equals(bookDTO1.getName()) && book.getDateOfWriting().equals(bookDTO1.getDateOfWriting()) &&
//                        book.getPreview().equals(bookDTO1.getPreview()) && book.getPrice() == bookDTO1.getPrice() &&
//                        book.getPricePerDay() == bookDTO1.getPricePerDay() && book.getQuantity() == bookDTO1.getQuantity()) {
//                    mustBeDeleted = book;
//                }
//            }
//        }
//        bookDAO.delete(mustBeDeleted.getId());
//    }
}

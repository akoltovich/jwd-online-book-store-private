package com.epam.jwd_online_book_store.context;

import com.epam.jwd_online_book_store.controller.command.ResponseContext;

public class PathToPages {
    /**
     * Admin page
     */
    public static final String ADMIN_AREA = "WEB-INF/jsp/admin_area.jsp";
    public static final String USER_BY_LOGIN = "WEB-INF/jsp/user_by_login.jsp";
    public static final String USERS_BY_FIRST_NAME = "WEB-INF/jsp/users_by_first_name.jsp";
    public static final String USERS_BY_LAST_NAME = "WEB-INF/jsp/users_by_last_name.jsp";
    public static final String ALL_USERS = "WEB-INF/jsp/all_users.jsp";
    public static final String DELETE_BOOK = "home?command=delete_book";
    public static final String ADMIN_PAGE = "WEB-INF/jsp/admin_page.jsp";
    /**
     * User page
     */
    public static final String USER_AREA = "WEB-INF/jsp/user_area.jsp";
    public static final String USER_PAGE = "WEB-INF/jsp/user_page.jsp";

    /**
     * General pages
     */
    public static final String BOOKS_BY_AUTHOR = "WEB-INF/jsp/by_author.jsp";
    public static final String BOOKS_BY_GENRE = "WEB-INF/jsp/by_genre.jsp";
    public static final String BOOKS_FIND_BY_NAME = "WEB-INF/jsp/by_name.jsp";
    public static final String BOOKS_BY_PRICE = "WEB-INF/jsp/by_price.jsp";
    public static final String USER_CHANGE_FIRST_NAME = "WEB-INF/jsp/user_change_first_name.jsp";
    public static final String USER_CHANGE_LAST_NAME = "WEB-INF/jsp/user_change_last_name.jsp";
    public static final String USER_CHANGE_LOGIN = "WEB-INF/jsp/user_change_login.jsp";
    public static final String USER_CHANGE_PASSWORD = "WEB-INF/jsp/user_change_password.jsp";
    public static final String ALL_BOOKS = "WEB-INF/jsp/all_books.jsp";
    public static final String ERROR_PAGE = "WEB-INF/jsp/error.jsp";

    public static final String REGISTER_PAGE = "WEB-INF/jsp/registration.jsp";
    public static final String MAIN_PAGE = "WEB-INF/jsp/main_page.jsp";
    public static final String SIGN_IN_PAGE = "WEB-INF/jsp/sign_in.jsp";
    public static final String START_PAGE = "/start_page.jsp";
    /**
     * Redirect commands
     */
    public static final String ALL_BOOKS_REDIRECT = "home?command=all_books";
    public static final String SIGN_IN_PAGE_REDIRECT = "home?command=sign_in";
    public static final String ADMIN_AREA_REDIRECT = "home?command=admin_area";
    public static final String USER_AREA_REDIRECT = "home?command=user_area";
    public static final String USER_PAGE_REDIRECT = "home?command=user_page";
    public static final String ADMIN_PAGE_REDIRECT = "home?command=admin_page";
    public static final String USER_BY_LOGIN_REDIRECT = "home?command=user_by_login";
    public static final String USERS_BY_FIRST_NAME_REDIRECT = "home?command=users_by_first_name";
    public static final String USERS_BY_LAST_NAME_REDIRECT = "home?command=users_by_last_name";
    public static final String USER_CHANGE_FIRST_NAME_REDIRECT = "home?command=user_change_first_name";
    public static final String USER_CHANGE_LAST_NAME_REDIRECT = "home?command=user_change_last_name";
    public static final String USER_CHANGE_LOGIN_REDIRECT = "home?command=user_change_login";
    public static final String USER_CHANGE_PASSWORD_REDIRECT = "home?command=user_change_password";
    public static final String BOOKS_BY_AUTHOR_REDIRECT = "home?command=by_author";
    public static final String BOOKS_BY_GENRE_REDIRECT = "home?command=by_genre";
    public static final String BOOKS_FIND_BY_NAME_REDIRECT = "home?command=books_by_name";
    public static final String BOOKS_BY_PRICE_REDIRECT = "home?command=by_price";

}

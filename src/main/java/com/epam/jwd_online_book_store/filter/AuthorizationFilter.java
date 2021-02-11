package com.epam.jwd_online_book_store.filter;

import com.epam.jwd_online_book_store.dto.UserDTO;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//@WebFilter("/home")
//public class AuthorizationFilter extends HttpFilter {
//    private static final String ADMIN_PAGE = "admin_page";
//    private static final String USER_PAGE = "user_page";
//    private static final String SIGN_OUT = "sign_out";
//    private static final String SELF_DELETE = "self_delete";
//    private static final String USER_AREA = "user_area";
//    private static final String ADMIN_AREA = "admin_area";
//    private static final String USER_BY_LOGIN = "user_by_login";
//    private static final String USERS_BY_FIRST_NAME = "users_by_first_name";
//    private static final String USERS_BY_LAST_NAME = "users_by_last_name";
//    private static final String SHOW_ALL_USERS = "all_users";
//    private static final String USER_CHANGE_FIRST_NAME = "user_change_first_name";
//    private static final String USER_CHANGE_LAST_NAME = "user_change_last_name";
//    private static final String USER_CHANGE_LOGIN = "user_change_login";
//    private static final String USER_CHANGE_PASSWORD = "user_change_password";
//    private static final String DELETE_BOOK = "delete_book";
//    private static final String ADD_BOOK = "add_book";
//    private static final String UPDATE_BOOK = "update_book";
//    private static final String BAN_USER = "ban_user";
//    private static final String BANNED_USERS = "banned_users";
//    private static final String UNBAN_USER = "unban_user";
//    private static final String SHOW_ALL_USER_ORDERS = "show_all_user_orders";
//    private static final String ORDER_BOOK = "order_book";
//    private static final String DELETE_ORDER = "delete_order";
//    private static final String SHOW_ALL_ADMIN_ORDERS = "show_all_admin_orders";
//    private static final String TAKE_ORDER = "take_order";
//    private static final String COMPLETE_ORDER = "complete_order";
//    private static final String SHOW_ORDERS_BY_STATUS = "show_orders_by_status";
//
//    private static final List<String> COMMANDS_NEEDED_AUTHORIZATION = Arrays.asList(
//            ADMIN_AREA,
//            ADMIN_PAGE,
//            ADD_BOOK,
//            USER_AREA,
//            UNBAN_USER,
//            USER_PAGE,
//            UPDATE_BOOK,
//            USER_BY_LOGIN,
//            DELETE_BOOK,
//            BAN_USER,
//            BANNED_USERS,
//            SIGN_OUT,
//            SELF_DELETE,
//            SHOW_ALL_ADMIN_ORDERS,
//            SHOW_ALL_USERS,
//            SHOW_ALL_USER_ORDERS,
//            SHOW_ORDERS_BY_STATUS,
//            ORDER_BOOK,
//            DELETE_ORDER,
//            TAKE_ORDER,
//            COMPLETE_ORDER,
//            USER_BY_LOGIN,
//            USERS_BY_FIRST_NAME,
//            USERS_BY_LAST_NAME,
//            USER_CHANGE_FIRST_NAME,
//            USER_CHANGE_LAST_NAME,
//            USER_CHANGE_LOGIN,
//            USER_CHANGE_PASSWORD
//    );
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
//    }
//}

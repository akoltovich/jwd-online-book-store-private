package com.epam.jwd_online_book_store.controller.command.factory;

public enum CommandType {
    SHOW_START_PAGE("start_page"),
    SHOW_MAIN_PAGE("main_page"),
    REGISTRATION("registration"),
    ADMIN_PAGE("admin_page"),
    USER_PAGE("user_page"),
    SIGN_IN("sign_in"),
    SIGN_OUT("sign_out"),
    BOOKS_BY_NAME("books_by_name"),
    BOOKS_BY_PRICE("by_price"),
    BOOKS_BY_GENRE("by_genre"),
    BOOKS_BY_AUTHOR("by_author"),
    ALL_BOOKS("all_books"),
    SELF_DELETE("self_delete"),
    USER_AREA("user_area"),
    ADMIN_AREA("admin_area"),
    USER_BY_LOGIN("user_by_login"),
    USERS_BY_FIRST_NAME("users_by_first_name"),
    USERS_BY_LAST_NAME("users_by_last_name"),
    SHOW_ALL_USERS("all_users"),
    USER_CHANGE_FIRST_NAME("user_change_first_name"),
    USER_CHANGE_LAST_NAME("user_change_last_name"),
    USER_CHANGE_LOGIN("user_change_login"),
    USER_CHANGE_PASSWORD("user_change_password"),
    DELETE_BOOK("delete_book"),
    BOOK_DETAILS("book_details"),
    ADD_BOOK("add_book"),
    UPDATE_BOOK("update_book"),
    BAN_USER("ban_user"),
    BANNED_USERS("banned_users"),
    UNBAN_USER("unban_user"),
    SHOW_ALL_USER_ORDERS("show_all_user_orders"),
    ORDER_BOOK("order_book"),
    DELETE_ORDER("delete_order"),
    SHOW_ALL_ADMIN_ORDERS("show_all_admin_orders"),
    TAKE_ORDER("take_order"),
    COMPLETE_ORDER("complete_order"),
    SHOW_ORDERS_BY_STATUS("show_orders_by_status"),
    ERROR("error");

    private String value;

    CommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private static CommandType getDefault() {
        return SHOW_START_PAGE;
    }

    public static CommandType getCommand(String value) {
        for (CommandType commandType : values()) {
            if (commandType.value.equals(value)) {
                return commandType;
            }
        }
        return getDefault();
    }
}

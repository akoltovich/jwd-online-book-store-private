package com.epam.jwd_online_book_store.controller.command.factory;

import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.impl.*;

public class CommandFactory {
    public static Command getCommand(String command) {
        if (command == null) {
            return new StartPageCommand();
        }
        switch (CommandType.getCommand(command)) {
            case REGISTRATION:
                return new RegistrationCommand();
            case SHOW_START_PAGE:
                return new StartPageCommand();
            case USER_PAGE:
                return new UserPageCommand();
            case SIGN_IN:
                return new SignInCommand();
            case SIGN_OUT:
                return new SignOutCommand();
            case SHOW_MAIN_PAGE:
                return new ShowMainPageCommand();
            case BOOKS_BY_NAME:
                return new FindBooksByNameCommand();
            case ALL_BOOKS:
                return new ShowAllBooksCommand();
            case BOOKS_BY_AUTHOR:
                return new FindBooksByAuthorCommand();
            case BOOKS_BY_GENRE:
                return new FindBooksByGenreCommand();
            case BOOKS_BY_PRICE:
                return new FindBooksByPriceCommand();
            case ADMIN_PAGE:
                return new AdminPageCommand();
            case SELF_DELETE:
                return new SelfDeleteCommand();
            case USER_AREA:
                return new UserAreaCommand();
            case ADMIN_AREA:
                return new AdminAreaCommand();
            case USER_BY_LOGIN:
                return new FindUserByLoginCommand();
            case USERS_BY_FIRST_NAME:
                return new FindUsersByFirstNameCommand();
            case USERS_BY_LAST_NAME:
                return new FindUsersByLastNameCommand();
            case SHOW_ALL_USERS:
                return new ShowAllUsersCommand();
            case USER_CHANGE_FIRST_NAME:
                return new UserChangeFirstNameCommand();
            case USER_CHANGE_PASSWORD:
                return new UserChangePasswordCommand();
            case USER_CHANGE_LAST_NAME:
                return new UserChangeLastNameCommand();
            case USER_CHANGE_LOGIN:
                return new UserChangeLoginCommand();
            case DELETE_BOOK:
                return new DeleteBookCommand();
            case ADD_BOOK:
                return new AddBookCommand();
            case UPDATE_BOOK:
                return new UpdateBookCommand();
            case BAN_USER:
                return new BanUserCommand();
            case BANNED_USERS:
                return new ShowBannedUsersCommand();
            case UNBAN_USER:
                return new UnbanUserCommand();
            case SHOW_ALL_USER_ORDERS:
                return new ShowAllUserOrdersCommand();
            case ORDER_BOOK:
                return new OrderBookCommand();
            case DELETE_ORDER:
                return new DeleteOrderCommand();
            case SHOW_ALL_ADMIN_ORDERS:
                return new ShowAllAdminOrdersCommand();
            case TAKE_ORDER:
                return new TakeOrderCommand();
            case COMPLETE_ORDER:
                return new CompleteOrderCommand();
            case SHOW_ORDERS_BY_STATUS:
                return new ShowAllOrdersByStatusCommand();
            case ACCESS_DENIED:
                return new AccessDeniedPageCommand();
            default:
                return new ErrorPageCommand();
        }
    }
}

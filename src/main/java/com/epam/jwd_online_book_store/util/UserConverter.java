package com.epam.jwd_online_book_store.util;

import com.epam.jwd_online_book_store.domain.User;
import com.epam.jwd_online_book_store.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {

    public static UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setRoleId(user.getRoleId());
        userDTO.setBanned(user.isBanned());
        return userDTO;
    }

    public static List<UserDTO> listOfUserToListOfUserDTO(List<User> users) {
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setLogin(user.getLogin());
            userDTO.setPassword(user.getPassword());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setRoleId(user.getRoleId());
            userDTO.setBanned(user.isBanned());
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    public static User userDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setRoleId(userDTO.getRoleId());
        user.setBanned(userDTO.isBanned());
        return user;
    }

    public static List<User> listOfUserDTOToListOfUser(List<UserDTO> userDTOS) {
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : userDTOS) {
            User user = new User();
            user.setLogin(userDTO.getLogin());
            user.setPassword(userDTO.getPassword());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setRoleId(userDTO.getRoleId());
            user.setBanned(userDTO.isBanned());
            users.add(user);
        }
        return users;
    }
}

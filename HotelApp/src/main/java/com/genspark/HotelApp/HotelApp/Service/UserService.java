package com.genspark.HotelApp.HotelApp.Service;

import com.genspark.HotelApp.HotelApp.Entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int userID);

    User addUser(User user);

    User updateUser(User user);

    String deleteUserById(int userID);

}

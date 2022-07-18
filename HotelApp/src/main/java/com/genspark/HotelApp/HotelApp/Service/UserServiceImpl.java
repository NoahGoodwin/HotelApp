package com.genspark.HotelApp.HotelApp.Service;


import com.genspark.HotelApp.HotelApp.Dao.UserDao;
import com.genspark.HotelApp.HotelApp.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUsers() { return this.userDao.findAll(); }

    @Override
    public User getUserById(int userID) {
        Optional<User> u = Optional.of(this.userDao.getById(userID));
        User user = null;
        if(u.isPresent()){
            user = u.get();
        } else {
            throw new RuntimeException("User not found for id :: " + userID);
        }

        return user;
    }

    @Override
    public User addUser(User user) {
        return this.userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userDao.save(user);
    }

    @Override
    public String deleteUserById(int userID) {

        this.userDao.deleteById(userID);

        return "Deleted Successfully";
    }
}

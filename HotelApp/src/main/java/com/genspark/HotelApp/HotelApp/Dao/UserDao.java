package com.genspark.HotelApp.HotelApp.Dao;

import com.genspark.HotelApp.HotelApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}

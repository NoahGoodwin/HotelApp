package com.genspark.HotelApp.HotelApp.Service;


import com.genspark.HotelApp.HotelApp.Dao.ReservationDao;
import com.genspark.HotelApp.HotelApp.Dao.UserDao;
import com.genspark.HotelApp.HotelApp.Entity.Reservation;
import com.genspark.HotelApp.HotelApp.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private UserService userService;


    @Override
    public List<Reservation> getAllReservationsByUserId(int userID) {
        User user = userService.getUserById(userID);
        return user.getReservations();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {


//        User user = userService.getUserById(reservation.getUser().getUserid());
//        reservation.setUser(user);

        return this.reservationDao.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {

        return this.reservationDao.save(reservation);
    }

    @Override
    public String deleteReservationById(int reservationID) {

        this.reservationDao.deleteById(reservationID);

        return "DeletedSuccessfully";
    }
}

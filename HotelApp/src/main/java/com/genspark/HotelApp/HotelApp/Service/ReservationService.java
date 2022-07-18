package com.genspark.HotelApp.HotelApp.Service;

import com.genspark.HotelApp.HotelApp.Entity.Reservation;
import com.genspark.HotelApp.HotelApp.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservationsByUserId(int userID);

    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    String deleteReservationById(int reservationID);
}

package com.genspark.HotelApp.HotelApp.Controller;

import com.genspark.HotelApp.HotelApp.Entity.Reservation;
import com.genspark.HotelApp.HotelApp.Entity.User;
import com.genspark.HotelApp.HotelApp.Service.ReservationService;
import com.genspark.HotelApp.HotelApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() { return this.userService.getAllUsers(); }

    @GetMapping("/users/{userID}")
    public User getUser(@PathVariable String userID){
        return this.userService.getUserById(Integer.parseInt(userID));
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) { return this.userService.addUser(user); }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) { return this.userService.updateUser(user); }

    @DeleteMapping("/users/{userID}")
    public String deleteUser(@PathVariable String userID){
        return this.userService.deleteUserById(Integer.parseInt(userID));
    }

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations/{userID}")
    public List<Reservation> getAllReservations(@PathVariable int userID) { return this.reservationService.getAllReservationsByUserId(userID); }

//    @GetMapping("/reservations/{reservationID}")
//    public Reservation getReservation(@PathVariable String reservationID){
//        return this.reservationService.getReservationById(Integer.parseInt(reservationID));
//    }

    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation reservation) { return this.reservationService.addReservation(reservation); }

    @PutMapping("/reservations")
    public Reservation updateReservation(@RequestBody Reservation reservation) { return this.reservationService.updateReservation(reservation); }

    @DeleteMapping("/reservations/{reservationID}")
    public String deleteReservation(@PathVariable String reservationID){
        return this.reservationService.deleteReservationById(Integer.parseInt(reservationID));
    }

}

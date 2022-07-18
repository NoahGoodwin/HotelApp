package com.genspark.HotelApp.HotelApp.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_reservations")
public class Reservation{
    @Id
    @Column(name = "r_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reservationid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinTable(name = "user_reservations", joinColumns = @JoinColumn(name = "reservation_id", referencedColumnName = "r_id", nullable = true))
    @JsonIgnoreProperties("reservations")
    private User user;
    private String type;
    private String hotel;

    public Reservation() {
    }

    public Reservation(User user, String type, String hotel) {
        this.user = user;
        this.type = type;
        this.hotel = hotel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getReservationid() {
        return reservationid;
    }

    public void setReservationid(int reservationid) {
        this.reservationid = reservationid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
}

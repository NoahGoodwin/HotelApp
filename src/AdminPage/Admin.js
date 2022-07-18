import { useEffect } from "react";
import APIService from "../Service/APIService";
import { useState } from "react";

export default function AdminPage () {

    const [users, setUsers] = useState([]);


    useEffect(() => {
        APIService.getAllUsers(setUsers)
    }, [users])

    const handleSubmit = (event) => {
        event.preventDefault();

        var {uid, type, hotel} = document.forms[0];

        uid = uid.value;
        type = type.value;
        hotel = hotel.value;

        APIService.createReservation(uid, type, hotel)

    }


        

    

    return (
        <div>
            {users.map(user => 
            <div key={user.id}>
                <h1>User Info</h1>
                <p>Type of User: {user.type}</p>
                <p>Username: {user.name}</p>
                <p>Email: {user.email}</p>
                <p>Payment Method: {user.paymentMethod}</p>
                
                <h1>Reservation Info</h1>
                {user.reservations.map(reservation =>
                    <div key={reservation.id}>
                        <p>Reservation ID: {reservation.reservationid}</p>
                        <p>Type of Reservation: {reservation.type}</p>
                        <p>Hotel: {reservation.hotel}</p>
                    </div>)}
            </div>)}


            <h1>Create Reservation</h1>
            <div className="form">
             <form onSubmit={handleSubmit}>
             <div className="input-container">
                <label>User ID </label>
                <input type="text" name="uid" required />
            </div>
            <div className="input-container">
                <label>Type </label>
                <input type="password" name="type" required />
            </div>
            <div className="input-container">
                <label>Hotel </label>
                <input type="text" name="hotel" required />
            </div>
            <div className="button-container">
                <input type="submit" />
            </div>
            </form>
        </div>
                
        </div>
    )
}
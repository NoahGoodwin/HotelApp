import axios from "axios";

class Service {

    instance = axios.create({
        baseURL: "http://localhost:8080/",
        headers: {
            "Content-type": "application/json"
        }
    });

    getAllUsers(setUsers) {
        return axios({
            method: 'get',
            url: `http://localhost:8080/users`,
        }).then(function (response) {
            console.log(response);
            setUsers(response.data);
        }).catch(function (error) {
            console.log(error);
        });
    }

    getUserById(user_id) {
        return axios({
            method: 'get',
            url: `users/${user_id}`,
        }).then(function (response) {
            console.log(response);
        }).catch(function (error) {
            console.log(error);
        });
    }

    createReservation(uid, type, hotel) {
        return axios({
            method: 'post',
            url: `http://localhost:8080/reservations`,
            data: {
                "user" : {
                    "userid" : uid
                },
                "type": type,
                "hotel": hotel
            }
        });
    }

    updateUser(user) {
        return axios({
            method: 'put',
            url: `users`,
            headers: {
                Authorization: `Bearer ${process.env.CLIENT_TOKEN}`
            },
            data: {
                "type": user.type,
                "name": user.name,
                "password": user.password,
                "email": user.email,
                "paymentMethod": user.paymentMethod
            }
        });
    }

    deleteUserById(user_id) {
        return axios({
            method: 'delete',
            url: `api/users/${user_id}`,
        }).then(function (response) {
            console.log(response);
        }).catch(function (error) {
            console.log(error);
        });
    }
}

export default new Service();
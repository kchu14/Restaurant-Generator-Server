package com.example.wbdv2019finalprojectserver.controllers;

import java.util.List;

import com.example.wbdv2019finalprojectserver.models.Restaurant;
import com.example.wbdv2019finalprojectserver.models.User;
import com.example.wbdv2019finalprojectserver.services.RestaurantService;
import com.example.wbdv2019finalprojectserver.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
class UserController {

    @Autowired
    UserService us;
    @Autowired
    RestaurantService rs;

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return us.findAllUsers();
    }

    @GetMapping("/api/users/{userId}")
    public User findUserById(@PathVariable("userId") Integer userId) {
        return us.findUserById(userId);
    }

    // @GetMapping("/api/users/{username}")
    // public User findUserByUserName(@PathVariable("username") String username) {
    //     return us.findUserByUserName(username);
    // }

    @PostMapping("/api/login")
    public User validateLogin(@RequestBody User user) throws Exception {
        User userLoggingIn = us.findUserByUserName(user.getUserName());
        if (userLoggingIn.getUserName().equals(user.getUserName())
                && userLoggingIn.getPassword().equals(user.getPassword())) {
            return us.findUserByUserName(user.getUserName());
        } else {
            throw new Exception("invalid login");
        }
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUser(@PathVariable("id") Integer Id) {
        us.deleteUser(Id);
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return us.createUser(user);
    }

    @PutMapping("/api/users/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        return us.updateUser(user, id);
    }

    @PutMapping("/api/users/{uid}/restaurants/{rid}")
    public User likeRestaurant(@PathVariable("uid") Integer uid, @PathVariable("rid") Integer rid) {
        User editedUser = us.findUserById(uid);
        List<Restaurant> tempList = editedUser.getLikedRestaurants();
        tempList.add(rs.findRestaurantById(rid));
        editedUser.setLikedRestaurants(tempList);
        return us.updateUser(editedUser, uid);
    }

}
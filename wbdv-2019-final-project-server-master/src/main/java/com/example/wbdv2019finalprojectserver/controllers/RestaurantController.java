package com.example.wbdv2019finalprojectserver.controllers;

import java.util.List;

import com.example.wbdv2019finalprojectserver.models.Restaurant;
import com.example.wbdv2019finalprojectserver.models.User;
import com.example.wbdv2019finalprojectserver.services.RestaurantService;

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
class RestaurantController {

    @Autowired
    RestaurantService rs;

    @GetMapping("/api/restaurants")
    public List<Restaurant> getRestaurants() {
        return rs.findAllRestaurants();
    }

    @GetMapping("/api/restaurants/{restaurantId}")
    public Restaurant findRestaurantById(@PathVariable("restaurantId") Integer restaurantId) {
        return rs.findRestaurantById(restaurantId);
    }

    @DeleteMapping("/api/restaurants/{id}")
    public void deleteRestaurant(@PathVariable("id") Integer Id) {
        rs.deleteRestaurant(Id);
    }

    @PostMapping("/api/restaurants")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return rs.createRestaurant(restaurant);
    }

    @PutMapping("/api/restaurants/{id}")
    public Restaurant updateRestaurant(@PathVariable("id") Integer id, @RequestBody Restaurant restaurant) {
        return rs.updateRestaurant(restaurant, id);
    }

    @GetMapping("/api/restaurants/{id}/users")
    public List<User> getRestaurantLikes(@PathVariable("id") Integer id) {
        return rs.getRestaurantLikes(id);
    }

}
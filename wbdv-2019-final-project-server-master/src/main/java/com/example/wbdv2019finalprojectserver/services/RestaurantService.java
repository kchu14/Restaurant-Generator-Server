package com.example.wbdv2019finalprojectserver.services;

import java.util.List;
import com.example.wbdv2019finalprojectserver.models.Restaurant;
import com.example.wbdv2019finalprojectserver.models.User;
import com.example.wbdv2019finalprojectserver.repositories.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository repository;

    public List<Restaurant> findAllRestaurants() {
        return repository.findAllRestaurants();
    }

    public Restaurant findRestaurantById(Integer restaurantId) {
        return repository.findRestaurantById(restaurantId);
    }

    public void deleteRestaurant(Integer restaurantId) {
        repository.deleteById(restaurantId);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public Restaurant updateRestaurant(Restaurant restaurant, Integer id) {
        Restaurant newRestaurant = repository.findRestaurantById(id);
        if (restaurant.getAdmin() != null) {
            newRestaurant.setAdmin(restaurant.getAdmin());
        }
        if (restaurant.getName() != null) {
            newRestaurant.setName(restaurant.getName());
        }
        if (restaurant.getUserLikes() != null) {
            newRestaurant.setUserLikes(restaurant.getUserLikes());
        }
        if (restaurant.getYelpLink() != null) {
            newRestaurant.setYelpLink(restaurant.getYelpLink());
        }
        return repository.save(newRestaurant);
    }

    public List<User> getRestaurantLikes(Integer id) {
        return repository.getRestaurantLikes(id);
    }

}
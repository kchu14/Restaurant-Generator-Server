package com.example.wbdv2019finalprojectserver.repositories;

import java.util.List;

import com.example.wbdv2019finalprojectserver.models.Restaurant;
import com.example.wbdv2019finalprojectserver.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{

    @Query("select restaurant from Restaurant restaurant")
    public List<Restaurant> findAllRestaurants();

    @Query("select restaurant from Restaurant restaurant where restaurant.id=:restaurantId")
    public Restaurant findRestaurantById(@Param("restaurantId") Integer restaurantId);

    @Query("select user FROM User user JOIN user.likedRestaurants restaurant WHERE restaurant.id = :id")
    public List<User> getRestaurantLikes(@Param("id") Integer id);
}
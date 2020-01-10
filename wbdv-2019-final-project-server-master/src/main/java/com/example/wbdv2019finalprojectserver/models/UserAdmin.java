package com.example.wbdv2019finalprojectserver.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "useradmins")
public class UserAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean isAdmin = true;
    private String name;
    private String userName;
    private String email;
    private String password;
    private Double locationLong;
    private Double locationLat;

    @OneToMany(mappedBy = "admin")
    private List<Restaurant> restaurants;

    public void ownsRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
        if (restaurant.getAdmin() != this) {
            restaurant.setAdmin(this);
        }
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsAdmin(){
        return this.isAdmin;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getLocationLong() {
        return this.locationLong;
    }

    public void setLocationLong(Double locationLong) {
        this.locationLong = locationLong;
    }

    public Double getLocationLat() {
        return this.locationLat;
    }

    public void setLocationLat(Double locationLat) {
        this.locationLat = locationLat;
    }

    public List<Restaurant> getRestaurants() {
        return this.restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

}
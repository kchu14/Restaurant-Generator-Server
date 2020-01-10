package com.example.wbdv2019finalprojectserver.services;

import java.util.List;
import com.example.wbdv2019finalprojectserver.models.User;
import com.example.wbdv2019finalprojectserver.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

    public User findUserById(Integer userId) {
        return repository.findUserById(userId);
    }

    public User findUserByUserName(String userName) {
        return repository.findUserByUserName(userName);
    }

    public void deleteUser(Integer userId) {
        repository.deleteById(userId);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(User user, Integer id) {
        User newUser = repository.findUserById(id);
        newUser.setId(id);
        if (user.getEmail() != null) {
            newUser.setEmail(user.getEmail());
        }
        if (user.getLikedRestaurants() != null) {
            newUser.setLikedRestaurants(user.getLikedRestaurants());
        }
        if (user.getUserName() != null) {
            newUser.setUserName(user.getUserName());
        }
        if (user.getName() != null) {
            newUser.setName(user.getName());
        }
        if (user.getPassword() != null) {
            newUser.setPassword(user.getPassword());
        }
        if (user.getLocationLat() != null) {
            newUser.setLocationLat(user.getLocationLat());
        }
        if (user.getLocationLong() != null) {
            newUser.setLocationLong(user.getLocationLong());
        }
        return repository.save(newUser);
    }

}
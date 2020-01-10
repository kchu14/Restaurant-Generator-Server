package com.example.wbdv2019finalprojectserver.services;

import java.util.List;

import com.example.wbdv2019finalprojectserver.models.Restaurant;
import com.example.wbdv2019finalprojectserver.models.UserAdmin;
import com.example.wbdv2019finalprojectserver.repositories.UserAdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAdminService {

    @Autowired
    UserAdminRepository repository;

    public List<UserAdmin> findAllUserAdmins() {
        return repository.findAllUserAdmins();
    }

    public UserAdmin findUserAdminById(Integer userId) {
        return repository.findUserAdminById(userId);
    }

    public UserAdmin findUserByUserName(String userName) {
        return repository.findUserByUserName(userName);
    }

    public void deleteUserAdmin(Integer useradminId) {
        repository.deleteById(useradminId);
    }

    public UserAdmin createUserAdmin(UserAdmin userAdmin) {
        return repository.save(userAdmin);
    }

    public UserAdmin updateUserAdmin(UserAdmin userAdmin, Integer id) {
        UserAdmin newUserAdmin = repository.findUserAdminById(id);
        newUserAdmin.setId(id);
        if (userAdmin.getEmail() != null) {
            newUserAdmin.setEmail(userAdmin.getEmail());
        }
        if (userAdmin.getName() != null) {
            newUserAdmin.setName(userAdmin.getName());
        }
        if (userAdmin.getUserName() != null) {
            newUserAdmin.setUserName(userAdmin.getUserName());
        }
        if (userAdmin.getPassword() != null) {
            newUserAdmin.setPassword(userAdmin.getPassword());
        }
        if (userAdmin.getLocationLat() != null) {
            newUserAdmin.setLocationLat(userAdmin.getLocationLat());
        }
        if (userAdmin.getLocationLong() != null) {
            newUserAdmin.setLocationLong(userAdmin.getLocationLong());
        }
        if (userAdmin.getRestaurants() != null) {
            newUserAdmin.setRestaurants(userAdmin.getRestaurants());
        }
        return repository.save(newUserAdmin);
    }

}
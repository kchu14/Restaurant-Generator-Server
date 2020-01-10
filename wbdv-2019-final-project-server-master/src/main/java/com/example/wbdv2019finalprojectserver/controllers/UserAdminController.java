package com.example.wbdv2019finalprojectserver.controllers;

import java.util.List;

import com.example.wbdv2019finalprojectserver.models.Restaurant;
import com.example.wbdv2019finalprojectserver.models.UserAdmin;
import com.example.wbdv2019finalprojectserver.services.RestaurantService;
import com.example.wbdv2019finalprojectserver.services.UserAdminService;

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
class UserAdminController {

    @Autowired
    UserAdminService uas;
    @Autowired
    RestaurantService rs;

    @GetMapping("/api/useradmins")
    public List<UserAdmin> findAllUserAdmins() {
        return uas.findAllUserAdmins();
    }

    @GetMapping("/api/useradmins/{useradminId}")
    public UserAdmin findUserById(@PathVariable("useradminId") Integer userId) {
        return uas.findUserAdminById(userId);
    }

    // @GetMapping("/api/useradmins/{username}")
    // public UserAdmin findUserByUserName(@PathVariable("username") String username) {
    //     return uas.findUserByUserName(username);
    // }

    @GetMapping("/api/useradmins/login")
    public UserAdmin validateLogin(@RequestBody UserAdmin user) throws Exception{
        UserAdmin userLoggingIn = uas.findUserByUserName(user.getUserName());
        if (userLoggingIn.getUserName().equals(user.getUserName())
                && userLoggingIn.getPassword().equals(user.getPassword())) {
            return uas.findUserByUserName(user.getUserName());
        } else {
            throw new Exception("invalid login");
        }
    }

    @DeleteMapping("/api/usersadmins/{id}")
    public void deleteUserAdmin(@PathVariable("id") Integer Id) {
        uas.deleteUserAdmin(Id);
    }

    @PostMapping("/api/useradmins")
    public UserAdmin createUser(@RequestBody UserAdmin userAdmin) {
        return uas.createUserAdmin(userAdmin);
    }

    @PutMapping("/api/useradmins/{id}")
    public UserAdmin updateUser(@PathVariable("id") Integer id, @RequestBody UserAdmin user) {
        return uas.updateUserAdmin(user, id);
    }

    @PutMapping("/api/useradmins/{aId}/restaurants/{rId}")
    public void ownsRestaurant(@PathVariable("aId") int aId, @PathVariable("rId") int rId) {
        UserAdmin admin = uas.findUserAdminById(aId);
        Restaurant restaurant = rs.findRestaurantById(rId);
        admin.ownsRestaurant(restaurant);
        uas.updateUserAdmin(admin, aId);

    }
}
package com.example.wbdv2019finalprojectserver.repositories;

import java.util.List;

import com.example.wbdv2019finalprojectserver.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select user from User user")
    public List<User> findAllUsers();

    @Query("select user from User user where user.id=:userId")
    public User findUserById(@Param("userId") Integer userId);

    @Query("select user from User user where user.userName=:userName")
    public User findUserByUserName(@Param("userName") String userName);
}
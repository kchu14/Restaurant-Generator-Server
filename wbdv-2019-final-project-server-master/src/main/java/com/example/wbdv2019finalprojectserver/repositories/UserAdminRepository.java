package com.example.wbdv2019finalprojectserver.repositories;

import java.util.List;

import com.example.wbdv2019finalprojectserver.models.UserAdmin;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserAdminRepository extends CrudRepository<UserAdmin, Integer> {

    @Query("select useradmin from UserAdmin useradmin")
    public List<UserAdmin> findAllUserAdmins();

    @Query("select useradmin from UserAdmin useradmin where useradmin.id=:useradminId")
    public UserAdmin findUserAdminById(@Param("useradminId") Integer userId);

    @Query("select useradmin from UserAdmin useradmin where useradmin.userName=:userName")
    public UserAdmin findUserByUserName(@Param("userName") String userName);
}
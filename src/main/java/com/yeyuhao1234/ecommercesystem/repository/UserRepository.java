package com.yeyuhao1234.ecommercesystem.repository;


import com.yeyuhao1234.ecommercesystem.entity.User;
import com.yeyuhao1234.ecommercesystem.model.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long > {

    //Query the user by the list
    @Query("SELECT u FROM User u WHERE u.state = ?1")
    public List<User>findByState(String state);

    // Query the user by the city
    @Query("SELECT u FROM User u WHERE u.city = ?1")
    public List<User> findByCity(String city);

    // Query the user by the email
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);

    // Delete user by the id
    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.userId = ?1")
    void deleteByUserId(long id);

    @Query("SELECT u.userId , u.userName ,u.email , u.city , u.state , u.phoneNumber FROM User u")
    List<Object[]> fetchAllUsers();
}

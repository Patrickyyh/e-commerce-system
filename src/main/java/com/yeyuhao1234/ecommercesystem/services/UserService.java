package com.yeyuhao1234.ecommercesystem.services;

import com.yeyuhao1234.ecommercesystem.entity.User;
import com.yeyuhao1234.ecommercesystem.model.UserRequest;
import com.yeyuhao1234.ecommercesystem.model.UserResponse;

import java.util.List;

public interface UserService {


    UserResponse getUserById(long userId);
    UserResponse addUser(UserRequest userRequest);
    List<User> fetchUserByState(String state);
    List<User> fetchUserByCity(String city);
    UserResponse getUserByEmail(String email);
    void deleteUserById(long userId);
    List<UserResponse> fetchAllUsers();

}

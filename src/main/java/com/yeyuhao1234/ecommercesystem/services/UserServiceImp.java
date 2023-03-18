package com.yeyuhao1234.ecommercesystem.services;

import com.yeyuhao1234.ecommercesystem.entity.User;
import com.yeyuhao1234.ecommercesystem.exception.UserServiceCustomException;
import com.yeyuhao1234.ecommercesystem.model.UserRequest;
import com.yeyuhao1234.ecommercesystem.model.UserResponse;
import com.yeyuhao1234.ecommercesystem.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserResponse> fetchAllUsers() {
        List<Object []>temp = userRepository.fetchAllUsers();
        List<UserResponse> users = new ArrayList<>();
        for(Object[] v1 : temp){
            UserResponse user = UserResponse.builder()
                    .userId((Long) v1[0])
                    .userName((String) v1[1])
                    .email((String) v1[2])
                    .city((String)  v1[3])
                    .state((String) v1[4])
                    .phoneNumber((String) v1[5])
                    .build();
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> fetchUserByState(String state) {
        return userRepository.findByState(state);
    }

    @Override
    public List<User> fetchUserByCity(String city) {
        return userRepository.findByCity(city);
    }

    @Override
    public UserResponse getUserById(long userId) {
        User user =  userRepository
                .findById(userId)
                .orElseThrow(()-> new UserServiceCustomException("User with given id not found","USER_NOT_FOUND"));

        UserResponse userResponse = new UserResponse();
        //copy properties from the user to userResponse
        BeanUtils.copyProperties(user , userResponse);
        return userResponse;
    }

    @Override
    public UserResponse getUserByEmail(String email) {
       User user = userRepository
               .findByEmail(email)
               .orElseThrow(()-> new UserServiceCustomException("User with given email not found", "USER_NOT_FOUND"));

       UserResponse userResponse = new UserResponse();
       BeanUtils.copyProperties(user , userResponse);
       return userResponse;

    }

    @Override
    public void deleteUserById(long userId) {

        userRepository.deleteByUserId(userId);
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User user = User.builder()
                .userName(userRequest.getUserName())
                .city(userRequest.getCity())
                .state(userRequest.getState())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .build();
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user , userResponse);
        User result = userRepository.save(user);
        userResponse.setUserId(result.getUserId());
        return userResponse;
    }
}

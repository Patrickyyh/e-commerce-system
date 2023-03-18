package com.yeyuhao1234.ecommercesystem.controller;

import com.yeyuhao1234.ecommercesystem.entity.User;
import com.yeyuhao1234.ecommercesystem.model.UserRequest;
import com.yeyuhao1234.ecommercesystem.model.UserResponse;
import com.yeyuhao1234.ecommercesystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
   @Autowired
   private UserService userService;

   @Autowired
   private EntityManager entityManager;



   // Get all User;

    @GetMapping("/")
    public List<UserResponse> fetchAllUsers(){
        return userService.fetchAllUsers();
    }

   //Get User by Id
   @GetMapping("/{id}")
   public ResponseEntity<UserResponse> getUserById(@PathVariable("id") long userId){
         UserResponse userResponse = userService.getUserById(userId);
         return new ResponseEntity<>(userResponse, HttpStatus.OK);
   }

   //Get user By state
    @GetMapping("/state")
    public List<User> fetchUserByState(@RequestParam(value="state") String state){
       return userService.fetchUserByState(state);
    }

    //Get user By city
    @GetMapping("/city")
    public List<User> fetchUserByCity(@RequestParam(value="city") String city){
       return userService.fetchUserByCity(city);
    }

    // Get user by email
    @GetMapping("/email")
    public ResponseEntity<UserResponse> getUserByEmail(@RequestParam(value = "email") String email){

       UserResponse userResponse = userService.getUserByEmail(email);
       return new ResponseEntity<>(userResponse , HttpStatus.OK);
    }

    //Delete user By id;
    @DeleteMapping("/userid")
    void deleteUserById(@RequestParam(value = "userid") long userId){
       userService.deleteUserById(userId);
    }


   @PostMapping
    public ResponseEntity<UserResponse>addUser(@RequestBody UserRequest userRequest){
       UserResponse userResponse  = userService.addUser(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
   }










}

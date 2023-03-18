package com.yeyuhao1234.ecommercesystem.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserRequest {
    private String userName;
    private String email;
    private String city;
    private String state;
    private String phoneNumber;
}

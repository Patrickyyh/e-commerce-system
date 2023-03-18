package com.yeyuhao1234.ecommercesystem.exception;

import lombok.Data;

@Data
public class UserServiceCustomException extends RuntimeException {
    private String errorCodes;
    public UserServiceCustomException(String message , String errorCodes){
        super(message);
        this.errorCodes = errorCodes;

    }
}

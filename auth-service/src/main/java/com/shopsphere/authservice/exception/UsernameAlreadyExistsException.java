package com.shopsphere.authservice.exception;

public class UsernameAlreadyExistsException extends  RuntimeException {

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}

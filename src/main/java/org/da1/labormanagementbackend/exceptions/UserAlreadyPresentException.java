package org.da1.labormanagementbackend.exceptions;

public class UserAlreadyPresentException extends Exception{
    public UserAlreadyPresentException(String message) {
        super(message);
    }
}

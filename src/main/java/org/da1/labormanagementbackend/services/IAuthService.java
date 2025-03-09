package org.da1.labormanagementbackend.services;

import org.da1.labormanagementbackend.exceptions.UserAlreadyPresentException;
import org.da1.labormanagementbackend.exceptions.UserNotFoundException;
import org.da1.labormanagementbackend.models.UserInfo;

public interface IAuthService {
    UserInfo login(String username, String password)throws UserNotFoundException;
    UserInfo signUp(String username, String password, String firstName,
                String lastName, String email) throws UserAlreadyPresentException;
    UserInfo updatePassword(String email,String password)throws UserNotFoundException;

}

package org.da1.labormanagementbackend.services;

import org.da1.labormanagementbackend.enums.ProfileTypes;
import org.da1.labormanagementbackend.exceptions.UserAlreadyPresentException;
import org.da1.labormanagementbackend.exceptions.UserNotFoundException;
import org.da1.labormanagementbackend.models.UserInfo;

public interface IAuthService {
    UserInfo login(String username, String password)throws UserNotFoundException;
    UserInfo signUpIndividual(String username,
                    String password,
                    String name,
                    String email,
                    String profileTypes,
                              String phoneNo
                   ) throws UserAlreadyPresentException;
    UserInfo signUpEmployer(String username,
                            String password,
                            String name,
                            String email,
                            String profileTypes,
                            String companyName,
                            String phoneNumber) throws UserAlreadyPresentException;
    UserInfo updatePassword(String email,String password)throws UserNotFoundException;

}

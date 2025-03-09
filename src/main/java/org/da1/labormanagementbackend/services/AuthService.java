package org.da1.labormanagementbackend.services;

import org.da1.labormanagementbackend.exceptions.UserAlreadyPresentException;
import org.da1.labormanagementbackend.exceptions.UserNotFoundException;
import org.da1.labormanagementbackend.models.Profile;
import org.da1.labormanagementbackend.models.UserInfo;
import org.da1.labormanagementbackend.repos.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserInfo login(String username, String password) throws UserNotFoundException {

        Optional<UserInfo> user=userRepository.findByUsername(username);
        if(user.isEmpty() || !bCryptPasswordEncoder.matches(password,user.get().getPassword())){
            throw new UserNotFoundException("Username or password is incorrect");
        }

        return user.get();
    }

    @Override
    public UserInfo signUp(String username, String password, String firstName,
                       String lastName, String email) throws UserAlreadyPresentException {
        Optional<UserInfo> userOptional=userRepository.findByEmailOrUsername(email,username);

        if(userOptional.isPresent()){
            throw new UserAlreadyPresentException("Please use any other email to sign");
        }

        UserInfo user=new UserInfo();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        Profile profile=new Profile();
        profile.setFirstName(firstName);
        profile.setLastName(lastName);



        return userRepository.save(user);
    }

    @Override
    public UserInfo updatePassword(String email,String password) throws UserNotFoundException {
        Optional<UserInfo> userOptional=userRepository.findByEmail(email);

        if(!userOptional.isPresent()){
            throw new UserNotFoundException("Please enter correct mail to sign");
        }
        UserInfo user=userOptional.get();
        user.setPassword(bCryptPasswordEncoder.encode(password));

        userRepository.save(user);
        return user;
    }


}

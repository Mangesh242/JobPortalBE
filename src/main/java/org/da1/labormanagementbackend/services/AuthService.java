package org.da1.labormanagementbackend.services;

import org.apache.catalina.User;
import org.da1.labormanagementbackend.enums.ProfileTypes;
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
    public UserInfo signUpIndividual(String username,
                                 String password,
                                 String name,
                                 String email,
                                 String profileType,
                                     String phoneNo) throws UserAlreadyPresentException {
        Optional<UserInfo> userOptional=userRepository.findByEmailOrUsername(email,username);

        if(userOptional.isPresent()){
            throw new UserAlreadyPresentException("Please use any other email to sign");
        }

        UserInfo user=new UserInfo();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setName(name);
        user.setEmail(email);
        ProfileTypes profileTypes=ProfileTypes.valueOf(profileType);
        user.setProfileType(profileTypes);
        user.setPhoneNumber(phoneNo);

        return userRepository.save(user);

    }
    @Override
    public UserInfo signUpEmployer(String username,
                           String password,
                           String name,
                           String email,
                           String profile,
                           String companyName,
                           String phoneNumber
                           ) throws UserAlreadyPresentException {
        Optional<UserInfo> userOptional=userRepository.findByEmailOrUsername(email,username);

        if(userOptional.isPresent()){
            throw new UserAlreadyPresentException("Please use any other email to sign");
        }

        UserInfo user=new UserInfo();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setName(name);
        user.setEmail(email);
        ProfileTypes profileTypes=ProfileTypes.valueOf(profile);
        user.setProfileType(profileTypes);
        user.setCompanyName(companyName);
        user.setPhoneNumber(phoneNumber);

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

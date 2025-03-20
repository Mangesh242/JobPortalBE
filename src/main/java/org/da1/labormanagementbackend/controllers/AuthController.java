package org.da1.labormanagementbackend.controllers;

import org.da1.labormanagementbackend.dtos.ForegetPasswordDTO;
import org.da1.labormanagementbackend.dtos.LoginRequestDTO;
import org.da1.labormanagementbackend.dtos.UserDTO;
import org.da1.labormanagementbackend.dtos.signupRequestDTO;
import org.da1.labormanagementbackend.exceptions.UserNotFoundException;
import org.da1.labormanagementbackend.models.UserInfo;
import org.da1.labormanagementbackend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        try{
            UserInfo user = authService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
            return new ResponseEntity<>(from(user), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("signupInd")
    public ResponseEntity<UserDTO> signupInd(@RequestBody signupRequestDTO signUpRequestDTO) {
        try {
            UserInfo user = authService.signUpIndividual(signUpRequestDTO.getUsername(),
                    signUpRequestDTO.getPassword(),
                    signUpRequestDTO.getName(),
                    signUpRequestDTO.getEmail(),
                    signUpRequestDTO.getProfile(),
                    signUpRequestDTO.getPhoneNumber()
            );
            return new ResponseEntity<>(from(user), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("signupEmp")
    public ResponseEntity<UserDTO> signupEmp(@RequestBody signupRequestDTO signUpRequestDTO) {
        try {
            UserInfo user = authService.signUpEmployer(signUpRequestDTO.getUsername(),
                    signUpRequestDTO.getPassword(),
                    signUpRequestDTO.getName(),
                    signUpRequestDTO.getEmail(),
                    signUpRequestDTO.getProfile(),
                    signUpRequestDTO.getCompanyName(),
                    signUpRequestDTO.getPhoneNumber()
            );
            return new ResponseEntity<>(from(user), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("update-password")
    public ResponseEntity<ForegetPasswordDTO> updatePassword(@RequestBody ForegetPasswordDTO foregetPasswordDTO) {
        ForegetPasswordDTO forgotPasswordDTO = new ForegetPasswordDTO();
        try{
            UserInfo user = authService.updatePassword(foregetPasswordDTO.getEmail(), foregetPasswordDTO.getPassword());
            forgotPasswordDTO.setEmail(user.getEmail());
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(foregetPasswordDTO,HttpStatus.OK);
    }





    private UserDTO from(UserInfo user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        System.out.println(user.getProfileType());
        userDTO.setProfileType(user.getProfileType());



        return userDTO;
    }
}

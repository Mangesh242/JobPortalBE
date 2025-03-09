package org.da1.labormanagementbackend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class signupRequestDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}

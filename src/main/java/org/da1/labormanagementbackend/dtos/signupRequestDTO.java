package org.da1.labormanagementbackend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.da1.labormanagementbackend.enums.ProfileTypes;

@Getter
@Setter
public class signupRequestDTO {
    private String username;
    private String password;
    private String name;
    private String email;
    private String profile;
    private String companyName;
    private String phoneNumber;
}

package org.da1.labormanagementbackend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.da1.labormanagementbackend.enums.ProfileTypes;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String username;
    private String password;
    private ProfileTypes profileType;
    private String name;
    private String phoneNumber;
}

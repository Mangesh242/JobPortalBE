package org.da1.labormanagementbackend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
}

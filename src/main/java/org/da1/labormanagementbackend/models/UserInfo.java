package org.da1.labormanagementbackend.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserInfo extends BaseModel{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

}

package org.da1.labormanagementbackend.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.da1.labormanagementbackend.enums.ProfileTypes;

@Entity
@Getter
@Setter
public class UserInfo extends BaseModel{
    private String email;
    private String username;
    private String password;
    private ProfileTypes profileType;//
    private String name;
    private String companyName;
    private String phoneNumber;


}

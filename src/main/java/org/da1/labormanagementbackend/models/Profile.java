package org.da1.labormanagementbackend.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Profile extends BaseModel {


    private int userId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String address;
    private String resume; // For employee
    private String companyName; // For employer
    private String companyWebsite; // For employer
    private String companyLogo; // For employer

}


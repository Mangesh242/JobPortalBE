package org.da1.labormanagementbackend.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Profile extends BaseModel {

    private String firstName;
    private String lastName;
    private String contactNumber;
    private String address;

}


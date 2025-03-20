package org.da1.labormanagementbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Employer extends Profile{

    @OneToMany
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private List<UserInfo> user;
    private String companyName;
    private String description;
    private String address;
    private String phoneNumber;

    private String companyWebsite; // For employer
    private String companyLogo; // For employer




}

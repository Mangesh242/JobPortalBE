package org.da1.labormanagementbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class JobApplication extends BaseModel{
    private int jobId;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private UserInfo user;

    private String coverLetter;
    private String status; // "applied", "reviewed", "interview", "hired", "rejected"
    private Date appliedDate;

}

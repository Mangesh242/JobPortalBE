package org.da1.labormanagementbackend.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class JobPosting extends BaseModel{

        private Long employerId;
        private String title;
        private String description;
        private String category;
        private String location;
        private String salaryRange;
        private String jobType; // "full-time", "part-time", "contract"


}

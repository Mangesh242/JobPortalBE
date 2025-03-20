package org.da1.labormanagementbackend.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
public class JobPostDTO {

    private Long employerId;
    private String title;
    private String description;
    private String location;
    private String salaryRange;
    private String jobType; // "full-time", "part-time", "contract"

    private Long id;
    private LocalDateTime createDate;
    private String category;
}

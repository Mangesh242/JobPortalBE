package org.da1.labormanagementbackend.services;

import org.da1.labormanagementbackend.models.JobPosting;
import org.da1.labormanagementbackend.repos.IJobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JobPostService {
    @Autowired
    IJobPostRepository iJobPostRepository;

    public List<JobPosting> getAllJobPosting() {
        return iJobPostRepository.findAll();
    }

    public int doesJobPostExist(Long id){
            if(iJobPostRepository.existsById(id)){
                return 1;
            }
            return 0;
    }

    public JobPosting save(Long employerId,
                           String title,
                           String description,
                           String location,
                           String salaryRange,
                           String jobType) {
        JobPosting jobPosting = new JobPosting();
        jobPosting.setEmployerId(employerId);
        jobPosting.setTitle(title);
        jobPosting.setDescription(description);
        jobPosting.setLocation(location);
        jobPosting.setSalaryRange(salaryRange);
        jobPosting.setJobType(jobType);


        jobPosting.setCreatedAt(LocalDateTime.now());

        Optional<JobPosting> jobPostingOptional = Optional.of(iJobPostRepository.save(jobPosting));
        if (jobPostingOptional.isPresent()) {
            System.out.println("Successfully added job posting");
            return jobPostingOptional.get();
        }
        System.out.println("Failed to add job posting");
        return null;
    }

}

package org.da1.labormanagementbackend.controllers;

import org.da1.labormanagementbackend.dtos.JobPostDTO;
import org.da1.labormanagementbackend.models.JobPosting;
import org.da1.labormanagementbackend.services.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class JobPostController {
    @Autowired
    private JobPostService jobPostService;

    @GetMapping
    public ResponseEntity<List<JobPostDTO>> getAllJobPosts() {
        List<JobPostDTO> jobPostDTOList= new ArrayList<>();

        List<JobPosting> jobPostingList=this.jobPostService.getAllJobPosting();
        if(jobPostingList.size()>0){
            for(JobPosting jobPosting:jobPostingList){
                JobPostDTO jobPostDTO;
                jobPostDTO=convertJOBPostingtoDTO(jobPosting);
                jobPostDTOList.add(jobPostDTO);
            }
            return new ResponseEntity<>(jobPostDTOList, HttpStatus.OK);
        }
        return new ResponseEntity<>(jobPostDTOList, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JobPostDTO> createJobPost(@RequestBody JobPostDTO jobPostDTO) {

        if(jobPostDTO.getId()!=null && this.jobPostService.doesJobPostExist(jobPostDTO.getId())==1){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        JobPosting jobPosting= this.jobPostService.save(
                jobPostDTO.getEmployerId(),
                jobPostDTO.getTitle(),
                jobPostDTO.getDescription(),
                jobPostDTO.getLocation(),
                jobPostDTO.getSalaryRange(),
                jobPostDTO.getJobType());

        JobPostDTO jobPostDTOResponse = convertJOBPostingtoDTO(jobPosting);

        if(jobPosting==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(jobPostDTOResponse, HttpStatus.CREATED);
    }

    private JobPostDTO convertJOBPostingtoDTO(JobPosting jobPosting){
        JobPostDTO jobPostDTO = new JobPostDTO();
        jobPostDTO.setEmployerId(jobPosting.getId());
        jobPostDTO.setTitle(jobPosting.getTitle());
        jobPostDTO.setDescription(jobPosting.getDescription());
        jobPostDTO.setLocation(jobPosting.getLocation());
        jobPostDTO.setSalaryRange(jobPosting.getSalaryRange());
        jobPostDTO.setJobType(jobPosting.getJobType());
        jobPostDTO.setCreateDate(jobPosting.getCreatedAt());
        jobPostDTO.setId(jobPosting.getId());
        return jobPostDTO;
    }

    private JobPosting convertJOBPostDTOtoJobPosting(JobPostDTO jobPostDTO){
        JobPosting jobPosting = new JobPosting();
        jobPosting.setId(jobPostDTO.getEmployerId());
        jobPosting.setTitle(jobPostDTO.getTitle());
        jobPosting.setDescription(jobPostDTO.getDescription());
        jobPosting.setLocation(jobPostDTO.getLocation());
        jobPosting.setSalaryRange(jobPostDTO.getSalaryRange());
        jobPosting.setJobType(jobPostDTO.getJobType());
        jobPosting.setCreatedAt(jobPostDTO.getCreateDate());
        return jobPosting;
    }
}

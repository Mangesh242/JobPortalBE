package org.da1.labormanagementbackend.repos;

import org.da1.labormanagementbackend.models.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IJobPostRepository extends JpaRepository<JobPosting,Long> {


}

package jmu.gcy.controller;

import jmu.gcy.bean.JobApplication;
import jmu.gcy.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationRepository;

    @GetMapping
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.getAllJobApplications();
    }
}
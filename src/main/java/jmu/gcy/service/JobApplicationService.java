package jmu.gcy.service;


import jmu.gcy.bean.JobApplication;

import java.util.List;

public interface JobApplicationService {
    public List<JobApplication> getApplicationsByEmployerId(int employerId);

    public JobApplication getApplicationsByApplicationId(int applicationId);

    public boolean agreeApplication(int applicationId);

    public boolean rejectApplication(int applicationId);

    void insertApplication(JobApplication jobApplication);
}


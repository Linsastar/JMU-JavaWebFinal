package jmu.gcy.service;


import jmu.gcy.bean.JobApplication;

import java.util.List;

public interface JobApplicationService {
    public List<JobApplication> getApplicationsByEmployerId(int employerId);
}


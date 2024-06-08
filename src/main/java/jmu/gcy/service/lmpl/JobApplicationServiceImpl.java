package jmu.gcy.service.lmpl;

import jmu.gcy.bean.Employment;
import jmu.gcy.bean.JobApplication;
import jmu.gcy.bean.Student;
import jmu.gcy.mapper.EmploymentMapper;
import jmu.gcy.mapper.StudentMapper;
import jmu.gcy.service.JobApplicationService;
import jmu.gcy.mapper.JobApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
    @Autowired
    private JobApplicationMapper jobApplicationMapper;

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private EmploymentMapper employmentMapper;

    @Override
    public List<JobApplication> getApplicationsByEmployerId(int employerId) {
        List<JobApplication> jobApplications = jobApplicationMapper.getApplicationsByEmployerId(employerId);
        for (JobApplication jobApplication : jobApplications) {
            // 获取学生信息
            Student student = studentMapper.getStudentById(jobApplication.getStudentId());
            jobApplication.setStudentName(student.getName());
            jobApplication.setJobTitle(jobApplicationMapper.getEmploymentById(jobApplication.getEmploymentId()).getJobTitle());
        }
        return jobApplications;
    }

    @Override
    public JobApplication getApplicationsByApplicationId(int applicationId) {
        JobApplication jobApplication = jobApplicationMapper.getApplicationsByApplicationId(applicationId);
        jobApplication.setStudentName(studentMapper.getStudentById(jobApplication.getStudentId()).getName());
        jobApplication.setJobTitle(jobApplicationMapper.getEmploymentById(jobApplication.getEmploymentId()).getJobTitle());
        return jobApplication;
    }

}


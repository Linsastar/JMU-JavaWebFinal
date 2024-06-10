package jmu.gcy.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import jmu.gcy.bean.JobApplication;
import jmu.gcy.bean.Student;
import jmu.gcy.mapper.EmploymentMapper;
import jmu.gcy.mapper.JobApplicationMapper;
import jmu.gcy.mapper.StudentMapper;
import jmu.gcy.service.JobApplicationService;
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

    @Override
    public boolean agreeApplication(int applicationId) {
        try {
            // 创建一个 UpdateWrapper 对象，用于指定更新条件和更新字段
            UpdateWrapper<JobApplication> updateWrapper = new UpdateWrapper<>();

            // 设置更新条件为 application_id 等于传入的 applicationId
            updateWrapper.eq("application_id", applicationId).set("status", "已录用");

            // 执行更新操作，并获取受影响的行数
            int rows = jobApplicationMapper.update(null, updateWrapper);

            // 判断更新是否成功，返回 true 或 false
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean rejectApplication(int applicationId) {
        try {
            // 创建一个 UpdateWrapper 对象，用于指定更新条件和更新字段
            UpdateWrapper<JobApplication> updateWrapper = new UpdateWrapper<>();

            // 设置更新条件为 application_id 等于传入的 applicationId
            updateWrapper.eq("application_id", applicationId).set("status", "未录用");

            // 执行更新操作，并获取受影响的行数
            int rows = jobApplicationMapper.update(null, updateWrapper);

            // 判断更新是否成功，返回 true 或 false
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void insertApplication(JobApplication jobApplication) {
        jobApplicationMapper.insert(jobApplication);
    }

}


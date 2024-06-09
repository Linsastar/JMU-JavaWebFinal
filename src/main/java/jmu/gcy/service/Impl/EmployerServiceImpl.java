package jmu.gcy.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jmu.gcy.bean.Employer;
import jmu.gcy.mapper.EmployerMapper;
import jmu.gcy.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerMapper employerMapper;

    @Override
    public Employer login(String employer_id, String password) {
        // 根据用户名和密码查询用人单位信息
        Employer employer = employerMapper.selectOne(new QueryWrapper<Employer>()
                .eq("employer_id", employer_id)
                .eq("password", password));
        return employer;
    }

    @Override
    public List<Employer> getAllEmployers() {
        return employerMapper.getAllEmployers();
    }

    @Override
    public int registerEmployer(Employer employer) {
        return employerMapper.insert(employer);
    }

    @Override
    public void approveEmployer(int employerId) {
        Employer employer = employerMapper.getEmployerById(employerId);
        employer.setVerificationStatus("已通过");
        employerMapper.update(employer, new QueryWrapper<Employer>().eq("employer_id", employerId));
    }

    @Override
    public void rejectEmployer(int employerId) {
        Employer employer = employerMapper.getEmployerById(employerId);
        employer.setVerificationStatus("未通过");
        employerMapper.update(employer, new QueryWrapper<Employer>().eq("employer_id", employerId));
    }
}

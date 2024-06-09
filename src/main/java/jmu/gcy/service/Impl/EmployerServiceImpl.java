package jmu.gcy.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jmu.gcy.bean.Employer;
import jmu.gcy.mapper.EmployerMapper;
import jmu.gcy.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

package jmu.gcy.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import jmu.gcy.bean.Employment;
import jmu.gcy.mapper.EmploymentMapper;
import jmu.gcy.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmploymentServiceImpl implements EmploymentService {

    @Autowired
    private EmploymentMapper employmentMapper;

    @Override
    public List<Employment> getAllEmployments() {
        QueryWrapper<Employment> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");
        return employmentMapper.selectList(queryWrapper);
    }

    @Override
    public boolean addEmployment(Employment employment) {
        return employmentMapper.insert(employment) > 0;
    }



    @Override
    public boolean closeEmployment(int employmentId) {
        try {
            // 使用 UpdateWrapper 更新职位状态
            UpdateWrapper<Employment> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("employment_id", employmentId).set("status", "已关闭");
            int rows = employmentMapper.update(null, updateWrapper);
            return rows > 0; // 如果更新了至少一行，返回 true
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public List<Employment> getEmploymentsByEmployerId(int employerId) {
        QueryWrapper<Employment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employer_id", employerId);
        return employmentMapper.selectList(queryWrapper);
    }
    @Override
    public boolean openEmployment(int employmentId) {
        try {
            // 使用 UpdateWrapper 更新职位状态为“招聘中”
            UpdateWrapper<Employment> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("employment_id", employmentId).set("status", "招聘中");
            int rows = employmentMapper.update(null, updateWrapper);
            return rows > 0; // 如果更新了至少一行，返回 true
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Employment> findByTypeContaining(String query) {
        return employmentMapper.findByTypeContaining(query);
    }

    @Override
    public Employment getEmploymentById(Integer employmentId) {
        return employmentMapper.selectById(employmentId);
    }
}


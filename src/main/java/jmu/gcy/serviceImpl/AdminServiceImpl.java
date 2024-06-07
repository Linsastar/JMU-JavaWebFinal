package jmu.gcy.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jmu.gcy.bean.Admin;
import jmu.gcy.mapper.AdminMapper;
import jmu.gcy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        // 根据用户名和密码查询管理员信息
        Admin admin = adminMapper.selectOne(new QueryWrapper<Admin>()
                .eq("username", username)
                .eq("password", password));
        return admin;
    }
}

package jmu.gcy.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jmu.gcy.bean.Student;
import jmu.gcy.mapper.StudentMapper;
import jmu.gcy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public Student login(String studentId, String password) {
        // 根据用户名和密码查询管理员信息
        Student student = studentMapper.selectOne(new QueryWrapper<Student>()
                .eq("student_id", studentId)
                .eq("password", password));
        return student;
    }

    @Override
    public void logout(HttpSession session) {
        // 这里处理登出逻辑，比如使会话失效
        session.invalidate(); // 销毁会话
        // 如果有其他与会话相关的清理工作，也可以在这里进行
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentMapper.getStudentById(studentId);
    }
}

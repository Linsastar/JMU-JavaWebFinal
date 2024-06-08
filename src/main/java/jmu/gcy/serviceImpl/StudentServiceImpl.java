package jmu.gcy.serviceImpl;

import jmu.gcy.bean.Student;
import jmu.gcy.mapper.StudentMapper;
import jmu.gcy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(Integer studentId) {
        return studentMapper.getStudentById(studentId);
    }
}

package jmu.gcy.service;

import jmu.gcy.bean.Student;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface StudentService {
    Student getStudentById(Integer studentId);

    Student login(String student_id, String password);

    void logout(HttpSession session);

    List<Student> getAllStudents();

    int updateStudent(Student student);
}
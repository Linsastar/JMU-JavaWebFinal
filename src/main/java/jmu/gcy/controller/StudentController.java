package jmu.gcy.controller;

import jmu.gcy.bean.Student;
import jmu.gcy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentRepository.getStudentById(id);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
        // 确保更新的学生ID一致
        updatedStudent.setStudentId(id);

        // 调用MyBatis的更新方法
        int updatedRows = studentRepository.updateStudent(updatedStudent);

        if (updatedRows > 0) {
            return "Student updated successfully!";
        } else {
            return "Failed to update student.";
        }
    }
}


package jmu.gcy.service;

import jmu.gcy.bean.Student;

import javax.servlet.http.HttpSession;

public interface StudentService {
   Student login(String studentId, String password);
   void logout(HttpSession session);
}

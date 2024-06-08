
package jmu.gcy.controller;

import jmu.gcy.bean.Admin;
import jmu.gcy.bean.Student;
import jmu.gcy.service.AdminService;
import jmu.gcy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class StudentLoginController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/login")
    public String studentLogin(@RequestParam("student_id") String studentId, @RequestParam("password") String password, HttpSession session) {
        Student login = studentService.login(studentId, password);
        if (login != null) {
            session.setAttribute("loggedInstudent", login);
            return "student_console";
        } else {
            return "student_error";
        }
    }

    @PostMapping("/student/logout")
    public String studentLogout(HttpSession session, RedirectAttributes redirectAttributes) {
        // 调用 StudentService 的登出方法
        studentService.logout(session);
        // 添加一个 flash 属性来通知前端显示登出消息（如果需要）
        redirectAttributes.addFlashAttribute("logoutSuccess", true);

        // 重定向到登录页面
        return "redirect:/student/login";
    }

}




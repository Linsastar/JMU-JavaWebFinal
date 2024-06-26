
package jmu.gcy.controller;

import jmu.gcy.bean.Employer;
import jmu.gcy.bean.Employment;
import jmu.gcy.bean.JobApplication;
import jmu.gcy.bean.Student;
import jmu.gcy.service.EmployerService;
import jmu.gcy.service.EmploymentService;
import jmu.gcy.service.JobApplicationService;
import jmu.gcy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentLoginController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private EmploymentService employmentService;
    @Autowired
    private JobApplicationService jobApplicationService;
    @Autowired
    private EmployerService employerService;

    @RequestMapping("/student/login")
    public String studentLogin(@RequestParam("student_id") String studentId, @RequestParam("password") String password, HttpSession session) {
        Student login = studentService.login(studentId, password);
        if (login != null) {
            session.setAttribute("loggedInstudent", login);
            return "redirect:/student_console";
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

    @GetMapping("/student/resume")
    public String getResumePage(Model model, HttpSession session) {
        // 从session中获取当前登录的学生对象
        Student loggedInStudent = (Student) session.getAttribute("loggedInstudent");

        // 检查是否已登录
        if (loggedInStudent != null) {
            // 假设你的Student类包含了所有必要的简历信息
            // 直接将student对象添加到Model中，以便在前端页面中使用
            model.addAttribute("student", loggedInStudent);

            // 返回个人简历页面的视图名称
            return "student_resume";
        } else {
            // 如果未登录，重定向到登录页面或显示错误页面
            return "redirect:/student/login"; // 或者 "student_error"
        }
    }

    @GetMapping("/student_console")
    public String showEmployerConsole(Model model, HttpSession session) {
        if (session != null) {
            List<Employment> employments = employmentService.getAllEmployments();
            model.addAttribute("employments", employments);
            List<Employer> enterprises = employerService.getAllEmployers();
            model.addAttribute("enterprises", enterprises);
            return "student_console"; // 返回到名为 "employer_console" 的页面
        } else {
            return "redirect:/student/login"; // 如果未登录，重定向到登录页面
        }
    }

    @PostMapping("/student/apply")
    public String applyForJob(@RequestParam("employmentId") int employmentId, HttpSession session) {
        Student student = (Student) session.getAttribute("loggedInstudent");

        if (student != null) {
            JobApplication jobApplication = new JobApplication();
            jobApplication.setStudentId(student.getStudentId());
            jobApplication.setEmploymentId(employmentId);
            jobApplication.setStatus("待处理");
            jobApplication.setApplicationDate(new java.util.Date());
            jobApplication.setEmployerId(employmentService.getEmployerById(employmentId).getEmployerId());
            jobApplicationService.insertApplication(jobApplication);
            return "redirect:/student_console"; // 重定向到学生控制台页面
        } else {
            return "redirect:/student/login"; // 如果未登录，重定向到登录页面
        }
    }


}




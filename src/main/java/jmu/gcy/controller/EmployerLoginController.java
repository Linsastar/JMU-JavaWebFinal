package jmu.gcy.controller;

import jmu.gcy.bean.Employer;
import jmu.gcy.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class EmployerLoginController {

    @Autowired
    private EmployerService employerService;

    @PostMapping("/employer/login")
    public String employerLogin(@RequestParam("employer_id") String employer_id, @RequestParam("password") String password, HttpSession session) {
        Employer employer = employerService.login(employer_id, password);
        if (employer != null) {
            session.setAttribute("loggedInEmployer", employer);
            return "redirect:/employer_console"; // 登录成功，重定向到 /employer_console 页面
        } else {
            return "employer_error"; // 登录失败，重定向到错误页面
        }
    }
}




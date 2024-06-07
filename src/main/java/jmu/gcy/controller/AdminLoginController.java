
package jmu.gcy.controller;

import jmu.gcy.bean.Admin;
import jmu.gcy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminLoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping( "/admin/login")
    public String adminLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            session.setAttribute("loggedInAdmin", admin);
            return "admin_console";
        } else {
            return "admin_error";
        }
    }
}




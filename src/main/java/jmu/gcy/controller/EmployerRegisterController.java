package jmu.gcy.controller;

import jmu.gcy.bean.Employer;
import jmu.gcy.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployerRegisterController {

    @Autowired
    private EmployerService employerService;

    @PostMapping("/register_employer")
    public String registerEmployer(
            @RequestParam("company_name") String companyName,
            @RequestParam("password") String password,
            @RequestParam("contact_person") String contactPerson,
            @RequestParam("address") String address,
            @RequestParam("nature") String nature,
            @RequestParam("email") String email,
            @RequestParam("scale") String scale,
            @RequestParam("contact_number") String contactNumber,
            Model model) {

        // 创建新的 Employer 实体
        Employer employer = new Employer();
        employer.setCompanyName(companyName);
        employer.setPassword(password);  // 这里应该对密码进行加密处理
        employer.setContactPerson(contactPerson);
        employer.setAddress(address);
        employer.setNature(nature);
        employer.setEmail(email);
        employer.setScale(scale);
        employer.setContactNumber(contactNumber);
        employer.setVerificationStatus("未审核");
        // 保存到数据库
        int result = employerService.registerEmployer(employer);
        if (result == 1) {
            model.addAttribute("message", "注册成功");
        } else {
            model.addAttribute("message", "注册失败");
        }
        return "redirect:/employer.html";
    }
}

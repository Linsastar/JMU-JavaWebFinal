package jmu.gcy.controller;

import jmu.gcy.bean.Employer;
import jmu.gcy.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminConsoleController {
    @Autowired
    private EmployerService employerService;

    @GetMapping("/admin/reviewEmployers")
    public String showReviewEmployers(Model model) {
        List<Employer> employers = employerService.getAllEmployers();
        model.addAttribute("employers", employers);
        return "admin_reviewEmployers";
    }

    @GetMapping("/admin/verifyEmployer")
    public String verifyEmployer(@RequestParam("employerId") int employerId,
                                 @RequestParam("action") String action,
                                 Model model) {
        // 处理审核逻辑
        if ("approve".equals(action)) {
            employerService.approveEmployer(employerId);
            model.addAttribute("message", "用人单位审核已通过");
        } else if ("reject".equals(action)) {
            employerService.rejectEmployer(employerId);
            model.addAttribute("message", "用人单位审核已拒绝");
        } else {
            model.addAttribute("message", "无效的审核操作");
        }

        // 返回审核后的页面（可以是审核列表页面）
        return "redirect:/admin/reviewEmployers";
    }
}

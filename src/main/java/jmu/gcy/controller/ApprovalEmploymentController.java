package jmu.gcy.controller;

import jmu.gcy.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApprovalEmploymentController {
    @Autowired
    private JobApplicationService jobApplicationService;

    // 通过
    @PostMapping("/approve")
    public String approveApplication(@RequestParam("applicationId") int applicationId) {
        jobApplicationService.agreeApplication(applicationId);
        return "redirect:/employer_console"; // 重定向到 /employer_console 页面
    }

    // 不通过
    @PostMapping("/reject")
    public String rejectApplication(@RequestParam("applicationId") int applicationId) {
        jobApplicationService.rejectApplication(applicationId);
        return "redirect:/employer_console"; // 重定向到 /employer_console 页面
    }
}

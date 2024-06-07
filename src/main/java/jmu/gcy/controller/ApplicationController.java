package jmu.gcy.controller;

import jmu.gcy.bean.JobApplication;
import jmu.gcy.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ApplicationController {
    @Autowired
    private JobApplicationService applicationService;

    @GetMapping("/process/{applicationId}")
    public String processApplication(@PathVariable int applicationId, Model model) {
        JobApplication application = applicationService.getApplicationsByApplicationId(applicationId);
        model.addAttribute("job_application", application);
        return "employer_dealapplication";
    }
}

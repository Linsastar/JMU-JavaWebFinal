package jmu.gcy.controller;

import jmu.gcy.bean.JobApplication;
import jmu.gcy.bean.Student;
import jmu.gcy.service.JobApplicationService;
import jmu.gcy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ApplicationController {
    @Autowired
    private JobApplicationService applicationService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/process/{applicationId}")
    public String processApplication(@PathVariable int applicationId, Model model) {
        JobApplication application = applicationService.getApplicationsByApplicationId(applicationId);
        Student student = studentService.getStudentById(application.getStudentId());
        model.addAttribute("job_application", application);
        model.addAttribute("student", student);
        return "employer_dealapplication";
    }
}

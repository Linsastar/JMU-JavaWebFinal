package jmu.gcy.controller;

import jmu.gcy.bean.Employment;
import jmu.gcy.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VisitorController {
    @Autowired private EmploymentService employmentService;

    @GetMapping("/visitor")
    public String showEmployerConsole(Model model) {
        List<Employment> employments = employmentService.getAllEmployments();
        model.addAttribute("employments", employments);
        return "visitor";
    }
}

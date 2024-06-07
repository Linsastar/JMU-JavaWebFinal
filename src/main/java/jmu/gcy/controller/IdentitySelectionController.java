package jmu.gcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IdentitySelectionController {

    @PostMapping("/selectIdentity")
    public String selectIdentity(@RequestParam("identity") String identity) {
        switch (identity) {
            case "admin":
                return "redirect:/manage.html";
            case "employer":
                return "redirect:/employer.html";
            case "student":
                return "redirect:/student.html";
            case "visitor":
                return "redirect:/visitor.html";
            default:
                return "redirect:/error.html";
        }
    }
}



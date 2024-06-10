package jmu.gcy.controller;

import jmu.gcy.bean.Employment;
import jmu.gcy.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employments")
public class ManageRecruitmentsController {
    @Autowired
    private EmploymentService employmentRepository;

    @GetMapping
    public List<Employment> getAllEmployments() {
        return employmentRepository.getAllEmployments();
    }

    @PutMapping("/{id}")
    public Employment updateEmploymentStatus(@PathVariable Integer id, @RequestBody Employment updatedEmployment) {
        Employment employment = employmentRepository.getEmploymentById(id);
        employment.setStatus(updatedEmployment.getStatus());
        return employmentRepository.updateEmploymentStatus(employment);
    }
}

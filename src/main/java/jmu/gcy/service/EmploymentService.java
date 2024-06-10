
package jmu.gcy.service;

import jmu.gcy.bean.Employer;
import jmu.gcy.bean.Employment;

import java.util.List;

public interface EmploymentService {
    List<Employment> getAllEmployments();
    boolean addEmployment(Employment employment);
    List<Employment> getEmploymentsByEmployerId(int employerId);
    boolean closeEmployment(int employmentId);
    boolean openEmployment(int employmentId);
    List<Employment> findByTypeContaining(String query);
    Employment getEmploymentById(Integer employmentId);

    Employer getEmployerById(int employmentId);

    Employment updateEmploymentStatus(Employment employment);
}




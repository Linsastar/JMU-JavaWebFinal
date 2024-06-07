
package jmu.gcy.service;
import jmu.gcy.bean.Employment;

import java.util.List;

public interface EmploymentService {
    List<Employment> getAllEmployments();
    boolean addEmployment(Employment employment);
    List<Employment> getEmploymentsByEmployerId(int employerId);
    boolean closeEmployment(int employmentId);
    boolean openEmployment(int employmentId);
    Employment getEmploymentById(Integer employmentId);
}




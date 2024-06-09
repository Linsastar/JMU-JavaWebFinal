package jmu.gcy.service;

import jmu.gcy.bean.Employer;

public interface EmployerService {
    Employer login(String employer_id, String password);

}

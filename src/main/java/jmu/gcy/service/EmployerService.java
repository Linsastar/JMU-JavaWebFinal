package jmu.gcy.service;

import jmu.gcy.bean.Employer;

import java.util.List;

public interface EmployerService {
    Employer login(String employer_id, String password);

    List<Employer> getAllEmployers();

    int registerEmployer(Employer employer);

    void approveEmployer(int employerId);

    void rejectEmployer(int employerId);
}
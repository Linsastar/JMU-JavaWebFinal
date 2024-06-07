package jmu.gcy.bean;

import java.util.Date;

public class Employment {
    private int employmentId;
    private int employerId;
    private Date startDate;
    private String salaryInformation;
    private String jobTitle;
    private String status;
    private String description;

    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmploymentId() {
        return employmentId;
    }

    public void setEmploymentId(int employmentId) {
        this.employmentId = employmentId;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getSalaryInformation() {
        return salaryInformation;
    }

    public void setSalaryInformation(String salaryInformation) {
        this.salaryInformation = salaryInformation;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

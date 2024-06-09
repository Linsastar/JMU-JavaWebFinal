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
    private String type;

    public Employment() {
    }

    public Employment(int employmentId, int employerId, Date startDate, String salaryInformation, String jobTitle, String status, String description, String type) {
        this.employmentId = employmentId;
        this.employerId = employerId;
        this.startDate = startDate;
        this.salaryInformation = salaryInformation;
        this.jobTitle = jobTitle;
        this.status = status;
        this.description = description;
        this.type = type;
    }


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

    /**
     * 获取
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Employment{employmentId = " + employmentId + ", employerId = " + employerId + ", startDate = " + startDate + ", salaryInformation = " + salaryInformation + ", jobTitle = " + jobTitle + ", status = " + status + ", description = " + description + ", type = " + type + "}";
    }
}

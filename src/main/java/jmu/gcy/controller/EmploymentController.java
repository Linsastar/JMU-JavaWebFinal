package jmu.gcy.controller;

import jmu.gcy.bean.Employer;
import jmu.gcy.bean.Employment;
import jmu.gcy.bean.JobApplication;
import jmu.gcy.bean.MessageBoard;
import jmu.gcy.service.EmploymentService;
import jmu.gcy.service.JobApplicationService;
import jmu.gcy.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmploymentController {

    @Autowired
    private EmploymentService employmentService;
    @Autowired
    private JobApplicationService applicationService;
    @Autowired
    private MessageBoardService messageBoardService;

    @GetMapping("/employer_console")
    public String showEmployerConsole(Model model, HttpSession session) {
        Employer loggedInEmployer = (Employer) session.getAttribute("loggedInEmployer");
        if (loggedInEmployer != null) {
            int employerId = loggedInEmployer.getEmployerId(); // 获取当前登录的用人单位的 employerId
            List<Employment> employments = employmentService.getEmploymentsByEmployerId(employerId);
            model.addAttribute("employments", employments);

            // 获取应聘记录
            List<JobApplication> jobApplications = applicationService.getApplicationsByEmployerId(employerId);
            model.addAttribute("job_applications", jobApplications);

            List<MessageBoard> messages = messageBoardService.getMessagesByEmployerId(employerId);
            model.addAttribute("comments", messages);

            return "employer_console"; // 返回到名为 "employer_console" 的页面
        } else {
            return "redirect:/employer/login"; // 如果未登录，重定向到登录页面
        }
    }


    @PostMapping("/employer_console/addEmployment")
    public String addEmployment(
            @RequestParam("jobTitle") String jobTitle,
            @RequestParam("jobDescription") String jobDescription,
            HttpSession session,
            Model model) {
        Employer loggedInEmployer = (Employer) session.getAttribute("loggedInEmployer");
        if (loggedInEmployer != null) {
            Employment employment = new Employment();
            employment.setEmployerId(loggedInEmployer.getEmployerId());
            employment.setJobTitle(jobTitle);
            employment.setDescription(jobDescription);
            employment.setStatus("招聘中"); // 确保状态为允许的值
            employmentService.addEmployment(employment);

            // 更新列表
            List<Employment> employments = employmentService.getEmploymentsByEmployerId(loggedInEmployer.getEmployerId());
            model.addAttribute("employments", employments);

            return "employer_console"; // 返回到名为 "employer_console" 的页面
        } else {
            return "redirect:/employer/login"; // 如果未登录，重定向到登录页面
        }
    }

    // 新增关闭申请的方法
    @PostMapping("/employer_console/closeEmployment")
    public String closeEmployment(
            @RequestParam("employmentId") int employmentId,
            HttpSession session,
            Model model) {
        Employer loggedInEmployer = (Employer) session.getAttribute("loggedInEmployer");
        if (loggedInEmployer != null) {
            boolean result = employmentService.closeEmployment(employmentId);

            if (result) {
                // 更新列表
                List<Employment> employments = employmentService.getEmploymentsByEmployerId(loggedInEmployer.getEmployerId());
                model.addAttribute("employments", employments);
                return "redirect:"; // 返回到名为 "employer_console" 的页面
            } else {
                model.addAttribute("error", "无法关闭职位，请稍后重试。");
                return "redirect:"; // 返回到同一页面，并显示错误信息
            }
        } else {
            return "redirect:/employer/login"; // 如果未登录，重定向到登录页面
        }
    }
    // 新增开启申请的方法
    @PostMapping("/employer_console/openEmployment")
    public String openEmployment(
            @RequestParam("employmentId") int employmentId,
            HttpSession session,
            Model model) {
        Employer loggedInEmployer = (Employer) session.getAttribute("loggedInEmployer");
        if (loggedInEmployer != null) {
            // 这里假设开启申请的逻辑与关闭申请的逻辑类似，只是将状态更新为“招聘中”
            // 如果实际逻辑有所不同，请根据实际情况修改
            boolean result = employmentService.openEmployment(employmentId);

            if (result) {
                // 更新列表
                List<Employment> employments = employmentService.getEmploymentsByEmployerId(loggedInEmployer.getEmployerId());
                model.addAttribute("employments", employments);
                return "redirect:"; // 返回到名为 "employer_console" 的页面
            } else {
                model.addAttribute("error", "无法开启申请，请稍后重试。");
                return "redirect:"; // 返回到同一页面，并显示错误信息
            }
        } else {
            return "redirect:/employer/login"; // 如果未登录，重定向到登录页面
        }
    }


}

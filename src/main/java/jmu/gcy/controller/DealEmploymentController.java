package jmu.gcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employment")
public class DealEmploymentController {

    @RequestMapping("/deal")
    public String dealEmployment() {
        // 处理逻辑
        return "redirect:/employment/list"; // 处理完后重定向到列表页面
    }
}


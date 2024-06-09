package jmu.gcy.controller;

import jmu.gcy.bean.MessageBoard;
import jmu.gcy.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminManageMessagesController {
    @Autowired
    private MessageBoardService messageBoardService;

    @GetMapping("/admin/manageMessages")
    public String manageMessages(Model model) {
        List<MessageBoard> messages = messageBoardService.getAllMessages();
        model.addAttribute("comments", messages);
        return "admin_manageMessages";
    }

    @PostMapping("/deleteComment")
    public String deleteComment(@RequestParam("commentId") int commentId) {
        messageBoardService.deleteMessage(commentId);
        return "redirect:/admin/manageMessages";
    }
}

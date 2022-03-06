package com.overone.controller;

import com.overone.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/chat")
    public String chat(@RequestParam("sender") String sender, Model model) {
        model.addAttribute("sender", sender);
        model.addAttribute("messages", messageService.getAllMessages());
        return "chat";
    }

    @PostMapping("/addMessage")
    public String addMessage(@RequestParam("sender") String sender, @RequestParam("text") String text, Model model) {
        if (messageService.addMessage(sender, text)) {
            model.addAttribute("sender", sender);
            model.addAttribute("messages", messageService.getAllMessages());
            return "chat";
        }
        model.addAttribute("sender", sender);
        model.addAttribute("errorMessage", "Add message Error");
        return "errorPage";
    }

    @PostMapping("/chatHiber")
    public String chatHiber(@RequestParam("sender") String sender, Model model) {
        model.addAttribute("sender", sender);
        model.addAttribute("messages", messageService.getAllMessagesHiber());
        return "chatHiber";
    }

}

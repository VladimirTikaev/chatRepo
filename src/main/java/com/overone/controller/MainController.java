package com.overone.controller;


import com.overone.model.Message;
import com.overone.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
        model.addAttribute("sender123", sender);
        model.addAttribute("messages", messageService.getAllMessages());
        return "chat";
    }


}

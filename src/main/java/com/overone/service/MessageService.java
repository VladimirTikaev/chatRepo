package com.overone.service;


import com.overone.model.Message;
import com.overone.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }

    public boolean addMessage(String sender, String text) {
        if (text == null || text.isEmpty()) return false;
        Message message = new Message();
        message.setSender(sender);
        message.setText(text);
        message.setTime(LocalTime.now().toString().substring(0, 8));
        return messageRepo.save(message);
    }
}

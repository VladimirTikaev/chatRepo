package com.overone.service;


import com.overone.model.Message;
import com.overone.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public List<Message> getAllMessages(){
        return messageRepo.findAll();
    }

}

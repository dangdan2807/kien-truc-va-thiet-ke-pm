package com.spingbootactivemq.controller;

import com.spingbootactivemq.MessageReceiver;
import com.spingbootactivemq.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class home {

    @Autowired
    private SendMessage sendMessage;

    @Autowired
    private MessageReceiver messageReceiver;

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable(name = "message") String message) {
        String result = "demo: " + message;
        sendMessage.sendMessage(result);
        return result;
    }

    @GetMapping("/receiver")
    public List<String> receiver() {
        return messageReceiver.getMessages();
    }
}

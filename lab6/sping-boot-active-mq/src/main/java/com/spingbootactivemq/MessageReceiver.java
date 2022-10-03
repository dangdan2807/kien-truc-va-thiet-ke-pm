package com.spingbootactivemq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageReceiver {
    public static List<String> messages = new ArrayList<>();

    private static Logger logger = LogManager.getLogger(MessageReceiver.class);

    @JmsListener(destination = "demo")
    public void listener(String message) {
        messages.add(message);
        logger.info(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}

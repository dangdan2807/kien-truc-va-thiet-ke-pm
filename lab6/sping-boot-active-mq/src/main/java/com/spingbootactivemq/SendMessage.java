package com.spingbootactivemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendMessage {
//    private static Logger logger = LogManager.getLogger(Listener.class);
    private JmsTemplate jmsTemplate;

    @Autowired
    public SendMessage(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String name) {
        jmsTemplate.convertAndSend("demo", name);
    }
}

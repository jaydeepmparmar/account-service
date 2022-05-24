package com.tuum.account.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageSenderService {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public void send(String update) {
        rabbitTemplate.convertAndSend(queue.getName(), update);
    }
}

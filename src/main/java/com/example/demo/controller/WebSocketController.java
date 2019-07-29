package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * WebSocketController
 *
 * @author qzwy
 */
@RestController
public class WebSocketController {

    /**
     * 在 /welcome/{content} 接收参数 content
     * 将消息转发往 /topic/greetings
     */
    @MessageMapping("/welcome/{content}")
    @SendTo("/topic/greetings")
    public String handle(@PathVariable String content) {
        return content;
    }
}

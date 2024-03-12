package com.colak.springwebsockettutorial.config;

import com.colak.springwebsockettutorial.handler.SocketTextHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // http://localhost:8080/index.html
        registry.addHandler(new SocketTextHandler(), "/user");
    }
}
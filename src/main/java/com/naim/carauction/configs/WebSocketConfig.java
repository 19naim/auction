package com.naim.carauction.configs;

import com.naim.carauction.controllers.SocketController;
import com.naim.carauction.services.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    SocketService socketService;

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        SocketController sc = new SocketController();
        sc.setSocketService(socketService);
        registry.addHandler(sc, "/auction-socket").setAllowedOrigins("*");
    }
}

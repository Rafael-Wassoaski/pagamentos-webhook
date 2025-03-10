package com.rafaelwassoaski.webhook.Webhook.infrastructure.websocket;

import com.rafaelwassoaski.webhook.Webhook.adapters.inbound.websocket.PagamentosWebSocket;
import jakarta.websocket.server.ServerContainer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.ServletContext;

@Configuration
public class WebSocketConfig {
    @Bean
    public ApplicationRunner configureWebSocket(ServletContext context) {
        return args -> {
            ServerContainer serverContainer = (ServerContainer) context.getAttribute("jakarta.websocket.server.ServerContainer");
            if (serverContainer != null) {
                serverContainer.addEndpoint(PagamentosWebSocket.class);
            } else {
                throw new IllegalStateException("Não foi possível configurar o WebSocket!");
            }
        };
    }
}
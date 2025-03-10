package com.rafaelwassoaski.webhook.Webhook.application.service;

import com.google.gson.Gson;
import com.rafaelwassoaski.webhook.Webhook.application.dto.PagamentoDTO;
import jakarta.websocket.Session;

import java.util.Set;

public class WebsocketService {
    private Set<Session> userSessions;

    public WebsocketService() {
        this.userSessions = SessionsSingleton.getUserSessions();
    }

    public void adicionarUserSession(Session userSession){
        userSessions.add(userSession);
    }

    public void removerUserSession(Session userSession){
        userSessions.remove(userSession);
    }

    public void atualizarPagamento (String id) throws Exception {
        PagamentoDTO pagamentoDTO = new PagamentoDTO(id);
        Gson gson = new Gson();
        for(Session session : userSessions){
            session.getAsyncRemote().sendText(gson.toJson(pagamentoDTO));
        }
    }
}

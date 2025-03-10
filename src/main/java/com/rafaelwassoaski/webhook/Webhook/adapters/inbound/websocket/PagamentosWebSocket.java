package com.rafaelwassoaski.webhook.Webhook.adapters.inbound.websocket;

import com.google.gson.Gson;
import com.rafaelwassoaski.webhook.Webhook.application.dto.PagamentoDTO;
import com.rafaelwassoaski.webhook.Webhook.application.service.PagamentoService;
import com.rafaelwassoaski.webhook.Webhook.application.service.WebsocketService;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.websocket.Session;
import org.springframework.stereotype.Component;


@ServerEndpoint("/webhook/pagamentos/")
@Component
public class PagamentosWebSocket {

    private PagamentoService pagamentoService;
    private WebsocketService websocketService;


    public PagamentosWebSocket() {
        this.pagamentoService = new PagamentoService();
        this.websocketService = new WebsocketService();
    }

    @OnOpen
    public void abrir(Session userSession) {
        System.out.println("Nova solicitação recebida. Id: " + userSession.getId());
        websocketService.adicionarUserSession(userSession);
    }

    @OnClose
    public void fechar(Session userSession) {
        System.out.println("Fechando solicitação recebida. Id: " + userSession.getId());
        websocketService.removerUserSession(userSession);
    }

    @OnMessage
    public void rebecerNovoPagamento(String mensagem, Session userSession) throws Exception {
        System.out.println("Recebendo nova mensagem: " + mensagem);
        Gson gson = new Gson();
        PagamentoDTO pagamentoDTO = gson.fromJson(mensagem, PagamentoDTO.class);

        pagamentoService.adicionarPagamento(pagamentoDTO);
//        websocketService.atualizarPagamento(pagamentoDTO.getId());
    }
}

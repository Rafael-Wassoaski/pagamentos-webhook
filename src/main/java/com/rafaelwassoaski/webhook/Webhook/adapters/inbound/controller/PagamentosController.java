package com.rafaelwassoaski.webhook.Webhook.adapters.inbound.controller;


import com.rafaelwassoaski.webhook.Webhook.application.service.PagamentoService;
import com.rafaelwassoaski.webhook.Webhook.application.service.WebsocketService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentosController {

    @PostMapping("/{id}")
    public void realizarPagamento(@PathVariable String id) throws Exception {
        PagamentoService pagamentoService = new PagamentoService();
        WebsocketService websocketService = new WebsocketService();

        pagamentoService.realizarPagamento(id);
        websocketService.atualizarPagamento(id);
    }
}

package com.rafaelwassoaski.webhook.Webhook.application.service;

import com.rafaelwassoaski.webhook.Webhook.application.dto.PagamentoDTO;
import com.rafaelwassoaski.webhook.Webhook.application.port.in.PagamentoUseCase;
import com.rafaelwassoaski.webhook.Webhook.domain.service.PagamentoDomainService;
import org.springframework.stereotype.Service;

public class PagamentoService implements PagamentoUseCase {

    private PagamentoDomainService pagamentoDomainService;

    public PagamentoService() {
        this.pagamentoDomainService = PagamentoSingleton.getInstance();
    }

    @Override
    public void realizarPagamento(String id) throws Exception {
        pagamentoDomainService.pagar(id);
    }

    @Override
    public void adicionarPagamento(PagamentoDTO pagamentoDTO) throws Exception {
        pagamentoDomainService.adicionarPagamento(pagamentoDTO.getId(), pagamentoDTO.getCliente());
    }
}

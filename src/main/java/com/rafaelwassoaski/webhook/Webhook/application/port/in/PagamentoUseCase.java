package com.rafaelwassoaski.webhook.Webhook.application.port.in;

import com.rafaelwassoaski.webhook.Webhook.application.dto.PagamentoDTO;

public interface PagamentoUseCase {

    void realizarPagamento(String id) throws Exception;
    void adicionarPagamento(PagamentoDTO pagamentoDTO) throws Exception;

}

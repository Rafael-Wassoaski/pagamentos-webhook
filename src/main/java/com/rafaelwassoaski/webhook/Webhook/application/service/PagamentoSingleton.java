package com.rafaelwassoaski.webhook.Webhook.application.service;

import com.rafaelwassoaski.webhook.Webhook.domain.model.Pagamento;
import com.rafaelwassoaski.webhook.Webhook.domain.service.PagamentoDomainService;

public class PagamentoSingleton {

    private static PagamentoDomainService INSTANCE;

    public static PagamentoDomainService getInstance(){
        if(INSTANCE == null){
            PagamentoSingleton.INSTANCE = new PagamentoDomainService();
        }

        return PagamentoSingleton.INSTANCE;
    }
}

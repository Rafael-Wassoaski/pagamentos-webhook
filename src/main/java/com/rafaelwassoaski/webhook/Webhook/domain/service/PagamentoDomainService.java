package com.rafaelwassoaski.webhook.Webhook.domain.service;

import com.rafaelwassoaski.webhook.Webhook.domain.model.Pagamento;

import java.util.HashMap;
import java.util.Map;

public class PagamentoDomainService {

    private Map<String, Pagamento> pagamentos;

    public PagamentoDomainService() {
        this.pagamentos = new HashMap<>();
    }

    public void pagar(String id) throws Exception {
        if(!pagamentos.containsKey(id)){
            throw new Exception("Cobrança não encontrada");
        }

        Pagamento pagamento = pagamentos.get(id);

        if(pagamento.getPago()){
            throw new Exception("Cobrança já efetuada");
        }

        pagamento.pagar();
    }

    public void adicionarPagamento(String id, String cliente) throws Exception {
        if(pagamentos.containsKey(id)){
            throw new Exception("Cobrança já existe");
        }

        Pagamento pagamento = new Pagamento(id, cliente);
        this.pagamentos.put(id, pagamento);
    }
}

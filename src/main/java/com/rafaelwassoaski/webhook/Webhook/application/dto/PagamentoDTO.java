package com.rafaelwassoaski.webhook.Webhook.application.dto;

public class PagamentoDTO {

    private String id;
    private String cliente;

    public PagamentoDTO(String id, String cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public PagamentoDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}

package com.rafaelwassoaski.webhook.Webhook.domain.model;

public class Pagamento {
    private String id;
    private String cliente;
    private Boolean pago;

    public Pagamento(String id, String cliente) {
        this.id = id;
        this.cliente = cliente;
        this.pago = false;
    }

    public String getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public Boolean getPago() {
        return pago;
    }

    public void pagar(){
        this.pago = true;
    }
}

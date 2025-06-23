package org.example;



public abstract class ProcessadorPedido {
    protected ProcessadorPedido proximo;

    public ProcessadorPedido setProximo(ProcessadorPedido proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public abstract boolean processar(Pedido pedido);
}

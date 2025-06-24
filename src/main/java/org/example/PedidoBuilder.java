package org.example;

public class PedidoBuilder {

    private Pedido pedido;

    public PedidoBuilder(Pedido pedido) {
        this.pedido = pedido;
    }

    public PedidoBuilder setEndereco(String endereco) {
        pedido.setEndereco(endereco);
        return this;
    }

    public PedidoBuilder setObservacao(String observacao) {
        pedido.setObservacao(observacao);
        return this;
    }

    public PedidoBuilder setValor(double valor) {
        pedido.setValor(valor);
        return this;
    }

    public Pedido build() {
        if (pedido.getCliente() == null || pedido.getCliente().isEmpty()) {
            throw new IllegalArgumentException("Cliente obrigatório.");
        }
        return pedido;
    }
}

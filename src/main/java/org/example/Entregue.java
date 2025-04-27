package org.example;

public class Entregue implements EstadoPedido {
    @Override
    public String getNomeEstado() {
        return "Entregue";
    }

    @Override
    public EstadoPedido proximoEstado() {
        return this; // Fica no último estado
    }
}

package org.example;

public class Enviado implements EstadoPedido {
    @Override
    public String getNomeEstado() {
        return "Enviado";
    }

    @Override
    public EstadoPedido proximoEstado() {
        return new Entregue();
    }
}

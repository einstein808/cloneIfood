package org.example;

public class EmPreparo implements EstadoPedido {
    @Override
    public String getNomeEstado() {
        return "Em Preparo";
    }

    @Override
    public EstadoPedido proximoEstado() {
        return new Enviado();
    }
}

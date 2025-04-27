package org.example;

import java.util.Observable;

public class Pedido extends Observable {

    private String cliente;
    private EstadoPedido estado;

    public Pedido(String cliente) {
        this.cliente = cliente;
        this.estado = new EmPreparo(); // Começa em "Em Preparo"
    }

    public void avancarEstado() {
        this.estado = this.estado.proximoEstado();
        setChanged();
        notifyObservers();
    }

    public String getEstado() {
        return this.estado.getNomeEstado();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente='" + cliente + '\'' +
                ", estado='" + estado.getNomeEstado() + '\'' +
                '}';
    }
}
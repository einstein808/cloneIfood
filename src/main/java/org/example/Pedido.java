package org.example;

import java.util.Observable;

public class Pedido extends Observable {

    private EstadoPedido estado;
    private String cliente;

    public Pedido(String cliente) {
        this.cliente = cliente;
        this.estado = PedidoEstadoEmPreparacao.getInstance(); // Estado inicial
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        setChanged(); // Marca como alterado para notificar os observadores
        notifyObservers(); // Notifica todos os observadores
    }

    public void preparar() {
        if (estado.preparar(this)) {
            setEstado(PedidoEstadoEmPreparacao.getInstance());
        }
    }

    public void entregar() {
        if (estado.entregar(this)) {
            setEstado(PedidoEstadoEmEntrega.getInstance());
        }
    }

    public void cancelar() {
        if (estado.cancelar(this)) {
            setEstado(PedidoEstadoCancelado.getInstance());
        }
    }
    public void concluir() {
        if (estado.concluir(this)) {
            setEstado(PedidoEstadoEntregue.getInstance());
        }
    }

    @Override
    public String toString() {
        return "Pedido do cliente " + cliente + " - " + estado.getEstado();
    }
}

package org.example;

import java.util.Observable;
import org.example.ProcessadorPedido;
import org.example.ValidadorEstoque;
import org.example.ValidadorPagamento;

public class Pedido extends Observable {

    private EstadoPedido estado;
    private String cliente;

    private ProcessadorPedido cadeiaValidacao;

    public Pedido(String cliente) {
        this.cliente = cliente;
        this.estado = PedidoEstadoEmPreparacao.getInstance();

        ProcessadorPedido validadorPagamento = new ValidadorPagamento();
        ProcessadorPedido validadorEstoque = new ValidadorEstoque();
        validadorPagamento.setProximo(validadorEstoque);
        this.cadeiaValidacao = validadorPagamento;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        setChanged();
        notifyObservers();
    }

    public boolean preparar() {
        if (cadeiaValidacao.processar(this)) {
            return estado.preparar(this);
        } else {
            cancelar();
            return false;
        }
    }

    public boolean entregar() {
        return estado.entregar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public boolean concluir() {
        return estado.concluir(this);
    }

    @Override
    public String toString() {
        return "Pedido do cliente " + cliente + " - " + (estado != null ? estado.getEstado() : "Estado desconhecido");
    }

}

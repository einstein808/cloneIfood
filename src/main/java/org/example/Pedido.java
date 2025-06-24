package org.example;

import java.util.Observable;

public class Pedido extends Observable {

    private EstadoPedido estado;
    private String cliente;
    private String endereco;
    private String observacao;
    private double valor;

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

    public String getCliente() {
        return cliente;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pedido do cliente " + cliente + " - " + (estado != null ? estado.getEstado() : "Estado desconhecido");
    }
}

package org.example;
public abstract class EstadoPedido {

    public abstract String getEstado();

    public boolean preparar(Pedido pedido) {
        return false;
    }

    public boolean entregar(Pedido pedido) {
        return false;
    }

    public boolean cancelar(Pedido pedido) {
        return false;
    }

    public boolean concluir(Pedido pedido) {
        return false;
    }
}

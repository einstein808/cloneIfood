package org.example;

public class PedidoEstadoEmPreparacao extends EstadoPedido {

    private static PedidoEstadoEmPreparacao instance = new PedidoEstadoEmPreparacao();

    private PedidoEstadoEmPreparacao() {}

    public static PedidoEstadoEmPreparacao getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Preparação";
    }
    @Override
    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmEntrega.getInstance());
        return false;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
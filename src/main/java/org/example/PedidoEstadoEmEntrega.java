package org.example;
public class PedidoEstadoEmEntrega extends EstadoPedido {

    private static PedidoEstadoEmEntrega instance = new PedidoEstadoEmEntrega();

    private PedidoEstadoEmEntrega() {}

    public static PedidoEstadoEmEntrega getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Entrega";
    }


    @Override
    public boolean concluir(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }

}
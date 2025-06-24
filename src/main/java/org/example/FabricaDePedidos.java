package org.example;

public class FabricaDePedidos {

    private static FabricaDePedidos instancia;

    private FabricaDePedidos() {
    }

    public static FabricaDePedidos getInstancia() {
        if (instancia == null) {
            instancia = new FabricaDePedidos();
        }
        return instancia;
    }

    public PedidoBuilder criarPedido(String cliente) {
        Pedido pedido = new Pedido(cliente);
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        return new PedidoBuilder(pedido);
    }
}

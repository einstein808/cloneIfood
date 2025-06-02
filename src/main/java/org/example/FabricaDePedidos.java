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

    public Pedido criarPedido(String cliente) {
        Pedido pedido = new Pedido(cliente); // Cria um pedido com o cliente
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance()); // Define o estado inicial como "Em Preparação"
        return pedido;
    }
}

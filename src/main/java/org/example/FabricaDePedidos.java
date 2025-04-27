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
        return new Pedido(cliente);
    }
}

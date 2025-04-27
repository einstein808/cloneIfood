package org.example;

public class Main {
    public static void main(String[] args) {
        FabricaDePedidos fabrica = FabricaDePedidos.getInstancia();
        Pedido pedido = fabrica.criarPedido("Gabriel");

        Cliente cliente = new Cliente("Gabriel");
        cliente.acompanharPedido(pedido);

        System.out.println("Estado inicial: " + pedido.getEstado());

        pedido.avancarEstado(); // Em Preparo -> Enviado
        pedido.avancarEstado(); // Enviado -> Entregue
    }
}

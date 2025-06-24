package org.example;

public class Main {
    public static void main(String[] args) {

        Pedido pedido = FabricaDePedidos.getInstancia()
                .criarPedido("Gabryel")
                .setEndereco("Rua das Flores, 123")
                .setObservacao("Sem gelo")
                .setValor(250.00)
                .build();

        System.out.println(pedido);

        pedido.preparar();
        pedido.entregar();
        pedido.concluir();

        System.out.println(pedido);
    }
}

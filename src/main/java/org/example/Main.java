package org.example;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("Cliente");
        pedido.entregar();
        pedido.concluir();
        pedido.cancelar(); // Pedido já está em "Entregue" e não pode ser cancelado
    }
}


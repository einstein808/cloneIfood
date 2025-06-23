package org.example;

import org.example.Cliente;
import org.example.Pedido;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("Gabryel");
        Cliente cliente = new Cliente("Gabryel");
        cliente.acompanharPedido(pedido);

        pedido.preparar();  // Vai passar pela cadeia antes de preparar

        System.out.println(cliente.getUltimaNotificacao());
    }
}

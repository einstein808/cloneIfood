package org.example;

import org.example.Pedido;

public class ValidadorEstoque extends ProcessadorPedido {
    @Override
    public boolean processar(Pedido pedido) {
        boolean estoqueOk = true;

        if (!estoqueOk) {
            return false;
        }

        return proximo == null || proximo.processar(pedido);
    }
}
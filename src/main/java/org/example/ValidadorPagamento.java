package org.example;

import org.example.Pedido;
import org.example.ProcessadorPedido;

public class ValidadorPagamento extends ProcessadorPedido {
    @Override
    public boolean processar(Pedido pedido) {
        boolean pagamentoOk = true;
        if (!pagamentoOk) {
            return false;
        }

        return proximo == null || proximo.processar(pedido);
    }
}

import org.example.FabricaDePedidos;
import org.example.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestePedidoComChain {

    @Test
    public void pedidoDeveSerPreparadoQuandoValidacoesPassam() {
        Pedido pedido = FabricaDePedidos.getInstancia()
                .criarPedido("Cliente")
                .setEndereco("Rua Teste")
                .setValor(100.0)
                .build();

        boolean preparado = pedido.preparar();


        assertEquals("Em Preparação", pedido.toString().split(" - ")[1]);
    }


    @Test
    public void pedidoDeveSerEnviadoDePreparacao() {
        Pedido pedido = FabricaDePedidos.getInstancia()
                .criarPedido("Cliente")
                .build();

        pedido.preparar();
        pedido.entregar();

        assertEquals("Em Entrega", pedido.toString().split(" - ")[1]);
    }

    @Test
    public void pedidoDeveSerCanceladoDePreparacao() {
        Pedido pedido = FabricaDePedidos.getInstancia()
                .criarPedido("Cliente")
                .build();

        pedido.cancelar();

        assertEquals("Cancelado", pedido.toString().split(" - ")[1]);
    }

    @Test
    public void pedidoNaoPodeSerPreparadoNovamente() {
        Pedido pedido = FabricaDePedidos.getInstancia()
                .criarPedido("Cliente")
                .build();

        pedido.preparar();
        boolean segundaPreparacao = pedido.preparar();
        assertEquals("Em Preparação", pedido.toString().split(" - ")[1]);
    }

    @Test
    public void pedidoDeveSerConcluidoDeEnviado() {
        Pedido pedido = FabricaDePedidos.getInstancia()
                .criarPedido("Cliente")
                .build();

        pedido.preparar();
        pedido.entregar();
        pedido.concluir();

        assertEquals("Entregue", pedido.toString().split(" - ")[1]);
    }

    @Test
    public void pedidoNaoPodeSerCanceladoDeEntregue() {
        Pedido pedido = FabricaDePedidos.getInstancia()
                .criarPedido("Cliente")
                .build();

        pedido.preparar();
        pedido.entregar();
        pedido.concluir();
        pedido.cancelar();

        assertEquals("Entregue", pedido.toString().split(" - ")[1]);
    }


}

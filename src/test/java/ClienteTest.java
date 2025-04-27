
import org.example.Cliente;
import org.example.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveReceberAtualizacaoQuandoPedidoMudar() {
        Pedido pedido = new Pedido("Gabriel");
        Cliente cliente = new Cliente("Gabriel");
        cliente.acompanharPedido(pedido);

        pedido.avancarEstado(); // Atualiza para "Enviado"

        assertNotNull(cliente.getUltimaNotificacao());
        assertTrue(cliente.getUltimaNotificacao().contains("Enviado"));
    }

    @Test
    void naoDeveReceberAtualizacaoSeNaoEstiverAcompanhando() {
        Pedido pedido = new Pedido("Gabriel");
        Cliente cliente = new Cliente("Gabriel");

        pedido.avancarEstado(); // Cliente não está acompanhando ainda

        assertNull(cliente.getUltimaNotificacao());
    }
}

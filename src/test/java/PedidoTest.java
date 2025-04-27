import org.example.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {
    @Test
    void deveComecarEmPreparo() {
        Pedido pedido = new Pedido("Gabriel");

        assertEquals("Em Preparo", pedido.getEstado());
    }

    @Test
    void deveAvancarParaEnviado() {
        Pedido pedido = new Pedido("Gabriel");
        pedido.avancarEstado();

        assertEquals("Enviado", pedido.getEstado());
    }

    @Test
    void deveAvancarParaEntregue() {
        Pedido pedido = new Pedido("Gabriel");
        pedido.avancarEstado(); // Em Preparo -> Enviado
        pedido.avancarEstado(); // Enviado -> Entregue

        assertEquals("Entregue", pedido.getEstado());
    }

    @Test
    void devePermanecerEmEntregue() {
        Pedido pedido = new Pedido("Gabriel");
        pedido.avancarEstado(); // Em Preparo -> Enviado
        pedido.avancarEstado(); // Enviado -> Entregue
        pedido.avancarEstado(); // Entregue -> Entregue (permanece)

        assertEquals("Entregue", pedido.getEstado());
    }
}

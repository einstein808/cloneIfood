
import org.example.FabricaDePedidos;
import org.example.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaDePedidosTest {

    @Test
    void deveCriarPedidoComCliente() {
        FabricaDePedidos fabrica = FabricaDePedidos.getInstancia();
        Pedido pedido = fabrica.criarPedido("Gabriel");

        assertNotNull(pedido);
        assertEquals("Gabriel", pedido.toString().contains("Gabriel") ? "Gabriel" : null);
    }

    @Test
    void deveSerSingleton() {
        FabricaDePedidos instancia1 = FabricaDePedidos.getInstancia();
        FabricaDePedidos instancia2 = FabricaDePedidos.getInstancia();

        assertSame(instancia1, instancia2);
    }
}
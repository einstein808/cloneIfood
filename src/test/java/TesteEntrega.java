import org.example.Pedido;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TesteEntrega {
    @Test
    public void pedidoDeveSerEnviadoDePreparacao() {
        Pedido pedido = new Pedido("Cliente");
        pedido.entregar(); // Pedido passa para o estado "Em Entrega"

        assertEquals("Em Entrega", pedido.toString().split(" - ")[1]);
    }

    @Test
    public void pedidoDeveSerCanceladoDePreparacao() {
        Pedido pedido = new Pedido("Cliente");
        pedido.cancelar(); // Pedido passa para o estado "Cancelado"

        assertEquals("Cancelado", pedido.toString().split(" - ")[1]);
    }

    @Test
    public void pedidoNaoPodeSerPreparadoNovamente() {
        Pedido pedido = new Pedido("Cliente");
        pedido.preparar();
        pedido.preparar();

        assertEquals("Em Preparação", pedido.toString().split(" - ")[1]);
    }

    @Test
    public void pedidoDeveSerConcluidoDeEnviado() {
        Pedido pedido = new Pedido("Cliente");
        pedido.entregar();
        pedido.concluir(); // Pedido passa para o estado "Entregue"

        assertEquals("Entregue", pedido.toString().split(" - ")[1]);
    }

    @Test
    public void pedidoNaoPodeSerCanceladoDeEntregue() {
        Pedido pedido = new Pedido("Cliente");
        pedido.entregar();
        pedido.concluir();
        pedido.cancelar(); // Pedido já está em "Entregue" e não pode ser cancelado

        assertEquals("Entregue", pedido.toString().split(" - ")[1]);
    }}

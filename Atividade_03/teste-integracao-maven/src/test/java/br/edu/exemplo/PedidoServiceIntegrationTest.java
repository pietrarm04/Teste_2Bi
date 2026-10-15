package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceIntegrationTest {

 private final ProdutoEntity caneta = new ProdutoEntity(1, "Caneta", 10);
 private final ProdutoEntity caderno = new ProdutoEntity(2, "Caderno", 2);

 private EstoqueService criarEstoque() {
  return new EstoqueService(new ProdutoEntity[] { caneta, caderno });
 }

 @Test
 void deveRealizarPedidoComVariosItensERetirarDoEstoque() {
  EstoqueService estoque = criarEstoque();
  PedidoService service = new PedidoService(estoque);

  boolean realizado = service.realizarPedido(List.of(
          new PedidoEntity(caneta, 3),
          new PedidoEntity(caderno, 1)
  ));

  assertTrue(realizado);
  assertEquals(7, estoque.getQuantidade(1));
  assertEquals(1, estoque.getQuantidade(2));
 }

 @Test
 void naoDeveRetirarNadaSeUmItemNaoTiverEstoque() {
  EstoqueService estoque = criarEstoque();
  PedidoService service = new PedidoService(estoque);

  boolean realizado = service.realizarPedido(List.of(
          new PedidoEntity(caneta, 3),
          new PedidoEntity(caderno, 5)
  ));

  assertFalse(realizado);
  assertEquals(10, estoque.getQuantidade(1));
  assertEquals(2, estoque.getQuantidade(2));
 }

 @Test
 void naoDeveRealizarPedidoDeProdutoInexistente() {
  EstoqueService estoque = criarEstoque();
  PedidoService service = new PedidoService(estoque);
  ProdutoEntity inexistente = new ProdutoEntity(99, "Borracha", 0);

  assertFalse(service.realizarPedido(List.of(new PedidoEntity(inexistente, 1))));
  assertEquals(0, estoque.getQuantidade(99));
 }

 @Test
 void deveZerarEstoqueQuandoPedidoIgualAoSaldo() {
  EstoqueService estoque = new EstoqueService(new ProdutoEntity[] {
          new ProdutoEntity(1, "Caneta", 3)
  });
  PedidoService service = new PedidoService(estoque);

  assertTrue(service.realizarPedido(List.of(
          new PedidoEntity(new ProdutoEntity(1, "Caneta", 3), 3)
  )));
  assertEquals(0, estoque.getQuantidade(1));
 }

 @Test
 void pedidoDeveEstarRelacionadoAoProduto() {
  PedidoEntity pedido = new PedidoEntity(caneta, 2);

  assertEquals("Caneta", pedido.getProduto().getNome());
  assertEquals(1, pedido.getProduto().getId());
  assertEquals(2, pedido.getQuantidade());
 }
}
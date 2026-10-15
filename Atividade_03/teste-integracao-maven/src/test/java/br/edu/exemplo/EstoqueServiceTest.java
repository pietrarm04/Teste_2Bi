package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstoqueServiceTest {

 private EstoqueService criarEstoque() {
  return new EstoqueService(new ProdutoEntity[] {
          new ProdutoEntity(1, "Caneta", 10),
          new ProdutoEntity(2, "Caderno", 2)
  });
 }

 @Test
 void deveInformarQuandoExisteEstoque() {
  assertTrue(criarEstoque().temEstoque(1, 3));
 }

 @Test
 void deveRetirarQuantidadeDoProduto() {
  EstoqueService estoque = criarEstoque();
  estoque.retirar(1, 3);
  assertEquals(7, estoque.getQuantidade(1));
  assertEquals(2, estoque.getQuantidade(2)); // o outro produto não muda
 }

 @Test
 void naoDeveTerEstoqueDeProdutoInexistente() {
  assertFalse(criarEstoque().temEstoque(99, 1));
 }
}
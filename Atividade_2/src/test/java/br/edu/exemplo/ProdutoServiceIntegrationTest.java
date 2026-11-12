package br.edu.exemplo;
import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
import br.edu.exemplo.model.Produto;

@SpringBootTest @Transactional
class ProdutoServiceIntegrationTest {

 @Autowired ProdutoService service;
 @Autowired ProdutoRepository repository;

 @Test void deveCadastrarERecuperarProduto(){
  Produto salvo = service.cadastrar("Teclado", 150.0);
  assertNotNull(salvo.getId());

  Produto encontrado = repository.findById(salvo.getId()).orElseThrow();

  assertEquals("Teclado", encontrado.getNome());
  assertEquals(150.0, encontrado.getPreco());
 }

 @Test void naoDevePersistirProdutoComNomeEmBranco(){
  long quantidadeAntes = repository.count();

  assertThrows(IllegalArgumentException.class,
          () -> service.cadastrar("   ", 80.0));

  assertEquals(quantidadeAntes, repository.count());
 }

 @Test void deveAtualizarPrecoPersistido(){
  Produto salvo = service.cadastrar("Mouse", 80.0);

  assertNotNull(salvo.getId());

  service.atualizarPreco(salvo.getId(), 95.0);

  Produto atualizado = repository.findById(salvo.getId()).orElseThrow();

  assertEquals("Mouse", atualizado.getNome());
  assertEquals(95.0, atualizado.getPreco());
 }
}

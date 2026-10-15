package br.edu.exemplo;

public class EstoqueService {
 private ProdutoEntity[] listaProduto;

 public EstoqueService(ProdutoEntity[] listaProduto) {
  this.listaProduto = listaProduto;
 }

 private ProdutoEntity buscarProduto(int idProduto) {
  for (ProdutoEntity produto : listaProduto) {
   if (produto.getId() == idProduto) {
    return produto;
   }
  }
  return null;
 }

 public boolean temEstoque(int idProduto, int quantidadeSolicitada) {
  ProdutoEntity produto = buscarProduto(idProduto);
  return produto != null && produto.getQuantidade() >= quantidadeSolicitada;
 }

 public void retirar(int idProduto, int quantidade) {
  ProdutoEntity produto = buscarProduto(idProduto);
  produto.setQuantidade(produto.getQuantidade() - quantidade);
 }

 public int getQuantidade(int idProduto) {
  ProdutoEntity produto = buscarProduto(idProduto);
  return produto == null ? 0 : produto.getQuantidade();
 }
}
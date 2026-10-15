package br.edu.exemplo;

public class PedidoEntity {
    private ProdutoEntity produto;
    private int quantidade;

    public PedidoEntity(ProdutoEntity produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ProdutoEntity getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
}
package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTest {

    // REQUISITO 1 - Carrinho vazio
    @Test
    void valorCarrinhoZero() {
        Carrinho c = new Carrinho();

        assertEquals(0, c.getValor(), 0.001);
    }

    // REQUISITO 2 - Adicionar um produto
    @Test
    void adicionarUmProduto() {
        Carrinho c = new Carrinho();

        Produto p = new Produto("Teclado", 100);

        c.adicionarProduto(p);

        assertEquals(100, c.getValor(), 0.001);
    }

    // REQUISITO 3 - Adicionar varios produtos
    @Test
    void adicionarVariosProdutos() {
        Carrinho c = new Carrinho();

        Produto p1 = new Produto("Teclado", 100);
        Produto p2 = new Produto("Mouse", 50);

        c.adicionarProduto(p1);
        c.adicionarProduto(p2);

        assertEquals(150, c.getValor(), 0.001);
    }

    // REQUISITO 4 - Remover produto
    @Test
    void removerProduto() {
        Carrinho c = new Carrinho();

        Produto p1 = new Produto("Teclado", 100);
        Produto p2 = new Produto("Mouse", 50);

        c.adicionarProduto(p1);
        c.adicionarProduto(p2);

        c.removerProduto(p2);

        assertEquals(100, c.getValor(), 0.001);
    }

    // REQUISITO 5 - Preco negativo
    @Test
    void produtoComPrecoNegativo() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Teclado", -100);
        });
    }

    // REQUISITO 6
    @Test
    void carrinhoComDesconto() {
        Carrinho c = new Carrinho();

        c.adicionarProduto(new Produto("Monitor", 600));

        assertEquals(540, c.getValor(), 0.001);
    }

    @Test
    void carrinhoComValor499() {
        Carrinho c = new Carrinho();

        c.adicionarProduto(new Produto("Produto", 499.99));

        assertEquals(499.99, c.getValor(), 0.001);
    }

    @Test
    void carrinhoComValor500() {
        Carrinho c = new Carrinho();

        c.adicionarProduto(new Produto("Produto", 500));

        assertEquals(450, c.getValor(), 0.001);
    }

    @Test
    void carrinhoComValor500e01() {
        Carrinho c = new Carrinho();

        c.adicionarProduto(new Produto("Produto", 500.01));

        assertEquals(450.009, c.getValor(), 0.001);
    }
}
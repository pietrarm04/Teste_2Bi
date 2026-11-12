package br.edu.exemplo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public void removerProduto(Produto p) {
        produtos.remove(p);
    }

    public double getValor() {
        double total = 0;

        for (Produto p : produtos) {
            total += p.getPreco();
        }

        if (total >= 500) {
            total = total * 0.90;
        }

        return total;
    }
}
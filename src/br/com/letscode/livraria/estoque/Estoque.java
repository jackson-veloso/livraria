package br.com.letscode.livraria.estoque;

import br.com.letscode.livraria.produto.Produto;

import java.util.ArrayList;
import java.util.List;

public class Estoque <T extends Produto> {
    private List<T> produtos;
    private Integer quantidade;

    public Estoque(List<T> produtos) {
        produtos = new ArrayList<>();
        this.produtos = produtos;
        quantidade = produtos.size();
    }

    public List<T> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<T> produtos) {
        this.produtos = produtos;
    }

    public void addProduto(T produto) {
        this.produtos.add(produto);
        quantidade++;
    }

    public void delProduto(T produto) {
        this.produtos.remove(produto);
        quantidade--;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

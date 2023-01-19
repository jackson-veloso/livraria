package br.com.letscode.livraria.estoque;

import br.com.letscode.livraria.produto.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estoque<P extends Produto> {

    private Map<P, Integer> produtos = new HashMap<>();

    public void adicionar(P produto, Integer quantidade) {
        if (produtos.containsKey(produto)) {
            Integer total = produtos.get(produto);
            produtos.put(produto, total + quantidade);
        } else {
            produtos.put(produto, quantidade);
        }
    }

    public void remover(P produto, Integer quantidade) {
        if (produtos.containsKey(produto)) {
            int total = produtos.get(produto);
            produtos.put(produto, total - quantidade);
        }
    }

    public void excluirProduto(P produto) {
        if (produtos.containsKey(produto)) {
            produtos.remove(produto);
        }
    }

    public Map<P, Integer> getAll() {
        return produtos;
    }

    public Integer getQuantidade(P produto) {
        if (produtos.containsKey(produto)) {
            return produtos.get(produto);
        }
        return null;
    }

    public int getAllQuantidade() {
        int total = 0;
        for (int qtd : produtos.values()) {
            total += qtd;
        }
        return total;
    }

}

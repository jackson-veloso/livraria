package br.com.letscode.livraria.carrinho;

import br.com.letscode.livraria.caixa.Caixa;
import br.com.letscode.livraria.estoque.Estoque;
import br.com.letscode.livraria.produto.Produto;

import java.util.HashMap;
import java.util.Map;

public class Carrinho {

    private Map<Produto, Integer> carrinho = new HashMap<>();

    public void adicionar(Produto produto, Integer quantidade, Estoque estoque) {
        if (quantidade <= estoque.getQuantidade(produto)) {
            this.addProduto(produto, quantidade);
            estoque.remover(produto, quantidade);
        }
    }

    public void remover(Produto produto, Integer quantidade, Estoque estoque) {
        if (carrinho.containsKey(produto) && this.removeProduto(produto, quantidade)) {
            estoque.adicionar(produto, quantidade);
        }
    }
    private void addProduto(Produto produto, Integer quantidade) {
        if (carrinho.containsKey(produto)) {
            int qtd = carrinho.get(produto);
            carrinho.put(produto, qtd + quantidade);
        } else {
            carrinho.put(produto, quantidade);
        }
    }
    private boolean removeProduto(Produto produto, Integer quantidade) {
        int qtd = carrinho.get(produto);
        if (quantidade == qtd) {
            carrinho.remove(produto);
            return true;
        } else if (quantidade < qtd) {
            carrinho.put(produto, qtd - quantidade);
            return true;
        }
        return false;
    }

    public Map<Produto, Integer> getAll(){
        return this.carrinho;
    }

    public Double valorTotalCarrinho() {
        Double total = 0D;
        for (Produto produto : carrinho.keySet()) {
            int qtd = carrinho.get(produto);
            total += produto.getPreco() * qtd;
        }
        return total;
    }

    public void realizarCompra(Caixa caixa) {
        caixa.deposito(this.valorTotalCarrinho());
        this.carrinho = new HashMap<>();
    }
}

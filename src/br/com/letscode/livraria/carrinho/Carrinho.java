package br.com.letscode.livraria.carrinho;

import br.com.letscode.livraria.caixa.Caixa;
import br.com.letscode.livraria.categoria.Categoria;
import br.com.letscode.livraria.estoque.Estoque;
import br.com.letscode.livraria.pessoa.Pessoa;
import br.com.letscode.livraria.produto.Produto;
import br.com.letscode.livraria.utilitaria.Utilitaria;

import java.util.HashMap;
import java.util.Map;

public class Carrinho {

    private Map<Produto, Integer> carrinho;
    private Double valorTotal;
    private Double valorEmLivros;
    private Double valorDesconto;

    public Carrinho() {
        carrinho = new HashMap<>();
        valorTotal = 0D;
        valorEmLivros = 0D;
        valorDesconto = 0D;
    }

    public void adicionar(Produto produto, Integer quantidade, Estoque estoque, Categoria categoria) {
        if (quantidade <= estoque.getQuantidade(produto)) {
            this.addProduto(produto, quantidade,categoria);
            estoque.remover(produto, quantidade);
        }
    }

    public void adicionar(Produto produto, Integer quantidade, Estoque estoque) {
        if (quantidade <= estoque.getQuantidade(produto)) {
            this.addProduto(produto, quantidade);
            estoque.remover(produto, quantidade);
        }
    }

    private void addProduto(Produto produto, Integer quantidade) {
        if (carrinho.containsKey(produto)) {
            int qtd = carrinho.get(produto);
            carrinho.put(produto, qtd + quantidade);
        } else {
            carrinho.put(produto, quantidade);
        }
        valorTotal += produto.getPreco() * quantidade;
    }

    private void addProduto(Produto produto, Integer quantidade, Categoria categoria) {
        addProduto(produto, quantidade);
        if (categoria == Categoria.LIVRO) {
            valorEmLivros += produto.getPreco() * quantidade;
            aplicarDescontoEmLivros();
        }
    }

    public void remover(Produto produto, Integer quantidade, Estoque estoque,Categoria categoria) {
        if (carrinho.containsKey(produto) && this.removeProduto(produto, quantidade,categoria)) {
            estoque.adicionar(produto, quantidade);
        }
    }
    public void remover(Produto produto, Integer quantidade, Estoque estoque) {
        if (carrinho.containsKey(produto) && this.removeProduto(produto, quantidade)) {
            estoque.adicionar(produto, quantidade);
        }
    }
    private boolean removeProduto(Produto produto, Integer quantidade) {
        int qtd = carrinho.get(produto);
        if (quantidade == qtd) {
            carrinho.remove(produto);
            valorTotal -= produto.getPreco() * quantidade;
            return true;
        } else if (quantidade < qtd) {
            carrinho.put(produto, qtd - quantidade);
            valorTotal -= produto.getPreco() * quantidade;
            return true;
        }
        return false;
    }

    private boolean removeProduto(Produto produto, Integer quantidade, Categoria categoria) {
        if (removeProduto(produto, quantidade)) {
            if (categoria == Categoria.LIVRO) {
                valorEmLivros -= produto.getPreco() * quantidade;
                aplicarDescontoEmLivros();
            }
            return true;
        }
        return false;
    }

    public Map<Produto, Integer> getAll() {
        return this.carrinho;
    }

    public Double valorTotalCarrinho() {
        return valorTotal - getValorDesconto();
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void aplicarDescontoEmLivros(){
        if(valorEmLivros > 200){
            setValorDesconto(0.15,valorEmLivros);
        } else {
            valorDesconto = 0D;
        }
    }
    public Double getValorEmLivros() {
        return valorEmLivros;
    }

    private void setValorDesconto(Double desconto, Double valorCompra) {
        this.valorDesconto = valorCompra * desconto;
    }

    public boolean finalizarCompra(Caixa caixa) {
        if (!carrinho.isEmpty()) {
            caixa.deposito(this.valorTotalCarrinho());
            this.carrinho = new HashMap<>();
            return true;
        }
        return false;
    }

    public boolean finalizarCompra(Caixa caixa, Pessoa comprador) {
        for (Produto produto : carrinho.keySet()) {
            if (produto.isProdutoAdulto() && !validaClienteMaior(comprador)) {
                return false;
            }
        }
        return finalizarCompra(caixa);
    }

    private boolean validaClienteMaior(Pessoa comprador) {
        return Utilitaria.isMaiorIdade(comprador.getDataNascimento());
    }
}

package br.com.letscode.livraria.caixa;

import br.com.letscode.livraria.estoque.Estoque;
import br.com.letscode.livraria.produto.Produto;

public class Caixa {
    private Double saldo;

    public Caixa(Double saldo) {
        this.saldo = saldo;
    }

     public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void deposito(Double valor){
        this.saldo += valor;
    }
    public void saque(Double valor){
        this.saldo = this.saldo - valor;
    }

}

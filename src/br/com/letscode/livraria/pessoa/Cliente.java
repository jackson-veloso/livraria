package br.com.letscode.livraria.pessoa;

import java.util.Date;

public class Cliente extends Pessoa {
    public Cliente(String nome, String rg, String cpf, Date dataNascimento) {
        super(nome, rg, cpf, dataNascimento);
    }
}

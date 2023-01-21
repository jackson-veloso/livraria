package br.com.letscode.livraria.produto;

import java.util.Objects;

public class Produto {
    private String nome;
    private Integer id;
    private Double preco;
    private String genero;
    private Boolean produtoAdulto;

    public Produto(String nome, Integer id, Double preco, String genero) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.genero = genero;
        this.produtoAdulto = false;
    }

    public Produto(String nome, Integer id, Double preco, String genero, Boolean produtoAdulto) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.genero = genero;
        this.produtoAdulto = produtoAdulto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean isProdutoAdulto() {

        return produtoAdulto;
    }

    public void setProdutoAdulto(Boolean produtoAdulto) {
        this.produtoAdulto = produtoAdulto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", preco=" + preco +
                ", genero='" + genero + '\'' +
                ", produtoAdulto=" + produtoAdulto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) && Objects.equals(id, produto.id) && Objects.equals(preco, produto.preco) && Objects.equals(genero, produto.genero) && Objects.equals(produtoAdulto, produto.produtoAdulto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, id, preco, genero, produtoAdulto);
    }
}

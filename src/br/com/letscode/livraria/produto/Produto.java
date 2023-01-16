package br.com.letscode.livraria.produto;

public class Produto {
    private String nome;
    private Integer id;
    private Double preco;
    private String genero;

    public Produto(String nome, Integer id, Double preco, String genero) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.genero = genero;
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
}

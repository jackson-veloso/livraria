package br.com.letscode.livraria.produto;

public class Livro extends Produto {
    private String escritor;
    private String editora;

    public Livro(String nome, Integer id, Double preco, String genero, String escritor, String editora) {
        super(nome, id, preco, genero);
        this.escritor = escritor;
        this.editora = editora;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}

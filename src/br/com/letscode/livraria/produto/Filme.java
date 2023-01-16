package br.com.letscode.livraria.produto;

public class Filme extends Produto {
    private String estudio;
    private String diretor;
    private String produtor;

    public Filme(String nome, Integer id, Double preco, String genero, String estudio, String diretor, String produtor) {
        super(nome, id, preco, genero);
        this.estudio = estudio;
        this.diretor = diretor;
        this.produtor = produtor;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }
}

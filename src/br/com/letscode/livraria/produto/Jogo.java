package br.com.letscode.livraria.produto;

public class Jogo extends Produto {
    private String distribuidora;
    private String estudio;

    public Jogo(String nome, Integer id, Double preco, String genero, String distribuidora, String estudio) {
        super(nome, id, preco, genero);
        this.distribuidora = distribuidora;
        this.estudio = estudio;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "distribuidora='" + distribuidora + '\'' +
                ", estudio='" + estudio + '\'' +
                "} " + super.toString();
    }
}

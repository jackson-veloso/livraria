package br.com.letscode.livraria.produto;

public class Brinquedo extends Produto {
    private String tipo;

    public Brinquedo(String nome, Integer id, Double preco, String tipo) {
        super(nome, id, preco, "");
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Brinquedo{" +
                "tipo='" + tipo + '\'' +
                "} " + super.toString();
    }
}

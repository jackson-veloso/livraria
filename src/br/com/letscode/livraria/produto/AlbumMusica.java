package br.com.letscode.livraria.produto;

public class AlbumMusica extends Produto {
    private String musicoBanda;
    private String selo;

    public AlbumMusica(String nome, Integer id, Double preco, String genero, String musicoBanda, String selo) {
        super(nome, id, preco, genero);
        this.musicoBanda = musicoBanda;
        this.selo = selo;
    }

    public String getMusicoBanda() {
        return musicoBanda;
    }

    public void setMusicoBanda(String musicoBanda) {
        this.musicoBanda = musicoBanda;
    }

    public String getSelo() {
        return selo;
    }

    public void setSelo(String selo) {
        this.selo = selo;
    }

    @Override
    public String toString() {
        return "AlbumMusica{" +
                "musicoBanda='" + musicoBanda + '\'' +
                ", selo='" + selo + '\'' +
                "} " + super.toString();
    }
}

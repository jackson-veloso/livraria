package br.com.letscode.livraria;

import br.com.letscode.livraria.produto.*;

public class Sistema {
    public static void main(String[] args) {

        AlbumMusica albumMusica1 = new AlbumMusica("Primeiros Erros",1,50.0,"Pop Rock","Capital Inicial","Platina");
        AlbumMusica albumMusica2 = new AlbumMusica("Decretos Reais",2,55.0,"Sertanejo","Marília Mendonça","Ouro");
        AlbumMusica albumMusica3 = new AlbumMusica("Amigos II",3,60.0,"Pagode","Raça Negra","Bronze");

        Brinquedo brinquedo1 = new Brinquedo("Barbie",1,50.0,"boneca");
        Brinquedo brinquedo2 = new Brinquedo("Super Robots",2,55.0,"carro");
        Brinquedo brinquedo3 = new Brinquedo("Motocicleta",3,60.0,"lego");

        Filme filme1 = new Filme("O Senhor dos Anéis",1,50.0,"Aventura","New Line Cinema","Peter Jackson","Peter Jackson");
        Filme filme2 = new Filme("Resident Evil",2,55.0,"Terror","Screen Gems","Johannes Roberts","Capcom Co.");
        Filme filme3 = new Filme("Avatar",3,60.0,"Aventura","20th Century Fox","James Cameron","James Cameron");

        Jogo jogo1 = new Jogo("The Witcher",1,50.0,"RPG","CD Project","CD Project Red");
        Jogo jogo2 = new Jogo("Call of Dury",2,55.0,"Tiro","Activision","Activision");
        Jogo jogo3 = new Jogo("F1",3,60.0,"Corrida","EA Sports","Codemasters");

        Livro livro1 = new Livro("Código Limpo",1,50.0,"técnico","Robert C.","Alta Books");
        Livro livro2 = new Livro("Crônicas do Gelo e Fogo",3,55.0,"Ficção","George R. R. Martin","Suma");
        Livro livro3 = new Livro("O Inocente",3,60.0,"Suspense","Harlan Coben","Arqueiro");
    }
}
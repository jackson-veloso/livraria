package br.com.letscode.livraria;

import br.com.letscode.livraria.caixa.Caixa;
import br.com.letscode.livraria.categoria.Categoria;
import br.com.letscode.livraria.estoque.Estoque;
import br.com.letscode.livraria.produto.*;
import br.com.letscode.livraria.carrinho.Carrinho;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        AlbumMusica albumMusica1 = new AlbumMusica("Primeiros Erros", 1, 50.0, "Pop Rock", "Capital Inicial", "Platina");
        AlbumMusica albumMusica2 = new AlbumMusica("Decretos Reais", 2, 55.0, "Sertanejo", "Marília Mendonça", "Ouro");
        AlbumMusica albumMusica3 = new AlbumMusica("Amigos II", 3, 60.0, "Pagode", "Raça Negra", "Bronze");
        Estoque<AlbumMusica> albumMusicas = new Estoque<>();
        albumMusicas.adicionar(albumMusica1, 10);
        albumMusicas.adicionar(albumMusica2, 6);
        albumMusicas.adicionar(albumMusica3, 4);

        Brinquedo brinquedo1 = new Brinquedo("Barbie", 1, 50.0, "boneca");
        Brinquedo brinquedo2 = new Brinquedo("Super Robots", 2, 55.0, "carro");
        Brinquedo brinquedo3 = new Brinquedo("Motocicleta", 3, 60.0, "lego");
        Estoque<Brinquedo> brinquedos = new Estoque<>();
        brinquedos.adicionar(brinquedo1, 10);
        brinquedos.adicionar(brinquedo2, 10);
        brinquedos.adicionar(brinquedo3, 10);

        Filme filme1 = new Filme("O Senhor dos Anéis", 1, 50.0, "Aventura", "New Line Cinema", "Peter Jackson", "Peter Jackson");
        Filme filme2 = new Filme("Resident Evil", 2, 55.0, "Terror", "Screen Gems", "Johannes Roberts", "Capcom Co.");
        Filme filme3 = new Filme("Avatar", 3, 60.0, "Aventura", "20th Century Fox", "James Cameron", "James Cameron");
        Estoque<Filme> filmes = new Estoque<>();
        filmes.adicionar(filme1, 5);
        filmes.adicionar(filme2, 5);
        filmes.adicionar(filme3, 5);

        Jogo jogo1 = new Jogo("The Witcher", 1, 50.0, "RPG", "CD Project", "CD Project Red");
        Jogo jogo2 = new Jogo("Call of Dury", 2, 55.0, "Tiro", "Activision", "Activision");
        Jogo jogo3 = new Jogo("F1", 3, 60.0, "Corrida", "EA Sports", "Codemasters");
        Estoque<Jogo> jogos = new Estoque<>();
        jogos.adicionar(jogo1, 8);
        jogos.adicionar(jogo2, 8);
        jogos.adicionar(jogo3, 8);

        Livro livro1 = new Livro("Código Limpo", 1, 50.0, "técnico", "Robert C.", "Alta Books");
        Livro livro2 = new Livro("Crônicas do Gelo e Fogo", 2, 55.0, "Ficção", "George R. R. Martin", "Suma");
        Livro livro3 = new Livro("O Inocente", 3, 60.0, "Suspense", "Harlan Coben", "Arqueiro");
        Estoque<Livro> livros = new Estoque<>();
        livros.adicionar(livro1, 10);
        livros.adicionar(livro2, 10);
        livros.adicionar(livro3, 10);

        //#######
        Map<Categoria, Estoque<? extends Produto>> estoques = new HashMap<>();
        estoques.put(Categoria.ALBUM_MUSICA, albumMusicas);
        estoques.put(Categoria.BRINQUEDO, brinquedos);
        estoques.put(Categoria.FILME, filmes);
        estoques.put(Categoria.JOGO, jogos);
        estoques.put(Categoria.LIVRO, livros);

        System.out.println("== Listar todos os produtos da loja");
        for (Estoque depo : estoques.values()) {
            System.out.println(depo.getAll());
        }

        System.out.println("\n== Listar produtos por categoria");
        Estoque estoque = estoques.get(Categoria.FILME);
        System.out.println(estoque.getAll());


        Caixa caixa = new Caixa(0D);
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(estoque.getProduto(1),2,estoque);
        estoque = estoques.get(Categoria.LIVRO);
        carrinho.adicionar(estoque.getProduto(2),1,estoque);

        System.out.println("\n== Itens Carrinho");
        int count  =0;
        for (Produto produto : carrinho.getAll().keySet()) {
            count++;
            int qtd = carrinho.getAll().get(produto);
            double total = produto.getPreco() * qtd;
            System.out.printf("\nItem %d = ",count);
            System.out.print(produto.getNome());
            System.out.printf(" -- Quantidade = %d, Total = %.2f",qtd,total);
        }
        System.out.printf("\nTotal carrinho %.2f",carrinho.valorTotalCarrinho());

        carrinho.realizarCompra(caixa);
        System.out.println("\n\n== Valor em caixa");
        System.out.println(caixa.getSaldo());

        System.out.println("\n== Listar todos os produtos da loja");
        for (Estoque depo : estoques.values()) {
            System.out.println(depo.getAll());
        }







    }
}
package br.com.letscode.livraria;

import br.com.letscode.livraria.caixa.Caixa;
import br.com.letscode.livraria.categoria.Categoria;
import br.com.letscode.livraria.estoque.Estoque;
import br.com.letscode.livraria.pessoa.Cliente;
import br.com.letscode.livraria.produto.*;
import br.com.letscode.livraria.carrinho.Carrinho;
import br.com.letscode.livraria.utilitaria.Utilitaria;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ParseException {
        //Produtos
        AlbumMusica albumMusica1 = new AlbumMusica("Primeiros Erros", 1, 50.0, "Pop Rock", "Capital Inicial", "Platina");
        AlbumMusica albumMusica2 = new AlbumMusica("Decretos Reais", 2, 55.0, "Sertanejo", "Marília Mendonça", "Ouro");

        Brinquedo brinquedo1 = new Brinquedo("Barbie", 1, 50.0, "boneca");
        Brinquedo brinquedo2 = new Brinquedo("Super Robots", 2, 55.0, "carro");
        Brinquedo brinquedo3 = new Brinquedo("Motocicleta", 3, 60.0, "lego");

        Filme filme1 = new Filme("O Senhor dos Anéis", 1, 50.0, "Aventura", "New Line Cinema", "Peter Jackson", "Peter Jackson");
        Filme filme2 = new Filme("Resident Evil", 2, 55.0, "Terror", "Screen Gems", "Johannes Roberts", "Capcom Co.");
        Filme filme3 = new Filme("Avatar", 3, 60.0, "Aventura", "20th Century Fox", "James Cameron", "James Cameron");

        Jogo jogo1 = new Jogo("The Witcher", 1, 50.0, "RPG", "CD Project", "CD Project Red");
        Jogo jogo2 = new Jogo("Call of Dury", 2, 55.0, "Tiro", "Activision", "Activision");
        Jogo jogo3 = new Jogo("F1", 3, 60.0, "Corrida", "EA Sports", "Codemasters");

        Livro livro1 = new Livro("Código Limpo", 1, 50.0, "técnico", "Robert C.", "Alta Books");
        Livro livro2 = new Livro("Crônicas do Gelo e Fogo", 2, 55.0, "Ficção", "George R. R. Martin", "Suma");
        Livro livro3 = new Livro("O Inocente", 3, 60.0, "Suspense", "Harlan Coben", "Arqueiro");

        //Estoques por produto
        Estoque<AlbumMusica> albumMusicas = new Estoque<>();
        Estoque<Brinquedo> brinquedos = new Estoque<>();
        Estoque<Filme> filmes = new Estoque<>();
        Estoque<Jogo> jogos = new Estoque<>();
        Estoque<Livro> livros = new Estoque<>();

        //Popular estoques
        albumMusicas.adicionar(albumMusica1, 10);
        albumMusicas.adicionar(albumMusica2, 6);

        brinquedos.adicionar(brinquedo1, 10);
        brinquedos.adicionar(brinquedo2, 10);
        brinquedos.adicionar(brinquedo3, 10);

        filmes.adicionar(filme1, 5);
        filmes.adicionar(filme2, 5);
        filmes.adicionar(filme3, 5);

        jogos.adicionar(jogo1, 8);
        jogos.adicionar(jogo2, 8);
        jogos.adicionar(jogo3, 8);

        livros.adicionar(livro1, 10);
        livros.adicionar(livro2, 10);
        livros.adicionar(livro3, 10);

        //Estoque central da loja
        Map<Categoria, Estoque<? extends Produto>> estoques = new HashMap<>();
        estoques.put(Categoria.ALBUM_MUSICA, albumMusicas);
        estoques.put(Categoria.BRINQUEDO, brinquedos);
        estoques.put(Categoria.FILME, filmes);
        estoques.put(Categoria.JOGO, jogos);
        estoques.put(Categoria.LIVRO, livros);

        //Caixa da loja
        Caixa caixa = new Caixa(0D);

        //Adicionar produto ao estoque
        Estoque estoqueTemp = estoques.get(Categoria.ALBUM_MUSICA);
        AlbumMusica albumMusica3 = new AlbumMusica("Amigos II", 3, 60.0, "Pagode", "Raça Negra", "Bronze");
        estoqueTemp.adicionar(albumMusica3, 4);

        //Alterar produto
        estoqueTemp = estoques.get(Categoria.BRINQUEDO);
        Produto produtoModificar = estoqueTemp.getProduto(1);
        produtoModificar.setPreco(45.0);

        //Remover produto
        estoqueTemp = estoques.get(Categoria.JOGO);
        Produto produtoRemover = estoqueTemp.getProduto(2);
        estoqueTemp.remover(produtoRemover, 5);

        //Listar produtos
        System.out.println("== Listar todos os produtos da loja");
        for (Estoque depo : estoques.values()) {
            System.out.println(depo.getAll());
        }

        System.out.println("\n== Listar produtos por categoria");
        estoqueTemp = estoques.get(Categoria.JOGO);
        System.out.println(estoqueTemp.getAll());

        //==Processo de Compra - V1
        Carrinho carrinhoCompraV1 = new Carrinho();

        estoqueTemp = estoques.get(Categoria.LIVRO);
        carrinhoCompraV1.adicionar(estoqueTemp.getProduto(1), 2, estoqueTemp);
        estoqueTemp = estoques.get(Categoria.ALBUM_MUSICA);
        carrinhoCompraV1.adicionar(estoqueTemp.getProduto(2), 1, estoqueTemp);

        //Ver carrinho
        displayCarrinho(carrinhoCompraV1);
        displayStatusCompra(caixa, carrinhoCompraV1.finalizarCompra(caixa));

        //Produtos removidos do estoque após a compra
        System.out.println("\n== Listar todos os produtos da loja");
        for (Estoque depo : estoques.values()) {
            System.out.println(depo.getAll());
        }

        //==Processo de Compra - V2-produto adulto
        //produto adulto
        Filme filmeAdulto = new Filme("Bruna Surfistinha", 4, 40.0, "erótico", true, "Imagem Filmes", "Marcus Baldini", "Marcus Baldini");
        estoqueTemp = estoques.get(Categoria.FILME);
        estoqueTemp.adicionar(filmeAdulto, 3);

        System.out.println("\n== Listar produtos por categoria");
        estoqueTemp = estoques.get(Categoria.FILME);
        System.out.println(estoqueTemp.getAll());

        //Compra ClienteMenor
        Cliente clienteMenor = new Cliente("João", "1234", "12345", Utilitaria.parseDate("20/01/2010"));
        Carrinho carrinhoClienteMenor = new Carrinho();
        estoqueTemp = estoques.get(Categoria.FILME);
        carrinhoClienteMenor.adicionar(estoqueTemp.getProduto(4), 1, estoqueTemp);
        estoqueTemp = estoques.get(Categoria.BRINQUEDO);
        carrinhoClienteMenor.adicionar(estoqueTemp.getProduto(2), 1, estoqueTemp);
        displayCarrinho(carrinhoClienteMenor);
        displayStatusCompra(caixa, carrinhoClienteMenor.finalizarCompra(caixa, clienteMenor));

        //Compra ClienteMaior
        Cliente clienteMaior = new Cliente("José", "5678", "67890", Utilitaria.parseDate("20/01/2000"));
        Carrinho carrinhoClienteMaior = new Carrinho();
        estoqueTemp = estoques.get(Categoria.FILME);
        carrinhoClienteMaior.adicionar(estoqueTemp.getProduto(4), 1, estoqueTemp);
        estoqueTemp = estoques.get(Categoria.LIVRO);
        carrinhoClienteMaior.adicionar(estoqueTemp.getProduto(2), 1, estoqueTemp);
        displayCarrinho(carrinhoClienteMaior);
        displayStatusCompra(caixa, carrinhoClienteMaior.finalizarCompra(caixa, clienteMaior));

        //==Processo de Compra - V3-desconto em Livros
        Carrinho carrinhoClienteLivro = new Carrinho();
        estoqueTemp = estoques.get(Categoria.ALBUM_MUSICA);
        carrinhoClienteLivro.adicionar(estoqueTemp.getProduto(2), 2, estoqueTemp,Categoria.ALBUM_MUSICA);
        estoqueTemp = estoques.get(Categoria.LIVRO);
        carrinhoClienteLivro.adicionar(estoqueTemp.getProduto(2), 4, estoqueTemp,Categoria.LIVRO);
        displayCarrinho(carrinhoClienteLivro);
        displayStatusCompra(caixa, carrinhoClienteLivro.finalizarCompra(caixa, clienteMenor));


    }

    private static void displayStatusCompra(Caixa caixa, boolean finalizarCompra) {
        System.out.println();
        if (finalizarCompra) {
            System.out.println("Compra realizada");
        } else {
            System.out.println("Compra bloqueada");
        }
        System.out.printf("== Valor em caixa %.2f\n", caixa.getSaldo());
    }

    private static void displayCarrinho(Carrinho carrinho) {
        System.out.println("\n== Itens Carrinho:");
        int count = 0;
        for (Produto produto : carrinho.getAll().keySet()) {
            count++;
            int qtd = carrinho.getAll().get(produto);
            double total = produto.getPreco() * qtd;
            System.out.printf("Item %d = ", count);
            System.out.print(produto.getNome());
            System.out.printf(" -- Quantidade = %d, Total = %.2f\n", qtd, total);
        }
        System.out.printf("Total em livros = %.2f, Desconto de %.2f\n",carrinho.getValorEmLivros(),carrinho.getValorDesconto());
        System.out.printf("Total carrinho %.2f\n", carrinho.valorTotalCarrinho());
    }
}
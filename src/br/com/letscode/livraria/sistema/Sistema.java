//package br.com.letscode.livraria.sistema;
//
//import br.com.letscode.livraria.estoque.Estoque;
//import br.com.letscode.livraria.produto.*;
//
//public class Sistema<T extends Produto> {
//    private Estoque<AlbumMusica> estoqueAlbumMusica;
//    private Estoque<Brinquedo> estoqueBrinquedo;
//    private Estoque<Filme> estoqueFilme;
//    private Estoque<Jogo> estoqueJogo;
//    private Estoque<Livro> estoqueLivro;
//
//    public Sistema() {
//        estoqueAlbumMusica = new Estoque<>();
//        estoqueBrinquedo = new Estoque<>();
//        estoqueFilme = new Estoque<>();
//        estoqueJogo = new Estoque<>();
//        estoqueLivro = new Estoque<>();
//    }
//
//    public Sistema(Estoque<AlbumMusica> estoqueAlbumMusica, Estoque<Brinquedo> estoqueBrinquedo, Estoque<Filme> estoqueFilme, Estoque<Jogo> estoqueJogo, Estoque<Livro> estoqueLivro) {
//        this.estoqueAlbumMusica = estoqueAlbumMusica;
//        this.estoqueBrinquedo = estoqueBrinquedo;
//        this.estoqueFilme = estoqueFilme;
//        this.estoqueJogo = estoqueJogo;
//        this.estoqueLivro = estoqueLivro;
//    }
//
//    public Estoque<AlbumMusica> getEstoqueAlbumMusica() {
//        return estoqueAlbumMusica;
//    }
//
//    public void setEstoqueAlbumMusica(Estoque<AlbumMusica> estoqueAlbumMusica) {
//        this.estoqueAlbumMusica = estoqueAlbumMusica;
//    }
//
//    public Estoque<Brinquedo> getEstoqueBrinquedo() {
//        return estoqueBrinquedo;
//    }
//
//    public void setEstoqueBrinquedo(Estoque<Brinquedo> estoqueBrinquedo) {
//        this.estoqueBrinquedo = estoqueBrinquedo;
//    }
//
//    public Estoque<Filme> getEstoqueFilme() {
//        return estoqueFilme;
//    }
//
//    public void setEstoqueFilme(Estoque<Filme> estoqueFilme) {
//        this.estoqueFilme = estoqueFilme;
//    }
//
//    public Estoque<Jogo> getEstoqueJogo() {
//        return estoqueJogo;
//    }
//
//    public void setEstoqueJogo(Estoque<Jogo> estoqueJogo) {
//        this.estoqueJogo = estoqueJogo;
//    }
//
//    public Estoque<Livro> getEstoqueLivro() {
//        return estoqueLivro;
//    }
//
//    public void setEstoqueLivro(Estoque<Livro> estoqueLivro) {
//        this.estoqueLivro = estoqueLivro;
//    }
//
//    public void cadastrarProduto(T produto) {
//        if (produto instanceof AlbumMusica) {
//            this.estoqueAlbumMusica.addProduto((AlbumMusica) produto);
//        } else if (produto instanceof Brinquedo) {
//            this.estoqueBrinquedo.addProduto((Brinquedo) produto);
//        } else if (produto instanceof Filme) {
//            this.estoqueFilme.addProduto((Filme) produto);
//        } else if (produto instanceof Jogo) {
//            this.estoqueJogo.addProduto((Jogo) produto);
//        } else if (produto instanceof Livro) {
//            this.estoqueLivro.addProduto((Livro) produto);
//        }
//    }
//    public void removerProduto(T produto) {
//        if (produto instanceof AlbumMusica) {
//            this.estoqueAlbumMusica.removeProduto((AlbumMusica) produto);
//        } else if (produto instanceof Brinquedo) {
//            this.estoqueBrinquedo.removeProduto((Brinquedo) produto);
//        } else if (produto instanceof Filme) {
//            this.estoqueFilme.removeProduto((Filme) produto);
//        } else if (produto instanceof Jogo) {
//            this.estoqueJogo.removeProduto((Jogo) produto);
//        } else if (produto instanceof Livro) {
//            this.estoqueLivro.removeProduto((Livro) produto);
//        }
//    }
//
//    public void listarProdutos(Estoque estoque){
//        System.out.println(estoque.toString());
//    }
//
//    public T getProduto(T produto){
//        if (produto instanceof AlbumMusica) {
//            return (T) this.estoqueAlbumMusica.getProduto((AlbumMusica) produto);
//        } else if (produto instanceof Brinquedo) {
//            return (T) this.estoqueBrinquedo.getProduto((Brinquedo) produto);
//        } else if (produto instanceof Filme) {
//            return (T) this.estoqueFilme.getProduto((Filme) produto);
//        } else if (produto instanceof Jogo) {
//            return (T) this.estoqueJogo.getProduto((Jogo) produto);
//        } else if (produto instanceof Livro) {
//            return (T) this.estoqueLivro.getProduto((Livro) produto);
//        }
//
//        return null;
//    }
//}

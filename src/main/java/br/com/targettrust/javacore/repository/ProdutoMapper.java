package br.com.targettrust.javacore.repository;

import br.com.targettrust.javacore.model.Eletronico;
import br.com.targettrust.javacore.model.Livro;
import br.com.targettrust.javacore.model.Produto;

public class ProdutoMapper {
    public static Produto buildProduto(ProdutoEntity produtoEntity) {
        if(produtoEntity.getType().equals("LIVRO")){
            return new Livro(produtoEntity.getId(), produtoEntity.getNome(), produtoEntity.getPreco());
        }

        if(produtoEntity.getType().equals("ELETRONICO")){
            return new Eletronico(produtoEntity.getId(), produtoEntity.getNome(), produtoEntity.getPreco());
        }

        return null;
    }

    public static ProdutoEntity buildProdutoEntity(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setPreco(produto.getPreco());
        if(produto instanceof Livro){
            produtoEntity.setType("LIVRO");
        }

        if(produto instanceof Eletronico){
            produtoEntity.setType("ELETRONICO");
        }
        return produtoEntity;
    }
}

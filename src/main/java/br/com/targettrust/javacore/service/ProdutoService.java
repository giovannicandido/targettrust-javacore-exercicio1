package br.com.targettrust.javacore.service;

import br.com.targettrust.javacore.model.Eletronico;
import br.com.targettrust.javacore.model.Livro;
import br.com.targettrust.javacore.model.Produto;
import br.com.targettrust.javacore.repository.ProdutoEntity;
import br.com.targettrust.javacore.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listAll() {
        return repository.findAll()
                .stream().map(this::buildProduto)
                .toList();
    }

    public Produto save(Produto produto) {
        ProdutoEntity saved = repository.save(buildProdutoEntity(produto));
        return buildProduto(saved);
    }

    private Produto buildProduto(ProdutoEntity produtoEntity) {
        if(produtoEntity.getType().equals("LIVRO")){
            return new Livro(produtoEntity.getId(), produtoEntity.getNome(), produtoEntity.getPreco());
        }

        if(produtoEntity.getType().equals("ELETRONICO")){
            return new Eletronico(produtoEntity.getId(), produtoEntity.getNome(), produtoEntity.getPreco());
        }

        return null;
    }

    private ProdutoEntity buildProdutoEntity(Produto produto) {
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

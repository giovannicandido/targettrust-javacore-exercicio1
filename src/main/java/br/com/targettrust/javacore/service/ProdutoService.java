package br.com.targettrust.javacore.service;

import br.com.targettrust.javacore.model.Eletronico;
import br.com.targettrust.javacore.model.Livro;
import br.com.targettrust.javacore.model.Produto;
import br.com.targettrust.javacore.repository.ProdutoEntity;
import br.com.targettrust.javacore.repository.ProdutoMapper;
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
                .stream().map(ProdutoMapper::buildProduto)
                .toList();
    }

    public Produto save(Produto produto) {
        ProdutoEntity saved = repository.save(ProdutoMapper.buildProdutoEntity(produto));
        return ProdutoMapper.buildProduto(saved);
    }
}

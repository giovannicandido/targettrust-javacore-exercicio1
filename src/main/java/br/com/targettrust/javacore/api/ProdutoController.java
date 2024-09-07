package br.com.targettrust.javacore.api;

import br.com.targettrust.javacore.model.Eletronico;
import br.com.targettrust.javacore.model.Produto;
import br.com.targettrust.javacore.service.ProdutoService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostConstruct
    public void init() {
        Produto eletronico1 = new Eletronico(null,"testeeletronico", BigDecimal.valueOf(25.67));
        produtoService.save(eletronico1);
        produtoService.listAll().forEach(System.out::println);
    }
}

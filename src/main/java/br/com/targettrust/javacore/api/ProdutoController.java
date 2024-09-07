package br.com.targettrust.javacore.api;

import br.com.targettrust.javacore.model.Eletronico;
import br.com.targettrust.javacore.model.Produto;
import br.com.targettrust.javacore.service.ProdutoService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// Toda entrada e saida de informação do sistema passa pelo controlador
@Component
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Sempre que a aplicação iniciar esse metodo é executado
    @PostConstruct
    public void init() {
        Produto eletronico1 = new Eletronico(null,"testeeletronico", BigDecimal.valueOf(25.67));
        produtoService.save(eletronico1);
        produtoService.listAll().forEach(System.out::println);
    }

    // TODO implementar o caso de uso do exercicio 2 do material 10
    // calcular desconto dos produtos no model e passar para o service persistir o novo preço
    // cada metodo do controlador é um caso de uso/feature ou interação com a UI
}

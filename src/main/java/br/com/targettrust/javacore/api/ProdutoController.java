package br.com.targettrust.javacore.api;

import br.com.targettrust.javacore.model.Eletronico;
import br.com.targettrust.javacore.model.Produto;
import br.com.targettrust.javacore.model.Venda;
import br.com.targettrust.javacore.service.ProdutoService;
import br.com.targettrust.javacore.service.VendaService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// Toda entrada e saida de informação do sistema passa pelo controlador
@Component
public class ProdutoController {
    private final ProdutoService produtoService;
    private final VendaService vendaService;

    public ProdutoController(ProdutoService produtoService, VendaService vendaService) {
        this.produtoService = produtoService;
        this.vendaService = vendaService;
    }

    // Sempre que a aplicação iniciar esse metodo é executado
    @PostConstruct
    public void init() {
        Produto eletronico1 = new Eletronico(null,"testeeletronico", BigDecimal.valueOf(25.67));
        eletronico1 = produtoService.save(eletronico1);
        produtoService.listAll().forEach(System.out::println);

        // Exemplo criando venda com desconto

        Venda venda = new Venda();
        venda.setProduto(eletronico1);
        venda.setDesconto(BigDecimal.valueOf(35.00));
        venda.setValorTotal(BigDecimal.valueOf(100.00));

        vendaService.save(venda);
    }

    // TODO implementar o caso de uso do exercicio 2 do material 10
    // calcular desconto dos produtos no model e passar para o service persistir o novo preço
    // cada metodo do controlador é um caso de uso/feature ou interação com a UI
}

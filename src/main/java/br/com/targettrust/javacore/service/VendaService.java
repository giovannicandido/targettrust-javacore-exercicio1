package br.com.targettrust.javacore.service;

import br.com.targettrust.javacore.model.Venda;
import br.com.targettrust.javacore.repository.ProdutoMapper;
import br.com.targettrust.javacore.repository.VendaEntity;
import br.com.targettrust.javacore.repository.VendaMapper;
import br.com.targettrust.javacore.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class VendaService {
    private final VendaRepository repository;

    public VendaService(VendaRepository repository) {
        this.repository = repository;
    }

    public Venda save(Venda venda) {
        return VendaMapper.buildVenda(repository.save(VendaMapper.buildEntity(venda)));
    }

    public List<Venda> listAll() {
        return repository.findAll().stream()
                .map(VendaMapper::buildVenda)
//                .collect(Collectors.toList()); // mutable list
                .toList(); // immutable list

    }

    public void test() {
        List<Venda> vendas = listAll();
        vendas.add(new Venda()); // exemplo immutable vai dar pau em runtime

        // filtra todas as vendas maiores que 100
        List<Venda> todasVendasMenoresQue100 = vendas.stream()
                .filter(venda -> venda.getValorTotal().compareTo(BigDecimal.valueOf(100)) >= 0) // lambda é variavel
                .filter(it -> it.getProduto().getNome().contains("Cama")) // a logica do filter é reutilizável
                //
//                .map()
                .toList();

        // filtra todas as vendas maiores que 100 (no stream, no functional)
        // paradigma: procedural, orientado a objeto, funcional (haskell), logico (prolog)

        List<Venda> vendasFiltradas = new ArrayList<>();

        // Logica do filtro não é reutilizável
        for(Venda venda : todasVendasMenoresQue100) {
            if(venda.getValorTotal().compareTo(BigDecimal.valueOf(100)) >= 0) {
                vendasFiltradas.add(venda);
            }
        }

        // no final vendasFiltradas.

        // equivalente a isso no kotlin for (i in 0..10) {

        IntStream.range(0, 10).forEach(i -> {

        });
    }


}

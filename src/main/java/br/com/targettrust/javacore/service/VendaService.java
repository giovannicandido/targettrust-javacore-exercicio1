package br.com.targettrust.javacore.service;

import br.com.targettrust.javacore.model.Venda;
import br.com.targettrust.javacore.repository.ProdutoMapper;
import br.com.targettrust.javacore.repository.VendaEntity;
import br.com.targettrust.javacore.repository.VendaMapper;
import br.com.targettrust.javacore.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .toList();
    }


}

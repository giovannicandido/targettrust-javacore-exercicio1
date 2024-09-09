package br.com.targettrust.javacore.repository;

import br.com.targettrust.javacore.model.Venda;

public class VendaMapper {
    public static VendaEntity buildEntity(Venda venda) {
        VendaEntity vendaEntity = new VendaEntity();
        vendaEntity.setId(venda.getId());
        vendaEntity.setData(venda.getData());
        vendaEntity.setDesconto(venda.getDesconto());
        vendaEntity.setData(venda.getData());
        vendaEntity.setValorTotal(venda.getValorTotal());
        vendaEntity.setProduto(ProdutoMapper.buildProdutoEntity(venda.getProduto()));
        return vendaEntity;
    }

    public static Venda buildVenda(VendaEntity entity) {
        Venda venda = new Venda();
        venda.setId(entity.getId());
        venda.setData(entity.getData());
        venda.setDesconto(entity.getDesconto());
        venda.setData(entity.getData());
        venda.setValorTotal(entity.getValorTotal());
        venda.setProduto(ProdutoMapper.buildProduto(entity.getProduto()));
        return venda;
    }
}

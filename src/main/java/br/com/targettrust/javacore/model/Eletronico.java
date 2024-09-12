package br.com.targettrust.javacore.model;

import java.math.BigDecimal;

public class Eletronico extends Produto {


    @Override
    public BigDecimal calcularDesconto() {
        return null;
    }

    public Eletronico(Long id, String nome, BigDecimal preco) {
        super(id, nome, preco);
    }

    @Override
    public String toString() {
        return "Eletronico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}

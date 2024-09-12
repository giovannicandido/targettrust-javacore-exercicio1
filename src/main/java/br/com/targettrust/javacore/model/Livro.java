package br.com.targettrust.javacore.model;

import java.math.BigDecimal;

public class Livro extends Produto {


    @Override
    public BigDecimal calcularDesconto() {
        return null;
    }

    public Livro(Long id, String nome, BigDecimal preco) {
        super(id, nome, preco);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

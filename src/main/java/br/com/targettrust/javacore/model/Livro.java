package br.com.targettrust.javacore.model;

import java.math.BigDecimal;

public class Livro extends Produto {


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
}

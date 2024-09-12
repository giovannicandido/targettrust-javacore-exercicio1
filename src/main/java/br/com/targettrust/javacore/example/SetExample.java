package br.com.targettrust.javacore.example;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        MeuObjeto meuObjeto = new SetExample.MeuObjeto("teste");
        MeuObjeto meuObjeto2 = new SetExample.MeuObjeto("teste"); // mesmo nome porem novo objeto na memoria
        Set<MeuObjeto> set = new HashSet<>();
        List<MeuObjeto> list = new ArrayList<>();

        list.add(meuObjeto);
        list.add(meuObjeto);
        System.out.println("------- List");
        imprimir(list);
        System.out.println("------- Set");
        set.add(meuObjeto);
        set.add(meuObjeto);
        imprimir(set);

        System.out.println("------- List com meu objeto 2");
        list.clear();
        list.add(meuObjeto);
        list.add(meuObjeto2);
        imprimir(list);
        System.out.println("------- Set com meu objeto 2");
        set.clear();
        set.add(meuObjeto);
        set.add(meuObjeto2);
        imprimir(set);

        // Calculo de imposto
        // Agrupando o IPTU por bairro
        // Bairro como um HashSet -> bairro a, bairro b
        // Poderia ser um HashMap -> Chave é o bairro, e o valor é estrutura que está sendo calculada. // Json

        // Um exemplo de uso do HashMap.
        // Pais -> Versão -> Opção -> Methodo -> Inputs | Results (8 min) -> segundos
        // cada item era uma api. cada item era uma chama de de rede para um serviço para buscar os dados. Isso é muito lento
        // Hierarquia é bem grande, poucos dados isso aumenta muito o processamento, e aumenta a complexidade.
        // Usei hashmap como cache
        // Redis cache da chamada http (backend -> API; backend -> redis (24h) -> API)
        // 
    }

    public static void imprimir(Collection<MeuObjeto> collection) {
        for (MeuObjeto meuObjeto : collection) {
            System.out.println(meuObjeto.getNome());
        }
    }

    public static class MeuObjeto {
        private String nome;

        public MeuObjeto(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MeuObjeto meuObjeto = (MeuObjeto) o;
            return Objects.equals(nome, meuObjeto.nome);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(nome);
        }
    }
}

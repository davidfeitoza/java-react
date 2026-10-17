package br.com.curso.aula02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColecoesLab {
    public static void main(String[] args) {
        // LIST
        List<String> nomes = new ArrayList<>();
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carla");

        System.out.println(nomes);
        System.out.println("Tamanho: " + nomes.size());
        System.out.println("Primeiro: " + nomes.get(0));

        nomes.remove("Bruno");
        System.out.println("Contém Ana? " + nomes.contains("Ana"));

        for (String nome : nomes) {
            System.out.println("- " + nome);
        }

        // MAP
        Map<String, Integer> estoque = new HashMap<>();
        estoque.put("Teclado", 10);
        estoque.put("Mouse", 25);

        System.out.println("Teclados: " + estoque.get("Teclado"));

        estoque.put("Teclado", 8);   // mesma chave: substitui
        System.out.println("Teclados agora: " + estoque.get("Teclado"));
        System.out.println("Tem Monitor? " + estoque.containsKey("Monitor"));

        for (Map.Entry<String, Integer> item : estoque.entrySet()) {
            System.out.println(item.getKey() + " -> " + item.getValue());
        }
    }
}

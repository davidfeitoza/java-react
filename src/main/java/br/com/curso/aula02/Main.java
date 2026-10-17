package br.com.curso.aula02;

import br.com.curso.aula02.modelo.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Produto> produtos = new ArrayList<>();
    private static int proximoId = 1;

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> adicionarProduto();
                case 2 -> listarProdutos();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("===== CADASTRO DE PRODUTOS =====");
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("0 - Sair");
    }

    private static void adicionarProduto() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        double preco = lerDecimal("Preço: ");
        int quantidade = lerInteiro("Quantidade: ");

        try {
            Produto produto = new Produto(proximoId, nome, preco, quantidade);
            produtos.add(produto);
            proximoId++;
            System.out.println("Cadastrado: " + produto);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        double totalGeral = 0;
        for (Produto p : produtos) {
            System.out.println(p);
            totalGeral += p.valorTotalEmEstoque();
        }
        System.out.printf("Valor total em estoque: R$ %.2f%n", totalGeral);
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDecimal(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();
            try {
                return Double.parseDouble(entrada.trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido (ex.: 19.90).");
            }
        }
    }
}
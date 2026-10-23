
package br.com.curso.aula02;

import br.com.curso.aula02.modelo.Produto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainProdutosMap {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, Produto> produtos = new HashMap<>();
    private static int proximoId = 1;

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n===== PRODUTOS COM MAP =====");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto por ID");
            System.out.println("4 - Remover produto por ID");
            System.out.println("5 - Alterar quantidade");
            System.out.println("0 - Sair");

            opcao = lerInteiro("Opção: ");

            switch (opcao) {
                case 1 -> adicionarProduto();
                case 2 -> listarProdutos();
                case 3 -> buscarProduto();
                case 4 -> removerProduto();
                case 5 -> alterarQuantidade();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private static void adicionarProduto() {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        double preco = lerDecimal("Preço: ");
        int quantidade = lerInteiro("Quantidade: ");

        try {
            Produto produto = new Produto(
                    proximoId, nome, preco, quantidade
            );

            produtos.put(proximoId, produto);
            proximoId++;

            System.out.println("Produto cadastrado: " + produto);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarProdutos() {

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        double total = 0;

        for (Produto produto : produtos.values()) {
            System.out.println(produto);
            total += produto.valorTotalEmEstoque();
        }

        System.out.printf("Total em estoque: R$ %.2f%n", total);
    }

    private static void buscarProduto() {

        int id = lerInteiro("ID do produto: ");
        Produto produto = produtos.get(id);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println(produto);
        }
    }

    private static void removerProduto() {

        int id = lerInteiro("ID para remover: ");
        Produto removido = produtos.remove(id);

        if (removido == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Produto removido: " + removido);
        }
    }

    private static void alterarQuantidade() {

        int id = lerInteiro("ID do produto: ");
        Produto produto = produtos.get(id);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        int quantidade = lerInteiro("Nova quantidade: ");

        try {
            produto.setQuantidade(quantidade);
            System.out.println("Quantidade atualizada: " + produto);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static int lerInteiro(String mensagem) {

        while (true) {
            System.out.print(mensagem);

            try {
                int valor = Integer.parseInt(
                        scanner.nextLine().trim()
                );

                if (valor < 0) {
                    System.out.println(
                            "Digite um número não negativo."
                    );
                    continue;
                }

                return valor;

            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDecimal(String mensagem) {

        while (true) {
            System.out.print(mensagem);

            try {
                double valor = Double.parseDouble(
                        scanner.nextLine().trim().replace(",", ".")
                );

                if (!Double.isFinite(valor) || valor < 0) {
                    System.out.println(
                            "Digite um preço válido e não negativo."
                    );
                    continue;
                }

                return valor;

            } catch (NumberFormatException e) {
                System.out.println("Digite um preço válido.");
            }
        }
    }
}

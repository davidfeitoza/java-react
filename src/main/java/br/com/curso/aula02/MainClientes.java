
package br.com.curso.aula02;

import br.com.curso.aula02.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClientes {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Cliente> clientes = new ArrayList<>();
    private static int proximoId = 1;

    public static void main(String[] args) {

        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> adicionarCliente();
                case 2 -> listarClientes();
                case 3 -> removerCliente();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n===== CADASTRO DE CLIENTES =====");
        System.out.println("1 - Adicionar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Remover cliente por ID");
        System.out.println("0 - Sair");
    }

    private static void adicionarCliente() {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        try {
            Cliente cliente = new Cliente(
                    proximoId, nome, email
            );

            // Impede e-mails duplicados, ignorando maiúsculas.
            for (Cliente existente : clientes) {
                if (existente.getEmail().equalsIgnoreCase(
                        cliente.getEmail())) {
                    throw new IllegalArgumentException(
                            "Este e-mail já está cadastrado."
                    );
                }
            }

            clientes.add(cliente);
            proximoId++;

            System.out.println("Cliente cadastrado: " + cliente);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private static void removerCliente() {

        int id = lerInteiro("Digite o ID do cliente: ");

        boolean removido = clientes.removeIf(
                cliente -> cliente.getId() == id
        );

        if (removido) {
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Não existe cliente com esse ID.");
        }
    }

    private static int lerInteiro(String mensagem) {

        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();

            try {
                int numero = Integer.parseInt(entrada.trim());

                if (numero < 0) {
                    System.out.println(
                            "Digite um número não negativo."
                    );
                    continue;
                }

                return numero;

            } catch (NumberFormatException e) {
                System.out.println(
                        "Digite um número inteiro válido."
                );
            }
        }
    }
}

package org.example;

import java.util.Scanner;

public class Nome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o ano de seu nascimento: ");
        int ano = scanner.nextInt();

        int idade = 2026 - ano;

        System.out.println("Olá, " + nome + "! Você tem " + idade + " anos.");
        System.out.println("Em 5 anos você terá " + (idade + 5) + " anos.");

        scanner.close();
    }
}

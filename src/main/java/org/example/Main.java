package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        System.out.println("Olá, " + nome + "! Você tem " + idade + " anos.");
        System.out.println("Em 5 anos você terá " + (idade + 5) + " anos.");

        scanner.close();
        }
    }

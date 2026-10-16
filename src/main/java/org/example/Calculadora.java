package org.example;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor da conta: ");
        double valorDaConta = scanner.nextDouble();

        System.out.print("Digite o percentual da gorjeta: ");
        int porcentagemDaGorgeta = scanner.nextInt();

        double gorjeta = valorDaConta / porcentagemDaGorgeta;
        double total = valorDaConta + gorjeta;

        System.out.println("A gorgeta é " + gorjeta + " e o total é " + total + ".");

        scanner.close();
    }
}

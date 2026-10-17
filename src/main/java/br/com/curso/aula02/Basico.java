package br.com.curso.aula02;

public class Basico {
    public static void main(String[] args) {
        // 1. Decisão
        int nota = 7;
        if (nota >= 7) {
            System.out.println("Aprovado");
        } else if (nota >= 5) {
            System.out.println("Recuperação");
        } else {
            System.out.println("Reprovado");
        }

        // 2. switch com retorno
        int dia = 3;
        String nomeDia = switch (dia) {
            case 1 -> "Domingo";
            case 2 -> "Segunda";
            case 3 -> "Terça";
            default -> "Outro dia";
        };
        System.out.println("Dia: " + nomeDia);

        // 3. for: tabuada
        int numero = 7;
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + "x" + i + "=" + (numero * i));
        }

        // 4. while: soma até 100
        int soma = 0;
        int n = 1;
        while (soma + n <= 100) {
            soma += n;
            n++;
        }
        System.out.println("Soma: " + soma + " (parou em n = " + n + ")");

        // 5. Métodos
        System.out.println("Soma de 3 e 4: " + somar(3, 4));
        System.out.println("É par? " + ehPar(10));
    }

    public static int somar(int a, int b) {
        return a + b;
    }

    public static boolean ehPar(int numero) {
        return numero % 2 == 0;
    }
}

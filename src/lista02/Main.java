package lista02;

import lista02.data.Data;

/** Demonstracao dos quatro exercicios da lista 02. */
public class Main {

    public static void main(String[] args) {
        exercicio01();
        exercicio02();
        exercicio03();
        exercicio04();
    }

    private static void exercicio01() {
        System.out.println("=== Exercicio 01 - Data ===");
        Data data = new Data(1, 8, 2017);

        String[] formatos = {"dd/mm/aaaa", "dddd/m/aaaa", "d:m:aa", "aaa/m/d"};
        for (String formato : formatos) {
            data.definirFormato(formato);
            System.out.printf("%-12s -> ", formato);
            data.imprimir();
        }

        // Validacao dos atributos.
        tentarCriar(31, 2, 2017);
        tentarCriar(1, 13, 2017);
        tentarCriar(29, 2, 2020); // valido: ano bissexto
        System.out.println();
    }

    private static void tentarCriar(int dia, int mes, int ano) {
        try {
            Data data = new Data(dia, mes, ano);
            System.out.println("Aceito: " + data);
        } catch (IllegalArgumentException erro) {
            System.out.println("Recusado: " + erro.getMessage());
        }
    }

    private static void exercicio02() {
        System.out.println("=== Exercicio 02 - Classe abstrata ===");
        // O tipo declarado e a classe abstrata: polimorfismo em acao.
        lista02.formas.abstrata.Forma[] formas = {
            new lista02.formas.abstrata.Retangulo(10, 4),
            new lista02.formas.abstrata.Triangulo(10, 4)
        };
        for (lista02.formas.abstrata.Forma forma : formas) {
            System.out.println(forma);
        }
        System.out.println();
    }

    private static void exercicio03() {
        System.out.println("=== Exercicio 03 - Interface ===");
        lista02.formas.interfaces.Forma[] formas = {
            new lista02.formas.interfaces.Retangulo(10, 4),
            new lista02.formas.interfaces.Triangulo(10, 4)
        };
        for (lista02.formas.interfaces.Forma forma : formas) {
            System.out.println(forma);
        }
        System.out.println();
    }

    private static void exercicio04() {
        System.out.println("=== Exercicio 04 - Triangulo herda de Retangulo ===");
        lista02.formas.heranca.Retangulo retangulo = new lista02.formas.heranca.Retangulo(10, 4);
        lista02.formas.heranca.Triangulo triangulo = new lista02.formas.heranca.Triangulo(10, 4);

        System.out.println(retangulo);
        System.out.println(triangulo + " (metade de " + retangulo.calcularArea() + ")");
        System.out.println("Triangulo e um Retangulo? " + (triangulo instanceof lista02.formas.heranca.Retangulo));
        System.out.println();
    }
}

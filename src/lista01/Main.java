package lista01;

import java.util.List;
import java.util.Locale;

/** Demonstracao dos tres exercicios da lista 01. */
public class Main {

    public static void main(String[] args) {
        exercicio01();
        exercicio02e03();
    }

    private static void exercicio01() {
        System.out.println("=== Exercicio 01 - Contador ===");
        Contador contador = new Contador();
        System.out.println("Valor inicial: " + contador.getValor());

        for (int i = 0; i < 5; i++) {
            contador.incrementar();
        }
        System.out.println("Apos 5 incrementos: " + contador.getValor());

        contador.zerar();
        System.out.println("Apos zerar: " + contador.getValor());
        System.out.println();
    }

    private static void exercicio02e03() {
        System.out.println("=== Exercicios 02 e 03 - Pais e Continente ===");

        Pais brasil = new Pais("BRA", "Brasil", 8515767.049);
        brasil.setPopulacao(202768562L);

        Pais argentina = new Pais("ARG", "Argentina", 2780400.0);
        argentina.setPopulacao(45376763L);

        Pais uruguai = new Pais("URY", "Uruguai", 176215.0);
        uruguai.setPopulacao(3473730L);

        Pais paraguai = new Pais("PRY", "Paraguai", 406752.0);
        paraguai.setPopulacao(7132538L);

        Pais bolivia = new Pais("BOL", "Bolivia", 1098581.0);
        bolivia.setPopulacao(11673021L);

        Pais chile = new Pais("CHL", "Chile", 756102.0);
        chile.setPopulacao(19116209L);

        // Fronteiras (a relacao e registrada nos dois sentidos).
        brasil.adicionarVizinho(argentina);
        brasil.adicionarVizinho(uruguai);
        brasil.adicionarVizinho(paraguai);
        brasil.adicionarVizinho(bolivia);
        argentina.adicionarVizinho(uruguai);
        argentina.adicionarVizinho(paraguai);
        argentina.adicionarVizinho(bolivia);
        argentina.adicionarVizinho(chile);
        bolivia.adicionarVizinho(paraguai);
        bolivia.adicionarVizinho(chile);

        // Igualdade por codigo ISO.
        Pais outroBrasil = new Pais("BRA", "Republica Federativa do Brasil", 8515767.049);
        System.out.println("Brasil equals outro objeto com ISO BRA? " + brasil.equals(outroBrasil));
        System.out.println("Brasil equals Argentina? " + brasil.equals(argentina));

        System.out.println("Chile e vizinho do Brasil? " + brasil.ehVizinho(chile));
        System.out.println("Uruguai e vizinho do Brasil? " + brasil.ehVizinho(uruguai));

        System.out.printf(Locale.US, "Densidade do Brasil: %.2f hab/km2%n",
                brasil.getDensidadePopulacional());

        List<Pais> comuns = brasil.getVizinhosEmComum(argentina);
        System.out.println("Vizinhos comuns entre Brasil e Argentina: " + comuns);
        System.out.println();

        Continente americaDoSul = new Continente("America do Sul");
        americaDoSul.adicionarPais(brasil);
        americaDoSul.adicionarPais(argentina);
        americaDoSul.adicionarPais(uruguai);
        americaDoSul.adicionarPais(paraguai);
        americaDoSul.adicionarPais(bolivia);
        americaDoSul.adicionarPais(chile);

        System.out.println("Continente: " + americaDoSul);
        System.out.printf(Locale.US, "Dimensao total: %.3f km2%n", americaDoSul.getDimensaoTotal());
        System.out.println("Populacao total: " + americaDoSul.getPopulacaoTotal());
        System.out.printf(Locale.US, "Densidade populacional: %.2f hab/km2%n",
                americaDoSul.getDensidadePopulacional());
        System.out.println("Maior populacao: " + americaDoSul.getPaisMaisPopuloso());
        System.out.println("Menor populacao: " + americaDoSul.getPaisMenosPopuloso());
        System.out.println("Maior territorio: " + americaDoSul.getMaiorPais());
        System.out.println("Menor territorio: " + americaDoSul.getMenorPais());
        System.out.printf(Locale.US, "Razao territorial (maior/menor): %.2f%n",
                americaDoSul.getRazaoTerritorial());
        System.out.println();
    }
}

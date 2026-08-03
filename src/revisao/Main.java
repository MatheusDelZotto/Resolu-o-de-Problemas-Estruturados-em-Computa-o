package revisao;

/** Demonstracao dos exercicios propostos nos slides do PDF de revisao. */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Exercicios do PDF - Pessoa e Funcionario ===");

        Pessoa vazia = new Pessoa();
        System.out.println("Construtor sem parametros: " + vazia);

        Pessoa pessoa = new Pessoa("Maria Silva", "123.456.789-00", "(41) 99999-0000");
        System.out.println("Construtor com parametros: " + pessoa);

        Funcionario funcionario = new Funcionario("Joao Souza", "987.654.321-00", "(41) 98888-1111", "MAT-2026-01");
        System.out.println("Funcionario (herda de Pessoa): " + funcionario);
        System.out.println("Funcionario e uma Pessoa? " + (funcionario instanceof Pessoa));
    }
}

package lista01;

/**
 * Lista 01 - Exercicio 01
 *
 * Encapsula um valor usado para contagem de itens ou eventos.
 * O atributo e privado: a unica forma de altera-lo e atraves dos
 * metodos publicos (encapsulamento).
 */
public class Contador {

    private int valor;

    public Contador() {
        this.valor = 0;
    }

    /** Zera o contador. */
    public void zerar() {
        this.valor = 0;
    }

    /** Incrementa o contador em uma unidade. */
    public void incrementar() {
        this.valor++;
    }

    /** Retorna o valor atual do contador. */
    public int getValor() {
        return this.valor;
    }

    @Override
    public String toString() {
        return "Contador[" + this.valor + "]";
    }
}

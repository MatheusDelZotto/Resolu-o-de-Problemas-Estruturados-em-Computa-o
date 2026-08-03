package lista02.formas.abstrata;

/**
 * Lista 02 - Exercicio 02
 *
 * Classe abstrata: nao pode ser instanciada e obriga as subclasses a
 * implementarem calcularArea(). Diferente de uma interface, ela pode
 * guardar atributos e ter metodos concretos (aqui, os getters/setters).
 */
public abstract class Forma {

    protected int altura;
    protected int largura;

    public Forma(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return this.largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    /** Metodo abstrato: sem implementacao aqui, obrigatorio nas subclasses. */
    public abstract int calcularArea();
}

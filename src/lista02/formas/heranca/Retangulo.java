package lista02.formas.heranca;

/**
 * Lista 02 - Exercicio 04
 *
 * Retangulo passa a ser a classe base do Triangulo. Os atributos ficam
 * protected para que a subclasse possa reutiliza-los.
 */
public class Retangulo implements Forma {

    protected int altura;
    protected int largura;

    public Retangulo(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public int getAltura() {
        return this.altura;
    }

    @Override
    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public int getLargura() {
        return this.largura;
    }

    @Override
    public void setLargura(int largura) {
        this.largura = largura;
    }

    @Override
    public int calcularArea() {
        return this.largura * this.altura;
    }

    @Override
    public String toString() {
        return "Retangulo " + this.largura + "x" + this.altura + " -> area " + this.calcularArea();
    }
}

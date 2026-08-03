package lista02.formas.interfaces;

/** Lista 02 - Exercicio 03: retangulo implementando a interface Forma. */
public class Retangulo implements Forma {

    private int altura;
    private int largura;

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

package lista02.formas.interfaces;

/** Lista 02 - Exercicio 03: triangulo implementando a interface Forma. */
public class Triangulo implements Forma {

    private int altura;
    private int largura;

    public Triangulo(int altura, int largura) {
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
        return (this.largura * this.altura) / 2;
    }

    @Override
    public String toString() {
        return "Triangulo " + this.largura + "x" + this.altura + " -> area " + this.calcularArea();
    }
}

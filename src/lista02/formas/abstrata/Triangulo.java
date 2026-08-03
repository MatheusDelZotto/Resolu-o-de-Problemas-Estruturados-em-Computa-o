package lista02.formas.abstrata;

/** Lista 02 - Exercicio 02: area do triangulo = (base x altura) / 2. */
public class Triangulo extends Forma {

    public Triangulo(int altura, int largura) {
        super(altura, largura);
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

package lista02.formas.abstrata;

/** Lista 02 - Exercicio 02: area do retangulo = base x altura. */
public class Retangulo extends Forma {

    public Retangulo(int altura, int largura) {
        super(altura, largura);
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

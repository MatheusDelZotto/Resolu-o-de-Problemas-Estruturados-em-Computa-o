package lista02.formas.heranca;

/**
 * Lista 02 - Exercicio 04
 *
 * O triangulo herda do retangulo: calcularArea() chama a implementacao da
 * superclasse com super e divide o resultado por dois.
 */
public class Triangulo extends Retangulo {

    public Triangulo(int altura, int largura) {
        super(altura, largura);
    }

    @Override
    public int calcularArea() {
        return super.calcularArea() / 2;
    }

    @Override
    public String toString() {
        return "Triangulo " + this.largura + "x" + this.altura + " -> area " + this.calcularArea();
    }
}

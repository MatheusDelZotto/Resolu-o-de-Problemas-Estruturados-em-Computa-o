package lista02.formas.heranca;

/**
 * Lista 02 - Exercicio 04
 *
 * Mesmo contrato do exercicio 03. O que muda e a hierarquia: agora
 * Triangulo herda de Retangulo em vez de implementar a interface
 * diretamente.
 */
public interface Forma {

    int calcularArea();

    int getAltura();

    void setAltura(int altura);

    int getLargura();

    void setLargura(int largura);
}

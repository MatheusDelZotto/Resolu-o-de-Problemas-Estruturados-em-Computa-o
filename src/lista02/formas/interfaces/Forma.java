package lista02.formas.interfaces;

/**
 * Lista 02 - Exercicio 03
 *
 * Mesmo exercicio anterior, agora com interface. A interface e apenas um
 * contrato: nao possui atributos nem construtor, e todos os metodos sao
 * publicos e sem implementacao. Por isso altura e largura passam a ser
 * responsabilidade de cada classe que implementa o contrato.
 */
public interface Forma {

    int calcularArea();

    int getAltura();

    void setAltura(int altura);

    int getLargura();

    void setLargura(int largura);
}

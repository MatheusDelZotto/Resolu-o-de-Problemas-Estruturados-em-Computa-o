package lista01;

import java.util.ArrayList;
import java.util.List;

/**
 * Lista 01 - Exercicio 03
 *
 * Um continente possui um nome e e composto por um conjunto de paises.
 *
 * Observacao: quando o continente esta vazio nao existe "maior" nem
 * "menor" pais, entao os metodos de busca retornam null e os de soma
 * retornam zero.
 */
public class Continente {

    private String nome;
    private List<Pais> paises;

    /** Construtor que inicializa o nome do continente. */
    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pais> getPaises() {
        return this.paises;
    }

    /** Adiciona um pais ao continente, ignorando duplicatas (mesmo ISO). */
    public void adicionarPais(Pais pais) {
        if (pais != null && !this.paises.contains(pais)) {
            this.paises.add(pais);
        }
    }

    /** Dimensao total do continente em km2. */
    public double getDimensaoTotal() {
        double total = 0;
        for (Pais pais : this.paises) {
            total += pais.getDimensao();
        }
        return total;
    }

    /** Populacao total do continente. */
    public long getPopulacaoTotal() {
        long total = 0;
        for (Pais pais : this.paises) {
            total += pais.getPopulacao();
        }
        return total;
    }

    /** Densidade populacional do continente em habitantes por km2. */
    public double getDensidadePopulacional() {
        double dimensaoTotal = this.getDimensaoTotal();
        if (dimensaoTotal <= 0) {
            return 0;
        }
        return this.getPopulacaoTotal() / dimensaoTotal;
    }

    /** Pais com maior populacao. */
    public Pais getPaisMaisPopuloso() {
        Pais maior = null;
        for (Pais pais : this.paises) {
            if (maior == null || pais.getPopulacao() > maior.getPopulacao()) {
                maior = pais;
            }
        }
        return maior;
    }

    /** Pais com menor populacao. */
    public Pais getPaisMenosPopuloso() {
        Pais menor = null;
        for (Pais pais : this.paises) {
            if (menor == null || pais.getPopulacao() < menor.getPopulacao()) {
                menor = pais;
            }
        }
        return menor;
    }

    /** Pais de maior dimensao territorial. */
    public Pais getMaiorPais() {
        Pais maior = null;
        for (Pais pais : this.paises) {
            if (maior == null || pais.getDimensao() > maior.getDimensao()) {
                maior = pais;
            }
        }
        return maior;
    }

    /** Pais de menor dimensao territorial. */
    public Pais getMenorPais() {
        Pais menor = null;
        for (Pais pais : this.paises) {
            if (menor == null || pais.getDimensao() < menor.getDimensao()) {
                menor = pais;
            }
        }
        return menor;
    }

    /** Razao territorial entre o maior e o menor pais do continente. */
    public double getRazaoTerritorial() {
        Pais maior = this.getMaiorPais();
        Pais menor = this.getMenorPais();
        if (maior == null || menor == null || menor.getDimensao() <= 0) {
            return 0;
        }
        return maior.getDimensao() / menor.getDimensao();
    }

    @Override
    public String toString() {
        return this.nome + " (" + this.paises.size() + " paises)";
    }
}

package lista01;

import java.util.ArrayList;
import java.util.List;

/**
 * Lista 01 - Exercicio 02
 *
 * Representa um pais atraves do codigo ISO 3166-1, nome, populacao e
 * dimensao territorial em km2. Cada pais mantem a lista dos paises com
 * os quais faz fronteira.
 */
public class Pais {

    private String codigoIso;
    private String nome;
    private long populacao;
    private double dimensao;
    private List<Pais> vizinhos;

    /** Construtor que inicializa o codigo ISO, o nome e a dimensao do pais. */
    public Pais(String codigoIso, String nome, double dimensao) {
        this.codigoIso = codigoIso;
        this.nome = nome;
        this.dimensao = dimensao;
        this.populacao = 0;
        this.vizinhos = new ArrayList<>();
    }

    // ------------------------------------------------------------------
    // Metodos de acesso
    // ------------------------------------------------------------------

    public String getCodigoIso() {
        return this.codigoIso;
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPopulacao() {
        return this.populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return this.dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public List<Pais> getVizinhos() {
        return this.vizinhos;
    }

    public void setVizinhos(List<Pais> vizinhos) {
        this.vizinhos = vizinhos;
    }

    /**
     * Adiciona uma fronteira. A fronteira e uma relacao mutua, entao o
     * pais recebido tambem passa a ter este pais como vizinho.
     */
    public void adicionarVizinho(Pais vizinho) {
        if (vizinho == null || this.equals(vizinho)) {
            return;
        }
        if (!this.ehVizinho(vizinho)) {
            this.vizinhos.add(vizinho);
        }
        if (!vizinho.ehVizinho(this)) {
            vizinho.getVizinhos().add(this);
        }
    }

    // ------------------------------------------------------------------
    // Comportamento
    // ------------------------------------------------------------------

    /** Dois paises sao iguais se tiverem o mesmo codigo ISO. */
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (!(objeto instanceof Pais)) {
            return false;
        }
        Pais outro = (Pais) objeto;
        if (this.codigoIso == null) {
            return outro.codigoIso == null;
        }
        return this.codigoIso.equalsIgnoreCase(outro.codigoIso);
    }

    /** Mantem o contrato equals/hashCode: paises iguais tem o mesmo hash. */
    @Override
    public int hashCode() {
        return this.codigoIso == null ? 0 : this.codigoIso.toUpperCase().hashCode();
    }

    /** Informa se o pais recebido faz fronteira com este pais. */
    public boolean ehVizinho(Pais outro) {
        if (outro == null) {
            return false;
        }
        for (Pais vizinho : this.vizinhos) {
            if (vizinho.equals(outro)) {
                return true;
            }
        }
        return false;
    }

    /** Densidade populacional em habitantes por km2. */
    public double getDensidadePopulacional() {
        if (this.dimensao <= 0) {
            return 0;
        }
        return this.populacao / this.dimensao;
    }

    /** Retorna a lista de vizinhos comuns a este pais e ao pais recebido. */
    public List<Pais> getVizinhosEmComum(Pais outro) {
        List<Pais> comuns = new ArrayList<>();
        if (outro == null) {
            return comuns;
        }
        for (Pais vizinho : this.vizinhos) {
            if (outro.ehVizinho(vizinho)) {
                comuns.add(vizinho);
            }
        }
        return comuns;
    }

    @Override
    public String toString() {
        return this.codigoIso + " - " + this.nome;
    }
}

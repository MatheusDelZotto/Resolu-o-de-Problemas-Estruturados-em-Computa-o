package revisao;

/**
 * Exercicio #1 do slide (PDF de revisao).
 *
 * Dois construtores (sobrecarga): um inicializa os atributos vazios e o
 * outro recebe os valores por parametro.
 */
public class Pessoa {

    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa() {
        this("", "", "");
    }

    public Pessoa(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa[nome=" + this.nome + ", cpf=" + this.cpf + ", telefone=" + this.telefone + "]";
    }
}

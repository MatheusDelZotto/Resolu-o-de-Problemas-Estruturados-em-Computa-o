package revisao;

/**
 * Exercicio #2 do slide (PDF de revisao).
 *
 * Herda de Pessoa e acrescenta a matricula.
 */
public class Funcionario extends Pessoa {

    private String matricula;

    public Funcionario() {
        super();
        this.matricula = "";
    }

    public Funcionario(String nome, String cpf, String telefone, String matricula) {
        super(nome, cpf, telefone);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Funcionario[nome=" + this.getNome() + ", cpf=" + this.getCpf()
                + ", telefone=" + this.getTelefone() + ", matricula=" + this.matricula + "]";
    }
}

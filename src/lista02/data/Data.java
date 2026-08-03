package lista02.data;

/**
 * Lista 02 - Exercicio 01
 *
 * Classe Data com dia, mes e ano. Os atributos so aceitam valores validos:
 * o mes vai de 1 a 12 e o dia respeita a quantidade de dias do mes, inclusive
 * fevereiro em anos bissextos. Valores invalidos disparam
 * IllegalArgumentException.
 *
 * O formato de impressao e definido por uma string onde:
 *   'd' -> dia, 'm' -> mes, 'a' -> ano
 * e qualquer outro caractere e copiado como separador literal.
 * A quantidade de letras determina a quantidade de digitos exibidos:
 * valores menores sao preenchidos com zeros a esquerda e valores maiores
 * sao truncados mantendo os digitos mais a direita.
 *
 *   "dd/mm/aaaa"  -> 01/08/2017
 *   "dddd/m/aaaa" -> 0001/8/2017
 *   "d:m:aa"      -> 1:8:17
 *   "aaa/m/d"     -> 017/8/1
 *
 * Observacao: o enunciado nomeia os metodos como DefinirFormato e Imprimir;
 * aqui eles seguem a convencao Java (primeira letra minuscula).
 */
public class Data {

    private static final String FORMATO_PADRAO = "dd/mm/aaaa";

    private int dia;
    private int mes;
    private int ano;
    private String formato;

    public Data(int dia, int mes, int ano) {
        validar(dia, mes, ano);
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.formato = FORMATO_PADRAO;
    }

    // ------------------------------------------------------------------
    // Metodos de acesso (com validacao)
    // ------------------------------------------------------------------

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        validar(dia, this.mes, this.ano);
        this.dia = dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        validar(this.dia, mes, this.ano);
        this.mes = mes;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        validar(this.dia, this.mes, ano);
        this.ano = ano;
    }

    public String getFormato() {
        return this.formato;
    }

    // ------------------------------------------------------------------
    // Comportamento
    // ------------------------------------------------------------------

    /** Define o formato usado na impressao da data. */
    public void definirFormato(String formato) {
        if (formato == null || formato.isEmpty()) {
            throw new IllegalArgumentException("O formato nao pode ser vazio.");
        }
        boolean possuiCampo = false;
        for (int i = 0; i < formato.length(); i++) {
            char caractere = formato.charAt(i);
            if (caractere == 'd' || caractere == 'm' || caractere == 'a') {
                possuiCampo = true;
                break;
            }
        }
        if (!possuiCampo) {
            throw new IllegalArgumentException(
                    "O formato deve conter ao menos um campo 'd', 'm' ou 'a': " + formato);
        }
        this.formato = formato;
    }

    /** Monta a data de acordo com o formato definido. */
    public String formatar() {
        StringBuilder saida = new StringBuilder();
        int posicao = 0;
        while (posicao < this.formato.length()) {
            char campo = this.formato.charAt(posicao);
            if (campo != 'd' && campo != 'm' && campo != 'a') {
                saida.append(campo);
                posicao++;
                continue;
            }
            // Conta quantas letras iguais estao em sequencia.
            int quantidade = 0;
            while (posicao < this.formato.length() && this.formato.charAt(posicao) == campo) {
                quantidade++;
                posicao++;
            }
            int valor = campo == 'd' ? this.dia : (campo == 'm' ? this.mes : this.ano);
            saida.append(ajustarTamanho(valor, quantidade));
        }
        return saida.toString();
    }

    /** Imprime a data atual baseado no formato. */
    public void imprimir() {
        System.out.println(this.formatar());
    }

    @Override
    public String toString() {
        return this.formatar();
    }

    // ------------------------------------------------------------------
    // Apoio
    // ------------------------------------------------------------------

    /**
     * Devolve o valor com exatamente 'tamanho' digitos: completa com zeros
     * a esquerda quando falta e descarta os digitos mais a esquerda quando sobra.
     */
    private static String ajustarTamanho(int valor, int tamanho) {
        String texto = String.valueOf(valor);
        if (texto.length() == tamanho) {
            return texto;
        }
        if (texto.length() > tamanho) {
            return texto.substring(texto.length() - tamanho);
        }
        StringBuilder preenchido = new StringBuilder();
        for (int i = texto.length(); i < tamanho; i++) {
            preenchido.append('0');
        }
        return preenchido.append(texto).toString();
    }

    private static void validar(int dia, int mes, int ano) {
        if (ano < 1) {
            throw new IllegalArgumentException("Ano invalido: " + ano);
        }
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mes invalido: " + mes);
        }
        int limite = diasNoMes(mes, ano);
        if (dia < 1 || dia > limite) {
            throw new IllegalArgumentException(
                    "Dia invalido: " + dia + " (o mes " + mes + "/" + ano + " tem " + limite + " dias)");
        }
    }

    private static int diasNoMes(int mes, int ano) {
        switch (mes) {
            case 2:
                return ehBissexto(ano) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static boolean ehBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;
    }
}

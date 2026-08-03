# TDE 1 — Revisão de Programação Orientada a Objetos (Java)

Resolução das duas listas de exercícios da primeira semana de integração da disciplina
**Resolução de Problemas Estruturados em Computação**, mais os dois exercícios propostos
nos slides do PDF de revisão.

Atividade formativa. Java 17, sem dependências externas.

## Estrutura

```
src/
├── lista01/                        01 - Orientação a Objetos
│   ├── Contador.java               ex. 01 — encapsulamento
│   ├── Pais.java                   ex. 02 — atributos, getters/setters, equals, fronteiras
│   ├── Continente.java             ex. 03 — composição (continente tem países)
│   └── Main.java                   demonstração da lista
├── lista02/                        02 - Orientação a Objetos Avançada
│   ├── data/Data.java              ex. 01 — validação de atributos + formatação
│   ├── formas/abstrata/            ex. 02 — classe abstrata Forma
│   ├── formas/interfaces/          ex. 03 — mesma solução com interface
│   ├── formas/heranca/             ex. 04 — Triangulo herda de Retangulo
│   └── Main.java                   demonstração da lista
└── revisao/                        exercícios #1 e #2 dos slides
    ├── Pessoa.java                 sobrecarga de construtores
    ├── Funcionario.java            herança
    └── Main.java
```

## Como compilar e executar

```bash
javac -d out $(find src -name '*.java')

java -cp out lista01.Main     # Contador, País, Continente
java -cp out lista02.Main     # Data, Formas (abstrata / interface / herança)
java -cp out revisao.Main     # Pessoa e Funcionário
```

## Notas sobre as decisões de implementação

**Lista 01 — País.** A igualdade é definida pelo código ISO, então `equals` foi
sobrescrito junto de `hashCode` (o contrato do Java exige que objetos iguais tenham o
mesmo hash — sem isso, `List.contains` e coleções baseadas em hash se comportam de forma
inconsistente). `adicionarVizinho` registra a fronteira nos dois sentidos, já que
vizinhança é uma relação mútua.

**Lista 01 — Continente.** Com o continente vazio não existe maior nem menor país: os
métodos de busca retornam `null` e os de soma retornam zero.

**Lista 02 — Data.** A validação recusa datas inexistentes, incluindo 29 de fevereiro em
anos não bissextos. Os setters revalidam contra o estado atual do objeto, então mudar o
mês de 31/01 para fevereiro é rejeitado em vez de deixar a data corrompida.

A formatação segue a regra do enunciado — a quantidade de letras no formato é igual à
quantidade de caracteres impressos. Valores curtos recebem zeros à esquerda e valores
longos são truncados pela esquerda:

| Formato | Saída para 01/08/2017 |
|---|---|
| `dd/mm/aaaa` | `01/08/2017` |
| `dddd/m/aaaa` | `0001/8/2017` |
| `d:m:aa` | `1:8:17` |
| `aaa/m/d` | `017/8/1` |

Qualquer caractere que não seja `d`, `m` ou `a` é copiado como separador literal.

**Lista 02 — Formas.** Os exercícios 02, 03 e 04 ficaram em pacotes separados porque
resolvem o mesmo problema com nomes de classe idênticos (`Forma`, `Retangulo`,
`Triangulo`) e abordagens diferentes. O contraste é o ponto do exercício: a classe
abstrata concentra os atributos e os getters/setters na superclasse, enquanto a interface
só declara o contrato — cada implementação precisa manter altura e largura por conta
própria.

**Nomes dos métodos.** Os enunciados usam `CalcularArea`, `DefinirFormato` e `Imprimir`
(inicial maiúscula, convenção de C#). O código segue a convenção Java: `calcularArea`,
`definirFormato`, `imprimir`.

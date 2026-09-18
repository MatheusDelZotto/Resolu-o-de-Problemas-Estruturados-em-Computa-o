TABELA = {
    'A': '.-',    'B': '-...',  'C': '-.-.',  'D': '-..',   'E': '.',
    'F': '..-.',  'G': '--.',   'H': '....',  'I': '..',    'J': '.---',
    'K': '-.-',   'L': '.-..',  'M': '--',    'N': '-.',    'O': '---',
    'P': '.--.',  'Q': '--.-',  'R': '.-.',   'S': '...',   'T': '-',
    'U': '..-',   'V': '...-',  'W': '.--',   'X': '-..-',  'Y': '-.--',
    'Z': '--..',  '0': '-----', '1': '.----', '2': '..---', '3': '...--',
    '4': '....-', '5': '.....', '6': '-....', '7': '--...', '8': '---..',
    '9': '----.',
}


class Nodo:
    def __init__(self):
        self.caractere = None
        self.esquerda = None
        self.direita = None


class ArvoreMorse:
    def __init__(self):
        self.raiz = Nodo()
        for caractere, codigo in TABELA.items():
            self.inserir(codigo, caractere)

    def inserir(self, codigo, caractere):
        if not codigo or any(s not in '.-' for s in codigo):
            raise ValueError('codigo invalido: ' + repr(codigo))
        no = self.raiz
        for simbolo in codigo:
            if simbolo == '.':
                no.esquerda = no.esquerda or Nodo()
                no = no.esquerda
            else:
                no.direita = no.direita or Nodo()
                no = no.direita
        no.caractere = caractere.upper()

    def buscar(self, codigo):
        no = self.raiz
        for simbolo in codigo:
            no = no.esquerda if simbolo == '.' else no.direita if simbolo == '-' else None
            if no is None:
                return None
        return no.caractere

    def codigo_de(self, caractere, no=None, caminho=''):
        no = self.raiz if no is None else no
        if no.caractere == caractere.upper() and caminho:
            return caminho
        for filho, simbolo in ((no.esquerda, '.'), (no.direita, '-')):
            if filho is not None:
                achado = self.codigo_de(caractere, filho, caminho + simbolo)
                if achado:
                    return achado
        return None

    def codificar(self, texto):
        palavras = [' '.join(self.codigo_de(c) or '?' for c in p) for p in texto.split()]
        return ' / '.join(palavras)

    def decodificar(self, morse):
        palavras = [''.join(self.buscar(c) or '?' for c in p.split()) for p in morse.split('/')]
        return ' '.join(p for p in palavras if p)

    def exibir(self, no=None, prefixo='', ultimo=True, rotulo='raiz'):
        no = self.raiz if no is None else no
        conector = '' if rotulo == 'raiz' else ('`-- ' if ultimo else '|-- ')
        print(prefixo + conector + '[' + (no.caractere or '*') + '] ' + rotulo)
        filhos = [(f, s) for f, s in ((no.esquerda, '.'), (no.direita, '-')) if f]
        novo = '' if rotulo == 'raiz' else prefixo + ('    ' if ultimo else '|   ')
        for i, (filho, simbolo) in enumerate(filhos):
            self.exibir(filho, novo, i == len(filhos) - 1, simbolo)


def menu():
    arvore = ArvoreMorse()
    while True:
        print('\n1-Exibir arvore  2-Buscar codigo  3-Codificar  4-Decodificar  5-Inserir  0-Sair')
        opcao = input('Opcao: ').strip()
        if opcao == '1':
            arvore.exibir()
        elif opcao == '2':
            print(arvore.codigo_de(input('Caractere: ')) or 'nao encontrado')
        elif opcao == '3':
            print(arvore.codificar(input('Texto: ')))
        elif opcao == '4':
            print(arvore.decodificar(input('Morse (letras por espaco, palavras por /): ')))
        elif opcao == '5':
            try:
                arvore.inserir(input('Codigo: ').strip(), input('Caractere: ').strip())
                print('inserido')
            except ValueError as erro:
                print(erro)
        elif opcao == '0':
            break
        else:
            print('opcao invalida')


if __name__ == '__main__':
    menu()

public class ArvoreBinariaCodigoMorse {

    // Classe interna que representa um nó da árvore.
    class No {
        char dado;    // Caractere armazenado neste nó 
        No direita;   // Filho direito: representa o traço (-)
        No esquerda;  // Filho esquerdo: representa o ponto (.)

        // Construtor: cria um nó novo já definindo seu caractere
        No(char letra) {
            this.dado = letra;
            this.direita = null;
            this.esquerda = null;
        }
    }

    No raiz = new No(' '); // Nó raiz da árvore. É o ponto de partida.

    public void inserirLetra(char letra, String codigo) {
        No atual = raiz;

        int idx = 0;
        while (idx < codigo.length()) {
            // Se move na árvore conforme o próximo caractere em morse
            if (codigo.charAt(idx) == '.') {
                if (atual.esquerda == null) {
                    atual.esquerda = new No(' ');
                }
                atual = atual.esquerda;
            } else {
                if (atual.direita == null) {
                    atual.direita = new No(' ');
                }
                atual = atual.direita;
            }
            idx++;
        }

        atual.dado = letra;
    }

    // Busca o caractere correspondente a um código Morse
    // e retorna o caractere correspondente (ou null se não encontrado)
    public Character buscarLetra(String codigo) {
        No atual = raiz;

        for (int idx = 0; idx < codigo.length(); idx++) {
            char simbolo = codigo.charAt(idx);

            if (simbolo == '.') {
                atual = atual.esquerda;
            } else if (simbolo == '-') {
                atual = atual.direita;
            }

            if (atual == null) {
                return null; // código inválido, não retorna caminho na árvore
            }
        }

        return atual.dado;
    }

    // CÓDIGO CRIADO POR IA
    public void exibirArvore() {
        if (raiz == null) {
            System.out.println("Árvore vazia!");
            return;
        }
        System.out.println("Raiz [*]");
        // O filho à esquerda representa o ponto (.) e o da direita o traço (-)
        exibirArvore(raiz.esquerda, "", true, ".");
        exibirArvore(raiz.direita, "", false, "-");
    }

    private void exibirArvore(No no, String prefixo, boolean isEsquerda, String simboloMorse) {
        // Se o nó não existe, não há nada para desenhar
        if (no == null) return;

        // Se o nó ainda não tem letra associada ou é um espaço
        // o código exibe um asterisco '*' para facilitar a leitura
        char caractere = (no.dado == ' ' || no.dado == '\0') ? '*' : no.dado;

        System.out.println(prefixo + (isEsquerda ? "├── " : "└── ") + simboloMorse + " -> " + caractere);

        // Define a formatação das linhas verticais para os próximos níveis
        String novoPrefixo = prefixo + (isEsquerda ? "│   " : "    ");

        // Chamada Recursiva
        exibirArvore(no.esquerda, novoPrefixo, true, ".");
        exibirArvore(no.direita, novoPrefixo, false, "-");
    }

    public static void main(String[] args) {
        ArvoreBinariaCodigoMorse arvore = new ArvoreBinariaCodigoMorse();

        arvore.inserirLetra('A', ".-");
        arvore.inserirLetra('B', "-...");
        arvore.inserirLetra('C', "-.-.");
        arvore.inserirLetra('D', "-..");
        arvore.inserirLetra('E', ".");
        arvore.inserirLetra('F', "..-.");
        arvore.inserirLetra('G', "--.");
        arvore.inserirLetra('H', "....");
        arvore.inserirLetra('I', "..");
        arvore.inserirLetra('J', ".---");
        arvore.inserirLetra('K', "-.-");
        arvore.inserirLetra('L', ".-..");
        arvore.inserirLetra('M', "--");
        arvore.inserirLetra('N', "-.");
        arvore.inserirLetra('O', "---");
        arvore.inserirLetra('P', ".--.");
        arvore.inserirLetra('Q', "--.-");
        arvore.inserirLetra('R', ".-.");
        arvore.inserirLetra('S', "...");
        arvore.inserirLetra('T', "-");
        arvore.inserirLetra('U', "..-");
        arvore.inserirLetra('V', "...-");
        arvore.inserirLetra('W', ".--");
        arvore.inserirLetra('X', "-..-");
        arvore.inserirLetra('Y', "-.--");
        arvore.inserirLetra('Z', "--..");
        arvore.inserirLetra('1', ".----");
        arvore.inserirLetra('2', "..---");
        arvore.inserirLetra('3', "...--");
        arvore.inserirLetra('4', "....-");
        arvore.inserirLetra('5', ".....");
        arvore.inserirLetra('6', "-....");
        arvore.inserirLetra('7', "--...");
        arvore.inserirLetra('8', "---..");
        arvore.inserirLetra('9', "----.");
        arvore.inserirLetra('0', "-----");

        arvore.exibirArvore();

        // Testando a busca
        System.out.println("\nTeste de busca:");
        System.out.println("Código '.-' -> " + arvore.buscarLetra(".-"));   // A
        System.out.println("Código '...' -> " + arvore.buscarLetra("...")); // S
        System.out.println("Código '--...' -> " + arvore.buscarLetra("--...")); // 7
    }
}
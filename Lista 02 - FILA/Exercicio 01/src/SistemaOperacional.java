public class SistemaOperacional {
    /* Sistema Operacional funciona como a implementação de uma fila
     que nesse caso vai criar uma lista de processos*/
    protected int tamanho;    /* Tamanho do vetor */
    protected Processo[] vetor;    /* Vetor de elementos */
    protected int ini;    /* Posicao do proximo elemento a ser retirado */
    protected int n;    /* Numero de elementos na fila */

    public SistemaOperacional(int tam) {
        tamanho = tam;
        vetor = new Processo[tam];
        ini = 0;
        n = 0;
    }

    public boolean vazia() {
        return (n == 0);
    }

    public boolean cheia() {
        return (n == tamanho);
    }

    //Retiramos o elemento do início da fila
    public Processo remove()
    {
        Processo elemento = null;

        if (!this.vazia())
        {
            elemento = vetor[ini];
            ini = (ini + 1) % tamanho;
            n--;
        }

        return elemento;
    }

    //Inserimos o elemento no final da fila
    public boolean insere(Processo elemento)
    {
        int fim;

        if ( !cheia() ) {
            fim = (ini + n) % tamanho;
            vetor[fim] = elemento;
            n++;
            return true;
        }
        else
            return false;
    }

    public void imprime()
    {
        int i, j;

        if (vazia())
            System.out.println("Fila está vazia.");
        else
            for (i = ini, j = 1; j <= n; j = j + 1, i = (i + 1) % tamanho)
                System.out.println(j + " " + vetor[i].getNome());
    }
}
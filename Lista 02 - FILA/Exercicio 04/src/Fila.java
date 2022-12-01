import java.util.Vector;

public class Fila
{
    /* Atributos protected para serem usados na subclasse. */
    protected int tamanho;	/* Tamanho do vetor */
    protected int[] vetor;	/* Vetor de elementos */
    protected int ini;	/* Posicao do proximo elemento a ser retirado */
    protected int n;	/* Numero de elementos na fila */

    public Fila(int tam)
    {
        tamanho = tam;
        vetor = new int[tamanho];
        ini = 0;
        n = 0;
    }

    public boolean vazia()
    {
        return (n == 0);
    }

    public boolean cheia()
    {
        return (n == tamanho);
    }

    //Retiramos o elemento do in�cio da fila
    public int remove()
    {
        int elemento = Integer.MIN_VALUE;

        if (!this.vazia())
        {
            elemento = vetor[ini];
            ini = (ini + 1) % tamanho;
            n--;
        }

        return elemento;
    }

    //Inserimos o elemento no final da fila
    public boolean insere(int elemento)
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

    public static FilaDupla geraFilaDupla(Fila fila){
        Vector vetor = new Vector();

        /* looping necessário para saber o tamanho da fila de entrada e armazenar os elementos num vetor*/
        while (!fila.vazia()){
            vetor.add(fila.remove());
        }

        /* cria uma fila dupla do memsmo tamanho da fila de entrada*/
        FilaDupla filaDupla = new FilaDupla(vetor.size());

        /* repassa todos os valores do vetor para a fila dupla*/
        while (vetor.size() != 0){
            filaDupla.insere((int)vetor.remove(0));
        }
        return filaDupla;
    }
}
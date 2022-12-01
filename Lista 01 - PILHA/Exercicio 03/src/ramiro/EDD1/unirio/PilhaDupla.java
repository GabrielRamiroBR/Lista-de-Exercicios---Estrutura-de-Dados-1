package ramiro.EDD1.unirio;


import java.util.Arrays;

public class PilhaDupla {
    private int n;
    private char vetor[];
    private int topo1, topo2;

    public PilhaDupla()
    {
        n = 10;
        vetor = new char[n];
        topo1 = -1;
        topo2 = 10;
    }


    public boolean vazia1()
    {
        return topo1 == -1 ? true : false;
    }
    public boolean vazia2()
    {
        return topo2 == 10 ? true : false;
    }

    public boolean cheia()
    {
        if (topo1 == topo2 - 1)
            return true;
        else if (topo2 == topo1 + 1)
            return true;
        else
            return false;

    }

    public char pop1()
    {
        char c = '\0';

        if (!this.vazia1())
        {
            c = vetor[topo1];

            //Decrementando o topo, o elemento � "removido da pilha1"
            topo1--;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha vazia: pop não funcionou.");
        }

        return c;
    }
    public char pop2()
    {
        char c = '\0';

        if (!this.vazia2())
        {
            c = vetor[topo2];

            //Acrescentando o topo, o elemento � "removido" da pilha 2"
            topo2++;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha vazia: pop não funcionou.");
        }

        return c;
    }

    public boolean push1(char elemento)
    {
        if (!this.cheia())
        {
            vetor[++topo1] = elemento;
            return true;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Vetor cheio: push não funcionou\n");
            return false;
        }
    }
    public boolean push2(char elemento)
    {
        if (!this.cheia())
        {
            vetor[--topo2] = elemento;
            return true;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Vetor cheio: push não funcionou.\n");
            return false;
        }
    }

    public char retornaTopo1()
    {
        char elemento = '\0';

        if(!this.vazia1())
        {
            elemento = vetor[topo1];
        }
        else
        {
            System.out.println("Pilha vazia.");
        }

        return elemento;
    }
    public char retornaTopo2()
    {
        char elemento = '\0';

        if(!this.vazia2())
        {
            elemento = vetor[topo2];
        }
        else
        {
            System.out.println("Pilha vazia.");
        }

        return elemento;
    }

    public void imprimeVetor(){
        System.out.println("        " + Arrays.toString(vetor));
        System.out.println("    Pilha 1                        Pilha 2");
        System.out.println("Base --> Topo                    Topo <-- Base");
    }
}

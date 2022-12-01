import java.util.Vector;

public class FilaDuplaPreferencial extends Fila
{
    /* Essa fila cria uma lista de String onde cada elemento é a senha da pessoana fila
     * As senhas preferenciais para idosos começam com P eas demais para adultos começam com A */
    public FilaDuplaPreferencial(int tam)
    {
        super(tam);
    }

    public boolean insereInicio(String elemento)
    {
        int prec;

        if (!cheia())
        {
            /* Insere na posi��o precedente ao in�cio */
            prec = (ini - 1 + tamanho) % tamanho;
            vetor[prec] = elemento;
            ini = prec; /* Atualiza �ndice para in�cio */
            n++;
            return true;
        }
        else
            return false;
    }

    public String removeFim()
    {
        String elemento = null;
        int ult;

        if (!this.vazia())
        {
            /* Retira o �ltimo elemento */
            ult = (ini + n - 1) % tamanho;
            elemento = vetor[ult];
            n--;
        }

        return elemento;
    }

    /* implementa inserçao de senha preferencial*/
    public void inserePreferencial(String senha){
        Vector vetorAux = new Vector();

        /* repassa as senhas nao preferenciais para um vetor auxiliar
         até a fila ficar vazia ou até achar uma senha preferencial*/
        while (!vazia()){
            if (this.vetor[((ini + n) % tamanho)-1].charAt(0) != 'P')
                vetorAux.add(removeFim());
            else
                break;
        }

        insere(senha);

        /* insere as senhas não preferenciais na mesma ordem após a inserçao da senha preferencial*/
        for (int i = (vetorAux.size() - 1); i >= 0; i--){
            insere((String) vetorAux.remove(i));
        }

    }
}


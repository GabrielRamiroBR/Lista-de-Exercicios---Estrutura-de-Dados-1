package ramiro.EDD1.unirio;

public class ConvertePosfixada {

    public static int prioridade(char elemento)
    {
        int prioridade;
        switch(elemento)
        {
            case '+':
            case '-':
                prioridade = 1;
                break;

            case '*':
            case '/':
                prioridade = 2;
                break;

            default:
                prioridade = 0;
                break;
        }

        return prioridade;
    }
    public static String converte(String entrada){
        String saida = "";
        PilhaGenerica<Integer> pilha = new PilhaGenerica<Integer>(entrada.length());
        int contador = 0;
        char c;

        while(contador < entrada.length())
        {
            c = entrada.charAt(contador);
            switch(c)
            {
                case '*':
                case '/':
                case '+':
                case '-':
                    while((!pilha.vazia()) && prioridade(c) <= prioridade((char)((int) pilha.retornaTopo())))
                        saida += (char)((int)pilha.pop());

                    pilha.push((int)c);
                    break;

                case '(':
                    pilha.push((int)c);
                    break;

                case ')':
                    while((char)((int)pilha.retornaTopo()) != '(')
                        saida += (char)((int)pilha.pop());

                    if((char)((int)pilha.retornaTopo()) == '(')
                        pilha.pop();
                    break;

                default:
                    saida += entrada.charAt(contador);
                    break;
            }
            contador++;
        }
        while(!pilha.vazia())
            if((char)((int)pilha.retornaTopo()) != '(')
                saida += (char)((int)pilha.pop());
            else
                pilha.pop();

        return saida;
    }

}

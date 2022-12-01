package ramiro.EDD1.unirio;

public class Comparador {

    public static boolean isXcY(String s){

        Pilha pilha1 = new Pilha(s.length());
        Pilha pilha2 = new Pilha(s.length());

        for (int i = 0; i < s.length(); i++){
            pilha1.push(s.charAt(i));
        }

        while(pilha1.retornaTopo() != 'C'&& !pilha1.vazia()){
            pilha2.push(pilha1.pop());
        }

        pilha1.pop();

        while(!pilha1.vazia() || !pilha2.vazia()){
            if (pilha1.retornaTopo() != pilha2.retornaTopo())
                return false;
            else if (pilha1.retornaTopo() != 'A' && pilha1.retornaTopo() != 'B')
                return false;
            else{
                pilha1.pop();
                pilha2.pop();
            }
        }

        return true;

    }
}

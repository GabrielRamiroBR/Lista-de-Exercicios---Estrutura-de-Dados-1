package ramiro.EDD1.unirio;

public class Comparador {

    public static boolean isCadeiaXcY(String s){

        Pilha pilhaMae = new Pilha(s.length());
        Pilha pilhaFilha1 = new Pilha(s.length());
        Pilha pilhaFilha2 = new Pilha(s.length());



        for (int i = 0; i < s.length(); i++){
            pilhaMae.push(s.charAt(i));
        }

        while (!pilhaMae.vazia()){
            while(pilhaMae.retornaTopo() != 'D' && !pilhaMae.vazia()){
                pilhaFilha1.push(pilhaMae.pop());
            }

            pilhaMae.pop();

            while(pilhaFilha1.retornaTopo() != 'C' && !pilhaFilha1.vazia()){
                pilhaFilha2.push(pilhaFilha1.pop());
            }

            pilhaFilha1.pop();

            while(!pilhaFilha1.vazia() || !pilhaFilha2.vazia()){
                if (pilhaFilha1.retornaTopo() != pilhaFilha2.retornaTopo())
                    return false;
                else if (pilhaFilha1.retornaTopo() != 'A' && pilhaFilha1.retornaTopo() != 'B')
                    return false;
                else{
                    pilhaFilha1.pop();
                    pilhaFilha2.pop();
                }
            }
        }
        return true;
    }
}

package ramiro.EDD1.unirio;

public class InversorPalavras {

    public static Pilha invertePalavras(String s){

        Pilha pilha = new Pilha(s.length());
        Pilha pilhaAux = new Pilha(s.length());


        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' ')
                pilhaAux.push(s.charAt(i));
            else{
                while (!pilhaAux.vazia()) {
                    pilha.push(pilhaAux.pop());
                }
                pilha.push(' ');
            }
            if (i == s.length() - 1){
                while (!pilhaAux.vazia()) {
                    pilha.push(pilhaAux.pop());
                }
            }
        }
        return pilha;
    }

}


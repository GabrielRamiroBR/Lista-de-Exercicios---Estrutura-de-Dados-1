package ramiro.EDD1.unirio;

public class Verificador {

    public static boolean verificaBalanceado(String s){
        Pilha pilha= new Pilha(s.length());

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i)  == '[' || s.charAt(i) == '{')
                pilha.push(s.charAt(i));
            else if (s.charAt(i) == ')' && pilha.retornaTopo() == '(' || s.charAt(i) == ']' && pilha.retornaTopo() == '['
                    || s.charAt(i) == '}' && pilha.retornaTopo() == '{'){
                    pilha.pop();
                }
            else
                continue;
            }
        return pilha.vazia() ? true:false;
        }
}

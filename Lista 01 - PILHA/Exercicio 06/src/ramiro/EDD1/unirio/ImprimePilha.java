package ramiro.EDD1.unirio;

public class ImprimePilha {
    public static void imprimePilha(Pilha p, int tam) {

        Pilha pAux = new Pilha(tam);
        while (!p.vazia()) {
            pAux.push(p.pop());
        }
        while (!pAux.vazia()) {
            System.out.printf("%c", pAux.pop());
        }
    }
}

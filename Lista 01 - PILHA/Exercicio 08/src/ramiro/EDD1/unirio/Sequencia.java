package ramiro.EDD1.unirio;

public class Sequencia {
    public static int contaSubsequenciasMaximas(int n){

        int cont = 0;
        PilhaGenerica<Integer> pilha1 = new PilhaGenerica<>(n);
        PilhaGenerica<Integer> pilha2 = new PilhaGenerica<>(n);

        for (int i = 1; i <= n; i++){ pilha1.push(i); }


        while (pilha1.retornaTopo() > 1){ // até só sobrar um par
            pilha2.push(pilha1.pop());
            pilha2.push(pilha1.pop()); // não é necessário verificar pois usando pilha vai ser sempre ser (maximo, segundo máximo)

            cont++;

            pilha1.push(pilha2.pop());
            pilha2.pop();
        }
        return cont;
    }

}

public class Teste {

    public static void main(String[] args) {
        ConjGenerico<Integer> c1 = new ConjGenerico();
        ConjGenerico<Integer> c2 = new ConjGenerico();
        ConjGenerico<Integer> c3= new ConjGenerico();

        c1.insere(1);
        c1.insere(2);
        c1.insere(3);
        c1.insere(4);
        c1.insere(5);

        c2.insere(0);
        c2.insere(1);
        c2.insere(2);



        c3 = c1.diferenca(c2);
        c3.imprime();
    }
}

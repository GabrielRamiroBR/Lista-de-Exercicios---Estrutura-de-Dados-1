import java.text.CompactNumberFormat;

public class Main {

    public static void main(String[] args) throws Exception {
        ConjGenerico<Integer> c1 = new ConjGenerico<>();
        ConjGenerico<Integer> c2 = new ConjGenerico<>();
        ConjGenerico<Integer> universo = new ConjGenerico<>();
        ConjGenerico<Integer> c;

        c1.insere(3);
        c1.insere(4);
        c2.insere(5);
        c2.insere(6);


        universo.insere(0);
        universo.insere(1);
        universo.insere(2);
        universo.insere(3);
        universo.insere(4);
        universo.insere(5);
        universo.insere(6);
        universo.insere(7);
        universo.insere(8);
        universo.insere(9);
        universo.insere(10);


        try {
            c = c1.aplicaDeMorgan(c1, c2, universo);
            c.imprime();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

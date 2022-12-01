public class Main {

    public static void main(String[] args) {
	ConjGenerico<Integer> c1 = new ConjGenerico<>();
    ConjGenerico<Integer> c2 = new ConjGenerico<>();

    c1.insere(1);
    c1.insere(2);
    c1.insere(3);
    c1.insere(4);
    c1.insere(5);

    c2.insere(1);
    c2.insere(2);
    c2.insere(3);
    c2.insere(4);
    c2.insere(5);

        System.out.println(c1.eIgual(c2));

    }
}

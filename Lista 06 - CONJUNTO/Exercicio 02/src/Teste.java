public class Teste {

    public static void main(String[] args) {
	ConjGenerico<Integer> c1 = new ConjGenerico<>();
    ConjGenerico<Integer> c2 = new ConjGenerico<>();

    c1.insere(1);
    c1.insere(2);
    c2.insere(1);
    c2.insere(3);

        System.out.println(c1.eIgual(c2));
    }
}

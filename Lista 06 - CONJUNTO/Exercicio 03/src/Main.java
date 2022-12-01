public class Main {

    public static void main(String[] args) {
        ConjGenerico<Integer> c1 = new ConjGenerico<>();
        ConjGenerico<Integer> complementar;
        ConjGenerico<Integer> universo = new ConjGenerico<>();

        c1.insere(2);
        c1.insere(4);
        c1.insere(6);
        c1.insere(8);
        c1.insere(10);

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
            complementar = c1.complementar(universo);
            complementar.imprime();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

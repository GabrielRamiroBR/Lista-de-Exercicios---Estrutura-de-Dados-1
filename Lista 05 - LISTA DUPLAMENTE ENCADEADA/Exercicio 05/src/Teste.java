public class Teste {

    public static void main(String[] args) {
        ListaDuplamente a = new ListaDuplamente();
        ListaDuplamente b = new ListaDuplamente();

        a.insere(1);
        a.insere(2);
        a.insere(3);

        b.insere(1);
        b.insere(2);
        b.insere(3);

        boolean teste = a.verificaIgualdade(b);
    }
}

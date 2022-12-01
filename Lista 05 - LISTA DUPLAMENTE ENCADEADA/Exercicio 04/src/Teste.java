public class Teste {

    public static void main(String[] args) {
        ListaDuplamente l1 = new ListaDuplamente();

        l1.insere(1);
        l1.insere(2);
        l1.insere(3);
        l1.insere(4);

        l1.imprime();
        l1.trocaElos(0,2);
        l1.imprime();
    }
}

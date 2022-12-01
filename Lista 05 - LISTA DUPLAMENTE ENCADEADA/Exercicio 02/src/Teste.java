public class Teste {

    public static void main(String[] args) {
	ListaCircular a = new ListaCircular();
    ListaCircular b  = new ListaCircular();

    a.insere(1);
    a.insere(2);
    a.insere(3);

    b.insere(7);
    b.insere(8);
    b.insere(9);

    ListaCircular c = a.merge(b);
    }
}

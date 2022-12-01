public class Main {

    public static void main(String[] args) {
	ListaDuplamente a = new ListaDuplamente();
    ListaDuplamente b = new ListaDuplamente();

    a.insere(3);
    a.insere(2);
    a.insere(1);
    a.insere(3);

    b.insere(1);
    b.insere(5);
    b.insere(3);
    b.insere(6);

    a.excluirRepetido(3);
    int t = 1;
    }
}

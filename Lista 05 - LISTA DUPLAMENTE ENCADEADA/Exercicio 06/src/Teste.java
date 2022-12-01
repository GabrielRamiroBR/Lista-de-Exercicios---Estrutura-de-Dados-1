public class Teste {

    public static void main(String[] args) {
	ListaDuplamente l = new ListaDuplamente();

    Chamada a = new Chamada("1", false);
    Chamada b = new Chamada("2", false);
    Chamada c = new Chamada("3", true);
    Chamada d = new Chamada("4", true);
    Chamada e = new Chamada("5", false);

    l.insere(a);
    l.insere(b);
    l.insere(c);
    l.insere(d);
    l.insere(e);
    l.imprime();

    l.remove();
    l.imprime();
    l.remove();
    l.imprime();
    l.remove();
    l.imprime();
    l.remove();
    l.imprime();
    }
}

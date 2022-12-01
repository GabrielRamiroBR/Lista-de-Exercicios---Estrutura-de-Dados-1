public class Teste {

    public static void main(String[] args) {
	FilaDuplaPreferencial fila = new FilaDuplaPreferencial(10);

    fila.insere("A-01");
    fila.insere("A-02");
    fila.inserePreferencial("P-01");
    fila.insere("A-03");
    fila.insere("A-04");
    fila.inserePreferencial("P-02");
    fila.insere("A-05");

    }
}

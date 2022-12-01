

public class Teste {

    public static void main(String[] args) {

        Fila fila = new Fila(6);

        fila.insere(1);
        fila.insere(2);
        fila.insere(3);
        fila.insere(4);
        fila.insere(5);
        fila.insere(6);

        FilaDupla filaDupla;
        filaDupla = Fila.geraFilaDupla(fila);

        System.out.println(filaDupla.remove() + " - " + filaDupla.removeFim());
        System.out.println(filaDupla.remove() + " - " + filaDupla.removeFim());
        System.out.println(filaDupla.remove() + " - " + filaDupla.removeFim());
    }
}

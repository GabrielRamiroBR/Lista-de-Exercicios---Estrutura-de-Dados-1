public class Teste {

    public static void main(String[] args) {
	    Processo processo1 = new Processo("Processo 1");
        Processo processo2 = new Processo("Processo 2");
        Processo processo3 = new Processo("Processo 3");
        Processo processo4 = new Processo("Processo 4");

        SistemaOperacional sistemaOp = new SistemaOperacional(4);

        sistemaOp.insere(processo1);
        sistemaOp.insere(processo2);
        sistemaOp.insere(processo3);
        sistemaOp.insere(processo4);

        sistemaOp.imprime();

        sistemaOp.remove();

        sistemaOp.imprime();
    }
}

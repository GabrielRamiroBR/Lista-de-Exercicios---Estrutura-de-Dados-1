public class Main {

    public static void main(String[] args) {
	Integer[] vetor = {2, 7, 3, 8, 4, 5};

    ArvBinBusca<Integer, Integer> avb = new ArvBinBusca<>();

    avb.constroiArvore(vetor);

    avb.mostra();
    }
}

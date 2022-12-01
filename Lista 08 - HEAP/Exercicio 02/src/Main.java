public class Main {

    public static void main(String[] args) {
	int [] vetMax = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    HeapBinariaMaxima heamMax = new HeapBinariaMaxima(vetMax.length, vetMax);
    HeapBinariaMinima heapMin = new HeapBinariaMinima(heamMax);

    heapMin.imprime();

    }
}

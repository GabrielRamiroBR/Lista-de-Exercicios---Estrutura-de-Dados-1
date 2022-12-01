public class Main {

    public static void main(String[] args) {
        int [] vetMin = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        HeapBinariaMinima heapMin = new HeapBinariaMinima(vetMin.length, vetMin);
        HeapBinariaMaxima heapMax = new HeapBinariaMaxima(heapMin);

        heapMax.imprime();

    }
}

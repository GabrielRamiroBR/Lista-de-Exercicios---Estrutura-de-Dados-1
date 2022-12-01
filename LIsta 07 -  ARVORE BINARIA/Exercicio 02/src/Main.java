public class Main {

    public static void main(String[] args) {
        Arvbin<Integer> a1 = new Arvbin<>(3);
        Arvbin<Integer> a2 = new Arvbin<>(5);
        Arvbin<Integer> a3 = new Arvbin<>(6); // folhas//

        Arvbin<Integer> a4 = new Arvbin<>(2, a1, null);
        Arvbin<Integer> a5 = new Arvbin<>(4, a2, a3);
        Arvbin<Integer> a6 = new Arvbin<>(1, a4, a5); // raiz


        System.out.println(Arvbin.retornaSomaSubArvore(a6));
        System.out.println(Arvbin.retornaSomaSubArvore(a5));

    }
}

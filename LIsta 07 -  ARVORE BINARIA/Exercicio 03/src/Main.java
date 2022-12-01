public class Main {

    public static void main(String[] args) {
        Arvbin <String> a1 = new Arvbin<>("C");
        Arvbin <String> a2 = new Arvbin<>("E");
        Arvbin <String> a3 = new Arvbin<>("F"); // folhas//

        Arvbin <String> a4 = new Arvbin<>("B", a1, null);
        Arvbin <String> a5 = new Arvbin<>("D", a2, a3);
        Arvbin <String> a6 = new Arvbin<>("A", a4, a5); // raiz

        Arvbin <String> a7 = new Arvbin<>("C");
        Arvbin <String> a8 = new Arvbin<>("E");
        Arvbin <String> a9 = new Arvbin<>("F"); // folhas//

        Arvbin <String> a10 = new Arvbin<>("B", a7, null);
        Arvbin <String> a11 = new Arvbin<>("D", a8, a9);
        Arvbin <String> a12 = new Arvbin<>("A", a10, a11); // raiz

        System.out.println(a6.eSimilar(a12));
    }
}
